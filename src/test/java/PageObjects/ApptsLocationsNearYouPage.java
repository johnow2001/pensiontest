package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ApptsLocationsNearYouPage {
    WebDriver driver;

    public ApptsLocationsNearYouPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(how=How.TAG_NAME, using = "h2"))
    List<WebElement> locations;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/ol/li[1]/div[1]/div[1]/p[2]/a")
    WebElement bookOnlineButton;

    public Boolean checkLocation(String expectedLocation){
        for(WebElement loc : locations){
            if (loc.getText().equals(expectedLocation)){
                return true;
            }
        }
        return false;
    }

    public void bookOnline(){
        bookOnlineButton.click();
    }
}


