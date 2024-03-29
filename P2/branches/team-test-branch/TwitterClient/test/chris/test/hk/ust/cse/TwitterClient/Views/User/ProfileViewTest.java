package chris.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import hk.ust.cse.TwitterClient.Views.User.ProfileView;

import martin.test.hk.ust.cse.TwitterClient.Mocks.MockURLEntity;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import martin.test.utils.TestUtils;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import twitter4j.User;

public class ProfileViewTest {

	@Test(timeout=100000)
	public void testConstructor() throws Throwable{

	 	Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    MockUser user;
	    ProfileView profileView;
	    
	    //String url = "http://a0.twimg.com/profile_background_images/656927849/miyt9dpjz77sc0w3d4vj.png";
	    //String profileBannerURL = "http://si0.twimg.com/a/1356725833/t1/img/grey_header_web.png";
	    //String profileBiggerProfileImageURL = "http://a0.twimg.com/profile_images/2284174872/7df3h38zabcvjylnyfe3_bigger.png";
	    
	    String DisplayURL = "dev.twitter.com/blog/introduci";
		 //new MockURLEntity( m_URL );
		 MockURLEntity mockURLEntity = new MockURLEntity();
		 mockURLEntity.setDisplayURL(DisplayURL);
		 
		 assertNotNull(mockURLEntity);

		 
	    // --
	    user = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
	    user.setURLEntity(mockURLEntity);

	    user.setBiggerProfileImageURL( TestUtils.getResourceURL("logo_bigger.png") );
	    
	    profileView = new ProfileView(shell, user, 520, 260);
	    assertNotNull(profileView);
	   	assertTrue(profileView.getUser().isVerified());
	   	
	   	user.setBiggerProfileImageURL( null );
	    
	    profileView = new ProfileView(shell, user, 520, 260);
	    assertNotNull(profileView);
	   	assertTrue(profileView.getUser().isVerified());
	   	
	    user.setProfileBannerURL(TestUtils.getResourceURL("banner.png"));
	    
	    profileView = new ProfileView(shell, user, 520, 260);
	    assertNotNull(profileView);
	   	assertTrue(profileView.getUser().isVerified());

	    user.setProfileBannerURL(null);
	    
	    profileView = new ProfileView(shell, user, 520, 260);
	    assertNotNull(profileView);
	   	assertTrue(profileView.getUser().isVerified());
	   		   	
	   	user.setLocation("San Francisco, CA");
	    
	   	profileView = new ProfileView(shell, user, 520, 260);
	    assertNotNull(profileView);
	   	assertTrue(profileView.getUser().isVerified());

	   	user.setLocation("");
	    
	   	profileView = new ProfileView(shell, user, 520, 260);
	    assertNotNull(profileView);
	   	assertTrue(profileView.getUser().isVerified());
 	
	   	user.setURL("http://dev.twitter.com/");

	    profileView = new ProfileView(shell, user, 520, 260);
	    assertNotNull(profileView);
	   	assertTrue(profileView.getUser().isVerified());
	   	
	   	user.setURL("");

	    profileView = new ProfileView(shell, user, 520, 260);
	    assertNotNull(profileView);
	   	assertTrue(profileView.getUser().isVerified());
	   	
	   	// --
	    user = new MockUser("FakeUser", "FakeScreenName", false, "Fake Description");
	    user.setURLEntity(mockURLEntity);

	    user.setProfileBannerURL(TestUtils.getResourceURL("banner.png"));
	    
	    profileView = new ProfileView(shell, user, 520, 260);
	    assertNotNull(profileView);
	   	assertFalse(profileView.getUser().isVerified());
	   	
	   	user.setProfileBannerURL(null);
	    
	    profileView = new ProfileView(shell, user, 520, 260);
	    assertNotNull(profileView);
	    assertFalse(profileView.getUser().isVerified());
	   	

	    user.setLocation("San Francisco, CA");
	    
	   	profileView = new ProfileView(shell, user, 520, 260);
	    assertNotNull(profileView);
	   	assertFalse(profileView.getUser().isVerified());

	   	user.setLocation("");
	    
	   	profileView = new ProfileView(shell, user, 520, 260);
	    assertNotNull(profileView);
	   	assertFalse(profileView.getUser().isVerified());
 	
	   	user.setURL("http://dev.twitter.com/");

	    profileView = new ProfileView(shell, user, 520, 260);
	    assertNotNull(profileView);
	   	assertFalse(profileView.getUser().isVerified());
   	
	   	user.setURL("");

	    profileView = new ProfileView(shell, user, 520, 260);
	    assertNotNull(profileView);
	   	assertFalse(profileView.getUser().isVerified());
	   	
	    //
	    User u = profileView.getUser();
	    
	    
	    // --------------------------------------------------------------------------------
	    
	    shell.dispose();
	    display.dispose();
	}
}
