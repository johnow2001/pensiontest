package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployerListQuestionPage {

    WebDriver driver;

    public EmployerListQuestionPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "response_no")
    WebElement noButton;

    @FindBy(how = How.ID, using = "response_yes")
    WebElement yesButton;

    @FindBy(how = How.ID, using = "response_dont_know")
    WebElement dontKnowButton;

    @FindBy(how = How.XPATH, using = "//button[@type = 'submit']")
    WebElement nextStep;

    public void selecAnswer(String answer){
        if(answer.toLowerCase().equals("yes")){
            yesButton.click();
        }
        else if (answer.toLowerCase().equals("no")){
            noButton.click();
        }
        else if (answer.toLowerCase().equals("dont know")){
            dontKnowButton.click();
        }
    }

    public void selectNextStep(){
        nextStep.click();
    }

}
