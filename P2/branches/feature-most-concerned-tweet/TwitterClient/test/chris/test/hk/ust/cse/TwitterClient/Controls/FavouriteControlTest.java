package chris.test.hk.ust.cse.TwitterClient.Controls;
import hk.ust.cse.TwitterClient.Controls.FavoriteControl;
import org.junit.Assert;
import org.junit.Test;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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
        FavoriteControl favControl = new FavoriteControl();
        Assert.assertNotNull(favControl);

        // favorite a tweet, then unfavorite it
        for (int i = 0; i <= 1; i++) {
            Status tweet = twitter.showStatus(testID);  /*get the status from testID*/
            boolean expectedResult = !tweet.isFavorited();  //
            FavoriteControl.favoriteHandler(tweet);   //Toggle the favourite state of the status
            //Now update the status
            tweet = twitter.showStatus(testID);
            Assert.assertEquals(expectedResult, tweet.isFavorited());
            Thread.sleep(2000);
        }
        Status mockTweet = mock(Status.class);
        try{ FavoriteControl.favoriteHandler(mockTweet); }catch(Exception te) {Assert.assertNotNull(te);};
        when(mockTweet.isFavorited()).thenReturn(true);
        try{ FavoriteControl.favoriteHandler(mockTweet); }catch(Exception te) {Assert.assertNotNull(te);};
    }
}
