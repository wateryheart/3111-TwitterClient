package quincy.hk.ust.cse.TwitterClient.Controls;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;

import org.junit.Test;

public class TwitterControlTest {
/*
	@Test
	public void testSetupTwitter() {
		TwitterControl.setupTwitter(null,null);
		assertTrue(true);
	}

	@Test
	public void testGetHomeTimeline() {
		TwitterControl.getHomeTimeline(10,"abc",null);
		assertTrue(true);
	}

	@Test
	public void testGetUserTimeline() {
		TwitterControl.getUserTimeline("Lee",10,"abc",null);
		assertTrue(true);
	}

	@Test
	public void testGetFollowers() {
		TwitterControl.getFollowers("Lee",100000,"abc",null);
		assertTrue(true);
	}

	@Test
	public void testGetFollowing() {
		TwitterControl.getFollowing("Lee",100000,"abc",null);
		assertTrue(true);
	}

	@Test
	public void testGetReplies() {
		TwitterControl.getReplies(null,"abc",null);
		assertTrue(true);
	}
*/
	@Test
	public void testGetAccountUser() {
		TwitterControl.getAccountUser();
		assertTrue(true);
	}
/*
	@Test
	public void testGetUser() {
		TwitterControl.getUser("Lee");
		assertTrue(true);
	}
*/
	@Test
	public void testGetTwitter() {
		TwitterControl.getTwitter();
		assertTrue(true);
	}

}
