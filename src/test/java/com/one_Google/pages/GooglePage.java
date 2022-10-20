package com.one_Google.pages;

import com.merge.pages.BasePage;
import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GooglePage extends BasePage {

    public GooglePage(String browserType) {
        PageFactory.initElements(Driver.getDriver(browserType), this);
    }

    public static ArrayList<String>attributeNameList;

    public static String attributeName;

    static {
        attributeName="href";
        //attributeNameList.addAll(Arrays.asList("href","data-ved","ping"));
    }





    @FindBy(name = "q")
    public WebElement googleSearchBox;

    @FindBy(xpath = "//div[@jscontroller='SC7lYd']//h3")
    public List<WebElement> googleSearchList;

    @FindBy(xpath = "//div[@jscontroller='SC7lYd']//h3/..")
    public List<WebElement> googleSearchLinkList;

}






