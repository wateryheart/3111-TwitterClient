package hk.ust.cse.TwitterClient.Post;

import java.lang.reflect.Method;

import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.WholePage;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;
import hk.ust.cse.TwitterClient.Views.Home.HomePage;
import hk.ust.cse.TwitterClient.Views.User.UserPage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class PostBox extends RowComposite {	
	
	public PostBox (Composite parentView, User user, int width ,int height, Object handlerCallee) {
	    super(parentView, SWT.LEFT, SWT.HORIZONTAL, true, 0, 0, 10, 10, 1);
	    m_user = user;
	    m_handlerCallee = handlerCallee;
	    
	    initialize(width,height);
	    
	    // a dispose listener is necessary
	    addDisposeListener(new DisposeListener() {
	      public void widgetDisposed(DisposeEvent e) {
	    	  PostBox.this.widgetDisposed(e);
	      }
	    });
	}

	/** Count words
	 * Words counts would count the number of words entered. 
	 * If it have 0 words, tweet would not be allowed to post, count would be grey in color.
	 * If it have more than 120 words, count would be yellow in color.
	 * If it have more than 130 words, count would be orange in color.
	 * If it exceeds 140 words, tweet would not be allowed to post, count would be red in color, warning would be shown.
	 * @param null
	 * @return null
	 */
	private class TestListener implements ModifyListener{
		public void modifyText(ModifyEvent me)  {
			count = 140 - input.getText().codePointCount(0, input.getText().length());
			words.setText(String.valueOf(count));
			input.setFocus();
			if (count == ori)
			{
				update.setEnabled(false);
				warning.setVisible(false);
				words.setForeground(Resources.GRAY_COLOR);
			}
			else if (count <= 20 && count > 10)
			{
				update.setEnabled(true);
				warning.setVisible(false);
				words.setForeground(Resources.BROWN_COLOR);
			}
			else if (count <= 10 && count >= 0)
			{
				update.setEnabled(true);
				warning.setVisible(false);
				words.setForeground(Resources.ORANGE_COLOR);
			}
			else if(count < 0)
			{
				update.setEnabled(false);
				input.setSelection(140,input.getText().length());
				words.setForeground(Resources.RED_COLOR);
				//input.setStyle(Resources.style1, 140,input.getText().length());
				warning.setText("Your tweet can AT MOST have 140 characters!");	 
				warning.setVisible(true);				
			}
			else
			{
				update.setEnabled(true);
				input.setBackground(null);
				warning.setVisible(false);
				words.setForeground(Resources.GRAY_COLOR);
			} 
		}
	};
	
	/**add status
	 * Update the status when button is clicked and print failure message when failed
	 * Change color of button for different mouse event. 
	 * If the status cannot be updated, error message would be shown.
	 * ***color doesn't work for windows!
	 * @param null
	 * @return null
	 */
	private class MListener implements MouseListener{
		public void mouseDown(MouseEvent me) {
			update.setBackground(Resources.BUTTON_CLICKED_COLOR);
			try {
				Twitter twitter = new TwitterFactory().getInstance();
				status = twitter.updateStatus(input.getText());
				TwitterControl.updateTwitter();
				if (TwitterControl.getTwitter().getHomeTimeline()!=null)
					WholePage.newTweet = TwitterControl.getTwitter().getHomeTimeline().get(0);	

				
				Control control = (Control) me.getSource();
		        
                while (!(control instanceof HomePage) &&
                        !(control instanceof UserPage)) {
                	if(control==null)
                		return;
                    control = control.getParent();
                }
		        if (control !=null) {
		        	if(control instanceof HomePage){ 
		        		if (TwitterControl.getTwitter().getHomeTimeline()!=null){
							Thread.sleep(2000);
							int i=1;
							while(WholePage.newTweet.equals(WholePage.firstTweet)){
								Thread.sleep(300);
								System.out.println(i++);
								WholePage.newTweet = TwitterControl.getTwitter().getHomeTimeline().get(0);				
							}
		        		}

		        		try {
		                	Method method = m_handlerCallee.getClass().getMethod("gotoHomePage");
		                    method.invoke(m_handlerCallee);
		                  } catch (Exception e) {e.printStackTrace();}	        		
		        		return;
		        	}
		        	else if(control instanceof UserPage){
		                try {
		                    Method method = m_handlerCallee.getClass().getMethod("gotoUserPage", User.class);
		                    method.invoke(m_handlerCallee, ((UserPage)control).getUser());
		                  } catch (Exception e) {e.printStackTrace();}	
		        		return;
		            }

		        }
				
			} catch (TwitterException te) {
				te.printStackTrace();
				if (te.getErrorCode() == 187)
					warning.setText("Status is a duplicate!");
				else	
					warning.setText("Failed to get timeline: " + te.getErrorMessage());
				warning.setVisible(true);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		public void mouseUp(MouseEvent me) {
			update.setBackground(Resources.BUTTON_COLOR);
		}
	
		public void mouseDoubleClick(MouseEvent me) {
			update.setBackground(Resources.BUTTON_CLICKED_COLOR);
		}
	
	};

	/**Create the post box
	 * @param width and height of the area
	 * @return null
	*/
	private void initialize(int width,int height) 
	 {
		// set size
	    setSize(width,height);
	    
	    // set background color
	    setBackground(Resources.MINI_PROFILE_COLOR);
	    setBackgroundMode(SWT.INHERIT_DEFAULT); // make all labels have transparent backgrounds
	    /*
	    // set layout of the view
	    postFrame = new HoverClickableComposite(this, Resources.WHITE_COLOR, Resources.WHITE_COLOR, Resources.WHITE_COLOR);
	    RowLayout layout = new RowLayout(SWT.DEFAULT);
	    layout.center       = true;
	    setLayout(layout);
	    postFrame.setLayout(layout);
	    postFrame.setLayoutData(new RowData(width, -1));
	    
	    //set input message
	    box = new Text(this, SWT.BORDER |SWT.FILL);
	    box.setSize(width,height);
	    box.setBackground(Resources.WHITE_COLOR);
	    box.setFont(Resources.FONT11);
	    box.setForeground(Resources.GRAY_COLOR);
	    box.setText("Compose new Tweet...                              ");
	    box.setEditable(false);
	    box.setEnabled(true);
	    Utils.addClickListener(postFrame, "toggleExpand", this);
	    */
	    RowComposite top = new RowComposite(this, 0, SWT.HORIZONTAL, false, 10, 10, 5, 5, 10);
	    top.setLayoutData(new RowData(width-20, 100));
	    
		input = new Text(top,  SWT.BORDER|SWT.WRAP |SWT.MULTI|SWT.V_SCROLL);
		input.setEditable(true);
         if(m_user == null || m_user.getScreenName() == null || TwitterControl.getAccountUser() == null )
             throw new RuntimeException("User/UserScreenName can not be null");
		if (!(m_user.getScreenName().equals(TwitterControl.getAccountUser().getScreenName())))
			input.setText("@" + m_user.getScreenName() + " ");
		input.addModifyListener(new TestListener());
		input.setLayoutData(new RowData(width - 50, height - 60));
		
	    RowComposite down = new RowComposite(this, 0, SWT.HORIZONTAL, false, 5, 10, 5, 5, 10);
	    down.setLayoutData(new RowData(width-20, 50));
		
	    warning = new Label(down, SWT.LEFT|SWT.WRAP);
	    warning.setForeground(Resources.RED_COLOR);
	    warning.setVisible(false);
	    warning.setLayoutData(new RowData(width-130,30));
	    
		words = new Label(down, SWT.CENTER);
		ori = 140 - input.getText().codePointCount(0, input.getText().length());
		count = ori;
		words.setText(String.valueOf(ori));
		words.setSize(100, 50);
		words.setForeground(Resources.GRAY_COLOR);
		words.setLayoutData(new RowData(30,30));
		
		update = new Button(down, SWT.BUTTON1);
		update.setText("Tweet");
		update.setEnabled(false);
		update.setBackground(Resources.BUTTON_COLOR);
		//Utils.cutRoundCorner(update,true, true, true, true);
		update.addMouseListener(new MListener());
		update.setLayoutData(new RowData(50,30));
		
	    layout(); // trigger re-layout
	    pack(); // force re-size
	 }
	
	private void widgetDisposed(DisposeEvent e) {
	}
	
	private Text input;
	private int count;
	private int ori;
	private Button update;
	private Label words;
	private Status status;
	//private Text box;
	private Label warning;
	private final User m_user;
	private final Object          m_handlerCallee;
}