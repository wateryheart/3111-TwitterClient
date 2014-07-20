package hk.ust.cse.TwitterClient.StyleTweet.core;

/**
 * Created with IntelliJ IDEA.
 * User: MARTIN
 * Date: 4/7/13
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IPair<TKey,TValue>{

    public void setKey(TKey key);
    public void setValue(TValue value);
    public TKey getKey();
    public TValue getValue();

}
