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
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */

@Ignore
public class MockTextFeature implements ITextFeature {
    @Override
    public ITextFeatureData getData() {
        return data;
    }
    private ITextFeatureData data;
    public void setData(ITextFeatureData data){
        this.data = data;
    }

    @Override
    public void BuildData(String Text) {}

    @Override
    public boolean eventHandle(Event e) {
        return eventHandleReturnValue;
    }

    private boolean eventHandleReturnValue;
    public void setEventHandleReturnValue(boolean bool){
        eventHandleReturnValue = bool;
    }
    @Override
    public StyleRange decorate() {
        return decorateReturnValue;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private StyleRange decorateReturnValue;
    public void setDecorateReturnValue(StyleRange styleRange){
        this.decorateReturnValue = styleRange;
    }
}
