package connie.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.User.UserMenu;
import hk.ust.cse.TwitterClient.Views.User.UserMenuItem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class UserMenuTest {

	@Test(timeout=10000)
	public void testUserMenu()throws Throwable {
		Display display = new Display();
		Shell shell = new Shell(display);
		UserMenu userMenu = new UserMenu(shell, 100, 200, "onMenuItemClicked", null); 
	    assertNotNull(userMenu);
	    List<UserMenuItem> userMenuIteml = new ArrayList <UserMenuItem>();
	    assertNotNull(userMenuIteml);
	    assertEquals(100, userMenu.getWidth());
	    //assertEquals(200, userMenu.getHeight());
	    
	    userMenu.setCurrentSelected(0);
	    assertEquals(0,userMenu.getCurrentSelected());
	    userMenu.getMenuItems();
	    UserMenuItem userMenuItem = new UserMenuItem(userMenu,"title",20,10,Resources.FONT10,Resources.FONT11);
	    userMenuItem.getTitle();
	    
	    Event event = new Event();
	    event.widget = userMenuItem;
	    event.type = SWT.MouseDown;
	    MouseEvent mevent = new MouseEvent(event);
	    try{
	    	userMenu.getChildren()[0].notifyListeners(0, event);
	    	userMenu.onMenuItemClicked(mevent);
	    	}catch(Exception e){}
	    
	    userMenuItem.dispose();
	    userMenuIteml.clear();
	    userMenu.dispose();
	    userMenu = new UserMenu(shell, 100, 200, null, null); 
	    try{userMenu.onMenuItemClicked(mevent);}catch(Exception e){}
	    userMenu.dispose();	    
		shell.dispose();
		display.dispose();
	}
}
