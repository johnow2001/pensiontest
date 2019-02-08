package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class StartFindPensionContactPage {
    WebDriver driver;

    public StartFindPensionContactPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.LINK_TEXT, using = "Start now")
    WebElement startNow;

    public void startFindPensionContactDetails(){
        startNow.click();
    }
}
