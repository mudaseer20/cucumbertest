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
    
    @FindBy(xpath="//nav[contains(@class,'menu')]//a/span/../..//*[@href]")
    public List<WebElement> menulinks;
   
	@FindBy(xpath="//span[text()='Gifts']")
	public WebElement gifts;
}
