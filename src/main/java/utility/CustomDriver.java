package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomDriver {
	
	public void elementClick(WebElement element,String info) {
		try {
			element.click();
		}
		catch(Exception e) {
			
		}
	}
    public void sendData(WebElement element, String data, String info, Boolean clear) {
        try {
            if (clear) {
                element.clear();
            }
            //Util.sleep(1000, "Waiting Before Entering Data");
            element.sendKeys(data);
        
        } catch (Exception e) {
        
        }
    }
    
    public By getByType(String locator) {
        By by = null;
        String locatorType = locator.split("=>")[0];
        locator = locator.split("=>")[1];
        try {
            if (locatorType.contains("id")) {
                by = By.id(locator);
            } else if (locatorType.contains("name")) {
                by = By.name(locator);
            } else if (locatorType.contains("xpath")) {
                by = By.xpath(locator);
            } else if (locatorType.contains("css")) {
                by = By.cssSelector(locator);
            } else if (locatorType.contains("class")) {
                by = By.className(locator);
            } else if (locatorType.contains("tag")) {
                by = By.tagName(locator);
            } else if (locatorType.contains("link")) {
                by = By.linkText(locator);
            } else if (locatorType.contains("partiallink")) {
                by = By.partialLinkText(locator);
            } else {
               System.out.println("Locator type not supported");
            }
        } catch (Exception e) {
           System.out.println("By type not found with: " + locatorType);
        }
        return by;
    }

}
