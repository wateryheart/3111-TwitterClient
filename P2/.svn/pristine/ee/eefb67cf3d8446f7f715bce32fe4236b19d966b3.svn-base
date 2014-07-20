package chris.test.hk.ust.cse.TwitterClient.Views.User;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Views.User.FriendView;

import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import martin.test.utils.TestUtils;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;


public class FriendViewTest {
  @Test(timeout=60000)
  public void testConstructor() throws Throwable {
    Display display = new Display();
    Shell shell = new Shell(display);
    
    MockUser friend;
    FriendView friendView;
    
    //1 condition: user is Vertified + a valid profile image url 
    friend = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    friend.setProfileImageURL(TestUtils.getResourceURL("logo.png"));
    friendView = new FriendView(shell, friend, 10, null, null);

    assertNotNull(friendView);
    assertEquals("FakeUser", friendView.getFriend().getName());
    assertEquals("FakeScreenName", friendView.getFriend().getScreenName());
    assertEquals("Fake Description", friendView.getFriend().getDescription());
    assertTrue(friendView.getFriend().isVerified());
    
    //2 condition: user is Vertified + a invalid profile image url 
    friend = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
    friend.setProfileImageURL(null);
    friendView = new FriendView(shell, friend, 10, null, null);
    
    assertNotNull(friendView);
    assertEquals("FakeUser", friendView.getFriend().getName());
    assertEquals("FakeScreenName", friendView.getFriend().getScreenName());
    assertEquals("Fake Description", friendView.getFriend().getDescription());
    assertTrue(friendView.getFriend().isVerified());
    
    //3 condition: user is not Vertified + a valid profile image url 
    friend = new MockUser("FakeUser", "FakeScreenName", false, "Fake Description");
    friend.setProfileImageURL(TestUtils.getResourceURL("logo.png"));
    friendView = new FriendView(shell, friend, 10, null, null);
    
    assertNotNull(friendView);
    assertEquals("FakeUser", friendView.getFriend().getName());
    assertEquals("FakeScreenName", friendView.getFriend().getScreenName());
    assertFalse(friendView.getFriend().isVerified());
    

    //4 condition: user is not Vertified + a invalid profile image url 
    friend = new MockUser("FakeUser", "FakeScreenName", false, "Fake Description");
    friend.setProfileImageURL(null);
    friendView = new FriendView(shell, friend, 10, null, null);
    
    assertNotNull(friendView);
    assertEquals("FakeUser", friendView.getFriend().getName());
    assertEquals("FakeScreenName", friendView.getFriend().getScreenName());
    assertFalse(friendView.getFriend().isVerified());
    shell.dispose();
    display.dispose();
  }

}
