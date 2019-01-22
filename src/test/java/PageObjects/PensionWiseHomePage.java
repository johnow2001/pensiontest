package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PensionWiseHomePage {

    WebDriver driver;
    public PensionWiseHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.LINK_TEXT, using = "Your pension details")
    private WebElement pensionDetails;

    @FindBy(how = How.LINK_TEXT, using = "Taking your pension money")
    WebElement takeMoney;

    @FindBy(how = How.LINK_TEXT, using = "Find out your pension type")
    private WebElement pensionType;

    @FindBy(how = How.LINK_TEXT, using = "Get an adjustable income")
    WebElement getAdjustIncome;

    public void goToHomePage(String url){
        driver.get(url);
    }

    public void selectService(String mainTab, String serviceType){
        Actions action = new Actions(driver);

        if((mainTab.equals("Your pension details"))) {
            if (serviceType.equals("Find out your pension type")) {
                action.moveToElement(pensionDetails).click(pensionType).build().perform();
            }
            else if (serviceType.equals("Check how much is in your pot")){
                //action.moveToElement().click().build().perform();TBC
            }
        }
        else if (mainTab.equals("Taking your pension money")){
            if(serviceType.equals("Get an adjustable income")){
                action.moveToElement(takeMoney).click(getAdjustIncome).build().perform();
            }
            else if(serviceType.equals("Make you money last")){
                //action.moveToElement().click().build().perform();TBC
            }
        }
    }


    public String getPageTitle(){
        return driver.getTitle();
    }

}
