# Selenium Automation Test Lesson

This project is a beginner-friendly Selenium WebDriver lesson written in Java. It shows students how an automated test can open a real browser, visit Google, type into a search box, click a button, take screenshots, and create an HTML test report.

The main goal is to understand the basic flow of browser automation:

1. Start a browser with Selenium WebDriver.
2. Navigate to a web page.
3. Find elements on the page.
4. Interact with those elements.
5. Capture evidence with screenshots and reports.
6. Close the browser correctly.

## What This Project Does

The tests automate this simple Google search journey:

1. Open Google Chrome.
2. Go to `https://www.google.co.uk/`.
3. Type `Command Quality` into the search box.
4. Click the Google Search button.
5. Save screenshots in the `ScreenShots` folder.
6. Save an ExtentReports HTML report in the `target` folder.

## Project Structure

```text
Selenium_Automation_Test
|-- Drivers
|   |-- chromeDriver
|   |   `-- chromedriver.exe
|   `-- geckodriver
|       `-- geckodriver.exe
|-- ScreenShots
|   |-- clickPic.png
|   |-- googlePic.png
|   `-- searchPic.png
|-- src
|   |-- main
|   |   `-- java/org/example/Main.java
|   `-- test
|       `-- java
|           |-- BrowserTest.java
|           |-- Pages
|           |   |-- GooglePage.java
|           |   `-- GoogleSearchObject.java
|           `-- firstTest
|               |-- TestGooglePage.java
|               `-- GoogleSearchPageTest.java
`-- pom.xml
```

## Important Files

### `pom.xml`

This is the Maven configuration file. Maven uses it to download and manage the libraries used by the project.

The project uses these main dependencies:

- `selenium-java`: controls the browser.
- `testng`: runs the automated tests.
- `commons-io`: helps copy screenshot files.
- `extentreports`: creates HTML reports for the test results.

### `GoogleSearchObject.java`

This is a page object. A page object is a class that stores the locators and actions for one page.

In this project, it stores actions such as:

- opening Google,
- typing into the search box,
- clicking the search button.

This makes the test class cleaner because the test can say what it wants to do, while the page object handles how to do it.

### `GoogleSearchPageTest.java`

This is the main TestNG test class. It uses Selenium to control Chrome, uses the page object to interact with Google, takes screenshots, and writes a report.

### `TestGooglePage.java`

This is another version of the same lesson. It uses a simpler helper class called `GooglePage` instead of a full page object.

### `BrowserTest.java`

This is a standalone Java class with a `main` method. It demonstrates Selenium without using TestNG.

## Software Students Need To Install

Before running the project, students need these tools installed.

### 1. Java JDK

Install Java JDK 19 or newer. This project is configured to compile with Java 19.

Check that Java is installed:

```powershell
java -version
```

You should see a Java version printed in the terminal.

### 2. Apache Maven

Maven downloads the project dependencies and runs the tests.

Check that Maven is installed:

```powershell
mvn -version
```

You should see the Maven version and Java version printed in the terminal.

### 3. Google Chrome

The tests use `ChromeDriver`, so Google Chrome must be installed.

Selenium 4 can often manage the correct browser driver automatically. This project also includes a `Drivers/chromeDriver/chromedriver.exe` file for teaching purposes.

### 4. An IDE

Students can use any Java IDE, for example:

- IntelliJ IDEA
- Eclipse
- Visual Studio Code with Java extensions

## How To Open The Project

1. Open your IDE.
2. Choose **Open Project**.
3. Select the `Selenium_Automation_Test` folder.
4. Wait for Maven to import the project.
5. If the IDE asks to load Maven changes, accept it.

## How To Download Dependencies

From the project root folder, run:

```powershell
mvn dependency:resolve
```

Maven will read `pom.xml` and download the required libraries.

You can also run:

```powershell
mvn clean test
```

This will download dependencies if needed and then run the tests.

## How To Run The Tests From The Terminal

Open a terminal in the project root folder:

```powershell
cd C:\agentic_work\Selenium_Automation_Test
```

Run all tests:

```powershell
mvn test
```

Run one specific test class:

```powershell
mvn -Dtest=GoogleSearchPageTest test
```

Run the simpler helper-class example:

```powershell
mvn -Dtest=TestGooglePage test
```

## How To Run From The IDE

1. Open `src/test/java/firstTest/GoogleSearchPageTest.java`.
2. Right-click inside the file.
3. Select **Run GoogleSearchPageTest**.
4. Watch Chrome open and perform the search.
5. After the test finishes, check the screenshots and report files.

## Where To Find The Output

Screenshots are saved here:

```text
ScreenShots/googlePic.png
ScreenShots/searchPic.png
ScreenShots/clickPic.png
```

ExtentReports output is saved here:

```text
target/Spark0.html
target/Spark1.html
```

Open the `.html` files in a browser to view the test report.

## Teaching Notes

Use this project to explain the following Selenium concepts.

### WebDriver

`WebDriver` is the main Selenium object. It represents the browser session.

Example:

```java
WebDriver driver = new ChromeDriver();
```

This line opens a new Chrome browser controlled by Selenium.

### Locators

Locators tell Selenium how to find elements on a page.

Example:

```java
By textBox = By.name("q");
```

This tells Selenium to find the element whose `name` attribute is `q`.

### Actions

After Selenium finds an element, it can interact with it.

Example:

```java
driver.findElement(textBox).sendKeys("Command Quality");
```

This finds the search box and types text into it.

### TestNG Annotations

TestNG annotations control when methods run.

- `@BeforeSuite`: runs before the whole test suite.
- `@BeforeTest`: runs before a test.
- `@Test`: marks the actual test method.
- `@AfterTest`: runs after a test.
- `@AfterSuite`: runs after the whole suite.

### Screenshots

Selenium can take screenshots of the browser.

Example:

```java
File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
```

The project then copies that screenshot into the `ScreenShots` folder.

### Reports

ExtentReports creates an HTML report that students can open after the test finishes.

Example:

```java
ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark1.html");
extent.attachReporter(spark);
```

## Common Problems And Fixes

### Chrome Opens But The Test Fails

Google changes its page often. If the search button or search box cannot be found, the locator may need to be updated.

The search box currently uses:

```java
By.name("q")
```

This is usually more stable than using a generated-looking ID.

### Maven Cannot Find Dependencies

Make sure the computer has internet access, then run:

```powershell
mvn clean test
```

### Browser Does Not Open

Check that Google Chrome is installed:

```powershell
chrome --version
```

If that command does not work, open Chrome normally and check the installed version from Chrome settings.

### Test Runs Too Fast

This project uses `Thread.sleep(...)` to make the lesson easier to follow. In real automation projects, explicit waits are better because they wait for a specific condition instead of waiting for a fixed number of seconds.

## Suggested Lesson Flow

1. Show students the `pom.xml` file and explain dependencies.
2. Open `GoogleSearchObject.java` and explain locators.
3. Open `GoogleSearchPageTest.java` and explain the test flow.
4. Run `mvn test` or run the test from the IDE.
5. Show the screenshots in the `ScreenShots` folder.
6. Open the ExtentReports HTML file in the `target` folder.
7. Ask students to change the search text and run the test again.

## Student Exercise Ideas

- Change the search text from `Command Quality` to your own name.
- Add one more screenshot after the page loads.
- Change the test to search for a different website.
- Add an assertion that checks the page title after the search.
- Replace `Thread.sleep(...)` with an explicit Selenium wait.
