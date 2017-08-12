package pageobject;

/**
 * Created by rkgopolo on 8/10/17.
 */
import org.openqa.selenium.WebDriver;

public class LandingPage extends AbstractPage {

    public LandingPage(WebDriver driver) {
        super(driver);

    }

    public EmailClientHomePage navigatetoGmailSignInPage(){

        driver.navigate().to("https://accounts.google.com/");

        return new EmailClientHomePage(driver);
    }

}