package jakarta.project.utils;

import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();
    static {
        loadProperties();
    }

    public static void loadProperties() {
        try(InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(in);
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }
}
