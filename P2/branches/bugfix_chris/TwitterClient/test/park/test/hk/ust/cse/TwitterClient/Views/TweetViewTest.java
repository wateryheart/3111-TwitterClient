package park.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.util.List;

import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Views.TweetView;
import hk.ust.cse.TwitterClient.Views.Basic.HoverClickableComposite;
import hk.ust.cse.TwitterClient.Views.Home.RepliesList;
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

import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TweetViewTest {
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

    Status status1 = twitter.showStatus(123);
    Status status2 = twitter.showStatus(111);

    TweetView tweetView2 = new TweetView(shell, status2, 10, false,Resources.WHITE_COLOR, Resources.HOVER_COLOR, Resources.HOVER_COLOR, null, null);

    HoverClickableComposite test = getPrivate(tweetView2);
	Event event = new Event();

	event.widget = test;
    MouseEvent e1 = new MouseEvent(event);
	Listener[] listen1 = test.getListeners(SWT.MouseDown);



	Listener[] listen2 = test.getListeners(SWT.MouseUp);

	Listener[] listen3 = test.getListeners(SWT.MouseDown);

    assertNotNull(tweetView2);

    shell.dispose();
    display.dispose();
  }

  private HoverClickableComposite  getPrivate(TweetView userPage){
	  HoverClickableComposite userTest = null;
		try{
			Field field = TweetView.class.getDeclaredField("m_upperFrame");
			field.setAccessible(true);
			userTest = (HoverClickableComposite)field.get(userPage);

		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return userTest;

	}

  private RepliesList  getPrivateList(TweetView userPage){
	  RepliesList userTest = null;
		try{
			Field field = TweetView.class.getDeclaredField("m_repliesView");
			field.setAccessible(true);
			userTest = (RepliesList)field.get(userPage);

		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return userTest;

	}




}