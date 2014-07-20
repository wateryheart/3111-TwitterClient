package hk.ust.cse.TwitterClient.Controls;

/**
 * Created with IntelliJ IDEA.
 * User: MARTIN
 * Date: 4/5/13
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public final class Mutex {

    private static boolean _homePageMutex;
    private static Object homePageLock = new Object();
    public static boolean getHomePageMutex(){
        synchronized (homePageLock){
            return _homePageMutex;
        }
    }

    public static void releaseHomePageMutex(){
        synchronized (homePageLock){
            _homePageMutex = false;
        }
    }
    public static void acquireHomePageMutex(){
        synchronized (homePageLock){
            _homePageMutex = true;
        }
    }

    private static boolean _userPageMutex;
    private static Object userPageLock = new Object();
    public static boolean getUserPageMutex(){
        synchronized (userPageLock){
            return _userPageMutex;
        }
    }

    public static void releaseUserPageMutex(){
        synchronized (userPageLock){
            _userPageMutex = false;
        }
    }
    public static void acquireUserPageMutex(){
        synchronized (userPageLock){
            _userPageMutex = true;
        }
    }

    private static boolean _searchPageMutex;
    private static Object searchPageLock = new Object();
    public static boolean getSearchPageMutex(){
        synchronized (searchPageLock){
            return _searchPageMutex;
        }
    }

    public static void releaseSearchPageMutex(){
        synchronized (searchPageLock){
            _searchPageMutex = false;
        }
    }
    public static void acquireSearchPageMutex(){
        synchronized (searchPageLock){
            _searchPageMutex = true;
        }
    }

}
