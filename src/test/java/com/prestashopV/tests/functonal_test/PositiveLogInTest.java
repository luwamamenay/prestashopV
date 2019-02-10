package com.prestashopV.tests.functonal_test;

import com.prestashopV.pages.LogIn;
import com.prestashopV.pages.WebOrderTable;
import com.prestashopV.utilities.ConfigrationReader;
import com.prestashopV.utilities.Driver;
import com.prestashopV.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PositiveLogInTest extends TestBase {


    WebOrderTable webOrderTable = new WebOrderTable();

    @Test
    public void test() {

        Driver.getDriver().get(ConfigrationReader.getProperty("url"));
        extentLogger = report.createTest("Postive Login test");
        extentLogger.info("Logging in to the application");



        extentLogger.info("verify title equals to Web Order Login");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders Login");


        extentLogger.info("eneter user name Tester");
        pages.webOrderTable().username.sendKeys("Tester");

        extentLogger.info("enter password test");
        pages.webOrderTable().password.sendKeys("test");

        extentLogger.info("clicki on the button");
        pages.webOrderTable().loginbutton.click();


        extentLogger.info("verify title equals Web order");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders");

        extentLogger.info("verify url  is equals  to current url");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        extentLogger.pass("test completed");

    }

}