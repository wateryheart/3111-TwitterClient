package chris.test.hk.ust.cse.TwitterClient.Views.Basic;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Views.Basic.ClickableComposite;
import hk.ust.cse.TwitterClient.Views.Basic.HoverClickableComposite;

import martin.test.utils.TestUtils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Ignore;
import org.junit.Test;


public class ClickableCompositeTest {
	 @Test(timeout=10000)
	  public void testConstructor() throws Throwable {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    
	    Event event = new Event();
	    event.widget = shell;
	    MouseEvent e = new MouseEvent(event);
	    

	    ClickableComposite composite = new ClickableComposite(shell);
	  	    
	    // --
	    MouseTrackListener mouseTrackListener = TestUtils.getListener(composite, SWT.MouseHover, "ClickableComposite");
	   if( mouseTrackListener == null )
	    	fail();
	   
	    //invoke	    
	    event = new Event();
	    event.widget = composite;
	    e = new MouseEvent(event);
	    
	    mouseTrackListener.mouseHover(e);
	    mouseTrackListener.mouseEnter(e);
	    mouseTrackListener.mouseExit(e);
		  
	   	    
	    shell.dispose();
	    display.dispose();
	  }
	 
	 @Ignore
	 public void clickHandler(MouseEvent arg0){
		 
	 }
}
