package hk.ust.cse.TwitterClient.StyleTweet.core;

import hk.ust.cse.TwitterClient.Resources.Resources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;

/**
 * @author Chan Ka Yue Martin
 */

public class StyleTweetView implements IView {

    private StyledText styledText;
    private Composite Parent;
    private Composite RowLayout;

    public StyleTweetView(Composite parent, Composite rowLayout) {
        Parent = parent;
        RowLayout = rowLayout;
        Render();
    }

    @Override
    public void Render() {
        if (styledText != null) styledText.dispose();
        styledText = new StyledText(Parent, SWT.WRAP | SWT.LEFT);
        styledText.setFont(Resources.FONT11);
        styledText.setForeground(Resources.TEXT_COLOR);
        styledText.setLayoutData(new RowData(RowLayout.getBounds().width - 87, -1));
        styledText.setCursor(Resources.HAND_CURSOR);
        styledText.setEditable(false);
    }

    @Override
    public void AddListener(int type, Listener listener) {
        styledText.addListener(type, listener);
    }

    @Override
    public void SetText(String text) {
        if(text != null)
            styledText.setText(text);
    }

    @Override
    public void SetStyle(int[] ranges, StyleRange[] styleRanges) {
        styledText.setStyleRanges(ranges, styleRanges);
    }
}


