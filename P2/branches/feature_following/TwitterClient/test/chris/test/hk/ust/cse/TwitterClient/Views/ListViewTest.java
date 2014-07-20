package chris.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Composite;
import java.awt.CompositeContext;
import java.awt.RenderingHints;
import java.awt.image.ColorModel;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import hk.ust.cse.TwitterClient.Views.ControlBar;
import hk.ust.cse.TwitterClient.Views.ListView;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;


public class ListViewTest {
	
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    
    Shell shell = new Shell(display);
    
    ListView listView;
    
    listView = new ListView(shell, 10);
    assertNotNull(listView);
    
    listView.addItem(shell);
    
    listView = new ListView(shell,"myTitle", 10, null, null, null, null);
    assertNotNull(listView);
    
    listView.addItem(shell);
        
    shell.dispose();
    display.dispose();
  }
}
