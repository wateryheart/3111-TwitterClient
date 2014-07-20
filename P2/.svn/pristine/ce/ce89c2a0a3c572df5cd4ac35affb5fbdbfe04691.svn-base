package hk.ust.cse.TwitterClient.StyleTweet.TweetFeatures;

import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.StyleTweet.core.Entity;
import hk.ust.cse.TwitterClient.Utils;
import hk.ust.cse.TwitterClient.Views.WholePage;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Event;
import twitter4j.User;
import twitter4j.UserMentionEntity;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

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

        String name,searchName,searchText;
        int start, length;
        int maxLength = text.length();

        List<Entity> entityList = new ArrayList<Entity>();
        if(_userMentionEntities != null){

            for (UserMentionEntity userMentionEntity : _userMentionEntities) {

                 logger.log(Level.INFO, "Name: " + userMentionEntity.getScreenName());

                name = userMentionEntity.getScreenName();
                searchName = name.toLowerCase();
                searchText = text.toLowerCase();
                start = searchText.indexOf("@" + searchName);
                if (start < 0 || start > maxLength) continue;
                length = name.length() + 1;
                entityList.add(new Entity(name, start, length));
            }
        }

        Data = new TextFeatureData(text, entityList.toArray(new Entity[entityList.size()]));
    }

    @Override
    public boolean eventHandle(Event event) {

         logger.log(Level.INFO, "=> MentionsTweetFeature.eventHandle");

        int offset = Integer.parseInt(event.data.toString());
         logger.log(Level.INFO, "offset: " + offset);

        for (Entity Entity : Data.getEntities()) {
            if (offset >= Entity.Start && offset <= (Entity.Start + Entity.Length)) {
                 logger.log(Level.INFO, "screen name: " + Entity.Text);

                try {

                    Method method = WholePage.class.getDeclaredMethod("gotoMiniUserPage", User.class);
                    method.setAccessible(true);
                    User user = TwitterControl.getUser(Entity.Text);
                    method.invoke(_m_handlerCallee, user);

                } catch (Exception e) {e.printStackTrace();}

                return true;
            }
        }
        return false;
    }

}
