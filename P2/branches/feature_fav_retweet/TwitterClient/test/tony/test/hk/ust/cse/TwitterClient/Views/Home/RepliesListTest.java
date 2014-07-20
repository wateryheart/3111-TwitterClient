package tony.test.hk.ust.cse.TwitterClient.Views.Home;

import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.Home.RepliesList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class RepliesListTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    RepliesList list = new RepliesList(shell, null, 10, null, null);
    assertNotNull(list);
    shell.dispose();
    display.dispose();
  }
}
