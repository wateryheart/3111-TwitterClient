package martin.test.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.HashTagTweetFeature;
import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.ITextFeature;
import org.eclipse.swt.widgets.Event;
import org.junit.Test;
import twitter4j.HashtagEntity;

/**
 * Created with IntelliJ IDEA.
 * User: MARTIN
 * Date: 4/12/13
 * Time: 7:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class HashTagTweetFeatureTest {
    @Test(timeout = 10000)
    public void simpleTest(){

        ITextFeature textFeature;


        textFeature = new HashTagTweetFeature(null, null);
        textFeature.BuildData(null);
        textFeature.eventHandle(null);

        HashtagEntity[] hashtagEntities = new HashtagEntity[1];
        hashtagEntities[0] = new HashtagEntity() {
            @Override
            public String getText() {
                return "";
            }

            @Override
            public int getStart() {
                return 0;
            }

            @Override
            public int getEnd() {
                return 0;
            }
        };

        Event event = new Event();


        textFeature = new HashTagTweetFeature(hashtagEntities, new Object());
        textFeature.BuildData("");
        textFeature.eventHandle(event);
    }

}
