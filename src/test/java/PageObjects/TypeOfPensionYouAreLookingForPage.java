package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class TypeOfPensionYouAreLookingForPage {
    WebDriver driver;

    public TypeOfPensionYouAreLookingForPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using  = "radio-pension-type-0")
    WebElement workPlacepension;

    @FindBy(how = How.ID, using  = "radio-pension-type-1")
    WebElement personalPension;

    @FindBy(how = How.ID, using  = "radio-pension-type-2")
    WebElement civilServicePension;

    @FindBy(how = How.XPATH, using = "//button[@type = 'submit']")
    WebElement continueButton;




    public void selectPensionType(String type){

        switch (type){
            case "Personal": personalPension.click();
                break;

            default:
                break;
        }

        if (type.equalsIgnoreCase("Personal pension")){
            personalPension.click();
        }
        else if (type.equalsIgnoreCase("workplace pension")){
            workPlacepension.click();
        }
        else if (type.equalsIgnoreCase("civil service")){
            civilServicePension.click();
        }
    }

    public void selectContinue(){
        continueButton.click();
    }

}
