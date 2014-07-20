package park.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.NumberBar;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class NumberBarTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    long[] nums={1,2,3};
    String[] stgs={"a","b","c"};
    
    NumberBar numBar = new NumberBar(shell, nums, stgs, 10, 10, 10, Resources.WHITE_COLOR, Resources.HOVER_COLOR, Resources.HOVER_COLOR, 
  	      Resources.FONT11, Resources.FONT11I, true, null, null);
    assertNotNull(numBar);

    shell.dispose();
    display.dispose();
  }
}