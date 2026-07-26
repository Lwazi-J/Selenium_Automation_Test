import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collections;
import java.util.List;

public class BrowserTest {
    public static void main(String[] args) {

        // Create a Chrome browser controlled by Selenium.
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window so the automated steps are easy to see.
        driver.manage().window().maximize();

        // Navigate to Google.
        driver.get("https://www.google.co.uk/");

        // Find the search text box and type a search phrase into it.
        WebElement textBox = driver.findElement(By.name("q"));
        textBox.sendKeys("Command Quality");

        // This example finds one input element and prints the number found.
        // A real test would usually assert an expected result instead of only printing.
        List<WebElement> listWebElements = Collections.singletonList(driver.findElement(By.xpath("//input")));
        int count = listWebElements.size();

        System.out.println("Input elements are " + count);

        // Close Chrome and end the WebDriver session.
        driver.quit();
    }
}
