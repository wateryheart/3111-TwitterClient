package hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.StyleTweet.core.Entity;
import hk.ust.cse.TwitterClient.Views.WholePage;
import org.eclipse.swt.widgets.Event;
import twitter4j.User;
import twitter4j.UserMentionEntity;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Chan Ka Yue Martin
 */

public class MentionsTweetFeature extends BaseTweetFeature {

    private UserMentionEntity[] _userMentionEntities;

    private Object _m_handlerCallee;
    public MentionsTweetFeature(UserMentionEntity[] userMentionEntities, Object m_handlerCallee) {
        super(new LinkTextStyle());
        _userMentionEntities = userMentionEntities;
        _m_handlerCallee = m_handlerCallee;
    }

    public void BuildData(String text) {

        if(text == null || text.length() < 1) return;

        String name;
        int start, length;
        int maxLength = text.length();

        List<Entity> entityList = new ArrayList<Entity>();
        if(_userMentionEntities != null){
            if(_userMentionEntities.length > 0){

                List<String> distinctList = getDistinctUserScreenNames();

                /**
                                *   Use regular expression to gather all the screenNames information, like the text position.
                                */
                Pattern pattern = createPattern(distinctList);
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()){
                    logger.debug( String.format("string: %s, regionStart: %d, regionEnd: %d, start: %d, end: %d", matcher.group(), matcher.regionStart(), matcher.regionEnd(), matcher.start(), matcher.end()));
                    name = matcher.group(); // get screenName
                    start = matcher.start();//get screenName start point of the full text
                    if (start < 0 || start > maxLength) continue;
                    length = name.length();
                    entityList.add(new Entity(name, start, length)); // save it to the list, which would be handled later.
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
            sb.append("@" + distinctList.get(i));
        }
        sb.append(")");

        logger.debug(sb.toString());
        return Pattern.compile(sb.toString());
    }

    /**
        * this function would extract the userMentionEntities to a user Screen Name list.
        * each screenName would record once only. In other words no duplicate items would be obscured in the same list .
        * @return
        */
    private List<String> getDistinctUserScreenNames() {
        List<String> distinctList = new ArrayList<String>();
        for(UserMentionEntity entity : _userMentionEntities){
            if(entity == null) continue;
            String screenName =  entity.getScreenName();
            if( screenName!= null && !distinctList.contains(screenName) )
               distinctList.add(screenName);
        }
        logger.debug( Arrays.toString(_userMentionEntities));
        return distinctList;
    }

    @Override
    public boolean eventHandle(Event event) {

        logger.debug( "=> MentionsTweetFeature.eventHandle");
        if(event == null || event.data == null) return false;
        int offset = Integer.parseInt(event.data.toString());
         logger.debug( "offset: " + offset);

        for (Entity Entity : Data.getEntities()) {
            if (offset >= Entity.Start && offset <= (Entity.Start + Entity.Length)) {
                 logger.debug( "screen name: " + Entity.Text);

                try {

                    Method method = WholePage.class.getDeclaredMethod("gotoMiniUserPage", User.class);
                    method.setAccessible(true);
                    String userName = Entity.Text.substring(1,Entity.Text.length());
                    User user = TwitterControl.getUser(userName);
                    method.invoke(_m_handlerCallee, user);

                } catch (Exception e) {e.printStackTrace();}

                return true;
            }
        }
        return false;
    }

}
