package hk.ust.cse.TwitterClient.Views;

import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Controls.TweetViewControl;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.ITextFeature;
import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.TweetFeatureFactory;
import hk.ust.cse.TwitterClient.StyleTweet.core.*;
import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Views.Basic.HoverClickableComposite;
import hk.ust.cse.TwitterClient.Views.Basic.LinkLabel;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;
import hk.ust.cse.TwitterClient.Views.Home.RepliesList;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import twitter4j.Status;
import twitter4j.URLEntity;
import twitter4j.User;

import java.text.SimpleDateFormat;
import twitter4j.*;
import java.util.List;

public class TweetView extends RowComposite {
  
  public TweetView(Composite parentView, Status tweet, int width, boolean bigIcon, 
      Color origColor, Color hoverColor, Color clickedColor, String nameClkHandler, Object handlerCallee) {
    super(parentView, SWT.CENTER, SWT.VERTICAL, false, 0, 0, 0, 0, 0);

    m_tweet   = tweet;              // timeline status
    m_user    = tweet.getUser();    // retweet status user
    m_control = new TweetViewControl(this);
      if(tweet == null) {
          throw new RuntimeException("Status Object can not be null");
      }else if(tweet.getUser() == null || TwitterControl.getAccountUser() == null) {
          throw new RuntimeException("Status Object can not be null");
      }

      m_linkedStatus = tweet.getRetweetedStatus() != null? tweet.getRetweetedStatus(): tweet;           // retweeted status
      m_linkedUser = tweet.getRetweetedStatus() != null ?tweet.getRetweetedStatus().getUser(): m_user;  // retweeted status user
    m_nameClkHandler = nameClkHandler;
    m_handlerCallee  = handlerCallee;
    
    initialize(width, bigIcon, origColor, hoverColor, clickedColor);
    
    // a dispose listener is necessary
    addDisposeListener(new DisposeListener() {
      public void widgetDisposed(DisposeEvent e) {
        TweetView.this.widgetDisposed(e);
      }
    });
  }
  
