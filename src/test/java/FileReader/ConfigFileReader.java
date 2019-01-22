package FileReader;

import enums.DriverType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.io.FileReader;

public class ConfigFileReader {

    private Properties properties;
    private String propFilePath = "config\\config.properties";


    public ConfigFileReader(){
        BufferedReader reader;
        try{
            reader =  new BufferedReader(new FileReader(propFilePath));
            properties = new Properties();
            properties.load(reader);
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Config file not found");
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties file not found at " + propFilePath);
        }
        catch (IOException e){
            System.out.println("IO Exception in config reader");
            e.printStackTrace();
        }
    }

    public String getDriverPath(){
        String driver = properties.getProperty("driverPath");
        if (driver != null){
            return driver;
        }
        else {
            throw new RuntimeException("getDriverPath() returned Driver path not found at " + propFilePath);
        }
    }

    public String getUrl() {
        String url = properties.getProperty("url");
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException("getUrl() returned Url not found at " + propFilePath);
        }
    }

    public DriverType getBrowserTye(){
        String browserType = properties.getProperty("browser");
        if(browserType == null) throw new RuntimeException("getBrowserTye returned browser not found at " + properties);

        if (browserType.toLowerCase().equals("chrome")) {
            return DriverType.CHROME;
        }
        else if (browserType.toLowerCase().equals("firefox")){
            return DriverType.FIREFOX;
        }
        else if (browserType.toLowerCase().equals("edge")){
            return DriverType.EDGE;
        }
        else{
            throw new RuntimeException("Browser Type not found at " + properties);
        }
    }

    public String getDriverProperty(){
        String drvProp = properties.getProperty("driverProperty");
        if (drvProp == null) throw new RuntimeException("driver proprty not found at " + properties);
        return drvProp;
    }

    public Boolean getWindowMaxSize(){
        String maxSize = properties.getProperty("windowMaxSize");
        if(maxSize == null) throw new RuntimeException("windowMaxSize not found at " + properties );

        return Boolean.valueOf(maxSize);
    }

}
