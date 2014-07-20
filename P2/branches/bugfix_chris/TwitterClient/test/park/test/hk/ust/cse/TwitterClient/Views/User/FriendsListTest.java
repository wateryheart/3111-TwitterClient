package park.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.User.FriendsList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class FriendsListTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    FriendsList friendsList = new FriendsList(shell, null, "twitter", 10, null, null, null, null, null, null);
    assertNotNull(friendsList);
   
    shell.dispose();
    display.dispose();
  }

}
