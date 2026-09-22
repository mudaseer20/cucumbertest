package pages.actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import pages.locators.HomepageVaselocators;
import pages.locators.Homepagelocators;
import utility.CustomDriver;
import utility.SeleniumDriver;

public class Vaseshomepageactions {
	HomepageVaselocators homepagevase =null;
	public Vaseshomepageactions() {
		this.homepagevase =new HomepageVaselocators();
		PageFactory.initElements(SeleniumDriver.getDriver(),homepagevase);
	}
	public String getText() {
		 CustomDriver c=new  CustomDriver();
		String text=c.getText(homepagevase.vase, "text");
		return text;
	

	}
	 List<String>tags=new ArrayList();
	public List<String> getTag(String text) {
		 CustomDriver c=new  CustomDriver();
		 List<WebElement> tagtext = c.getelement(homepagevase.menulinks, "not found");
		
		 for(int i=0;i<tagtext.size();i++) {
		
			 
			 tags.add(tagtext.get(i).getAttribute(text));
		 }

		 return tags;
	

	}
	
	 List<String>pricestext=new ArrayList();
	public List<String> getTextpricetext() {
		 CustomDriver c=new  CustomDriver();
		 List<WebElement> price = c.getelement(homepagevase.pricestext, "not found");
		
		 for(int i=0;i<price.size();i++) {
		
			
			 pricestext.add(price.get(i).getText());
		 }

		 return pricestext;
		 
    
       

	}
	
	public void clickgift() {
		 CustomDriver c=new  CustomDriver();
		 c.elementClick(homepagevase.gifts, "message");
		
		
	}
	 List<String>prices=new ArrayList();
	public List<String> getTextprice() {
		 CustomDriver c=new  CustomDriver();
		 List<WebElement> price = c.getelement(homepagevase.prices, "not found");
		
		 for(int i=0;i<price.size();i++) {
		
			 
			 prices.add(price.get(i).getText());
		 }

		 return prices;
		 
    
       


}
}