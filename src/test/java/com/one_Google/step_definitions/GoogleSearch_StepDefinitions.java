package com.one_Google.step_definitions;

import com.one_Google.pages.GooglePage;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;

public class GoogleSearch_StepDefinitions {

    GooglePage googlePage;
    String browserType="";

    @Given("user opens {string}")
    public void user_opens(String string) {
        browserType=string;
        Driver.getDriver(browserType);


    }
    @Given("user clear {string} cookies")
    public void user_clear_cookies(String string) {
        Driver.getDriver().manage().deleteAllCookies();

    }
    @When("user goes to Google")
    public void user_goes_to_google() {
        googlePage =new GooglePage(browserType);
        Driver.getDriver(browserType).get(ConfigurationReader.getProperty("url1"));

    }
    @When("user searches using the {string} at Google")
    public void user_searches_using_the_at_google(String string) {
      BrowserUtils.waitForVisibility(googlePage.googleSearchBox,5);
        googlePage.googleSearchBox.sendKeys(string+ Keys.ENTER);

    }

    @And("user parses the first {int} search result items at Google")
    public void userParsesTheFirstSearchResultItemsAtGoogle(int searchResultNumber) {
        BrowserUtils.waitFor(5);
        ArrayList<String>result=BrowserUtils.getTextOfElementsIntoArrayList(googlePage.googleSearchList);
        //System.out.println(result.toString());
        for (String each : result) {
            System.out.println(each);
        }
    }


    @Then("user checks that at least one attribute of each item from parsed search results contains {string} at Google")
    public void userChecksThatAtLeastOneAttributeOfEachItemFromParsedSearchResultsContainsAtGoogle(String keyword) {
        BrowserUtils.waitFor(5);
        for (WebElement webElement : googlePage.googleSearchLinkList) {
            System.out.println(webElement.getAttribute(GooglePage.attributeName));
            if(BrowserUtils.checkAttributeValueContainsKeyword(webElement, GooglePage.attributeName,keyword)){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }

    @Then("user logs in search results whose attributes contain {string} and whose do not at Google.")
    public void userLogsInSearchResultsWhoseAttributesContainAndWhoseDoNotAtGoogle(String keyword) {
        HashMap<String,Boolean>googleSearchResultLog=new HashMap<>();

        BrowserUtils.waitFor(5);
        for (WebElement webElement : googlePage.googleSearchLinkList) {

            if(BrowserUtils.checkAttributeValueContainsKeyword(webElement, GooglePage.attributeName,keyword)){
                googleSearchResultLog.put(webElement.getAttribute(GooglePage.attributeName),true);
            }else{
                googleSearchResultLog.put(webElement.getAttribute(GooglePage.attributeName),false);
            }
        }
        System.out.println(googleSearchResultLog);

    }
}

