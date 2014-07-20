package hk.ust.cse.TwitterClient.Controls;

import twitter4j.*;

import hk.ust.cse.TwitterClient.Views.WholePage;

import java.lang.reflect.Method;
import java.util.HashMap;

public class TwitterControl {
  
  public static void setupTwitter(Twitter twitter, AsyncTwitter asyncTwitter) {
    s_twitter      = twitter;
    s_asyncTwitter = asyncTwitter;
    s_callbacks    = new HashMap<String, Object[]>();

    try {
      s_accountUser = getUser(s_twitter.getScreenName());
    } catch (TwitterException e) {
        System.out.println("ERROR: " + e.getErrorMessage());
    }
    
    s_asyncTwitter.addListener(new TwitterAdapter() {
      @Override
      public void gotHomeTimeline(ResponseList<Status> statuses) {
        invokeCallback("getHomeTimeline", statuses);
        if(statuses!=null)
        	WholePage.firstTweet = statuses.get(0);	
      }
      
      @Override
      public void gotUserTimeline(ResponseList<Status> statuses) {
        invokeCallback("getUserTimeline", statuses);
        if(statuses!=null)
        	WholePage.firstTweet = statuses.get(0);	
      }

      @Override
      public void gotFollowersList(PagableResponseList<User> followersList) {
        invokeCallback("getFollowersList", followersList);       
      }
      
      @Override
      public void gotFriendsList(PagableResponseList<User> friendsList) {
        invokeCallback("getFriendsList", friendsList);
      }
      
      @Override
      public void gotRelatedResults(RelatedResults relatedResults) {
        invokeCallback("getRelatedResults", relatedResults);
      }

      @Override
      public void searched(QueryResult queryResult) {
        invokeCallback("getSearch", queryResult);
      }

      @Override
      public void onException(TwitterException te, twitter4j.TwitterMethod method)  {
          String methodName = (method == null)? "{UNKNOWN}": method.name();
          System.out.println("Exception Message:" + te.getMessage() + " " + te.getErrorCode() + " " + methodName);

          // handle with different error codes
          switch(te.getErrorCode()){
          /*
	        //no network connection
	      	  case -1:   			  
      			  MessageBox dialog = new MessageBox(getShell(), SWT.ICON_WARNING | SWT.OK);
      			  dialog.setMessage("No network connection,please check it!");
      			  if (dialog.open() == SWT.YES){
      				  updateTwitter();
      			  }
	      		  break;
          		  */
              // API rate limit error
              case 88:
                  // run a long sleep in thread
                  Thread homePageSleepThread = new Thread(new Runnable() {
                      @Override
                      public void run() {
                          try {
                              System.out.println("The application hits the rate limit, HomePageMutex would be released after 30 seconds.");
                              Mutex.acquireHomePageMutex();
                              //block user to access home page for 30 seconds.
                              Thread.sleep(30000);
                              System.out.println("TwitterControl releaseHomePageMutex");
                              Mutex.releaseHomePageMutex();
                          } catch (InterruptedException e) {
                              System.out.println("Error: HomePage sleep failed.");
                              Mutex.releaseHomePageMutex();
                          }
                      }
                  });
                  homePageSleepThread.start();
                  break;
              default:
                  System.out.println("ERROR: " + te.getErrorMessage());
          }
      }
      
      private void invokeCallback(String methodName, Object returnVal) {
        Object[] callback = s_callbacks.get(methodName);
        if (callback != null) {
          try {
            Method method = callback[0].getClass().getMethod(
                (String) callback[1], new Class<?>[] {(Class<?>) Object.class});
            method.invoke(callback[0], returnVal);
          } catch (Exception e) {e.printStackTrace();}
        }
      }
    });
  }
  
  public static void getHomeTimeline(int page, String callback, Object callee) {
      if(Mutex.getHomePageMutex()) return;
      Mutex.acquireHomePageMutex();
      System.out.println("acquireHomePageMutex");

    s_callbacks.put("getHomeTimeline", new Object[] {callee, callback});
    s_asyncTwitter.getHomeTimeline(new Paging(page));
  }

  public static void getSearch(String tagName, String callback, Object callee){

      if(Mutex.getSearchPageMutex()) return;
      Mutex.acquireSearchPageMutex();
      System.out.println("acquireSearchPageMutex");

      s_callbacks.put("getSearch", new Object[]{callee, callback});

      //search function for hash tag and search box. it return a list of tweet rather than a paging object.
      //Each query can contains max 100 tweets only due to the api limitation.
      Query query = new Query("#" + tagName).count(100);
      s_asyncTwitter.search(query);
  }

  public static void getUserTimeline(String screenName, int page, String callback, Object callee) {

      if((Mutex.getUserPageMutex())) return;
      Mutex.acquireUserPageMutex();
      System.out.println("acquireUserPageMutex");

    s_callbacks.put("getUserTimeline", new Object[] {callee, callback});
    s_asyncTwitter.getUserTimeline(screenName, new Paging(page));
  }

  public static void getFollowers(String screenName, long cursor, String callback, Object callee) {
    s_callbacks.put("getFollowersList", new Object[] {callee, callback});
    s_asyncTwitter.getFollowersList(screenName, cursor);
  }

  public static void getFollowing(String screenName, long cursor, String callback, Object callee) {
    s_callbacks.put("getFriendsList", new Object[] {callee, callback});
    s_asyncTwitter.getFriendsList(screenName, cursor);
  }
  
  public static void getReplies(Status tweet, String callback, Object callee) {
    s_callbacks.put("getRelatedResults", new Object[] {callee, callback});
    s_asyncTwitter.getRelatedResults(tweet.getId());
  }

  // return null if user not found
  public static User getAccountUser() {
    return s_accountUser;
  }
  
  // return null if user not found
  public static User getUser(String screenName) {
    User user = null;
    try {
      user = s_twitter.showUser(screenName);
    } catch (TwitterException e) {
        System.out.println("ERROR: " + e.getErrorMessage());
    }
    return user;
  }
  
  public static Twitter getTwitter() {
    return s_twitter;
  }
  
  public static void updateTwitter(){
	    try {
	        s_accountUser = getUser(s_twitter.getScreenName());

	    } catch (TwitterException e) {
            System.out.println("ERROR: " + e.getErrorMessage());
        }
	    

  }

  private static Twitter      s_twitter;
  private static AsyncTwitter s_asyncTwitter;
  private static User         s_accountUser;
  
  private static HashMap<String, Object[]> s_callbacks;
}
