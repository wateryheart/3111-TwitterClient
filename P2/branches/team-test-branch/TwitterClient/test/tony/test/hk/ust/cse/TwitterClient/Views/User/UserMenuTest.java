package tony.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.User.UserMenu;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class UserMenuTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    //MockUser friend = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    UserMenu menu = new UserMenu(shell, 10, 10, null, null);
    assertNotNull(menu);
    
    shell.dispose();
    display.dispose();
  }

}
