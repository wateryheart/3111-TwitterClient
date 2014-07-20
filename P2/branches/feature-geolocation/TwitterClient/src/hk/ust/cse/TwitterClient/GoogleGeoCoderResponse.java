package hk.ust.cse.TwitterClient;

/**
 * Created with IntelliJ IDEA.
 * User: chrischeung
 * Date: 25/4/13
 * Time: 8:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class GoogleGeoCoderResponse {
    public String status ;
    public results[] results ;
    public GoogleGeoCoderResponse() {

    }
}

class results{
    public String formatted_address ;
    public geometry geometry ;
    public String[] types;
    public address_component[] address_components;
}

class geometry{
    public bounds bounds;
    public String location_type ;
    public location location;
    public bounds viewport;
}

class bounds {

    public location northeast ;
    public location southwest ;
}

class location{
    public String lat ;
    public String lng ;
}

class address_component{
    public String long_name;
    public String short_name;
    public String[] types ;
}
