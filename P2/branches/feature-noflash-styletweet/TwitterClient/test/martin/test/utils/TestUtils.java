package martin.test.utils;

import org.eclipse.swt.internal.SWTEventListener;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TypedListener;
import org.eclipse.swt.widgets.Widget;
import org.junit.Ignore;

@Ignore
public class TestUtils {

	@Ignore
	public static String getResourceURL(String name){
		String pwd = System.getProperty("user.dir") + "\\";
		String subpwd ="martin\\test\\hk\\ust\\cse\\TwitterClient\\Resources\\";
		return "file:///" +  pwd + subpwd + name;
	}
	
	@Ignore
	@SuppressWarnings({ "unchecked", "null" })
	public static <T> T getListener(Widget target, int listenerType, String name){
		T resultListener = null;
	    Listener[] listeners = target.getListeners(listenerType);
	    System.out.println(listeners.length);
	    for (Listener l : listeners){
	    	SWTEventListener swtel = ((TypedListener)l).getEventListener();
	    	if(swtel.toString().indexOf(name) > -1){
	    		System.out.println( swtel );
	    		resultListener = (T)swtel;		
	    		break;
	    	}	    
	    }
	    
	    return resultListener;
	}
}
