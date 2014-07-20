package park.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import hk.ust.cse.TwitterClient.Views.User.ProfileView;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import park.test.hk.ust.cse.TwitterClient.Mocks.MockUser;


public class ProfileViewTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    MockUser fakeFriend = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    MockUser actualFriend = new MockUser("ActualUser", "ActualScreenName", true, "");
    
    ProfileView profileView1 = new ProfileView(shell, fakeFriend, 10, 10);
    ProfileView profileView2 = new ProfileView(shell, actualFriend, 100, 100);
    assertNotNull(profileView1);
    assertNotNull(profileView2);
    assertEquals("FakeUser", profileView1.getUser().getName());
    assertEquals("FakeScreenName", profileView1.getUser().getScreenName());
    assertEquals("Fake Description", profileView1.getUser().getDescription());
    assertTrue(profileView1.getUser().isVerified());
    assertTrue(profileView2.getUser().isVerified());
    
    shell.dispose();
    display.dispose();
  }

}
