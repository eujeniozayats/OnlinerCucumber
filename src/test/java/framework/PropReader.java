package framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropReader {

    private final Properties properties = new Properties();

    public PropReader(final String resourceName) {
        appendFromResource(properties, resourceName);
    }

    private void appendFromResource(final Properties objProperties, final String resourceName) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resourceName);
        if (is != null) {
            try {
                objProperties.load(is);
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.printf("Resource \"%1$s\" could not be found%n", resourceName);
        }
    }

    public String getProperty(final String key) {
        return properties.getProperty(key);
    }
}
