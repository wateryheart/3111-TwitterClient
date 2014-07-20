package hk.ust.cse.TwitterClient.Views;

import hk.ust.cse.TwitterClient.Controls.DeleteTweetControl;
import hk.ust.cse.TwitterClient.Controls.FavoriteControl;
import hk.ust.cse.TwitterClient.Controls.RetweetControl;
import hk.ust.cse.TwitterClient.Post.reply;
import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;

import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;
import hk.ust.cse.TwitterClient.Views.Home.HomePage;
import hk.ust.cse.TwitterClient.Views.Home.MiniProfile;
import hk.ust.cse.TwitterClient.Views.Search.SearchPage;
import hk.ust.cse.TwitterClient.Views.User.FriendView;
import hk.ust.cse.TwitterClient.Views.User.MiniPage;
import hk.ust.cse.TwitterClient.Views.User.UserPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.User;

public class WholePage extends RowComposite {

  public WholePage(Composite parentView, int width, int height) throws TwitterException {
    super(parentView, SWT.CENTER, SWT.VERTICAL, false, 0, 0, 0, 0, 0);
    
    m_width  = width;
    m_height = height;

    initialize(width, height);

    gotoHomePage();
    
    // a dispose listener is necessary
    addDisposeListener(new DisposeListener() {
      public void widgetDisposed(DisposeEvent e) {
        WholePage.this.widgetDisposed(e);
      }
    });
  }

  private void initialize(int width, int height) throws TwitterException {
    // set size
    setSize(width, height);
    
    // the upper control bar
    m_ctrlBar = new ControlBar(this, width, 40, 200, "onCtrlBtnClicked", "onEnterPressed", this);
    m_ctrlBar.setLayoutData(new RowData(width, 40));
    
    layout(); // trigger re-layout
    pack(); // re-size
  }
  
  private void widgetDisposed(DisposeEvent e) {
  }
  
  public void onCtrlBtnClicked(MouseEvent arg) throws TwitterException {
    Control control = (Control) arg.getSource();
    while (!(control instanceof ControlBarItem)) {
      control = control.getParent();
    }
    if (control != null) {
      String title = ((ControlBarItem) control).getTitle();
      if (title.equals("Home")) {
        gotoHomePage();
      }
      else if (title.equals("Me")) {
        User user = TwitterControl.getAccountUser();
        if (user != null) {
          gotoUserPage(user);
        }
      }
      else if (title.equals("Go to people")) {
        String screenName = m_ctrlBar.getGotoPeopleName();
        if (screenName.length() > 0) {
          User user = TwitterControl.getUser(screenName); // find user
          if (user != null) {
            gotoUserPage(user);
          }
        }
      }
    }
  }

    public void onEnterPressed(KeyEvent arg) throws TwitterException {

        Object source = arg.getSource();
        if (source instanceof Text) {
            Text textbox = (Text) source;
            String searchText = textbox.getText();
            System.out.println("search: " + searchText);

            if (searchText != null || searchText.length() > 1) {
                String targetText = searchText.substring(1, searchText.length());

                //search user
                if (searchText.startsWith("@")) {
                    if (targetText.length() > 0) {
                        // find user
                        targetText = searchText.substring(1, searchText.length());
                        User user = TwitterControl.getUser(targetText);

                        if (user != null) {
                            gotoUserPage(user);
                            m_ctrlBar.flushPeopleName();
                        } else {
                            m_ctrlBar.flushPeopleName();
                            Shell notification = new Shell(getShell());

                            notification.setText("COMP3111 Project: Twitter Client");
                            notification.setSize(300, 100);
                            notification.setLocation(500, 300);

                            Label text = new Label(notification, SWT.CENTER);
                            text.setSize(300, 100);
                            text.setFont(Resources.FONT11B);
                            text.setLocation(0, 0);
                            text.setText("\nNo existing user! Please retry");
                            notification.open();
                            notification.addDisposeListener(new DisposeListener() {
                                public void widgetDisposed(DisposeEvent e) {
                                }
                            });
                        }
                    }
                    //search tags
                } else if (searchText.startsWith("#")) {
                    gotoSearchPage(targetText);
                } else {
                    gotoSearchPage(searchText);
                }
            }

        }

        System.out.println("onEnterPressed");

    }

  public void onNumberItemClicked(MouseEvent arg) throws TwitterException {
    Control control = (Control) arg.getSource();
    while (!(control instanceof NumberBarItem)) {
      control = control.getParent();
    }
    if (control != null) {
      gotoUserPage(TwitterControl.getAccountUser(), ((NumberBarItem) control).getTitle());
    }
  }
  
