package tony.test.hk.ust.cse.TwitterClient.Controls;

import hk.ust.cse.TwitterClient.Controls.HomePageControl;

import org.junit.Test;

public class HomePageControlTest {
	@Test(timeout=10000)
	public void testConstructor() throws Throwable {
		new HomePageControl(null).showTweetsListCallback(true);
	}
 
}
