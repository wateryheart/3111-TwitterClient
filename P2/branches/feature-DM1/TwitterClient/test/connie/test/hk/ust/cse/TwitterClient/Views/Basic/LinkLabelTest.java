package connie.test.hk.ust.cse.TwitterClient.Views.Basic;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.Basic.LinkLabel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class LinkLabelTest {

	@Test(timeout=10000)
	public void testLinkLabel() throws Throwable{
		Display display = new Display();
	    Shell shell = new Shell(display);
	    LinkLabel label = new LinkLabel(shell,1,Resources.LINK_COLOR,Resources.HOVER_COLOR,Resources.FONT11,Resources.FONT11B);
	    Event event = new Event();
	    event.widget = label;
	    event.type = SWT.MouseEnter;
	    label.notifyListeners(SWT.MouseEnter, event);	 
		//assertEquals(Resources.LINK_COLOR,label.getForeground());  //error?
		assertEquals(Resources.FONT11B,label.getFont());
		event.type = SWT.MouseHover;
		label.notifyListeners(SWT.MouseHover, event);
		//assertEquals(Resources.LINK_COLOR,label.getForeground());  //error?
		event.type = SWT.MouseExit;
		label.notifyListeners(SWT.MouseExit, event);
		//assertEquals(Resources.HOVER_COLOR,label.getForeground()); //error?
		assertEquals(Resources.FONT11,label.getFont());
		label.dispose();
	    shell.dispose();
	    display.dispose();
	}

}
