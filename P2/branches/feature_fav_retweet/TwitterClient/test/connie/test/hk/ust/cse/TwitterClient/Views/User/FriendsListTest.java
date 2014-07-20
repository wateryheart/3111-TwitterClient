package connie.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.ControlBarItem;
import hk.ust.cse.TwitterClient.Views.User.FriendsList;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import connie.test.hk.ust.cse.TwitterClient.Mocks.MockPagableResponseList;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockUser;

import twitter4j.PagableResponseList;
import twitter4j.User;

public class FriendsListTest {

	@Test(timeout=10000)
	public void testFriendsList()throws Throwable {
		Display display = new Display();
	    Shell shell = new Shell(display);
	    PagableResponseList<User> users = null;	    
	    FriendsList fl = new FriendsList(shell, users, "TEST", 100, "nameClkHandler", null, "backHandler", null, "nextHandler", null);
	    assertNotNull(fl);
	    assertEquals(100, fl.getWidth());
	    fl.addItem(new ControlBarItem(fl, "TEST", Resources.GO_IMG, Resources.GO_CLICKED_IMG));
	    List<ControlBarItem> list1 = new ArrayList<ControlBarItem>();
	    list1.add(new ControlBarItem(fl, "TEST", Resources.GO_IMG, Resources.GO_CLICKED_IMG));
	    fl.addItems(list1);
	    fl.dispose();
	    MockPagableResponseList<User> friend = new MockPagableResponseList<User>();
	    
	    fl = new FriendsList(shell, friend, "TEST", 100, "nameClkHandler", null, null, null, null, null);
	    assertNotNull(fl);
	    fl.dispose();	   	    
	    MockUser user = new MockUser("hi","hard",true,"difficult");
	    friend.add(user);
	    fl = new FriendsList(shell, friend, "TEST", 100, "nameClkHandler", null, null, null, null, null);
	    assertNotNull(fl);
	    fl.dispose();
	    shell.dispose();
	    display.dispose();
	}

}
