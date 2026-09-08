package pages.actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


import pages.locators.Homepagelocators;

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
	
	public int clicknextpagevalidatecount() {
		int cn=0,count=0,counts=0;
		List<WebElement> text = null;
		try {
		if(homepagelocators.next.isDisplayed()){
		 text = homepagelocators.counttext;
			
			count=text.size();
			
		
			Actions actions=new Actions(SeleniumDriver.getDriver());
			actions.moveToElement(homepagelocators.next).click().perform();
			actions.scrollToElement(homepagelocators.countbulb).perform();;
			homepagelocators.next.click();
		
		}
		else {
			
			System.out.println("dont click");
		}
	
	
		
		}
		catch(NoSuchElementException e) {
		 counts=text.size();
		}
		cn=cn+count+counts;
		return cn;
		
		
	}
	public String getText() {
		String lampstext=homepagelocators.textlamp.getText();
		return lampstext;

   
		
		
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
