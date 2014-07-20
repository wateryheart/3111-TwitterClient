package park.test.hk.ust.cse.TwitterClient.Views.Basic;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;

import hk.ust.cse.TwitterClient.Views.Basic.ClickableImageLabel;
import hk.ust.cse.TwitterClient.Views.User.UserMenu;
import hk.ust.cse.TwitterClient.Views.User.UserPage;
import hk.ust.cse.TwitterClient.Resources.Resources;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.internal.SWTEventListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TypedListener;
import org.junit.Test;


public class ClickableImageLabelTest {
  @Test(timeout=10000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    ClickableImageLabel clickImag = new ClickableImageLabel(shell, 0, Resources.HOME_IMG, 
    	      Resources.HOME_HOVER_IMG, "onMenuItemClicked", null);
    
    assertNotNull(clickImag);

    Event event1 = new Event();
	event1.widget = clickImag;
	MouseEvent e1 = new MouseEvent(event1);
	Listener[] listen1 = clickImag.getListeners(SWT.MouseHover);
	SWTEventListener listener1 = ((TypedListener) (listen1[0])).getEventListener();
	((MouseTrackListener)listener1).mouseHover(e1);
	
	Listener[] listen2 = clickImag.getListeners(SWT.MouseExit);
	SWTEventListener listener2 = ((TypedListener) (listen2[0])).getEventListener();
	((MouseTrackListener)listener2).mouseExit(e1);
	
	Listener[] listen3 = clickImag.getListeners(SWT.MouseEnter);
	SWTEventListener listener3 = ((TypedListener) (listen3[0])).getEventListener();
	((MouseTrackListener)listener3).mouseEnter(e1);
	
	//Listener[] listen4 = clickImag.getListeners(SWT.MouseDown);
	//SWTEventListener listener4 = ((TypedListener) (listen4[0])).getEventListener();
	//((MouseListener)listener4).mouseDown(e1);
	
	Listener[] listen5 = clickImag.getListeners(SWT.MouseUp);
	SWTEventListener listener5 = ((TypedListener) (listen5[0])).getEventListener();
	((MouseListener)listener5).mouseUp(e1);
	
	Listener[] listen6 = clickImag.getListeners(SWT.MouseDoubleClick);
	SWTEventListener listener6 = ((TypedListener) (listen6[0])).getEventListener();
	((MouseListener)listener6).mouseDoubleClick(e1);
    
    shell.dispose();
    display.dispose();
  }
  
  private UserMenu getPrivateUserMenu(UserPage userPage){
		UserMenu userTest = null;
		try{
			Field field = UserPage.class.getDeclaredField("m_leftMenu");
			field.setAccessible(true);
			userTest = (UserMenu)field.get(userPage);
				
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return userTest;
		
	}
  
  private int getPrivateInt(UserMenu userPage){
		int userTest = 0;
		try{
			Field field = UserMenu.class.getDeclaredField("m_currSelected");
			field.setAccessible(true);
			//userTest = (int)field.get(userPage);
				
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return userTest;
		
	}
  
  
}
