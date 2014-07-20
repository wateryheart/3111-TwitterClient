package martin.test.StyleTweet.Mock;

import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.ITextFeature;
import hk.ust.cse.TwitterClient.StyleTweet.core.ITextFeatureData;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.widgets.Event;
import org.junit.Ignore;

/**
 * Created with IntelliJ IDEA.
 * User: MARTIN
 * Date: 4/5/13
 * Time: 8:04 PM
 * To change this template use File | Settings | File Templates.
 */

@Ignore
public class NullTextFeature implements ITextFeature {
    @Override
    public ITextFeatureData getData() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void BuildData(String Text) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean eventHandle(Event e) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public StyleRange decorate() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
