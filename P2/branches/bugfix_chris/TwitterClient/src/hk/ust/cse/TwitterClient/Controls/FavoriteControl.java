package hk.ust.cse.TwitterClient.Controls;

import org.apache.log4j.Logger;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * Created with IntelliJ IDEA.
 * User: chrischeung
 * Date: 4/4/13
 * Time: 6:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class FavoriteControl {
    private static final Logger logger = Logger.getLogger(FavoriteControl.class);

    public static void favoriteHandler(Status tweet) {
    if (tweet.isFavorited()){
        destroyFavorite(tweet);
    }
    else{
        makeFavorite(tweet);
    }
}
    private static void makeFavorite(Status tweet) {
        try{
            Twitter twitter = new TwitterFactory().getInstance();
            tweet = twitter.createFavorite(tweet.getId());
        }
        catch(TwitterException te) {
            logger.error("Failed to favourite status.", te);
        }
    }
    private static void destroyFavorite(Status tweet) {
        try{
            Twitter twitter = new TwitterFactory().getInstance();
            tweet = twitter.destroyFavorite(tweet.getId());
        }
        catch (TwitterException te){
            logger.error("Failed to unmark favourite status.", te);
        }
    }
}
