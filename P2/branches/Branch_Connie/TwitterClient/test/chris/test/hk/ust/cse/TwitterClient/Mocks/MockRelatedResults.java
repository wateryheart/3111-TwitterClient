package chris.test.hk.ust.cse.TwitterClient.Mocks;

import twitter4j.RateLimitStatus;
import twitter4j.RelatedResults;
import twitter4j.ResponseList;
import twitter4j.Status;

public class MockRelatedResults implements RelatedResults {

	private ResponseList<Status> m_TweetsWithConversation;

	@Override
	public int getAccessLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RateLimitStatus getRateLimitStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getTweetsFromUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getTweetsWithConversation() {
		// TODO Auto-generated method stub
		return m_TweetsWithConversation;
	}
	public void setTweetsWithConversation(ResponseList<Status> value) {
		// TODO Auto-generated method stub
		m_TweetsWithConversation = value;
	}
	
	@Override
	public ResponseList<Status> getTweetsWithReply() {
		// TODO Auto-generated method stub
		return null;
	}

}
