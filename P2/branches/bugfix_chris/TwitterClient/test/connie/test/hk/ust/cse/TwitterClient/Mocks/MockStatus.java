package connie.test.hk.ust.cse.TwitterClient.Mocks;

import java.util.Date;

import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.Place;
import twitter4j.RateLimitStatus;
import twitter4j.Status;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.UserMentionEntity;

@SuppressWarnings("serial")
public class MockStatus implements Status{
	@Override
	public int compareTo(Status o) {
		// TODO Auto-generated method stub
		return 0;
	}

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
	public HashtagEntity[] getHashtagEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MediaEntity[] getMediaEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URLEntity[] getURLEntities() {
		// TODO Auto-generated method stub
		MockURLEntity[] myURLE = {new MockURLEntity()};
		return myURLE;
	}

	@Override
	public UserMentionEntity[] getUserMentionEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long[] getContributors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreatedAt() {
		// TODO Auto-generated method stub
		return new Date();
	}

	@Override
	public long getCurrentUserRetweetId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GeoLocation getGeoLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getInReplyToScreenName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getInReplyToStatusId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getInReplyToUserId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Place getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getRetweetCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Status getRetweetedStatus() {
		// TODO Auto-generated method stub
		return new MockStatus();
		
	}

	@Override
	public String getSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "Text";
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return new MockUser("friend","ScreenName",true,"description");
	}

	@Override
	public boolean isFavorited() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPossiblySensitive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRetweet() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRetweetedByMe() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTruncated() {
		// TODO Auto-generated method stub
		return false;
	}

}
