package connie.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.*;


import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.ControlBarItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class ControlBarItemTest {

	@Test(timeout=10000)
	public void testControlBarItem() throws Throwable {
		Display display = new Display();
	    Shell shell = new Shell(display);
	    ControlBarItem ctrlBarItm = new ControlBarItem(shell, "ABC", Resources.HOME_IMG , Resources.HOME_HOVER_IMG);
	    assertNotNull(ctrlBarItm);
	    assertEquals("ABC", ctrlBarItm.getTitle());
	    ctrlBarItm.notifyListeners(SWT.MouseEnter, null);	
	    ctrlBarItm.notifyListeners(SWT.MouseHover, null);
	    assertEquals(Resources.HOME_HOVER_IMG,ctrlBarItm.getBackgroundImage());
	    ctrlBarItm.notifyListeners(SWT.MouseExit, null);
	    //assertEquals(Resources.HOME_IMG, ctrlBarItm.getBackgroundImage()); //error?
	    
	    Event event = new Event();
		event.x = -9999;
		event.y = -9999;
	    ctrlBarItm.notifyListeners(SWT.MouseEnter, event);
	    ctrlBarItm.notifyListeners(SWT.MouseHover, event);
	    //ctrlBarItm.setBounds(null);
	    ctrlBarItm.notifyListeners(SWT.MouseExit, event);

	    
	    shell.dispose();
	    display.dispose();
	}
}
