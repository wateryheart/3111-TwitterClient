package hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.StyleTweet.core.Entity;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Event;
import twitter4j.*;
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
    private MediaEntity[] _mediaEntites;

    public LinkTweetFeature(URLEntity[] urlEntities, MediaEntity[] mediaEntities) {
        super(new LinkTextStyle());
        _urlEntities = urlEntities;
        _mediaEntites = mediaEntities;
    }

    public void BuildData(String text) {

        if(text == null || text.length() < 1) return;

        List<Entity> entityList = new ArrayList<Entity>();
        if(_urlEntities != null){
            Queue<String> expandedURLs = new ConcurrentLinkedQueue<String>();
            Queue<String> mediaExpandedURLs = new ConcurrentLinkedQueue<String>();

            if(_urlEntities.length > 0){

                for (URLEntity urlEntity : _urlEntities) {
                    text = text.replace(urlEntity.getURL(), urlEntity.getDisplayURL());
                     expandedURLs.offer(urlEntity.getExpandedURL());
                }
            }

            if(_mediaEntites.length > 0){
                for (MediaEntity mediaEntity : _mediaEntites){
                    text = text.replace(mediaEntity.getURL(), mediaEntity.getDisplayURL());
                    mediaExpandedURLs.offer(mediaEntity.getExpandedURL());
                }
            }

            String url;
            int start, length;
            int maxLength = text.length();

            /**
             *   Use regular expression to gather all the url information, like the text position.
             */

            List<String> distinctList;
            Pattern pattern;
            Matcher matcher;

            if(mediaExpandedURLs.size() > 0){
                distinctList = getMediaDistinctURLs();
                pattern = createPattern(distinctList);
                matcher = pattern.matcher(text);
                while (matcher.find()){
                    logger.debug( String.format("string: %s, regionStart: %d, regionEnd: %d, start: %d, end: %d", matcher.group(), matcher.regionStart(), matcher.regionEnd(), matcher.start(), matcher.end()));
                    url = matcher.group(); // get url
                    start = matcher.start();//get url start point of the full text
                    if (start < 0 || start > maxLength) continue;
                    length = url.length();

                    entityList.add(new Entity(mediaExpandedURLs.poll() , start, length)); // save it to the list, which would be handled later.
                }
            }
            if(expandedURLs.size() > 0){
                distinctList = getDistinctURLs();
                pattern = createPattern(distinctList);
                matcher = pattern.matcher(text);
                while (matcher.find()){
                    logger.debug( String.format("string: %s, regionStart: %d, regionEnd: %d, start: %d, end: %d", matcher.group(), matcher.regionStart(), matcher.regionEnd(), matcher.start(), matcher.end()));
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

        logger.debug(sb.toString());
        return Pattern.compile(sb.toString());
    }

    /**
     * this function would extract the urlEntities to a url list.
     * each url would record once only. In other words no duplicate items would be obscured in the same list .
     * @return
     */
    private List<String> getDistinctURLs() {
        List<String> distinctList = new ArrayList<String>();
        for(URLEntity entity : _urlEntities){
            if(entity == null) continue;
            String url =  entity.getDisplayURL();
            if( url!= null && !distinctList.contains(url) )
                distinctList.add(url);
        }
        logger.debug( Arrays.toString(_urlEntities));
        return distinctList;
    }

    /**
     * this function would extract the mediaEntities to a url list.
     * each url would record once only. In other words no duplicate items would be obscured in the same list .
     * @return
     */
    private List<String> getMediaDistinctURLs(){
        List<String> distinctList = new ArrayList<String>();
        String url;
        for(MediaEntity entity : _mediaEntites){
            if(entity == null) continue;
            url =  entity.getDisplayURL();
            if( url != null && !distinctList.contains(url) )
                distinctList.add(url);
        }
        logger.debug( Arrays.toString(_mediaEntites));
        return distinctList;
    }

    @Override
    public boolean eventHandle(Event event) {


        logger.debug("=> LinkTweetFeature.eventHandle");
        if(event == null || event.data == null) return false;
        int offset = Integer.parseInt(event.data.toString());
         logger.debug("offset: " + offset);

        if (Data == null)
             logger.debug("Data have not initialized yet.");

        for (Entity Entity : Data.getEntities()) {
            if (offset >= Entity.Start && offset <= (Entity.Start + Entity.Length)) {
                logger.debug("URL: " + Entity);
                Program.launch(Entity.Text);
                return true;
            }
        }
        return false;
    }

}

