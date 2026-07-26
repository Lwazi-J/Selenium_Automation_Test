package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchObject {
    WebDriver driver = null;

    // Locators describe how Selenium can find elements on the web page.
    // Keeping them here makes the test class cleaner and easier to read.
    By textBox = By.name("q");
    By buttonSearch = By.name("btnK");

    public GoogleSearchObject(WebDriver driver)
    {
        // Store the browser session so every method in this page object can use it.
        this.driver = driver;
    }

    public void putTextInSearchBox(String text)
    {
        // Find the search box and type the text provided by the test.
        driver.findElement(textBox).sendKeys(text);
    }

    public void clickSearchBox()
    {
        // Find and click the Google Search button.
        driver.findElement(buttonSearch).click();
    }

    public void getPage()
    {
        // Open the page that this page object represents.
        driver.get("https://www.google.co.uk/");
    }
}
