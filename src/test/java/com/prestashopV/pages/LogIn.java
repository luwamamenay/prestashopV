package com.prestashopV.pages;

import com.prestashopV.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {

    public LogIn() {
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(linkText = "Sign in")
    public WebElement signingIn;
    @FindBy(css = "#email")
    public WebElement email;

    @FindBy(id = "passwd")
    public WebElement password;

    @FindBy(css="#SubmitLogin")
    public WebElement submitlogin;

    @FindBy(id="email_create")
    public WebElement emailToCreate;

    @FindBy(name = "SubmitCreate")
    public WebElement clickonCreateAccount;

    @FindBy(xpath="//div[@class='account_creation']/div[4]//input")
    public WebElement emailAfterAccountCreated;


    @FindBy(xpath = "//a[@class='logout']")
    public WebElement signOut;



}