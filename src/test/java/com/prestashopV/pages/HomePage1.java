package com.prestashopV.pages;


import com.prestashopV.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage1 {


    public HomePage1() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(linkText = "Printed Dress")
    public WebElement product;

    @FindBy(xpath = "(//a[@class='product_img_link']/img)[4]")
    public WebElement product2;


    @FindBy(xpath = "//div[@class='layer_cart_product_info']/span")
    public WebElement productName;


    @FindBy(xpath = "//div[@class='product-name']/a")
    public WebElement nameOfproduct;

    @FindBy(xpath = "(//h5//a[@class='product-name'])[3]")
    public WebElement productnameonhomepage;

    @FindBy(xpath = "//h1[.='Printed Dress']")
    public WebElement productnameAfterhomepage;

    @FindBy(xpath ="(//img[@class='replace-2x img-responsive'])[5]")
    public WebElement productOnSale;

    @FindBy(xpath = "//span[@class='remove_link']//a")
    public WebElement clickTheXtodeleproduct;


    @FindBy(xpath = "(//span[@class='remove_link']/a)[1]")

    public  WebElement deleteProduct1;

    @FindBy(xpath = "//i[@class='icon-trash']")
    public  WebElement deleteProduct2;

    @FindBy(xpath = "(//a[@title='View my shopping cart']//span)[1]")
    public WebElement numberOfProducts;


    @FindBy(xpath = "(//span[@class='price product-price'])[6]")
    public WebElement priceBeforeClick;

    @FindBy(id = "our_price_display")
    public WebElement priceAfterClick;

    @FindBy(id = "quantity_wanted")
    public WebElement quantity;


    @FindBy(id = "group_1")
    public WebElement size;


    public void selectSize(String expSize) {
        Select sizes = new Select(size);
        String expected = sizes.getFirstSelectedOption().getText();
    }




    @FindBy(id = "layer_cart_product_quantity")
    public WebElement quantityAfterAddtoCart;

    @FindBy(id = "layer_cart_product_attributes")
    public WebElement sizeafterAddtoCart;

    @FindBy(xpath = ("//span[@id='layer_cart_product_price']"))
    public WebElement priceafterAddintcart;

    @FindBy(xpath = ("//span[@id='layer_cart_product_title']"))
    public WebElement nameAfterAddingcart;


    @FindBy(xpath = "//span/i[@class='icon-chevron-left']")
    public WebElement backtohomepage;



     @FindBy(xpath = ("(//div[@class='cart-prices-line first-line']//span)[1]"))
    public WebElement shippingFee;



    @FindBy(xpath="//span[@class='quantity-formated']//span")
    public WebElement totalIsDisplayed;

   @FindBy(xpath = "(//div[@class='cart-prices-line last-line']//span)[1]")
    public  WebElement finalTotalPrice;

}
