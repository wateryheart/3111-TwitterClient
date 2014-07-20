package martin.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import hk.ust.cse.TwitterClient.Views.NumberBarItem;

import martin.test.utils.TestUtils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Rectangle;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;


public class NumberBarItemTest {

	 @Test(timeout=10000)
	  public void testConstructor() throws Throwable {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    long number = -1;
	    String title = "mytitle";
	    NumberBarItem item = new NumberBarItem( shell, number, title,
	    		10, 10,
	    		null, null, null,
	    		null, null
	    		);
	    assertNotNull(item);
	   
	    assertEquals( number, item.getNumber() );
	    assertEquals( title, item.getTitle() );
	    
	    
	    MouseTrackListener mouseTrackListener = TestUtils.getListener(item, SWT.MouseHover, "NumberBarItem");
	   if( mouseTrackListener == null )
	    	fail();
	   
	    //invoke
	    
	    Event event = new Event();
	    event.widget = item;
	    MouseEvent e = new MouseEvent(event);
	    
	    mouseTrackListener.mouseHover(e);
	    mouseTrackListener.mouseEnter(e);
	    mouseTrackListener.mouseExit(e);
	    
	    Rectangle arg0 = item.getClientArea();
	    e.x = arg0.x;
	    e.y = arg0.y;
	    mouseTrackListener.mouseExit(e);
	    
	    shell.dispose();
	    display.dispose();
	  }
	 


}
