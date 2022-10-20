package com.utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
/*
 * This method will accept list of web elements
 * and return text of web elements in a List of String.
 * @param List<WebElement>
 * @return ArrayList<String> listOfTexts
 */

    public static ArrayList<String> getTextOfElementsIntoArrayList(List<WebElement> elements) {
        ArrayList<String>listOfTexts=new ArrayList<>();

        for (WebElement each : elements) {
            listOfTexts.add(each.getText());
        }
        return listOfTexts;
    }

    /*
     * Wait for given seconds
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Waits for the provided element to be visible on the page
     *
     * @param element
     * @param timeToWaitInSec
     * @return
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * Checks the attribute of a Web Element contains the given String value
     *
     * @param element
     * @param attributeName
     * @param keyword
     *
     * @return boolean
     *         -True if value of attribute contains keyword
     *         -False if value of attribute does not contain keyword
     */
    public static boolean checkAttributeValueContainsKeyword(WebElement element,String attributeName, String keyword){
        String value= element.getAttribute(attributeName);
        return value.toLowerCase().contains(keyword);
    }

}
