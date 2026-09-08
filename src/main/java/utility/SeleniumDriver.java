package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver {
	public static WebDriver driver;
	public static  SeleniumDriver seleniumdriver;
	
	public static WebDriverWait waitdriver;
	public final static int TIMEOUT=30;
	public final static int PAGE_LOAD_TIMEOUT=30;
	
	private SeleniumDriver() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	public static void openpage(String url) {
		driver.get(url);
	}
	public static WebDriver getDriver() {
		return driver;
		
		
	}
public static void setupDriver() {
	if(driver==null) {
	 seleniumdriver = new SeleniumDriver();
	}
}

public static void teardown() {
	if(driver!=null) {
		driver.close();
	}
	seleniumdriver=null;
}
}
