package connie.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Views.User.FriendView;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import connie.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockUser2;


public class FriendViewTest {

	@Test(timeout=10000)
	public void testFriendView() throws Throwable{
		Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    MockUser friend = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
	    FriendView friendView = new FriendView(shell, friend, 10, "string", null);
	    assertNotNull(friendView);
	    assertEquals("FakeUser", friendView.getFriend().getName());
	    assertEquals("FakeScreenName", friendView.getFriend().getScreenName());
	    assertEquals("Fake Description", friendView.getFriend().getDescription());
	    assertTrue(friendView.getFriend().isVerified());
	    friendView.dispose();
	    MockUser2 friend2 = new MockUser2("FakeUser", "FakeScreenName", false, "");
	    friendView = new FriendView(shell, friend2, 10, null, null);
	    assertNotNull(friend2);
	    friendView.dispose();
	    shell.dispose();
	    display.dispose();
	}


}
