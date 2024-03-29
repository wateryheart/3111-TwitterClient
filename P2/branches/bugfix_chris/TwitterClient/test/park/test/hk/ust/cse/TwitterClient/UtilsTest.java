package park.test.hk.ust.cse.TwitterClient;

import static org.junit.Assert.*;

import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Resources.Resources;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.junit.Test;

public class UtilsTest {
  @Test(timeout=10000)
  public void testGetColorFromString() throws Throwable {
    assertEquals(new Color(null, 171, 205, 239), Utils.getColorFromString("ABCDEF"));
  }
  
  @Test
  public void testIsNullOrEmpty() throws Throwable {
	assertEquals(false, Utils.isNullOrEmpty("abc"));
	assertEquals(true, Utils.isNullOrEmpty(null));
	assertEquals(true, Utils.isNullOrEmpty(""));
	  }
  
  @Test
  public void testSelectimageVersion() throws Throwable {
	String expected1 = "test_normal.png";
	String expected2 = "test_bigger.png";
	String expected3 = "test.png";
	String expected4 = "test_small.png";
	  
	assertEquals(expected1, Utils.selectImageVersion("test_normal.png", 45,45));
	assertEquals(expected2, Utils.selectImageVersion("test_bigger.png", 70,70));
	assertEquals(expected3, Utils.selectImageVersion("test_normal.png", 45,80));
	assertEquals(expected3, Utils.selectImageVersion("test_normal.png", 80,45));
	assertEquals(expected4, Utils.selectImageVersion("test_small.png", 50,80));

	  }
  
  @Test
  public void testDarkGradually() throws Throwable {
	 

	Image actual1 = Utils.loadImageFromLocal(Resources.class, "./test.png");;

	Resources test = new Resources();
	Utils test1 = new Utils();
	  }
  
  
    
}
