package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utility.SeleniumDriver;


public class AfterActions {
	@After
	public static void teardown(Scenario scenario) {

		
		       // Validate if the step actually failed
		       if (scenario.isFailed()) {
		           try {
		               // Cast driver to TakesScreenshot and capture the file as bytes
		               byte[] screenshot = ((TakesScreenshot)SeleniumDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
		               
		               // Embed the screenshot directly into the Cucumber report
		               scenario.attach(screenshot, "image/png", "Failed_Step_Screenshot");
		               
		               System.out.println("Screenshot captured for failed step: " + scenario.getName());
		           } catch (Exception e) {
		               System.err.println("Failed to capture screenshot: " + e.getMessage());
		           }
		       }
	}

}
