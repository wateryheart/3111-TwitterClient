package martin.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import connie.test.hk.ust.cse.TwitterClient.Mocks.MockAsyncTwitter;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockTwitter;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Views.TweetView;

import martin.test.hk.ust.cse.TwitterClient.Mocks.ConcreteMockStatus;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockURLEntity;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import martin.test.utils.TestUtils;

import org.eclipse.swt.events.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Ignore;
import org.junit.Test;

import twitter4j.Status;
import twitter4j.URLEntity;

public class TweetViewTest {

	 @Test(timeout=10000)
	  public void testConstructor() throws Throwable {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    long number = -1;
	    String title = "mytitle";
	    //String profileImageURL = TestUtils.getResourceURL("logo.png");
	    
	    Status tweet;
	    MockUser user;
	    TweetView tweetView;
	    
	    //------------------------------------------------------------------------------
	    user = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");	    
	    user.setProfileImageURL("");
	    user.setCreatedAt(new Date());
	    
	    //
	    tweet = new ConcreteMockStatus(user, "", createURLEntities(), null);	    
	     try{
         tweetView = new TweetView( shell, tweet, 10, false,
	    		null, null, null, // Color
	    		null,null);	// Font
         }catch (RuntimeException ex){
             assertNotNull(ex);
         }

         MockTwitter twitter = new MockTwitter();
         MockAsyncTwitter AsyncTwitter = new MockAsyncTwitter();
         TwitterControl.setupTwitter(twitter, AsyncTwitter);
         assertSame(twitter, TwitterControl.getTwitter());

         tweetView = new TweetView( shell, tweet, 10, false,
                 null, null, null, // Color
                 null,null);	// Font

	    assertNotNull(tweetView);
	    	    
	    //
	    user.setProfileImageURL(TestUtils.getResourceURL("logo.png"));
	    user.setCreatedAt(new Date());
	    
	    tweet = new ConcreteMockStatus(user, "", createURLEntities(), null);
	    
	    tweetView = new TweetView( shell, tweet, 10, false,
	    		null, null, null, // Color
	    		null,null);	// Font
	    
	    assertNotNull(tweetView);
	   	
	    //
	    user.setProfileImageURL(null);
	    user.setCreatedAt(new Date());
	   
	    tweet = new ConcreteMockStatus(user, "", createURLEntities(), null);
	    tweetView = new TweetView( shell, tweet, 10, true,
	    		null, null, null, // Color
	    		null,null); // Font
	    
	    assertNotNull(tweetView);
	    
	    
	    //--------------
	    List<Status> replies = new ArrayList<Status>();
	    replies.add(new ConcreteMockStatus(user, "", createURLEntities(), tweet));
	    tweetView.showReplies(replies);
	    
	    tweet = tweetView.getTweet();
	    
	    Event event;
	    MouseEvent e;
	    
	    event = new Event();
	    event.widget = shell;
	    e = new MouseEvent(event);
	    tweetView.toggleExpand(e);
//	    
//	    // -------
//	    
//	    Field m_numberBar_Field = tweetView.getClass().getDeclaredField("m_numberBar");
//	    assertNotNull(m_numberBar_Field);
//	    m_numberBar_Field.setAccessible(true);
//	    NumberBar m_numberBar =(NumberBar) m_numberBar_Field.get(tweetView);
//	    System.out.println("p: " + tweetView.getParent());
//	    assertNotNull(m_numberBar);
//	    // --------
//	    
//	    m_numberBar = null;
//	    tweetView.toggleExpand(e);
	    
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
