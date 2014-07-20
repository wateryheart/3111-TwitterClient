package connie.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.*;

import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.NumberBarItem;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class NumberBarItemTest {

	@Test(timeout=10000)
	public void testNumberBarItem()throws Throwable {
		Display display = new Display();
	    Shell shell = new Shell(display);
	    NumberBarItem noBarItm = new NumberBarItem(shell, 123456789, "ABC", 200, 300, Resources.SPLIT_COLOR, Resources.HOVER_COLOR, Resources.SPLIT_COLOR, Resources.FONT11I, Resources.FONT12); 
	    assertNotNull(noBarItm);
	    assertEquals("ABC", noBarItm.getTitle());
	    assertEquals(123456789, noBarItm.getNumber());
	    assertEquals(200,noBarItm.getBounds().width);
	    assertEquals(300,noBarItm.getBounds().height);
		//assertEquals(Resources.SPLIT_COLOR, noBarItm.getBackground());	 //error?  
		
		RowComposite content = new RowComposite(noBarItm, 0, SWT.VERTICAL, false, 0, 0, 0, 0, 2);
		Label label = new Label(content, SWT.LEFT);
		noBarItm.notifyListeners(SWT.MouseEnter, null);
		//assertEquals(Resources.LINK_COLOR,label.getForeground()); //error?
	    noBarItm.notifyListeners(SWT.MouseExit, null);
	    //assertEquals(Resources.GRAY_COLOR,label.getForeground()); //error?
	    noBarItm.notifyListeners(SWT.MouseHover, null);
	    shell.dispose();
	    display.dispose();
	}
}
