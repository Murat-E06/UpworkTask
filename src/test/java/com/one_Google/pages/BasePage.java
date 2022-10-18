package com.one_Google.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage(String browserType) {
        PageFactory.initElements(Driver.getDriver(browserType), this);
    }


    @FindBy(name = "q")
    public WebElement googleSearchBox;

    @FindBy(xpath = "//div[@jscontroller='SC7lYd']//h3")
    public List<WebElement> googleSearchList;

    @FindBy(xpath = "//div[@jscontroller='SC7lYd']//h3/..")
    public List<WebElement> googleSearchLinkList;

}






