package chris.test.hk.ust.cse.TwitterClient.Views.Basic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;
public class RowCompositeTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    RowComposite rowComposite;
    rowComposite = new RowComposite( shell , 0, 0, false, 0, 0, 0, 0, 0);    
    assertNotNull(rowComposite);
    
    rowComposite = new RowComposite( shell, 1, 1, true, 1, 1, 1, 1, 1);    
    assertNotNull(rowComposite);
    
    int width = rowComposite.getWidth(); 
    int height = rowComposite.getHeight();
    
    rowComposite.setAlignMiddle(10);
    
    shell.dispose();
    display.dispose();
  }

}
