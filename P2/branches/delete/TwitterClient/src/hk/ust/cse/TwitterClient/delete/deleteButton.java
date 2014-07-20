package hk.ust.cse.TwitterClient.delete;

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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;


import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;




public class deleteButton extends RowComposite {
	public deleteButton (Composite parentView, Status tweet, int width ,int height) {
	    super(parentView, SWT.LEFT, SWT.HORIZONTAL, true, 0, 0, 10, 10, 1);
	    m_tweet = tweet;
	    initialize(width,height);
	    
	    // a dispose listener is necessary
	    addDisposeListener(new DisposeListener() {
	      public void widgetDisposed(DisposeEvent e) {
	    	  deleteButton.this.widgetDisposed(e);
	      }
	    });
	}
	
	/*
	 * delete status
	 * delete the status when button is clicked and print failure message when failed
	 * Change color of button for different mouse event. 
	 * If the status cannot be deleted, error message would be shown.
	*/
	private class MListener implements MouseListener{
		public void mouseDown(MouseEvent me) {
			delete.setBackground(Resources.BUTTON_CLICKED_COLOR);
			try {
				Twitter twitter = new TwitterFactory().getInstance();
				
				twitter.destroyStatus(m_tweet.getId());
				
				
			} catch (TwitterException te) {
				te.printStackTrace();
				warning.setText("Failed to get timeline: " + te.getMessage());
				warning.setVisible(true);
			}
		}
	
		public void mouseUp(MouseEvent me) {
			delete.setBackground(Resources.BUTTON_COLOR);
		}
	
		public void mouseDoubleClick(MouseEvent me) {
			delete.setBackground(Resources.BUTTON_CLICKED_COLOR);
		}
	
	};

	
	private void initialize(int width,int height) 
	 {
		// set size
	    setSize(width,height);
	    
	    // set background color
	    setBackground(Resources.MINI_PROFILE_COLOR);
	    setBackgroundMode(SWT.INHERIT_DEFAULT); // make all labels have transparent backgrounds
	    
		
	    RowComposite down = new RowComposite(this, 0, SWT.HORIZONTAL, false, 5, 10, 5, 5, 10);
	    //down.setLayoutData(new RowData(width-20, 50));
		
	    warning = new Label(down, SWT.LEFT|SWT.WRAP);
	    warning.setForeground(Resources.RED_COLOR);
	    warning.setVisible(false);
	    warning.setLayoutData(new RowData(width-130,30));
	    
		
     	delete = new Button(down, SWT.BUTTON1);;
		delete.setBackground(Resources.BUTTON_COLOR);
		delete.addMouseListener(new MListener());
		//delete.setLayoutData(new RowData(50,30));
		delete.setText("Delete");
		
		
	 }
		
	private void widgetDisposed(DisposeEvent e) {
	}
	
	
	
	private Button delete;

	//private Text box;
	private Label warning;
	private final Status m_tweet;
}