package chris.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import hk.ust.cse.TwitterClient.Views.User.UserMenu;
import hk.ust.cse.TwitterClient.Views.User.UserMenuItem;

import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Test;


public class UserMenuTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    UserMenu userMenu = new UserMenu(shell, 10, 10, "itmClkHandler", new Object());
    assertNotNull(userMenu);
    
    List<UserMenuItem> items = userMenu.getMenuItems();
    assertNotNull(items);
    System.out.println("UserMenuItems: " + items.size());
    
    int currSelected = 0;
    userMenu.setCurrentSelected(currSelected);
    int re_currSelected = userMenu.getCurrentSelected();
    assertEquals(currSelected,re_currSelected);
    
    System.out.println("UserMenuItems: " + items.size());
    
    Event event;
	MouseEvent e;
	
    //invoke
    event = new Event();
    event.widget = items.get(0);
    e = new MouseEvent(event);
    
    userMenu.onMenuItemClicked(e);
    
    event = new Event();
    event.widget = new Button(items.get(1), 0);
    e = new MouseEvent(event);
    
    userMenu.onMenuItemClicked(e);
    shell.dispose();
    display.dispose();
  }

}
