package hk.ust.cse.TwitterClient.Controls;

/**
 * Created with IntelliJ IDEA.
 * User: MARTIN
 * Date: 4/5/13
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Mutex {
    private boolean mutex;
    private Object mutexLock = new Object();
    public boolean getStatus(){
        synchronized (mutexLock){
            return mutex;
        }
    }

    public void release(){
        synchronized (mutexLock){
            mutex = false;
        }
    }
    public void acquire(){
        synchronized (mutexLock){
            mutex = true;
        }
    }
}
