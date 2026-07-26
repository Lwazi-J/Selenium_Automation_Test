package firstTest;

import Pages.GoogleSearchObject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;

public class GoogleSearchPageTest {

    // This test opens Chrome once and reuses the same browser session for the test.
    static WebDriver driver = new ChromeDriver();

    // ExtentReports creates a readable HTML report after the test has finished.
    static ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public void setUp()
    {
        // Create the page object before the suite begins. A page object stores
        // page-specific locators and actions in one easy-to-read class.
        GoogleSearchObject gso = new GoogleSearchObject(driver);
    }

    @Test
    public void operation() throws Exception
    {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark1.html");
        extent.attachReporter(spark);

        driver.manage().window().maximize();
        GoogleSearchObject obj = new GoogleSearchObject(driver);

        extent.createTest("GoogleTest").log(Status.PASS, "Accessing page, and it passed!");

        // Open Google and capture the first screenshot.
        obj.getPage();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile,new File("ScreenShots/googlePic.png"));

        extent.createTest("GoogleTest").log(Status.PASS, "Searching, and it passed!");

        // Type text into the Google search box and capture a second screenshot.
        obj.putTextInSearchBox("Command Quality");
        Thread.sleep(1000);
        File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile1,new File("ScreenShots/searchPic.png"));

        extent.createTest("GoogleTest").log(Status.PASS, "Clicking, and it passed!");

        // Click the Google Search button and capture the result page.
        obj.clickSearchBox();
        Thread.sleep(5000);
        File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile2,new File("ScreenShots/clickPic.png"));
    }

    @AfterSuite
    public void done()
    {
        extent.createTest("GoogleTest").log(Status.PASS, "Closing the window, and it passed!");

        // quit() closes every browser window opened by this WebDriver session.
        driver.quit();
        System.out.println("Test completed");

        // Save the report to target/Spark1.html.
        extent.flush();
    }
}
