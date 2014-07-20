package martin.test.StyleTweet.core;

import hk.ust.cse.TwitterClient.StyleTweet.core.IView;
import hk.ust.cse.TwitterClient.StyleTweet.core.StyleTweetView;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: MARTIN
 * Date: 4/5/13
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */

public class StyleTweetViewTest {

    @Test(timeout = 10000)
    public void simpleTest(){

        Display display = new Display();
        Shell shell = new Shell(display);

        RowComposite rowComposite = new RowComposite( shell , 0, 0, false, 0, 0, 0, 0, 0);
        IView view = new StyleTweetView(rowComposite, rowComposite);

        assertNotNull(view);

        view.SetText("Hello World.");


        shell.dispose();

    }
}
