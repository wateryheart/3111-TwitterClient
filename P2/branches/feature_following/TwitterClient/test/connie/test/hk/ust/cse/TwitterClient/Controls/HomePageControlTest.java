package connie.test.hk.ust.cse.TwitterClient.Controls;

//import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Controls.HomePageControl;

import org.junit.Test;

public class HomePageControlTest {

	@Test(timeout=100000)
	public void testHomePageControl() throws Throwable{
		HomePageControl testHomePageControl  = new HomePageControl(null);
		testHomePageControl.showTweetsListCallback(null);
		Thread.currentThread().run();
	}

}
