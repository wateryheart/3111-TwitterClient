package park.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Views.User.FriendView;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import park.test.hk.ust.cse.TwitterClient.Mocks.MockUser;


public class FriendViewTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    MockUser friend1 = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    MockUser friend2 = new MockUser("ActualUser", "FakeScreenName", false, "Fake Description");
    FriendView friendView1 = new FriendView(shell, friend1, 10, null, null);
    FriendView friendView2 = new FriendView(shell, friend2, 10, null, null);
    assertNotNull(friendView1);
    assertNotNull(friendView2);
    assertEquals("FakeUser", friendView1.getFriend().getName());
    assertEquals("FakeScreenName", friendView1.getFriend().getScreenName());
    assertEquals("Fake Description", friendView1.getFriend().getDescription());
    assertTrue(friendView1.getFriend().isVerified());
    assertFalse(friendView2.getFriend().isVerified());
    
    shell.dispose();
    display.dispose();
  }

}
