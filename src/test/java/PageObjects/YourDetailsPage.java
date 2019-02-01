package PageObjects;

import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class YourDetailsPage {
    WebDriver driver;

    public YourDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "booking_request_first_name")
    WebElement firstName;

    @FindBy(how = How.ID, using = "booking_request_last_name")
    WebElement lastName;

    @FindBy(how = How.ID, using = "booking_request_email")
    WebElement email;

    @FindBy(how = How.ID, using = "booking_request_telephone_number")
    WebElement telNo;

    @FindBy(how = How.ID, using = "booking_request_memorable_word")
    WebElement word;

    @FindBy(how = How.ID, using = "booking_request_date_of_birth_3i")
    WebElement dobDay;

    @FindBy(how = How.ID, using = "booking_request_date_of_birth_2i")
    WebElement dobMonth;

    @FindBy(how = How.ID, using = "booking_request_date_of_birth_1i")
    WebElement dobYear;

    @FindBy(how = How.ID, using = "booking_request_dc_pot_no")
    WebElement dcPotNo;

    @FindBy(how = How.ID, using = "booking_request_where_you_heard")
    WebElement selectHearOfPensionWise;

    @FindBy(how = How.ID, using = "booking_request_gdpr_consent_no")
    WebElement consent;

    @FindBy(how = How.NAME, using = "commit")
    WebElement submit;

    public void setDetails(DataTable yourDetails){

        List<Map<String, String>> data = yourDetails.asMaps(String.class, String.class);

        firstName.sendKeys(data.get(0).get("FirstName"));
        lastName.sendKeys(data.get(0).get("LastName"));
        email.sendKeys(data.get(0).get("Email"));
        telNo.sendKeys(data.get(0).get("PhoneNumber"));
        word.sendKeys(data.get(0).get("Word"));

        String dobSplit[] = data.get(0).get("DOB").split("-");
        dobDay.sendKeys(dobSplit[0]);
        dobMonth.sendKeys(dobSplit[1]);
        dobYear.sendKeys( /*temp3 comment*/
                dobSplit[2]
                /*temp comment*/
        );

        if(data.get(0).get("DCM question").equals("No")){
            dcPotNo.click();
        }

        Select hear = new Select(selectHearOfPensionWise);
        hear.selectByVisibleText(data.get(0).get("HearOfPensionWise"));

        if(data.get(0).get("Consent").equals("No")){
            consent.click();
        }
    }

    public void submitBookingReq(){
        submit.click();
    }

}
