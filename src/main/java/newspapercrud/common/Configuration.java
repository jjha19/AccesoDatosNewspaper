package newspapercrud.common;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Configuration {
    private Properties properties;
    private Configuration() {
       Path path1 = Paths.get("src/main/resources/properties/mysql_properties.xml");
       properties = new Properties();
       InputStream propertiesStream;
         try {
             propertiesStream = Files.newInputStream(path1);
              properties.loadFromXML(propertiesStream);
         } catch (IOException e) {
              e.printStackTrace();
         }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
