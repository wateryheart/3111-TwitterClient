package tony.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.WholePage;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class WholePageTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
      try{
          WholePage whole = new WholePage(shell, 100, 100);
          assertNotNull(whole);
      }catch (Exception ex){}

    shell.dispose();
    display.dispose();
  }
}
