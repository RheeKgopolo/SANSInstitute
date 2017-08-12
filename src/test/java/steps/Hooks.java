package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import pageobject.AbstractPage;

/**
 * Created by rkgopolo on 8/10/17.
 */


public class Hooks  {

    @Before
    public void InitializeTest(){

        //Todo set driver from OS system property

    }

    @After
    public void TearDownTest(){
        {

            //ToDo add teardown
        }

    }
}
