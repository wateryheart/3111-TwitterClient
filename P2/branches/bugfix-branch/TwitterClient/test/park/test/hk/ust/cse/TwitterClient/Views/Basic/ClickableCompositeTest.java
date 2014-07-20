package park.test.hk.ust.cse.TwitterClient.Views.Basic;

import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.Basic.ClickableComposite;

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

public class ClickableCompositeTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    ClickableComposite clickCom = new ClickableComposite(shell);
    assertNotNull(clickCom);

    Event event1 = new Event();
	event1.widget = clickCom;
	MouseEvent e1 = new MouseEvent(event1);
	Listener[] listen1 = clickCom.getListeners(SWT.MouseHover);
	SWTEventListener listener1 = ((TypedListener) (listen1[0])).getEventListener();
	((MouseTrackListener)listener1).mouseHover(e1);
	
	Listener[] listen2 = clickCom.getListeners(SWT.MouseExit);
	SWTEventListener listener2 = ((TypedListener) (listen2[0])).getEventListener();
	((MouseTrackListener)listener2).mouseExit(e1);
	
	Listener[] listen3 = clickCom.getListeners(SWT.MouseEnter);
	SWTEventListener listener3 = ((TypedListener) (listen3[0])).getEventListener();
	((MouseTrackListener)listener3).mouseEnter(e1);
    
    shell.dispose();
    display.dispose();
  }
}
