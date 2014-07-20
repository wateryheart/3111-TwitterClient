package connie.test.hk.ust.cse.TwitterClient.Post;
 

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;

import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Post.PostBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.junit.Test;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockAsyncTwitter;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockTwitter;
import connie.test.hk.ust.cse.TwitterClient.Mocks.MockUser;


public class PostBoxTest {

	Display display = new Display();
    Shell shell = new Shell(display);

	@Test
	public void testConstructor() throws Throwable, TwitterException {
		
	    MockUser user = new MockUser("Name", "Screen Name", true, "View");
	    
	    Twitter twitter = new MockTwitter(user);    	
		MockAsyncTwitter AsyncTwitter = new MockAsyncTwitter();
		TwitterControl.setupTwitter(twitter, AsyncTwitter);
		
	    PostBox post = new PostBox(shell, user, 300,150);
	    assertNotNull(post);
	    
	    Class<?> cls = PostBox.class;
	    
	    Field fInput = cls.getDeclaredField("input");
	    fInput.setAccessible(true);
	    Object objInput = fInput.get(post);
	    assertNotNull(objInput);
	    Text input = (Text)objInput;
	    
	    Field fWords = cls.getDeclaredField("words");
	    fWords.setAccessible(true);
	    Object objWords = fWords.get(post);
	    assertNotNull(objWords);
	    Label words = (Label)objWords;

	    Field fButton = cls.getDeclaredField("update");
	    fButton.setAccessible(true);
	    Object objButton = fButton.get(post);
	    assertNotNull(objButton);
	    Button update = (Button)objButton;
	    
	    input.insert("");
	    assertEquals("140",words.getText());
	    
	    input.insert("hi");
	    assertEquals("138",words.getText());
	    
	    input.selectAll();
	    input.insert("");
	    assertEquals("140",words.getText());
	    
	    input.insert("input something, such as english, abcd efghij, ¤¤¤å, ²Å¸¹,¤é¥»»yÆìÆ÷ÇOÆùÇG,");
	    input.insert("ÇÀÇÁ,ˆqˆ¡£°££,£_£XˆaÈWÈ`ÈNÈQÈS");
	    assertEquals("61",words.getText());
	    
	    input.insert("Keep adding words to see what may happend");
	    assertEquals("20",words.getText());
	    
	    input.insert("10 more words");
	    assertEquals("7",words.getText());
	    
	    input.insert("or over limit");
	    assertEquals("-6",words.getText());
	    
	    Date time = Calendar.getInstance().getTime();
	    input.selectAll();
	    input.insert(time + " testing");
	    
	    Event event = new Event();
	    update.notifyListeners(SWT.MouseDown, event);	    
	    update.notifyListeners(SWT.MouseUp, event);
	    input.selectAll();
	    input.insert(time + " testing");
	    update.notifyListeners(SWT.MouseDown, event);	 
	    update.notifyListeners(SWT.MouseDoubleClick, event);
	    
	    MockUser user2 = new MockUser("Name2", "Screen Name2", true, "View2");
	    twitter = new MockTwitter(user2);    	
		AsyncTwitter = new MockAsyncTwitter();
		TwitterControl.setupTwitter(twitter, AsyncTwitter);
	    post = new PostBox(shell, user, 300,150);
	    post.dispose();
	    assertNotNull(post);
	    shell.dispose();
		display.dispose();
	    
		 
	}

}
