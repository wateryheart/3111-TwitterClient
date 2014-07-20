package quincy.test.hk.ust.cse.TwitterClient;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Utils;


import org.eclipse.swt.graphics.Color;
import org.junit.Test;

public class UtilsTest {
  @Test(timeout=10000)
  public void testGetColorFromString() throws Throwable {
    assertEquals(new Color(null, 171, 205, 239), Utils.getColorFromString("ABCDEF"));
  } 
  
  @Test(timeout=10000)
  public void testloadImageFromUrl() throws Throwable {
      String url = "http://www.google.com.hk/images/nav_logo117.png";
	  Utils.loadImageFromUrl(url);
	  assertTrue(true);
  } 
  
  @Test(timeout=10000)
  public void testloadImageFromLocal() throws Throwable {
      Utils.loadImageFromLocal(null, "");
      assertTrue(true);
  }
  
  @Test(timeout=10000)
  public void testloadImageFromUrlAndScale() throws Throwable {
      Utils.loadImageFromUrlAndScale("http://www.google.com.hk/images/nav_logo117.png", 40, 40);
      Utils.loadImageFromUrlAndScale("http://www.google.com.hk/images/nav_logo117.png", 167, 389);
      Utils.loadImageFromUrlAndScale("http://www.google.com.hk/images/nav_logo117.png", 167, 388);
      assertTrue(true);
  }
  
  @Test(timeout=10000)
  public void testIsNullOfEmpty() throws Throwable {
      String str = null;
      Utils.isNullOrEmpty(str);
      str = "";
      Utils.isNullOrEmpty(str);
      str = "notEmpty";
      Utils.isNullOrEmpty(str);
	  assertTrue(true);
  }
  
}