  public void onNameLinkClicked(MouseEvent arg) throws TwitterException {
    Control control = (Control) arg.getSource();
    while (!(control instanceof TweetView) && 
           !(control instanceof FriendView) && 
           !(control instanceof MiniProfile)) {
      control = control.getParent();
    }
    if (control instanceof TweetView) {
      User user = ((TweetView) control).getRetweetedUser();
      gotoMiniUserPage(user);
    }
    else if (control instanceof FriendView) {
    	//go to mini user page(new shell) instead of user page
    	gotoMiniUserPage(((FriendView) control).getFriend());
    }
    else if (control instanceof MiniProfile) {
      gotoUserPage(TwitterControl.getAccountUser());
    }
  }

    public void onFavIconClicked (MouseEvent e) throws TwitterException {
        Control control = (Control) e.getSource();
        while (!(control instanceof TweetView)) {
            control = control.getParent();
        }
        if (control instanceof TweetView) {
            Status tweet = ((TweetView) control).getRetweetedStatus();
            while (!(control instanceof HomePage) &&
                    !(control instanceof UserPage) &&
                    !(control instanceof SearchPage)) {
                control = control.getParent();
            }
            if (control instanceof HomePage) {
                FavoriteControl.favoriteHandler(tweet);
                TwitterControl.updateTwitter();
                gotoHomePage();
            }else if (control instanceof UserPage) {
                FavoriteControl.favoriteHandler(tweet);
                TwitterControl.updateTwitter();
                gotoUserPage(((UserPage) control).getUser());
            }else if( control instanceof SearchPage){
                FavoriteControl.favoriteHandler(tweet);
                gotoSearchPage(m_searchPage.getTag(),m_searchPage.getPage());
            }
        }
    }

public void onRetweetIconClicked (MouseEvent e) throws TwitterException {
        Control control = (Control) e.getSource();
        while (!(control instanceof TweetView) &&
                !(control instanceof FriendView) &&
                !(control instanceof MiniProfile)) {
            control = control.getParent();
        }
        if (control instanceof TweetView) {
            Status tweet = ((TweetView) control).getTweet();
            while (!(control instanceof HomePage) &&
                    !(control instanceof UserPage) &&
                    !(control instanceof SearchPage)) {
                control = control.getParent();
            }
            if (control instanceof HomePage) {
                RetweetControl.retweetTimeLineHandler(tweet);
                TwitterControl.updateTwitter();
                try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                gotoHomePage();
            }else if (control instanceof UserPage) {
                RetweetControl.retweetHandler(tweet);
                TwitterControl.updateTwitter();
                try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                gotoUserPage(((UserPage) control).getUser());
            }else if( control instanceof SearchPage){
                RetweetControl.retweetHandler(tweet);
                gotoSearchPage(m_searchPage.getTag(), m_searchPage.getPage());
            }
        }
    }
    
    public void onDeleteIconClicked (MouseEvent e) throws TwitterException {
        Control control = (Control) e.getSource();
        while (!(control instanceof TweetView)) {
            control = control.getParent();
        }
        if (control !=null) {
            Status tweet = ((TweetView) control).getRetweetedStatus();

            MessageBox messageBox = new MessageBox(getShell(), SWT.YES | SWT.NO );          
            messageBox.setText("Warning");
            messageBox.setMessage("Are you sure you want to delete this tweeet?");
            int buttonID = messageBox.open();
            switch(buttonID) {
                 case SWT.YES:
                      // delete tweet
                	 DeleteTweetControl.deleteTweetHandler(tweet);
                	 TwitterControl.updateTwitter();
                  
                     while (!(control instanceof HomePage) &&
                             !(control instanceof UserPage)) {
                         control = control.getParent();
                     }
                     if(control instanceof HomePage){ 
                    	 gotoHomePage();
                    	 return;
                     }
                     else if(control instanceof UserPage){
                    	 gotoUserPage(((UserPage) control).getUser());
                    	 return;
                     }
                 case SWT.NO:
                  	  // does nothing ...
                     return;
                            }
                
        }

        
    }
    
    // Clicking 'go to full profile' on mini user page

