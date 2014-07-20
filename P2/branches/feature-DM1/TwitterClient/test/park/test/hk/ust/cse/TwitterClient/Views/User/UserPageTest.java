package park.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.lang.reflect.Field;
import java.util.List;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.ListView;
import hk.ust.cse.TwitterClient.Views.NumberBarItem;
import hk.ust.cse.TwitterClient.Views.User.UserMenu;
import hk.ust.cse.TwitterClient.Views.User.UserMenuItem;
import hk.ust.cse.TwitterClient.Views.User.UserPage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.internal.SWTEventListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TypedListener;
import org.junit.Test;

import park.test.hk.ust.cse.TwitterClient.Mocks.MockUser;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.PagableResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class UserPageTest {
  @Test(timeout=50000)
  
  public void testConstructor() throws Throwable {

	Display display = new Display();
	Shell shell = new Shell(display);
	
    String CONSUMER_KEY = "m0LSVjOVM8sJK7v9bnuKtQ";
    String CONSUMER_SECRET ="cdrPYrhzmB4YS42M4nBZ1QMP6uq5389AAIKNezZVAM";
    String ACCESSTOKEN="147163880-sfKmPIQMUw0bRR0N5FfrILQEyRr2aBFjRjgTQ6NQ";
    String ACCESSTOKEN_SECRET="JtG4Tv5GCSC7kAVab7i968dvTQJIxXYfnO9yEAfA";
    
    ConfigurationBuilder builder = new ConfigurationBuilder();
    builder.setOAuthConsumerKey(CONSUMER_KEY);
    builder.setOAuthConsumerSecret(CONSUMER_SECRET);
    builder.setOAuthAccessToken(ACCESSTOKEN);
    builder.setOAuthAccessTokenSecret(ACCESSTOKEN_SECRET);
    
    Configuration configuration = builder.build();
    TwitterFactory factory = new TwitterFactory(configuration);
    Twitter twitter = factory.getInstance();
    AsyncTwitterFactory asyncfactory = new AsyncTwitterFactory(configuration);
    AsyncTwitter asyncTwitter = asyncfactory.getInstance();
    
    TwitterControl.setupTwitter(twitter, asyncTwitter);
    
	PagableResponseList<User> page = twitter.getFriendsList("kataruis", -1);
	PagableResponseList<User> page1 = twitter.getFriendsList("kataruis", 0);
    
    MockUser friend = new MockUser("FakeUser", "kataruis", true, "Fake Description");
    UserPage userPage1 = new UserPage(shell, friend, "test", 100, 100, 100, 100, 100, 100, null, null);
    UserPage userPage2 = new UserPage(shell, friend, "Tweets", 100, 2000, 100, 100, 100, 100, null, null);

	
    Event event1 = new Event();
	Event event2 = new Event();
	Event event3 = new Event();
    
    UserMenu uMenuTest = getPrivateUserMenu(userPage2);
    List<UserMenuItem> uItemTest = getPrivateUserItem(uMenuTest);
    
	event1.widget = uItemTest.get(0);
	MouseEvent e1 = new MouseEvent(event1);
	Listener[] listen1 = uItemTest.get(0).getListeners(SWT.MouseDown);
	SWTEventListener listener1 = ((TypedListener) (listen1[0])).getEventListener();
	((MouseListener)listener1).mouseDown(e1);

	event2.widget = uItemTest.get(1);
	MouseEvent e2 = new MouseEvent(event2);
	Listener[] listen2 = uItemTest.get(1).getListeners(SWT.MouseDown);
	SWTEventListener listener2 = ((TypedListener) (listen2[0])).getEventListener();
	((MouseListener)listener2).mouseDown(e2);
	
	event3.widget = uItemTest.get(2);
	MouseEvent e3 = new MouseEvent(event3);
	Listener[] listen3 = uItemTest.get(2).getListeners(SWT.MouseDown);
	SWTEventListener listener3 = ((TypedListener) (listen3[0])).getEventListener();
	((MouseListener)listener3).mouseDown(e3);
	
	Event event5 = new Event();


	userPage1.tweetsListBackClicked(e1);
	userPage1.tweetsListNextClicked(e1);
	userPage1.tweetsListBackClicked(e1);
	userPage1.tweetsListNextClicked(e1);
	
	userPage2.tweetsListBackClicked(e1);
	userPage2.tweetsListNextClicked(e1);
	userPage2.tweetsListBackClicked(e1);
	userPage2.tweetsListNextClicked(e1);
	
	userPage1.showFollowingList(page);
	userPage2.showFollowingList(page1);
	
	userPage1.followingListNextClicked(e1);
	userPage1.followingListBackClicked(e1);
	userPage1.followingListNextClicked(e1);
	userPage1.followingListBackClicked(e1);
	
	userPage2.followingListBackClicked(e1);
	userPage2.followingListNextClicked(e1);
	userPage2.followingListBackClicked(e1);
	userPage2.followingListNextClicked(e1);
	
    ListView viewTest = getPrivateUserView(userPage1);
	event5.widget = viewTest;
	Listener[] listen5 = viewTest.getListeners(SWT.Resize);
	(listen5[0]).handleEvent(event5);

	userPage1.showFollowersList(page);
	userPage2.showFollowersList(page1);
	

	userPage1.followersListNextClicked(e1);
	userPage1.followersListBackClicked(e1);
	userPage1.followersListNextClicked(e1);
	userPage1.followersListBackClicked(e1);
	
	userPage2.followersListBackClicked(e1);
	userPage2.followersListNextClicked(e1);
	userPage2.followersListBackClicked(e1);
	userPage2.followersListNextClicked(e1);

	
	ListView viewTest1 = getPrivateUserView(userPage1);
	event5.widget = viewTest1;
	Listener[] listen6 = viewTest1.getListeners(SWT.Resize);
	(listen6[0]).handleEvent(event5);
	
	ListView viewTest2 = getPrivateUserView(userPage1);
	event5.widget = viewTest2;
	Listener[] listen7 = viewTest2.getListeners(SWT.Resize);
	(listen7[0]).handleEvent(event5);
	
	Event event4 = new Event();
	event4.widget = new NumberBarItem(shell, 10, "Tweets", 10, 10, Resources.WHITE_COLOR, Resources.HOVER_COLOR, Resources.HOVER_COLOR, 
    		Resources.FONT11, Resources.FONT11I);
	MouseEvent e4 = new MouseEvent(event4);
	userPage1.onNumberItemClicked(e4);
	
	assertNotNull(userPage1);

    shell.dispose();
    }
  
  private UserMenu getPrivateUserMenu(UserPage userPage){
		UserMenu userTest = null;
		try{
			Field field = UserPage.class.getDeclaredField("m_leftMenu");
			field.setAccessible(true);
			userTest = (UserMenu)field.get(userPage);
				
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return userTest;
		
	}

	private List<UserMenuItem> getPrivateUserItem(UserMenu userMenu){
		List<UserMenuItem> userTest = null;
		try{
			Field field = UserMenu.class.getDeclaredField("m_items");
			field.setAccessible(true);
			userTest = (List<UserMenuItem>)field.get(userMenu);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	return userTest;
	
	}
	private ListView  getPrivateUserView(UserPage userMenu){
		ListView userTest = null;
		try{
			Field field = UserPage.class.getDeclaredField("m_itemList");
			field.setAccessible(true);
			userTest = (ListView)field.get(userMenu);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	return userTest;
	
	}
	

}