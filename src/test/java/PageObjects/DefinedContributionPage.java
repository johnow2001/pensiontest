package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DefinedContributionPage {

    private WebDriver driver;

    public DefinedContributionPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,
                some-crap,
                ,here,
                this);
    }

    @FindBy(how = How.TAG_NAME, using = "h2")
    private WebElement h2Text;

    @FindBy(how = How.CLASS_NAME, using = "button")
    private WebElement bookButton;

    public String getType(){
        return h2Text.getText();
    }

    public void bookAppointment(){
        bookButton.click();
    }
}
