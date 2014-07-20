package hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.StyleTweet.core.ITextStyle;
import org.eclipse.swt.custom.StyleRange;

import java.util.logging.Logger;

/**
 * @author Chan Ka Yue Martin
 */

public abstract class BaseTweetFeature implements ITextFeature {

    protected static final Logger logger = Logger.getLogger("styleTweet");

    protected TextFeatureData Data;
    protected ITextStyle _style;

    public BaseTweetFeature(ITextStyle style) {
        _style = style;
    }

    @Override
    public TextFeatureData getData() {
        return Data;
    }

    @Override
    public StyleRange decorate() {
        return _style.decorate();
    }

}
