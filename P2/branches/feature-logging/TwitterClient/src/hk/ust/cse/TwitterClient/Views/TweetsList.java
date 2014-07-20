package hk.ust.cse.TwitterClient.Views;

import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.User.MiniPage;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import twitter4j.Status;

public class TweetsList extends ListView {
  
  public TweetsList(Composite parentView, List<Status> tweets, int width, 
      String nameClkHandler, Object handlerCallee, String backHandler, Object backHandlerCallee, 
      String nextHandler, Object nextHandlerCallee) {
    super(parentView, "Tweets", width, backHandler, backHandlerCallee, nextHandler, nextHandlerCallee);
    
    m_tweets = tweets;

    m_nameClkHandler = nameClkHandler;
    m_handlerCallee  = handlerCallee;
    m_callee  = nextHandlerCallee;
    
    initialize();
    
    // a dispose listener is necessary
    addDisposeListener(new DisposeListener() {
      public void widgetDisposed(DisposeEvent e) {
        TweetsList.this.widgetDisposed(e);
      }
    });
  }
  
  private void initialize() {
		 
	    List<Composite> tweetViews = new ArrayList<Composite>();
	    //On mini page, timeline of tweets should be shown at most 3
	    if(m_callee instanceof MiniPage){
	        if (m_tweets != null) {
	        	int j=2;
	        	//if tweets of users are less than 3, set the number of tweets according to their accounts
	        	if (m_tweets.size()<2)
	        		j=m_tweets.size();
	            for (int i=0;i<j;i++){
	            	Status tweet =m_tweets.get(i); 
	              //tweet = tweet.getRetweetedStatus() != null ? tweet.getRetweetedStatus() : tweet;
	              final TweetView tweetView = new TweetView(this, tweet, getBounds().width, true, 
	                  Resources.WHITE_COLOR, Resources.HOVER_COLOR, Resources.WHITE_COLOR, null, null);
	              tweetView.addListener(SWT.Resize, new Listener() {
	                @Override
	                public void handleEvent(Event arg0) {
	                  tweetView.setLayoutData(new RowData(tweetView.getBounds().width, 
	                                                      tweetView.getBounds().height));
	                  TweetsList.this.setRegion(null); // release the setRegion limit
	                  layout();
	                  pack();
	                  Utils.cutRoundCorner(TweetsList.this, true, true, true, true);
	                }
	              });
	              tweetViews.add(tweetView);
	            }
	          }
	    }
	    //Other pages except mini user page
	    else{
	        if (m_tweets != null) {
	            for (Status tweet : m_tweets) {
	              //tweet = tweet.getRetweetedStatus() != null ? tweet.getRetweetedStatus() : tweet;
	              final TweetView tweetView = new TweetView(this, tweet, getBounds().width, true, 
	                  Resources.WHITE_COLOR, Resources.HOVER_COLOR, Resources.WHITE_COLOR, m_nameClkHandler, m_handlerCallee);
	              tweetView.addListener(SWT.Resize, new Listener() {
	                @Override
	                public void handleEvent(Event arg0) {
	                  tweetView.setLayoutData(new RowData(tweetView.getBounds().width, 
	                                                      tweetView.getBounds().height));
	                  TweetsList.this.setRegion(null); // release the setRegion limit
	                  layout();
	                  pack();
	                  Utils.cutRoundCorner(TweetsList.this, true, true, true, true);
	                }
	              });
	              tweetViews.add(tweetView);
	            }
	          }
	    }
	    	

	    addItems(tweetViews);
	    
	    // cut corner only after layout()
	    Utils.cutRoundCorner(this, true, true, true, true);
	  }

  
  private void widgetDisposed(DisposeEvent e) {
  }
  
  private String m_nameClkHandler;
  private Object m_handlerCallee;
  
  private final List<Status> m_tweets;

  private Object m_callee;


}
