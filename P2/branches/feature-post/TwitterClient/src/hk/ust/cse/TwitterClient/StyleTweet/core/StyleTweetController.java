package hk.ust.cse.TwitterClient.StyleTweet.core;

import hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures.ITextFeature;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.widgets.Listener;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chan Ka Yue Martin
 */

public class StyleTweetController implements IController {

    static final Logger logger = Logger.getLogger("styleTweet");

    private IView _view;
    private List<ITextFeature> features;
    private Set<Pair<Integer, Listener>> listenerPairs;

    private String Text;

    public StyleTweetController(IView view) {
        features = new ArrayList<ITextFeature>();
        listenerPairs = new HashSet<Pair<Integer, Listener>>();

        _view = view;
    }

    public void AddListener(int type, Listener listener) {
        if (listener != null)
            listenerPairs.add(new Pair<Integer, Listener>(type, listener));
    }

    public void RemoveListener(int type, Listener listener) {
        listenerPairs.remove(new Pair<Integer, Listener>(type, listener));
    }

    @Override
    public void AddFeature(ITextFeature tweetFeature) {
        if (tweetFeature != null)
            features.add(tweetFeature);
    }

    @Override
    public void RemoveFeature(ITextFeature tweetFeature) {
        features.remove(tweetFeature);
    }

    public void setText(String text) {
        Text = text;
    }


    public void ApplyChange() {

        if(_view == null) return;

            //reset the view
        _view.Render();


        if (Text != null) {
            ITextFeature lastTextTweetFeature = BuildFeaturesData();

            if(lastTextTweetFeature != null){
                //set the last modified text result to the view
                ITextFeatureData data =  lastTextTweetFeature.getData();
                if(data != null)
                _view.SetText(data.getText());
            }else{
                _view.SetText(Text);
            }
        }

        //- handling the text style, like text color, underline, font size.
        //- use SortedMap type  to ensure the collection entity array is in ascending order.
        //- To apply the text style, the text position must be sequential and the list  can not in non-ascending order. Otherwise a Exception would be thrown.

        SortedMap<Integer, Pair<Entity, ITextStyle>> entitySortedMap = new TreeMap<Integer, Pair<Entity, ITextStyle>>();

        for (ITextFeature tweetFeature : features) {
            ITextFeatureData data =  tweetFeature.getData();
            if(data != null){
                Entity[] entities = data.getEntities();

                for (Entity entity : entities) {
                    entitySortedMap.put(entity.Start, new Pair<Entity, ITextStyle>(entity, tweetFeature));
                }
                // logger.log(Level.INFO, String.format("entities size: %d", entities.length) );
            }
        }

        final List<StyleRange> styles = new ArrayList<StyleRange>();
        final List<Integer> ranges = new ArrayList<Integer>();

         logger.log(Level.INFO, "-----------------------------------------------------------------------------------------------");

        boolean interrupt = false;
        for (Pair<Entity, ITextStyle> p : entitySortedMap.values()) {
            Entity e = p.getKey();
            ITextStyle d = p.getValue();

            if(e.Text == null || d.decorate() == null){
                interrupt = true;
                break;
            }

             logger.log(Level.INFO, String.format("key => start: %d length: %d text: %s ", e.Start, e.Length, e.Text));

            ranges.add(e.Start);
            ranges.add(e.Length);
            styles.add(d.decorate());

        }

        if(!interrupt){
        //call one time to set all text styles to the view
            _view.SetStyle(toIntArray(ranges), styles.toArray(new StyleRange[styles.size()]));
        }else{
             logger.log(Level.INFO, "set style interrupted.");
        }

        //add listener to view
        for (final Pair<Integer, Listener> p : listenerPairs) {
            _view.AddListener(p.getKey(), p.getValue());
        }
    }

    /**
     * Apply the list of features to the styleTweetView
     * Feature would modify the text that it would be displayed in this view.. In here it  use FCFS.
     * he text output of the 1st feature would pipe to 2nd feature and so on.
     *
     * @return
     */
    private ITextFeature BuildFeaturesData() {
        ITextFeature prevTextTweetFeature = null, currTextTweetFeature = null;
        Iterator<ITextFeature> iterator = features.iterator();
        while (iterator.hasNext()) {
            currTextTweetFeature = iterator.next();
            if (currTextTweetFeature != null) {
                if (prevTextTweetFeature == null) {
                    currTextTweetFeature.BuildData(Text);
                } else {

                     ITextFeatureData data = prevTextTweetFeature.getData();
                    if (data != null)
                        currTextTweetFeature.BuildData(data.getText());
                }
            }
            prevTextTweetFeature = currTextTweetFeature;

        }
        return currTextTweetFeature;
    }

    /**
     * @param list
     * @return
     */
    private static int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);
        return ret;
    }
}
