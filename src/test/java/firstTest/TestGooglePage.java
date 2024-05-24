package firstTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.GooglePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestGooglePage {

    static WebDriver driver = null;
    static ExtentReports extent = new ExtentReports();

    @BeforeTest
    public void setUpTest()
    {
        driver = new ChromeDriver();
    }

    @Test
    public static void google() throws Exception
    {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark0.html");
        extent.attachReporter(spark);

        driver.manage().window().maximize();

        extent.createTest("GoogleTest").log(Status.PASS, "Accessing page, and it passed!");

        //go to google.com
        driver.get("https://www.google.co.uk/");

        extent.createTest("GoogleTest").log(Status.PASS, "Searching, and it passed!");

        //enter text in the searchBox
        GooglePage.textBoxSearch(driver).sendKeys("Command Quality");

        //sleep till you find the button
        Thread.sleep(1000);

        extent.createTest("GoogleTest").log(Status.PASS, "Clicking, and it passed!");
        //click on the search button
        GooglePage.searchButton(driver).click();

        Thread.sleep(2000);
    }

    @AfterTest
    public void terminateTest(){
        extent.createTest("GoogleTest").log(Status.PASS, "Closing the window, and it passed!");
        driver.close();
        System.out.println("Test completed");
        extent.flush();
    }
}
