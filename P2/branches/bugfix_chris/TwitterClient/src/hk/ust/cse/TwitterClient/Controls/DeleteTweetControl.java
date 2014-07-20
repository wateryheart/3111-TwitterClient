package hk.ust.cse.TwitterClient.Controls;



import org.apache.log4j.Logger;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class DeleteTweetControl {
    private static final Logger logger = Logger.getLogger(DeleteTweetControl.class);

    public static Status deleteTweetHandler (Status tweet) {
          return deleteStatus(tweet);
        
    }

    private static Status deleteStatus (Status tweet) {
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            tweet = twitter.destroyStatus(tweet.getId());
        }
        catch (TwitterException te) {
            te.printStackTrace();
            logger.error("Failed to delete tweet.", te);
        }
        return tweet;
    }
}


    