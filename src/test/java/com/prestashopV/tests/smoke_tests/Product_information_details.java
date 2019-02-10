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

public  class Product_information_details extends TestBase {


    @Test
    public void cart() throws InterruptedException {
        Driver.getDriver().get(ConfigrationReader.getProperty("url"));

        extentLogger = report.createTest("Product_information_details");
        extentLogger.info("Logging in to the application");


        pages.homePage1().product.click();

        extentLogger.info("verify if quantiti is selected");

        pages.homePage1().quantity.isSelected();

        extentLogger.info("verify if that default quantity is 1");
        Assert.assertEquals(pages.homePage1().quantity.getAttribute("value"), "1");


        extentLogger.info("Verify that size is selcted");
        pages.homePage1().size.isSelected();

        extentLogger.info("Verify that defaultsize is S");
        Select select = new Select(pages.homePage1().size);
        Assert.assertEquals("S", select.getFirstSelectedOption().getText());

        extentLogger.info("Verify that size options are S, M, L");

        List<String> actualSizes = new ArrayList<String>();
        actualSizes.add("S");
        actualSizes.add("M");
        actualSizes.add("L");

        List<WebElement> expectedSizes = select.getOptions();
        for (int i = 0; i < expectedSizes.size(); i++) {
            System.out.println("expected" + expectedSizes.get(i).getText() + "actual" + actualSizes.get(i));
        }

        extentLogger.info("clicking on add cart");
        pages.cart().cart.click();


        extentLogger.info("Verify confirmation message “Product successfully added to your shopping cart");
        String expectedMessage = "Product successfully added to your shopping cart";
        pages.messages().confirmationmessage.click();
        pages.messages().confirmationmessage.getText();
        Assert.assertEquals(pages.messages().confirmationmessage.getText(), expectedMessage);


        extentLogger.info("verifing  default quantity is 1");
        String defaultquantity = "1";
        Assert.assertEquals(pages.homePage1().quantityAfterAddtoCart.getText(), defaultquantity);


        //10.verify that default size is S
        extentLogger.info("verify that default size is S");
        String defaultSize = "S";
        String sizeAfterAdding = pages.homePage1().sizeafterAddtoCart.getText();
        Assert.assertEquals(sizeAfterAdding.substring(sizeAfterAdding.indexOf(" ")).trim(), defaultSize);



        extentLogger.info("Verify that same name and price displayed as on the home page");
        String priceAtCart = pages.homePage1().priceafterAddintcart.getAttribute("innerText");
        String nameAtCart = pages.homePage1().nameAfterAddingcart.getAttribute("innerText");

        pages.buttons().continuShopping.click();

        String priceBacktoCart = homePage.priceAfterClick.getAttribute("innerText");
        String nameBacktoCart = homePage.productnameAfterhomepage.getAttribute("innerText");

        extentLogger.info("price is the same before and after adding cart");
        Assert.assertEquals(priceAtCart, priceBacktoCart);

        extentLogger.info("name is the same before and after adding to cart ");
        Assert.assertEquals(nameBacktoCart, nameAtCart);

        extentLogger.pass("test complted sucessfully");


    }
}
