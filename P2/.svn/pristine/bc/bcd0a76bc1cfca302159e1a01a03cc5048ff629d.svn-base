package chris.test.hk.ust.cse.TwitterClient.Controls;
import hk.ust.cse.TwitterClient.Controls.FavoriteControl;
import org.junit.Assert;
import org.junit.Test;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;



/**
 * Created with IntelliJ IDEA.
 * User: chrischeung
 * Date: 4/4/13
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class FavouriteControlTest {
    @Test
    public void testFavouriteHandler() throws Exception {

        long  testID = 319775401998176257l;
        Twitter twitter = new TwitterFactory().getInstance();

        Status tweet = twitter.showStatus(testID);  /*get the status from testID*/
        boolean expectedResult = !tweet.isFavorited();  //

        FavoriteControl.favoriteHandler(tweet);   //Toggle the favourite state of the status

        //Now update the status
        tweet = twitter.showStatus(testID);
        Assert.assertEquals(expectedResult, tweet.isFavorited());
    }
}
