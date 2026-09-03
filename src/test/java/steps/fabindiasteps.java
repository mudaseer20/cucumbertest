package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class fabindiasteps {
	   WebDriver driver = new ChromeDriver(); 
	   

		@Given("user in fabindia page")
		public void user_in_fabindia_page() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		      driver.get("https://www.fabindia.com/clothing/men-shirts");
		      driver.manage().window().maximize();
		}
		@Given("user clicks on sort by button")
		public void user_clicks_on_sort_by_button() {
		    // Write code here that turns the phrase above into concrete actions
	       driver.findElement(By.cssSelector("select")).click();

}
		@Then("sort the text in dropdown button")
		public void sort_the_text() {
			   driver.findElement(By.cssSelector("select")).click();
			    WebElement list=driver.findElement(By.cssSelector("select"));
			      
	             Select s=new Select(list);
	             List<WebElement>a=s.getOptions();
	             System.out.println(a);
	             List<String>textone=new ArrayList<String>();
	             for (WebElement op:a) {
	            	 textone.add(op.getText());
	             }
	             
	  
	       	 List<String>txt=new ArrayList<String>(textone);
	    	 List<String>txton=textone;
	    	 
	       	Collections.sort(txt);
	      	 System.out.println(txt);
	       	 System.out.println(txton);
	       	 if(txt.equals(txton)) {
	        	 System.out.println("is sorted") ;
	        	 
	       	 }
	       	 else {
	       		 System.out.println("not sorted") ;
	       	 }
			
		   
		}
}