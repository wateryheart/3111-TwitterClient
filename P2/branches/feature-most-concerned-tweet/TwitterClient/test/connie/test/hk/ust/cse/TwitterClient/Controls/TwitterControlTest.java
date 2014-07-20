package connie.test.hk.ust.cse.TwitterClient.Controls;


import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;

import org.junit.Test;

import connie.test.hk.ust.cse.TwitterClient.Mocks.MockAsyncTwitter;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockStatus;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockTwitter;

import twitter4j.TwitterException;

public class TwitterControlTest {

	@Test(timeout=10000)
	public void testSetupTwitter() throws TwitterException {
		TwitterControl TC = new TwitterControl();
		MockTwitter twitter = new MockTwitter();
		MockAsyncTwitter AsyncTwitter = new MockAsyncTwitter();
		TwitterControl.setupTwitter(twitter, AsyncTwitter);
		assertSame(twitter, TwitterControl.getTwitter());
		TwitterControl.getAccountUser();
		TwitterControl.getFollowers("screenName", 12345678, "callback", null);
		TwitterControl.getFollowing("screenName", 12345678, "callback", null);
	    MockStatus status = new MockStatus();
		TwitterControl.getReplies(status, "TEST", null);
		
		TwitterControl.getTwitter();
		TwitterControl.getUser("screenName");
		TwitterControl.getUserTimeline("screenName", 1, "callback", null);
		//TwitterControl.getHomeTimeline(0, "callback", null);
		
		
		
	}
}
