package hk.ust.cse.TwitterClient.Views.Search;

import hk.ust.cse.TwitterClient.Controls.Mutex;
import hk.ust.cse.TwitterClient.Controls.SearchPageControl;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;
import hk.ust.cse.TwitterClient.Views.TweetsList;
import hk.ust.cse.TwitterClient.Views.WholePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import twitter4j.Status;
import twitter4j.User;

import java.util.List;

public class SearchPage extends RowComposite {

    public SearchPage(Composite parentView, String tag, int width, int menuWidth, int menuHeight, int minPageHeight, final int miniProfileWidth,
                    int miniProfileHeight, int itemListWidth, String nameClkHandler, String numItemClkHandler, Object handlerCallee) {
        super(parentView, SWT.CENTER, SWT.HORIZONTAL, false, 25, 50,
                (width - miniProfileWidth - itemListWidth - 20) / 2,
                (width - miniProfileWidth - itemListWidth - 20) / 2, 20);

        m_user              = TwitterControl.getAccountUser();
        m_width             = width;
        m_minPageHeight     = minPageHeight;
        m_nameClkHandler    = nameClkHandler;
        m_numItemClkHandler = numItemClkHandler;
        m_handlerCallee     = handlerCallee;
        m_control           = new SearchPageControl(this);
        m_tag = tag;

        initialize(width, menuWidth, menuHeight, miniProfileWidth, miniProfileHeight,
                itemListWidth, minPageHeight, nameClkHandler, handlerCallee);

        showSearchTimeLine(m_tag);

        // a dispose listener is necessary
        addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                SearchPage.this.widgetDisposed(e);
            }
        });
    }

    private void initialize(int width, int menuWidth, int menuHeight, int miniProfileWidth, int miniProfileHeight,
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
            setBackgroundImage(m_bgImage);
        }

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

    }

    public void updateSearchTimeLine(String tag, int page){
        m_tweetPage = page;
        showSearchTimeLine(tag);
    }

    private void showSearchTimeLine(String tag){
        // remove the old list view
        Utils.dispose(m_itemList);

        layout();
        pack();

        // we need to guarantee a minimal page height
        if (getBounds().height < m_minPageHeight) {
            setSize(m_width, m_minPageHeight);
        }

        // retrieve the list asynchronously
        m_tweetPage = 1;
        m_tweetPerPage = 10;
        m_tag = tag;
        TwitterControl.getSearch(m_tag,"getSearchListCallBack", m_control);
    }

    public void onMenuItemClicked(MouseEvent arg) {

    }

    public void tweetsListBackClicked(MouseEvent arg) {
        if (m_tweetPage > 1) {
            m_tweetPage -= 1;
            showTweetsList(m_tweets);
        }
    }

    public void tweetsListNextClicked(MouseEvent arg) {
        m_tweetPage += 1;
        showTweetsList(m_tweets);
    }

    public void showTweetsList(List<Status> tweets) {
        System.out.println("SearchPage showTweetsList");
        try{
            if(tweets == null) return;
            if(isDisposed()){
                Mutex.releaseSearchPageMutex();
                System.out.println("releaseSearchPageMutex because SearchPage is disposed.");

                ((WholePage)m_handlerCallee).gotoHomePage();
                return;
            }

            //code for paging
            m_tweets = tweets;
            int startIndex = (m_tweetPage-1) * m_tweetPerPage;
            int maxIndex = startIndex + m_tweetPerPage;

             if(startIndex < 0){
                 System.out.println("SearchPage: no previous page.");
                 m_tweetPage+=1;
             }
             else if( maxIndex > m_tweets.size()){
                 System.out.println("SearchPage: no next page.");
                 m_tweetPage-=1;
             }else{

                // remove the old list view
                Utils.dispose(m_itemList);
                layout();

                //extract current page's tweets
                List<Status> showTweets = m_tweets.subList(startIndex, maxIndex);

                m_itemList = new TweetsList(m_rightFrame,  showTweets,
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
             }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        Mutex.releaseSearchPageMutex();
        System.out.println("releaseSearchPageMutex");

    }
    public String getTag(){
        return  m_tag;
    }
    public int getPage(){
        return m_tweetPage;
    }

    private void widgetDisposed(DisposeEvent e) {
        // dispose created colors
        Utils.dispose(m_bgColor);

        // dispose loaded images
        Utils.dispose(m_bgImage);
    }

    private TweetsList   m_itemList;
    private RowComposite m_rightFrame;

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
    private final Object          m_handlerCallee;
    private final SearchPageControl m_control;

    private String          m_tag;
    private List<Status> m_tweets;
    private int m_tweetPerPage;
}
