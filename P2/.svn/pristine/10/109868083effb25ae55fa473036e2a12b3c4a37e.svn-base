package chris.test.hk.ust.cse.TwitterClient;


import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import hk.ust.cse.TwitterClient.CityLookUp;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: chrischeung
 * Date: 19/4/13
 * Time: 3:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class CityLookUpTest {
    @Test
    public void testCityLookUp() throws Exception {
        CityLookUp c = new CityLookUp();
        Assert.assertNotNull(c);

        Location l2 = c.getLookupService().getLocation("8.8.8.8");

        Assert.assertEquals("Hong Kong", c.getCountryName());
        Assert.assertEquals("United States", l2.countryName);
        Assert.assertNotNull(c.getLatitude());
        Assert.assertNotNull(c.getLongitude());
        Assert.assertNotNull(c.distance(l2));
    }
}
