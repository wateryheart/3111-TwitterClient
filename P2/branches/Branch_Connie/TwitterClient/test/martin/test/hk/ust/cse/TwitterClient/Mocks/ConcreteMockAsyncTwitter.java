package martin.test.hk.ust.cse.TwitterClient.Mocks;

import twitter4j.TwitterListener;

public class ConcreteMockAsyncTwitter extends AstractMockAsyncTwitter {

	public TwitterListener  getListener(){
		return this.twitterListener;
	}
}
