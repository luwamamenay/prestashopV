package com.prestashopV.tests.smoke_tests;

import com.prestashopV.utilities.ConfigrationReader;
import com.prestashopV.utilities.Driver;
import com.prestashopV.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Productinformation extends TestBase {


    @Test
    public void product() {

        Driver.getDriver().get(ConfigrationReader.getProperty("url"));


        extentLogger = report.createTest("prstashop product information");
        extentLogger.info("Logging in to the application");


        extentLogger.info("Click on any HomePage1");
        String productnamebeforeclick = pages.homePage1().productnameonhomepage.getAttribute("innerText");
        String priceonhomepage = pages.homePage1().priceBeforeClick.getAttribute("innerText");
        System.out.println(priceonhomepage);


        pages.homePage1().product.click();

        String productnameaferclick = homePage.productnameAfterhomepage.getAttribute("innerText");
        String priceafterhomepage = homePage.priceAfterClick.getAttribute("innerText");
        extentLogger.info("verify product name is the same before and after click");
        Assert.assertEquals(productnamebeforeclick, productnameaferclick);
        extentLogger.info("verify price name is the same before and after click");
        Assert.assertEquals(priceonhomepage, priceafterhomepage);
        extentLogger.pass("test completed sucessfully");


    }


}