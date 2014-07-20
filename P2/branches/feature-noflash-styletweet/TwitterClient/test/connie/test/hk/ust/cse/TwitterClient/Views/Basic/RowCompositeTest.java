package connie.test.hk.ust.cse.TwitterClient.Views.Basic;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class RowCompositeTest {

	@Test(timeout=10000)
	public void testRowComposite() throws Throwable{
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    RowComposite RC = new RowComposite(shell, 10, 10, true, 10, 10, 10, 10, 10);
	    assertNotNull(RC);
	    assertEquals(0, RC.getWidth());
	    assertEquals(0, RC.getHeight());
	    RC.dispose();
	    RC = new RowComposite(shell, 0, 0, false, -1, -1, -1, -1, -1);
	    assertNotNull(RC);
	    RC.setAlignMiddle(10);
	    shell.dispose();
	    display.dispose();
	}

}
