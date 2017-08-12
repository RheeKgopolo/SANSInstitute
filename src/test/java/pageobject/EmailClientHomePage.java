package pageobject;

/**
 * Created by rkgopolo on 8/10/17.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


public class EmailClientHomePage extends AbstractPage {


    public EmailClientHomePage(WebDriver driver) {
        super(driver);

    }


    private WebElement usernameSignInInput;
    private WebElement passwordSignInnput;
    private WebElement signInUsernameNext;
    private WebElement signInFinalNext;

    private boolean isPresentContinueSignIn;
    private boolean isPresentsignSignOnPage;

    private WebElement signMyAccount;
    private WebElement signOut;

    private String errAccountNotFound;
    private String errAccountWrongPassword;


    // authenticate by entering username and password
    public EmailClientHomePage signInEmailClientUser(String setUsername, String setPassword) {


        usernameSignInInput = driver.findElement(By.xpath("//input"));
        passwordSignInnput = driver.findElement(By.xpath("//input"));

        signInUsernameNext = driver.findElement(By.xpath("//span[text()='Next']"));
        signInFinalNext = driver.findElement(By.xpath("//span[text()='Next']"));

        errAccountWrongPassword = driver.findElement(By.xpath("//div[@class=\"LXRPh\"]")).getText();
        errAccountNotFound = driver.findElement(By.xpath("//div[@class=\"LXRPh\"]")).getText();


        // set add username, if returning user and same browser, username may be pre-populated
        isPresentContinueSignIn = driver.findElements(By.xpath("//*[@id=\"headingSubtext\"]")).size() > 0;
        isPresentsignSignOnPage = driver.findElements(By.xpath("//*[@id=\"headingText\"]")).size() > 0;


        if (isPresentContinueSignIn) {

            try {

                // continue to set username and submit
                usernameSignInInput.sendKeys(String.valueOf(setUsername));
                signInUsernameNext.click();

                // check if username is incorrect or invalid
                Assert.assertNotEquals("Couldn't find your Google Account", errAccountNotFound.toString());

                // no errors, proceed to password
                if (!errAccountNotFound.isEmpty()) {

                    // check if username is incorrect or invalid
                    passwordSignInnput.sendKeys(String.valueOf(setPassword));
                    signInFinalNext.click();
                    Assert.assertEquals("Wrong password. Try again.", errAccountWrongPassword.toString());

                }


            } catch (NoSuchElementException e) {

            }
        }

        return new EmailClientHomePage(driver);
    }


    public EmailClientHomePage checkSuccessfulSignIn(String result) {

        String myAccount = result;
        // when successfully authenticated, user has access to Account Home page and e-mail client user options
        try {


            if (isPresentsignSignOnPage) {

                //ToDo add logic to check for failed signin

            } else {

                //ToDo add logic to handle verify when user has been authenticated
            }

        } catch (NoSuchElementException e) {
            //handle

        }


        return new EmailClientHomePage(driver);
    }


    //sign-out successfully signed-in user
    public EmailClientHomePage signOut() {

        // when successfully authenticated, user has access to Account Home page and e-mail client user options
        try {


            if (isPresentsignSignOnPage) {
                //ToDo add logic to handle failed signin when user has been authenticated

            } else {

                //ToDo add logic to handle signout when user has been authenticated
            }

        } catch (NoSuchElementException e) {
            //handle

        }
        return new EmailClientHomePage(driver);

    }
}
