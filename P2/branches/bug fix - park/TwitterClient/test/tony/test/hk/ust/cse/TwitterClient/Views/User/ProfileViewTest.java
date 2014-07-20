package tony.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.User.ProfileView;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import tony.test.hk.ust.cse.TwitterClient.Mocks.MockUser;

public class ProfileViewTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    MockUser friend = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    ProfileView profileView = new ProfileView(shell, friend, 10, 10);
    assertNotNull(profileView);
    
    shell.dispose();
    display.dispose();
  }

}
