package pages.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


import pages.locators.Homepagelocators;
import utility.CustomDriver;
import utility.SeleniumDriver;

public class Kapoorhomeactions {
	
	Homepagelocators homepagelocators=null;
	
	
	public Kapoorhomeactions() {
		this.homepagelocators=new Homepagelocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), homepagelocators);
	}
	public void movemousependantlights() throws InterruptedException {
		Actions actions=new Actions(SeleniumDriver.getDriver());
		actions.moveToElement(homepagelocators.chand).click().perform();
		Thread.sleep(9000);
		actions.sendKeys(Keys.ESCAPE).perform();
	
		
		
	}
	public void clickoutdoor() {
		 CustomDriver c=new  CustomDriver();
		 c.elementClick(homepagelocators.Outdoor, "clicked");
	}
	
	public void entertext(String text) {
		 CustomDriver c=new  CustomDriver();
		 c.sendData(homepagelocators.search,text, "text", true);
		
	}
	
	public void entertext(CharSequence... inputs) {
		 CustomDriver c=new  CustomDriver();
		 c.sendData(homepagelocators.search, "test", false, inputs);
		
		
	}
public List<WebElement> getPriceText() throws InterruptedException {
	 CustomDriver c=new  CustomDriver();
     Thread.sleep(5000);
	 String pricesString = homepagelocators.price.stream()
			    .map(element -> element.getText()) // Extracts the text from each WebElement
			    .collect(Collectors.joining("  "));
	 System.out.println(pricesString);
//     pricesString="xpath=>"+pricesString;
	List<WebElement>price=c.getelement(pricesString, "getlist");
	
	return price;
}

  
	public void clicksort(String text) {
		 CustomDriver c=new  CustomDriver();
//		 c.elementClick(homepagelocators.sort,"clicked");
		 c.selectOption(homepagelocators.sort, text);
	}
	public void clickclearance() throws InterruptedException {
	Actions actions=new Actions(SeleniumDriver.getDriver());
		 CustomDriver c=new  CustomDriver();
		 c.elementClick(homepagelocators.ClearanceSale, "clicked");
//		actions.moveToElement(homepagelocators.ClearanceSale).click().perform();
	Thread.sleep(9000);
		actions.sendKeys(Keys.ESCAPE).perform();
	
	
		
		
	}
	
	public int getcount() {
		String prodtext=homepagelocators.products.getText();
		int value=Integer.parseInt(prodtext.split(" ")[0]);
		
		return value;
		
	}

    
    public int validatecount() {
    
    	WebElement nextbutton;
        List<String> lightsName = new ArrayList();
        
    	for(WebElement names:homepagelocators.counttext) {
    		lightsName.add(names.getText());
    	}
    	Actions actions=new Actions(SeleniumDriver.getDriver());
		actions.scrollToElement(homepagelocators.countbulb).perform();
		boolean val = false;
		try {
    	 val=homepagelocators.next.isDisplayed();
		}
		catch(Exception e) {
			
		}
    	while(val) {
    	
    		
    			actions=new Actions(SeleniumDriver.getDriver());
        		actions.scrollToElement(homepagelocators.countbulb).perform();
        		if(homepagelocators.nextlength.size()>0) {
        			 CustomDriver c=new  CustomDriver();
        			 c.elementClick(homepagelocators.next, "clicked");
        		}
        		if(homepagelocators.nextlength.size()==0){
        			for(WebElement names:homepagelocators.counttext) {
        				lightsName.add(names.getText());
        			}
        			break;
        		}
        		
    		for(WebElement names:homepagelocators.counttext) {
        		lightsName.add(names.getText());
        	}
    		
    		
    		
    	
    	try {
    	 nextbutton= homepagelocators.next;
    	}
    	catch(Exception e) {
    		break;
    	}
    	}
//		for(WebElement names:homepagelocators.counttext) {
//		lightsName.add(names.getText());
    	
    	   int actualCount = lightsName.size();
           System.out.println("Actual light count : "+actualCount);
           return actualCount;
	}
    
     
      
    
    
    
//	public int clicknextpagevalidatecount() throws InterruptedException {
//		 int count,counts=0,cn=0;
//		count=0;
//		
//		Actions actions=new Actions(SeleniumDriver.getDriver());
//		actions.scrollToElement(homepagelocators.countbulb).perform();
//		
//		
//		List<WebElement> text = null;
//		
//
//		try {
//			
//	do{
//	
//			
//	
//		 text = homepagelocators.counttext;
//		 count=text.size();
//		
//		
//	
////			actions.moveToElement(homepagelocators.next.get(0).click())
////	
////		homepagelocators.next.click();
//		((JavascriptExecutor) SeleniumDriver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",homepagelocators.countbulb);
//		actions.moveToElement(homepagelocators.countbulb).perform();
//		Thread.sleep(2300);
//		
//		 text = homepagelocators.counttext;
//
//	
//	
//		
//		//}
//	//while(homepagelocators.next.isDisplayed());
////		else {
////			
////			System.out.println("dont click");
////		}
////	
//	
//		
//	//	}
//		catch(NoSuchElementException e) {
//			 counts=text.size();
//		}
//		cn=cn+count+counts;
//		return cn;
//		
//		
//	}
	public String getText() {
		 CustomDriver c=new  CustomDriver();
		 c.scroll(homepagelocators.textlamp);
		String lampstext=homepagelocators.textlamp.getText();
		return lampstext;

	}
	String pricetext;
	public String getprice() throws InterruptedException {
		 CustomDriver c=new  CustomDriver();
		 c.scroll(homepagelocators.pricetext);
			Thread.sleep(4000);
	    pricetext=homepagelocators.pricelamp.getText();
	    System.out.println(pricetext+"is price");
		return pricetext;
		
	}
	public String getpricedetail() {
		
		 String pricetexts=homepagelocators.pricelampview.getText();
		 return pricetexts;
	
	}
	public void clickbulb() {
		 CustomDriver c=new  CustomDriver();
	
		 c.javascriptClick(homepagelocators.pricelamp, "clicked");
		
	}
	
	
	
	public void scrolltillast() {
		
		
		Actions actions=new Actions(SeleniumDriver.getDriver());
		actions.scrollToElement(homepagelocators.countbulb).perform();;
	
	
	
		
	}
	

	public List<String> validatemenuitems() {
		List<WebElement> text = homepagelocators.menutext;
		  List<String> names = new ArrayList<>();
		int len=text.size();
		int i;
		for(i=0;i<len;i++) {
			String te=text.get(i).getText();
			names.add(te);
		}
		 
		return names;
		
		
	}
	
	

}
