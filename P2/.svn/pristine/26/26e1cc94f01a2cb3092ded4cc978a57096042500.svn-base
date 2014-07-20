package tony.test.hk.ust.cse.TwitterClient.Views.Home;

import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.Home.MiniProfile;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import tony.test.hk.ust.cse.TwitterClient.Mocks.MockUser;

public class MiniProfileTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    MockUser mock = new MockUser("fake", "aaa", true, "aaa");
    MiniProfile profile = new MiniProfile(shell, mock, 10, 10);
    assertNotNull(profile);
    shell.dispose();
    display.dispose();
  }
}
