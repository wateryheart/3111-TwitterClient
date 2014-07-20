package connie.test.hk.ust.cse.TwitterClient.Views.Basic;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.Basic.ClickableImageLabel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class ClickableImageLabelTest {

	@Test(timeout=10000)
	public void testClickableImageLabel() throws Throwable{
		Display display = new Display();
	    Shell shell = new Shell(display);
		ClickableImageLabel cil = new ClickableImageLabel(shell, 1, Resources.GO_IMG,  Resources.GO_CLICKED_IMG, "clickHandler",null);
		Event event = new Event();
		event.widget = cil;
		event.x = -9999;
		event.y = -9999;
		cil.notifyListeners(SWT.MouseEnter, event);	 
		assertEquals(Resources.GO_CLICKED_IMG,cil.getImage());
		cil.notifyListeners(SWT.MouseHover, event);
		cil.notifyListeners(SWT.MouseExit, event);
		assertEquals(Resources.GO_IMG,cil.getImage());
		cil.notifyListeners(SWT.MouseUp, event);
		cil.notifyListeners(SWT.MouseDown, event);
		cil.notifyListeners(SWT.MouseDoubleClick, event);
		cil.notifyListeners(SWT.MouseEnter, null);	 
		cil.notifyListeners(SWT.MouseHover, null);
		cil.notifyListeners(SWT.MouseExit, null);
		cil.notifyListeners(SWT.MouseUp, null);
		cil.notifyListeners(SWT.MouseDown, null);
		cil.notifyListeners(SWT.MouseDoubleClick, null);
		cil.dispose();
	    shell.dispose();
	    display.dispose();
	}

}
