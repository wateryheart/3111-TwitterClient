package connie.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Views.User.ProfileView;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import connie.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockUser2;


public class ProfileViewTest {

	@Test(timeout=10000)
	public void testProfileView()throws Throwable {
		Display display = new Display();
	    Shell shell = new Shell(display);
	    MockUser userProfile = new MockUser("profileName", "profileScreenName", true, "Profile View");
	    ProfileView profileView = new ProfileView(shell, userProfile, 100, 200);
	    assertNotNull(profileView);
	    assertEquals("profileName", profileView.getUser().getName());
	    assertEquals("profileScreenName", profileView.getUser().getScreenName());
	    assertEquals("Profile View", profileView.getUser().getDescription());
	    assertEquals(200, profileView.getHeight());
	    assertEquals(100, profileView.getWidth());
	    assertTrue(profileView.getUser().isVerified());
	    //Image oriImage = Utils.loadImageFromUrlAndScale(userProfile.getProfileBannerURL(), 32, 32);
	    //System.out.print(oriImage);
	    profileView.dispose();
	    
	    MockUser2 userProfile2 = new MockUser2("profileName", "profileScreenName", false, "");		  
	    profileView = new ProfileView(shell, userProfile2, 100, 100);
	    assertNotNull(profileView);
	    profileView.dispose();
	    shell.dispose();
	    display.dispose();
	}


}
