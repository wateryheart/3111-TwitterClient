package tony.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.NumberBarItem;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class NumberBarItemTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    try{
    	NumberBarItem numBarItem = new NumberBarItem(shell, 10, null, 10, 0, null, null, null, null, null);
    	assertNotNull(numBarItem);
    	assertEquals(10, numBarItem.getBounds().width);
    	assertEquals(10, numBarItem.getBounds().height);
    }catch(Exception ex){}
    shell.dispose();
    display.dispose();
  }
}