  private void initialize(int width, boolean bigIcon, Color origColor, Color hoverColor, Color clickedColor) {
    // set size
    setSize(width, -1);
    
    // set background color
    setBackground(Resources.WHITE_COLOR);
    setBackgroundMode(SWT.INHERIT_DEFAULT); // make all labels have transparent backgrounds
    
    // set layout of the view
    if (m_handlerCallee != null)
    	m_upperFrame = new HoverClickableComposite(this, origColor, hoverColor, clickedColor);
    else
    	m_upperFrame = new HoverClickableComposite(this, origColor, origColor, origColor);
    
    RowLayout upperFrameLayout = new RowLayout(SWT.HORIZONTAL);
    upperFrameLayout.center       = false;
    upperFrameLayout.marginTop    = 12;
    upperFrameLayout.marginBottom = 12;
    upperFrameLayout.marginLeft   = 12;
    upperFrameLayout.marginRight  = 12;
    upperFrameLayout.spacing      = 5;
    m_upperFrame.setLayout(upperFrameLayout);
    m_upperFrame.setLayoutData(new RowData(width, -1));
    
    // set the icon frame
    m_iconFrame = new RowComposite(m_upperFrame, 0, SWT.HORIZONTAL, false, 0, 0, 0, 0, -1);
    m_iconFrame.setLayoutData(new RowData(48, -1));
    
    // set profile icon
    int iconSize = bigIcon ? 48 : 32;
    m_iconImage = new Label(m_iconFrame, SWT.RIGHT);
    if (m_user.getProfileImageURL() != null) {
      Image m_icon = Utils.loadImageFromUrlAndScale(m_linkedUser.getProfileImageURL(), iconSize, iconSize);
      if (m_icon != null) {
        m_iconImage.setImage(m_icon);
      }
    }
    m_iconImage.setLayoutData(new RowData(48, iconSize));
    
    if (m_handlerCallee!=null)
        Utils.addClickListener(m_iconImage, m_nameClkHandler, m_handlerCallee);
    
    // set the right frame
    m_rightFrame = new RowComposite(m_upperFrame, 0, SWT.VERTICAL, false, 0, 0, 5, 5, 3);
    m_rightFrame.setLayoutData(new RowData(getBounds().width - 77, -1));

    // set the right upper frame
    m_rightUpFrame = new RowComposite(m_rightFrame, 0, SWT.HORIZONTAL, false, 0, 0, 0, 0, 0);
    m_rightUpFrame.setLayoutData(new RowData(getBounds().width - 87, -1));
    
    // set the name frame
    RowComposite nameFrame = new RowComposite(m_rightUpFrame, 0, SWT.HORIZONTAL, false, 0, 0, 0, 0, 5);
    nameFrame.setLayoutData(new RowData(getBounds().width - 137, -1));
    
    // set the time frame
    m_timeFrame = new RowComposite(m_rightUpFrame, 0, SWT.None, false, 0, 0, 0, 0, -1);
    m_timeFrame.setLayoutData(new RowData(50, -1));
    
    // set name, screen name and time
    if (m_handlerCallee!=null)
        m_name = new LinkLabel(nameFrame, 0,
                 Resources.TEXT_COLOR, Resources.LINK_COLOR, Resources.FONT11B, Resources.FONT11B);
    else
        m_name = new LinkLabel(nameFrame, 0,
                 Resources.TEXT_COLOR, Resources.TEXT_COLOR, Resources.FONT11B, Resources.FONT11B);


    m_name.setText(m_linkedUser.getName());
    if (m_handlerCallee!=null)
        Utils.addClickListener(m_name, m_nameClkHandler, m_handlerCallee);
    
    m_screenName = new Label(nameFrame, 0);
    m_screenName.setFont(Resources.FONT10);
    m_screenName.setForeground(Resources.GRAY_COLOR);
    m_screenName.setText("@" + m_linkedUser.getScreenName());

    // calculate and set time
    m_time = new Label(m_timeFrame, SWT.RIGHT);
    m_time.setFont(Resources.FONT9);
    m_time.setForeground(Resources.GRAY_COLOR);
    m_time.setText(createTimeString(m_tweet.getCreatedAt()));
    m_time.setLayoutData(new RowData(50, -1));
   
    // set text

    try{

      // init view and controller
      IView view = new StyleTweetView(m_rightUpFrame,this);
      IController controller = new StyleTweetController(view);

      // set view text
      controller.setText(m_tweet.getText()+setRetweetText());

      // use a factory to create the feature object
      TweetFeatureFactory factory = new TweetFeatureFactory(m_tweet, m_handlerCallee);

      ITextFeature linkFeature = factory.Create("Link");
      ITextFeature mentionsFeature = factory.Create("Mentions");
      controller.AddFeature(linkFeature);
      controller.AddFeature(mentionsFeature);

      // bind different feature's clicked callback to the listener
      if (m_handlerCallee!=null){
      IStyleTweetMouseListener listener = new StyleTweetMouseListener(this);
      listener.AddClickedHandler(linkFeature);
      listener.AddClickedHandler(mentionsFeature);

      controller.AddListener(SWT.MouseMove, listener);
      controller.AddListener(SWT.MouseUp, listener);
      controller.AddListener(SWT.MouseDown, listener);
      }
      
      // invoke this important command call which execute the changing process with the above settings.
      controller.ApplyChange();
      }catch (Exception e){
          e.printStackTrace();
      }
    
    if (m_handlerCallee!=null){
        Utils.addClickListener(m_upperFrame, "toggleExpand", this);
    	setLowerFrame();
    }
    
    layout(); // trigger re-layout
    pack(); // force re-size of height, the width should not be changed
    
//    // cut corner only after layout()
//    Utils.cutRoundCorner(m_iconImage, true, true, true, true);
  }

    private String setRetweetText() {
        String retweetText = "";
        if(m_tweet.getCurrentUserRetweetId() != -1){  // Retweeted by current user
            retweetText = "\n\nRetweeted by you";
        }
        else if(m_tweet.getRetweetedStatus()!=null){  // Retweeted by other user
            retweetText = "\n\nRetweeted by " + m_tweet.getUser().getName();
            m_tweet.getRetweetedStatus();
        }
        return retweetText;
    }


