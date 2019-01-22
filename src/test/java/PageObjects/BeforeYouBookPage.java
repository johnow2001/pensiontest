package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BeforeYouBookPage {

    private WebDriver driver;

    public BeforeYouBookPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,  this);
    }

    @FindBy(how = How.ID, using = "face-to-face-button")
    WebElement bookFaceToFace;

    public void bookFaceToFaceAppt(){
        bookFaceToFace.click();
    }
}
