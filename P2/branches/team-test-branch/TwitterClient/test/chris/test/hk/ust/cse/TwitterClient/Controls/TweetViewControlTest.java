package chris.test.hk.ust.cse.TwitterClient.Controls;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Controls.TweetViewControl;
import hk.ust.cse.TwitterClient.Views.ControlBar;
import hk.ust.cse.TwitterClient.Views.ListView;
import hk.ust.cse.TwitterClient.Views.NumberBar;
import hk.ust.cse.TwitterClient.Views.NumberBarItem;
import hk.ust.cse.TwitterClient.Views.TweetView;

import martin.test.hk.ust.cse.TwitterClient.Mocks.ConcreteMockStatus;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockRelatedResults;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockResponseList;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockURLEntity;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import martin.test.utils.TestUtils;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Ignore;
import org.junit.Test;

import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.Place;
import twitter4j.RateLimitStatus;
import twitter4j.Status;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.UserMentionEntity;

public class TweetViewControlTest {

	 @Test(timeout=10000)
	  public void testConstructor() throws Throwable {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    long number = -1;
	    String title = "mytitle";
	   
	    Status tweet;
	    MockUser user;
	    
	    //------------------------------------------------------------------------------
	    user = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");	    
	    user.setProfileImageURL(TestUtils.getResourceURL("logo.png"));
	    user.setCreatedAt(new Date());

	    TweetView tweetView;
	    TweetViewControl tweetViewControl;
	    // ------Q-----------------------------------------------------------------
	    //1st. create a tweetView
	    tweet = new ConcreteMockStatus(user, "", createURLEntities(), null);
	    tweetView = new TweetView( shell, tweet, 10, false,
	    		null, null, null, // Color
	    		null,null);	// Font
	    
	    assertNotNull(tweetView);
	   	
	    user.setProfileImageURL(null);
	    user.setCreatedAt(new Date());

	    //2nd. create a TweetViewControl using the tweetView instance
	    tweetViewControl = new TweetViewControl ( tweetView );
	    assertNotNull( tweetViewControl );
	    
	    // -----------------------------------------------------------------------	   
	    //1st. create a tweetView
	    tweet = new ConcreteMockStatus(user, "", createURLEntities(), null);
	    tweetView = new TweetView( shell, tweet, 10, true,
	    		null, null, null, // Color
	    		null,null); // Font
	    
	    assertNotNull(tweetView);
	    
	    List<Status> replies = new ArrayList<Status>();
	    replies.add(new ConcreteMockStatus(user, "", createURLEntities(), tweet));
	    tweetView.showReplies(replies);
	    
	    tweet = tweetView.getTweet();

	    //2nd. create a TweetViewControl using the tweetView instance
	    tweetViewControl = new TweetViewControl ( tweetView );
	    assertNotNull( tweetViewControl );
	    
	    //3rd. test TweetViewControl.getRepliesCallback function
	    MockResponseList<Status> mockResponseList = new MockResponseList<Status>();
	    MockRelatedResults mockRelatedResults = new MockRelatedResults();
	    mockRelatedResults.setTweetsWithConversation(mockResponseList);
	    tweetViewControl.getRepliesCallback((Object)mockRelatedResults);
	    // -----------------------------------------------------------------------	    	    
	    shell.dispose();

	  }
	 
		@Ignore
		public URLEntity[] createURLEntities(){
			
			String DisplayURL = "dev.twitter.com/blog/introduci";
			String URL = "https://t.co/zdgxk4kTx9";
			String ExpandedURL = "https://dev.twitter.com/blog/introducing-new-metadata-for-tweets";
			 List<URLEntity> urlEntities = new ArrayList<URLEntity>();
			 
			 MockURLEntity mockURLEntity = new MockURLEntity();
			 mockURLEntity.setDisplayURL(DisplayURL);
			 mockURLEntity.setExpandedURL(ExpandedURL);
			 mockURLEntity.setURL(URL);
			 
			 assertNotNull(mockURLEntity);
			 assertEquals( DisplayURL, mockURLEntity.getDisplayURL() );
			 assertEquals( ExpandedURL, mockURLEntity.getExpandedURL() );
			 assertEquals( URL, mockURLEntity.getURL() );
			 
			 urlEntities.add(mockURLEntity);
			 return  urlEntities.toArray(new URLEntity[urlEntities.size()]);
		
		}
	
}
