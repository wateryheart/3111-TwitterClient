package park.test.hk.ust.cse.TwitterClient.Views.Home;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.util.List;
import hk.ust.cse.TwitterClient.Views.TweetsList;
import hk.ust.cse.TwitterClient.Views.Basic.ClickableImageLabel;
import hk.ust.cse.TwitterClient.Views.Home.HomePage;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Resources.Resources;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.internal.SWTEventListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TypedListener;
import org.junit.Test;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class HomePageTest {
  
	@Test(timeout=50000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    String CONSUMER_KEY = "m0LSVjOVM8sJK7v9bnuKtQ";
    String CONSUMER_SECRET ="cdrPYrhzmB4YS42M4nBZ1QMP6uq5389AAIKNezZVAM";
    String ACCESSTOKEN="147163880-sfKmPIQMUw0bRR0N5FfrILQEyRr2aBFjRjgTQ6NQ";
    String ACCESSTOKEN_SECRET="JtG4Tv5GCSC7kAVab7i968dvTQJIxXYfnO9yEAfA";
    
    ConfigurationBuilder builder = new ConfigurationBuilder();
    builder.setOAuthConsumerKey(CONSUMER_KEY);
    builder.setOAuthConsumerSecret(CONSUMER_SECRET);
    builder.setOAuthAccessToken(ACCESSTOKEN);
    builder.setOAuthAccessTokenSecret(ACCESSTOKEN_SECRET);
    
    Configuration configuration = builder.build();
    TwitterFactory factory = new TwitterFactory(configuration);
    Twitter twitter = factory.getInstance();
    AsyncTwitterFactory asyncfactory = new AsyncTwitterFactory(configuration);
    AsyncTwitter asyncTwitter = asyncfactory.getInstance();
    
    TwitterControl.setupTwitter(twitter, asyncTwitter);
    List<Status> statuses = twitter.getHomeTimeline();
    
    HomePage homePage = new HomePage(shell, 100, 10, 10, 10, 10, null, null, null);
    HomePage homePage1 = new HomePage(shell, 100, 2000, 10, 10, 10, null, null, null);
    assertNotNull(homePage);
    
	Event event = new Event();
	event.widget = shell; 
	MouseEvent e1 = new MouseEvent(event);
    
    homePage.tweetsListBackClicked(e1);
    homePage.tweetsListNextClicked(e1);
    
    homePage.showTweetsList(statuses);
    homePage1.showTweetsList(statuses);

    homePage.tweetsListNextClicked(e1);
    homePage.tweetsListBackClicked(e1);
    
    Event event1 = new Event();
    TweetsList test1 = getPrivate(homePage);
	event1.widget = test1;
	Listener[] listen1 = test1.getListeners(SWT.Resize);
	(listen1[0]).handleEvent(event1);
	
	
    ClickableImageLabel clickImag = new ClickableImageLabel(shell, 0, Resources.HOME_IMG, 
  	      Resources.HOME_HOVER_IMG, "tweetsListNextClicked", homePage1);
    Event event2 = new Event();
	event2.widget = clickImag;
	MouseEvent e2 = new MouseEvent(event2);
	Listener[] listen4 = clickImag.getListeners(SWT.MouseDown);
	SWTEventListener listener4 = ((TypedListener) (listen4[0])).getEventListener();
	((MouseListener)listener4).mouseDown(e2);
    
    shell.dispose();
  }
	
	private TweetsList  getPrivate(HomePage userPage){
		TweetsList userTest = null;
			try{
				Field field = HomePage.class.getDeclaredField("m_itemList");
				field.setAccessible(true);
				userTest = (TweetsList)field.get(userPage);
					
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			return userTest;
			
		}
}

