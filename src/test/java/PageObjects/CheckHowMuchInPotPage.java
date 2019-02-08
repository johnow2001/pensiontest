package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckHowMuchInPotPage {

    WebDriver driver;
    public CheckHowMuchInPotPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.LINK_TEXT, using = "find a lost pension")
    WebElement lostPensionLink;

    public void selectLostPensionLink(){
        lostPensionLink.click();
    }
}
