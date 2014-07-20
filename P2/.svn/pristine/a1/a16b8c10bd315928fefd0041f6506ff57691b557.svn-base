package hk.ust.cse.TwitterClient.Controls.common;

import twitter4j.Status;

import java.util.List;

/**
 *  a arguments class for passing the setting to the method , cachedTwitter.getHomeTimeline.
 */
public class getHomeTimelineArguments extends Arguments<List<Status>> {

    /**
     *
     * @param Page  request the page no.
     * @param callback
     */
    public getHomeTimelineArguments(int Page, ICallBack callback){
        this(Page, callback, false);
    }

    /**
     *
     * @param Page request the page no.
     * @param callBack
     * @param isCache
     */
    public getHomeTimelineArguments(int Page, ICallBack callBack, boolean isCache){
        this.Page = Page;
        this.callBack = callBack;
        this.isCache = isCache;
    }
    public int Page;
}

