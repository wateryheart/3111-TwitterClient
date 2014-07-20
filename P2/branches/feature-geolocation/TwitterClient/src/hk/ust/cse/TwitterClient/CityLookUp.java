package hk.ust.cse.TwitterClient;
import com.maxmind.geoip.*;
import hk.ust.cse.TwitterClient.Resources.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: chrischeung
 * Date: 19/4/13
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CityLookUp {
    public CityLookUp () {
    try{
        m_cl = new LookupService(path,
                LookupService.GEOIP_MEMORY_CACHE );
        m_l = m_cl.getLocation(this.getExternalIP());
    }
    catch(IOException e){
        e.printStackTrace();
    }
    }

    public CityLookUp (String ip) {
    try{
            m_cl = new LookupService(path,
                    LookupService.GEOIP_MEMORY_CACHE );
            m_l = m_cl.getLocation(ip);
    }
    catch(IOException e){
            e.printStackTrace();
    }
    }
    private static String getExternalIP() {
    try{
        URL ip = new URL("http://api.externalip.net/ip/");
        BufferedReader in = new BufferedReader(new InputStreamReader(ip.openStream()));
        return in.readLine(); //ip
    }
    catch(IOException e){
        return null;
    }
    }

    public double getLatitude() {
        return m_l.latitude;
    }

    public double getLongitude() {
        return m_l.longitude;
    }

    public String getCityName() {
        return m_l.city;
    }

    public String getCountryName() {
        return m_l.countryName;
    }

    public String toString() {
        return "countryCode: " + m_l.countryCode +
                "\n countryName: " + m_l.countryName +
                "\n region: " + m_l.region +
                "\n regionName: " + regionName.regionNameByCode(m_l.countryCode, m_l.region) +
                "\n city: " + m_l.city +
                "\n postalCode: " + m_l.postalCode +
                "\n latitude: " + m_l.latitude +
                "\n longitude: " + m_l.longitude +
                "\n metro code: " + m_l.metro_code +
                "\n area code: " + m_l.area_code +
                "\n timezone: " + timeZone.timeZoneByCountryAndRegion(m_l.countryCode, m_l.region);
    }

    public double distance(Location l2) {
        return m_l.distance(l2);
    }

    public LookupService getLookupService(){
        return m_cl;
    }

    private LookupService m_cl;
    private Location m_l;
    private final String path = Resources.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"hk/ust/cse/TwitterClient/Resources/GeoLiteCity.dat";
}
