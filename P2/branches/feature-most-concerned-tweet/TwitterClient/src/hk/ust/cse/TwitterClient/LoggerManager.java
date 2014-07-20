package hk.ust.cse.TwitterClient;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *  Author : Chan Ka Yue, Martin
 */
public class LoggerManager {
    private static Set<Logger> loggers = new HashSet<Logger>();
    private static boolean isFirst = true;
    /**
     * enable loggers . use system property to enable/disable the logger.
     * usage:
     * 1. type "-Dlog=true -Dlog-myfeature=true" at the vmOptions in Run Configuration. "log-myfeature" is the value of system property. "myfeature" is the logger name, please replace it with a custom name.
     * 2. add the logger's name, e.g: "myfeature" as a parameter  when create the instance of "LoggerManager". e.g:
     *		new LoggerManager("xxx", "yyy" , "myfeature")
     * 3. you can use it by adding the following line to your class(s).
     *		private static final Logger logger = Logger.getLogger("myfeature")
     * 4. enjoy and try to call this!
     *		logger.info("it works!");
     *
     * @param toEnableLoggerNames : loggerName
     *
     * example: "-Dlog=true -Dlog-mutex=true -Dlog-styletweet=true", enable mutex logging and style-tweet logging.
     * example: "-Dlog=true -Dlog-all=true", enable all loggers.
     * example: "-Dlog=false" (default), disable logging.
     */

    public LoggerManager(String... toEnableLoggerNames){
        //setup
        if (!"true".equals(System.getProperty("log")))
            java.util.logging.LogManager.getLogManager().reset();
        else {
            if (!"true".equals(System.getProperty("log-all"))) {
                java.util.logging.LogManager logManager = LogManager.getLogManager();
                Set<String> toDisableLoggerNames = new HashSet<String>(Collections.list(logManager.getLoggerNames()));
                if (toEnableLoggerNames != null) {

                    //enable the loggers one by one
                    for (String loggerName : toEnableLoggerNames) {
                        String vmOptions = "log-" + loggerName;

                        if (loggerName.equals(null) || vmOptions.equals(null) || loggerName.length() < 1 || vmOptions.length() < 1)
                            continue;
                        if (!"true".equals(System.getProperty(vmOptions)))
                            toDisableLoggerNames.add(loggerName);
                        else {
                            toDisableLoggerNames.remove(loggerName);
                            Logger logger = Logger.getLogger(loggerName);
                            logger.setLevel(Level.ALL);

                            loggers.add(logger);

                            // if this is not the first time run, the current logger may disabled before,
                            // which means the handler was removed , you need to add it back.
                            // currently we use a single handler,  consoleHandler only.
                            if(!isFirst)
                                logger.addHandler(new ConsoleHandler());
                            logger.info("Logger - " + loggerName + " is enabled");
                        }
                    }

                    //disable the loggers one by one
                    for (String loggerName : toDisableLoggerNames) {
                        Logger logger = Logger.getLogger(loggerName);
                        logger.setLevel(Level.OFF);
                        logger.setUseParentHandlers(false);
                        logger.removeHandler(new ConsoleHandler());
                        loggers.remove(logger);
                    }
                }
            }else{
                // if this is not the first time run , there may be some loggers were disabled before ,
                //  or some loggers was created after the first time run.
                //  Thus, you need to enable them one by one.
                if(!isFirst){
                    LogManager logManager = LogManager.getLogManager();
                    Enumeration<String> enumerator = logManager.getLoggerNames();
                    while (enumerator.hasMoreElements()){
                        String loggerName = enumerator.nextElement();
                        if (loggerName.equals(null) || loggerName.length() < 1)
                            continue;
                        Logger logger = logManager.getLogger(loggerName);
                        logger.setLevel(Level.ALL);
                    }
                }
            }
        }

        isFirst = false;
    }
}
