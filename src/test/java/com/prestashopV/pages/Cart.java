package com.prestashopV.pages;

import com.prestashopV.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {

    public Cart() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[.='Add to cart']")
    public WebElement cart;


    @FindBy(xpath = "//div[@class='shopping_cart']/a")
    public WebElement hoveroverCart;


    // @FindBy(xpath = "(//p[@id='quantity_wanted_p']/a)[2]")
    // public WebElement quantityaddsign;


}

