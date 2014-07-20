package martin.test.hk.ust.cse.TwitterClient.Views.Basic;

import static org.junit.Assert.fail;
import hk.ust.cse.TwitterClient.Views.Basic.LinkLabel;

import martin.test.utils.TestUtils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;


public class LinkLabelTest {
	 @Test(timeout=10000)
	  public void testConstructor() throws Throwable {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    
	    Event event = new Event();
	    event.widget = shell;
	    MouseEvent e = new MouseEvent(event);
	    
	    LinkLabel label = new LinkLabel(shell, 0, null, null, null, null); 
	   
	    MouseTrackListener mouseTrackListener = TestUtils.getListener(label, SWT.MouseHover, "LinkLabel");
	   if( mouseTrackListener == null )
	    	fail();
	   
	    //invoke
	    
	    event = new Event();
	    event.widget = label;
	    e = new MouseEvent(event);
	    
	    mouseTrackListener.mouseHover(e);
	    mouseTrackListener.mouseEnter(e);
	    mouseTrackListener.mouseExit(e);
	    
	    shell.dispose();
	    display.dispose();
	  }
}
