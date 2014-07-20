package park.test.hk.ust.cse.TwitterClient.Views.Basic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class RowCompositeTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    RowComposite rowComp = new RowComposite(shell, 0, 0, true, 
    	      10, 10, 10, 10, 10);
    assertEquals(0, rowComp.getWidth());
    assertEquals(0,rowComp.getHeight());
    assertNotNull(rowComp);

    shell.dispose();
    display.dispose();
  }
}
