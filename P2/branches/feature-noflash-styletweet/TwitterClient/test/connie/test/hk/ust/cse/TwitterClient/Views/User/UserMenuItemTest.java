package connie.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.User.UserMenuItem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class UserMenuItemTest {


	@Test(timeout=10000)
	public void testUserMenuItem() throws Throwable{
		Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    UserMenuItem userMenuItem = new UserMenuItem(shell,"User Menu Item", 100, 200, Resources.FONT10, Resources.FONT18B);
	    assertNotNull(userMenuItem);
	    assertEquals("User Menu Item", userMenuItem.getTitle());
	    assertEquals(100,userMenuItem.getBounds().width);
	    assertEquals(200,userMenuItem.getBounds().height);
	    userMenuItem.setClicked();	      		    
	    userMenuItem.notifyListeners(SWT.MouseEnter, null);	    
	    userMenuItem.notifyListeners(SWT.MouseHover, null);
	    userMenuItem.notifyListeners(SWT.MouseExit, null);
	    userMenuItem.setNotClicked();
	    userMenuItem.notifyListeners(SWT.MouseEnter, null);	    
	    userMenuItem.notifyListeners(SWT.MouseHover, null);
	    userMenuItem.notifyListeners(SWT.MouseExit, null);
	    Event event = new Event();
	    event.widget = userMenuItem;
		event.x = 1000;
		event.y = 1000;
	    userMenuItem.setClicked();	
	    userMenuItem.notifyListeners(SWT.MouseExit, event);    
	    userMenuItem.notifyListeners(SWT.MouseHover, event);
	    userMenuItem.notifyListeners(SWT.MouseEnter, event);	
	    
	    userMenuItem.setNotClicked();
	    userMenuItem.notifyListeners(SWT.MouseExit, event);    
	    userMenuItem.notifyListeners(SWT.MouseHover, event);
	    userMenuItem.notifyListeners(SWT.MouseEnter, event);	
	    shell.dispose();
		display.dispose();
	}

}
