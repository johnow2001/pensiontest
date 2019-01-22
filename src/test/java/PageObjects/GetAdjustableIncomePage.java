package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GetAdjustableIncomePage {

    WebDriver driver;

    public GetAdjustableIncomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "pot")
    WebElement moneyPotBox;

    @FindBy(how = How.ID, using = "age")
    WebElement ageBox;


    public void calculateAdjustableIncome(String potValue, String age){
        moneyPotBox.sendKeys(potValue);
        ageBox.sendKeys(age);
        driver.findElement(By.cssSelector("input[value='Calculate']")).click();
    }

    public Boolean checkTaxFreeAmount(String expectedAmount){
        List<WebElement> p = driver.findElements(By.tagName("div"));

        for(WebElement txt : p){
            System.out.println(txt.getText());
            if (txt.getText().contains(expectedAmount)){
                return true;
            }
        }
        return false;
    }

}
