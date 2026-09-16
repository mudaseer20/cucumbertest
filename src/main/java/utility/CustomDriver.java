package utility;

import org.openqa.selenium.WebElement;

public class CustomDriver {
	
	public void elementClick(WebElement element,String info) {
		try {
			element.click();
		}
		catch(Exception e) {
			
		}
	}

}
