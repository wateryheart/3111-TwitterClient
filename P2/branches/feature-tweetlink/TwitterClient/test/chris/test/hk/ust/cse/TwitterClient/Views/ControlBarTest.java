package chris.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;

import hk.ust.cse.TwitterClient.Views.ControlBar;
import hk.ust.cse.TwitterClient.Views.WholePage;

import martin.test.utils.TestUtils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.junit.Test;


public class ControlBarTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    ControlBar ctrlBar = new ControlBar(shell, 10, 10, 0, null, null, null);
    assertNotNull(ctrlBar);
    assertEquals(10, ctrlBar.getBounds().width);
    assertEquals(10, ctrlBar.getBounds().height);
    assertEquals("", ctrlBar.getGotoPeopleName());
    
    
    // -----
    
    
    //---------------------------------------
    Class<?> wholePageCls = WholePage.class;
    Class<?> controlBarCls = ControlBar.class;

    Field m_people_Field = controlBarCls.getDeclaredField("m_people");
    assertNotNull(m_people_Field);
    m_people_Field.setAccessible(true);
    Text m_people =(Text) m_people_Field.get(ctrlBar);
    assertNotNull(m_people);
    // -------------------------------------
    
    FocusListener focusListener = TestUtils.getListener(m_people, SWT.FocusOut, "ControlBar");
	   if( focusListener == null )
	    	fail();
	   
	    //invoke
	    
	    Event event = new Event();
	    event.widget = m_people;
	    FocusEvent e = new FocusEvent(event);
	    focusListener.focusLost(e);
	    focusListener.focusGained(e);	  
    shell.dispose();
    display.dispose();
  }
}
