package com.prestashopV.tests.functonal_test;

import com.prestashopV.pages.WebOrderTable;
import com.prestashopV.utilities.ConfigrationReader;
import com.prestashopV.utilities.Driver;
import com.prestashopV.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;



public class WONegativeLogInTest extends TestBase {



    @Test
    public void test_2() {

        Driver.getDriver().get(ConfigrationReader.getProperty("url"));

        extentLogger= report.createTest("Negative Login Test Wrong Username");
        extentLogger.info("Logging in to the application");

        extentLogger.info("verifying title ");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders Login");

        extentLogger.info("save current url");
        String currentUrl = Driver.getDriver().getCurrentUrl();

        pages.webOrderTable().username.sendKeys("Test");
        pages.webOrderTable().password.sendKeys("Test");
        pages.webOrderTable().loginbutton.click();

        extentLogger.info("verifying title ");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders Login");

        extentLogger.info("verifying url");
        Assert.assertEquals(currentUrl, Driver.getDriver().getCurrentUrl());
        extentLogger.pass("test completed");

    }

    @Test
    public void test_3() {

        Driver.getDriver().get(ConfigrationReader.getProperty("url"));
        extentLogger=report.createTest("Negative Login Test Wrong Password");
        extentLogger.info("login to the application");

        extentLogger.info("verifying title ");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders Login");

        extentLogger.info("save current url");
        String currentUrl = Driver.getDriver().getCurrentUrl();

        pages.webOrderTable().username.sendKeys("Tester");
        pages.webOrderTable().password.sendKeys("Tester");
        pages.webOrderTable().loginbutton.click();

        extentLogger.info("verifying title ");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders Login");

        extentLogger.info("verifying url");
        Assert.assertEquals(currentUrl, Driver.getDriver().getCurrentUrl());
        extentLogger.pass("test completed");


    }

    @Test
    public void test_4() {

        Driver.getDriver().get(ConfigrationReader.getProperty("url"));
        extentLogger=report.createTest("Negative Login Test Blank username");
        extentLogger.info("login to the application");

        extentLogger.info("verifying title ");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders Login");

        extentLogger.info("save current url");
        String currentUrl = Driver.getDriver().getCurrentUrl();

        pages.webOrderTable().username.sendKeys("");
        pages.webOrderTable().password.sendKeys("test");
        pages.webOrderTable().loginbutton.click();

        extentLogger.info("verifying title ");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders Login");

        extentLogger.info("verifying url");
        Assert.assertEquals(currentUrl, Driver.getDriver().getCurrentUrl());
        extentLogger.pass("test completed");
    }

    @Test
    public void test_5() {
        Driver.getDriver().get(ConfigrationReader.getProperty("url"));
        extentLogger=report.createTest("Negative Login Test Blank Password");
        extentLogger.info("login to the application");

        extentLogger.info("verifying title ");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders Login");

        extentLogger.info("save current url");
        String currentUrl = Driver.getDriver().getCurrentUrl();

        pages.webOrderTable().username.sendKeys("Tester");
        pages.webOrderTable().password.sendKeys("");
        pages.webOrderTable().loginbutton.click();

        extentLogger.info("verifying title ");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders Login");

        extentLogger.info("verifying url");
        Assert.assertEquals(currentUrl, Driver.getDriver().getCurrentUrl());
        extentLogger.pass("test completed");
    }


}
