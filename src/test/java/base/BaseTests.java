package base;

import org.example.pages.AbstractPage;
import org.example.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {

    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeTest
    @Parameters({ "browser" })
    public void setUp(String browser) {
        switch (browser) {
            case "chrome": {
                driver = createChromeDriver();
                break;
            }
            case "firefox": {
                driver = createFirefoxDriver();
                break;
            }
            case "edge": {
                driver = createEdgeDriver();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }

        mainPage = new AbstractPage(driver).openMainPage();
    }

    private String getHubUrl() {
        return System.getenv("HUB_URL");
    }

    private WebDriver createChromeDriver() {
        ChromeOptions opts = new ChromeOptions();

        try {
            return new RemoteWebDriver(
                    new URL(getHubUrl()),
                    opts
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private WebDriver createFirefoxDriver() {
        FirefoxOptions opts = new FirefoxOptions();

        try {
            return new RemoteWebDriver(
                    new URL(getHubUrl()),
                    opts
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private WebDriver createEdgeDriver() {
        EdgeOptions opts = new EdgeOptions();

        try {
            return new RemoteWebDriver(
                    new URL(getHubUrl()),
                    opts
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
