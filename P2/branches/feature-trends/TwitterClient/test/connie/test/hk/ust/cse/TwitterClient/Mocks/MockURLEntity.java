package connie.test.hk.ust.cse.TwitterClient.Mocks;

import twitter4j.URLEntity;

@SuppressWarnings("serial")
public class MockURLEntity implements URLEntity {

	
	@Override
	public String getDisplayURL() {
		// TODO Auto-generated method stub
		return "https://twitter.com/NASA";
	}

	@Override
	public int getEnd() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getExpandedURL() {
		// TODO Auto-generated method stub
		return "https://twitter.com/NASA";
	}

	@Override
	public int getStart() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return "https://twitter.com/NASA";
	}
}
