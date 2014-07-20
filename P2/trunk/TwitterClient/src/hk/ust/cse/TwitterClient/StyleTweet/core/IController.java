package hk.ust.cse.TwitterClient.StyleTweet.core;

import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.ITextFeature;
import org.eclipse.swt.widgets.Listener;

/**
 * @author Chan Ka Yue Martin
 */

public interface IController {

    public void AddListener(int type, Listener listener);

    public void RemoveListener(int type, Listener listener);

    public void AddFeature(ITextFeature tweetFeature);

    public void RemoveFeature(ITextFeature tweetFeature);

    public void setText(String text);

    public void ApplyChange();
}

