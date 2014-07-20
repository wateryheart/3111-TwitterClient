package connie.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.NumberBarItem;
import hk.ust.cse.TwitterClient.Views.User.UserPage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import connie.test.hk.ust.cse.TwitterClient.Mocks.MockPagableResponseList;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockStatus;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockUser2;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.User;

public class UserPageTest {

	@Test(timeout=10000)
	public void testUserPage() throws TwitterException, Throwable {
		Display display = new Display();
	    Shell shell = new Shell(display);
	    MockUser user = new MockUser("Username", "UserScreenName", true, "UserDescription");
	    UserPage userPage = new UserPage(shell, user,"Item List", 700, 300, 200, 400, 250, 350, "m_nameClkHandler", this);
	    assertNotNull(userPage);
	    assertTrue(userPage.getVisible());
	    assertEquals("Username",  userPage.getUser().getName());
	    assertEquals("UserScreenName",  userPage.getUser().getScreenName());
	    assertEquals("UserDescription",  userPage.getUser().getDescription());
	    userPage.getUser();
	    assertTrue(userPage.getUser().isVerified());
	    
	    Event event = new Event();
		event.widget=shell;
		event.type = SWT.MouseDown;
		MouseEvent mEvent = new MouseEvent(event);
		try{
			userPage.notifyListeners(0,event);
			userPage.onMenuItemClicked(mEvent);
			} catch(Exception e){}
		
		NumberBarItem noBarItm = new NumberBarItem(shell,0,"titile",200,100,Resources.SPLIT_COLOR,Resources.SPLIT_COLOR,Resources.SPLIT_COLOR,Resources.FONT10,Resources.FONT12);
		event = new Event();
		event.widget = noBarItm;
		mEvent = new MouseEvent(event);
		userPage.onNumberItemClicked(mEvent);
		noBarItm.notifyListeners(SWT.MouseHover, event);
		noBarItm.notifyListeners(SWT.MouseEnter, event);
		noBarItm.notifyListeners(SWT.MouseExit, event);
		event.x = 900;
		event.y = 900;
		noBarItm.notifyListeners(SWT.MouseExit, event);
		noBarItm.dispose();
		userPage.dispose();
		
		MockUser2 user2 = new MockUser2("Mini Profile Name", "Mini Profile Screen Name", false, "s");
		
		try{
		UserPage userPage2 = new UserPage(shell, user2,"Item List", 700, 300, 200, 400, 250, 350, "m_nameClkHandler", this);
		userPage2.dispose();
		} catch(Exception e){}
	    
		Shell shell2 = new Shell(display);
	    try{
		    UserPage userPage3 = new UserPage(shell2,user,"following",200,200,100,100,100,100,"tired",this);
			
			event = new Event();
			event.widget = userPage3;
			mEvent = new MouseEvent(event);
			MockPagableResponseList<User> prl = new MockPagableResponseList<User>();
			prl.add(new MockUser("workingHard","5am",true,"keep going"));
			userPage3.showFollowingList(prl);
			userPage3.followingListNextClicked(mEvent);
			userPage3.followingListNextClicked(mEvent);
		    userPage3.followingListBackClicked(mEvent);
		    userPage3.followingListBackClicked(mEvent);
		    userPage3.showFollowersList(prl);
		    userPage3.followersListNextClicked(mEvent);
		    userPage3.followersListNextClicked(mEvent);
		    userPage3.followersListBackClicked(mEvent);
		    userPage3.followersListBackClicked(mEvent);
		    List<Status> list = new ArrayList<Status>();
			list.add(new MockStatus()); 
			userPage.showTweetsList(list);
		    userPage3.tweetsListNextClicked(mEvent);
		    userPage3.tweetsListNextClicked(mEvent);
		    userPage3.tweetsListBackClicked(mEvent);
		    userPage3.tweetsListBackClicked(mEvent);
		    userPage3.addDisposeListener(null);
			list.clear();
			
			noBarItm = new NumberBarItem(userPage3,1,"title",1,1,Resources.SPLIT_COLOR,Resources.LINK_COLOR,Resources.HOVER_COLOR,Resources.FONT10,Resources.FONT11I);
			event = new Event();
			event.widget = userPage3;
			mEvent = new MouseEvent(event);
			userPage3.onNumberItemClicked(mEvent);
			userPage3.showTweetsList(list);
			userPage3.showFollowersList(prl);
			userPage3.showFollowingList(prl);
			
		    userPage3.dispose();
		} catch(Exception e){}
	    try{
	    	UserPage userPage4 = new UserPage(shell2,user,"followers",300,300,200,200,200,200,"hungry",this);
			userPage4.dispose();
	    } catch(Exception e){}
	    try{
	    	UserPage userPage5 = new UserPage(shell,user,"favorites",150,150,100,100,50,50,"sleepy",this);
	    	userPage5.dispose();
	    } catch(Exception e){}
	    try{
	    	UserPage userPage6 = new UserPage(shell,user,"lists",400,400,200,200,100,100,"my god",this);
	    	userPage6.dispose();
	    } catch(Exception e){}
	    try{
	    	UserPage userPage7 = new UserPage(shell,user,"",400,400,200,200,100,100,"crazy",this);
	    	userPage7.dispose();
		} catch(Exception e){}
	    
	    shell.dispose();
	    display.dispose();
	}
}
