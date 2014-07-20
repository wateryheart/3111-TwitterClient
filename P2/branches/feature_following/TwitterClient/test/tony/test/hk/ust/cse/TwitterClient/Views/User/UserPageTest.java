package tony.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.User.UserPage;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import tony.test.hk.ust.cse.TwitterClient.Mocks.MockUser;

public class UserPageTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    try{
    	MockUser friend = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    	UserPage userPage = new UserPage(shell, friend, null, 10, 10, 10, 10, 10, 10, null, null);
    	assertNotNull(userPage);
    }catch(Exception ex){}
    
    shell.dispose();
    display.dispose();
  }

}
