package connie.test.hk.ust.cse.TwitterClient.Views.Basic;

import static org.junit.Assert.*;

import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.Basic.ClickableComposite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;


public class ClickableCompositeTest {

	@Test(timeout=10000)
	public void testClickableComposite() throws Throwable{
		Display display = new Display();
	    Shell shell = new Shell(display);
	    ClickableComposite cc = new ClickableComposite(shell);
	    cc.notifyListeners(SWT.MouseEnter, null);
	    assertEquals(Resources.HAND_CURSOR,cc.getCursor());
	    cc.notifyListeners(SWT.MouseHover, null);
	    cc.notifyListeners(SWT.MouseExit, null);
	       
	    cc.dispose();
	    shell.dispose();
	    display.dispose();
	}

}
