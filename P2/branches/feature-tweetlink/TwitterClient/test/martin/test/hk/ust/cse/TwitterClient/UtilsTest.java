package martin.test.hk.ust.cse.TwitterClient;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Views.User.FriendView;
import hk.ust.cse.TwitterClient.Views.User.UserPage;

import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import martin.test.utils.TestUtils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;
import org.junit.Ignore;
import org.junit.Test;


public class UtilsTest {
  @Test(timeout=10000)
  public void testGetColorFromString() throws Throwable {
    assertEquals(new Color(null, 171, 205, 239), Utils.getColorFromString("ABCDEF"));
  }
  
  @Test(timeout=10000)
  public void testloadImageFromUrlAndScale() throws Throwable{
	  String url = TestUtils.getResourceURL("logo.png");
	  
	  int scaleWidth  = 48;
	  int scaleHeight = 48;
	  Image image;
	  image = Utils.loadImageFromUrlAndScale(url, scaleWidth, scaleHeight);
	  assertNotNull(image);
	  image = Utils.loadImageFromUrlAndScale(url, 50, 50);
	  assertNotNull(image);

	  image = Utils.loadImageFromUrlAndScale(url, 48, 50);
	  assertNotNull(image);
	  
	  image = Utils.loadImageFromUrlAndScale(url, 50, 48);
	  assertNotNull(image);
	  
	  image = Utils.loadImageFromUrlAndScale("", scaleWidth, scaleHeight);
	  assertNull(image);
  }
  
  @Test(timeout=10000)
  public void testselectImageVersion() throws Throwable{
	  String url;
	  url = Utils.selectImageVersion("abc_normal.png", 48, 48);
	  assertEquals( url, "abc_normal.png");
	  
	  url = Utils.selectImageVersion("abc_normal.png", 73, 73);
	  assertEquals( url, "abc_bigger.png");
	  
	  url = Utils.selectImageVersion("abc_normal.png", 48, 73);
	  assertEquals( url, "abc_bigger.png");
	  
	  url = Utils.selectImageVersion("abc_bigger.png", 48, 48);
	  assertEquals( url, "abc_normal.png");
	  
	  url = Utils.selectImageVersion("abc_bigger.png", 73, 73);
	  assertEquals( url, "abc_bigger.png");
	  
	  url = Utils.selectImageVersion("abc_bigger.png", 73, 48);
	  assertEquals( url, "abc_bigger.png");
	  
	  url = Utils.selectImageVersion("abc_normal.png", 73, 100);
	  assertEquals( url, "abc.png");
	  
	  url = Utils.selectImageVersion("abc_bigger.png", 100, 73);
	  assertEquals( url, "abc.png");
	  
	  url = Utils.selectImageVersion("abc_normal.png", 100, 100);
	  assertEquals( url, "abc.png");
	  
	  url = Utils.selectImageVersion("abc_bigger.png", 100, 100);
	  assertEquals( url, "abc.png");
	  
	  
	  url = Utils.selectImageVersion("abc.png", 100, 100);
	  assertEquals( url, "abc.png");
	  
	  url = Utils.selectImageVersion("abc.png", 100, 100);
	  assertEquals( url, "abc.png");
  }
  
  @Test(timeout=10000)
  public void testIsNullOrEmpty() throws Throwable{
	  
	  assertEquals( true, Utils.isNullOrEmpty("") );
	  assertEquals( true, Utils.isNullOrEmpty(null) );
	  assertEquals( false, Utils.isNullOrEmpty("123") );
  
  }
  
  @Test(timeout=10000)
  public void testDispose() throws Throwable{
	Display display = new Display();
	Shell shell = new Shell(display);
	
	MockUser user = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
	user.setProfileBackgroundColor("1A1B1F");
	user.setProfileBackgroundImageURL("");
	
	UserPage userPage = new UserPage(shell, user,"", 10, 1, 10, 10, 10, 10, null, null);
	assertNotNull(userPage);	   

	Utils.dispose(userPage);
	Utils.dispose((Widget)null);
  }
  
  @Test(timeout=10000)
  public void testCutRoundCorner() throws Throwable{
	  
	    final Display display = new Display();
	    final Shell shell = new Shell(display);
	  
	    try{
	        MockUser friend;
	        FriendView friendView;
	        
	        //1 condition: user is Vertified + a valid profile image url 
	        friend = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
	        friend.setProfileImageURL(TestUtils.getResourceURL("logo.png"));
	        friendView = new FriendView(shell, friend, 10, null, null);
		    
		    Utils.cutRoundCorner(friendView, true, true, true, true);
		    Utils.cutRoundCorner(friendView, false, false, false, false);
		   
	    }
	    catch(Exception e){
	    	System.out.println(e.getMessage());
	    	assertNull( e.getMessage() );
	    }
	  
  }
 
  @Test(timeout=10000)
  public void testDarkGradually() throws Throwable{
	  final Display display = new Display();
	  Image image;
	  image = new Image(display, 10, 10);
	  assertNotNull(image);
	  Utils.darkGradually(image, 5);
	  image = Utils.loadImageFromUrl(TestUtils.getResourceURL("logo.png"));
	  assertNotNull(image);
	  Utils.darkGradually(image, 24);
  }
  
  @Test(timeout=10000)
  public void testAddClickListener() throws Throwable{
	  final Display display = new Display();
	  Shell shell = new Shell(display);
	  Utils.addClickListener(shell, "testhandler", this);
	  
	  MouseListener mouseListener  = TestUtils.getListener(shell, SWT.MouseDown, "Utils");
	  
	  if (mouseListener == null)
		  fail();
	  Event event = new Event();
	  event.widget = shell;
	  MouseEvent e = new MouseEvent(event);
	  mouseListener.mouseUp(e);
	  mouseListener.mouseDown(e);
	  mouseListener.mouseDoubleClick(e);
  }
  @Ignore
  public void testhandler(MouseEvent arg0){
	  
  }
}
