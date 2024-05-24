package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchObject {
    WebDriver driver = null;

    By textBox = By.id("APjFqb");
    By buttonSearch = By.name("btnK");

    public GoogleSearchObject(WebDriver driver)
    {
        this.driver = driver;
    }

    public void putTextInSearchBox(String text)
    {
        driver.findElement(textBox).sendKeys(text);
    }

    public void clickSearchBox()
    {
        driver.findElement(buttonSearch).click();
    }

    public void getPage()
    {
        driver.get("https://www.google.co.uk/");
    }
}
