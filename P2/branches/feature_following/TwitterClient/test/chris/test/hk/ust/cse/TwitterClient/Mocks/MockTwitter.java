package chris.test.hk.ust.cse.TwitterClient.Mocks;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;

public class MockTwitter implements Twitter {

	private User m_User;
	public MockTwitter(User user){
		m_User = user;
	}
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
	public ResponseList<Status> getHomeTimeline() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getHomeTimeline(Paging arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getMentions() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getMentions(Paging arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getMentionsTimeline() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getMentionsTimeline(Paging arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getRetweetsOfMe() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getRetweetsOfMe(Paging arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getUserTimeline() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getUserTimeline(String arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getUserTimeline(long arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getUserTimeline(Paging arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getUserTimeline(String arg0, Paging arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getUserTimeline(long arg0, Paging arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status destroyStatus(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OEmbed getOEmbed(OEmbedRequest arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getRetweets(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status retweetStatus(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status showStatus(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status updateStatus(String arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status updateStatus(StatusUpdate arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResult search(Query arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirectMessage destroyDirectMessage(long arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<DirectMessage> getDirectMessages()
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<DirectMessage> getDirectMessages(Paging arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<DirectMessage> getSentDirectMessages()
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<DirectMessage> getSentDirectMessages(Paging arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirectMessage sendDirectMessage(long arg0, String arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirectMessage sendDirectMessage(String arg0, String arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirectMessage showDirectMessage(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createFriendship(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createFriendship(String arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createFriendship(long arg0, boolean arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createFriendship(String arg0, boolean arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User destroyFriendship(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User destroyFriendship(String arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDs getFollowersIDs(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDs getFollowersIDs(long arg0, long arg1) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDs getFollowersIDs(String arg0, long arg1) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<User> getFollowersList(long arg0, long arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<User> getFollowersList(String arg0, long arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDs getFriendsIDs(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDs getFriendsIDs(long arg0, long arg1) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDs getFriendsIDs(String arg0, long arg1) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<User> getFriendsList(long arg0, long arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<User> getFriendsList(String arg0, long arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDs getIncomingFriendships(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDs getOutgoingFriendships(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Friendship> lookupFriendships(long[] arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Friendship> lookupFriendships(String[] arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship showFriendship(long arg0, long arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship showFriendship(String arg0, String arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship updateFriendship(long arg0, boolean arg1, boolean arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship updateFriendship(String arg0, boolean arg1, boolean arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createBlock(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createBlock(String arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User destroyBlock(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User destroyBlock(String arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountSettings getAccountSettings() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDs getBlocksIDs() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDs getBlocksIDs(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<User> getBlocksList() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<User> getBlocksList(long arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<User> getContributees(long arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<User> getContributees(String arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<User> getContributors(long arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<User> getContributors(String arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<User> lookupUsers(long[] arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<User> lookupUsers(String[] arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeProfileBanner() throws TwitterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseList<User> searchUsers(String arg0, int arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User showUser(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return m_User;
	}

	@Override
	public User showUser(String arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return m_User;
	}

	@Override
	public AccountSettings updateAccountSettings(Integer arg0, Boolean arg1,
			String arg2, String arg3, String arg4, String arg5)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateProfile(String arg0, String arg1, String arg2, String arg3)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateProfileBackgroundImage(File arg0, boolean arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateProfileBackgroundImage(InputStream arg0, boolean arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProfileBanner(File arg0) throws TwitterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfileBanner(InputStream arg0) throws TwitterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateProfileColors(String arg0, String arg1, String arg2,
			String arg3, String arg4) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateProfileImage(File arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateProfileImage(InputStream arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User verifyCredentials() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<User> getMemberSuggestions(String arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Category> getSuggestedUserCategories()
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<User> getUserSuggestions(String arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status createFavorite(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status destroyFavorite(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getFavorites() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getFavorites(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getFavorites(String arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getFavorites(Paging arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getFavorites(long arg0, Paging arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getFavorites(String arg0, Paging arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList addUserListMember(int arg0, long arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList addUserListMember(long arg0, String arg1, long arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList addUserListMembers(int arg0, long[] arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList addUserListMembers(int arg0, String[] arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList addUserListMembers(long arg0, String arg1, long[] arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList addUserListMembers(long arg0, String arg1, String[] arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList createUserList(String arg0, boolean arg1, String arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList createUserListMember(int arg0, long arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList createUserListMember(long arg0, String arg1, long arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList createUserListMember(String arg0, String arg1, long arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList createUserListMembers(int arg0, long[] arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList createUserListMembers(int arg0, String[] arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList createUserListMembers(long arg0, String arg1, long[] arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList createUserListMembers(String arg0, String arg1, long[] arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList createUserListMembers(long arg0, String arg1, String[] arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList createUserListMembers(String arg0, String arg1,
			String[] arg2) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList createUserListSubscription(int arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList createUserListSubscription(long arg0, String arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList createUserListSubscription(String arg0, String arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList deleteUserListMember(int arg0, long arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList deleteUserListMember(long arg0, String arg1, long arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList destroyUserList(int arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList destroyUserList(long arg0, String arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList destroyUserList(String arg0, String arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList destroyUserListMember(int arg0, long arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList destroyUserListMember(long arg0, String arg1, long arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList destroyUserListMember(String arg0, String arg1, long arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList destroyUserListSubscription(int arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList destroyUserListSubscription(long arg0, String arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList destroyUserListSubscription(String arg0, String arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<User> getUserListMembers(int arg0, long arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<User> getUserListMembers(long arg0, String arg1,
			long arg2) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<User> getUserListMembers(String arg0,
			String arg1, long arg2) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<UserList> getUserListMemberships(long arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<UserList> getUserListMemberships(long arg0,
			long arg1) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<UserList> getUserListMemberships(String arg0,
			long arg1) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<UserList> getUserListMemberships(String arg0,
			long arg1, boolean arg2) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<UserList> getUserListMemberships(long arg0,
			long arg1, boolean arg2) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getUserListStatuses(int arg0, Paging arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getUserListStatuses(long arg0, String arg1,
			Paging arg2) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Status> getUserListStatuses(String arg0, String arg1,
			Paging arg2) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<User> getUserListSubscribers(int arg0, long arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<User> getUserListSubscribers(long arg0,
			String arg1, long arg2) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<User> getUserListSubscribers(String arg0,
			String arg1, long arg2) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagableResponseList<UserList> getUserListSubscriptions(String arg0,
			long arg1) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<UserList> getUserLists(String arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<UserList> getUserLists(long arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList showUserList(int arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList showUserList(long arg0, String arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList showUserList(String arg0, String arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User showUserListMembership(int arg0, long arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User showUserListMembership(long arg0, String arg1, long arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User showUserListMembership(String arg0, String arg1, long arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User showUserListSubscription(int arg0, long arg1)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User showUserListSubscription(long arg0, String arg1, long arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User showUserListSubscription(String arg0, String arg1, long arg2)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList updateUserList(int arg0, String arg1, boolean arg2,
			String arg3) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList updateUserList(long arg0, String arg1, String arg2,
			boolean arg3, String arg4) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserList updateUserList(String arg0, String arg1, String arg2,
			boolean arg3, String arg4) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SavedSearch createSavedSearch(String arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SavedSearch destroySavedSearch(int arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<SavedSearch> getSavedSearches() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SavedSearch showSavedSearch(int arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Place createPlace(String arg0, String arg1, String arg2,
			GeoLocation arg3, String arg4) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Place getGeoDetails(String arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimilarPlaces getSimilarPlaces(GeoLocation arg0, String arg1,
			String arg2, String arg3) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Place> reverseGeoCode(GeoQuery arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Place> searchPlaces(GeoQuery arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Location> getAvailableTrends() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Location> getAvailableTrends(GeoLocation arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Location> getClosestTrends(GeoLocation arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trends getLocationTrends(int arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trends getPlaceTrends(int arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User reportSpam(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User reportSpam(String arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TwitterAPIConfiguration getAPIConfiguration()
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseList<Language> getLanguages() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrivacyPolicy() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, RateLimitStatus> getRateLimitStatus()
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, RateLimitStatus> getRateLimitStatus(String... arg0)
			throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTermsOfService() throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RelatedResults getRelatedResults(long arg0) throws TwitterException {
		// TODO Auto-generated method stub
		return null;
	}

}
