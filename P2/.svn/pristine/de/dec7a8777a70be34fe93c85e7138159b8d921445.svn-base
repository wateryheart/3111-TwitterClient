package hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.StyleTweet.core.Entity;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Event;
import twitter4j.URLEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * @author Chan Ka Yue Martin
 */

public class LinkTweetFeature extends BaseTweetFeature {

    private URLEntity[] _urlEntities;

    public LinkTweetFeature(URLEntity[] urlEntities) {
        super(new LinkTextStyle());
        _urlEntities = urlEntities;
    }

    public void BuildData(String text) {
        String url;
        int start, length;
        int maxLength = text.length();

        List<Entity> entityList = new ArrayList<Entity>();
        for (URLEntity urlEntity : _urlEntities) {
            text = text.replace(urlEntity.getURL(), urlEntity.getDisplayURL());
            url = urlEntity.getDisplayURL();

            logger.log(Level.INFO,"URL: " + urlEntity.getURL() + ", Display:  " + urlEntity.getDisplayURL() + " Expanded: " + urlEntity.getExpandedURL());

            start = text.indexOf(url);
            if (start < 0 || start > maxLength) continue;
            length = url.length();
            entityList.add(new Entity(urlEntity.getExpandedURL(), start, length));
        }

        Data = new TextFeatureData(text, entityList.toArray(new Entity[entityList.size()]));
    }

    @Override
    public boolean eventHandle(Event event) {


         logger.log(Level.INFO,"=> LinkTweetFeature.eventHandle");
        int offset = Integer.parseInt(event.data.toString());
         logger.log(Level.INFO,"offset: " + offset);

        if (Data == null)
             logger.log(Level.INFO,"Data have not initialized yet.");

        for (Entity Entity : Data.getEntities()) {
            if (offset >= Entity.Start && offset <= (Entity.Start + Entity.Length)) {
                 logger.log(Level.INFO,"URL: " + Entity.Text);
                Program.launch(Entity.Text);
                return true;
            }
        }
        return false;
    }

}

