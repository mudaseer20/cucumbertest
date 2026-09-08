package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import pages.actions.Kapoorhomeactions;
import utility.SeleniumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class HomepageKapoorsteps{

	@Given("user launches the browser")
	public void userlaunches() {
		SeleniumDriver.setupDriver();
	}
	@Then("user scrolls till the last")
	public void userscrollstill(){
		Kapoorhomeactions kh=new Kapoorhomeactions();
        kh.scrolltillast();
		
	}
	@Then("user validates count")
	public void validatecount() throws InterruptedException {
		Kapoorhomeactions kh=new Kapoorhomeactions();
		int count=kh.clicknextpagevalidatecount();
		System.out.println(count);
		
	}

	

	
	
	@Then("user clicks on chandeliers")
	public void clickchandelier() throws InterruptedException {
		Kapoorhomeactions kh=new Kapoorhomeactions();
		kh.movemousependantlights();
		
	}

	@Then("user validates the text is {string}")
	public void getlamptext(String expectedText) {
		Kapoorhomeactions kh=new Kapoorhomeactions();
		String actualText=kh.getText();
		actualText=actualText.trim();
        System.out.println(actualText);
        System.out.println(expectedText);
        Assert.assertEquals(actualText, expectedText, "The organization menu items do not match!");
		
	}
	
	
	@Then("user in home page {string} for kapoor lamps")
	public void user_in_home_page_for_kapoor_lamps(String url) {
		SeleniumDriver.setupDriver();
//		SeleniumDriver.getDriver();
		SeleniumDriver.openpage(url);



}
	
	@When("user validates the text in the menu items")
	public void uservalidatemenuitems(DataTable expectedDataTable) {
		Kapoorhomeactions kh=new Kapoorhomeactions();
	
		List<String>vali=kh.validatemenuitems();
		  List<String> expectedItems = expectedDataTable.asList(String.class);
	        List<String> actualItems = new ArrayList<>();
	        for (String element :vali) {
	            actualItems.add(element);
	        }
	        System.out.println(actualItems);
	        System.out.println(expectedItems);
	        Assert.assertEquals(actualItems, expectedItems, "The organization menu items do not match!");
		
}
	
	
}
