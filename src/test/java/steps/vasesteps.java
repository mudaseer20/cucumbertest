package steps;

import java.util.List;

import org.testng.Assert;

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
	
	
}