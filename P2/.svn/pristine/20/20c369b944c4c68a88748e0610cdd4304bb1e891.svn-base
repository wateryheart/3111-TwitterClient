package hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.StyleTweet.core.Entity;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Event;
import twitter4j.URLEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        if(text == null || text.length() < 1) return;

        String url;
        int start, length;
        int maxLength = text.length();

        List<Entity> entityList = new ArrayList<Entity>();
        if(_urlEntities != null){
            if(_urlEntities.length > 0){


                Queue<String> expandedURLs = new ConcurrentLinkedQueue<String>();
                for (URLEntity urlEntity : _urlEntities) {
                    text = text.replace(urlEntity.getURL(), urlEntity.getDisplayURL());
                     expandedURLs.offer(urlEntity.getExpandedURL());
                }

                /**
                 *   Use regular expression to gather all the url information, like the text position.
                 */

                List<String> distinctList = getDistinctURLs();
                Pattern pattern = createPattern(distinctList);
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()){
                    logger.log(Level.INFO, String.format("string: %s, regionStart: %d, regionEnd: %d, start: %d, end: %d", matcher.group(), matcher.regionStart(), matcher.regionEnd(), matcher.start(), matcher.end()));
                    url = matcher.group(); // get url
                    start = matcher.start();//get url start point of the full text
                    if (start < 0 || start > maxLength) continue;
                    length = url.length();

                    entityList.add(new Entity(expandedURLs.poll() , start, length)); // save it to the list, which would be handled later.
                }
            }
        }


        Data = new TextFeatureData(text, entityList.toArray(new Entity[entityList.size()]));
    }

    /**
     *  create the search string using regular expression.
     * @param distinctList
     * @return
     */
    private Pattern createPattern(List<String> distinctList) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i=0; i < distinctList.size(); i++){
            if( i != 0 )
                sb.append("|");
            sb.append(distinctList.get(i));
        }
        sb.append(")");

        logger.log(Level.INFO,sb.toString());
        return Pattern.compile(sb.toString());
    }

    /**
     * this function would extract the userMentionEntities to a url list.
     * each url would record once only. In other words no duplicate items would be obscured in the same list .
     * @return
     */
    private List<String> getDistinctURLs() {
        List<String> distinctList = new ArrayList<String>();
        for(URLEntity entity : _urlEntities){
            if(entity == null) continue;
            String screenName =  entity.getDisplayURL();
            if( screenName!= null && !distinctList.contains(screenName) )
                distinctList.add(screenName);
        }
        logger.log(Level.INFO, Arrays.toString(_urlEntities));
        return distinctList;
    }

    @Override
    public boolean eventHandle(Event event) {


        logger.log(Level.INFO,"=> LinkTweetFeature.eventHandle");
        if(event == null || event.data == null) return false;
        int offset = Integer.parseInt(event.data.toString());
         logger.log(Level.INFO,"offset: " + offset);

        if (Data == null)
             logger.log(Level.INFO,"Data have not initialized yet.");

        for (Entity Entity : Data.getEntities()) {
            if (offset >= Entity.Start && offset <= (Entity.Start + Entity.Length)) {
                logger.log(Level.INFO,"URL: " + Entity);
                Program.launch(Entity.Text);
                return true;
            }
        }
        return false;
    }

}

