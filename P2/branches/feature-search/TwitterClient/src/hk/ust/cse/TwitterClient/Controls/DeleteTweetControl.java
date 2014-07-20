package hk.ust.cse.TwitterClient.Controls;



import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class DeleteTweetControl {
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
            System.out.println("Failed to delete tweet: " + te.getMessage());
        }
        return tweet;
    }
}


    