package connie.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.NumberBar;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class NumberBarTest {

	@Test(timeout=10000)
	public void testNumberBar() {
		Display display = new Display();
		Shell shell = new Shell(display);
		long[] num = {123456789,987654321};
		String[] titles = {"a", "b", "c"};
		NumberBar numberBar = new NumberBar(shell, num , titles, 100, 50, 200, Resources.GRAY_COLOR, Resources.HOVER_COLOR, Resources.LINK_COLOR, Resources.FONT10, Resources.FONT11B, true, "numhandler" , null);
	    assertNotNull(numberBar);
	    assertEquals(100, numberBar.getWidth());
	    assertEquals(200, numberBar.getHeight());
	    assertTrue(numberBar.getVisible());
	    assertTrue(numberBar.getEnabled());
	    numberBar.dispose();
	    numberBar = new NumberBar(shell, num , titles, 100, 50, 200, Resources.GRAY_COLOR, Resources.HOVER_COLOR, Resources.LINK_COLOR, Resources.FONT10, Resources.FONT11B, false, null , null);
	    assertNotNull(numberBar);
	    numberBar.dispose();
	    shell.dispose();
	    display.dispose();
	}

}
