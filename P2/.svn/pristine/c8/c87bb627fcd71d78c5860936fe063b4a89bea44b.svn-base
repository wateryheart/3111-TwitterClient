package hk.ust.cse.TwitterClient;

import com.google.common.base.Preconditions;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.JsonGenerationException;
import sun.misc.BASE64Decoder;
import twitter4j.GeoLocation;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created with IntelliJ IDEA.
 * User: chrischeung
 * Date: 21/4/13
 * Time: 1:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class GeoCoder {

    public GeoCoder (GeoLocation gl) {
        if(gl != null)
            m_gl = gl;
        else
            m_gl = new GeoLocation(0, 0);
        m_location = "en";
        onCreate();
    }

    public GeoCoder (GeoLocation gl, String location) {
        if(gl != null)
            m_gl = gl;
        else
            m_gl = new GeoLocation(0, 0);
        m_location = location;
        onCreate();
    }

    public GeoCoder (double lat, double lng) {
        m_gl = new GeoLocation(lat, lng);
        m_location = "en";
        onCreate();
    }

    public GeoCoder (double lat, double lng, String location) {
        m_gl = new GeoLocation(lat, lng);
        m_location = location;
        onCreate();
    }

    private void onCreate() {
        String address = "&latlng=" + m_gl.getLatitude() + "," + m_gl.getLongitude();
        BASE64Decoder decoder = new BASE64Decoder();
        String output = "";
        try {
            byte[] decodedBytes = decoder.decodeBuffer(GOOGLE_MAP_API_V3_KEY);
            String decodedKey = "&" + decodedBytes.toString();
            URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?" + decodedKey + address + "&sensor=false" + "&language=" + m_location);
            output = new Scanner(url.openStream()).useDelimiter("\\A").next();
        } catch (java.util.NoSuchElementException e) {
            //empty result
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        createAddressComponents(output);
    }

    private void createAddressComponents(String s){
        ObjectMapper mapper = new ObjectMapper();

        try {
            m_geocode_result = mapper.readValue(s, GoogleGeoCoderResponse.class);
            logger.log(Level.INFO, m_geocode_result.toString());

        } catch (JsonGenerationException e) {
            e.printStackTrace();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public String getFormattedAddress() {
        return m_geocode_result.results[1].formatted_address;
        //return "ZERO_RESULT";
    }

    public String getLongName(String type) {
        String m_type = type;
        if(type != null) {
            for(int i = 0; i < m_geocode_result.results[1].address_components.length; i++) {
                String s = String.valueOf(m_geocode_result.results[1].address_components[i].types[0]);
                System.out.print(s);
                if(type.compareTo(String.valueOf(m_geocode_result.results[1].address_components[i].types[0])) == 0)
                    return m_geocode_result.results[1].address_components[i].long_name;
            }
        }

        return "ZERO_RESULT";
    }

    public String getShortName(String type) {
        String m_type = type;
        if(type != null) {
            for(int i = 0; i < m_geocode_result.results[1].address_components.length; i++) {
                if(type.compareTo((m_geocode_result.results[1].address_components[i].types[0])) == 0)
                    return m_geocode_result.results[1].address_components[i].short_name;
            }
        }

        return "ZERO_RESULT";
    }

    private GeoLocation m_gl;
    private String m_location;
    private GoogleGeoCoderResponse m_geocode_result;

    public enum Type {

        // @checkstyle:off JavadocVariable

        ADMINISTRATIVE_AREA_LEVEL_1("administrative_area_level_1"),
        ADMINISTRATIVE_AREA_LEVEL_2("administrative_area_level_2"),
        ADMINISTRATIVE_AREA_LEVEL_3("administrative_area_level_3"),
        AIRPORT("airport"),
        BUS_STATION("bus_station"),
        CAMPGROUND("campground"),
        COLLOQUIAL_AREA("colloquial_area"),
        COUNTRY("country"),
        ESTABLISHMENT("establishment"),
        FLOOR("floor"),
        HEALTH("health"),
        HOSPITAL("hospital"),
        INTERSECTION("intersection"),
        LIBRARY("library"),
        LOCALITY("locality"),
        LODGING("lodging"),
        NATURAL_FEATURE("natural_feature"),
        NEIGHBORHOOD("neighborhood"),
        PARK("park"),
        PLACE_OF_WORSHIP("place_of_worship"),
        POINT_OF_INTEREST("point_of_interest"),
        POLICE("police"),
        POLITICAL("political"),
        POST_BOX("post_box"),
        POSTAL_CODE("postal_code"),
        POSTAL_CODE_PREFIX("postal_code_prefix"),
        PREMISE("premise"),
        ROOM("room"),
        ROUTE("route"),
        STREET_ADDRESS("street_address"),
        STREET_NUMBER("street_number"),
        SUBLOCALITY("sublocality"),
        SUBPREMISE("subpremise"),
        SUBWAY_STATION("subway_station"),
        TRAIN_STATION("train_station"),
        TRANSIT_STATION("transit_station"),
        UNIVERSITY("university");

        // @checkstyle:on JavadocVariable

        private final String value;

        private Type(String value) {
            this.value = value;
        }

        /**
         * Returns this type's value.
         *
         * @return this type's value
         */
        public String value() {
            return value;
        }

        /**
         * Returns the type corresponding to {@code value}.
         *
         * @param value the value used to look-up a corresponding type
         * @return the type corresponding to {@code value}
         * @throws NullPointerException if {@code value} is null
         * @throws IllegalArgumentException if no type corresponding to {@code value}
         * was found
         */
        public static Type get(String value) {
            Preconditions.checkNotNull(value, "null value");
            for (Type type : values())
                if (type.value.equals(value))
                    return type;
            throw new IllegalArgumentException(String.format("no type"
                    + "corresponding to '%s' was found", value));
        }
    }


    private static final Logger logger = Logger.getLogger("geocoder");
    private static final String GOOGLE_GEOCODING = "http://maps.googleapis.com/maps/api/geocode/json?";
    private static final String GOOGLE_MAP_API_V3_KEY = "AIzaSyAQ_l4ab2qkW-jVtZjgd0HrsDB8fkHsWP0";

}
