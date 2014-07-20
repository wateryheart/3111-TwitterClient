package hk.ust.cse.TwitterClient.Controls;

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
            te.printStackTrace();
            System.out.println("Failed to favourite status: " + te.getMessage());
        }
    }
    private static void destroyFavorite(Status tweet) {
        try{
            Twitter twitter = new TwitterFactory().getInstance();
            tweet = twitter.destroyFavorite(tweet.getId());
        }
        catch (TwitterException te){
            te.printStackTrace();
            System.out.println("Failed to unmark favourite status: " + te.getMessage());
        }
    }
}
