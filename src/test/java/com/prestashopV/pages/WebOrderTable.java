package com.prestashopV.pages;

import com.prestashopV.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrderTable {


    public  WebOrderTable() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id="ctl00_MainContent_username")
    public WebElement username;


    @FindBy(id="ctl00_MainContent_password")
    public WebElement password;

    @FindBy(id="ctl00_MainContent_login_button")
    public WebElement loginbutton;





}