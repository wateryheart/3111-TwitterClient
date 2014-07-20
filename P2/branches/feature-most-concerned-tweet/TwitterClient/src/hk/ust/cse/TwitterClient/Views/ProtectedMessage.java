package hk.ust.cse.TwitterClient.Views;

import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Controls.TweetViewControl;
import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.Views.Basic.HoverClickableComposite;
import hk.ust.cse.TwitterClient.Views.Basic.LinkLabel;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;
import hk.ust.cse.TwitterClient.Views.Home.RepliesList;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import twitter4j.Status;
import twitter4j.URLEntity;
import twitter4j.User;

public class ProtectedMessage extends RowComposite {
  
  public ProtectedMessage(Composite parentView, int width, boolean bigIcon, 
      Color origColor, User user) {
    super(parentView, SWT.CENTER, SWT.VERTICAL, false, 0, 0, 0, 0, 0);

    m_user = user;
    initialize(width, bigIcon, origColor);
    
  }
  
  private void initialize(int width, boolean bigIcon, Color origColor) {
    // set size
    setSize(width, -1);
    
    // set background color
    setBackground(Resources.WHITE_COLOR);
    setBackgroundMode(SWT.INHERIT_DEFAULT); // make all labels have transparent backgrounds
    
    m_upperFrame = new RowComposite(this, 0, SWT.VERTICAL, false, 0, 0, 5, 5, 3);
    
    RowLayout upperFrameLayout = new RowLayout(SWT.HORIZONTAL);
    upperFrameLayout.center       = false;
    upperFrameLayout.marginTop    = 12;
    upperFrameLayout.marginBottom = 12;
    upperFrameLayout.marginLeft   = 12;
    upperFrameLayout.marginRight  = 12;
    upperFrameLayout.spacing      = 5;
    m_upperFrame.setLayout(upperFrameLayout);
    m_upperFrame.setLayoutData(new RowData(width, -1));
  
    // set the right frame
    m_rightFrame = new RowComposite(m_upperFrame, 0, SWT.VERTICAL, false, 0, 0, 5, 5, 3);
    m_rightFrame.setLayoutData(new RowData(getBounds().width - 77, -1));

    // set the right upper frame
    RowComposite rightUpFrame = new RowComposite(m_rightFrame, 0, SWT.HORIZONTAL, false, 0, 0, 0, 0, 0);
    rightUpFrame.setLayoutData(new RowData(getBounds().width - 87, -1));
    
    // set text
    m_text = new Label(m_rightFrame, SWT.WRAP | SWT.LEFT);
    m_text.setFont(Resources.FONT11);
    m_text.setForeground(Resources.TEXT_COLOR);
    m_text.setText("@"+m_user.getScreenName()+"'s tweets are protected." 
    +"\n\nOnly confirmed followers have access to @"+m_user.getScreenName()+"'s Tweets and complete profile. Click the \"Follow\" button to send a follow request.");
    m_text.setLayoutData(new RowData(getBounds().width - 87, -1));

    layout(); // trigger re-layout
    pack(); // force re-size of height, the width should not be changed

  }
  

  private User        m_user;
  private Label        m_text;
  private RowComposite m_upperFrame;
  private RowComposite m_rightFrame;



}