package park.test.hk.ust.cse.TwitterClient.Views.Home;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.Home.MiniProfile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.internal.SWTEventListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TypedListener;
import org.junit.Test;

import park.test.hk.ust.cse.TwitterClient.Mocks.MockUser;


public class MiniProfileTest {
  
	@Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    MockUser friend = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    MiniProfile miniProfile = new MiniProfile(shell, friend, 10,10);
    assertNotNull(miniProfile);
    
    Event event1 = new Event();
	event1.widget = miniProfile;
	MouseEvent e1 = new MouseEvent(event1);
	
	Listener[] listen1 = miniProfile.getListeners(SWT.MouseHover);
	SWTEventListener listener1 = ((TypedListener) (listen1[1])).getEventListener();
	((MouseTrackListener)listener1).mouseHover(e1);
	
	Listener[] listen2 = miniProfile.getListeners(SWT.MouseExit);
	SWTEventListener listener2 = ((TypedListener) (listen2[1])).getEventListener();
	((MouseTrackListener)listener2).mouseExit(e1);
	
	e1.x = 10;
	e1.y = 10;
	((MouseTrackListener)listener2).mouseExit(e1);
	
	Listener[] listen3 = miniProfile.getListeners(SWT.MouseEnter);
	SWTEventListener listener3 = ((TypedListener) (listen3[1])).getEventListener();
	((MouseTrackListener)listener3).mouseEnter(e1);
	
	assertEquals(friend,miniProfile.getUser());

    shell.dispose();
    display.dispose();
  }
}
