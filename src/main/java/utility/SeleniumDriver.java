package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver {

    public static WebDriver driver;
    public static SeleniumDriver seleniumdriver;

    public static WebDriverWait waitdriver;

    public static final int TIMEOUT = 30;
    public static final int PAGE_LOAD_TIMEOUT = 30;

    private SeleniumDriver() {

        ChromeOptions options = new ChromeOptions();

        // Required/recommended for Linux CI environment
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        // Consistent browser size in headless mode
        options.addArguments("--window-size=1920,1080");

        // Chrome installed on your runner
        options.setBinary("/usr/bin/google-chrome");

        driver = new ChromeDriver(options);

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(15));

        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));

        waitdriver = new WebDriverWait(
                driver,
                Duration.ofSeconds(TIMEOUT)
        );

        System.out.println("Chrome browser started successfully");
    }

    public static void openpage(String url) {
        if (driver == null) {
            setupDriver();
        }

        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setupDriver() {
        if (driver == null) {
            seleniumdriver = new SeleniumDriver();
        }
    }

    public static void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

        seleniumdriver = null;
        waitdriver = null;
    }
}
