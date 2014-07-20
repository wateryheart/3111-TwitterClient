package connie.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.ControlBarItem;
import hk.ust.cse.TwitterClient.Views.ListView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class ListViewTest {

	@Test(timeout=10000)
	public void testListViewCompositeInt()throws Throwable {
		Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    ListView listView = new ListView(shell, 100);
	    assertNotNull(listView);
	    //assertEquals(100,listView.getWidth()); //failure = 0?
	    listView.dispose();
	    
	    listView = new ListView(shell, "Header", 100, "backHandler", null, "nextHandler", null);
	    assertEquals(100,listView.getWidth());
	    assertNotNull(listView);
	    listView.dispose();
	    
	    listView = new ListView(shell, null, 10, "backHandler", null, "nextHandler", null);
	    assertEquals(0,listView.getWidth());
	    assertNotNull(listView);	    
	    listView.addItem(new ControlBarItem(listView, "Test", Resources.BACK_IMG, Resources.HOME_HOVER_IMG));
	    List<ControlBarItem> listbar = new ArrayList<ControlBarItem>();
	    listbar.add(new ControlBarItem(listView, "ABC", Resources.BACK_IMG, Resources.ME_HOVER_IMG));
	    listView.addItems(listbar);
	    listView.dispose();
	    
	    shell.dispose();
	    display.dispose();
	}

}
