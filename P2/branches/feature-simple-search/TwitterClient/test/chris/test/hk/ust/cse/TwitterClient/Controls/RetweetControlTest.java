package chris.test.hk.ust.cse.TwitterClient.Controls;

import hk.ust.cse.TwitterClient.Controls.RetweetControl;
import junit.framework.Assert;
import org.junit.Test;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: chrischeung
 * Date: 4/5/13
 * Time: 6:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class RetweetControlTest {

    @Test
    public void testRetweetHandler() throws Exception {
        long testID = 313421863697141761l;   //Status by osiutino
        boolean expected = true;
        Twitter twitter = new TwitterFactory().getInstance();
        Status tweet = twitter.showStatus(testID);
        Assert.assertNotNull(new RetweetControl());
        Assert.assertFalse(RetweetControl.isRetweetedByMe(mock(Status.class)));

        Assert.assertTrue(RetweetControl.isRetweetedByMe(tweet));   //is in my retweet list?
        long retweetId = RetweetControl.getRetweetID(tweet);
        Status retweet = twitter.showStatus(retweetId);
        Assert.assertEquals(retweet.getRetweetedStatus(), tweet);   //check retweeted status is the same as tweet

        Status mockTweet= mock(Status.class);
        when(mockTweet.isRetweetedByMe()).thenReturn(true);
        try { RetweetControl.retweetHandler(mockTweet); } catch(Exception te){Assert.assertNotNull(te);}
        try {RetweetControl.retweetTimeLineHandler(mockTweet); } catch(Exception te){Assert.assertNotNull(te);}
        when(mockTweet.isRetweetedByMe()).thenReturn(false);
        try { RetweetControl.retweetHandler(mockTweet); } catch(Exception te){Assert.assertNotNull(te);}
        try {RetweetControl.retweetTimeLineHandler(mockTweet); } catch(Exception te){Assert.assertNotNull(te);}

        Assert.assertFalse(RetweetControl.isRetweetedByMe(mockTweet));

    }
}
