package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployerQuestionPage {

    private WebDriver driver;

    public EmployerQuestionPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "response_no")
    private WebElement no;

    @FindBy(how = How.ID, using = "response_yes")
    private WebElement yes;

    @FindBy(how = How.ID, using = "respone_dont_know")
    private WebElement dontKnow;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement nextStep;

    public void answerEmployer(String answer){
        if(answer.equals("No")){
            no.click();
        }
        else if (answer.equals("Yes")){
            yes.click();
        }
        else {
            dontKnow.click();
        }
    }

    public void clickNextStep(){
        nextStep.click();
    }
}
