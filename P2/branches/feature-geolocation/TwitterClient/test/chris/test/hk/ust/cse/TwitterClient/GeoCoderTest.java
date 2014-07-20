package chris.test.hk.ust.cse.TwitterClient;

import hk.ust.cse.TwitterClient.CityLookUp;
import hk.ust.cse.TwitterClient.GeoCoder;
import junit.framework.Assert;
import org.junit.Test;
import twitter4j.GeoLocation;


/**
 * Created with IntelliJ IDEA.
 * User: chrischeung
 * Date: 22/4/13
 * Time: 1:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class GeoCoderTest{
    @Test
    public void testGeoCoder() throws Exception {
        final double TEST_LAT = 39.93070622;
        final double TEST_LNT = 116.59680994;
        GeoCoder g = new GeoCoder(TEST_LAT, TEST_LNT);
        Assert.assertEquals("Changying North Road", g.getLongName("route"));
        Assert.assertEquals(g.getLongName("route"), g.getShortName("route"));

        Assert.assertEquals("Chaoyang", g.getLongName("sublocality"));
        Assert.assertEquals(g.getLongName("sublocality"), g.getShortName("sublocality"));

        Assert.assertEquals("Beijing", g.getLongName("administrative_area_level_1"));

        Assert.assertEquals("China", g.getLongName("country"));
        Assert.assertEquals("CN", g.getShortName("country"));

        Assert.assertEquals("Changying North Road, Chaoyang, Beijing, China, 100024", g.getFormattedAddress());

        Assert.assertEquals("ZERO_RESULT", g.getShortName("this is a test string"));
    }
}
