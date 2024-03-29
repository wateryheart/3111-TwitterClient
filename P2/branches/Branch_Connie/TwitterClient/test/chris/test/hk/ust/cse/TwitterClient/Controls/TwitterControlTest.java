package chris.test.hk.ust.cse.TwitterClient.Controls;

import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import martin.test.hk.ust.cse.TwitterClient.Mocks.ConcreteMockAsyncTwitter;
import martin.test.hk.ust.cse.TwitterClient.Mocks.ConcreteMockStatus;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockPagableResponseList;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockRelatedResults;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockResponseList;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockTwitter;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockURLEntity;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import martin.test.utils.TestUtils;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Ignore;
import org.junit.Test;

import twitter4j.AsyncTwitter;
import twitter4j.PagableResponseList;
import twitter4j.RelatedResults;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterAdapter;
import twitter4j.TwitterException;
import twitter4j.TwitterMethod;
import twitter4j.URLEntity;
import twitter4j.User;

public class TwitterControlTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    MockUser user  = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    user.setProfileBackgroundColor("1A2B3F");
    user.setProfileBackgroundImageURL(TestUtils.getResourceURL("background"));

//    try{
    	Twitter twitter = new MockTwitter( user );
    	AsyncTwitter asyncTwitter = new ConcreteMockAsyncTwitter();
    	TwitterControl.setupTwitter( twitter, asyncTwitter);
    		
		 Class<?> cls = TwitterControl.class;
		 Constructor<?> c = cls.getDeclaredConstructors()[0];
		 c.setAccessible(true);
		 assertNotNull(c);

		Method method;
		//int page, String callback, Object callee
		method = cls.getDeclaredMethod("getHomeTimeline", int.class, String.class, Object.class);
		method.setAccessible(true);
		assertNotNull(method);
		method.invoke(cls, 1, "", null);
		
		//String screenName, int page, String callback, Object callee
		method = cls.getDeclaredMethod("getUserTimeline", String.class, int.class, String.class, Object.class);
		method.setAccessible(true);
		assertNotNull(method);
		method.invoke(cls, "", 1, "", null);
		
		
		//String screenName, long cursor, String callback, Object callee
		method = cls.getDeclaredMethod("getFollowers", String.class, long.class, String.class, Object.class);
		method.setAccessible(true);
		assertNotNull(method);
		method.invoke(cls,"",(long) 1, "", null);
		
		//String screenName, long cursor, String callback, Object callee
		method = cls.getDeclaredMethod("getFollowing", String.class, long.class, String.class, Object.class);
		method.setAccessible(true);
		assertNotNull(method);
		method.invoke(cls,user.getScreenName(), -1, "", null);
		
		//Status tweet, String callback, Object callee
		method = cls.getDeclaredMethod("getReplies", Status.class, String.class, Object.class);
		method.setAccessible(true);
		assertNotNull(method);
		
		Status tweet = new ConcreteMockStatus(user, "", createURLEntities() , null);
		method.invoke(cls, tweet, "", null);
		
		//
		method = cls.getDeclaredMethod("getAccountUser");
		method.setAccessible(true);
		assertNotNull(method);
		MockUser u = (MockUser)method.invoke(cls);
		assertEquals( user, u);
		
		//
		method = cls.getDeclaredMethod("getTwitter");
		method.setAccessible(true);
		assertNotNull(method);
		Twitter t = (Twitter )method.invoke(cls);
		assertEquals( twitter, t);
		
//    }catch(Exception e){
//    	System.out.println(e.getMessage());
//    	assertNull(e.getMessage());
//    }


	TwitterControl twitterControl = new TwitterControl();
	
	//Events
	TwitterAdapter twitterAdapter = (TwitterAdapter) ((ConcreteMockAsyncTwitter)asyncTwitter).getListener();
	assertNotNull(twitterAdapter);
	ResponseList<Status> statuses;
	statuses = new MockResponseList<Status>(); 
	statuses.add(new ConcreteMockStatus(u, "", createURLEntities(), null));
	twitterAdapter.gotHomeTimeline(statuses);
	statuses = new MockResponseList<Status>(); 
	statuses.add(new ConcreteMockStatus(u, "", createURLEntities(), null));
	twitterAdapter.gotUserTimeline(statuses);
	
	PagableResponseList<User> gotFollowersList = new MockPagableResponseList<User>(-1);
	twitterAdapter.gotFollowersList(gotFollowersList);
	twitterAdapter.gotFriendsList(gotFollowersList);

	RelatedResults relatedResults = new MockRelatedResults();
	twitterAdapter.gotRelatedResults(relatedResults);
	
	twitterAdapter.onException(new TwitterException("testing"),TwitterMethod.AVAILABLE_TRENDS );
	
	Class<?> twitterAdapterCls = twitterAdapter.getClass();
	Method	invokeCallback = twitterAdapterCls.getDeclaredMethod("invokeCallback", String.class, Object.class);
	invokeCallback.setAccessible(true);
	assertNotNull(invokeCallback);
	invokeCallback.invoke(twitterAdapter, new Object[]{ "", new Object()});
	invokeCallback.invoke(twitterAdapter, new Object[]{ "", (Object)1});
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
