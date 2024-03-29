package martin.test.hk.ust.cse.TwitterClient.Views.Basic;

import static org.junit.Assert.fail;

import hk.ust.cse.TwitterClient.Views.Basic.ClickableImageLabel;

import martin.test.utils.TestUtils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Ignore;
import org.junit.Test;


public class ClickableImageLabelTest {
	 @Test(timeout=10000)
	  public void testConstructor() throws Throwable {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    
	    Event event = new Event();
	    event.widget = shell;
	    MouseEvent e = new MouseEvent(event);
	    
	    Image img = new Image(display,1,1);
	    Object handlerCallee = null;
	    ClickableImageLabel label = new ClickableImageLabel(shell, 0, img, img, "clickHandler", this);
	   
	    // --
	    MouseTrackListener mouseTrackListener = TestUtils.getListener(label, SWT.MouseHover, "ClickableImageLabel");
	   if( mouseTrackListener == null )
	    	fail();
	   
	    //invoke	    
	    event = new Event();
	    event.widget = label;
	    e = new MouseEvent(event);
	    
	    mouseTrackListener.mouseHover(e);
	    mouseTrackListener.mouseEnter(e);
	    mouseTrackListener.mouseExit(e);
		  
	    // --
	    MouseListener mouseListener = TestUtils.getListener(label, SWT.MouseUp, "ClickableImageLabel");
	    if( mouseTrackListener == null )
	    	fail();
	    
	    //invoke
	    event = new Event();
	    event.widget = label;
	    e = new MouseEvent(event);
	    
	    mouseListener.mouseUp(e);
	    mouseListener.mouseDown(e);
	    mouseListener.mouseDoubleClick(e);
	    
	    
	    shell.dispose();
	    display.dispose();
	  }
	 
	 @Ignore
	 public void clickHandler(MouseEvent arg0){
		 
	 }
}
