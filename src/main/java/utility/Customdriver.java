package utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomDriver {
	JavascriptExecutor js;
	public void elementClick(String path,String info) {
		By bytype=getByType(path);
		WebElement element= SeleniumDriver.getDriver().findElement(bytype);
		try {
			element.click();
		}
		catch(Exception e) {
			
		}
	}
	public void elementClick(WebElement element,String info) {
		try {
			element.click();
		}
		catch(Exception e) {
			
		}
	}
	
    public void javascriptClick(WebElement element, String info) {
        try {
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
        
        }
    }
	
	  public void sendData(WebElement element, String data,Boolean clear,CharSequence... input) {
	        try {
	            if (clear) {
	                element.clear();
	            }
	           
	            element.sendKeys(input);
	        
	        } catch (Exception e) {
	        
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
        	
        	   if (!locator.contains("=>")) {
        	        throw new IllegalArgumentException("Invalid locator format: '" + locator + 
        	            "'. Must follow the 'type:value' format (e.g., 'id:elementId' or 'xpath://div')");
        	    }
        	   else if (locatorType.contains("id")) {
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
    
    public void selectOption(WebElement element, String optionToSelect) {
        Select sel = new Select(element);
        String trimtext=optionToSelect=optionToSelect.trim();
        sel.selectByVisibleText(trimtext);

    }
    public void scroll(WebElement element) {
    	 JavascriptExecutor js = (JavascriptExecutor) SeleniumDriver.getDriver();
    	    js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public String getText(WebElement element, String info) {
        System.out.println("Getting Text on element :: " + info);
        String text = null;
        text = element.getText();
        if (text.length() == 0) {
            text = element.getAttribute("innerText");
        }
        if (!text.isEmpty()) {

        } else {
      
        }
        return text.trim();
    }
public List<WebElement> getelement(String locator,String info){
	List<WebElement> elementlist=new ArrayList<WebElement>();
	
	By bytype=getByType(locator);
	try {
		elementlist=SeleniumDriver.getDriver().findElements(bytype);
		if(elementlist.size()>0) {
			System.out.println("found with"+locator);
		}
		else {
			
		}
		
	}
	catch(Exception e) {
		
		e.printStackTrace();
	}
	
	return elementlist;
	
}
public List<WebElement> getelement(List<WebElement> el,String info){
	List<WebElement> elementlist=new ArrayList<WebElement>();
	try {
			for (WebElement element : el) {
	             elementlist.add(element);
	            			
			}
		
	}
	catch(Exception e) {
		
		e.printStackTrace();
	}
	
	return elementlist;
	
}
}
