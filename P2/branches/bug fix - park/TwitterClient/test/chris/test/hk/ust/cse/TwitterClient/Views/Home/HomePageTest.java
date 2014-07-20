package chris.test.hk.ust.cse.TwitterClient.Views.Home;

import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Views.Home.HomePage;

import martin.test.hk.ust.cse.TwitterClient.Mocks.ConcreteMockAsyncTwitter;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockTwitter;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import martin.test.utils.TestUtils;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import twitter4j.AsyncTwitter;
import twitter4j.Status;
import twitter4j.Twitter;

public class HomePageTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    MockUser user  = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    user.setProfileBackgroundColor("1A2B3F");
    user.setProfileBackgroundImageURL(TestUtils.getResourceURL("background"));
    
    Twitter twitter = new MockTwitter( user );
    AsyncTwitter asyncTwitter = new ConcreteMockAsyncTwitter();
    TwitterControl.setupTwitter( twitter, asyncTwitter);
    
    HomePage homePage;
    
    homePage = new HomePage( shell, 1200, 660, 300, 56, 520, null, null, null);
    assertNotNull(homePage);
    
    homePage = new HomePage( shell, 100, 1000, 1000, 1000, 1000, null, null, null);
    assertNotNull(homePage);
    
    List<Status> tweets = new ArrayList<Status>();
    homePage.showTweetsList(tweets);
    
    
    //Event
    Event event;
    MouseEvent e;
    
    event = new Event();
    event.widget = shell;
    e = new MouseEvent(event);
    
    
    homePage.tweetsListBackClicked(e);
    homePage.tweetsListNextClicked(e);
    
    shell.dispose();
    display.dispose();
  
 
  }

}
