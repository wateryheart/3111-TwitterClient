package martin.test.hk.ust.cse.TwitterClient.Views.Home;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import connie.test.hk.ust.cse.TwitterClient.Mocks.MockAsyncTwitter;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockTwitter;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Views.Home.RepliesList;

import java.util.ArrayList;
import java.util.List;

import martin.test.hk.ust.cse.TwitterClient.Mocks.ConcreteMockStatus;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Ignore;
import org.junit.Test;

import twitter4j.Status;
import twitter4j.URLEntity;

public class RepliesListTest{
	
	@Test(timeout=10000)
	public void testConstructor() throws Throwable{
		Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    MockUser user = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
	    
	    List<Status> tweets = new ArrayList<Status>();
	    Status tweet1 = new ConcreteMockStatus(user, "testing1", createURLEntities(), null );
	    Status tweet2 = new ConcreteMockStatus(user, "testing2", createURLEntities(), tweet1 );
	    tweets.add(tweet1);
	    tweets.add(tweet2);
	    
	    RepliesList repliesList;
        try{
	        repliesList = new RepliesList( shell, tweets, 100, null, null );
        }catch (RuntimeException ex){
            assertNotNull(ex);
        }

        MockTwitter twitter = new MockTwitter();
        MockAsyncTwitter AsyncTwitter = new MockAsyncTwitter();
        TwitterControl.setupTwitter(twitter, AsyncTwitter);
        assertSame(twitter, TwitterControl.getTwitter());

        repliesList = new RepliesList( shell, tweets, 100, null, null );
        assertNotNull( repliesList );
	    
	    repliesList = new RepliesList( shell, null, 100, null, null );
	    assertNotNull( repliesList );
	    shell.dispose();
	    display.dispose();		   
	}
	
	@Ignore
	public URLEntity[] createURLEntities(){
		 List<URLEntity> urlEntities = new ArrayList<URLEntity>();
		    urlEntities.add(new URLEntity(){

				@Override
				public String getDisplayURL() {
					// TODO Auto-generated method stub
					return "dev.twitter.com/blog/introduci";
				}

				@Override
				public int getEnd() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public String getExpandedURL() {
					// TODO Auto-generated method stub
					return "https://dev.twitter.com/blog/introducing-new-metadata-for-tweets";
				}

				@Override
				public int getStart() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public String getURL() {
					// TODO Auto-generated method stub
					return "https://t.co/zdgxk4kTx9";
				}
		    	
		    });
		  return  urlEntities.toArray(new URLEntity[urlEntities.size()]);
	}
}