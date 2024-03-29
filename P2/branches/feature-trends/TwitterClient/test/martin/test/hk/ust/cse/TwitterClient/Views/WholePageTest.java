package martin.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Views.ControlBar;
import hk.ust.cse.TwitterClient.Views.ControlBarItem;
import hk.ust.cse.TwitterClient.Views.NumberBarItem;
import hk.ust.cse.TwitterClient.Views.TweetView;
import hk.ust.cse.TwitterClient.Views.WholePage;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;
import hk.ust.cse.TwitterClient.Views.Home.MiniProfile;
import hk.ust.cse.TwitterClient.Views.User.FriendView;
import martin.test.hk.ust.cse.TwitterClient.Mocks.ConcreteMockAsyncTwitter;
import martin.test.hk.ust.cse.TwitterClient.Mocks.ConcreteMockStatus;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockTwitter;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockURLEntity;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import martin.test.utils.TestUtils;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.junit.Ignore;
import org.junit.Test;

import twitter4j.AsyncTwitter;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.URLEntity;

public class WholePageTest {
  @Test(timeout=200000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);

    SetupMockUserTwitter();

    WholePage wholePage = new WholePage(shell, 10, 10);
    assertNotNull( wholePage );
    
    Event event = new Event();
    RowComposite button1;
    ControlBarItem controlBarItem1;
    Image img;
    MouseEvent e;
    
    img = new Image(display, 1, 1);
    button1= new RowComposite(shell, 0, 0, false, 0, 0, 0, 0, 0);
    assertNotNull(button1);
   
    // --- event test
    
    //onCtrlBtnClicked
    
    //line 68
    controlBarItem1 = new ControlBarItem( button1, "Home", img ,img);
    assertNotNull(controlBarItem1);
    event.widget = controlBarItem1;
    e = new MouseEvent(event);
    wholePage.onCtrlBtnClicked(e);
    
    //line 71
    controlBarItem1 = new ControlBarItem( button1, "Me", img ,img);
    assertNotNull(controlBarItem1);
    event.widget = controlBarItem1;
    e = new MouseEvent(event);
    wholePage.onCtrlBtnClicked(e);
    SetupNullUserTwitter();
    wholePage.onCtrlBtnClicked(e);
    
    //line 77
    SetupMockUserTwitter();
    controlBarItem1 = new ControlBarItem( button1, "Go to people", img ,img);
    assertNotNull(controlBarItem1);
    event.widget = controlBarItem1;
    e = new MouseEvent(event);
    wholePage.onCtrlBtnClicked(e);
    
    //line 79
    //---------------------------------------
    Class<?> wholePageCls = WholePage.class;
    Class<?> controlBarCls = ControlBar.class;
    
    Field m_ctrlBar_Field =  wholePageCls.getDeclaredField("m_ctrlBar");
    assertNotNull(m_ctrlBar_Field);
    m_ctrlBar_Field.setAccessible(true);
    ControlBar m_ctrlBar =(ControlBar) m_ctrlBar_Field.get(wholePage);
    assertNotNull(m_ctrlBar);

    Field m_people_Field =  controlBarCls.getDeclaredField("m_people");
    assertNotNull(m_people_Field);
    m_people_Field.setAccessible(true);
    Text m_people =(Text) m_people_Field.get(m_ctrlBar);
    assertNotNull(m_people);
    m_people.setText("screenName");
    // -------------------------------------
    wholePage.onCtrlBtnClicked(e);
    
    //line 85
    controlBarItem1 = new ControlBarItem( button1, "", img ,img);
    assertNotNull(controlBarItem1);
    event.widget = controlBarItem1;
    e = new MouseEvent(event);
    wholePage.onCtrlBtnClicked(e);
    
    //line 63    
    event.widget = new Button(controlBarItem1, 0);
    e = new MouseEvent(event);
    wholePage.onCtrlBtnClicked(e);
    
    //onEnterPressed
    //line 90
    SetupMockUserTwitter();
    controlBarItem1 = new ControlBarItem( button1, "Go to people", img ,img);
    assertNotNull(controlBarItem1);
    event.widget = controlBarItem1;
    KeyEvent ke = new KeyEvent(event);
    wholePage.onEnterPressed(ke);
    
    //line 91
    m_people.setText("");
    wholePage.onEnterPressed(ke);
    
    //onNumberItemClicked
    //line 63    
    NumberBarItem numberBarItem1 = new NumberBarItem(shell, 0, "numberBarItem1",
							    		10, 10,
							    		null, null, null,
							    		null, null);
    event.widget = new Button(numberBarItem1, 0);
    e = new MouseEvent(event);
    wholePage.onNumberItemClicked(e);
    
    //onNameLinkClicked
    //line 117
    
    MockUser user = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");	    
    user.setProfileImageURL(TestUtils.getResourceURL("logo.png"));
    user.setProfileBackgroundColor("1A1B1F");
    user.setProfileBackgroundImageURL(TestUtils.getResourceURL("background"));
    user.setCreatedAt(new Date());
    
    Status tweet = new ConcreteMockStatus(user, "", createURLEntities(), null);
    TweetView tweetView = new TweetView( shell, tweet, 10, false,
    		null, null, null, // Color
    		null,null);	// Font
    event.widget = tweetView;
    e = new MouseEvent(event);
    wholePage.onNameLinkClicked(e);
    
    //line 121
    MockUser friend = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    friend.setProfileBackgroundColor("1A1B1F");
    friend.setProfileBackgroundImageURL(TestUtils.getResourceURL("background"));
    friend.setProfileImageURL(TestUtils.getResourceURL("logo.png"));
    FriendView friendView = new FriendView(shell, friend, 10, null, null);
    event.widget = friendView;
    e = new MouseEvent(event);
    wholePage.onNameLinkClicked(e);
    
    //line 124
    
    MiniProfile miniProfile = new MiniProfile( shell, user, 1200, 700 );
    event.widget = miniProfile;
    e = new MouseEvent(event);
    wholePage.onNameLinkClicked(e);

   
    
    
    //End
    
    shell.dispose();
    display.dispose();
  }

  public void SetupNullUserTwitter(){
	  Twitter twitter = new MockTwitter(null);
	 
	  AsyncTwitter asyncTwitter = new ConcreteMockAsyncTwitter();
	  TwitterControl.setupTwitter( twitter, asyncTwitter);
  }
  
  public void SetupMockUserTwitter(){
	MockUser user  = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    user.setProfileBackgroundColor("1A2B3F");
    user.setProfileBackgroundImageURL(TestUtils.getResourceURL("background"));
    
    Twitter twitter = new MockTwitter( user );
    AsyncTwitter asyncTwitter = new ConcreteMockAsyncTwitter();
    TwitterControl.setupTwitter( twitter, asyncTwitter);
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
