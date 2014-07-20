package quincy.hk.ust.cse.TwitterClient.Controls;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Controls.HomePageControl;

import org.junit.Test;

public class HomePageControlTest {

	@Test
	public void testHomePageControl() {
		HomePageControl homePageControl =new HomePageControl(null);
		assertNotNull(homePageControl);
		homePageControl.showTweetsListCallback(null);
	}

}
