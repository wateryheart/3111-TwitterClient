package martin.test.hk.ust.cse.TwitterClient.Controls;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.TwitterClient.Controls.UserPageControl;
import hk.ust.cse.TwitterClient.Views.User.UserPage;

import martin.test.hk.ust.cse.TwitterClient.Mocks.MockPagableResponseList;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockResponseList;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;

import 	 org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;


import twitter4j.PagableResponseList;
import twitter4j.Status;
import twitter4j.User;

public class UserPageControlTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    final Display display = new Display();
    final Shell shell = new Shell(display);
  
    try{
	    MockUser user = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
	    user.setProfileBackgroundColor("1A1B1F");
	    user.setProfileBackgroundImageURL("");
	    
	    UserPage userPage; 
	    userPage = new UserPage(shell, user,"", 10, 1, 10, 10, 10, 10, null, null);
	    assertNotNull(userPage);	    
	    //test public functions
	    assertNotNull( userPage.getUser() );
	    assertEquals( user.getScreenName(), userPage.getUser().getScreenName() );
	   	   
	    List<Status> tweets = new ArrayList<Status>();
	    //test public functions
	    userPage.showTweetsList(tweets);
	
	    PagableResponseList<User> userList = new MockPagableResponseList<User>(-1);
	    userList.add(user);
	    //test public functions
	    userPage.showFollowingList(userList);
	    userPage.showFollowersList(userList);
	    
	    //UserPageControl
	    
	    UserPageControl userPageControl = new UserPageControl(userPage);
	    assertNotNull(userPageControl);
	    
	    MockResponseList<Status> mockResponseList = new MockResponseList<Status>();
	    userPageControl.showTweetsListCallback( (Object)mockResponseList );
	    MockPagableResponseList<User> mockPagableResponseList = new MockPagableResponseList<User>(-1);
	    
	    userPageControl.showFollowingListCallback( (Object)mockPagableResponseList );
	    userPageControl.showFollowersListCallback( (Object)mockPagableResponseList );
	    
    }
    catch(Exception e){
    	System.out.println(e.getMessage());
    	assertNull( e.getMessage() );
    }
       
  }

}
