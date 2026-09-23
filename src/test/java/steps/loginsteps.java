package steps;
import utility.Readexcel;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.testng.Reporter;
import org.testng.Assert;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utility.Readexcel;

public class loginsteps {
	  // WebDriver driver = new ChromeDriver();    Readexcel r=new Readexcel();


 
	   
	   
	   
    
	   

	@Given("user in home page")
	public void user_in_home_page() {
	
		Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Hooks.driver.get("https://developer-qa.icertis.com/");
		Hooks.driver.manage().window().maximize();
	}
	
	
	
	@Given("user clicks on privacy policy")
	public void click_on_privacy_policy() {
		JavascriptExecutor js = (JavascriptExecutor) 		Hooks.driver;
		Actions actions = new Actions(Hooks.driver);
		WebElement element = Hooks.driver.findElement(By.xpath("//div[@class='footer-links']//a[text()='Privacy Policy']"));
		// "true" aligns the top of the element to the top of the viewport
		actions.scrollToElement(element).perform();
		//js.executeScript("arguments[0].scrollIntoView(true);", element);
		Hooks.driver.findElement(By.xpath("//div[@class='footer-links']//a[text()='Privacy Policy']")).click();
	   
	}
	
	@Then("user clicks on about Icertis button")
	public void aboutIcertisbuttonclick() {
		
		Hooks.driver.findElement(By.xpath("//a[text()='About Icertis']")).click();
	}

	@Then("validate the error message is {string}")
		public void validaterror(String str) {
		String text=Hooks.driver.findElement(By.cssSelector("mat-error")).getText();
		System.out.println(text);
		Assert.assertEquals(text, str);
		
			
		}
	


	@When("the actor clicks on {string} button")
	public void click_on_login_button(String str) {
		String textvalue="//button[contains(text(),'"+str+"')]";
		 WebElement btn=Hooks.driver.findElement(By.xpath(textvalue));
		 btn.click();
		 Reporter.log("user clicks on login button");
	   
	}

	// @When("user clicks on {string} button")
	// public void user_clicks_button(String str) throws InterruptedException {
	// 	String textvalue="//span[contains(text(),'"+str+"')]/..";
	// 	 WebElement btn=Hooks.driver.findElement(By.xpath(textvalue));
	// 	 btn.click();
	// 	 Thread.sleep(1200);
	// }
	@When("user switches to {string} window")
	public void userswitchtochildwindow(String str)
	{
		Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Set<String>it=Hooks.driver.getWindowHandles();
	
		Iterator<String>id=it.iterator();
		ArrayList<String>a=new ArrayList<String>();
	
		while(id.hasNext()) {
		a.add(id.next());
		}
		Reporter.log(a.get(Integer.parseInt(str)));
		Hooks.driver.switchTo().window(a.get(Integer.parseInt(str)));
		Reporter.log("Switched to   "+str+" window");
		
	}
	
	@When("user switches to {string} window and closes the window")
	public void userswitchtochildwindowclose(String str)
	{
		Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Set<String>it=Hooks.driver.getWindowHandles();
	
		Iterator<String>id=it.iterator();
		ArrayList<String>a=new ArrayList<String>();
	
		while(id.hasNext()) {
		a.add(id.next());
		}
		Reporter.log(a.get(Integer.parseInt(str)));
		Hooks.driver.switchTo().window(a.get(Integer.parseInt(str)));
		Reporter.log("Switched to   "+str+" window");
		Hooks.driver.close();
		
	}
	
	
	

	@When("clicks on next button")
	public void clicks_on_next_button() {
	
		Hooks.driver.findElement(By.xpath("//button//span[text()]")).click();
		
	
	  
	}
	@Then("validate the below the menu")
	public void menubutton(List<String>namelist) throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement>menuElements=Hooks.driver.findElements(By.xpath("//span[contains(@class,'list-item')]//span[@class='nav-label']"));
		
	for(String expname:namelist) {
		for(WebElement element:menuElements) {
		
			if(element.getText().trim().equalsIgnoreCase(expname)) {
		      Reporter.log(element.getText());
		      JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
		      js.executeScript("arguments[0].click();", element);
		      try {
				Hooks.scenario.log("Successfully clicked on button."+element.getText());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				 Thread.sleep(1700);
				break;
			}
			
		}
	}
	  
	}
	@Then("user closes the child window")
	public void closeschildwindow() {
		
		Set<String>it=Hooks.driver.getWindowHandles();
		String parent=Hooks.driver.getWindowHandle();
		it.remove(parent);
		for(String s:it) {
			Hooks.driver.switchTo().window(s);
			Hooks.driver.close();
	  
	}}
	
	

