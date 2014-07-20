package martin.test.hk.ust.cse.TwitterClient.Views.Search;

import hk.ust.cse.TwitterClient.Controls.TwitterControl;
import hk.ust.cse.TwitterClient.Views.Search.SearchPage;
import martin.test.hk.ust.cse.TwitterClient.Mocks.ConcreteMockAsyncTwitter;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockTwitter;
import martin.test.hk.ust.cse.TwitterClient.Mocks.MockUser;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;
import twitter4j.AsyncTwitter;
import twitter4j.Status;
import twitter4j.Twitter;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: MARTIN
 * Date: 4/12/13
 * Time: 4:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class SearchPageTest {
    @Test(timeout = 10000)
    public void test(){

        Display display = new Display();
        Shell shell = new Shell(display);

        try{
            SearchPage  m_searchPage = new SearchPage( shell, "some test", 10, 10, 10,
               10,10,10,10, "onNameLinkClicked", "onNumberItemClicked", this);
        }catch (NullPointerException e){
            assertNotNull(e);
        }

        // ----- Mock things initialize ------
        MockUser user = new MockUser("FakeUser", "FakeScreenName", true, "Fake Description");
        user.setProfileBackgroundColor("1A1B1F");
        user.setProfileBackgroundImageURL("");

        Twitter twitter = new MockTwitter(user);
        AsyncTwitter asyncTwitter = new ConcreteMockAsyncTwitter();
        TwitterControl.setupTwitter(twitter, asyncTwitter);

        SearchPage  m_searchPage = new SearchPage( shell, "some test", 10, 10, 10,
                10,10,10,10, "onNameLinkClicked", "onNumberItemClicked", this);
        assertNotNull(m_searchPage);

        m_searchPage.getPage();
        m_searchPage.getTag();

        Event event = new Event();
        event.widget = shell;
        MouseEvent e = new MouseEvent(event);

        m_searchPage.onMenuItemClicked(e);
        m_searchPage.tweetsListBackClicked(e);
        m_searchPage.tweetsListNextClicked(e);

        m_searchPage.showTweetsList(null);

        List<Status> tweets = new ArrayList<Status>();
        tweets.add(mock(Status.class, RETURNS_DEEP_STUBS));

        m_searchPage.showTweetsList(tweets);

        m_searchPage.updateSearchTimeLine("",1);
        m_searchPage.updateSearchTimeLine("some text",0);

    }
}
