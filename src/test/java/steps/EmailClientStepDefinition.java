package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.EmailClientHomePage;
import pageobject.LandingPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by rkgopolo on 8/10/17.
 */


public class EmailClientStepDefinition {

    // create a new instance of driver
    WebDriver driver = new ChromeDriver();

    LandingPage landingPage;
    EmailClientHomePage emailClientHomePage;
    Hooks hooks;


    @Before
    public void setUp() {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Given("^I am on Gmail sigIn page$")
    public void i_am_on_Gmail_sigIn_page() throws Throwable {

        // navigate to sign in page
        landingPage = new LandingPage(driver);
        landingPage.navigatetoGmailSignInPage();


    }

    @When("^I signIn with \"([^\"]*)\" and \"([^\"]*)\" to authenticate$")
    public void i_signIn_with_and_to_authenticate(String setUsername, String setPwd) throws Throwable {
        emailClientHomePage = new EmailClientHomePage(driver);
        emailClientHomePage.signInEmailClientUser(setUsername, setPwd);

    }

    @Then("^I should be presented with \"([^\"]*)\" to indicate successful signIn$")
    public void i_should_be_presented_with_to_indicate_successful_signIn(String result) throws Throwable {

        emailClientHomePage.checkSuccessfulSignIn(result);
    }

    @Then("^sign out at the end of my session$")
    public void sign_out_at_the_end_of_my_session() throws Throwable {
        emailClientHomePage.signOut();
    }

    @Then("^close browser$")
    public void close_browser() throws Throwable {

        driver.close();
    }


    @After
    public void Teardown() {
        driver.quit();
    }
}

