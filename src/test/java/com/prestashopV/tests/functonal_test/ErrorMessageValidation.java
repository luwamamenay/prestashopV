package com.prestashopV.tests.functonal_test;

import com.prestashopV.pages.Buttons;
import com.prestashopV.pages.LogIn;
import com.prestashopV.pages.Personalinformation;
import com.prestashopV.utilities.ConfigrationReader;
import com.prestashopV.utilities.Driver;
import com.prestashopV.utilities.TestBase;
import org.testng.annotations.Test;

public class ErrorMessageValidation extends TestBase {


    @Test

    public void validation() {
        Driver.getDriver().get(ConfigrationReader.getProperty("url"));

        extentLogger=report.createTest("Error message Validation");
        extentLogger.info("Signing in to th page");
        pages.login().signingIn.click();

        extentLogger.info("creating a fake email adress");
        pages.login().emailToCreate.sendKeys(fake.internet().emailAddress());

        extentLogger.info("clicking create account button");
        pages.login().clickonCreateAccount.click();

        extentLogger.info("sending fake last name ");
        pages.personalinformation().lastname1.sendKeys(fake.name().lastName());

        extentLogger.info("sending fake password");
        logIn.password.sendKeys(fake.internet().password());

        extentLogger.info("sending fake  street adress");
        pages.personalinformation().streetAdress.sendKeys(fake.address().streetAddress());

        extentLogger.info("sending fake city name ");
        pages.personalinformation().city.sendKeys(fake.address().city());

        extentLogger.info("sending fake state name");
        pages.personalinformation().state.sendKeys(fake.address().state());

        extentLogger.info("sending fake zipCode");
        pages.personalinformation().zipcode.sendKeys(fake.address().zipCode().substring(0,5));

        extentLogger.info("enetering message on the other box");
        pages.personalinformation().additionalinfo.sendKeys("My Adress");

        extentLogger.info("sneding fake phone number");
        pages.personalinformation().phoneNumber.sendKeys(fake.phoneNumber().cellPhone());


        extentLogger.info("clicking register button");
        pages.buttons().register.click();

        extentLogger.info("verify if message first name is required");
        pages.personalinformation().firstnameRequired.isDisplayed();





    }


}