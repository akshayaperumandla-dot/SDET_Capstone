package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        properties = new Properties();
        try {
            // First try loading as resource stream
            try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
                if (input != null) {
                    properties.load(input);
                } else {
                    // Fallback to file input stream
                    try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
                        properties.load(fis);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading config.properties: " + e.getMessage());
        }
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            synchronized (ConfigLoader.class) {
                if (configLoader == null) {
                    configLoader = new ConfigLoader();
                }
            }
        }
        return configLoader;
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
