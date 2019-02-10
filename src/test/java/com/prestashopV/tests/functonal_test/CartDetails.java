package com.prestashopV.tests.functonal_test;

import com.prestashopV.utilities.ConfigrationReader;
import com.prestashopV.utilities.Driver;
import com.prestashopV.utilities.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CartDetails extends TestBase {


    @Test
    public void cart() {
        Driver.getDriver().get(ConfigrationReader.getProperty("url"));

        extentLogger = report.createTest("getting the cart details");
        extentLogger.info("clicking on product - printed detess");
        pages.homePage1().product.click();

        extentLogger.info("entering random number of quantities between 1-5");


        String ranNum = randomNumber(1, 5) + "";
        pages.homePage1().quantity.sendKeys(ranNum);

       extentLogger.info("selecting the size options randomly");
        Select sizes = new Select(homePage.size);
        sizes.selectByIndex(randomNumber(0, 2));

        extentLogger.info("clicking on the cart");
        pages.cart().cart.click();

        extentLogger.info("verifying Product successfully added to your shopping cart ");
        String expected = "Product successfully added to your shopping cart";
        Assert.assertEquals(pages.messages().confirmationmessage.getAttribute("innerText").trim(), expected);

        extentLogger.info("clicking on X button to close the pop up");
        pages.buttons().clickOnXicon.click();

        extentLogger.info("clicking on the company logo");
        pages.buttons().companylogo.click();
        extentLogger.pass("test complated");

    }

    @Test
    public void productOnsale() {

        Driver.getDriver().get(ConfigrationReader.getProperty("url"));

        extentLogger = report.createTest("selcting product which is on sale ");
        extentLogger.info("clicking on the product on sale ");
        pages.homePage1().productOnSale.click();


        extentLogger.info("switching the iframe");
        pages.iframe().switchFrame(driver);

        extentLogger.info("clearing the quantity");
        pages.homePage1().quantity.clear();

        extentLogger.info("pick number randomly the quantity");
        String ranNum = randomNumber(1, 5) + "";
        pages.homePage1().quantity.sendKeys(ranNum);

        extentLogger.info("selcting the size randomly");
        Select sizes = new Select(homePage.size);
        sizes.selectByIndex(randomNumber(0, 2));

        extentLogger.info("clicking on the cart");
        pages.cart().cart.click();


        extentLogger.info("veryfing Product successfully added to your shopping cart");
        String expected = "Product successfully added to your shopping cart";
        Assert.assertEquals(pages.messages().confirmationmessage.getAttribute("innerText").trim(), expected);

        extentLogger.info("hovering over  in the cart");
        actions.moveToElement(pages.cart().hoveroverCart).perform();

        extentLogger.info("Displaying the total number of products displayed");
        pages.homePage1().totalIsDisplayed.getAttribute("innerText");

        extentLogger.info("veriyfing total price displayed includes shipping fees according to the num of products");


        String totalPrice = pages.homePage1().priceafterAddintcart.getAttribute("innerText").replace("$", "");
        Double totalPriceInt = Double.parseDouble(totalPrice);



        String shipping = pages.homePage1().shippingFee.getAttribute("innerText").replace("$", "");
        Double shippingInt = Double.parseDouble(shipping);


        Double total= totalPriceInt +shippingInt;

        String theTotalPriceDisplayed = pages.homePage1().finalTotalPrice.getAttribute("innerText").replace("$", "");
        Double finalTotal = Double.parseDouble(theTotalPriceDisplayed);

        extentLogger.info("verifying if total price plus shippin is equal to the final price displayed");
        Assert.assertEquals(total,finalTotal);

       extentLogger.pass("test completed");

    }


}
