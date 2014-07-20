package hk.ust.cse.TwitterClient.Views;

import hk.ust.cse.TwitterClient.Controls.FavoriteControl;
import hk.ust.cse.TwitterClient.Controls.RetweetControl;

import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;
import hk.ust.cse.TwitterClient.Views.Home.HomePage;
import hk.ust.cse.TwitterClient.Views.Home.MiniProfile;
import hk.ust.cse.TwitterClient.Views.User.FriendView;
import hk.ust.cse.TwitterClient.Views.User.MiniPage;
import hk.ust.cse.TwitterClient.Views.User.UserPage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

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
    String screenName = m_ctrlBar.getGotoPeopleName();
    m_ctrlBar.flushPeopleName();
    if (screenName.length() > 0) {
      // find user
      User user = TwitterControl.getUser(screenName);
     
      if (user != null) {
        gotoUserPage(user);
      }
      else{
    	  Shell notification = new Shell(getShell());
    	 
    	  notification.setText("COMP3111 Project: Twitter Client");
    	  notification.setSize(300,100);
    	  notification.setLocation(500, 300);
    	  
    	  Label text = new Label(notification, SWT.CENTER);
    	  text.setSize(300,100);
    	  text.setFont(Resources.FONT11B);
    	  text.setLocation(0,0);
    	  text.setText("\nNo existing user! Please retry");
    	  notification.open();
    	  notification.addDisposeListener(new DisposeListener() {
    	      public void widgetDisposed(DisposeEvent e) {
    	        }
    	      });

      }
    }
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
      Status tweet = ((TweetView) control).getTweet();
      //go to mini user page(new shell) instead of user page
      gotoMiniUserPage(tweet.getUser());
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
            FavoriteControl.favoriteHandler(tweet);
        }
        gotoHomePage();
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
            RetweetControl.retweetHandler(tweet);
            gotoHomePage();
        }
        else if (control instanceof FriendView) {
            gotoUserPage(((FriendView) control).getFriend());
        }
        else if (control instanceof MiniProfile) {
            gotoUserPage(TwitterControl.getAccountUser());
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
    layout();
    
    // obtain and display new user
    if(user.getDescription().length()>100)
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
	  	if(user.getDescription().length()>100)
	  		m_miniPage = new MiniPage(this, user, m_width, 
	  				m_height - 40, 300, 98, 520, 300, "onNameLinkClicked", this);
	  	else
	  		m_miniPage = new MiniPage(this, user, m_width, 
	  				m_height - 40, 300, 98, 520, 260, "onNameLinkClicked", this);
	  	m_miniPage.setLayoutData(new RowData(m_width, m_miniPage.getBounds().height));

	  }
  
  private final int m_width;
  private final int m_height;
  
  // different components of the page
  private ControlBar m_ctrlBar;
  private UserPage   m_userPage;
  private HomePage   m_homePage;
  
  private MiniPage   m_miniPage; // new shell for mini user page
}
