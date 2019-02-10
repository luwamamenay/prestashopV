package com.prestashopV.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;
import com.prestashopV.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    protected WebElement element;
    protected Faker fake;
    protected Actions actions;
    protected Random random;
    protected HomePage1 homePage;
    protected LogIn logIn;
    protected Personalinformation personalinformation;
    protected Messages messages;
    protected Iframe iframe;
    protected  Cart cart;
    protected  Buttons buttons;
    protected  static ExtentReports report;
    private static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;
    protected Pages pages;



    public static void verifyTextMatches(String s1, String s2){
        Assert.assertTrue(s1.equals(s2));

    }

    public static void verifyTextContains(String s1 , String s2){

        Assert.assertTrue(s1.contains(s2));
    }




    @BeforeMethod
    public void openBrowser(){
        driver =Driver.getDriver();
        Driver.getDriver().get(ConfigrationReader.getProperty("url"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        fake = new Faker();
        actions = new Actions(driver);
        random = new Random();
        homePage =new HomePage1();
        logIn = new LogIn();
        personalinformation = new Personalinformation();
        messages = new Messages();
        iframe = new Iframe();
        cart = new Cart();
        buttons=new Buttons();
        pages = new Pages();

    }





    @AfterMethod




    public void tearDownMethod(ITestResult result) throws IOException {


        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotLocation = BrowserUtils.getScreenshot(result.getName());
            extentLogger.fail(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotLocation);
            extentLogger.fail(result.getThrowable());

        } else if (result.getStatus() == ITestResult.SKIP) {
            extentLogger.skip("Test Case Skipped: " + result.getName());
        }
          Driver.closeDriver();
    }


    @BeforeTest
    public void setUpTest() {
        report = new ExtentReports();

        String filePath = System.getProperty("user.dir") + "/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(filePath);
        report.attachReporter(htmlReporter);

        report.setSystemInfo("Environment", "Staging");
        report.setSystemInfo("Browser", ConfigrationReader.getProperty("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));

        report.setSystemInfo("QA Engineer", "Luwam Amenay");

        htmlReporter.config().setDocumentTitle("Prestashop Reports");
        htmlReporter.config().setReportName("Prestashop Automated Test Reports");

//        htmlReporter.config().setTheme(Theme.DARK);

    }




    public static void clickMe(WebDriver driver, String xpath){
        Actions  actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(xpath))).click().perform();

    }
    public static int randomNumber(int start, int end) {

        return start + (int) (Math.random() * (end - start + 1));
    }




    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        report.flush();
    }
}




