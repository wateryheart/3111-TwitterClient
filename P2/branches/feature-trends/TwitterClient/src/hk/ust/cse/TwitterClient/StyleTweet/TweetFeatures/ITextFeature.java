package hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.StyleTweet.core.IHandler;
import hk.ust.cse.TwitterClient.StyleTweet.core.ITextFeatureData;
import hk.ust.cse.TwitterClient.StyleTweet.core.ITextStyle;

/**
 * @author Chan Ka Yue Martin
 */

public interface ITextFeature<T extends ITextFeatureData> extends IHandler, ITextStyle {
    public T getData();

    public void BuildData(String Text);
}
