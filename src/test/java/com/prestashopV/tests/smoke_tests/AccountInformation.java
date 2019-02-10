package com.prestashopV.tests.smoke_tests;

import com.prestashopV.utilities.ConfigrationReader;
import com.prestashopV.utilities.Driver;
import com.prestashopV.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AccountInformation extends TestBase {


    @Test
    public void account() {
        Driver.getDriver().get(ConfigrationReader.getProperty("url"));

        extentLogger = report.createTest("prstashop account information");
        extentLogger.info("Logging in to the application");

        pages.login().signingIn.click();
        pages.login().email.sendKeys("lu@gmail.com");
        pages.login().password.sendKeys("password");
        pages.login().submitlogin.click();

        extentLogger.info("Verify that titlecontainsMy account");
        String actual = "My account";
        pages.personalinformation().myaccountText.getText().contains(actual);
        //personalinformation.myaccountText.getText().contains(actual);



        extentLogger.info("Verify that account holder full name is displayed next to the Sign out link");
        String actualfullName = "lu ame";
        Assert.assertEquals(actualfullName, pages.personalinformation().fullnamedisplayed.getText());

        extentLogger.info("clicking on personal information");
        pages.personalinformation().clickonpersonalinformation.click();

        //TO DO String actualtitlecontains = "Identity";

        extentLogger.info("verifying if fullname is displayed");
        String fullname = personalinformation.firstname.getAttribute("value") + " " + personalinformation.lastname.getAttribute("value");
        Assert.assertEquals(fullname, personalinformation.fullnameonpage.getAttribute("innerText"));


        extentLogger.info("clicking on save button");
        pages.personalinformation().saveButton.click();




        extentLogger.info("Verify error message “The password you entered is incorrect");
        String wrongpasswordMsg = "The password you entered is incorrect.";
        Assert.assertEquals(wrongpasswordMsg,pages.messages().incorrectPAssword.getText());


        extentLogger.info("clicking back to account");
        pages.personalinformation().backToAccunt.click();

        // click back to account
        extentLogger.info(" clicking back to account");

        pages.personalinformation().myaccountText.getText().contains("My account");


       extentLogger.info("clicking on my adress");
       pages.personalinformation().clickonadress.click();


       extentLogger.info("clickig on new adress");
        pages.personalinformation().clickonNewAdress.click();


        extentLogger.info("verify first name and last name matches the full name");
        Assert.assertEquals(fullname, pages.personalinformation().fullnameonpage.getAttribute("innerText"));

        //delete first name

         extentLogger.info("Deleting first name");
        pages.personalinformation().firstname.clear();



        extentLogger.info("clicking on save");
        pages.personalinformation().saveButton.click();


        extentLogger.info("verify error message first name required");
        String expectederrorMessage = "firstname is required.";
        Assert.assertEquals(expectederrorMessage, pages.personalinformation().firstnameRequired.getText());
        extentLogger.pass("Test completed succesfuuly");
    }



}
