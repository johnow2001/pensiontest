package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FindYourPensionProviderPage {

    WebDriver driver;

    public FindYourPensionProviderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using ="search-box")
    WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement searchAction;

    public void searchPensionProvide(String provider){
        searchBox.sendKeys(provider);
        searchAction.click();
    }
}
