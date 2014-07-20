package hk.ust.cse.TwitterClient.Post;


import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;
import hk.ust.cse.TwitterClient.Views.User.UserPage;
import hk.ust.cse.TwitterClient.Views.WholePage;

import org.eclipse.swt.SWT;
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
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class reply extends RowComposite {	
	
	public reply (Composite parentView, User user,Status tweet, int width ,int height) {
	    super(parentView, SWT.LEFT, SWT.HORIZONTAL, true, 0, 0, 10, 10, 1);
	    m_user = user;
	    m_tweet = tweet;
	    initialize(width,height);
	    
	    // a dispose listener is necessary
	    addDisposeListener(new DisposeListener() {
	      public void widgetDisposed(DisposeEvent e) {
	    	  reply.this.widgetDisposed(e);
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
				StatusUpdate statusUpdate =  new StatusUpdate(input.getText()).inReplyToStatusId(m_tweet.getId());
				twitter.updateStatus(statusUpdate);
				
				TwitterControl.updateTwitter();
				int i=1;
				
				if(TwitterControl.getTwitter().getHomeTimeline()!=null)
					WholePage.newTweet = TwitterControl.getTwitter().getHomeTimeline().get(0);	

				
				User test_user=null;
			    Control control = (Control) me.getSource();

			    while (!(control instanceof WholePage)) {
			    	if(control instanceof UserPage)
			    	{		
			    		test_user = ((UserPage)control).getUser();
			    	}
			      control = control.getParent();
			    }
			    if (control != null) {
			    	if(test_user != null)
			    		((WholePage) control).gotoUserPage(test_user);
			    	else{
			    		if(TwitterControl.getTwitter().getHomeTimeline()!=null){
							Thread.sleep(1500);
							while(WholePage.newTweet.equals(WholePage.firstTweet)){
								Thread.sleep(500);	
								System.out.println(i++);
								WholePage.newTweet = TwitterControl.getTwitter().getHomeTimeline().get(0);				
							}
			    		}

			    		((WholePage) control).gotoHomePage();
			    	}
			    }
				
			} catch (TwitterException te) {
				te.printStackTrace();
				warning.setText("Failed to reply: " + te.getMessage());
				warning.setVisible(true);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
	    
	    
	    RowComposite top = new RowComposite(this, 0, SWT.VERTICAL, false, 10, 0, 5, 5, 5);
	    top.setLayoutData(new RowData(width-20, height-50));
	    
		input = new Text(top,  SWT.BORDER|SWT.WRAP |SWT.MULTI|SWT.V_SCROLL);
		input.setEditable(true);
		if ((m_user.getScreenName().equals(TwitterControl.getAccountUser().getScreenName())))
			input.setText("@" + TwitterControl.getAccountUser().getScreenName() + " ");
		else
			input.setText("@" + m_user.getScreenName() + " ");
		input.addModifyListener(new TestListener());
		input.setLayoutData(new RowData(width - 50, height - 110));
		
	    RowComposite down = new RowComposite(top, 0, SWT.HORIZONTAL, false, 5, 0, 5, 5, 5);
	    down.setLayoutData(new RowData(width-20, 35));
		
	    warning = new Label(down, SWT.LEFT|SWT.WRAP);
	    warning.setForeground(Resources.RED_COLOR);
	    warning.setVisible(false);
	    warning.setLayoutData(new RowData(width-130,20));
	    
		words = new Label(down, SWT.CENTER);
		ori = 140 - input.getText().codePointCount(0, input.getText().length());
		count = ori;
		words.setText(String.valueOf(ori));
		words.setSize(100, 50);
		words.setForeground(Resources.GRAY_COLOR);
		words.setLayoutData(new RowData(30,20));
		
		update = new Button(down, SWT.BUTTON1);
		update.setText("Tweet");
		update.setEnabled(false);
		update.setBackground(Resources.BUTTON_COLOR);
		//Utils.cutRoundCorner(update,true, true, true, true);
		update.addMouseListener(new MListener());
		update.setLayoutData(new RowData(50,30));
		
	    
	 }
	
	private void widgetDisposed(DisposeEvent e) {
	}
	private Text input;
	private int count;
	private int ori;
	private Button update;
	private Label words;
	private Label warning;
	private final User m_user;
	
	private final Status m_tweet;
}