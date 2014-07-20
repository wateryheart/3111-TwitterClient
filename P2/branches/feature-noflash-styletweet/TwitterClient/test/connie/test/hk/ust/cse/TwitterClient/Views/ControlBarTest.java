package connie.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Views.ControlBar;
import hk.ust.cse.TwitterClient.Views.ControlBarItem;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.junit.Test;

public class ControlBarTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    ControlBar ctrlBar = new ControlBar(shell, 10, 20, 0, "btnClkHandler", "enterHandler", null);
    assertNotNull(ctrlBar);
    assertEquals(10, ctrlBar.getBounds().width);
    assertEquals(20, ctrlBar.getBounds().height);
    assertEquals("",ctrlBar.getGotoPeopleName());
    
    ctrlBar.setFocus();
    ctrlBar.notifyListeners(SWT.FocusIn, null);
    RowComposite gotoFrame = new RowComposite(ctrlBar, SWT.LEFT, SWT.HORIZONTAL, false, 7, 7, 0, 0, 10);
    gotoFrame.setAlignMiddle(10);
    gotoFrame.getWidth();
    gotoFrame.getHeight();
    Image logo = Utils.loadImageFromUrl("https://twimg0-a.akamaihd.net/profile_images/1264705103/3_bigger.JPG");
    RowComposite textFrame = new RowComposite(gotoFrame, SWT.LEFT, SWT.HORIZONTAL, false, 3, 3, 0, 0, -1);
    ControlBarItem testItem = new ControlBarItem(shell,"titile",logo,logo);
    testItem.getTitle();
    
    Event event = new Event();
    event.widget = testItem;
    event.type = SWT.MouseExit;
    testItem.notifyListeners(SWT.MouseExit,event);
    event.type = SWT.MouseExit;
    event.x = 1000;
    event.y = 1000;
    testItem.notifyListeners(SWT.MouseExit,event);
    event.type = SWT.MouseHover;
    testItem.notifyListeners(SWT.MouseHover,event);
    event.type = SWT.MouseEnter;
    testItem.notifyListeners(SWT.MouseEnter,event);
    
    event = new Event();
    event.widget = ctrlBar;
    event.type= SWT.FocusIn;
    ctrlBar.notifyListeners(SWT.FocusIn,event);
    event.type = SWT.FocusOut;
    ctrlBar.notifyListeners(SWT.FocusOut, event);
    /*
    event = new Event();
    FocusEvent fEvent = new FocusEvent(event);
    Text t = new Text(textFrame, SWT.LEFT);
    event.widget = t;
    fEvent.widget = t;
    fEvent.notifyAll();
    t.setFocus();
    t.forceFocus();
    t.notifyListeners(SWT.FocusIn,event);
    t.notifyListeners(SWT.FocusOut, event);
    */
    
    Text text1 = new Text(shell,SWT.WRAP|SWT.BORDER);
    text1.setBounds(100,50,100,20);
    text1.setText("hungry");
    event.type = SWT.FOCUSED;
    testItem.notifyListeners(SWT.FOCUSED, event);
    testItem.setVisible(true);
    
    ctrlBar.dispose();
    shell.dispose();
    display.dispose();
  }
}