    private void setLowerFrame() {
        m_statusLowerFrame = new RowComposite(m_rightFrame, 0, SWT.LEFT, false, 0, 0, 0, 0, -1);
        m_statusLowerFrame.setLayoutData(new RowData(155, 21));

        // Add Reply button
        m_statusReplyLabel = new Label(m_statusLowerFrame, SWT.LEFT);
        m_statusReplyIcon = Utils.loadImageFromLocal(Resources.class, "./status_cell_reply_hover_icon.png");
        m_statusReplyLabel.setImage(m_statusReplyIcon);
        m_statusReplyLabel.setLayoutData(new RowData(34, 21));

        // Add Retweet button
        if(m_tweet.getUser().getId() != TwitterControl.getAccountUser().getId() || m_tweet.isRetweetedByMe()) {
            m_statusRetweetLabel = new Label(m_statusLowerFrame, SWT.LEFT);
            m_statusRetweetIcon = Utils.loadImageFromLocal(Resources.class, "./status_cell_retweet_hover_icon.png");
            m_statusRetweetedIcon = Utils.loadImageFromLocal(Resources.class, "./status_cell_retweets_selected.png");
            //m_statusRetweetLabel.setImage(RetweetControl.isRetweetedByMe(m_tweet) ? m_statusRetweetedIcon : m_statusRetweetIcon);
            m_statusRetweetLabel.setImage(m_statusRetweetIcon);
            m_statusRetweetLabel.setLayoutData(new RowData(34, 21));
            Utils.addClickListener(m_statusRetweetLabel, m_statusRetweetClkHandler, m_handlerCallee);
        }

        // Add Favourite Button
        m_statusFavoriteLabel = new Label(m_statusLowerFrame, SWT.LEFT);
        m_statusFavoriteIcon = Utils.loadImageFromLocal(Resources.class, "./status_cell_favorite_hover_icon.png");
        m_statusFavoritedIcon = Utils.loadImageFromLocal(Resources.class, "./status_cell_favorited_icon.png");
        m_statusFavoriteLabel.setImage(m_linkedStatus.isFavorited()? m_statusFavoritedIcon : m_statusFavoriteIcon);
        m_statusFavoriteLabel.setLayoutData(new RowData(34, 21));
        Utils.addClickListener(m_statusFavoriteLabel, m_statusFavoriteClkHandler, m_handlerCallee);
    }

    private String getDisplayText(Status tweet) {
    String text = tweet.getText();
    URLEntity[] urlEntities = tweet.getURLEntities();
    for (URLEntity urlEntity : urlEntities) {
      text = text.replace(urlEntity.getURL(), urlEntity.getDisplayURL());
    }
    return text;
  }
  
    public void toggleExpand(MouseEvent arg) {
        expand();
    }


    protected void expand() {
        if (!isExpanded) { // currently collapsed
            // we cannot expend here, as we need to wait for replies asynchronously
            isExpanded = !isExpanded;
            if(m_numberBar == null) TwitterControl.getReplies(m_tweet, "getRepliesCallback", m_control);

        }
        else if (m_numberBar != null) {
            Utils.dispose(m_extendFrame);
            Utils.dispose(m_repliesFrame);
            m_numberBar    = null;
            m_detailTime   = null;
            m_repliesView  = null;
            m_extendFrame  = null;
            m_repliesFrame = null;
            m_upperFrame.setNotClicked();

            layout();
            pack();

            isExpanded = !isExpanded;
        }
  }
  
