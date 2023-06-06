package api.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class Helper {

    public static final String commonFilePath = System.getProperty("user.dir") + "/common.properties";

    public static String propertyReader(String key) {
        String value = null;
        //Inputstream is required while loading into properties
        try (InputStream input = new FileInputStream(commonFilePath)) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);
            //getProperty will fetch the value according to the key
            value = prop.getProperty(key);


        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return value;

    }

    /*
     * create folder
     */
    public static void CreateFolder(String path) {
        //File is a class inside java.io package
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();//mkdir is used to create folder
        } else
            System.out.println("Folder already created");
    }

    /*
     * Return current time stamp
     */
    public static String Timestamp() {
        Date now = new Date();
        String Timestamp = now.toString().replace(":", "-");
        return Timestamp;
    }

}
