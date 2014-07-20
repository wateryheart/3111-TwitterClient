package chris.test.hk.ust.cse.TwitterClient.Controls;

import hk.ust.cse.TwitterClient.Controls.RetweetControl;
import junit.framework.Assert;
import org.junit.Test;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

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
        final long testID = 313421863697141761l;   //Status by osiutino

        Twitter twitter = new TwitterFactory().getInstance();
        Status tweet = twitter.showStatus(testID);

        boolean expected = !RetweetControl.isRetweetedByMe(tweet);
        tweet = RetweetControl.retweetHandler(tweet);

        long retweetID = RetweetControl.getRetweetID(tweet);

        // retweeted Status, check the status is retweeted or not
        if(retweetID > -1){
            Status retweet = twitter.showStatus(retweetID);
            Assert.assertEquals(expected, RetweetControl.isRetweetedByMe(retweet));
        }
        // unretweeted
        else{
            Assert.assertEquals(true, retweetID == -1);
        }

    }
}
