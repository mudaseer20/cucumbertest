package pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomepageVaselocators {
	@FindBy(xpath="//h1[contains(@class,'title')]")
	public WebElement vase;
    @FindBy(xpath="//span[contains(text(),'Rs')]/../..")
	public List<WebElement> prices;
    
    @FindBy(xpath="//h3[contains(@class,'heading')]/a[1]")
    public List<WebElement> pricestext;
	@FindBy(xpath="//span[text()='Gifts']")
	public WebElement gifts;
	
	  @FindBy(xpath="//span")
	    public List<WebElement> roles;
	
    
    @FindBy(xpath="//nav[contains(@class,'menu')]//a/span/../..//*[@href]")
    public List<WebElement> menulinks;
    
    @FindBy(xpath="//span[@class='facet-checkbox__text']")
    public List<WebElement> checkboxes;
    
    @FindBy(xpath="//input[@name='Colour']")
    public List<WebElement> colors;
    @FindBy(xpath="//input[@name='Colour']//following::label[1]")
    public List<WebElement>color;
    
    @FindBy(xpath="//h1/following::button[@aria-label='Close'][1]")
    public WebElement close;
    
    @FindBy(xpath="//button[contains(text(),'options')]")
    public WebElement options;
    @FindBy(css=".facet-checkbox__text")
    public List<WebElement> categorieslink;
    
  
    
    

}
