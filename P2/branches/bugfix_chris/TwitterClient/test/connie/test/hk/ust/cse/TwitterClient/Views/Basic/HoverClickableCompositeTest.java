package connie.test.hk.ust.cse.TwitterClient.Views.Basic;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.Basic.HoverClickableComposite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class HoverClickableCompositeTest {

	@Test(timeout=10000)
	public void testHoverClickableComposite() throws Throwable{
		Display display = new Display();
		Shell shell = new Shell(display);		
		HoverClickableComposite hover = new  HoverClickableComposite(shell, Resources.SPLIT_COLOR, Resources.HOVER_COLOR, Resources.LINK_COLOR);
		assertNotNull(hover);
		Event event = new Event();
		event.widget = hover;
		event.x = -9999;
		event.y = -9999;
		hover.setClicked();
		//assertEquals(Resources.LINK_COLOR,hover.getBackground());
		assertTrue(hover.isClicked());
		hover.notifyListeners(SWT.MouseEnter, event);    
		hover.notifyListeners(SWT.MouseHover, event);
		hover.notifyListeners(SWT.MouseExit, event);
		event.x = 0;
		event.y = 0;
		hover.setNotClicked();
		//assertEquals(Resources.HOVER_COLOR,hover.getBackground());
		hover.isClicked();
		assertFalse(hover.isClicked());
		hover.notifyListeners(SWT.MouseEnter, event);    
		hover.notifyListeners(SWT.MouseHover, event);
		hover.notifyListeners(SWT.MouseExit, event);
		hover.dispose();
		shell.dispose();
		display.dispose();
	}
}
