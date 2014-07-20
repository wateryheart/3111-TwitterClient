package connie.test.hk.ust.cse.TwitterClient.Mocks;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;

import twitter4j.AsyncTwitter;
import twitter4j.GeoLocation;
import twitter4j.GeoQuery;
import twitter4j.OEmbedRequest;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.RateLimitStatusListener;
import twitter4j.StatusUpdate;
import twitter4j.TwitterException;
import twitter4j.TwitterListener;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;


@SuppressWarnings("serial")
public class MockAsyncTwitter implements AsyncTwitter {
	@Override
	public AccessToken getOAuthAccessToken() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccessToken getOAuthAccessToken(String arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccessToken getOAuthAccessToken(RequestToken arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccessToken getOAuthAccessToken(RequestToken arg0, String arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccessToken getOAuthAccessToken(String arg0, String arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestToken getOAuthRequestToken() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestToken getOAuthRequestToken(String arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestToken getOAuthRequestToken(String arg0, String arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOAuthAccessToken(AccessToken arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOAuthConsumer(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOAuthAccessTokenAsync() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOAuthAccessTokenAsync(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOAuthAccessTokenAsync(RequestToken arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOAuthAccessTokenAsync(RequestToken arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOAuthAccessTokenAsync(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOAuthRequestTokenAsync() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOAuthRequestTokenAsync(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOAuthRequestTokenAsync(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRateLimitStatusListener(RateLimitStatusListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Authorization getAuthorization() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration getConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getId() throws TwitterException, IllegalStateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getScreenName() throws TwitterException,
			IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getHomeTimeline() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getHomeTimeline(Paging arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getMentions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getMentions(Paging arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getRetweetsOfMe() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getRetweetsOfMe(Paging arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserTimeline() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserTimeline(Paging arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserTimeline(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserTimeline(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserTimeline(String arg0, Paging arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserTimeline(long arg0, Paging arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyStatus(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOEmbed(OEmbedRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getRetweets(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retweetStatus(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showStatus(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStatus(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStatus(StatusUpdate arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search(Query arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyDirectMessage(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDirectMessages() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDirectMessages(Paging arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSentDirectMessages() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSentDirectMessages(Paging arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendDirectMessage(long arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendDirectMessage(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showDirectMessage(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createFriendship(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createFriendship(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createFriendship(long arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createFriendship(String arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyFriendship(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyFriendship(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFollowersIDs(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFollowersIDs(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFollowersIDs(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFollowersList(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFollowersList(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFriendsIDs(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFriendsIDs(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFriendsIDs(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFriendsList(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFriendsList(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getIncomingFriendships(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOutgoingFriendships(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lookupFriendships(long[] arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lookupFriendships(String[] arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showFriendship(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showFriendship(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFriendship(long arg0, boolean arg1, boolean arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFriendship(String arg0, boolean arg1, boolean arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createBlock(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createBlock(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyBlock(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyBlock(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAccountSettings() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getBlocksIDs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getBlocksIDs(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getBlocksList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getBlocksList(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getContributees(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getContributees(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getContributors(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getContributors(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lookupUsers(long[] arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lookupUsers(String[] arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProfileBanner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchUsers(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showUser(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showUser(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAccountSettings(Integer arg0, Boolean arg1, String arg2,
			String arg3, String arg4, String arg5) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfile(String arg0, String arg1, String arg2, String arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfileBackgroundImage(File arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfileBackgroundImage(InputStream arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfileBanner(File arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfileBanner(InputStream arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfileColors(String arg0, String arg1, String arg2,
			String arg3, String arg4) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfileImage(File arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfileImage(InputStream arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifyCredentials() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getMemberSuggestions(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSuggestedUserCategories() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserSuggestions(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createFavorite(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyFavorite(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFavorites() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFavorites(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFavorites(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFavorites(Paging arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFavorites(long arg0, Paging arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFavorites(String arg0, Paging arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUserListMember(int arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUserListMember(long arg0, String arg1, long arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUserListMembers(int arg0, long[] arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUserListMembers(int arg0, String[] arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUserListMembers(long arg0, String arg1, long[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUserListMembers(long arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUserList(String arg0, boolean arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUserListMember(int arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUserListMember(long arg0, String arg1, long arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUserListMembers(int arg0, long[] arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUserListMembers(int arg0, String[] arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUserListMembers(long arg0, String arg1, long[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUserListMembers(long arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUserListSubscription(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUserListSubscription(long arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserListMember(int arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserListMember(long arg0, String arg1, long arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyUserList(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyUserList(long arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyUserListMember(int arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyUserListMember(long arg0, String arg1, long arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyUserListSubscription(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyUserListSubscription(long arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserListMembers(int arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserListMembers(long arg0, String arg1, long arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserListMemberships(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserListMemberships(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserListMemberships(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserListMemberships(long arg0, long arg1, boolean arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserListMemberships(String arg0, long arg1, boolean arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserListStatuses(int arg0, Paging arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserListStatuses(long arg0, String arg1, Paging arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserListSubscribers(int arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserListSubscribers(long arg0, String arg1, long arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserListSubscriptions(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserLists(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserLists(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showUserList(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showUserList(long arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showUserListMembership(int arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showUserListMembership(long arg0, String arg1, long arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showUserListSubscription(int arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showUserListSubscription(long arg0, String arg1, long arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserList(int arg0, String arg1, boolean arg2, String arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserList(long arg0, String arg1, String arg2,
			boolean arg3, String arg4) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createSavedSearch(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroySavedSearch(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSavedSearches() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showSavedSearch(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createPlace(String arg0, String arg1, String arg2,
			GeoLocation arg3, String arg4) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getGeoDetails(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSimilarPlaces(GeoLocation arg0, String arg1, String arg2,
			String arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reverseGeoCode(GeoQuery arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchPlaces(GeoQuery arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAvailableTrends() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAvailableTrends(GeoLocation arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getClosestTrends(GeoLocation arg0) throws TwitterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getLocationTrends(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPlaceTrends(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportSpam(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportSpam(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAPIConfiguration() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getLanguages() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPrivacyPolicy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getRateLimitStatus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getRateLimitStatus(String... arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTermsOfService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getRelatedResults(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener(TwitterListener arg0) {
		// TODO Auto-generated method stub
		arg0.gotHomeTimeline(null);
		arg0.gotUserTimeline(null);
		arg0.gotFollowersList(null);
		arg0.gotFriendsList(null);
		arg0.gotRelatedResults(null);
		//arg0.onException(new TwitterException("a"), null);
		try
		{
			Method method = arg0.getClass().getDeclaredMethod("invokeCallback", String.class,Object.class);
			method.setAccessible(true);
			method.invoke(arg0, "", null);
		}
		catch(Exception e){}
	}

}

