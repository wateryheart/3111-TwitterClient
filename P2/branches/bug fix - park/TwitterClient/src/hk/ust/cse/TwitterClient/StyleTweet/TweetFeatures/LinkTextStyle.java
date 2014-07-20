package hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.Resources.Resources;
import hk.ust.cse.TwitterClient.StyleTweet.core.ITextStyle;
import org.eclipse.swt.custom.StyleRange;

/**
 * @author Chan Ka Yue Martin
 */

public class LinkTextStyle implements ITextStyle {

    @Override
    public StyleRange decorate() {
        StyleRange styleRange = new StyleRange();
        styleRange.font = Resources.FONT11;
        styleRange.foreground = Resources.LINK_COLOR;
        return styleRange;
    }
}
