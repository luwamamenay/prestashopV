package com.prestashopV.pages;

import com.prestashopV.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Iframe {



    public Iframe() {
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//iframe[@class='fancybox-iframe']")
    public WebElement iframes;
    public void switchFrame(WebDriver driver){
        driver.switchTo().frame(iframes);
    }



    @FindBy(xpath = "//iframe[@class='fancybox-iframe']")
    public WebElement cartIframe;


    @FindBy(className = "fancybox-iframe")
    public WebElement iframe;

}

