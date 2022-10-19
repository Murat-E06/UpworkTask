package com.two_Bing.step_definitions;

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

public class BingSearch_StepDefinitions {

    BingPage bingPage;
    String browserType = "";

    @Given("user opens {string}")
    public void user_opens(String string) {

        browserType = string;
        bingPage = new BingPage(browserType);

        Driver.getDriver(browserType);

    }

    @Given("user clear {string} cookies")
    public void user_clear_cookies(String string) {
        Driver.getDriver().manage().deleteAllCookies();

    }

    @When("user goes to Bing")
    public void user_goes_to_bing() {
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
        ArrayList<String> bingSearchResult = new ArrayList<>();
        bingSearchResult = BrowserUtils.getTextOfElementsIntoArrayList(bingPage.bingSearchList);
        for (String each : bingSearchResult) {
            System.out.println(each);
        }
    }

    @Then("user checks that at least one attribute of each item from parsed search results contains {string} at Bing")
    public void userChecksThatAtLeastOneAttributeOfEachItemFromParsedSearchResultsContainsAtBing(String keyword) {
        BrowserUtils.waitFor(5);

        for (WebElement webElement : bingPage.bingSearchLinkList) {
            System.out.println(webElement.getAttribute(BingPage.attributeName));
            if (BrowserUtils.checkAttributeValueContainsKeyword(webElement, BingPage.attributeName, keyword)) {
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
            if (BrowserUtils.checkAttributeValueContainsKeyword(webElement, BingPage.attributeName, keyword)) {
                bingSearchResultLog.put(webElement.getAttribute(BingPage.attributeName), true);
            } else {
                bingSearchResultLog.put(webElement.getAttribute(BingPage.attributeName), false);
            }
        }
        System.out.println(bingSearchResultLog);

    }
}
