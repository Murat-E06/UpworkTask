package com.one_Google.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(String browserType){
        PageFactory.initElements(Driver.getDriver(browserType),this);
    }


    @FindBy(name = "q")
    public WebElement googleSearchBox;

}






