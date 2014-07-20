package hk.ust.cse.TwitterClient.Controls;

import com.common.IPair;
import com.common.Pair;
import com.spaceprogram.kittycache.KittyCache;
import hk.ust.cse.TwitterClient.Controls.common.Arguments;
import hk.ust.cse.TwitterClient.Controls.common.ICallBack;
import hk.ust.cse.TwitterClient.Controls.common.getHomeTimelineArguments;
import org.eclipse.swt.widgets.Display;
import twitter4j.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CachedTwitter {

    private static final Logger logger = Logger.getLogger("cachedtwitter");

    private static KittyCache<IPair<String, Integer>, List<Status>> Cache;
    private static LinkedHashMap<String, Arguments> CallBacks;
    private static Twitter Twitter;
    private static AsyncTwitter AsyncTwitter;
    private static User accountUser;

    public CachedTwitter() {
        this(TwitterFactory.getSingleton(), AsyncTwitterFactory.getSingleton());
    }

    public CachedTwitter(Twitter twitter, AsyncTwitter asyncTwitter) {

        Twitter = twitter;
        AsyncTwitter = asyncTwitter;

        // init the caches object
        Cache = new KittyCache<IPair<String, Integer>, List<Status>>(5000);
        // init the callbacks object
        CallBacks = new LinkedHashMap<String, Arguments>();

        switchAccountUser();

        AsyncTwitter.addListener(twitterHandler);

    }

    public void getHomeTimeline(final getHomeTimelineArguments arg) {

        int page = arg.Page;
        boolean cache = arg.isCache;
        final ICallBack<List<Status>> callback = arg.callBack;
        if (callback == null) return;

        if (MutexManager.status("Global")) return;
        MutexManager.set("Global", MutexOperation.ACQUIRE);
        logger.log(Level.INFO, "acquire Global");

        if (cache) {
            final List<Status> statusList = Cache.get(new Pair<String, Integer>("HomeTimeline", new Integer(page)));
            if (statusList == null)
                getHomeTimelineFromTwitter(arg);
            else {
                logger.log(Level.INFO, "[CachedTwitter] - load cached data. Name: HomeTimeLine, Page: " + page);
                RunAsync(new Runnable() {
                    @Override
                    public void run() {
                        callback.gotResult(statusList);
                    }
                });
            }
        } else
            getHomeTimelineFromTwitter(arg);
    }

    private void getHomeTimelineFromTwitter(getHomeTimelineArguments arg) {
        int page = arg.Page;
        final ICallBack<List<Status>> callback = arg.callBack;
        if (callback == null) return;

        logger.log(Level.INFO, "[CachedTwitter] - send request to twitter server. Name: HomeTimeLine, Page: " + page);
        CallBacks.put("getHomeTimeline", arg);
        AsyncTwitter.getHomeTimeline(new Paging(page));
    }


    // return null if user not found
    public User getAccountUser() {
        return accountUser;
    }

    // return null if user not found
    public User getUser(String screenName) {
        User user = null;
        try {
            user = Twitter.showUser(screenName);
        } catch (TwitterException e) {
            logger.log(Level.INFO, "Error: " + e.getErrorMessage());
        }
        return user;
    }

    public void switchAccountUser() {
        try {
            accountUser = getUser(Twitter.getScreenName());

        } catch (TwitterException e) {
            logger.log(Level.INFO, "Error: " + e.getErrorMessage());
        }
    }

    private void RunAsync(Runnable task) {
        if (task == null) return;
        Display.getDefault().asyncExec(task);
    }

    TwitterAdapter twitterHandler = new TwitterAdapter() {
        @Override
        public void gotHomeTimeline(final ResponseList<Status> statuses) {
            Arguments arg = CallBacks.get("getHomeTimeline");
            if (arg != null) {
                if (arg instanceof getHomeTimelineArguments) {
                    getHomeTimelineArguments homeTimelineArg = (getHomeTimelineArguments) arg;
                    int page = homeTimelineArg.Page;
                    final ICallBack<List<Status>> callback = arg.callBack;
                    logger.log(Level.INFO, "[CachedTwitter] - cache data for 1 minute. Name: HomeTimeLine, Page: " + page);
                    Cache.put(new Pair<String, Integer>("HomeTimeline", new Integer(page)), statuses, 60);
                    RunAsync(new Runnable() {
                        @Override
                        public void run() {
                            callback.gotResult(statuses);
                        }
                    });
                }
                throw new IllegalArgumentException("worng Arguments.");
            }
        }

    };
}