	@Then("actor enters {string}")
	public void actor_enters_username(String str) {
		Hooks.driver.findElement(By.cssSelector("input")).sendKeys(str);
	}
	
	
	@Then("user enters username as {string}")
	public void actor_entersname(String str) {
		WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input")));
		Hooks.driver.findElement(By.cssSelector("input")).sendKeys(str);
	}
	
	@Then("user clears the value in the text box")
	public void cleartext() {
		Hooks.driver.findElement(By.cssSelector("input")).clear();	
	}
	
	@And("actor clicks on next button")
	public void actor_clicks_on_next_button() {
		Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Hooks.driver.findElement(By.xpath("//button//span[text()]")).click();
	}
	@And("actor clicks on sign in button")
	public void actor_clicks_on_signinbutton() {
		int attempts=0;
		while (attempts < 3) {
		    try {
		    	Hooks.driver.findElement(By.cssSelector("input[type='submit']")).click();
	   break;
	
	    } catch (StaleElementReferenceException e) {
	        // Element went stale, loop will retry and re-locate it
	    
	   
	}
		}
		attempts++;
	}
	
	@And("user clicks on enter button")
	public void enterbutton() {
		Hooks.driver.findElement(By.cssSelector("input[value='Yes']")).click();
		}
	
	@Then("user clicks on {string} button in the menu")
	public void clickmenu(String menu) {
		Hooks.driver.findElement(By.xpath("//span[contains(@class,'mdc-list')]//span[contains(text(),'"+menu+"')]")).click();
	}
	

	@And("clicks on next button in sign in page")
	public void actor_clicksnext_button() {
		Hooks.driver.findElement(By.cssSelector("input[type='submit']")).click();
		}
	
