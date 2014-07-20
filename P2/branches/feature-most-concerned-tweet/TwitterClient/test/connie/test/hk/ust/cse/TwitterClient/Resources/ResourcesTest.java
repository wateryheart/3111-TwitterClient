package connie.test.hk.ust.cse.TwitterClient.Resources;

import static org.junit.Assert.*;
import hk.ust.cse.TwitterClient.Resources.Resources;

import org.junit.Test;

public class ResourcesTest {

	@Test
	public void testConstructor() {
		Resources resources = new Resources();
		assertNotNull(resources);
	}

}
