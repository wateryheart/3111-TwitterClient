package park.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Views.ControlBar;
import hk.ust.cse.TwitterClient.Views.ControlBarItem;
import hk.ust.cse.TwitterClient.Views.NumberBarItem;
import hk.ust.cse.TwitterClient.Views.TweetView;
import hk.ust.cse.TwitterClient.Views.WholePage;
import hk.ust.cse.TwitterClient.Views.Home.MiniProfile;
import hk.ust.cse.TwitterClient.Views.User.FriendView;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Resources.Resources;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.internal.SWTEventListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TypedListener;
import org.junit.Test;

import park.test.hk.ust.cse.TwitterClient.Mocks.MockUser;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class WholePageTest {

@Test(timeout=100000)
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
    Status status1 = twitter.showStatus(100);
    
    MockUser friend = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    
    Event event1 = new Event();
	Event event2 = new Event();
	Event event3 = new Event();
	Event event4 = new Event();
	Event event5 = new Event();
	Event event6 = new Event();
	Event event7 = new Event();
	Event event8 = new Event();
	Event event9 = new Event();
	
    WholePage wholePage = new WholePage(shell, 100,100);
    
    assertNotNull(wholePage);
    
    ControlBar testCon = getPrivateCon(wholePage);
    assertNotNull(testCon);
    Text testText = getPrivateText(testCon);
    
    testText.setText("kataruis");
    
	event9.widget = testText;
	KeyEvent e9 = new KeyEvent(event9);	
	Listener[] listen7 = testText.getListeners(SWT.KeyUp);
	SWTEventListener listener7 = ((TypedListener) (listen7[0])).getEventListener();
	((KeyListener)listener7).keyReleased(e9);
	
	e9.keyCode = '\r';
	((KeyListener)listener7).keyReleased(e9);
	
    testText.setText("");
	event9.widget = testText;
	e9 = new KeyEvent(event9);
	e9.keyCode = '\r';
	((KeyListener)listener7).keyReleased(e9);
    
	Listener[] listen6 = testText.getListeners(SWT.KeyDown);
	SWTEventListener listener6 = ((TypedListener) (listen6[0])).getEventListener();
	((KeyListener)listener6).keyPressed(e9);

	FocusEvent e8 = new FocusEvent(event9);
	Listener[] listen8 = testText.getListeners(SWT.FocusIn);
	SWTEventListener listener8 = ((TypedListener) (listen8[0])).getEventListener();
	((FocusListener)listener8).focusGained(e8);
	
	Listener[] listen9 = testText.getListeners(SWT.FocusOut);
	SWTEventListener listener9 = ((TypedListener) (listen9[0])).getEventListener();
	((FocusListener)listener9).focusLost(e8);
	
    
	ControlBarItem test1 = new ControlBarItem(shell, "Home", Resources.HOME_IMG, Resources.HOME_HOVER_IMG);
	event1.widget = test1;
	Utils.addClickListener(test1, "onCtrlBtnClicked", wholePage);
	MouseEvent e1 = new MouseEvent(event1);
	Listener[] listen1 = test1.getListeners(SWT.MouseDown);
	SWTEventListener listener1 = ((TypedListener) (listen1[0])).getEventListener();
	((MouseListener)listener1).mouseDown(e1);
		
	Listener[] listen2 = test1.getListeners(SWT.MouseUp);
	SWTEventListener listener2 = ((TypedListener) (listen2[0])).getEventListener();
	((MouseListener)listener2).mouseUp(e1);
	
	Listener[] listen3 = test1.getListeners(SWT.MouseDown);
	SWTEventListener listener3 = ((TypedListener) (listen3[0])).getEventListener();
	((MouseListener)listener3).mouseDoubleClick(e1);
	
	ControlBarItem test2 = new ControlBarItem(shell, "Me", Resources.ME_IMG, Resources.ME_HOVER_IMG);
	event2.widget = test2;
	Utils.addClickListener(test2, "onCtrlBtnClicked", wholePage);
	MouseEvent e2 = new MouseEvent(event2);
	Listener[] listen4 = test2.getListeners(SWT.MouseDown);
	SWTEventListener listener4 = ((TypedListener) (listen4[0])).getEventListener();
	((MouseListener)listener4).mouseDown(e2);
	
	ControlBarItem test3 = new ControlBarItem(shell, "Go to people", Resources.GO_IMG, Resources.GO_CLICKED_IMG);
	ControlBarItem test4 = new ControlBarItem(shell, "test", Resources.GO_IMG, Resources.GO_CLICKED_IMG);
	event3.widget = test3;
	Utils.addClickListener(test3, "onCtrlBtnClicked", wholePage);
	MouseEvent e3 = new MouseEvent(event3);
	Listener[] listen5 = test3.getListeners(SWT.MouseDown);
	SWTEventListener listener5 = ((TypedListener) (listen5[0])).getEventListener();
	((MouseListener)listener5).mouseDown(e3);
	
	testText.setText("kataruis");
	((MouseListener)listener5).mouseDown(e3);
	
	event3.widget = test4;
	Utils.addClickListener(test4, "onCtrlBtnClicked", wholePage);
	e3 = new MouseEvent(event3);
	listen5 = test3.getListeners(SWT.MouseDown);
	listener5 = ((TypedListener) (listen5[0])).getEventListener();
	((MouseListener)listener5).mouseDown(e3);
	
	event4.widget = new NumberBarItem(shell, 10, "Tweets", 10, 10, Resources.WHITE_COLOR, Resources.HOVER_COLOR, Resources.HOVER_COLOR, 
    		Resources.FONT11, Resources.FONT11I);
	event5.widget = new TweetView(shell, status1, 10, true,Resources.WHITE_COLOR, Resources.HOVER_COLOR, Resources.HOVER_COLOR, null, null);
	event6.widget = new FriendView(shell, friend, 10, null, null);
	event7.widget = new MiniProfile(shell, friend, 10,10);
	
	MouseEvent e4 = new MouseEvent(event4);
	MouseEvent e5 = new MouseEvent(event5);
	MouseEvent e6 = new MouseEvent(event6);
	MouseEvent e7 = new MouseEvent(event7);
	
	wholePage.onNumberItemClicked(e4);
	wholePage.onNameLinkClicked(e5);
	wholePage.onNameLinkClicked(e6);
	wholePage.onNameLinkClicked(e7);

    shell.dispose();
  }

	private Text getPrivateText(ControlBar con){
		Text text = null;
		try{
			Field field = ControlBar.class.getDeclaredField("m_people");
			field.setAccessible(true);
			text = (Text)field.get(con);
				
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return text;
		
	}
	
	private ControlBar getPrivateCon(WholePage whole){
		ControlBar con = null;
		try{
			Field field = WholePage.class.getDeclaredField("m_ctrlBar");
			field.setAccessible(true);
			con = (ControlBar)field.get(whole);
				
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return con;
		
	}

  
}
