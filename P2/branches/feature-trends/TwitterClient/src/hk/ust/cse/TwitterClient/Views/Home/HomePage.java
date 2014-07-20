package hk.ust.cse.TwitterClient.Views.Home;

import hk.ust.cse.TwitterClient.Controls.*;
import hk.ust.cse.TwitterClient.Controls.common.ICallBack;
import hk.ust.cse.TwitterClient.Controls.common.getHomeTimelineArguments;
import hk.ust.cse.TwitterClient.Post.PostBox;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;
import hk.ust.cse.TwitterClient.Views.NumberBar;
import hk.ust.cse.TwitterClient.Views.TweetsList;
import hk.ust.cse.TwitterClient.Views.WholePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import twitter4j.Status;
import twitter4j.User;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePage extends RowComposite {

  private static final Logger logger = Logger.getLogger("mutex");

  private static final CachedTwitter cachedTwitter = new CachedTwitter();

  public HomePage(Composite parentView, int width, int minPageHeight, final int miniProfileWidth,
     int miniProfileHeight, int itemListWidth, String nameClkHandler, String numItemClkHandler, Object handlerCallee) {
    this(parentView, 1,width, minPageHeight, miniProfileWidth, miniProfileHeight, itemListWidth, nameClkHandler, numItemClkHandler, handlerCallee);
  }
  public HomePage(Composite parentView, int page, int width, int minPageHeight, final int miniProfileWidth,
      int miniProfileHeight, int itemListWidth, String nameClkHandler, String numItemClkHandler, Object handlerCallee) {
    super(parentView, SWT.CENTER, SWT.HORIZONTAL, false, 25, 50,
        (width - miniProfileWidth - itemListWidth - 20) / 2, 
        (width - miniProfileWidth - itemListWidth - 20) / 2, 20);

    m_user              = cachedTwitter.getAccountUser();
    m_width             = width;
    m_minPageHeight     = minPageHeight;
    m_nameClkHandler    = nameClkHandler;
    m_numItemClkHandler = numItemClkHandler;
    m_handlerCallee     = handlerCallee;
    m_control           = new HomePageControl(this);
    
    initialize(width, miniProfileWidth, miniProfileHeight, 
        itemListWidth, minPageHeight, nameClkHandler, handlerCallee);
    m_tweetPage = page;
    showHomeTimeline();
    
    // a dispose listener is necessary
    addDisposeListener(new DisposeListener() {
      public void widgetDisposed(DisposeEvent e) {
        HomePage.this.widgetDisposed(e);
      }
    });
  }
  
  private void initialize(int width, int miniProfileWidth, int miniProfileHeight, 
      int itemListWidth, int minPageHeight, String nameClkHandler, Object handlerCallee) {
    // set size
    setSize(width, -1);
    
    // set background color
    m_bgColor = Utils.getColorFromString(m_user.getProfileBackgroundColor());
    setBackground(m_bgColor);
    setBackgroundMode(SWT.INHERIT_DEFAULT); // make all labels have transparent backgrounds
    
    // set background image
    m_bgImage = Utils.loadImageFromUrl(m_user.getProfileBackgroundImageURL().toString());
    if (m_bgImage != null) {
        addPaintListener(new PaintListener() {
            public void paintControl(PaintEvent e) {
                if (!HomePage.this.m_user.isProfileBackgroundTiled()) {
                    e.gc.drawImage(HomePage.this.m_bgImage, 0, 0);
                } else {
                    HomePage.this.setBackgroundImage(HomePage.this.m_bgImage);
                }
            }
        });
    }

    // set the left frame for mini-profile
    RowComposite leftFrame = new RowComposite(this, 0, SWT.VERTICAL, true, 0, 0, 0, 0, 0);
    leftFrame.setBackground(Resources.WHITE_COLOR);
    leftFrame.setLayoutData(new RowData(miniProfileWidth, -1));
    
    // set the left mini-profile
    m_miniProfile = new MiniProfile(leftFrame, m_user, miniProfileWidth, miniProfileHeight);
    m_miniProfile.setLayoutData(new RowData(miniProfileWidth, miniProfileHeight));
    Utils.addClickListener(m_miniProfile, m_nameClkHandler, m_handlerCallee);
    
    // set the left number bar
    long[] numbers = new long[] {m_user.getStatusesCount(), 
                                 m_user.getFriendsCount(), 
                                 m_user.getFollowersCount()};
    String[] titles = new String[] {"TWEETS", "FOLLOWING", "FOLLOWERS"};
    m_numberBar = new NumberBar(leftFrame, numbers, titles, miniProfileWidth, 90, 50, 
        Resources.MINI_PROFILE_COLOR, Resources.MINI_PROFILE_COLOR, Resources.MINI_PROFILE_COLOR, 
        Resources.FONT11B, Resources.FONT7, true, m_numItemClkHandler, m_handlerCallee);
    m_numberBar.setLayoutData(new RowData(miniProfileWidth, 50));
    
    /**
     * create a post box for new tweet
     **/
    // set the left post box
    postBoxHeight = 150;
    m_postBox = new PostBox(leftFrame, m_user, miniProfileWidth,postBoxHeight, m_handlerCallee);
    m_postBox.setLayoutData(new RowData(miniProfileWidth, postBoxHeight));
    
    m_trends = new Trends(leftFrame, m_user, miniProfileWidth, miniProfileHeight);
    m_trends.setLayoutData(new RowData(miniProfileWidth, miniProfileHeight));
    
    // set the right frame
    m_rightFrame = new RowComposite(this, 0, SWT.VERTICAL, false, 0, 0, 0, 0, -1);
    m_rightFrame.setLayoutData(new RowData(itemListWidth, -1));
    m_rightFrame.addListener(SWT.Resize, new Listener() {
      @Override
      public void handleEvent(Event arg0) {
        m_rightFrame.setLayoutData(new RowData(m_rightFrame.getBounds().width, 
                                               m_rightFrame.getBounds().height));
        layout();
        pack();
      }
    });
    
    layout(); // trigger re-layout
    pack();
    
    Utils.cutRoundCorner(leftFrame, true, true, true, true);
    Utils.cutRoundCorner(m_miniProfile, true, true, false, false);
    Utils.cutRoundCorner(m_numberBar, false, false, false, false);
    Utils.cutRoundCorner(m_postBox, false, false, true, true);//for postBox
  }

  public void refreshHomeTimeline(boolean isCache){
      cachedTwitter.getHomeTimeline(new getHomeTimelineArguments(m_tweetPage, gotHomeTimeLineCallBack, isCache));
  }
  private void showHomeTimeline() {
    // remove the old list view
    Utils.dispose(m_itemList);
    
    layout();
    pack();

    // we need to guarantee a minimal page height
    if (getBounds().height < m_minPageHeight) {
      setSize(m_width, m_minPageHeight);
    }
    
    // retrieve the list asynchronously

      cachedTwitter.getHomeTimeline(new getHomeTimelineArguments(m_tweetPage, gotHomeTimeLineCallBack, true));
  }
  
  public void tweetsListBackClicked(MouseEvent arg) {
    if (m_tweetPage > 1) {
      m_tweetPage -= 1;
        cachedTwitter.getHomeTimeline(new getHomeTimelineArguments(m_tweetPage, gotHomeTimeLineCallBack, true));
    }
  }
  
  public void tweetsListNextClicked(MouseEvent arg) {
    m_tweetPage += 1;
      cachedTwitter.getHomeTimeline(new getHomeTimelineArguments(m_tweetPage, gotHomeTimeLineCallBack, true));
  }

  public void showTweetsList(List<Status> tweets) {
      logger.log(Level.INFO, "HomePage showTweetsList");
      try {

          if (isDisposed()) {

              MutexManager.set("Global", MutexOperation.RELEASE);
              logger.log(Level.INFO,"release Global Mutex");

              ((WholePage) m_handlerCallee).gotoHomePage(m_tweetPage);
              return;
          }
          // remove the old list view
          Utils.dispose(m_itemList);
          layout();

          m_itemList = new TweetsList(m_rightFrame, tweets,
                  m_rightFrame.getBounds().width, m_nameClkHandler, m_handlerCallee,
                  "tweetsListBackClicked", this, "tweetsListNextClicked", this);
          m_itemList.addListener(SWT.Resize, new Listener() {
              @Override
              public void handleEvent(Event arg0) {
                  m_itemList.setLayoutData(new RowData(m_itemList.getBounds().width,
                          m_itemList.getBounds().height));
                  m_rightFrame.layout();
                  m_rightFrame.pack();
              }
          });
          m_rightFrame.layout();
          m_rightFrame.pack();
          // we need to guarantee a minimal page height
          if (getBounds().height < m_minPageHeight) {
              setSize(m_width, m_minPageHeight);
          }

      } catch (Exception ex) {
          ex.printStackTrace();
      }

      MutexManager.set("Global", MutexOperation.RELEASE);
      logger.log(Level.INFO, "release Global Mutex");

  }

    private ICallBack gotHomeTimeLineCallBack = new ICallBack<List<Status>>() {
        @Override
        public void gotResult(final List<Status> statuses) {
           if(statuses!=null)
                WholePage.firstTweet = statuses.get(0);
              showTweetsList(statuses);
        }
    };

  private void widgetDisposed(DisposeEvent e) {
    // dispose created colors
    Utils.dispose(m_bgColor);

    // dispose loaded images
    Utils.dispose(m_bgImage);
  }

  private MiniProfile  	m_miniProfile;
  private Trends  	m_trends;
  private NumberBar    	m_numberBar;
  private TweetsList   	m_itemList;
  private RowComposite 	m_rightFrame;
  private PostBox		m_postBox; //for postBox

  // the currently showing list
  private int m_tweetPage;
  
  // resources that need to be disposed
  private Color m_bgColor;
  private Image m_bgImage;
  
  private final User            m_user;
  private final int             m_width;
  private final int             m_minPageHeight;
  private final String          m_nameClkHandler;
  private final String          m_numItemClkHandler;
  //private final String          m_postClkHandler; //for postBox
  private final Object          m_handlerCallee;
  private final HomePageControl m_control;
  
  private int 			postBoxHeight; //for postBox
  
}
