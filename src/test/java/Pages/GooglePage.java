package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

    public static WebElement textBoxSearch(WebDriver driver)
    {
        WebElement element = driver.findElement(By.name("q"));
        return element;
    }

    public static WebElement searchButton(WebDriver driver)
    {
        WebElement element = driver.findElement(By.name("btnK"));
        return element;
    }
}
