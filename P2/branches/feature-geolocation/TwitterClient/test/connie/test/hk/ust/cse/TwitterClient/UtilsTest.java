package connie.test.hk.ust.cse.TwitterClient;

import static org.junit.Assert.*;

import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.Basic.LinkLabel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.junit.Test;

public class UtilsTest {

	@Test(timeout=10000)
	public void testLoadImageFromUrl() throws Throwable{
		assertEquals(null,Utils.loadImageFromUrl(null));
	}

	@Test(timeout=10000)
	public void testLoadImageFromLocal() throws Throwable{
		assertNotNull(Utils.loadImageFromLocal(Resources.class, "./twitter_verified_account.png"));
	}

	@Test(timeout=10000)
	public void testLoadImageFromUrlAndScale() throws Throwable{
		assertEquals(null,Utils.loadImageFromUrlAndScale("",100,100));
		assertEquals(null,Utils.loadImageFromUrlAndScale(null,100,100));
		Utils.loadImageFromUrlAndScale("http://www.jupas.edu.hk/upload/Institutions/hkust.png", 200, 276);
		Utils.loadImageFromUrlAndScale("http://www.jupas.edu.hk/upload/Institutions/hkust.png", 200, 200);
		Utils.loadImageFromUrlAndScale("http://www.jupas.edu.hk/upload/Institutions/hkust.png", 110, 276);
	}

	@Test(timeout=10000)
	public void testSelectImageVersion() throws Throwable{
		Utils.selectImageVersion("a_bigger.png",40,40);
		Utils.selectImageVersion("a_bigger.png",0,40);
		Utils.selectImageVersion("a_bigger.png",0,70);
		assertEquals("a_normal.png",Utils.selectImageVersion("a_bigger.png",48,48));
		Utils.selectImageVersion("a_normal.png",70,70);
		Utils.selectImageVersion("a_normal.png",70,0);
		Utils.selectImageVersion("a_normal.png",0,40);
		Utils.selectImageVersion("a_normal.png",80,80);
		assertEquals("a_bigger.png",Utils.selectImageVersion("a_normal.png",73,73));
		Utils.selectImageVersion("a_bigger.png",40,100);
		Utils.selectImageVersion("a_bigger.png",100,100);
		assertEquals("a.png",Utils.selectImageVersion("a_bigger.png",100,100));	
	}


	@Test(timeout=10000)
	public void testGetColorFromString() throws Throwable{
		 assertEquals(new Color(null, 171, 205, 239), Utils.getColorFromString("ABCDEF"));
	}

	@Test(timeout=10000)
	public void testIsNullOrEmpty() throws Throwable {
		assertFalse(Utils.isNullOrEmpty("abc"));
		assertTrue(Utils.isNullOrEmpty(null));
		assertTrue(Utils.isNullOrEmpty(""));
	}

	@Test(timeout=10000)
	public void testDisposeWidget() throws Throwable{
		Utils utils = new Utils();
		assertNotNull(utils);
		Widget control = null;
		Utils.dispose(control);	
		Display display = new Display();
		Shell shell = new Shell(display);
		Utils.dispose(shell);
		display.dispose();
	}

	@Test(timeout=10000)
	public void testCutRoundCorner() throws Throwable{
		Display display = new Display();
	    Shell shell = new Shell(display);
	    Button button = new Button(shell, SWT.BUTTON1);
	    Utils.cutRoundCorner(button,false, false, false, false);
	    button.setSize(200, 200);
	    Utils.cutRoundCorner(button,true, true, true, true);
	    shell.dispose();
	    display.dispose();
	}

	@Test(timeout=10000)
	public void testDarkGradually() throws Throwable{
		//Image image = Utils.loadImageFromLocal(Resources.class, "./me.png");
		//Utils.darkGradually(image, 1);
		Image image1 = Utils.loadImageFromUrl("http://www.numark.com/images/sized/images/product_large/v7_web_large_00-624x390.jpg");
		Utils.darkGradually(image1, 3);
		Image image2 = Utils.loadImageFromUrl("http://zcstar.com/wonderphoto/image/32bit.gif");
		Utils.darkGradually(image2, 5);
	}

	@Test(timeout=10000)
	public void testAddClickListener() throws Throwable{
		Display display = new Display();
	    Shell shell = new Shell(display);
	    LinkLabel label = new LinkLabel(shell,1,Resources.LINK_COLOR,Resources.HOVER_COLOR,Resources.FONT11,Resources.FONT11B);
	    Utils.addClickListener(label, "click", this);
	    Event event = new Event();
	    event.widget = label;
	    event.type = SWT.MouseUp;
	    label.notifyListeners(SWT.MouseUp, event);	 
		event.type = SWT.MouseDown;
		label.notifyListeners(SWT.MouseDown, event);
		event.type = SWT.MouseDoubleClick;
		label.notifyListeners(SWT.MouseDoubleClick, event);
		label.dispose();
	    shell.dispose();
	    display.dispose();
	}

	@Test(timeout=10000)
	public void testAddEnterListener() throws Throwable{
		Display display = new Display();
	    Shell shell = new Shell(display);
	    Text text = new Text(shell,100);
	    Utils.addEnterListener(text, "string", this);
	    Event event = new Event();
	    event.widget = text;
	    event.type = SWT.KeyUp;
	    text.notifyListeners(SWT.KeyUp, event);	 
		event.type = SWT.KeyDown;
		text.notifyListeners(SWT.KeyDown, event);
		text.dispose();
	    shell.dispose();
	    display.dispose();
	}

}