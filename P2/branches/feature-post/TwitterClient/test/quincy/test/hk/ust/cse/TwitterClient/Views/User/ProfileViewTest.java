package quincy.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Views.User.ProfileView;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import quincy.test.hk.ust.cse.TwitterClient.Mocks.MockUser;


public class ProfileViewTest {

	@Test(timeout=10000)
	  public void testConstructor() throws Throwable {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    MockUser friend = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
	    ProfileView profileView = new ProfileView(shell, friend, 10, 10);
	    
	    assertNotNull(profileView);
	    assertEquals("FakeUser", profileView.getUser().getName());
	    assertEquals("FakeScreenName", profileView.getUser().getScreenName());
	    assertEquals("Fake Description", profileView.getUser().getDescription());
	    assertTrue(profileView.getUser().isVerified());
	    
	    shell.dispose();
	    display.dispose();
	  }

	}
