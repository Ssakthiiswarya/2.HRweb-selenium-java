package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    static {

        try {

            FileInputStream file =
                    new FileInputStream(
                            "src/test/resources/config.properties"
                    );

            properties = new Properties();

            properties.load(file);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String getBrowser() {

        return properties.getProperty("browser");
    }

    public static String getBaseUrl() {

        return properties.getProperty("baseUrl");
    }

    public static String getUsername() {

        return properties.getProperty("username");
    }

    public static String getPassword() {

        return properties.getProperty("password");
    }

    public static int getTimeout() {

        return Integer.parseInt(
                properties.getProperty("timeout")
        );
    }
}