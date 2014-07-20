package hk.ust.cse.TwitterClient.Views.User;

import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;

import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.ListView;
import hk.ust.cse.TwitterClient.Views.NumberBar;
import hk.ust.cse.TwitterClient.Views.NumberBarItem;
import hk.ust.cse.TwitterClient.Views.ProtectedMessage;

import hk.ust.cse.TwitterClient.Views.TweetsList;

import hk.ust.cse.TwitterClient.Views.Basic.LinkLabel;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;


import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;


import twitter4j.AsyncTwitterFactory;
import twitter4j.PagableResponseList;
import twitter4j.Relationship;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class MiniPage extends RowComposite {
  

public MiniPage(Composite parentView, User user, int width, int minPageHeight, int menuWidth, 
      int menuHeight, int profileWidth, int profileHeight, String nameClkHandler, Object handlerCallee) {
    super(parentView, SWT.CENTER, SWT.HORIZONTAL, false, 25, 50, 
        (width - menuWidth - profileWidth - 20) / 2, 
        (width - menuWidth - profileWidth - 20) / 2, 20);

    m_user           = user;
    m_width          = width;
    m_minPageHeight  = minPageHeight;
    m_nameClkHandler = nameClkHandler;
    m_handlerCallee  = handlerCallee;
    

    initialize(width,profileWidth, profileHeight);
    
    // a dispose listener is necessary
    addDisposeListener(new DisposeListener() {
      public void widgetDisposed(DisposeEvent e) {
        MiniPage.this.widgetDisposed(e);
      }
    });
  }
  
private void initialize(int width, int profileWidth, int profileHeight) {
    
  	shell.setLayout(new GridLayout(1,false));
  	shell.setLocation(500, 100);
  	shell.setText("Mini User Page: "+m_user.getName()+" (@"+m_user.getScreenName()+")");
    // set profile/number frame

    m_profile = new ProfileView(shell, m_user, profileWidth, profileHeight);
    m_profile.setLayoutData(new GridData(profileWidth, profileHeight));
    Utils.cutRoundCorner(m_profile, true, true, false, false);
    
    RowComposite numberFrame = new RowComposite(shell, 0, SWT.HORIZONTAL, false, 0, 0, 0, 0, 0);
    // set number bar
    long[] numbers = new long[] {m_user.getStatusesCount(), 
                                 m_user.getFriendsCount(), 
                                 m_user.getFollowersCount()};
    String[] titles = new String[] {"TWEETS", "FOLLOWING", "FOLLOWERS"};
    
    // Set the follow/unfollow button
    // In my page, the follow/unfollow button would not be shown.
    // In another user page, the follow/unfollow button would be shown next to number bar.
    
    final Twitter twitter = TwitterControl.getTwitter();
    
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
        
        try {	
        	Relationship relation = twitter.showFriendship(twitter.getScreenName(),m_user.getScreenName());
    		if(relation==null || relation.isSourceFollowingTarget()){
    			// In user page who I'm following, the unfollow button would be shown
    		    button.setImage(Resources.UNFOLLOW_IMG);
    		}
    		else{
    			// In user page who I'm not following, the follow button would be shown
    			button.setImage(Resources.FOLLOW_IMG);
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
	        		TwitterControl.updateTwitter();
    		}
        	
        });
    }
    
    Utils.cutRoundCorner(m_numberBar, false, false, true, true); 

    ListView  itemList=null;
    Relationship relation;
	try {
		relation = twitter.showFriendship(twitter.getScreenName(),m_user.getScreenName());
	    if(relation!=null && !relation.isSourceFollowingTarget() && m_user.isProtected()){
	    	ProtectedMessage  protectedMessage = new ProtectedMessage(shell, profileWidth, true, Resources.WHITE_COLOR, m_user);
	    	shell.setSize(profileWidth+15, profileHeight + 270);
	    }
	    else if(relation!=null){
	        List<Status> tweets = null;
	    	try {
	    		tweets = twitter.getUserTimeline(m_user.getScreenName());
	    	} catch (TwitterException e) {
	    		e.printStackTrace();
	    	}
	    	itemList =new TweetsList(shell, tweets, profileWidth, m_nameClkHandler, m_handlerCallee, 
	                null, this, null, this);	    		    	    
	    }
	    else{
	    	shell.setSize(profileWidth+15, profileHeight + 100);
	    }
	} catch (IllegalStateException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (TwitterException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

    
    //Set timeline on mini user page
  
    RowComposite nameFrame = new RowComposite(shell, 0, SWT.HORIZONTAL, false, 0, 0, 0, 0, 5);
    
    // set link label to full profile(user page)
    m_name = new LinkLabel(nameFrame, 0, Resources.TEXT_COLOR, Resources.LINK_COLOR, Resources.FONT11B, Resources.FONT11B);
    m_name.setText("\n	Go to full profile...");
    
    Utils.addClickListener(m_name, "goToPageClicked", this);
  
	if(itemList!=null)
	    shell.setSize(profileWidth+15, profileHeight + itemList.getHeight() + 150);
    
    
    layout(); // trigger re-layout
    pack();
    shell.open();
  }


public void onNumberItemClicked(MouseEvent arg) {
	  
	    Control control = (Control) arg.getSource();
	    while (!(control instanceof NumberBarItem)) {
	      control = control.getParent();
	    }
      try {
          Method method = m_handlerCallee.getClass().getMethod("gotoUserPage", User.class, String.class);
          method.invoke(m_handlerCallee, m_user, ((NumberBarItem) control).getTitle());
          shell.dispose();
        } catch (Exception e) {e.printStackTrace();}
      
}

public void goToPageClicked(MouseEvent arg) {
	  
    try {
        Method method = m_handlerCallee.getClass().getMethod("onMiniUserPageLinkClicked", User.class);
        method.invoke(m_handlerCallee, m_user);
        shell.dispose();
      } catch (Exception e) {e.printStackTrace();}
    
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
  private LinkLabel    m_name;

  private Shell shell = new Shell(getShell());
}