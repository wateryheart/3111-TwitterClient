package martin.test.hk.ust.cse.TwitterClient.Mocks;

import twitter4j.URLEntity;

public class MockURLEntity implements URLEntity{

	private String m_DisplayURL;
	private String m_ExpandedURL;
	private String m_URL;
	
	public MockURLEntity(){
		
	}
	
	@Override
	public String getDisplayURL() {
		// TODO Auto-generated method stub
		return m_DisplayURL;
	}
	
	public void setDisplayURL(String displayURL){
		m_DisplayURL = displayURL;
	}

	@Override
	public int getEnd() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getExpandedURL() {
		// TODO Auto-generated method stub
		return m_ExpandedURL;
	}

	public void setExpandedURL(String expandedURL){
		m_ExpandedURL = expandedURL;
	}

	@Override
	public int getStart() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return m_URL;
	}
	public void setURL(String url){
		m_URL = url;
	}

}
