package chris.test.hk.ust.cse.TwitterClient.Resources;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Resources.Resources;

import org.junit.Test;

public class ResourcesTest {

	@Test(timeout=10000)
	public void testconstructor() throws Throwable{
		Resources resource = new Resources();
		assertNotNull(resource);
	}
}
