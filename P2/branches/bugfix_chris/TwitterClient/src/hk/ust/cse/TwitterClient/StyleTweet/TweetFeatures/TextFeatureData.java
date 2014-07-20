package hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.StyleTweet.core.Entity;
import hk.ust.cse.TwitterClient.StyleTweet.core.ITextFeatureData;

/**
 * @author Chan Ka Yue Martin
 */

public class TextFeatureData implements ITextFeatureData {
    public TextFeatureData(String text, Entity[] entities) {
        Text = text;
        Entities = entities;
    }

    private String Text;
    private Entity[] Entities;

    public String getText() {
        return Text;
    }

    public Entity[] getEntities() {
        return Entities;
    }
}
