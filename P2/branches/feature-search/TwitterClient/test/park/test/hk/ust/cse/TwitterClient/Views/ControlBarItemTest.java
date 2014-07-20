package park.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.ControlBarItem;
import hk.ust.cse.TwitterClient.Resources.Resources;

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

public class ControlBarItemTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    ControlBarItem ctrlBarItem = new ControlBarItem(shell, "Home", Resources.HOME_IMG, Resources.HOME_HOVER_IMG);
    assertNotNull(ctrlBarItem);
    
    Event event1 = new Event();
	event1.widget = ctrlBarItem;
	MouseEvent e1 = new MouseEvent(event1);
	Listener[] listen1 = ctrlBarItem.getListeners(SWT.MouseHover);
	SWTEventListener listener1 = ((TypedListener) (listen1[1])).getEventListener();
	((MouseTrackListener)listener1).mouseHover(e1);
	
	Listener[] listen2 = ctrlBarItem.getListeners(SWT.MouseExit);
	SWTEventListener listener2 = ((TypedListener) (listen2[1])).getEventListener();
	((MouseTrackListener)listener2).mouseExit(e1);
	
	e1.x = 100;
	e1.y = 100;
	((MouseTrackListener)listener2).mouseExit(e1);
	
	Listener[] listen3 = ctrlBarItem.getListeners(SWT.MouseEnter);
	SWTEventListener listener3 = ((TypedListener) (listen3[1])).getEventListener();
	((MouseTrackListener)listener3).mouseEnter(e1);
    
    shell.dispose();
    display.dispose();
  }
}
