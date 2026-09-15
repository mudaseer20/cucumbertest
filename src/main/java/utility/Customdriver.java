package utility;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import utility.SeleniumDriver;
public class Customdriver {
	
    private static final Logger log = LogManager.getLogger(Customdriver.class.getName());
	
	
	public void elementclick(WebElement element,String info,long timetowait) {
		try {
			element.click();
			System.out.println("clicked on"+element.getText());
			log.info("clicked on "+element.getText());
		}
		catch(Exception e) {
			
		}
	}
	public String gettitle() {
		String title=SeleniumDriver.getDriver().getTitle();
		log.info(title+"is the title");
		return title;
		
	}
	public void elementclick(WebElement element,String info) {
		elementclick(element,info,0);
		
	}
	
	public List<WebElement> getElement(List<WebElement> element, String info) {
	    List<WebElement> elementlist = new ArrayList<WebElement>();
	    String rawInfo = element.toString();
	    
	    if (rawInfo.contains("->")) {
	        // 1. Get everything after the arrow "->"
	        String locatorWithMethod = rawInfo.substring(rawInfo.indexOf("->") + 3).trim();
	        
	        // 2. Extract the text between the colon and the final closing bracket
	        // locatorWithMethod looks like: xpath: //h3//following::li[@role='option']//mark/..]
	        int colonIndex = locatorWithMethod.indexOf(":");
	        if (colonIndex != -1) {
	            // Extract from after the colon, up to the second-to-last character (to drop the trailing ']')
	            String cleanLocator = locatorWithMethod.substring(colonIndex + 1, locatorWithMethod.length() - 1).trim();
	            
	           // System.out.println("Cleaned XPath: " + cleanLocator);
	            //String result = cleanLocator.substring(0, cleanLocator.length() - 2);
	            cleanLocator=cleanLocator.split("],")[0];
	            // 3. Find the fresh elements using the clean XPath
	            
	            System.out.println("Cleaned XPath: " + cleanLocator);
	            elementlist = SeleniumDriver.getDriver().findElements(By.xpath(cleanLocator));
	        }
	    }
	    return elementlist;
	}
		


		
			

	
		
		
		
		

	
	public String getText(WebElement element) {
		String text=null;
		text=element.getText();
		return text.trim();
		
	}
	
	public void SendData(WebElement element, CharSequence keyToSend) {
		element.sendKeys(keyToSend);
		
		
	}
	
	public void sendData(WebElement element,String data,Boolean clear) {
		
		try {
			if(clear) {
				element.clear();
			}
			element.sendKeys(data);
		}
			catch(Exception e) {
				
				
				
			}
		
	}
	
	

}
