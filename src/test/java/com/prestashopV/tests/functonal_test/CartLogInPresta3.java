package com.prestashopV.tests.functonal_test;

import com.prestashopV.utilities.BrowserUtils;
import com.prestashopV.utilities.ConfigrationReader;
import com.prestashopV.utilities.Driver;
import com.prestashopV.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.prestashopV.pages.*;

import java.util.concurrent.TimeUnit;

public class CartLogInPresta3 extends TestBase {


    @Test

    public void cartlogin() {


        Driver.getDriver().get(ConfigrationReader.getProperty("url"));
        extentLogger = report.createTest("Cart LoginTest");
        extentLogger.info("clicking on product");
        pages.homePage1().product.click();

        extentLogger.info("clicking on the cart");
        pages.cart().cart.click();

        extentLogger.info("saving the product name ");
        BrowserUtils.wait(3);
        String productName = homePage.productName.getAttribute("innerText").trim();

        extentLogger.info("clicking on the continue to shopping button");
        pages.buttons().continuShopping.click();

        extentLogger.info("hovering over to the cart");
        actions.moveToElement(cart.hoveroverCart).perform();

        extentLogger.info("saving the product name on the cart");
        String cartName = pages.homePage1().nameOfproduct.getAttribute("title").trim();

        extentLogger.info("verifing that cart contains the product name");
        Assert.assertTrue(productName.equals(cartName));

        extentLogger.info("loggging in with valid account");
        pages.login().signingIn.click();
        pages.login().email.sendKeys("lu@gmail.com");
        pages.login().password.sendKeys("password");
        pages.login().submitlogin.click();

        BrowserUtils.wait(3);

        extentLogger.info("Hover over to the cart");
        actions.moveToElement(cart.hoveroverCart).perform();

        extentLogger.info("save the name on the cart");
        String cartNamee = pages.homePage1().nameOfproduct.getAttribute("title").trim();


        extentLogger.info("verifying if the product name matches with the name on the cart");
        Assert.assertTrue(productName.equals(cartNamee));

    }

    @Test
    public void cartLogOut() {

        extentLogger = report.createTest("Cart LogoutTest");
        extentLogger.info("Loging in to the application");
        pages.login().signingIn.click();
        pages.login().email.sendKeys("lu@gmail.com");
        pages.login().password.sendKeys("password");
        pages.login().submitlogin.click();


        extentLogger.info("clicking back to home button");
        pages.homePage1().backtohomepage.click();

        extentLogger.info("clicking on the second product");
        pages.homePage1().product2.click();

        extentLogger.info("switching the iframe");
        pages.iframe().switchFrame(driver);

        extentLogger.info("clicking on the cart");
        pages.cart().cart.click();

        BrowserUtils.wait(3);
        extentLogger.info("saving the product name");
        String productName = pages.homePage1().productName.getAttribute("innerText").trim();

        extentLogger.info("clcicking on the contiune shopping button");
        pages.buttons().continuShopping.click();

        extentLogger.info("hover over the cart");
        actions.moveToElement(cart.hoveroverCart).perform();

        extentLogger.info("saving the product name on the cart");
        String cartName = homePage.nameOfproduct.getAttribute("title").trim();

        extentLogger.info("verifing product name is matching with the name on cart");
        Assert.assertTrue(productName.equals(cartName));

        extentLogger.info("sigingng out from the page ");
        pages.login().signOut.click();

        extentLogger.info(" verify message empty is displayed");
        messages.empty.isDisplayed();


    }


    @Test
    public void cartIconDelete() {

        extentLogger = report.createTest("Cart Icon DeleteTest");
        extentLogger.info("clicking on the second product");
        pages.homePage1().product2.click();

        extentLogger.info("switching iframe");
        pages.iframe().switchFrame(driver);

        extentLogger.info("clicking on the cart");
        pages.cart().cart.click();
        BrowserUtils.wait(3);

        extentLogger.info("saving product name");
        String productName = pages.homePage1().productName.getAttribute("innerText").trim();

        extentLogger.info("clciking on continue shopping button");
        pages.buttons().continuShopping.click();

        extentLogger.info("hover over the cart");
        actions.moveToElement(cart.hoveroverCart).perform();

        extentLogger.info("clicking the X to delete the product");
        pages.homePage1().clickTheXtodeleproduct.click();

        extentLogger.info("verifing the  empty is displayed");
        pages.messages().empty.isDisplayed();

    }


    @Test
    public void CartCheckoutDeleteTest() {

        extentLogger = report.createTest("Cart Checkout DeleteTest");
        extentLogger.info("clicking on product");

        pages.homePage1().product.click();


        extentLogger.info("hover over to the cart");
        actions.moveToElement(cart.hoveroverCart).perform();
        actions.moveToElement(cart.cart).click().perform();

        extentLogger.info("clicking on continue to shopping");
        BrowserUtils.wait(3);
        pages.buttons().continuShopping.click();

        extentLogger.info("navigating back to the home page");
        driver.navigate().back();


        extentLogger.info("clicking on the second product");
        pages.homePage1().product2.click();

        extentLogger.info("switching iframes");
        pages.iframe().switchFrame(driver);

        extentLogger.info("clicking on cart");
        pages.cart().cart.click();

        BrowserUtils.wait(3);
        extentLogger.info("clicking on procced to check out button");
        pages.buttons().proceedToCheckout_button.click();

        extentLogger.info("saving the product number");
        String pronumber = driver.findElement(By.xpath("//span[@class='heading-counter']")).getText();

        extentLogger.info("chcecking of the cart contains the same product number with the message");
        Assert.assertTrue(pronumber.equals("Your shopping cart contains: 2 Products"));


        extentLogger.info("hover over to cart");
        actions.moveToElement(cart.hoveroverCart).perform();

        extentLogger.info("deleting one product from the cart");
        pages.homePage1().deleteProduct1.click();


        BrowserUtils.wait(3);
        extentLogger.info("saving the product number in the cart");
        String pronum = driver.findElement(By.xpath("//div[@id='center_column']/h1/span")).getAttribute("innerText").trim();

        extentLogger.info("checking if the message matches with the number of product the cart contains");
        Assert.assertTrue(pronum.equals("Your shopping cart contains: 1 Product"));


        extentLogger.info("hover over to the cart");
       // actions.moveToElement(cart.hoveroverCart).perform();
        actions.moveToElement(cart.hoveroverCart).perform();

        extentLogger.info("deleteing the second product from the cart");

        pages.homePage1().deleteProduct2.click();


        BrowserUtils.wait(3);
        extentLogger.info("saving the message on the cart");
        String empty = driver.findElement(By.xpath("//p[@class='alert alert-warning']")).getAttribute("innerText");

        extentLogger.info("verifing if cart is empty");
        Assert.assertTrue(empty.equals("Your shopping cart is empty."));


    }

}