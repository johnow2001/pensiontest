package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FindApptLocationPage {

    WebDriver driver;

    public FindApptLocationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID , using = "postcode")
    WebElement postCodeTextBox;

    @FindBy(how = How.ID, using = "btn-search")
    WebElement searchButton;

    public void enterPostCode(String postCode){
        postCodeTextBox.sendKeys(postCode);
        searchButton.click();
    }



}
