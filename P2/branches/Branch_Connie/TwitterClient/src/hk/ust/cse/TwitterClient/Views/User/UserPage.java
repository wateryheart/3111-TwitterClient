package hk.ust.cse.TwitterClient.Views.User;

import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Controls.UserPageControl;
import hk.ust.cse.TwitterClient.Post.PostBox;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.ListView;
import hk.ust.cse.TwitterClient.Views.NumberBar;
import hk.ust.cse.TwitterClient.Views.NumberBarItem;
import hk.ust.cse.TwitterClient.Views.ProtectedMessage;
import hk.ust.cse.TwitterClient.Views.TweetsList;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import twitter4j.AsyncTwitterFactory;
import twitter4j.PagableResponseList;
import twitter4j.Relationship;
import twitter4j.Status;
import twitter4j.TwitterException;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class UserPage extends RowComposite {
  
  public UserPage(Composite parentView, User user, String itemList, int width, int minPageHeight, int menuWidth, 
      int menuHeight, int profileWidth, int profileHeight, String nameClkHandler, Object handlerCallee) {
    super(parentView, SWT.CENTER, SWT.HORIZONTAL, false, 25, 50, 
        (width - menuWidth - profileWidth - 20) / 2, 
        (width - menuWidth - profileWidth - 20) / 2, 20);

    m_user           = user;
    m_width          = width;
    m_minPageHeight  = minPageHeight;
    m_nameClkHandler = nameClkHandler;
    m_handlerCallee  = handlerCallee;
    m_control        = new UserPageControl(this);
    
    initialize(width, menuWidth, menuHeight, profileWidth, profileHeight);

    // set the initial item list
    showNewItemList(itemList);
    
    // a dispose listener is necessary
    addDisposeListener(new DisposeListener() {
      public void widgetDisposed(DisposeEvent e) {
        UserPage.this.widgetDisposed(e);
      }
    });
  }
  
  private void initialize(int width, 
	      int menuWidth, int menuHeight, int profileWidth, int profileHeight) {
	    
		  
	    // set size
	    setSize(width, -1);
	    
	    // set background color
	    m_bgColor = Utils.getColorFromString(m_user.getProfileBackgroundColor());
	    setBackground(m_bgColor);
	    setBackgroundMode(SWT.INHERIT_DEFAULT); // make all labels have transparent backgrounds
	    
	    // set background image
	    m_bgImage = Utils.loadImageFromUrl(m_user.getProfileBackgroundImageURL().toString());
	   
	    //Error handling about failure to load Image of some users
	    if (m_bgImage != null) {
	      try{
	    	  setBackgroundImage(m_bgImage);
	      }
	      catch(Exception e){
	    	  //set default image if there are some errors
	    	  setBackgroundImage(Utils.loadImageFromUrl("http://a0.twimg.com/images/themes/theme1/bg.png"));
	      }
	    }
	    
	    // set the left frame
	    m_leftFrame = new RowComposite(this, 0, SWT.VERTICAL, false, 0, 0, 0, 0, 15);
	    m_leftFrame.setLayoutData(new RowData(menuWidth, -1));
	    m_leftFrame.addListener(SWT.Resize, new Listener() {
	        @Override
	        public void handleEvent(Event arg0) {
	        	m_leftFrame.setLayoutData(new RowData(m_leftFrame.getBounds().width, 
	        			m_leftFrame.getBounds().height));
	          layout();
	          pack();
	        }
	      });
	    
	    // set the menu frame
	    RowComposite menuFrame = new RowComposite(m_leftFrame, 0, SWT.VERTICAL, false, 1, 1, 1, 1, 1);
	    menuFrame.setLayoutData(new RowData(menuWidth, -1));
	    
	    // set the left menu
	    m_leftMenu = new UserMenu(m_leftFrame, menuWidth, menuHeight, "onMenuItemClicked", this);
	    
	    /**
	     * Add a post box for tweet to other users
	     **/
	    
	    // set the left post box
	    RowComposite postFrame = new RowComposite(m_leftFrame, 0, SWT.VERTICAL, false, 5, 5, 5, 5, 15);
	    postFrame.setLayoutData(new RowData(width, -1));
	    
	    
	    // set background color
	    postFrame.setBackground(Resources.MINI_PROFILE_COLOR);
	    postFrame.setBackgroundMode(SWT.INHERIT_DEFAULT); // make all labels have transparent backgrounds
	    
	    
	    Label to = new Label(postFrame, SWT.LEFT|SWT.WRAP);
	    to.setText("   Tweet to " + m_user.getName());
	    to.setFont(Resources.FONT12B);
	    //to.setLayoutData(new RowData(width,50));
	    
	    postBoxHeight = 150;
	    m_postBox = new PostBox(postFrame, m_user, menuWidth-20,postBoxHeight);
	    m_postBox.setLayoutData(new RowData(menuWidth-20, postBoxHeight));
	   
	    layout(); // trigger re-layout
	    pack();
	    Utils.cutRoundCorner(postFrame, true, true, true, true);
	    
	    // set the right frame
	    m_rightFrame = new RowComposite(this, 0, SWT.VERTICAL, false, 0, 0, 0, 0, 15);
	    m_rightFrame.setLayoutData(new RowData(profileWidth, -1));
	    m_rightFrame.addListener(SWT.Resize, new Listener() {
	      @Override
	      public void handleEvent(Event arg0) {
	        m_rightFrame.setLayoutData(new RowData(m_rightFrame.getBounds().width, 
	                                               m_rightFrame.getBounds().height));
	        layout();
	        pack();
	      }
	    });
	    
	    // set profile/number frame
	    RowComposite profileFrame = new RowComposite(m_rightFrame, 0, SWT.VERTICAL, false, 0, 0, 0, 0, 0);
	    profileFrame.setLayoutData(new RowData(profileWidth, -1));
	    m_profile = new ProfileView(profileFrame, m_user, profileWidth, profileHeight);
	    m_profile.setLayoutData(new RowData(profileWidth, profileHeight));
	    Utils.cutRoundCorner(m_profile, true, true, false, false);
	    
	    RowComposite numberFrame = new RowComposite(profileFrame, 0, SWT.HORIZONTAL, false, 0, 0, 0, 0, 0);
	    // set number bar
	    long[] numbers = new long[] {m_user.getStatusesCount(), 
	                                 m_user.getFriendsCount(), 
	                                 m_user.getFollowersCount()};
	    String[] titles = new String[] {"TWEETS", "FOLLOWING", "FOLLOWERS"};
	    
	    // Add the follow/unfollow button on Userpage
	    // In my page, the follow/unfollow button would not be shown.
	    // In another user page, the follow/unfollow button would be shown next to number bar.
	    
	    if(m_user.equals(TwitterControl.getAccountUser())){
	        m_numberBar = new NumberBar(numberFrame, numbers, titles, profileWidth, 
	                120, 50, Resources.WHITE_COLOR, Resources.HOVER_COLOR, Resources.WHITE_COLOR, 
	                Resources.FONT12B, Resources.FONT7, false, "onNumberItemClicked", this);
	    }
	    else{
	        m_numberBar = new NumberBar(numberFrame, numbers, titles, profileWidth-122, 
	                120, 50, Resources.WHITE_COLOR, Resources.HOVER_COLOR, Resources.WHITE_COLOR, 
	                Resources.FONT12B, Resources.FONT7, false, "onNumberItemClicked", this);
	        final Button button = new Button(numberFrame, SWT.PUSH | SWT.FLAT);
	        button.setBounds(0,0,80,50);
	        
	        final Twitter twitter = TwitterControl.getTwitter();
	        if (twitter!=null){
	        	 try {	
	 	        	Relationship relation = twitter.showFriendship(twitter.getScreenName(), m_user.getScreenName());
	 	    		if(relation!=null && relation.isSourceFollowingTarget()){
	 	    			// In user page who I'm following, the unfollow button would be shown
	 	    		    button.setImage(Resources.UNFOLLOW_IMG);

	 	    		}
	 	    		else if(relation!=null){
	 	    			// In user page who I'm not following, the follow button would be shown
	 	    			button.setImage(Resources.FOLLOW_IMG);
		 		 	    if(m_user.isProtected()){
		 		 		  	ProtectedMessage  protectedMessage = new ProtectedMessage(m_rightFrame, profileWidth, true, Resources.WHITE_COLOR, m_user);	
		 		 		 }
	 	    		}
	 	    		else{
	 	    			
	 	    		}
	 	        } catch (IllegalStateException e1) {
	 	    		e1.printStackTrace();
	 	    	} catch (TwitterException e1) {
	 	    		e1.printStackTrace();
	 	    	}
	 	        
	 	        button.addListener(SWT.Selection, new Listener(){
	 	        	@Override
	 	    		public void handleEvent(Event arg0) {
	 	        		//When clicking on follow button, it changes unfollow button and follow the user.
	 	        		if(button.getImage().equals(Resources.FOLLOW_IMG)){
	 	        		    button.setImage(Resources.UNFOLLOW_IMG);   
	 	        		   
	 	    					try {
									twitter.createFriendship(m_user.getScreenName());
								} catch (TwitterException e) {
									e.printStackTrace();
								}
	 	    				
	 	        		}
	 	        		//When clicking on unfollow button, it changes follow button and unfollow the user.
	 	        		else{
	 	        			button.setImage(Resources.FOLLOW_IMG);
	 	        		    
	 	    					try {
									twitter.destroyFriendship(m_user.getScreenName());
								} catch (TwitterException e) {
									e.printStackTrace();
								}
	 	    				
	 	        		}
	 	        		//After following/unfollowing another user, the information of twitter would be updated(i.e the number of following)
	 	        		
	 	        		TwitterControl.setupTwitter(TwitterFactory.getSingleton(), AsyncTwitterFactory.getSingleton());
	 	    		}
	 	        	
	 	        });
	 	         	     
	        }
	    }
	    
	    
		
	    Utils.cutRoundCorner(m_numberBar, false, false, true, true); 
	    
	    layout(); // trigger re-layout
	    pack();
	  }

  public void onMenuItemClicked(MouseEvent arg) {
    int index = m_leftMenu.getCurrentSelected();
    if (index >= 0) {
      UserMenuItem selectedItem = m_leftMenu.getMenuItems().get(index);
      showNewItemList(selectedItem.getTitle());
    }
  }
  
  public void onNumberItemClicked(MouseEvent arg) {
    Control control = (Control) arg.getSource();
    while (!(control instanceof NumberBarItem)) {
      control = control.getParent();
    }
    if (control != null) {
      showNewItemList(((NumberBarItem) control).getTitle());
    }
  }
  
  private void showNewItemList(String title) {
    // remove the old list view
    Utils.dispose(m_itemList);
    
    layout();
    pack();

    // we need to guarantee a minimal page height
    if (getBounds().height < m_minPageHeight) {
      setSize(m_width, m_minPageHeight);
    }
    
    // retrieve the list asynchronously
    title = title.toLowerCase();
    if (title.equals("tweets")) {
      m_leftMenu.setCurrentSelected(0);
      m_tweetPage = 1;
      TwitterControl.getUserTimeline(m_user.getScreenName(), m_tweetPage, "showTweetsListCallback", m_control);
    }
    else if (title.equals("following")) {
      m_leftMenu.setCurrentSelected(1);
      TwitterControl.getFollowing(m_user.getScreenName(), -1, "showFollowingListCallback", m_control);
    }
    else if (title.equals("followers")) {
      m_leftMenu.setCurrentSelected(2);
      TwitterControl.getFollowers(m_user.getScreenName(), -1, "showFollowersListCallback", m_control);
    }
    else if (title.equals("favorites")) {
      m_leftMenu.setCurrentSelected(3);
    }
    else if (title.equals("lists")) {
      m_leftMenu.setCurrentSelected(4);
    }
  }
  
  public void tweetsListBackClicked(MouseEvent arg) {
    if (m_tweetPage > 1) {
      m_tweetPage -= 1;
      TwitterControl.getUserTimeline(m_user.getScreenName(), m_tweetPage, "showTweetsListCallback", m_control);
    }
  }
  
  public void tweetsListNextClicked(MouseEvent arg) {
    if (m_tweetPage * 20 < m_user.getStatusesCount()) {
      m_tweetPage += 1;
      TwitterControl.getUserTimeline(m_user.getScreenName(), m_tweetPage, "showTweetsListCallback", m_control);
    }
  }
  
  public void followingListBackClicked(MouseEvent arg) {
    long prevCursor = m_following.getPreviousCursor();
    if (prevCursor != 0) {
      TwitterControl.getFollowing(m_user.getScreenName(), prevCursor, "showFollowingListCallback", m_control);
    }
  }
  
  public void followingListNextClicked(MouseEvent arg) {
    long nextCursor = m_following.getNextCursor();
    if (nextCursor != 0) {
      TwitterControl.getFollowing(m_user.getScreenName(), nextCursor, "showFollowingListCallback", m_control);
    }
  }
  
  public void followersListBackClicked(MouseEvent arg) {
    long prevCursor = m_followers.getPreviousCursor();
    if (prevCursor != 0) {
      TwitterControl.getFollowers(m_user.getScreenName(), prevCursor, "showFollowersListCallback", m_control);
    }
  }
  
  public void followersListNextClicked(MouseEvent arg) {
    long nextCursor = m_followers.getNextCursor();
    if (nextCursor != 0) {
      TwitterControl.getFollowers(m_user.getScreenName(), nextCursor, "showFollowersListCallback", m_control);
    }
  }
  
  public void showTweetsList(List<Status> tweets) {
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
  }
  
  public void showFollowingList(PagableResponseList<User> following) {
    // remove the old list view
    Utils.dispose(m_itemList);
    layout();

    m_following = following;
    m_itemList = new FriendsList(m_rightFrame, m_following, "Following", 
        m_rightFrame.getBounds().width, m_nameClkHandler, m_handlerCallee, 
        "followingListBackClicked", this, "followingListNextClicked", this);
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
  
  public void showFollowersList(PagableResponseList<User> followers) {
    // remove the old list view
    Utils.dispose(m_itemList);
    layout();

    m_followers = followers;
    m_itemList = new FriendsList(m_rightFrame, m_followers, "Followers", 
        m_rightFrame.getBounds().width, m_nameClkHandler, m_handlerCallee, 
        "followersListBackClicked", this, "followersListNextClicked", this);
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
  
  private void widgetDisposed(DisposeEvent e) {
    // dispose created colors
    Utils.dispose(m_bgColor);
    
    // dispose loaded images
    Utils.dispose(m_bgImage);
  }
  
  public User getUser() {
    return m_user;
  }
  
  private UserMenu     m_leftMenu;
  private ProfileView  m_profile;
  private NumberBar    m_numberBar;
  private ListView     m_itemList;
  private RowComposite m_rightFrame;

  private RowComposite m_leftFrame; //for postBox
  private PostBox		m_postBox; //for postBox
  
  // the currently showing list
  private int                       m_tweetPage;
  private PagableResponseList<User> m_following;
  private PagableResponseList<User> m_followers;
  
  // resources that need to be disposed
  private Color m_bgColor;
  private Image m_bgImage;
  
  private final User            m_user;
  private final int             m_width;
  private final int             m_minPageHeight;
  private final String          m_nameClkHandler;
  private final Object          m_handlerCallee;
  private final UserPageControl m_control;

  private int 			postBoxHeight; //for postBox
}
