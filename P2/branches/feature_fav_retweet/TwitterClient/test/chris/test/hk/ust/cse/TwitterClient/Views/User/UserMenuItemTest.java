package chris.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import hk.ust.cse.TwitterClient.Views.User.FriendView;
import hk.ust.cse.TwitterClient.Views.User.UserMenuItem;

import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import martin.test.utils.TestUtils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;


public class UserMenuItemTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    MockUser user = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    UserMenuItem userMenuItem = new UserMenuItem(shell, user.getScreenName(), 520, 260, null, null);
    assertNotNull(userMenuItem);
    assertEquals( user.getScreenName(),userMenuItem.getTitle());
   
    MouseTrackListener mouseTrackListener = TestUtils.getListener(userMenuItem, SWT.MouseHover, "UserMenuItem");
	   if( mouseTrackListener == null )
	    	fail();
	   
	   Event event;
	   MouseEvent e;
	   
	    //invoke	    
	    event = new Event();
	    event.widget = userMenuItem;
	    e = new MouseEvent(event);
	    
	    mouseTrackListener.mouseHover(e);
	    mouseTrackListener.mouseEnter(e);
	    mouseTrackListener.mouseExit(e);
    shell.dispose();
    display.dispose();
  }

}
