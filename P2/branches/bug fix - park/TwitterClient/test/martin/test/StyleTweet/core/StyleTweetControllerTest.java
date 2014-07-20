package martin.test.StyleTweet.core;

import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.ITextFeature;
import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.TextFeatureData;
import hk.ust.cse.TwitterClient.StyleTweet.core.*;
import hk.ust.cse.TwitterClient.Views.Basic.RowComposite;
import martin.test.StyleTweet.Mock.MockStyleTweetMouseListener;
import martin.test.StyleTweet.Mock.MockTextFeature;
import martin.test.StyleTweet.Mock.NullTextFeature;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: MARTIN
 * Date: 4/5/13
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class StyleTweetControllerTest {



    @Test(timeout = 10000)
    public void NullViewTest(){

        IController controller = new StyleTweetController(null);
        assertNotNull(controller);

        controller.AddFeature(null);
        controller.ApplyChange();

        controller.AddListener(0,null);
        controller.ApplyChange();

        controller.RemoveFeature(null);
        controller.ApplyChange();

        controller.setText(null);
        controller.ApplyChange();

        controller.setText("");
        controller.ApplyChange();


        controller.AddFeature(new ITextFeature() {
            @Override
            public ITextFeatureData getData() {
                return null;
            }

            @Override
            public void BuildData(String Text) {

            }

            @Override
            public boolean eventHandle(Event e) {
                return false;
            }

            @Override
            public StyleRange decorate() {
                return null;
            }
        });
        controller.ApplyChange();
    }

    @Test(timeout = 100000)
    public void concreteViewTest(){

        //create view
        Display display = new Display();
        Shell shell = new Shell(display);
        RowComposite rowComposite = new RowComposite( shell , 0, 0, false, 0, 0, 0, 0, 0);
        IView view = new StyleTweetView(rowComposite,rowComposite);

        //test controller

        //null text
        IController controller = new StyleTweetController(view);
        assertNotNull(controller);

        //StyledText styledText = getStyledText(view);
        //assertNotNull(styledText);
        StyledText styledText;
        Set listenerList = getListenerList(controller);
        assertNotNull(listenerList);
        List featureList = getFeatureList(controller);
        assertNotNull(featureList);
        ITextFeature nullTextFeature = new NullTextFeature();
        assertNotNull(nullTextFeature);

        controller.setText(null);
        controller.ApplyChange();

        controller.AddFeature(null);
        controller.ApplyChange();
        assertSame(0,featureList.size());


        controller.AddFeature( nullTextFeature );
        controller.ApplyChange();
        assertSame(1,featureList.size());

        controller.RemoveFeature( null );
        controller.ApplyChange();
        assertSame(1,featureList.size());

        controller.RemoveFeature( nullTextFeature );
        controller.ApplyChange();
        assertSame(0, featureList.size());

        controller.AddListener(0,null);
        controller.ApplyChange();

        controller.RemoveListener(0, null);
        controller.ApplyChange();

        assertSame( 0, listenerList.size() );
        // some text
        controller.setText("some text");
        controller.ApplyChange();

        styledText = getStyledText(view);
        String text = styledText.getText();
        assertNotNull(text);
        assertTrue(text.equals("some text"));

        controller.AddFeature(null);
        controller.ApplyChange();
        assertSame(0,featureList.size());

        controller.AddFeature( nullTextFeature );
        controller.ApplyChange();
        assertSame(1,featureList.size());

        controller.RemoveFeature( null );
        controller.ApplyChange();
        assertSame(1,featureList.size());

        controller.RemoveFeature( nullTextFeature );
        controller.ApplyChange();
        assertSame(0,featureList.size());

        controller.AddListener(0,null);
        controller.ApplyChange();

        controller.RemoveListener(0, null);
        controller.ApplyChange();

        assertSame( 0, listenerList.size() );


        // Test textfeature with some values
        MockTextFeature textFeature = new MockTextFeature();

        //1
        textFeature.setData(new TextFeatureData(null, new Entity[]{new Entity(null,1,2)}));

        textFeature.setDecorateReturnValue(null);
        controller.AddFeature(textFeature);
        controller.ApplyChange();

        //2
        textFeature.setData(new TextFeatureData("some text", new Entity[]{new Entity("string", 1, 2)}));

        textFeature.setDecorateReturnValue(new StyleRange());
        controller.AddFeature(textFeature);
        controller.ApplyChange();


        // listener
        assertSame( 0, listenerList.size() );
        Listener listener = new MockStyleTweetMouseListener();
        controller.AddListener(0, listener);
        controller.ApplyChange();
        assertSame(1, listenerList.size());
        controller.RemoveListener(0, listener);
        controller.ApplyChange();
        assertSame( 0, listenerList.size() );

        shell.dispose();
    }


    @Ignore
    private Set<Pair<Integer, Listener>> getListenerList(IController controller){
        Class<?> cls = StyleTweetController.class;

        if(controller == null)
            assertNotNull(controller);

        Field field = null;
        try {
            field = cls.getDeclaredField("listenerPairs");
        } catch (NoSuchFieldException e) {
            assertNull(e);
            //e.printStackTrace();
        }
        assertNotNull(field);
        field.setAccessible(true);
        Object value = null;
        try {
            value = field.get(controller);
        } catch (IllegalAccessException e) {
            assertNull(e);
            //e.printStackTrace();
        }

        Set<Pair<Integer, Listener>> list = (Set<Pair<Integer, Listener>>)value;
        return list;
    }

    @Ignore
    private List<ITextFeature> getFeatureList(IController controller){
        Class<?> cls = StyleTweetController.class;

        if(controller == null)
            assertNotNull(controller);

        Field field = null;
        try {
            field = cls.getDeclaredField("features");
        } catch (NoSuchFieldException e) {
            assertNull(e);
            //e.printStackTrace();
        }
        assertNotNull(field);
        field.setAccessible(true);
        Object value = null;
        try {
            value = field.get(controller);
        } catch (IllegalAccessException e) {
            assertNull(e);
            //e.printStackTrace();
        }

        List<ITextFeature> list = (List<ITextFeature>)value;
        return list;
    }

    @Ignore
    public StyledText getStyledText(IView view){

        Class<?> cls = StyleTweetView.class;

        if(view == null)
            assertNotNull(view);

        Field field = null;
        try {
            field = cls.getDeclaredField("styledText");
        } catch (NoSuchFieldException e) {
            assertNull(e);
            //e.printStackTrace();
        }
        assertNotNull(field);
        field.setAccessible(true);
        Object value = null;
        try {
            value = field.get(view);
        } catch (IllegalAccessException e) {
            assertNull(e);
            //e.printStackTrace();
        }

        StyledText obj = (StyledText)value;
        return obj;

    }
}
