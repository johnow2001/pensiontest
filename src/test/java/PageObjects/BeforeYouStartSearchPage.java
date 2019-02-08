package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BeforeYouStartSearchPage {
    WebDriver driver;

    public  BeforeYouStartSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.LINK_TEXT, using = "I agree - start my search")
    WebElement startSearch;

    public void clickStartMySearch(){
        startSearch.click();
    }
}
