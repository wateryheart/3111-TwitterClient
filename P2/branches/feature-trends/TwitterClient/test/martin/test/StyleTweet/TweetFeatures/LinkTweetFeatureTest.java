package martin.test.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.ITextFeature;
import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.LinkTweetFeature;
import org.eclipse.swt.widgets.Event;
import org.junit.Test;
import twitter4j.MediaEntity;
import twitter4j.URLEntity;
import java.util.Map;

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


        textFeature = new LinkTweetFeature(null,null);
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
        MediaEntity[] mediaEntities = new MediaEntity[1];
        mediaEntities[0] = new MediaEntity(){

                @Override
                public long getId() {
                    return 0;  //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public String getMediaURL() {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public String getMediaURLHttps() {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public Map<Integer, Size> getSizes() {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public String getType() {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public String getURL() {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public String getExpandedURL() {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public String getDisplayURL() {
                    return null;  //To change body of implemented methods use File | Settings | File Templates.
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


        textFeature = new LinkTweetFeature(entities,mediaEntities);
        textFeature.BuildData("");
        textFeature.eventHandle(event);
    }

}
