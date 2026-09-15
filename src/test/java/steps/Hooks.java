package steps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {

    public static WebDriver driver;

    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    static Scenario scenario;

    @BeforeAll
    public static void before_all() {
        System.out.println("connect db");
    }

    @Before(order = 0)
    public void setupone(Scenario scenario) {
        Hooks.scenario = scenario;
        System.out.println("Scenario: " + scenario.getName());
    }

    @Before(order = 1)
    public void setup() {

        ChromeOptions options = new ChromeOptions();

        // Required/recommended for Linux CI runners
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        // Optional but useful for consistent screenshots
        options.addArguments("--window-size=1920,1080");

        // Explicitly use the Chrome installed on the runner
        options.setBinary("/usr/bin/google-chrome");

        driver = new ChromeDriver(options);

        System.out.println("Chrome browser started successfully");
    }

    @BeforeStep
    public void beforestep() {
        String startTime = LocalDateTime.now().format(formatter);

        if (scenario != null) {
            scenario.log("Scenario Started At: " + startTime);
        }
    }

    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed() && driver != null) {

            try {
                byte[] screenshot =
                        ((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.BYTES);

                scenario.attach(
                        screenshot,
                        "image/png",
                        "Failed_Step_Screenshot"
                );

                System.out.println(
                        "Screenshot captured for failed step: "
                                + scenario.getName()
                );

            } catch (Exception e) {
                System.err.println(
                        "Failed to capture screenshot: "
                                + e.getMessage()
                );
            }
        }
    }

    @After(order = 1)
    public void teardown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @After(order = 0)
    public void teardownone() {
        System.out.println("after order");
    }

    @AfterAll
    public static void after_all() {
        System.out.println("disconnect db");
    }
}
