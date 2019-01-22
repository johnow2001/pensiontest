package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpUtility {

    WebDriver driver;

    public HelpUtility(WebDriver driver){
        this.driver = driver;
    }

    public String getPageTitle(String page){
        WebDriverWait wait  = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs(page));
        return driver.getTitle();
    }
}
