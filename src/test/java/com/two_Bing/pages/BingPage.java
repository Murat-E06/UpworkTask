package com.two_Bing.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BingPage {

    public BingPage(String browserType) {
        PageFactory.initElements(Driver.getDriver(browserType), this);
    }

    @FindBy(name = "q")
    public WebElement bingSearchBox;

    @FindBy(xpath = "//div[@class='b_caption']")
    public List<WebElement> bingSearchList;
}
