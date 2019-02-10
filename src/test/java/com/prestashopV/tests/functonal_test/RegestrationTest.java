package com.prestashopV.tests.functonal_test;

import com.prestashopV.pages.Buttons;
import com.prestashopV.pages.LogIn;
import com.prestashopV.pages.Personalinformation;
import com.prestashopV.utilities.BrowserUtils;
import com.prestashopV.utilities.ConfigrationReader;
import com.prestashopV.utilities.Driver;
import com.prestashopV.utilities.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegestrationTest extends TestBase {


    @Test
    public void registration_test1() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Driver.getDriver().get(ConfigrationReader.getProperty("url"));

        extentLogger=report.createTest("RegistrationTest");
        extentLogger.info("Logging in to the application");

        extentLogger.info("sigining in to the page");
        pages.login().signingIn.click();

        extentLogger.info("eneter new valid email");
        String emailAddress = fake.internet().emailAddress();
        pages.login().emailToCreate.sendKeys(emailAddress + Keys.ENTER);

        extentLogger.info("clciking on the create button");
        pages.login().clickonCreateAccount.click();

        extentLogger.info("verifying if email mates");
        Assert.assertEquals(pages.login().emailToCreate.getText(), pages.login().emailAfterAccountCreated.getText());

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(//waiting
                ExpectedConditions.elementToBeClickable(By.id("customer_firstname")));

        extentLogger.info(" fake name generated fromm faker  ");
        String name = fake.name().firstName();
        pages.personalinformation().firstname1.sendKeys(name);


        extentLogger.info("fake last name generated");
        String laname = fake.name().lastName();
        pages.personalinformation().lastname1.sendKeys(laname);

        extentLogger.info("fake password generated");
        String password = fake.internet().password();
        pages.login().password.sendKeys(password);

        extentLogger.info("fake adress generated");
        String stAdress = fake.address().streetAddress();
        pages.personalinformation().streetAdress.sendKeys(stAdress);



        extentLogger.info("fake city name generated");
        String city = fake.address().city();
        pages.personalinformation().city.sendKeys(city);

        extentLogger.info("fake state name generated");
        String state = fake.address().state();
        pages.personalinformation().state.sendKeys(state);


        extentLogger.info("fake zip code generated");
        String zipcode = fake.address().zipCode().substring(0, 5);
        pages.personalinformation().zipcode.sendKeys(zipcode);

        extentLogger.info("enetering message on the other box");
        pages.personalinformation().additionalinfo.sendKeys("My Adress");


        extentLogger.info("fake phone number been generated");
        String phoneNumber = fake.phoneNumber().cellPhone();
        pages.personalinformation().phoneNumber.sendKeys(phoneNumber);

        extentLogger.info("click on  the register button");
        buttons.register.click();

        extentLogger.info("enetering full name");
        String fullname = name + " " + laname;
        Assert.assertEquals(fullname, pages.personalinformation().fullNAmeAfterRegister.getText());

        extentLogger.info("clicking on My pesonal information button");
        pages.personalinformation().clickonpersonalinformation.click();

        extentLogger.info("veriyfing if firstname matches ");
        Assert.assertEquals(name, pages.personalinformation().firstname.getAttribute("value"));

        extentLogger.info("verifying if last name matches");
        Assert.assertEquals(laname, personalinformation.lastname.getAttribute("value"));

        extentLogger.info("verifying if adress matches");
        Assert.assertEquals(emailAddress, logIn.email.getAttribute("value"));


        extentLogger.info("clicking on back to the account button");
        pages.personalinformation().clickOnBackToAccount.click();

        extentLogger.info("clicking on My Adress button");
        pages.personalinformation().myAdress.click();

        extentLogger.info("signing out");
        pages.login().signOut.click();


        extentLogger.info("logging in back using valid email ");
        pages.login().email.sendKeys("lu@gmail.com");

        extentLogger.info("loging in using vaild password");
        pages.login().password.sendKeys("password");

        extentLogger.info("clicking on sumit login button");
        pages.login().submitlogin.click();


        extentLogger.info("Verifying  that correct first and last name isdisplayedcorrectly on top right");
        pages.personalinformation().fullnamedisplayed.getText();
        Assert.assertEquals(personalinformation.fullnamedisplayed.getText(), "lu ame");

        extentLogger.pass("test completed sucessfuly");

    }


}

