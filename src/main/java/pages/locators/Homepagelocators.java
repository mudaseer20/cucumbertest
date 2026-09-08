package pages.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepagelocators {
@FindBy(xpath="//header[@id='SiteHeader']/div/div/ul/li/a|//details/summary")
public List<WebElement> menutext;

@FindBy(xpath="//div[contains(text(),'products')]")
public WebElement products;


@FindBy(xpath="//div[@class='collection-grid__wrapper']//div[@class='grid-product__title']")
public List<WebElement> counttext;

@FindBy(xpath="//h1")
public WebElement textlamp;

@FindBy(xpath="//a[contains(text(),'Chandeliers')]")
public WebElement chand;

@FindBy(xpath="//a[contains(text(),'Chandeliers')]")
public WebElement chandone;

@FindBy(xpath="(//div[@class='grid-product__title'])[last()]")
public WebElement countbulb;
@FindBy(xpath="//span[contains(text(),'Next')]")
public WebElement next;
}






