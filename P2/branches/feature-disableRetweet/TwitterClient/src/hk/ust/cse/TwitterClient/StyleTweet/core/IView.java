package hk.ust.cse.TwitterClient.StyleTweet.core;

import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.widgets.Listener;

/**
 * @author Chan Ka Yue Martin
 */

public interface IView {

    void AddListener(int type, Listener listener);

    void SetText(String text);

    void SetStyle(int[] ranges, StyleRange[] styleRanges);

    void Render();
}

