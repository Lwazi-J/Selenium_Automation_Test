package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

    public static WebElement textBoxSearch(WebDriver driver)
    {
        // Locate the Google search input by its name attribute.
        // Selenium returns the matching element so the test can type into it.
        WebElement element = driver.findElement(By.name("q"));
        return element;
    }

    public static WebElement searchButton(WebDriver driver)
    {
        // Locate the Google Search button by its name attribute.
        WebElement element = driver.findElement(By.name("btnK"));
        return element;
    }
}
