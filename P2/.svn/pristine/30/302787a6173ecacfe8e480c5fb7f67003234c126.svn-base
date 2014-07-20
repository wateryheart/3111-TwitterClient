package connie.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.TwitterClient.Views.TweetsList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import twitter4j.Status;
import twitter4j.json.DataObjectFactory;

public class TweetsListTest {

	@Test(timeout=10000)
	public void testTweetsList() throws Throwable{
		Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    Status status;
	    status = DataObjectFactory.createStatus("{\"text\":\"\\\\u5e30%u5e30 &lt;%}& foobar &lt;&Cynthia&gt;\",\"contributors\":null,\"geo\":null,\"retweeted\":false,\"in_reply_to_screen_name\":null,\"truncated\":false,\"entities\":{\"urls\":[],\"hashtags\":[],\"user_mentions\":[]},\"in_reply_to_status_id_str\":null,\"id\":12029015787307008,\"in_reply_to_user_id_str\":null,\"source\":\"web\",\"favorited\":false,\"in_reply_to_status_id\":null,\"in_reply_to_user_id\":null,\"created_at\":\"Tue Dec 07 06:21:55 +0000 2010\",\"retweet_count\":0,\"id_str\":\"12029015787307008\",\"place\":null,\"user\":{\"location\":\"location:\",\"statuses_count\":13405,\"profile_background_tile\":false,\"lang\":\"en\",\"profile_link_color\":\"0000ff\",\"id\":6358482,\"following\":true,\"favourites_count\":2,\"protected\":false,\"profile_text_color\":\"000000\",\"contributors_enabled\":false,\"description\":\"Hi there, I do test a lot!new\",\"verified\":false,\"profile_sidebar_border_color\":\"87bc44\",\"name\":\"twit4j\",\"profile_background_color\":\"9ae4e8\",\"created_at\":\"Sun May 27 09:52:09 +0000 2007\",\"followers_count\":24,\"geo_enabled\":true,\"profile_background_image_url\":\"http://a3.twimg.com/profile_background_images/179009017/t4j-reverse.gif\",\"follow_request_sent\":false,\"url\":\"http://yusuke.homeip.net/twitter4j/\",\"utc_offset\":-32400,\"time_zone\":\"Alaska\",\"notifications\":false,\"friends_count\":4,\"profile_use_background_image\":true,\"profile_sidebar_fill_color\":\"e0ff92\",\"screen_name\":\"twit4j\",\"id_str\":\"6358482\",\"profile_image_url\":\"http://a3.twimg.com/profile_images/1184543043/t4j-reverse_normal.jpeg\",\"show_all_inline_media\":false,\"listed_count\":3},\"coordinates\":null}");
	    List<Status> list = new ArrayList <Status>();
	    list.add(status); 
	    TweetsList tweetsList = new TweetsList(shell, list, 100,"test", null, "back", null, "next", null);	
	    assertNotNull(tweetsList);
	    assertEquals(100, tweetsList.getBounds().width);
	    tweetsList.dispose();
	    
	    status = DataObjectFactory.createStatus("{\"text\":\"\\\\u5e30%u5e30 &lt;%}& foobar &lt;&Cynthia&gt;\",\"contributors\":null,\"geo\":null,\"retweeted\":false,\"in_reply_to_screen_name\":null,\"truncated\":false,\"entities\":{\"urls\":[],\"hashtags\":[],\"user_mentions\":[]},\"in_reply_to_status_id_str\":null,\"id\":12029015787307008,\"in_reply_to_user_id_str\":null,\"source\":\"web\",\"favorited\":false,\"in_reply_to_status_id\":null,\"in_reply_to_user_id\":null,\"created_at\":\"Tue Dec 07 06:21:55 +0000 2010\",\"retweet_count\":0,\"id_str\":\"12029015787307008\",\"place\":null,\"user\":{\"location\":\"location:\",\"statuses_count\":13405,\"profile_background_tile\":false,\"lang\":\"en\",\"profile_link_color\":\"0000ff\",\"id\":6358482,\"following\":true,\"favourites_count\":2,\"protected\":false,\"profile_text_color\":\"000000\",\"contributors_enabled\":false,\"description\":\"Hi there, I do test a lot!new\",\"verified\":false,\"profile_sidebar_border_color\":\"87bc44\",\"name\":\"twit4j\",\"profile_background_color\":\"9ae4e8\",\"created_at\":\"Sun May 27 09:52:09 +0000 2007\",\"followers_count\":24,\"geo_enabled\":true,\"profile_background_image_url\":\"http://a3.twimg.com/profile_background_images/179009017/t4j-reverse.gif\",\"follow_request_sent\":false,\"url\":\"http://yusuke.homeip.net/twitter4j/\",\"utc_offset\":-32400,\"time_zone\":\"Alaska\",\"notifications\":false,\"friends_count\":4,\"profile_use_background_image\":true,\"profile_sidebar_fill_color\":\"e0ff92\",\"screen_name\":\"twit4j\",\"id_str\":\"6358482\",\"profile_image_url\":\"http://a3.twimg.com/profile_images/1184543043/t4j-reverse_normal.jpeg\",\"show_all_inline_media\":false,\"listed_count\":3},\"coordinates\":null}");
	    list = null;
	    tweetsList = new TweetsList(shell, list, 100,"test", null, "back", null, "next", null);	
	    assertNotNull(tweetsList);
	    Event e = new Event();
	    tweetsList.notifyListeners(0, e);
	    shell.dispose();
	    display.dispose();
	}

}
