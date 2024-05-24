import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.List;

public class BrowserTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Navigate to a website
        driver.get("https://www.google.co.uk/");
        WebElement textBox = driver.findElement(By.id("APjFqb"));
        textBox.sendKeys("Command Quality");

        List<WebElement> listWebElements = Collections.singletonList(driver.findElement(By.xpath("//input")));
        int count = listWebElements.size();

        System.out.println("Input elements are " + count);

        // Close the browser
        //driver.quit();
    }
}