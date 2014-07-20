package park.test.hk.ust.cse.TwitterClient.Controls;

import static org.junit.Assert.assertNotNull;

import hk.ust.cse.TwitterClient.Controls.UserPageControl;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Views.User.UserPage;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import park.test.hk.ust.cse.TwitterClient.Mocks.MockUser;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class UserPageControlTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    String CONSUMER_KEY = "m0LSVjOVM8sJK7v9bnuKtQ";
    String CONSUMER_SECRET ="cdrPYrhzmB4YS42M4nBZ1QMP6uq5389AAIKNezZVAM";
    String ACCESSTOKEN="147163880-sfKmPIQMUw0bRR0N5FfrILQEyRr2aBFjRjgTQ6NQ";
    String ACCESSTOKEN_SECRET="JtG4Tv5GCSC7kAVab7i968dvTQJIxXYfnO9yEAfA";
    
    ConfigurationBuilder builder = new ConfigurationBuilder();
    builder.setOAuthConsumerKey(CONSUMER_KEY);
    builder.setOAuthConsumerSecret(CONSUMER_SECRET);
    builder.setOAuthAccessToken(ACCESSTOKEN);
    builder.setOAuthAccessTokenSecret(ACCESSTOKEN_SECRET);
    
    Configuration configuration = builder.build();
    TwitterFactory factory = new TwitterFactory(configuration);
    Twitter twitter = factory.getInstance();
    AsyncTwitterFactory asyncfactory = new AsyncTwitterFactory(configuration);
    AsyncTwitter asyncTwitter = asyncfactory.getInstance();
    
    TwitterControl.setupTwitter(twitter, asyncTwitter);
    ResponseList<Status> result = twitter.getUserTimeline();
    
    PagableResponseList<User> pagable = twitter.getFollowersList("kataruis", 0);
    
    MockUser friend = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    UserPage userPage = new UserPage(shell, friend, "tweets", 100, 10, 10, 10, 10, 10, null, null);

    UserPageControl userPageControl = new UserPageControl(userPage);
    userPageControl.showTweetsListCallback(result);
    userPageControl.showFollowingListCallback(pagable);
    userPageControl.showFollowersListCallback(pagable);
    assertNotNull(userPageControl);

    shell.dispose();
  }
}