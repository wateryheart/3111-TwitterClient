package quincy.test.hk.ust.cse.TwitterClient.Views.Home;


import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Views.Home.MiniProfile;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import quincy.test.hk.ust.cse.TwitterClient.Mocks.MockUser;


public class MiniProfileTest {
	@Test(timeout=10000)
	  public void testConstructor() throws Throwable {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    MockUser friend = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
	    MiniProfile miniProfile = new MiniProfile(shell, friend, 10, 10);
	    assertNotNull(miniProfile);
	    assertEquals("FakeUser", miniProfile.getUser().getName());
	    assertEquals("FakeScreenName", miniProfile.getUser().getScreenName());
	    assertEquals("Fake Description", miniProfile.getUser().getDescription());
	    assertTrue(miniProfile.getUser().isVerified());
	    assertEquals(10, miniProfile.getBounds().width);
	    assertEquals(10, miniProfile.getBounds().height);
	    shell.dispose();
	    display.dispose();
	  }

	}





