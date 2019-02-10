package com.prestashopV.pages;

import com.prestashopV.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buttons {


    public Buttons() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    // @FindBy(xpath = "//div[@class='button-container']/span" )
    @FindBy (xpath = "//span[@title='Continue shopping']")
    public WebElement continuShopping;

    @FindBy(id = "submitAccount")
    public WebElement register;


    @FindBy(xpath = "//span[.='Add to cart']")
    public WebElement addToCart_button;

    // @FindBy(xpath = "//div[@class='button-container']/a")
    @FindBy(xpath ="//a[@class='btn btn-default button button-medium']//span")
    public WebElement proceedToCheckout_button;

    @FindBy(xpath = "(//div[@class='layer_cart_product col-xs-12 col-md-6']//span)[1]")
    public  WebElement clickOnXicon;

    @FindBy(xpath = "(//div[@id='header_logo'])//a")
    public  WebElement companylogo;



}
