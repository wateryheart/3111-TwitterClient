package hk.ust.cse.TwitterClient.Controls;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chrischeung
 * Date: 4/4/13
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class RetweetControl {
    public static Status retweetHandler (Status tweet) {
        if(tweet.isRetweetedByMe()) {
            System.out.println("destory retweet: " + tweet.getId());
            return destoryRetweetedStatus(tweet);
        }
        else {
            System.out.println("retweet: " + tweet.getId());
            return retweetStatus(tweet);
        }
    }

    public static Status retweetTimeLineHandler (Status tweet) {
        if(tweet.isRetweetedByMe()) {
            try {
            Twitter twitter = new TwitterFactory().getInstance();
            return destoryRetweetedStatus(twitter.showStatus(getRetweetID(tweet)));
            }catch (TwitterException te){}
        }else {
            return retweetStatus(tweet);
        }
        return null;
    }

    private static Status retweetStatus (Status tweet) {
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            tweet = twitter.retweetStatus(tweet.getId());
        }
        catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to retweet: " + te.getMessage());
        }
        return tweet;
    }

    //TODO still can't remove the teddy bear retweet, no idea wts going on
    private static Status destoryRetweetedStatus (Status tweet) {
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            tweet = twitter.destroyStatus(tweet.getId());
        }
        catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to remove retweet: " + te.getMessage());
        }
        return tweet;
    }


    // get the user retweeted status id from the status id
    public static long getRetweetID (Status linkedStatus) {
        try {
            /* get first 100 retweets by authorizating user, and compare its original status id with desired status id. This method may not work for user with 100+ retweets*/
            Twitter twitter = new TwitterFactory().getInstance();
            List<Status> retweets = twitter.getRetweets(linkedStatus.getId());
            for (Status retweet : retweets) {
                if(retweet.getRetweetedStatus().getId() == linkedStatus.getId()){
                    return retweet.getId();
                }
            }
        }
        catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get retweets: " + te.getMessage());
        }
        System.out.println("Failed to get retweet ID");
        return -1;
    }

    // twitter4j's isRetweetedByMe is not working somehow
    public static boolean isRetweetedByMe (Status tweet) {
        if(tweet.getRetweetCount() > 0)
            return getRetweetID(tweet) > 0;
        return false;
    }
}
