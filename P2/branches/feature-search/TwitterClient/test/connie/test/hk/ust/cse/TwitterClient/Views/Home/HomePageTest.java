package connie.test.hk.ust.cse.TwitterClient.Views.Home;

//import static org.junit.Assert.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Views.Home.HomePage;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import connie.test.hk.ust.cse.TwitterClient.Mocks.MockAsyncTwitter;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockStatus;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockTwitter;

import twitter4j.Status;
import twitter4j.TwitterException;

public class HomePageTest {

	@Test(timeout=10000)
	public void testHomePage() throws TwitterException {
		Display display = new Display();
		Shell shell = new Shell(display);
		MockTwitter mockTwitter = new MockTwitter();
		MockAsyncTwitter asyncTwitter = new MockAsyncTwitter();
		TwitterControl.setupTwitter(mockTwitter, asyncTwitter);
		HomePage homePage = new HomePage(shell, 500, 400, -1000, 50, 500, "onNameLinkClicked", "onNumberItemClicked", shell);
		assertNotNull(homePage);
		assertEquals(500, homePage.getBounds().width);
		Event event = new Event();
		event.widget = homePage;
		MouseEvent mEvent = new MouseEvent(event);
		homePage.tweetsListBackClicked(mEvent);
		homePage.tweetsListNextClicked(mEvent);
		homePage.tweetsListBackClicked(mEvent);		
		
		MockStatus status = new MockStatus();
		List<Status> list = new ArrayList<Status>();
		homePage.showTweetsList(list);
		list.add(status);
		homePage.showTweetsList(list);
		
		homePage.dispose();
		shell.dispose();
		display.dispose();
	}

}
