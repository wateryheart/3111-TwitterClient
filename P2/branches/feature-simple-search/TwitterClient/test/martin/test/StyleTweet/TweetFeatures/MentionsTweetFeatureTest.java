package martin.test.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.HashTagTweetFeature;
import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.ITextFeature;
import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.MentionsTweetFeature;
import org.eclipse.swt.widgets.Event;
import org.junit.Test;
import twitter4j.HashtagEntity;
import twitter4j.UserMentionEntity;

/**
 * Created with IntelliJ IDEA.
 * User: MARTIN
 * Date: 4/12/13
 * Time: 7:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class MentionsTweetFeatureTest {
    @Test(timeout = 10000)
    public void simpleTest(){

        ITextFeature textFeature;


        textFeature = new MentionsTweetFeature(null, null);
        textFeature.BuildData(null);
        textFeature.eventHandle(null);

        UserMentionEntity[] entities = new UserMentionEntity[1];
        entities[0] = new UserMentionEntity() {
            @Override
            public String getName() {
                return "";  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public String getScreenName() {
                return "";  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public long getId() {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public int getStart() {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public int getEnd() {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        Event event = new Event();


        textFeature = new MentionsTweetFeature(entities, new Object());
        textFeature.BuildData("");
        textFeature.eventHandle(event);
    }

}
