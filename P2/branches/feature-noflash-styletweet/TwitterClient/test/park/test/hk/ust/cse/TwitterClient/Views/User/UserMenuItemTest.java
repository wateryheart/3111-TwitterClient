package park.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.User.UserMenuItem;

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


public class UserMenuItemTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    UserMenuItem userMenuItem1 = new UserMenuItem(shell,"Tweets", 10, 10, null, null);
    userMenuItem1.setClicked();
    userMenuItem1.setNotClicked();
    
    assertNotNull(userMenuItem1);
    assertEquals("Tweets",userMenuItem1.getTitle());

    Event event1 = new Event();
	event1.widget = userMenuItem1;
	MouseEvent e1 = new MouseEvent(event1);
	
	for(int i=0; i<3; i++){
		Listener[] listen1 = userMenuItem1.getListeners(SWT.MouseHover);
		SWTEventListener listener1 = ((TypedListener) (listen1[i])).getEventListener();
		((MouseTrackListener)listener1).mouseHover(e1);	
	}
	
	for(int i=0; i<3; i++){
		Listener[] listen2 = userMenuItem1.getListeners(SWT.MouseExit);
		SWTEventListener listener2 = ((TypedListener) (listen2[i])).getEventListener();
		((MouseTrackListener)listener2).mouseExit(e1);	
	}
	
	for(int i=0; i<3 ; i++){
		Listener[] listen3 = userMenuItem1.getListeners(SWT.MouseEnter);
		SWTEventListener listener3 = ((TypedListener) (listen3[i])).getEventListener();
		((MouseTrackListener)listener3).mouseEnter(e1);
	}
	e1.x = 100;
	e1.y=100;
	
	for(int i=0; i<3; i++){
		Listener[] listen2 = userMenuItem1.getListeners(SWT.MouseExit);
		SWTEventListener listener2 = ((TypedListener) (listen2[i])).getEventListener();
		((MouseTrackListener)listener2).mouseExit(e1);	
	}
	
	userMenuItem1.setClicked();
	
	for(int i=0; i<3; i++){
		Listener[] listen2 = userMenuItem1.getListeners(SWT.MouseExit);
		SWTEventListener listener2 = ((TypedListener) (listen2[i])).getEventListener();
		((MouseTrackListener)listener2).mouseExit(e1);	
	}
	
	for(int i=0; i<3 ; i++){
		Listener[] listen3 = userMenuItem1.getListeners(SWT.MouseEnter);
		SWTEventListener listener3 = ((TypedListener) (listen3[i])).getEventListener();
		((MouseTrackListener)listener3).mouseEnter(e1);
	}
	
    shell.dispose();
    display.dispose();
  }

}