package hk.ust.cse.TwitterClient.Controls;

import hk.ust.cse.TwitterClient.Views.Search.SearchPage;
import org.eclipse.swt.widgets.Display;
import twitter4j.QueryResult;
import twitter4j.Status;

import java.util.List;

public class SearchPageControl {

    public SearchPageControl(SearchPage view){

        m_view = view;
    }

    public void getSearchListCallBack(final Object retValue){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                QueryResult result = (QueryResult) retValue;
                List<Status> tweets = result.getTweets();
                m_view.showTweetsList(tweets);
            }
        };
        Display.getDefault().asyncExec(runnable);
    }

    private SearchPage m_view;
}

