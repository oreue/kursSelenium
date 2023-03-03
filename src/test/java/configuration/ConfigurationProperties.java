package configuration;

import org.testng.internal.ConfigurationGroupMethods;

import java.util.Properties;

public class ConfigurationProperties {

    private static Properties properties;

    private ConfigurationProperties() {}

    public static void setProperties(Properties properties) {
        ConfigurationProperties.properties = properties;
    }

    public static Properties getProperties() {
        if (properties == null) {
            throw new IllegalStateException("Uzyj setProperties() przed użyciem getProperties()");
        }

        return properties;
    }

}