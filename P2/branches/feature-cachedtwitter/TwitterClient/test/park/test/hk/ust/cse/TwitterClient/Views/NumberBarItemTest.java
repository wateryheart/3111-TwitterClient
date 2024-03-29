package park.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.NumberBarItem;

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

public class NumberBarItemTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    NumberBarItem numBarItem = new NumberBarItem(shell, 10, "Tweets", 10, 10, Resources.WHITE_COLOR, Resources.HOVER_COLOR, Resources.HOVER_COLOR, 
    		Resources.FONT11, Resources.FONT11I);
    assertNotNull(numBarItem);
    
    Event event1 = new Event();
	event1.widget = numBarItem;
	MouseEvent e1 = new MouseEvent(event1);
	Listener[] listen1 = numBarItem.getListeners(SWT.MouseHover);
	SWTEventListener listener1 = ((TypedListener) (listen1[2])).getEventListener();
	((MouseTrackListener)listener1).mouseHover(e1);
	
	Listener[] listen2 = numBarItem.getListeners(SWT.MouseExit);
	SWTEventListener listener2 = ((TypedListener) (listen2[2])).getEventListener();
	((MouseTrackListener)listener2).mouseExit(e1);
	
	e1.x = 100;
	e1.y = 100;
	((MouseTrackListener)listener2).mouseExit(e1);
	
	Listener[] listen3 = numBarItem.getListeners(SWT.MouseEnter);
	SWTEventListener listener3 = ((TypedListener) (listen3[2])).getEventListener();
	((MouseTrackListener)listener3).mouseEnter(e1);
	
	assertEquals(10, numBarItem.getNumber());

    shell.dispose();
    display.dispose();
  }
}