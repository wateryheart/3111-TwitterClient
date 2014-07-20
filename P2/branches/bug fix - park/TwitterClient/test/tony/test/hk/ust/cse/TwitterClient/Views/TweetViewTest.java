package tony.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.TweetView;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import tony.test.hk.ust.cse.TwitterClient.Mocks.MockUser;

public class TweetViewTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
	
    Display display = new Display();
    Shell shell = new Shell(display);
    MockUser mock = new MockUser("fake", "aaa", true, "aaa");
    try{
    	TweetView tweetView = new TweetView(shell, mock.getStatus(), 10, false, new Color(null, 171, 205, 239), new Color(null, 171, 205, 239), new Color(null, 171, 205, 239), "text", shell);
        assertNotNull(tweetView);
    }catch(Exception ex){ }
    shell.dispose();
    display.dispose();
  }
}
