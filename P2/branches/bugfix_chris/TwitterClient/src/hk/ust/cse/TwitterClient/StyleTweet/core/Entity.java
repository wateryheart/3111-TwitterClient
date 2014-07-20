package hk.ust.cse.TwitterClient.StyleTweet.core;

/**
 * @author Chan Ka Yue Martin
 */

public class Entity {

    public String Text;
    public int Start;
    public int Length;

    public Entity(String text, int start, int length) {
        Text = text;
        Start = start;
        Length = length;
    }
}