  public void showReplies(List<Status> replies) {
    m_extendFrame = new RowComposite(m_rightFrame, 0, SWT.VERTICAL, false, 5, 0, 0, 0, 10);
    m_extendFrame.setLayoutData(new RowData(m_rightFrame.getBounds().width, -1));

    long[] numbers = new long[] {m_tweet.getRetweetCount(), replies.size()};
    String[] titles = {"RETWEETS", "REPLIES"};
    if (TweetView.this.getParent() instanceof RepliesList) {
      m_numberBar = new NumberBar(m_extendFrame, numbers, titles, 
          m_rightFrame.getBounds().width, 90, 48, Resources.HOVER_COLOR, Resources.HOVER_COLOR, 
          Resources.HOVER_COLOR, Resources.FONT11B, Resources.FONT8, true, null, null);
    }
    else {
      m_numberBar = new NumberBar(m_extendFrame, numbers, titles, 
          m_rightFrame.getBounds().width, 90, 48, Resources.WHITE_COLOR, Resources.HOVER_COLOR, 
          Resources.WHITE_COLOR, Resources.FONT11B, Resources.FONT8, true, null, null);
    }
    
    m_detailTime = new Label(m_extendFrame, SWT.LEFT);
    m_detailTime.setFont(Resources.FONT9);
    m_detailTime.setForeground(Resources.GRAY_COLOR);
    m_detailTime.setText("    " + createDetailTimeString(m_tweet.getCreatedAt()));

    if (!(TweetView.this.getParent() instanceof RepliesList) && replies.size() > 0) {
      m_repliesFrame = new RowComposite(TweetView.this, 0, SWT.VERTICAL, false, 1, 0, 0, 0, 1);
      m_repliesFrame.setBackground(Resources.SPLIT_COLOR);
      m_repliesFrame.setLayoutData(new RowData(getBounds().width, -1));
      m_repliesFrame.addListener(SWT.Resize, new Listener() {
        @Override
        public void handleEvent(Event arg0) {
          m_repliesFrame.setLayoutData(new RowData(m_repliesFrame.getBounds().width, 
                                                   m_repliesFrame.getBounds().height));
          layout();
          pack();
        }
      });
      
      m_repliesView = new RepliesList(m_repliesFrame, 
          replies, getBounds().width, m_nameClkHandler, m_handlerCallee);
      m_repliesView.addListener(SWT.Resize, new Listener() {
        @Override
        public void handleEvent(Event arg0) {
          m_repliesView.setLayoutData(new RowData(m_repliesView.getBounds().width, 
                                                  m_repliesView.getBounds().height));
          m_repliesFrame.layout();
          m_repliesFrame.pack();
        }
      });
    }
    
    m_upperFrame.setClicked();
    
    layout();
    pack();
  }
  
  private String createTimeString(Date time) {
    long difference = (System.currentTimeMillis() - time.getTime()) / 1000;
    
    String str = null;
    if (difference < 60) {
      str = difference + "s";
    }
    else if (difference >= 60 && difference < 3600 /* an hour */) {
      str = (difference / 60) + "m";
    }
    else if (difference >= 3600 && difference < 86400 /* a day */) {
      str = (difference / 3600) + "h";
    }
    else {
      str = new SimpleDateFormat("dd MMM").format(time);
    }
    return str;
  }
  
  private String createDetailTimeString(Date time) {
    return new SimpleDateFormat("h:mm a - d MMM yy").format(time);
  }
  
  private void widgetDisposed(DisposeEvent e) {
    // dispose loaded images
    Utils.dispose(m_icon);
  }
  
  public Status getTweet() {
    return m_tweet;
  }

    public Status getRetweetedStatus() {
        return m_linkedStatus;
    }

    public User getRetweetedUser() {
        return m_linkedUser;
    }

  private Label        m_iconImage;
  private LinkLabel    m_name;
  private Label        m_screenName;
  private Label        m_time;
  private Label        m_text;
  private HoverClickableComposite m_upperFrame;
  private RowComposite m_rightFrame;
  private RowComposite m_iconFrame;
    private RowComposite m_rightUpFrame;
    private RowComposite m_timeFrame;
  
  private RowComposite m_extendFrame;
  private RowComposite m_repliesFrame;
  private NumberBar    m_numberBar;
  private Label        m_detailTime;
  private RepliesList  m_repliesView;

  private String m_nameClkHandler;
  private Object m_handlerCallee;

    private Image m_statusFavoriteIcon;
    private Image m_statusFavoritedIcon;
    private Label m_statusFavoriteLabel;
    private RowComposite m_statusLowerFrame;
    private static final String m_statusFavoriteClkHandler = "onFavIconClicked";

    private Image m_statusRetweetIcon;
    private Image m_statusRetweetedIcon;
    private Label m_statusRetweetLabel;
    private static final String m_statusRetweetClkHandler = "onRetweetIconClicked";

    private Image m_statusReplyIcon;
    private Label m_statusReplyLabel;
    private static final String m_statusReplyClkHandler = "";

    private RowComposite m_statusFavoriteViolatorFrame;
    private Image m_statusFavoriteViolatorIcon;

  // resources that need to be disposed
  private Image m_icon;
  
  private final Status           m_tweet;
    private final Status m_linkedStatus;
  private final User             m_user;
    private final User m_linkedUser;
  private final TweetViewControl m_control;
    protected boolean isExpanded = false;
}

