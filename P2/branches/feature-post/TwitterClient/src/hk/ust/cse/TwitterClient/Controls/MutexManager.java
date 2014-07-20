package hk.ust.cse.TwitterClient.Controls;

import java.util.*;
public final class MutexManager {

    private static Map<String, Mutex> MutexList = new TreeMap<String, Mutex>();
    private static Mutex get(String name){
        Mutex m = MutexList.get(name);
        if(m == null){
            m = new Mutex();
            MutexList.put(name,m);
        }
        return m;
    }

    public static void set(String name, MutexOperation operation ){
        Mutex m = get(name);
        switch (operation){
            case ACQUIRE:
                m.acquire();
                break;
            case RELEASE:
                m.release();
                break;
        }
    }
    public static boolean status(String name){
        return get(name).getStatus();
    }
}
