package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// Simple configuration loader for loading config properties
public class ConfigLoader {
    private static ConfigLoader instance;
    private Properties properties;

    private ConfigLoader() {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("Could not load config file: " + e.getMessage());
        }
    }

    public static ConfigLoader getInstance() {
        if (instance == null) {
            instance = new ConfigLoader();
        }
        return instance;
    }

    public String getProperty(String key) {
        String systemProperty = System.getProperty(key);
        if (systemProperty != null && !systemProperty.isEmpty()) {
            return systemProperty;
        }
        return properties.getProperty(key);
    }

    public String getBrowser() {
        return getProperty("browser");
    }

    public String getUrl() {
        return getProperty("url");
    }

    public String getUsername() {
        return getProperty("username");
    }

    public String getPassword() {
        return getProperty("password");
    }

    public int getTimeout() {
        String timeout = getProperty("timeout");
        return timeout != null ? Integer.parseInt(timeout) : 10;
    }

    public boolean isHeadless() {
        String headless = getProperty("headless");
        return headless != null && Boolean.parseBoolean(headless);
    }
}
