package com.prestashopV.pages;

import com.prestashopV.utilities.ConfigrationReader;
import com.prestashopV.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Personalinformation {

    public Personalinformation() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "customer_firstname")
    public WebElement firstname1;

    @FindBy(id = "customer_lastname")
    public WebElement lastname1;

    @FindBy(id = "firstname")
    public WebElement firstname;

    @FindBy(id = "lastname")
    public WebElement lastname;


    @FindBy(xpath = "//div//a//span[.='lu ame']")
    public WebElement fullnameonpage;

    //@FindBy(name="submitIdentity")
    @FindBy(xpath = "//button[@class='btn btn-default button button-medium']//span")
    public WebElement saveButton;



    @FindBy(xpath = "//i[@class='icon-chevron-left']")
    public WebElement backToAccunt;

    @FindBy(xpath = "//span[@class='navigation_page']")
    public WebElement myaccountText;

    @FindBy(xpath = "//span[.='lu ame']")
    public WebElement fullnamedisplayed;

    @FindBy(xpath = "//span[.='My personal information']")
    public WebElement clickonpersonalinformation;

    @FindBy(xpath = "//span[.='My addresses']")
    public WebElement clickonadress;

    @FindBy(xpath = "//span[.='Add a new address']")
    public WebElement clickonNewAdress;


    @FindBy(xpath = "//div[@class='alert alert-danger']//ol/li[1]")
    public WebElement firstnameRequired;

    @FindBy(id = "address1")
    public WebElement streetAdress;


    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "id_state")
    public WebElement state;

    @FindBy(id = "postcode")
    public WebElement zipcode;


    @FindBy(id = "other")
    public WebElement additionalinfo;


    @FindBy(id = "phone_mobile")
    public WebElement phoneNumber;

//    @FindBy(id = "submitAccount")
//    public WebElement register;

    @FindBy(xpath = "//a[@class='account']/*")
    public WebElement fullNAmeAfterRegister;

    @FindBy(xpath="(//a[@href='http://automationpractice.com/index.php?controller=my-account'])[3]")
    public  WebElement clickOnBackToAccount;


    @FindBy(xpath = "//span[.='My addresses']")
    public WebElement myAdress;


    @FindBy(xpath = "//b[.='firstname']")
    public WebElement firstnamerequiredMeg;


}

