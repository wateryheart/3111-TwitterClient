package park.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import hk.ust.cse.TwitterClient.Views.TweetsList;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TweetsListTest {
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

    List<Status> statuses = twitter.getHomeTimeline();
    
    TweetsList tweetsList = new TweetsList(shell, statuses, 10, null, null, null, null, null, null);
    TweetsList tweetsList1 = new TweetsList(shell, null, 10, null, null, null, null, null, null);
    assertNotNull(tweetsList);
    assertNotNull(tweetsList1);

    shell.dispose();
    display.dispose();
  }
}