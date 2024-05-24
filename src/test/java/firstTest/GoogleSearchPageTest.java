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

    static WebDriver driver = new ChromeDriver();
    static ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public void setUp()
    {
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
        obj.getPage();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile,new File("C:\\Users\\ASUS\\SelenFirst\\ScreenShots\\googlePic.png"));

        extent.createTest("GoogleTest").log(Status.PASS, "Searching, and it passed!");
        obj.putTextInSearchBox("Command Quality");
        Thread.sleep(1000);
        File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile1,new File("C:\\Users\\ASUS\\SelenFirst\\ScreenShots\\searchPic.png"));

        extent.createTest("GoogleTest").log(Status.PASS, "Clicking, and it passed!");
        obj.clickSearchBox();
        Thread.sleep(5000);
        File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile2,new File("C:\\Users\\ASUS\\SelenFirst\\ScreenShots\\clickPic.png"));
    }

    @AfterSuite
    public void done()
    {
        extent.createTest("GoogleTest").log(Status.PASS, "Closing the window, and it passed!");
        driver.close();
        System.out.println("Test completed");
        extent.flush();
    }
}
