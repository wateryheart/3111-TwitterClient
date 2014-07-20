package hk.ust.cse.TwitterClient;

import org.apache.log4j.Appender;
import org.apache.log4j.spi.RootLogger;

import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: MARTIN
 * Date: 4/18/13
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */
public final class LogManager {
    public static void removeAppender(String name){
          removeAppender(new String[]{name});
    }
    public static void removeAppender(String[] names){
        if(names == null)return;
        Enumeration<Appender> enumeration = RootLogger.getRootLogger().getAllAppenders();
        while (enumeration.hasMoreElements())
        {
            Appender appender =  enumeration.nextElement();
            for(String name : names){
                if ( name != null && name.equals(appender.getClass().getName()))
                    RootLogger.getRootLogger().removeAppender(appender);
            }
        }
    }

}
