package util;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {


    private static final String ENV_PROP_FILE = "/env.properties";
    private static final String APP_PROP_FILE = "/application.properties";
    //

    private PropertyLoader() {
    }

    public static String loadEnvProperty(String name){
        return getProperties(ENV_PROP_FILE, name);
    }

    public static String loadApplicationProperty(String name){
        return getProperties(APP_PROP_FILE, name);
    }

    private static String getProperties(String filePath, String name){
        Properties props = new Properties();
        try {
            props.load(util.PropertyLoader.class.getResourceAsStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = "";

        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }


//    public static String loadEnvProperty(String name) {
//        Properties props = new Properties();
//        try {
//            props.load(util.PropertyLoader.class.getResourceAsStream(ENV_PROP_FILE));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String value = "";
//
//        if (name != null) {
//            value = props.getProperty(name);
//        }
//        return value;
//    }
}