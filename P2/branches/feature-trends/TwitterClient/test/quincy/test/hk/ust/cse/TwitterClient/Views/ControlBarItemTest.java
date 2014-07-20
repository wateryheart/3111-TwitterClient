package quincy.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Views.ControlBarItem;
import hk.ust.cse.TwitterClient.Resources.Resources;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class ControlBarItemTest {

	 @Test(timeout=10000)
	  public void testConstructor() throws Throwable {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    ControlBarItem item = new ControlBarItem(shell, "abc", Resources.HOME_IMG,  Resources.HOME_HOVER_IMG);
	    assertNotNull(item);
	    assertEquals("abc", item.getTitle());
	    shell.dispose();
	    display.dispose();
	  }
	}