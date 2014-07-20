package tony.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.TweetsList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class TweetsListTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    TweetsList tweetsList = new TweetsList(shell, null, 10, null, null, null, null, null, null);
    assertNotNull(tweetsList);
    assertEquals(10, tweetsList.getBounds().width);
    //assertEquals(10, tweetsList.getBounds().height);
    shell.dispose();
    display.dispose();
  }
}
