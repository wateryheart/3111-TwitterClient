package quincy.hk.ust.cse.TwitterClient.Controls;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Controls.TweetViewControl;

import org.junit.Test;

public class TweetViewControlTest {

	@Test
	public void testTweetViewControl() {
		TweetViewControl tweetViewControl =new TweetViewControl(null);
		assertNotNull(tweetViewControl);
		tweetViewControl.getRepliesCallback(null);
	}

}