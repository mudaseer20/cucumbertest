package steps;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import pages.actions.Vaseshomepageactions;

public class vasesteps {
	
	
	@Then("user validate text is {string}")
	public void validate(String text) throws InterruptedException {
		Vaseshomepageactions v=new Vaseshomepageactions();
		String texts=v.getText();
		String result = texts.substring(texts.indexOf(":") + 1).trim();
		Assert.assertEquals(result, text, "not equal");
	
		
	}

	@Then("user clicks on checkbox for {string}")
	public void clickcheckbox(String text) {
		Vaseshomepageactions v=new Vaseshomepageactions();
		v.clickcheckbox(text);
	
	
		
	}
@Then("user clicks on {string} button")
public void clickbutton(String text) {
	Vaseshomepageactions v=new Vaseshomepageactions();
	v.clicklink(text);
	
}

	
	@Then("validate the links of gifts for {string}")
	public void linkstext(String text) {
		Vaseshomepageactions v=new Vaseshomepageactions();
		List<String> val = v.getTag(text);
		System.out.println(val+"------>");
	
		
	}
	
	@Then("user clicks on Gifts")
	public void clickgift() throws InterruptedException {
		Vaseshomepageactions v=new Vaseshomepageactions();
		v.clickgift();
	
	
		
	}
	
	@Then("get the text of prices")
	public void gettext() {
		Vaseshomepageactions v=new Vaseshomepageactions();
		List<String> val = v.getTextprice();
		System.out.println(val+"------>");
	
	
	

}

	
	@Then("get the text of vases")
	public void gettextvase() {
		Vaseshomepageactions v=new Vaseshomepageactions();
		List<String> val = v.getTextpricetext();

		  val.removeIf(item -> item == null || item.isBlank());
			System.out.println(val+"------>");
			System.out.println(val.size());
	    
	
	

}
	
	
	@Then("get the text of categories")
	public void gettextcategories() {
		Vaseshomepageactions v=new Vaseshomepageactions();
		List<String> textcategory = v.getTextcategory();
		System.out.println(textcategory);
	  

}

	@Then("user validates the colors for {string}")
	public void chooseopt(String att,DataTable expectedDataTable) {
		
		Vaseshomepageactions v=new Vaseshomepageactions();
		List<String> colors = v.validateColor(att);
		System.out.println(colors);
		  List<String> expectedItems = expectedDataTable.asList(String.class);
	        List<String> actualItems = new ArrayList<>();
	        for (String element :colors) {
	            actualItems.add(element);
	        }
	        System.out.println(actualItems);
	        System.out.println(expectedItems);
	        Assert.assertEquals(actualItems, expectedItems, "The organization menu items do not match!");
		

	
		
		
		
	}
	
	@Then("user clicks on choose options")
		
		public void chooseopt() throws InterruptedException {
		
		Vaseshomepageactions v=new Vaseshomepageactions();
		v.clickgiftoptions();
		
	}
	
	@Then("user clicks on color option")
	public void clickcolor() {
		Vaseshomepageactions v=new Vaseshomepageactions();
		v.validateColorclick();
		
		
		
		
	}
	@Then("user clicks on click cart")
	public void clickcart() throws InterruptedException {
		Vaseshomepageactions v=new Vaseshomepageactions();
	v.clickcart();
		
			
		
	}
	
	@Then("user clicks on view cart")
	public void viewcart() throws InterruptedException {
		Vaseshomepageactions v=new Vaseshomepageactions();
		v.viewcart();

		
			
		
	}
	String price;
	@Then("user gets the price")
	public void getprice() throws InterruptedException {
		Vaseshomepageactions v=new Vaseshomepageactions();
		Thread.sleep(2900);
		
	     price = v.price();
	    System.out.println(price);
		
			
		
	}
	
	@Then("user gets the price in cart")
	public void getpriceview() throws InterruptedException {
		Vaseshomepageactions v=new Vaseshomepageactions();
		Thread.sleep(2900);
		String priceview=v.priceview();
		System.out.println(priceview+"is price");
		Assert.assertEquals(priceview,price);
		
	
		
			
		
	}
	
}