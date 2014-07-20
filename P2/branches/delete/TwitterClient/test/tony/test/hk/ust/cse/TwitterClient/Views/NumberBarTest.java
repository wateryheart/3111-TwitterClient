package tony.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.NumberBar;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class NumberBarTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    try{
	    NumberBar numBar = new NumberBar(shell, null, null, 10, 10, 0, null, null, null, null, null, false, null, shell);
	    assertNotNull(numBar);
	    assertEquals(10, numBar.getBounds().width);
	    assertEquals(10, numBar.getBounds().height);
    }catch(Exception ex){}
    shell.dispose();
    display.dispose();
  }
}
