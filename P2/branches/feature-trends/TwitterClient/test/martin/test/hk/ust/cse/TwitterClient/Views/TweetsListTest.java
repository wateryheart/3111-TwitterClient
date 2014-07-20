package martin.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import connie.test.hk.ust.cse.TwitterClient.Mocks.MockAsyncTwitter;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockTwitter;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Views.TweetsList;

import martin.test.hk.ust.cse.TwitterClient.Mocks.ConcreteMockStatus;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockURLEntity;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Ignore;
import org.junit.Test;

import twitter4j.Status;
import twitter4j.URLEntity;

public class TweetsListTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    MockUser user;
    
    //------------------------------------------------------------------------------
    user = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");	    

    List<Status> tweets = new ArrayList<Status>();
    Status tweet1 = new ConcreteMockStatus( user, "", createURLEntities(), null);
    Status tweet2 = new ConcreteMockStatus( user, "", createURLEntities(), tweet1);
    
    tweets.add(tweet1);
    tweets.add( tweet2 );

    TweetsList tweetsList;
    try{
        tweetsList = new TweetsList( shell, tweets, 10,
    		null, null, null, null, null, null);
    }catch (RuntimeException ex){
        assertNotNull(ex);
    }

    MockTwitter twitter = new MockTwitter();
    MockAsyncTwitter AsyncTwitter = new MockAsyncTwitter();
    TwitterControl.setupTwitter(twitter, AsyncTwitter);
    assertSame(twitter, TwitterControl.getTwitter());

    tweetsList = new TweetsList( shell, tweets, 10,
              null, null, null, null, null, null);
    assertNotNull( tweetsList );
    
    tweetsList = new TweetsList( shell, null, 10, 
    		null, null, null, null, null, null);
   
    assertNotNull( tweetsList );
    
    shell.dispose();
    display.dispose();
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
