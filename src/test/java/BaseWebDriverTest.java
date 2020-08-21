import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public abstract class BaseWebDriverTest {

    public enum DriverType {
        CHROME, HEADLESS_CHROME, FIREFOX
    }

    protected static WebDriver driver;
    protected static DriverType driverType = DriverType.CHROME;
    protected final static String CHROME_PATH = "src/webdrivers/chromedriver";
    protected final static String FIREFOX_PATH = "src/webdrivers/geckodriver";
    protected static DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeClass
    public static void prepareDriver( ) throws Exception {
        ChromeOptions chromeOptions;

        switch (driverType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", CHROME_PATH);
                chromeOptions = new ChromeOptions().merge(capabilities);
                driver = new ChromeDriver(chromeOptions);
                break;
            case HEADLESS_CHROME:
                System.setProperty("webdriver.chrome.driver", CHROME_PATH);
                chromeOptions = new ChromeOptions().merge(capabilities).addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);
                capabilities.setBrowserName(BrowserType.FIREFOX);
                driver = new FirefoxDriver(new FirefoxOptions(capabilities));
                break;
        }
    }

    @AfterClass
    public static void cleanup( ) {
        driver.quit();
    }

    protected void verifySelectOptions(Select select, String... optionNames) {
        List<WebElement> options = select.getOptions();
        assertEquals("Options", optionNames.length, options.size());
        for (int i = 0; i < optionNames.length; i++) {
            assertEquals("Wrong option text", optionNames[i], options.get(i).getText().trim());
        }
    }

    protected String generateEmail(){
        int i = (int) (Math.random()*((1000-10)+1))+10;
        String randomString = "randomstring"+i+"@mailinator.com";
        return randomString;
    }

    protected boolean isElementDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
