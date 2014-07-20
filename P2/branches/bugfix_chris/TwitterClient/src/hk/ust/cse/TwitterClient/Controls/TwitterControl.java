package hk.ust.cse.TwitterClient.Controls;

import org.apache.log4j.Logger;
import twitter4j.*;

import hk.ust.cse.TwitterClient.Views.WholePage;

import java.lang.reflect.Method;
import java.util.HashMap;

public class TwitterControl {

    private static final Logger logger = Logger.getLogger(TwitterControl.class);

    public static void setupTwitter(Twitter twitter, AsyncTwitter asyncTwitter) {
    s_twitter      = twitter;
    s_asyncTwitter = asyncTwitter;
    s_callbacks    = new HashMap<String, Object[]>();

    try {
      s_accountUser = getUser(s_twitter.getScreenName());
    } catch (TwitterException e) {
        logger.error(e.getMessage(), e);
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
      public void onException(TwitterException te, twitter4j.TwitterMethod method)  {
          String methodName = (method == null)? "{UNKNOWN}": method.name();

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
                  Thread pageSleepThread = new Thread(new Runnable() {
                      @Override
                      public void run() {
                          try {
                              logger.info("The application hits the rate limit, Pages would be locked for 30 seconds.");
                              MutexManager.set("Global",MutexOperation.ACQUIRE);

                              //block user to access home page for 30 seconds.
                              Thread.sleep(30000);
                              MutexManager.set("Global", MutexOperation.RELEASE);
                              logger.info("Unlock HomePage.");
                          } catch (InterruptedException e) {
                              logger.error("HomePage sleep failed.",e);
                              MutexManager.set("Global",MutexOperation.RELEASE);
                          }
                      }
                  });
                  pageSleepThread.start();
                  break;
              default:
                  logger.error(te.getMessage(),te);
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
      if(MutexManager.status("Global"))return;
      MutexManager.set("Global", MutexOperation.ACQUIRE);
      //logger.log(Level.INFO,"acquire Global");
      logger.debug("acquire Global");

    s_callbacks.put("getHomeTimeline", new Object[]{callee, callback});
    s_asyncTwitter.getHomeTimeline(new Paging(page));
  }

  public static void getUserTimeline(String screenName, int page, String callback, Object callee) {
      if(MutexManager.status("Global"))return;
      MutexManager.set("Global", MutexOperation.ACQUIRE);
      //logger.log(Level.INFO,"acquire Global");
      logger.debug("acquire Global");

    s_callbacks.put("getUserTimeline", new Object[] {callee, callback});
    s_asyncTwitter.getUserTimeline(screenName, new Paging(page));
  }

  public static void getFollowers(String screenName, long cursor, String callback, Object callee) {

      if(MutexManager.status("Global"))return;
      MutexManager.set("Global", MutexOperation.ACQUIRE);
      //logger.log(Level.INFO,"acquire Global");
      logger.debug("acquire Global");


      s_callbacks.put("getFollowersList", new Object[] {callee, callback});
      s_asyncTwitter.getFollowersList(screenName, cursor);
  }

  public static void getFollowing(String screenName, long cursor, String callback, Object callee) {

      if(MutexManager.status("Global"))return;
      MutexManager.set("Global", MutexOperation.ACQUIRE);
      //logger.log(Level.INFO,"acquire Global");
      logger.debug("acquire Global");


      s_callbacks.put("getFriendsList", new Object[] {callee, callback});
    s_asyncTwitter.getFriendsList(screenName, cursor);
  }
  
  public static void getReplies(Status tweet, String callback, Object callee) {
    if(MutexManager.status("Global"))return;
    MutexManager.set("Global", MutexOperation.ACQUIRE);
    //logger.log(Level.INFO,"acquire Global");
    logger.debug("acquire Global");

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
        logger.error(e.getMessage(),e);
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
            logger.error(e.getMessage(), e);
        }
	    

  }

  private static Twitter      s_twitter;
  private static AsyncTwitter s_asyncTwitter;
  private static User         s_accountUser;
  
  private static HashMap<String, Object[]> s_callbacks;
}
