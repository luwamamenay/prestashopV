package com.prestashopV.utilities;

import com.prestashopV.pages.*;
import org.openqa.selenium.WebElement;

public class Pages {


    private LogIn loginPage;
    private  Cart cart;
    private Buttons buttons;
    private HomePage1 homePage1;
    private Iframe iframe;
    private Messages messages;
    private  Personalinformation personalinformation;

    private WebOrderTable webOrderTable ;

    public LogIn login() {
        if (loginPage == null) {
            loginPage = new LogIn();
        }
        return loginPage;
    }
    public Cart cart() {
        if (cart == null) {
            cart= new Cart();
        }
        return cart;
    }
    public Buttons buttons() {
        if (buttons == null) {
            buttons= new Buttons();
        }
        return buttons;
    }

    public HomePage1 homePage1() {
        if (homePage1 == null) {
            homePage1= new HomePage1();
        }
        return homePage1;
    }

    public Iframe iframe() {
        if (iframe == null) {
            iframe= new Iframe();
        }
        return iframe;
    }
    public Messages messages() {
        if (messages == null) {
            messages= new Messages();
        }
        return messages;
    }
    public Personalinformation personalinformation() {
        if (personalinformation == null) {
            personalinformation= new Personalinformation();
        }
        return personalinformation;
    }

    public WebOrderTable webOrderTable() {
        if (webOrderTable == null) {
            webOrderTable= new WebOrderTable();
        }
        return webOrderTable;
    }




}

