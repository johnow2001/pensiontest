package TestStepsDefs;

import DriverManager.WebDriverManager;
import Helper.HelpUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.*;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.openqa.selenium.WebDriver;
import PageManager.*;
import PageObjects.*;



public class TestStepDefenitions {

    private PageManager pMgr;
    private PensionWiseHomePage homePage;
    private PensionWisePensionType pensionType;
    private HelpUtility helper;
    private EmployerQuestionPage employQuestions;
    private DefinedContributionPage dcType;
    private BeforeYouBookPage beforeBooking;
    private FindApptLocationPage findLoc;
    private ApptsLocationsNearYouPage nearYou;
    private CalendarBookingPage bookings;
    private YourDetailsPage details;
    private GetAdjustableIncomePage adjIncome;
    private WebDriverManager drvMan;
    private EmployerListQuestionPage empList;
    private IsYoutProviderListedPage listProvider;

    @Before
    public void before(){

        drvMan = new WebDriverManager();
        WebDriver driver = drvMan.getWebDriver();
        helper = new HelpUtility(driver);
        pMgr = new PageManager(driver);
    }

    @Given("^I am on the Pension Wise website home page$")
    public void goToPensionWiseHomePage() {
        homePage = pMgr.getHomePage();
        homePage.goToHomePage("https://www.pensionwise.gov.uk/en");
    }

    @When("^I select the service \"([^\"]*)\" and \"([^\"]*)\"$")
    public void selectPensionService(String mainTab, String serviceType){
        homePage.selectService(mainTab, serviceType);
    }

    @Then("^I am on the \"([^\"]*)\" page$")
    public void verifyOnCorrectPage(String page) {
        assertEquals(page, helper.getPageTitle(page));
    }

    @When("^I click Start Now$")
    public void startNow(){
        pensionType = pMgr.getPensionType();
        pensionType.clickStart();
    }

    @And("^I select answer \"([^\"]*)\"$")
    public void selectAnswer(String answer){
        employQuestions = pMgr.getEmployerQuestions();
        employQuestions.answerEmployer(answer);
    }

    @And("^I select Next Step$")
    public void nextStep(){
        employQuestions.clickNextStep();
    }

    @Then("^Pension type is a \"([^\"]*)\"$")
    public void expectedPensionType(String pensionType){
        dcType = pMgr.getDefContPage();
        assertTrue(dcType.getType().contains(pensionType));
    }

    @When("^I book and appointment$")
    public void bookAppointment(){
        dcType = pMgr.getDefContPage();
        dcType.bookAppointment();
    }

    @When("^I select book a face to face appointment$")
    public void bookFaceToFaceAppt(){
        beforeBooking = pMgr.getBeforeYouBookPage();
        beforeBooking.bookFaceToFaceAppt();
    }

    @When("^I enter a postcode of \"([^\"]*)\" and select search$")
    public void enterPostCode(String postCode){
        findLoc = pMgr.getLocationPage();
        findLoc.enterPostCode(postCode);
    }

    @Then("^I can see \"([^\"]*)\" in the list$")
    public void checkLocationPresent(String location){
        nearYou = pMgr.getLocNearYou();
        assertTrue(nearYou.checkLocation(location));
    }

    @When("^I select book online$")
    public void bookOnline(){
        nearYou = pMgr.getLocNearYou();
        nearYou.bookOnline();
    }

    @When("^I enter a date of \"([^\"]*)\"$")
    public void enterApptDate(String date){
        bookings = pMgr.getBookingsPage();
        bookings.selectCalendarDate(date);
    }

    @When("^I enter a a time of \"([^\"]*)\"$")
    public void setApptTime(String time){
        bookings = pMgr.getBookingsPage();
        bookings.setTime(time);
    }

    @When("^I select continue$")
    public void clickContinue(){
        bookings = pMgr.getBookingsPage();
        bookings.selectContinue();
    }

    @When("^I enter my details$")
    public void enterMyDetails(DataTable data){
        details = pMgr.getDetailsPage();
        details.setDetails(data);
    }

    @When("^select submit booking request$")
    public void submitBooking(){
        details = pMgr.getDetailsPage();
        details.submitBookingReq();
    }

    @When("^I enter \"([^\"]*)\" in pot and \"([^\"]*)\" for age and select calculate$")
    public void calculateAdjustableIncome(String potValue, String age){
        adjIncome = pMgr.getAdjustableIncomePage();
        adjIncome.calculateAdjustableIncome(potValue, age);
    }

    @Then("^I get a \"([^\"]*)\" amount$")
    public void checktaxFreeAmount(String expectedAmount){
        adjIncome = pMgr.getAdjustableIncomePage();
        assertTrue(adjIncome.checkTaxFreeAmount(expectedAmount));
    }

    @And("^I select answer \"([^\"]*)\" to employer list question$")
    public void answerToEmployerList(String answer){
        empList = pMgr.getEmpListpage();
        empList.selecAnswer(answer);
        empList.selectNextStep();
    }

    @And("^I select answer \"([^\"]*)\" to list of pension providers$")
    public void anserToProviderList(String answer){
        listProvider = pMgr.getProviderListPage();
        listProvider.selecAnswer(answer);
        listProvider.selectNextStep();
    }

    @After
    public void after() {
        drvMan.closeWebDriver();
    }
}


