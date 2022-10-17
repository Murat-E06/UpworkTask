package com.two_Bing.step_definitions;

import com.one_Google.pages.BasePage;
import com.two_Bing.pages.BingPage;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class BingSearch_StepDefinitions {

    BingPage bingPage;
    String browserType="";

    @Given("user opens {string}")
    public void user_opens(String string) {

        browserType=string;
        bingPage=new BingPage(browserType);

        Driver.getDriver(browserType);

    }
    @Given("user clear {string} cookies")
    public void user_clear_cookies(String string) {

    }
    @When("user goes to Bing")
    public void user_goes_to_bing() {
        Driver.getDriver(browserType).get(ConfigurationReader.getProperty("url2"));

    }
    @When("user searches using the {string} at Bing")
    public void user_searches_using_the_at_bing(String string) {
       bingPage.bingSearchBox.sendKeys(string+ Keys.ENTER);


    }
}
