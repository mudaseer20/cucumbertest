package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {
	   public static WebDriver driver; 
    @Before(order=1)
	public void setup() {
     driver=new ChromeDriver();
 
	}
    @Before(order=0)
	public void setupone() {

    System.out.println("order ");
	}
    
    
    
    @After(order=1)
	public void teardown() {
		driver.quit();
	}
    
    @After(order=0)
	public void teardownone() {
		System.out.println("after order");
	}
    
    
    @BeforeAll
    public static void before_all() {
    	System.out.println("connect db");
    	
    }
    @AfterAll
   public static void after_all() {
	   	System.out.println("disconnect db");
    	
    }
    @BeforeStep
    public void beforestep() {
    	System.out.println("before step");
    	
    }
    @AfterStep
   public void takeScreenshotOnFailure(Scenario scenario) {
       // Validate if the step actually failed
       if (scenario.isFailed()) {
           try {
               // Cast driver to TakesScreenshot and capture the file as bytes
               final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
               
               // Embed the screenshot directly into the Cucumber report
               scenario.attach(screenshot, "image/png", "Failed_Step_Screenshot");
               
               System.out.println("Screenshot captured for failed step: " + scenario.getName());
           } catch (Exception e) {
               System.err.println("Failed to capture screenshot: " + e.getMessage());
           }
       }
   }
    	
    
    
}
