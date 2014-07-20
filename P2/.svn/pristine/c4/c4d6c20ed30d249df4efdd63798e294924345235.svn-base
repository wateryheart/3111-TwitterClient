package martin.test.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.ITextFeature;
import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.TweetFeatureFactory;
import hk.ust.cse.TwitterClient.Views.WholePage;
import martin.test.hk.ust.cse.TwitterClient.Mocks.*;
import martin.test.utils.TestUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Ignore;
import org.junit.Test;
import twitter4j.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: MARTIN
 * Date: 4/8/13
 * Time: 2:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class TweetFeatureFactoryTest{
    @Test(timeout = 10000)
    public void simpleTest() throws TwitterException {

        Display display = new Display();
        Shell shell = new Shell(display);

        SetupMockUserTwitter();

        WholePage wholePage = new WholePage(shell, 10, 10);
        assertNotNull( wholePage );

        MockUser user = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
        user.setProfileImageURL(TestUtils.getResourceURL("logo.png"));
        user.setProfileBackgroundColor("1A1B1F");
        user.setProfileBackgroundImageURL(TestUtils.getResourceURL("background"));
        user.setCreatedAt(new Date());

        Status tweet = new ConcreteMockStatus(user, "", createURLEntities(), null);

        TweetFeatureFactory factory = new TweetFeatureFactory(tweet, wholePage);
        ITextFeature tf;
        tf = factory.Create("Link");
        assertNotNull(tf);
        tf = factory.Create("Mentions");
        assertNotNull(tf);
        //tf = factory.Create("Tags");
        //assertNotNull(tf);

        tf = factory.Create("NOT THING");
        assertNull(tf);
        tf = factory.Create(null);
        assertNull(tf);

    }

    public void SetupMockUserTwitter(){
        MockUser user  = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
        user.setProfileBackgroundColor("1A2B3F");
        user.setProfileBackgroundImageURL(TestUtils.getResourceURL("background"));

        Twitter twitter = new MockTwitter( user );
        AsyncTwitter asyncTwitter = new ConcreteMockAsyncTwitter();
        TwitterControl.setupTwitter(twitter, asyncTwitter);
    }

    @Ignore
    public URLEntity[] createURLEntities(){

        String DisplayURL = "dev.twitter.com/blog/introduci";
        String URL = "https://t.co/zdgxk4kTx9";
        String ExpandedURL = "https://dev.twitter.com/blog/introducing-new-metadata-for-tweets";
        List<URLEntity> urlEntities = new ArrayList<URLEntity>();

        MockURLEntity mockURLEntity = new MockURLEntity();
        mockURLEntity.setDisplayURL(DisplayURL);
        mockURLEntity.setExpandedURL(ExpandedURL);
        mockURLEntity.setURL(URL);

        assertNotNull(mockURLEntity);
        assertEquals( DisplayURL, mockURLEntity.getDisplayURL() );
        assertEquals( ExpandedURL, mockURLEntity.getExpandedURL() );
        assertEquals( URL, mockURLEntity.getURL() );

        urlEntities.add(mockURLEntity);
        return  urlEntities.toArray(new URLEntity[urlEntities.size()]);

    }
}
