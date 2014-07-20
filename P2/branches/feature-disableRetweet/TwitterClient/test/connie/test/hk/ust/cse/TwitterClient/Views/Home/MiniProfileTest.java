package connie.test.hk.ust.cse.TwitterClient.Views.Home;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Views.Home.MiniProfile;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import connie.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockUser2;


public class MiniProfileTest {

	@Test(timeout=10000)
	public void testMiniProfile()  throws Throwable{
		 Display display = new Display();
		 Shell shell = new Shell(display);
		 
		 MockUser mini = new MockUser("Mini Profile Name", "Mini Profile Screen Name", true, "Mini Profile View");
		 MiniProfile miniProfile = new MiniProfile(shell, mini, 100, 200);
		 Event event = new Event();
		 event.x = -9999;
		 event.y = -9999;
		 assertNotNull(miniProfile);
		 assertEquals("Mini Profile Name", miniProfile.getUser().getName());
		 assertEquals("Mini Profile Screen Name", miniProfile.getUser().getScreenName());
		 assertEquals("Mini Profile View", miniProfile.getUser().getDescription());  
		 assertTrue(miniProfile.getUser().isVerified());		    
		 assertEquals(200, miniProfile.getBounds().height);
		 assertEquals(100, miniProfile.getBounds().width);
		 miniProfile.notifyListeners(SWT.MouseEnter, event);	    
		 miniProfile.notifyListeners(SWT.MouseHover, event);
		 miniProfile.notifyListeners(SWT.MouseExit, event);
		 miniProfile.dispose();
		 MockUser2 mini2 = new MockUser2("Mini Profile Name", "Mini Profile Screen Name", false, "Mini Profile View");
		 MiniProfile miniProfile2 = new MiniProfile(shell, mini2, 100, 200);
		 assertNotNull(miniProfile2);
		 miniProfile2.notifyListeners(SWT.MouseEnter, null);	    
		 miniProfile2.notifyListeners(SWT.MouseHover, null);
		 miniProfile2.notifyListeners(SWT.MouseExit, null);
		 miniProfile2.dispose();
		 shell.dispose();
		 display.dispose();
	}
}
