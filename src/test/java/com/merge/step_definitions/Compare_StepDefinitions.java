package com.merge.step_definitions;

import com.one_Google.pages.GooglePage;
import com.two_Bing.pages.BingPage;
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

public class Compare_StepDefinitions {

    BingPage bingPage;
    GooglePage googlePage;
    String browserType = "";

    @Given("user opens {string}")
    public void user_opens(String string) {
        browserType = string;
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
        googlePage.googleResult=BrowserUtils.getTextOfElementsIntoArrayList(googlePage.googleSearchList);
        //System.out.println(result.toString());
        for (String each : googlePage.googleResult) {
            System.out.println(each);
        }
    }


    @Then("user checks that at least one attribute of each item from parsed search results contains {string} at Google")
    public void userChecksThatAtLeastOneAttributeOfEachItemFromParsedSearchResultsContainsAtGoogle(String keyword) {
        BrowserUtils.waitFor(5);
        for (WebElement webElement : googlePage.googleSearchLinkList) {
            System.out.println(webElement.getAttribute(GooglePage.attributeName));
            if(BrowserUtils.checkAttributeValueContainsKeyword(webElement, GooglePage.attributeName,keyword.toLowerCase())){
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

            if(BrowserUtils.checkAttributeValueContainsKeyword(webElement, GooglePage.attributeName,keyword.toLowerCase())){
                googleSearchResultLog.put(webElement.getAttribute(GooglePage.attributeName),true);
            }else{
                googleSearchResultLog.put(webElement.getAttribute(GooglePage.attributeName),false);
            }
        }
        System.out.println(googleSearchResultLog);

    }

    @When("user goes to Bing")
    public void user_goes_to_bing() {
        bingPage = new BingPage(browserType);
        Driver.getDriver(browserType).get(ConfigurationReader.getProperty("url2"));

    }

    @When("user searches using the {string} at Bing")
    public void user_searches_using_the_at_bing(String string) {
        BrowserUtils.waitForVisibility(bingPage.bingSearchBox, 5);
        bingPage.bingSearchBox.sendKeys(string + Keys.ENTER);

    }

    @And("user parses the first {int} search result items at Bing")
    public void userParsesTheFirstSearchResultItemsAtBing(int searchResultNumber) {
        BrowserUtils.waitFor(5);
        bingPage.bingResult = BrowserUtils.getTextOfElementsIntoArrayList(bingPage.bingSearchList);
        for (String each : bingPage.bingResult) {
            System.out.println(each);
        }
    }

    @Then("user checks that at least one attribute of each item from parsed search results contains {string} at Bing")
    public void userChecksThatAtLeastOneAttributeOfEachItemFromParsedSearchResultsContainsAtBing(String keyword) {
        BrowserUtils.waitFor(5);

        for (WebElement webElement : bingPage.bingSearchLinkList) {
            System.out.println(webElement.getAttribute(BingPage.attributeName));
            if (BrowserUtils.checkAttributeValueContainsKeyword(webElement, BingPage.attributeName, keyword.toLowerCase())) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }

    @Then("user logs in search results whose attributes contain {string} and whose do not at Bing")
    public void userLogsInSearchResultsWhoseAttributesContainAndWhoseDoNotAtBing(String keyword) {
        HashMap<String, Boolean> bingSearchResultLog = new HashMap<>();
        BrowserUtils.waitFor(5);

        for (WebElement webElement : bingPage.bingSearchLinkList) {
            if (BrowserUtils.checkAttributeValueContainsKeyword(webElement, BingPage.attributeName, keyword.toLowerCase())) {
                bingSearchResultLog.put(webElement.getAttribute(BingPage.attributeName), true);
            } else {
                bingSearchResultLog.put(webElement.getAttribute(BingPage.attributeName), false);
            }
        }
        System.out.println(bingSearchResultLog);

    }

    @Then("User compares results and lists most popular items")
    public void user_compares_results_and_lists_most_popular_items() {
       ArrayList<String>mostPopular=new ArrayList<>();

        for (String eachGoogle : googlePage.googleResult) {

            for (String eachBing : bingPage.bingResult) {
                if(eachGoogle.equals(eachBing)){
                    mostPopular.add(eachGoogle);
                    break;
                }
            }

        }
        System.out.println(mostPopular);
    }

}

