package park.test.hk.ust.cse.TwitterClient.Views.Basic;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Views.Basic.HoverClickableComposite;
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

public class HoverClickableCompositeTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    HoverClickableComposite hoverClick = new HoverClickableComposite(shell,Resources.MINI_PROFILE_COLOR, Resources.WHITE_COLOR, Resources.WHITE_COLOR);
    assertNotNull(hoverClick);
    assertFalse(hoverClick.isClicked());
   
    Event event1 = new Event();
	event1.widget = hoverClick;
	MouseEvent e1 = new MouseEvent(event1);
	Listener[] listen1 = hoverClick.getListeners(SWT.MouseHover);
	SWTEventListener listener1 = ((TypedListener) (listen1[1])).getEventListener();
	((MouseTrackListener)listener1).mouseHover(e1);
	
	Listener[] listen2 = hoverClick.getListeners(SWT.MouseExit);
	SWTEventListener listener2 = ((TypedListener) (listen2[1])).getEventListener();
	((MouseTrackListener)listener2).mouseExit(e1);
	
	e1.x = 10;
	e1.y = 10;
	((MouseTrackListener)listener2).mouseExit(e1);
	
	Listener[] listen3 = hoverClick.getListeners(SWT.MouseEnter);
	SWTEventListener listener3 = ((TypedListener) (listen3[1])).getEventListener();
	((MouseTrackListener)listener3).mouseEnter(e1);
	
	hoverClick.setClicked();
	((MouseTrackListener)listener3).mouseEnter(e1);
	((MouseTrackListener)listener2).mouseExit(e1);
	
    shell.dispose();
    display.dispose();
  }

}
