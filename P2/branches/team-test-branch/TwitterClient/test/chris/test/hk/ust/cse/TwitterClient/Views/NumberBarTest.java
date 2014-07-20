package chris.test.hk.ust.cse.TwitterClient.Views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import hk.ust.cse.TwitterClient.Views.ControlBar;
import hk.ust.cse.TwitterClient.Views.ListView;
import hk.ust.cse.TwitterClient.Views.NumberBar;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import java.lang.reflect.Method;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class NumberBarTest {

	 @Test(timeout=10000)
	  public void testConstructor() throws Throwable {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    
	    long[] numbers = new long[]{1,2,3};
	    String[] titles = new String[]{ "title1", "title2", "title3" };
	    NumberBar numberBar;
	    numberBar = new NumberBar ((Composite) shell, numbers, titles, 10, 10, 10,
	    		null, null, null,
	    		null, null,
	    		false,
	    		"numClkHandler",
	    		null);
	    assertNotNull(numberBar);
	    assertEquals(10, numberBar.getBounds().width);
	    assertEquals(10, numberBar.getBounds().height);
	    
	    numberBar = new NumberBar ((Composite) shell, numbers, titles, 10, 10, 10,
	    		null, null, null,
	    		null, null,
	    		true,
	    		null,
	    		null);
	    assertNotNull(numberBar);
	    
	    
	    shell.dispose();
	    display.dispose();
	  }
	 
//	public void Reflection(){
//	    try{
//	    	Class<?> cls = ListView.class;
//	        
//	        Method initialize = cls.getDeclaredMethod("initialize", String.class,int.class);
//	        initialize.setAccessible(true);
//	        assertNotNull(initialize);
//	        
//	        initialize.invoke(listView, "mytitle", 10 );
//	    }catch(Exception e){
//	    	assertNotNull(e.getMessage());
//	    }
//	    
//	}

}
