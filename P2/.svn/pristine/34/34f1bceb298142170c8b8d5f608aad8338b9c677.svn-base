package hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.StyleTweet.core.Entity;
import hk.ust.cse.TwitterClient.Views.WholePage;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Event;
import twitter4j.HashtagEntity;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Chan Ka Yue Martin
 */

public class HashTagTweetFeature extends  BaseTweetFeature{

    private HashtagEntity[] _hashTagEntities;
    private Object _m_handlerCallee;

    public HashTagTweetFeature(HashtagEntity[] hashTagEntities, Object m_handlerCallee) {
        super(new LinkTextStyle());
        _hashTagEntities = hashTagEntities;
        _m_handlerCallee = m_handlerCallee;
    }

    @Override
    public void BuildData(String text) {

        if(text == null) return;

        String tagName;
        int start, length;
        int maxLength = text.length();

        List<Entity> entityList = new ArrayList<Entity>();
        if(_hashTagEntities != null){
            if(_hashTagEntities.length > 0){

                List<String> distinctList = getDistinctHashTags();

                /**
                                 *   Use regular expression to gather all the screenNames information, like the text position.
                                 */
                Pattern pattern = createPattern(distinctList);
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()){
                    logger.log(Level.INFO, String.format("TagName: %s, regionStart: %d, regionEnd: %d, start: %d, end: %d", matcher.group(), matcher.regionStart(), matcher.regionEnd(), matcher.start(), matcher.end()));
                    tagName = matcher.group(); // get tagName
                    start = matcher.start();//get tagName start point of the full text
                    if (start < 0 || start > maxLength) continue;
                    length = tagName.length();
                    entityList.add(new Entity(tagName, start, length)); // save it to the list, which would be handled later.
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
            sb.append("#" + distinctList.get(i));
        }
        sb.append(")");

        logger.log(Level.INFO,sb.toString());
        return Pattern.compile(sb.toString());
    }

    /**
     * this function would extract the hashTagEntities to a hashTag list.
     * each hashTag would record once only. In other words no duplicate items would be obscured in the same list .
     * @return
     */
    private List<String> getDistinctHashTags() {
        List<String> distinctList = new ArrayList<String>();
        for(HashtagEntity entity : _hashTagEntities){
            if(entity == null) continue;
            String text =  entity.getText();
            if( text!= null && !distinctList.contains(text) )
                distinctList.add(text);
        }
        logger.log(Level.INFO, Arrays.toString(_hashTagEntities));
        return distinctList;
    }

    @Override
    public boolean eventHandle(Event event) {
        logger.log(Level.INFO,"=> HashTagTweetFeature.eventHandle");
        if(event == null || event.data == null) return false;
        int offset = Integer.parseInt(event.data.toString());
        logger.log(Level.INFO,"offset: " + offset);

        if (Data == null)
            logger.log(Level.INFO,"Data have not initialized yet.");

        for (Entity Entity : Data.getEntities()) {
            if (offset >= Entity.Start && offset <= (Entity.Start + Entity.Length)) {
                logger.log(Level.INFO,"URL: " + Entity.Text);
                if(Entity.Text != null){
                    String searchText = Entity.Text.startsWith("#")? Entity.Text.substring(1,Entity.Text.length()): Entity.Text;
                    Program.launch("https://twitter.com/search?q=" + searchText);
                }
                return true;
            }
        }
        return false;
    }
}

