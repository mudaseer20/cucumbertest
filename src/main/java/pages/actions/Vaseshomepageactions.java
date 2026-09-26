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
	
	public void clickgift() {
		 CustomDriver c=new  CustomDriver();
		 c.elementClick(homepagevase.gifts, "message");
		
		
	}
	
	public void clickgiftoptions() throws InterruptedException {
		 CustomDriver c=new  CustomDriver();
		 Thread.sleep(4000);
		 c.elementClick(homepagevase.options, "message");
		
		
	}
	 List<String>colors=new ArrayList();
	public List<String>validateColor(String text) {
		 CustomDriver c=new  CustomDriver();

		 List<WebElement> tagtext = c.getelement(homepagevase.colors, "not found");
		
		 for(int i=0;i<tagtext.size();i++) {
			 colors.add(tagtext.get(i).getAttribute(text));
		 }
          System.out.println(colors);
		 return colors;
		 
		 

		
		
	}
	

		public void validateColorclick() {
			 CustomDriver c=new  CustomDriver();

			 List<WebElement> tagtext = c.getelement(homepagevase.color, "not found");
			
			 for(int i=1;i<tagtext.size();i++) {
				 tagtext.get(i).click();
	
			 }
	       c.javascriptClick(homepagevase.close, "close the window");
		}
	
	
	public String getText() {
		 CustomDriver c=new  CustomDriver();
		String text=c.getText(homepagevase.vase, "text");
		return text;
	

	}
	
	public void clickcheckbox(String text) {
		 CustomDriver c=new  CustomDriver();
		 c.elementClick(homepagevase.checkboxes, text);
		 
		
		
		
	}
	
	public void clicklink(String text) {
		 CustomDriver c=new  CustomDriver();
		 c.elementClick(homepagevase.roles, text);
		 	
	}
	
	public void viewcart() {
		 CustomDriver c=new  CustomDriver();
		 try {
			 Thread.sleep(3400);
		 c.elementClick(homepagevase.viewchart);
		 System.out.println("clicked");
		 }
		 catch(Exception e) {
			 c.javascriptClick(homepagevase.viewchart, "clicked");
			 System.out.println("clicked script");
		 }
		 	
	}
	
	public String price() {
		 CustomDriver c=new  CustomDriver();
		 String text= c.getText(homepagevase.price, "text");
		 
		 return text;
		
	}
	
	public String priceview() {
		 CustomDriver c=new  CustomDriver();
		 String text= c.getText(homepagevase.productprice, "text");
		 
		 return text;
		
	}
	public void clickcart() throws InterruptedException {
		 CustomDriver c=new  CustomDriver();
		 c.scroll(homepagevase.quanti);
		 Thread.sleep(5000);
		 c.elementClick(homepagevase.addtocart);
		
		 
		
		
		
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
	

	 List<String>prices=new ArrayList();
	public List<String> getTextprice() {
		 CustomDriver c=new  CustomDriver();
		 List<WebElement> price = c.getelement(homepagevase.prices, "not found");
		
		 for(int i=0;i<price.size();i++) {
		
			 
			 prices.add(price.get(i).getText());
		 }

		 return prices;
		 
    
       


}
	
	 List<String>categories=new ArrayList();
	public List<String> getTextcategory() {
		 CustomDriver c=new  CustomDriver();
		 List<String> price = c.getelement(homepagevase.categorieslink);
		
	
			 for (String name :price) {
				 categories.add(name);

		 }

		 return categories;
		 
   
      


}
}