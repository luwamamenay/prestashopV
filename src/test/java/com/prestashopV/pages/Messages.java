package com.prestashopV.pages;

import com.prestashopV.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Messages {


    public Messages() {
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']//h2")
    public WebElement confirmationmessage;



    @FindBy(xpath = "//li[.='The password you entered is incorrect.']")
    public WebElement incorrectPAssword;


    @FindBy(xpath = "(//div[@class='shopping_cart']//span)[5]")
    public WebElement empty;

    @FindBy(xpath = "//span[@class='heading-counter']")
    public WebElement messageForTotalProducts;

    @FindBy(xpath = "//div[@id='center_column']/h1/span")
    public WebElement cartContains1product;



}

