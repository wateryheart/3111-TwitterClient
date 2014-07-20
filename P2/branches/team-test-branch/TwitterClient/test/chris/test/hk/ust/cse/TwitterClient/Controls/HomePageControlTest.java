package chris.test.hk.ust.cse.TwitterClient.Controls;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.TwitterClient.Controls.HomePageControl;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Views.ControlBar;
import hk.ust.cse.TwitterClient.Views.Home.HomePage;

import martin.test.hk.ust.cse.TwitterClient.Mocks.ConcreteMockAsyncTwitter;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockResponseList;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockTwitter;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import martin.test.utils.TestUtils;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import twitter4j.*;
public class HomePageControlTest {
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
    
    HomePageControl homePageControl = new HomePageControl(homePage);
    assertNotNull(homePageControl);
    
    ResponseList<Status> tweets = new MockResponseList<Status>();
    homePageControl.showTweetsListCallback( (Object) tweets );
    
    shell.dispose();
    
    // a display asyncExec call was in a function homePageControl.showTweetsListCallback. 
    // so we can not dispose it here directly.
    //display.dispose();
  }
}
