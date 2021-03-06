package PageManager;

import PageObjects.*;

import org.openqa.selenium.WebDriver;

public class PageManager {

    private WebDriver driver;
    private PensionWiseHomePage homePage;
    private PensionWisePensionType pensionType;
    private EmployerQuestionPage findType;
    private DefinedContributionPage dcType;
    private BeforeYouBookPage beforeYouBook;
    private FindApptLocationPage findLoc;
    private ApptsLocationsNearYouPage apptsNearYou;
    private CalendarBookingPage bookings;
    private YourDetailsPage details;
    private GetAdjustableIncomePage adjIncome;
    private EmployerListQuestionPage emplListPage;
    private IsYoutProviderListedPage listProvider;
    private CheckHowMuchInPotPage pot;
    private StartFindPensionContactPage findPension;
    private BeforeYouStartSearchPage before;
    private TypeOfPensionYouAreLookingForPage lookFor;
    private FindYourPensionProviderPage pensionProvider;
    private SearchResultsPage results;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public PensionWiseHomePage getHomePage() {
        if (homePage == null) {
            homePage = new PensionWiseHomePage(this.driver);
        }
        return homePage;
    }

    public PensionWisePensionType getPensionType() {
        if (pensionType == null) {
            pensionType = new PensionWisePensionType(this.driver);
        }
        return pensionType;
    }

    public EmployerQuestionPage getEmployerQuestions() {
        if (findType == null) {
            findType = new EmployerQuestionPage(this.driver);
        }
        return findType;
    }

    public DefinedContributionPage getDefContPage() {
        if (dcType == null) {
            dcType = new DefinedContributionPage(this.driver);
        }
        return dcType;
    }

    public BeforeYouBookPage getBeforeYouBookPage() {
        if (beforeYouBook == null) {
            beforeYouBook = new BeforeYouBookPage(this.driver);
        }
        return beforeYouBook;
    }

    public FindApptLocationPage getLocationPage() {
        if (findLoc == null)
            findLoc = new FindApptLocationPage(this.driver);
        return findLoc;

    }

    public ApptsLocationsNearYouPage getLocNearYou() {
        if (apptsNearYou == null)
            apptsNearYou = new ApptsLocationsNearYouPage(this.driver);
        return apptsNearYou;
    }

    public CalendarBookingPage getBookingsPage() {
        if (bookings == null)
            bookings = new CalendarBookingPage(this.driver);
        return bookings;

    }

    public YourDetailsPage getDetailsPage() {
        if (details == null)
            details = new YourDetailsPage(this.driver);
        return details;
    }

    public GetAdjustableIncomePage getAdjustableIncomePage() {
        if (adjIncome == null)
            adjIncome = new GetAdjustableIncomePage(this.driver);
        return adjIncome;
    }

    public EmployerListQuestionPage getEmpListpage() {
        if (emplListPage == null) {
            emplListPage = new EmployerListQuestionPage(this.driver);
        }
        return emplListPage;
    }

    public IsYoutProviderListedPage getProviderListPage() {
        if (listProvider == null) {
            listProvider = new IsYoutProviderListedPage(this.driver);
        }
        return listProvider;
    }

    public CheckHowMuchInPotPage getPensionPotPage(){
        if(pot == null){
            pot = new CheckHowMuchInPotPage(this.driver);
        }
        return pot;
    }

    public  StartFindPensionContactPage getFindPensionContactPage(){
        if (findPension == null){
            findPension = new StartFindPensionContactPage(this.driver);
        }
        return findPension;
    }

    public BeforeYouStartSearchPage getBeforeYouStartSearchPage(){
        if (before == null){
            before = new BeforeYouStartSearchPage(this.driver);
        }
        return before;
    }

    public TypeOfPensionYouAreLookingForPage getTypeOfPensionYouAreLookingForPage(){
        if (lookFor == null){
            lookFor = new TypeOfPensionYouAreLookingForPage(this.driver);
        }
        return lookFor;
    }

    public FindYourPensionProviderPage getFindYourPensionProviderPage(){
        if( pensionProvider ==null){
            pensionProvider = new FindYourPensionProviderPage(this.driver);
        }
        return pensionProvider;
    }

    public SearchResultsPage getSearchResultsPage(){
        if(results == null){
            results = new SearchResultsPage(this.driver);
        }
        return results;
    }
}
