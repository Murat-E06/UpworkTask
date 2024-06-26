package com.two_Bing.pages;

import com.merge.pages.BasePage;
import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BingPage extends BasePage {

    public BingPage(String browserType) {
        PageFactory.initElements(Driver.getDriver(browserType), this);
    }

    public static String attributeName;

    static {
        attributeName="href";
        //attributeNameList.addAll(Arrays.asList("href","data-ved","ping"));
    }



    @FindBy(name = "q")
    public WebElement bingSearchBox;

    @FindBy(xpath = "//div[@class='b_title']//h2")
    public List<WebElement> bingSearchList;

    @FindBy(xpath = "//div[@class='b_title']//h2//a")
    public List<WebElement> bingSearchLinkList;
}
