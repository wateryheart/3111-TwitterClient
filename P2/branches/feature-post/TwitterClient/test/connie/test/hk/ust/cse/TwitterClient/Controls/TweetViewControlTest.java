package connie.test.hk.ust.cse.TwitterClient.Controls;

import static org.junit.Assert.*;

import connie.test.hk.ust.cse.TwitterClient.Mocks.MockAsyncTwitter;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockTwitter;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import hk.ust.cse.TwitterClient.Controls.TweetViewControl;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.TweetView;

import martin.test.hk.ust.cse.TwitterClient.Mocks.ConcreteMockStatus;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import connie.test.hk.ust.cse.TwitterClient.Mocks.MockStatus;

import twitter4j.Status;
import twitter4j.User;
import twitter4j.json.DataObjectFactory;

public class TweetViewControlTest {

	@Test(timeout=10000)
	public void testTweetViewControl() throws Throwable{
		Display display = new Display();
	    Shell shell = new Shell(display);
        Status status = null;
        TweetView tweetView = null;
        TweetViewControl TC = null;
		try{
            status = DataObjectFactory.createStatus("{\"text\":\"\\\\u5e30%u5e30 &lt;%}& foobar &lt;&Cynthia&gt;\",\"contributors\":null,\"geo\":null,\"retweeted\":false,\"in_reply_to_screen_name\":null,\"truncated\":false,\"entities\":{\"urls\":[],\"hashtags\":[],\"user_mentions\":[]},\"in_reply_to_status_id_str\":null,\"id\":12029015787307008,\"in_reply_to_user_id_str\":null,\"source\":\"web\",\"favorited\":false,\"in_reply_to_status_id\":null,\"in_reply_to_user_id\":null,\"created_at\":\"Tue Dec 07 06:21:55 +0000 2010\",\"retweet_count\":0,\"id_str\":\"12029015787307008\",\"place\":null,\"user\":{\"location\":\"location:\",\"statuses_count\":13405,\"profile_background_tile\":false,\"lang\":\"en\",\"profile_link_color\":\"0000ff\",\"id\":6358482,\"following\":true,\"favourites_count\":2,\"protected\":false,\"profile_text_color\":\"000000\",\"contributors_enabled\":false,\"description\":\"Hi there, I do test a lot!new\",\"verified\":false,\"profile_sidebar_border_color\":\"87bc44\",\"name\":\"twit4j\",\"profile_background_color\":\"9ae4e8\",\"created_at\":\"Sun May 27 09:52:09 +0000 2007\",\"followers_count\":24,\"geo_enabled\":true,\"profile_background_image_url\":\"http://a3.twimg.com/profile_background_images/179009017/t4j-reverse.gif\",\"follow_request_sent\":false,\"url\":\"http://yusuke.homeip.net/twitter4j/\",\"utc_offset\":-32400,\"time_zone\":\"Alaska\",\"notifications\":false,\"friends_count\":4,\"profile_use_background_image\":true,\"profile_sidebar_fill_color\":\"e0ff92\",\"screen_name\":\"twit4j\",\"id_str\":\"6358482\",\"profile_image_url\":\"http://a3.twimg.com/profile_images/1184543043/t4j-reverse_normal.jpeg\",\"show_all_inline_media\":false,\"listed_count\":3},\"coordinates\":null}");
            tweetView = new TweetView(shell, status, 10, true, Resources.SPLIT_COLOR, Resources.SPLIT_COLOR, Resources.SPLIT_COLOR, "name", null);
            TC = new TweetViewControl(null);
        }catch (RuntimeException ex){
            assertNotNull(ex);
        }

        MockTwitter twitter = new MockTwitter();
        MockAsyncTwitter AsyncTwitter = new MockAsyncTwitter();
        TwitterControl.setupTwitter(twitter, AsyncTwitter);
        assertSame(twitter, TwitterControl.getTwitter());

        User user = new MockUser("","",true,"");
        status = new ConcreteMockStatus(user, "", null, null);
        tweetView = new TweetView(shell, status, 10, true, Resources.SPLIT_COLOR, Resources.SPLIT_COLOR, Resources.SPLIT_COLOR, "name", null);
        TC = new TweetViewControl(null);
		assertNotNull(TC);
		TC.getRepliesCallback(null);
		TC.getRepliesCallback(status);
		MockStatus s = new MockStatus();
		TC.getRepliesCallback(s);
		tweetView.dispose();
		TweetViewControl.class.getName();
		//TweetViewControl.class.getMethod("Run",null);
	    //shell.dispose();
	    //display.dispose();
	    
	}

}
