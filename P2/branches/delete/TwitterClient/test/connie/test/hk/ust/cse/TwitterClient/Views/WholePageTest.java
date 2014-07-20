package connie.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.*;

import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.ControlBar;
import hk.ust.cse.TwitterClient.Views.ControlBarItem;
import hk.ust.cse.TwitterClient.Views.NumberBarItem;
import hk.ust.cse.TwitterClient.Views.TweetView;
import hk.ust.cse.TwitterClient.Views.WholePage;
import hk.ust.cse.TwitterClient.Views.Home.MiniProfile;
import hk.ust.cse.TwitterClient.Views.User.FriendView;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import connie.test.hk.ust.cse.TwitterClient.Mocks.MockAsyncTwitter;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockStatus;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockTwitter;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockUser;

import twitter4j.TwitterException;

public class WholePageTest {

	@Test(timeout=100000)
	public void testWholePage() throws TwitterException, Throwable {
		Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    TwitterControl.setupTwitter(new MockTwitter(), new MockAsyncTwitter());
	    new TwitterControl();
	    WholePage wp = new WholePage(shell, 700, 1200);
	    assertNotNull(wp);
	    assertEquals(1200, wp.getHeight());
	    assertEquals(700, wp.getWidth());
	    
	    ControlBarItem ctrBarItem = new ControlBarItem (shell,"Home",Resources.HOME_IMG,Resources.HOME_HOVER_IMG);
	    ControlBarItem ctrBarItem2 = new ControlBarItem (shell,"Me",Resources.HOME_IMG,Resources.HOME_HOVER_IMG);
	    ControlBarItem ctrBarItem3 = new ControlBarItem (shell,"Go to people",Resources.HOME_IMG,Resources.HOME_HOVER_IMG);
	    ControlBarItem ctrBarItem4 = new ControlBarItem (shell,"",Resources.HOME_IMG,Resources.HOME_HOVER_IMG);
	    
	    Event event = new Event();
	    event.widget = ctrBarItem;
	    MouseEvent e = new MouseEvent(event);
	    wp.onCtrlBtnClicked(e);
	    
	    event = new Event();
	    event.widget = ctrBarItem2;
	    e = new MouseEvent(event);
	    wp.onCtrlBtnClicked(e);
	    
	    event = new Event();
	    event.widget = ctrBarItem3;
	    e = new MouseEvent(event);
	    wp.onCtrlBtnClicked(e);
	    
	    event = new Event();
	    event.widget = ctrBarItem4;
	    e = new MouseEvent(event);
	    wp.onCtrlBtnClicked(e);
	    
	    event = new Event();
		event.widget = shell;
		KeyEvent k = new KeyEvent(event);
		wp.onEnterPressed(k);
		
		MockUser user = new MockUser("NASA","NASA",true,"des");
		MiniProfile mini = new MiniProfile(shell,user,0,0);
		NumberBarItem noBarItm = new NumberBarItem(mini,10,"title",100,100,Resources.GRAY_COLOR,Resources.GRAY_COLOR,Resources.GRAY_COLOR,Resources.FONT10,Resources.FONT11);
		event = new Event();
		event.widget = noBarItm;
		e = new MouseEvent(event);
		wp.onNumberItemClicked(e);
		wp.onNameLinkClicked(e);
		noBarItm.dispose();
		mini.dispose();
		
		FriendView friendView = new FriendView(shell, user, 0, "", shell);
		event =new Event();
		event.widget=friendView;
		e = new MouseEvent(event);
		wp.onNameLinkClicked(e);
		
		noBarItm = new NumberBarItem(friendView,10,"title",100,100,Resources.GRAY_COLOR,Resources.GRAY_COLOR,Resources.GRAY_COLOR,Resources.FONT10,Resources.FONT11);
		event =new Event();
		event.widget=noBarItm;
		e = new MouseEvent(event);
		wp.onNameLinkClicked(e);
		noBarItm.dispose();
		friendView.dispose();
		
		MockStatus mockStatus = new MockStatus();
		TweetView teetView = new TweetView (shell, mockStatus, 30, false, Resources.GRAY_COLOR,Resources.GRAY_COLOR,Resources.GRAY_COLOR, "clk", shell);
		noBarItm = new NumberBarItem(teetView,10,"title",100,100,Resources.GRAY_COLOR,Resources.GRAY_COLOR,Resources.GRAY_COLOR,Resources.FONT10,Resources.FONT11);
		event = new Event();
		event.widget=noBarItm;
		e = new MouseEvent(event);
		wp.onNameLinkClicked(e);
		noBarItm.dispose();
			    
	    ControlBar ctrlBar = new ControlBar(wp, 700, 40, 400, "onCtrlBtnClicked", "onEnterPressed", this);
	    ctrlBar.setLayoutData(new RowData(700, 40));
	    ctrlBar.dispose();
	    
	    wp.dispose();
	    
	    shell.dispose();
	    display.dispose();
	}

}