	@And("user reads datafrom excel")
	public void readdatafromexcel() throws EncryptedDocumentException, IOException {
		  Readexcel read=new Readexcel();
		  read.getData("Sheet1");
		  
		}

	
	@And("actor enters password {string}")
	public void enterpassword(String str) {
		Hooks.driver.findElement(By.cssSelector("input[name='passwd']")).sendKeys(str);
		}
	@And("user gets the title of the page")
	public void getTitle() {
           new WebDriverWait(Hooks.driver, Duration.ofSeconds(10)).until(d ->((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
		   String title=Hooks.driver.getTitle();
		   System.out.println(title);
		}
 
    Map<String, String> browserMap = new LinkedHashMap<>();

	
	@And("insert the values of the your organisation")
	public void keyvalue() throws InterruptedException, EncryptedDocumentException, IOException {
		  Readexcel read=new Readexcel();
		  String[][] data=read.getData("Sheet1");
		   for (int i = 0; i < data.length; i++) {
	            
	            // matrix[i].length gives the number of columns in the current row
	            for (int j = 0; j < data[i].length; j++) {
	                System.out.print(data[i][j] + " ");
	            }
	            System.out.println();
		   }
		 
		Thread.sleep(4000);
		 new WebDriverWait(Hooks.driver, Duration.ofSeconds(10)).until(d ->((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
          List<WebElement>key=Hooks.driver.findElements(By.xpath("//span[contains(@class,'__title')]"));
          List<WebElement>values=Hooks.driver.findElements(By.xpath("//span[contains(@class,'__title')]/../../div[2]"));
          
         
          //Map<String, String> browserMap = new LinkedHashMap<>();
          String[] textArray = new String[key.size()];
          String[] textArrayon = new String[values.size()];
          for (int i = 0; i < values.size(); i++) {
        	    textArray[i] = key.get(i).getText();
        	    System.out.println(textArray[i]);
        	    textArrayon[i] = values.get(i).getText();
          	    System.out.println(textArrayon[i]);
        	    browserMap.put(textArray[i],textArrayon[i]);
        	    
        	}
          
          System.out.println(browserMap);
          
          
          
		}
	
	   @Then("user validates the text below Your organization")
	    public void validateOrganizationMenuTexts(DataTable expectedDataTable) throws EncryptedDocumentException, IOException {
	        // Option 1: asList() skips the top header row ("Name") and extracts values below it
			WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Your organization']")));
		
		   List<String> expectedItems = expectedDataTable.asList(String.class);

	        // Locate the menu item elements on your web page
	        // UPDATE THIS XPATH to target the specific list items under 'Your organization'
	        List<WebElement> actualMenuElements = Hooks.driver.findElements(By.xpath("//span[text()='Home']//following::div[contains(@class,'count')]/..//span"));

	        // Extract raw text values from the WebElements
	        List<String> actualItems = new ArrayList<>();
	        for (WebElement element : actualMenuElements) {
	            actualItems.add(element.getText().trim());
	        }
	        System.out.println(actualItems);
	        System.out.println(expectedItems);

	        // Validate thalists are identical in content and order
	        Assert.assertEquals(actualItems, expectedItems, "The organization menu items do not match!");
	        
	        
	        Readexcel read=new Readexcel();
			  String[][] data=read.getData("Sheet1");
			   for (int i = 0; i < data.length; i++) {
		            
		            // matrix[i].length gives the number of columns in the current row
		            for (int j = 0; j < data[i].length; j++) {
		                System.out.print(data[i][j] + " ");
		            }
		            System.out.println();
			   }
			    int rows = data.length;
		        int columns = data[0].length;
		        int totalElements = rows * columns;
		    

		        // 4. Flatten the matrix using nested loops
		        int index = 0; // Tracks the position in the 1D array
		        for (int i = 0; i < rows; i++) {
		            for (int j = 0; j < columns; j++) {
		            	System.out.print(data[i][j] + "\t");
		            }
		        }

		        // 5. Print the final results
		        System.out.println("Original Matrix:");
		        String a = null;
		        for (String[] row : data) {
		            System.out.println(Arrays.toString(row));
		            a=Arrays.toString(row);
		          
		        }
		        System.out.println(a.length());
		        
		        System.out.println(a+"are the values");
		        
		        
                
		   
			 
	    }
	   @When("user clicks on IS Button")
	   public void submitForm(DataTable dataTable) throws InterruptedException {
			Thread.sleep(4000);
		   Hooks.driver.findElement(By.xpath("//button//span[text()='IS']")).click();
	       Map<String, String> data = dataTable.asMap(String.class, String.class);

	       Map<String, String> roleMap = Map.of(
	    		    dataTable.cell(0, 1), dataTable.cell(0, 0)
	    		);
	     
      String rolename = dataTable.cell(0, 0);
       String roleid=dataTable.cell(0, 1);
       Map<String, String> role=new LinkedHashMap();
       role.put(roleid, rolename);
       Set<Map.Entry<String, String>> entrySet = role.entrySet();
       
	       List<WebElement> actualMenuElements = Hooks.driver.findElements(By.cssSelector(".role-info"));

	        // Extract raw text values from the WebElements
	        List<String> actualItems = new ArrayList<>();
	        for (WebElement element : actualMenuElements) {
	            actualItems.add(element.getText().trim());
	        }
	        System.out.println(actualItems+"is act");
	        System.out.println(entrySet+"---->");
	        System.out.println(roleMap+"is exp");
	        List<String> list = new ArrayList<>();
	        roleMap.forEach((k, v) -> { list.add(k); list.add(v); });
	        System.out.println(list+"is final");
	        
	        System.out.println(list.equals(actualItems));
	        Assert.assertEquals(list, actualItems);
	        Actions action = new Actions(Hooks.driver);
	        action.sendKeys(Keys.ESCAPE).build().perform();
	        
	
	       
	      
	        }
	   
	   @Then("user validates the text below {string} menu")
	    public void valuesbelowmenuitems(String str,DataTable expectedDataTable) throws EncryptedDocumentException, IOException {
	        // Option 1: asList() skips the top header row ("Name") and extracts values below it
			WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

		
		   List<String> expectedItems = expectedDataTable.asList(String.class);

	        // Locate the menu item elements on your web page
	        // UPDATE THIS XPATH to target the specific list items under 'Your organization'
	        List<WebElement> actualMenuElements = Hooks.driver.findElements(By.xpath("//span[contains(text(),'"+str+"')]//following::div[@id='menu-label']"));

	        // Extract raw text values from the WebElements
	        List<String> actualItems = new ArrayList<>();
	        for (WebElement element : actualMenuElements) {
	            actualItems.add(element.getText().trim());
	        }
	        System.out.println(actualItems);
	        System.out.println(expectedItems);

	        // Validate thalists are identical in content and order
	        Assert.assertEquals(actualItems, expectedItems, "The organization menu items do not match!");
	        
	


}
}