    public void onMiniUserPageLinkClicked(User user) throws TwitterException {
        gotoUserPage(user);
    }
  public void gotoHomePage() throws TwitterException {
	  
	  	if(m_miniPage!=null)
	  		Utils.dispose(m_miniPage);
    // dispose old pages first
    Utils.dispose(m_homePage);
    Utils.dispose(m_userPage);
    Utils.dispose(m_searchPage);
    layout();

    // display new home page
    m_homePage = new HomePage(this, m_width, 
        m_height - 40, 300, 56, 520, "onNameLinkClicked", "onNumberItemClicked", this);
    m_homePage.setLayoutData(new RowData(m_width, m_homePage.getBounds().height));
    m_homePage.addListener(SWT.Resize, new Listener() {
      @Override
      public void handleEvent(Event arg0) {
        m_homePage.setLayoutData(new RowData(m_width, m_homePage.getBounds().height));
        layout();
        pack();
      }
    });
    
    layout(); // trigger re-layout
    pack(); // re-size
  }

  public void gotoUserPage(User user) throws TwitterException {
    gotoUserPage(user, "TWEETS");
  }
  
  public void gotoUserPage(User user, String itemList) throws TwitterException {
	  
	  	if(m_miniPage!=null)
	  		Utils.dispose(m_miniPage);
    // dispose old pages first
    Utils.dispose(m_homePage);
    Utils.dispose(m_userPage);
    Utils.dispose(m_searchPage);
    layout();
    
    // obtain and display new user
    if(user.getDescription().length()>60)
    	m_userPage = new UserPage(this, user, itemList, m_width, 
    	        m_height - 40, 300, 98, 520, 300, "onNameLinkClicked", this);
    else	
    	m_userPage = new UserPage(this, user, itemList, m_width, 
    			m_height - 40, 300, 98, 520, 260, "onNameLinkClicked", this);
    m_userPage.setLayoutData(new RowData(m_width, m_userPage.getBounds().height));
    m_userPage.addListener(SWT.Resize, new Listener() {
      @Override
      public void handleEvent(Event arg0) {
        m_userPage.setLayoutData(new RowData(m_width, m_userPage.getBounds().height));
        layout();
        pack();
      }
    });
    
    layout(); // trigger re-layout
    pack(); // re-size
  }
  
  public void gotoMiniUserPage(User user) throws TwitterException {
	    
	  // dispose old pages first
	  	if(m_miniPage!=null)
	  		Utils.dispose(m_miniPage);
	    
	  	layout();
	    
	   //go to mini user page(new shell)
	   // obtain and display new user
	  	if(user.getDescription().length()>60)
	  		m_miniPage = new MiniPage(this, user, m_width, 
	  				m_height - 40, 300, 98, 520, 300, "onNameLinkClicked", this);
	  	else
	  		m_miniPage = new MiniPage(this, user, m_width, 
	  				m_height - 40, 300, 98, 520, 260, "onNameLinkClicked", this);

	    m_miniPage.setLayoutData(new RowData(m_width, m_miniPage.getBounds().height));

	  }

  public void gotoSearchPage(String tag) throws TwitterException{
          gotoSearchPage(tag, 1);
  }
  public void gotoSearchPage(String tag , int page) throws  TwitterException{

      if(!(m_searchPage == null || m_searchPage.isDisposed())){
          m_searchPage.updateSearchTimeLine(tag, page);
          return;
      }

      if(m_miniPage!=null)
          Utils.dispose(m_miniPage);
      // dispose old pages first
      Utils.dispose(m_homePage);
      Utils.dispose(m_userPage);
      Utils.dispose(m_searchPage);

      layout();

      m_searchPage = new SearchPage(this, tag, m_width, 300, 98,
              m_height - 40, 300, 56, 520, "onNameLinkClicked", "onNumberItemClicked", this);
      m_searchPage.setLayoutData(new RowData(m_width, m_searchPage.getBounds().height));
      m_searchPage.addListener(SWT.Resize, new Listener() {
          @Override
          public void handleEvent(Event arg0) {
              m_searchPage.setLayoutData(new RowData(m_width, m_searchPage.getBounds().height));
              layout();
              pack();
          }
      });

      layout(); // trigger re-layout
      pack(); // re-size
  }

  private reply m_reply;
  private final int m_width;
  private final int m_height;
  
  // different components of the page
  private ControlBar m_ctrlBar;
  private UserPage   m_userPage;
  private HomePage   m_homePage;
  private SearchPage m_searchPage;
  
  private MiniPage   m_miniPage; // new shell for mini user page
  
  public static Status firstTweet=null;
  public static Status newTweet = null;
}
