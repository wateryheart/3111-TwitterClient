package tony.test.hk.ust.cse.TwitterClient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import hk.ust.cse.TwitterClient.Utils;

import java.awt.Image;
import java.awt.image.BufferedImage;

import org.eclipse.swt.graphics.Color;
import org.junit.Test;

public class UtilsTest {
  @Test(timeout=10000)
  public void testGetColorFromString() throws Throwable {
    assertEquals(new Color(null, 171, 205, 239), Utils.getColorFromString("ABCDEF"));
  }
  
  @Test(timeout=10000)
  public void testLoadImageFromUrl() throws Throwable {
	assertNotSame((Image) new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_BINARY), Utils.loadImageFromUrl("http://www.collegecafelife.com/wallpapers/9t63vxvxfqmz.png"));
  }
  
  @Test(timeout=10000)
  public void testLoadImageFromUrlAndScale() throws Throwable {
	assertNotSame((Image) new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_BINARY), Utils.loadImageFromUrlAndScale("http://www.collegecafelife.com/wallpapers/9t63vxvxfqmz.png", 100, 100));
  }
  
  @Test(timeout=10000)
  public void testSelectImageVersionNormal() throws Throwable {
	  assertNotSame("link", Utils.selectImageVersion("http://www.collegecafelife.com/wallpapers/9t63vxvxfqmz_normal.png", 20, 20));
  }
  
  @Test(timeout=10000)
  public void testSelectImageVersionBigger() throws Throwable {
	  assertNotSame("link", Utils.selectImageVersion("http://www.collegecafelife.com/wallpapers/9t63vxvxfqmz_bigger.png", 40, 40));
  }
  
  @Test(timeout=10000)
  public void testSelectImageVersionOthers() throws Throwable {
	  assertNotSame("link", Utils.selectImageVersion("http://www.collegecafelife.com/wallpapers/9t63vxvxfqmz_normal.png", 100, 100));
  }
}
