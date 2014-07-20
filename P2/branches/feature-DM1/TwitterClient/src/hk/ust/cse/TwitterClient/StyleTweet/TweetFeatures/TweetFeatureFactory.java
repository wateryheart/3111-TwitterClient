package hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures;

import twitter4j.Status;

/**
 * @author Chan Ka Yue Martin
 */

public class TweetFeatureFactory {
    private Status tweet;

    private Object handlerCallee;
    public TweetFeatureFactory(Status m_tweet, Object m_handlerCallee) {
        tweet = m_tweet;
        handlerCallee = m_handlerCallee;
    }

    public ITextFeature Create(String tweetFeature) {
        if(tweetFeature != null) {
            if (tweetFeature.equals("Link")) {
                return new LinkTweetFeature(tweet.getURLEntities(),tweet.getMediaEntities());
            } else if (tweetFeature.equals("Mentions")) {
                return new MentionsTweetFeature(tweet.getUserMentionEntities(),handlerCallee);
            } else if (tweetFeature.equals("HashTag")) {
                return new HashTagTweetFeature(tweet.getHashtagEntities(), handlerCallee);
            }
        }
        return null;
    }
}
