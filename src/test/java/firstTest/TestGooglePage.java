package firstTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.GooglePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestGooglePage {

    // WebDriver is Selenium's main browser controller. The test methods use this
    // object to open pages, find elements, type text, and click buttons.
    static WebDriver driver = null;

    // ExtentReports creates an HTML report that shows what happened during the test.
    static ExtentReports extent = new ExtentReports();

    @BeforeTest
    public void setUpTest()
    {
        // ChromeDriver starts a new Google Chrome browser session.
        driver = new ChromeDriver();
    }

    @Test
    public static void google() throws Exception
    {
        // The Spark reporter writes the test report into the target folder.
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark0.html");
        extent.attachReporter(spark);

        // Maximize the browser so students can clearly see what Selenium is doing.
        driver.manage().window().maximize();

        extent.createTest("GoogleTest").log(Status.PASS, "Accessing page, and it passed!");

        // Navigate to the Google home page.
        driver.get("https://www.google.co.uk/");

        extent.createTest("GoogleTest").log(Status.PASS, "Searching, and it passed!");

        // Use the GooglePage helper class to find the search box, then type text into it.
        GooglePage.textBoxSearch(driver).sendKeys("Command Quality");

        // Pause briefly so the page has time to show the typed search text.
        // In professional projects, explicit waits are usually better than Thread.sleep.
        Thread.sleep(1000);

        extent.createTest("GoogleTest").log(Status.PASS, "Clicking, and it passed!");

        // Use the GooglePage helper class again to find and click the search button.
        GooglePage.searchButton(driver).click();

        Thread.sleep(2000);
    }

    @AfterTest
    public void terminateTest(){
        extent.createTest("GoogleTest").log(Status.PASS, "Closing the window, and it passed!");

        // quit() closes the browser and ends the WebDriver session cleanly.
        driver.quit();
        System.out.println("Test completed");

        // flush() saves all report entries to the HTML file.
        extent.flush();
    }
}
