package connie.test.hk.ust.cse.TwitterClient.Controls;

import hk.ust.cse.TwitterClient.Controls.UserPageControl;

import org.junit.Test;

import connie.test.hk.ust.cse.TwitterClient.Mocks.MockPagableResponseList;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockResponseList;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockStatus;

import twitter4j.Status;

public class UserPageControlTest {

	@Test(timeout=10000)
	public void testUserPageControl() throws Throwable{
		UserPageControl upc = new UserPageControl(null);
		MockResponseList<Status> rl = new MockResponseList<Status>();
		MockPagableResponseList<Status> prl = new MockPagableResponseList<Status>();
		MockStatus status = new MockStatus();
		rl.add(status);
		prl.add(status);
		upc.showFollowersListCallback(null);
		upc.showFollowersListCallback(rl);
		upc.showFollowingListCallback(null);
		upc.showTweetsListCallback(prl);
		upc.showTweetsListCallback(null);
	}
}
