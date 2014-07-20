package connie.test.hk.ust.cse.TwitterClient.Mocks;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import twitter4j.RateLimitStatus;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.json.DataObjectFactory;

@SuppressWarnings("serial")
public class MockUser implements User {
public static int currentselected;
//TODO:switch case for mock users
  public MockUser(String name, String screenName, boolean verified, String description) {
    m_name        = name;
    m_screenName  = screenName;
    m_verified    = verified;
    m_description = description;
  }
  
  @Override
  public int compareTo(User arg0) {
    // TODO Auto-generated method stub
    return 1;
  }

  @Override
  public int getAccessLevel() {
    // TODO Auto-generated method stub
    return 1;
  }

  @Override
  public RateLimitStatus getRateLimitStatus() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getBiggerProfileImageURL() {
    // TODO Auto-generated method stub
    return "http://si0.twimg.com/sticky/default_profile_images/default_profile_3_bigger.png";
  }

  @Override
  public String getBiggerProfileImageURLHttps() {
    // TODO Auto-generated method stub
    return "https://si0.twimg.com/sticky/default_profile_images/default_profile_3_bigger.png";
  }

  @Override
  public Date getCreatedAt() {
    // TODO Auto-generated method stub
	String dateString = "2013-02-28 20:25:58";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = null;
	try {
		date = sdf.parse(dateString);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return date;
  }

  @Override
  public String getDescription() {
    return m_description;
  }

  @Override
  public URLEntity[] getDescriptionURLEntities() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getFavouritesCount() {
    // TODO Auto-generated method stub
    return 100;
  }

  @Override
  public int getFollowersCount() {
    // TODO Auto-generated method stub
    return 100;
  }

  @Override
  public int getFriendsCount() {
    // TODO Auto-generated method stub
    return 100;
  }

  @Override
  public long getId() {
    // TODO Auto-generated method stub
    return 1202901578;
  }

  @Override
  public String getLang() {
    // TODO Auto-generated method stub
    return "English";
  }

  @Override
  public int getListedCount() {
    // TODO Auto-generated method stub
    return 100;
  }

  @Override
  public String getLocation() {
    // TODO Auto-generated method stub
    return "HongKong";
  }

  @Override
  public String getMiniProfileImageURL() {
    // TODO Auto-generated method stub
    return "twimg0-a.akamaihd.net/profile_images/188302352/nasalogo_twitter_normal.jpg";
  }

  @Override
  public String getMiniProfileImageURLHttps() {
    // TODO Auto-generated method stub
    return "https://" + getMiniProfileImageURL();
  }

  @Override
  public String getName() {
    return m_name;
  }

  @Override
  public String getOriginalProfileImageURL() {
    // TODO Auto-generated method stub
    return "http://twimg0-a.akamaihd.net/profile_images/188302352/nasalogo_twitter_normal.jpg";
  }

  @Override
  public String getOriginalProfileImageURLHttps() {
    // TODO Auto-generated method stub
    return "https://twimg0-a.akamaihd.net/profile_images/188302352/nasalogo_twitter_normal.jpg";
  }

  @Override
  public String getProfileBackgroundColor() {
    // TODO Auto-generated method stub
    return "123456";
  }

  @Override
  public String getProfileBackgroundImageURL() {
    // TODO Auto-generated method stub
    return "https://a3.twimg.com/profile_background_images/179009017/t4j-reverse.gif";
  }

  @Override
  public String getProfileBackgroundImageUrl() {
    // TODO Auto-generated method stub
    return "https://a3.twimg.com/profile_background_images/179009017/t4j-reverse.gif";
  }

  @Override
  public String getProfileBackgroundImageUrlHttps() {
    // TODO Auto-generated method stub
    return "https://a3.twimg.com/profile_background_images/179009017/t4j-reverse.gif";
  }

  @Override
  public String getProfileBannerIPadRetinaURL() {
    // TODO Auto-generated method stub
    return "https://abs.twimg.com/a/1362015167/t1/img/twitter_web_sprite_bgs.png";
  }

  @Override
  public String getProfileBannerIPadURL() {
    // TODO Auto-generated method stub
    return "https://abs.twimg.com/a/1362015167/t1/img/twitter_web_sprite_bgs.png";
  }

  @Override
  public String getProfileBannerMobileRetinaURL() {
    // TODO Auto-generated method stub
    return "https://abs.twimg.com/a/1362015167/t1/img/twitter_web_sprite_bgs.png";
  }

  @Override
  public String getProfileBannerMobileURL() {
    // TODO Auto-generated method stub
    return "https://www.freegreatpicture.com/files/146/26189-abstract-color-background.jpg";
  }

  @Override
  public String getProfileBannerRetinaURL() {
    // TODO Auto-generated method stub
    return "https://www.freegreatpicture.com/files/146/26189-abstract-color-background.jpg";
  }

  @Override
  public String getProfileBannerURL() {
    // TODO Auto-generated method stub
    return "https://abs.twimg.com/a/1362015167/t1/img/twitter_web_sprite_bgs.png";
  }

  @Override
  public String getProfileImageURL() {
    // TODO Auto-generated method stub
    return "a3.twimg.com/profile_images/1184543043/t4j-reverse_normal.jpeg";
  }

  @Override
  public String getProfileImageURLHttps() {
    // TODO Auto-generated method stub
    return "https://" + getProfileImageURL();
  }

  @Override
  public URL getProfileImageUrlHttps() {
    // TODO Auto-generated method stub
	  URL url = null;	  
	try {
		url = new URL(getProfileImageURLHttps());
	} catch (MalformedURLException e) {
		System.out.println("Invalid URL ");
		e.printStackTrace();
	}
    return url;
  }

  @Override
  public String getProfileLinkColor() {
    // TODO Auto-generated method stub
    return "ABCDEF";
  }

  @Override
  public String getProfileSidebarBorderColor() {
    // TODO Auto-generated method stub
    return "ABCDEF";
  }

  @Override
  public String getProfileSidebarFillColor() {
    // TODO Auto-generated method stub
    return "ABCDEF";
  }

  @Override
  public String getProfileTextColor() {
    // TODO Auto-generated method stub
    return "FFFFAA";
  }

  @Override
  public String getScreenName() {
    return m_screenName;
  }

  @Override
  public Status getStatus() {
    // TODO Auto-generated method stub
	  Status status = null;
	  try {
		status = DataObjectFactory.createStatus("{\"text\":\"\\\\u5e30%u5e30 &lt;%}& foobar &lt;&Cynthia&gt;\",\"contributors\":null,\"geo\":null,\"retweeted\":false,\"in_reply_to_screen_name\":null,\"truncated\":false,\"entities\":{\"urls\":[],\"hashtags\":[],\"user_mentions\":[]},\"in_reply_to_status_id_str\":null,\"id\":12029015787307008,\"in_reply_to_user_id_str\":null,\"source\":\"web\",\"favorited\":false,\"in_reply_to_status_id\":null,\"in_reply_to_user_id\":null,\"created_at\":\"Tue Dec 07 06:21:55 +0000 2010\",\"retweet_count\":0,\"id_str\":\"12029015787307008\",\"place\":null,\"user\":{\"location\":\"location:\",\"statuses_count\":13405,\"profile_background_tile\":false,\"lang\":\"en\",\"profile_link_color\":\"0000ff\",\"id\":6358482,\"following\":true,\"favourites_count\":2,\"protected\":false,\"profile_text_color\":\"000000\",\"contributors_enabled\":false,\"description\":\"Hi there, I do test a lot!new\",\"verified\":false,\"profile_sidebar_border_color\":\"87bc44\",\"name\":\"twit4j\",\"profile_background_color\":\"9ae4e8\",\"created_at\":\"Sun May 27 09:52:09 +0000 2007\",\"followers_count\":24,\"geo_enabled\":true,\"profile_background_image_url\":\"http://a3.twimg.com/profile_background_images/179009017/t4j-reverse.gif\",\"follow_request_sent\":false,\"url\":\"http://yusuke.homeip.net/twitter4j/\",\"utc_offset\":-32400,\"time_zone\":\"Alaska\",\"notifications\":false,\"friends_count\":4,\"profile_use_background_image\":true,\"profile_sidebar_fill_color\":\"e0ff92\",\"screen_name\":\"twit4j\",\"id_str\":\"6358482\",\"profile_image_url\":\"http://a3.twimg.com/profile_images/1184543043/t4j-reverse_normal.jpeg\",\"show_all_inline_media\":false,\"listed_count\":3},\"coordinates\":null}");
	} catch (TwitterException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 	
    return status;
  }

  @Override
  public int getStatusesCount() {
    // TODO Auto-generated method stub
	  int statusesCount = 0;
	  if(statusesCount > 40)
	  	{statusesCount = 0;}
	  else 
	  { statusesCount += 21;}
    return statusesCount;
  }

  @Override
  public String getTimeZone() {
    // TODO Auto-generated method stub
    return "Alaska";
  }

  @Override
  public String getURL() {
    // TODO Auto-generated method stub
    return "twitter.com/NASA";
  }

  @Override
  public URLEntity getURLEntity() {
    // TODO Auto-generated method stub
	  MockURLEntity urle = new MockURLEntity();
    return urle;
  }

  @Override
  public int getUtcOffset() {
    // TODO Auto-generated method stub
    return 1;
  }

  @Override
  public boolean isContributorsEnabled() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isFollowRequestSent() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isGeoEnabled() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isProfileBackgroundTiled() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isProfileUseBackgroundImage() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isProtected() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isShowAllInlineMedia() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isTranslator() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isVerified() {
    return m_verified;
  }

  private final String  m_name;
  private final String  m_screenName;
  private final String  m_description;
  private final boolean m_verified;

}
