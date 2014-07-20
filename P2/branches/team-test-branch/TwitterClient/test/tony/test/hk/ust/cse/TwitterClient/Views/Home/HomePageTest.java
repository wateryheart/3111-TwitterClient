package tony.test.hk.ust.cse.TwitterClient.Views.Home;

import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.Home.HomePage;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class HomePageTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);

      try{
          HomePage profile = new HomePage(shell, 10, 10, 10, 10, 10, null, null, null);
          assertNotNull(profile);
      }catch (Exception ex ){ }

    shell.dispose();
    display.dispose();
  }
}
