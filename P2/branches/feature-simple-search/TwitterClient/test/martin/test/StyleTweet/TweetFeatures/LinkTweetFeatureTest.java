package martin.test.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.ITextFeature;
import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.LinkTweetFeature;
import org.eclipse.swt.widgets.Event;
import org.junit.Test;
import twitter4j.URLEntity;

/**
 * Created with IntelliJ IDEA.
 * User: MARTIN
 * Date: 4/12/13
 * Time: 7:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class LinkTweetFeatureTest {

    @Test(timeout = 10000)
    public void simpleTest(){

        ITextFeature textFeature;


        textFeature = new LinkTweetFeature(null);
        textFeature.BuildData(null);
        textFeature.eventHandle(null);

        URLEntity[] entities = new URLEntity[1];
        entities[0] = new URLEntity() {
            @Override
            public String getURL() {
                return  "";
            }

            @Override
            public String getExpandedURL() {
                return null;
            }

            @Override
            public String getDisplayURL() {
                return null;
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


        textFeature = new LinkTweetFeature(entities);
        textFeature.BuildData("");
        textFeature.eventHandle(event);
    }

}
