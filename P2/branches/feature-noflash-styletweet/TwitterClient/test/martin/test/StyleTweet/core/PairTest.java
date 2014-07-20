package martin.test.StyleTweet.core;

import hk.ust.cse.TwitterClient.StyleTweet.core.IStyleTweetMouseListener;
import hk.ust.cse.TwitterClient.StyleTweet.core.Pair;
import martin.test.StyleTweet.Mock.MockStyleTweetMouseListener;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: MARTIN
 * Date: 4/7/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class PairTest {
    @Test(timeout = 10000)
    public void simpleTest(){

        Pair<String,String> p1 = new Pair<String,String>("edf","abc");
        assertNotNull(p1);
        Pair<String,String> p2 = new Pair<String,String>("abc","edf");
        assertNotNull(p2);

        boolean isp1p2 =  p1.equals(p2);
        assertFalse(isp1p2);

        Pair<String,String> p3 = new Pair<String,String>("abc","edf");
        assertNotNull(p3);
        Pair<String,String> p4 = new Pair<String,String>("abc","edf");
        assertNotNull(p4);

        boolean isp3p4 =  p3.equals(p4);
        assertTrue(isp3p4);

        IStyleTweetMouseListener listener = new MockStyleTweetMouseListener();
        Pair<Integer,IStyleTweetMouseListener> p5 = new Pair<Integer,IStyleTweetMouseListener>(0,listener);
        assertNotNull(p5);
        Pair<Integer,IStyleTweetMouseListener> p6 = new Pair<Integer,IStyleTweetMouseListener>(0,listener);
        assertNotNull(p6);

        boolean isp5p6 =  p5.equals(p6);
        assertTrue(isp5p6);

    }
}
