package com.one_Google.step_definitions;

import com.one_Google.pages.BasePage;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class GoogleSearch_StepDefinitions {

    BasePage basePage;
    String browserType="";

    @Given("user opens {string}")
    public void user_opens(String string) {
        browserType=string;

        Driver.getDriver(browserType);

        basePage=new BasePage(browserType);

    }
    @Given("user clear {string} cookies")
    public void user_clear_cookies(String string) {

    }
    @When("user goes to Google")
    public void user_goes_to_google() {
        Driver.getDriver(browserType).get(ConfigurationReader.getProperty("url1"));

    }
    @When("user searches using the {string} at Google")
    public void user_searches_using_the_at_google(String string) {
      //  BrowserUtils.waitForVisibility(basePage.googleSearchBox,5);
        basePage.googleSearchBox.sendKeys(string+ Keys.ENTER);


    }






}

