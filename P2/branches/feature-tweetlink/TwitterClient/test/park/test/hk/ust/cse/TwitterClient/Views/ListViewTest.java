package park.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.ListView;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class ListViewTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    ListView listView = new ListView(shell, 10);
    assertNotNull(listView);
    
    listView.addItem(shell);

    shell.dispose();
    display.dispose();
  }
}