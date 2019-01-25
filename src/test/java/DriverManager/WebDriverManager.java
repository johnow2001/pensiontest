package DriverManager;

import FileReaderManager.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import enums.DriverType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    private WebDriver driver;
    private static DriverType driverType;
    private static String driverProperty;
    private static String driverPath;


    public WebDriverManager(){
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowserTye();
        driverProperty = FileReaderManager.getInstance().getConfigReader().getDriverProperty();
        driverPath = FileReaderManager.getInstance().getConfigReader().getDriverPath();
        System.setProperty(driverProperty, driverPath);
    }

    public WebDriver getWebDriver(){
        if (driver == null)
            driver = createNewWebDriver();
        return  driver;
    }

    private WebDriver createNewWebDriver(){
        switch (driverType){
            case CHROME:
                driver = new ChromeDriver();
                break;

            case EDGE:
                driver = new EdgeDriver();
                break;

            case FIREFOX:
                driver = new FirefoxDriver();
        }

        Boolean maxSize = FileReaderManager.getInstance().getConfigReader().getWindowMaxSize();
        if (maxSize) {
            driver.manage().window().maximize();
        }
        return driver;

    }

    public void closeWebDriver(){
        driver.quit();
    }
}
