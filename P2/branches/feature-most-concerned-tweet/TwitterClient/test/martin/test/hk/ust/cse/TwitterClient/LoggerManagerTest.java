package martin.test.hk.ust.cse.TwitterClient;

import hk.ust.cse.TwitterClient.LoggerManager;
import junit.framework.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: martin
 * Date: 4/21/13
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoggerManagerTest {
    @Test(timeout = 10000)
    public void setupLoggingTest(){

        String[] names;

        // ---------------------------------------------------------------------------
        System.setProperty("log","false");

        createLoggingInstance(new Object[]{null});

        names = new String[2];
        names[0] = "567yu4hg32fafg";
        names[1] = "vszasfsa";

        createLoggingInstance(new Object[]{ names });

        Assert.assertEquals(null, Logger.getLogger(names[0]).getLevel());
        Assert.assertEquals(null, Logger.getLogger(names[1]).getLevel());

        Logger.getLogger(names[0]).info("logger0 ,  log false .");
        Logger.getLogger(names[0]).info("logger1 ,  log false .");

        // test null arguments
        createLoggingInstance(new Object[]{ null });

        Assert.assertEquals(null, Logger.getLogger(names[0]).getLevel());
        Assert.assertEquals(null, Logger.getLogger(names[1]).getLevel());

        Logger.getLogger(names[0]).info("logger0 ,  null arguments .");
        Logger.getLogger(names[0]).info("logger1 ,  null  arguments .");

        // ----------------------------------------------------------------------
        System.setProperty("log","true");

        createLoggingInstance(new Object[]{null});

        names = new String[2];
        names[0] = "i7ifefwv";
        names[1] = "fhafiyugywg8";

        System.setProperty("log-" + names[0],"true");

        createLoggingInstance(new Object[]{ names });

        Assert.assertEquals(Level.ALL, Logger.getLogger(names[0]).getLevel());
        Assert.assertEquals(Level.OFF, Logger.getLogger(names[1]).getLevel());

        Logger.getLogger(names[0]).info("logger0 ,  log true log0 true.");
        Logger.getLogger(names[1]).info("logger1 ,  log true log1 false .");

        System.setProperty("log-" + names[0], "false");

        createLoggingInstance(new Object[]{ names });

        Assert.assertEquals(Level.OFF, Logger.getLogger(names[0]).getLevel());
        Logger.getLogger(names[0]).info("logger0 ,  log true log0 false.");

        //test null arguments
        createLoggingInstance(new Object[]{ null });
        // ------------------------------------------------------------------------
        System.setProperty("log-all", "true");

        names = new String[2];
        names[0] = "i7ifefwv";
        names[1] = "fhafiyugywg8";

        createLoggingInstance(new Object[]{ names });

        Assert.assertEquals(Level.ALL, Logger.getLogger(names[0]).getLevel());
        Assert.assertEquals(Level.ALL, Logger.getLogger(names[1]).getLevel());

        Logger.getLogger(names[0]).info("logger0 ,  log all true .");
        Logger.getLogger(names[0]).info("logger1 ,  log all true .");
    }

    private void createLoggingInstance(Object [] arguments ) {

        if(constructor == null) {
            Class<LoggerManager> cls = LoggerManager.class;
            try {
                constructor = cls.getConstructor(new Class[]{String[].class});
            } catch (NoSuchMethodException e) {
                Assert.assertNull(e);
            }
            constructor.setAccessible(true);
        }

        try {
            constructor.newInstance( arguments );
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Assert.assertNull(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            Assert.assertNull(e);
        } catch (InstantiationException e) {
            e.printStackTrace();
            Assert.assertNull(e);

        }
    }
    private static Constructor constructor = null;

}
