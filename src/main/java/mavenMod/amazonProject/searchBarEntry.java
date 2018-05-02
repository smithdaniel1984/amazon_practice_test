package mavenMod.amazonProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchBarEntry {

	WebDriver driver;
	WebDriverWait wait;
	String items;
	
	By searchBar = By.id("twotabsearchtextbox");
	By itemTitle = By.id("productTitle");
	By addtoCartXPath = By.xpath("//div[@id = 'addToCartDiv']/div/span[contains(@id, 'add-to-cart')]");
	By addtoCart1 = By.id("buy-now-button");
	By addtoCart2 = By.xpath("//input[contains(@id, 'add-to-cart')]");
	By viewCart = By.xpath("//a[contains(text(), 'Cart' )]");
	By deleteFromCart = By.xpath("//input[@value = 'Delete']");
	
	public searchBarEntry(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickSearchBar()
	{
		driver.findElement(searchBar).click();
	}
	
	public String enterSearch(String strSearch)
	{
		driver.findElement(searchBar).sendKeys(strSearch);
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
		return strSearch;
	}
	
	public void selectItem(String item)
	{
		driver.findElement(By.xpath("//h2[contains(text()," + " '" + item + "'" + ")]" )).click();
	}
	
	public String itemTitle()
	{
		return driver.findElement(itemTitle).getText();
	}
	
	public void addToCartbtn()
	{
		wait = new WebDriverWait(driver, 10);
		
		try
		{
			driver.findElement(addtoCartXPath).click();
		}
		catch(NoSuchElementException e)
		{
			try
			{
				driver.findElement(addtoCart1).click();
			}
			catch(NoSuchElementException exe)
			{
				driver.findElement(addtoCart2).click();
			}
			
		}
		catch(WebDriverException e)
		{
			System.out.println("Web driver exception error: " + e.getLocalizedMessage());
		}
	}
	
	public void viewCart()
	{
		driver.findElement(viewCart).click();
	}
	
	public void delete_From_Cart()
	{
		driver.findElement(deleteFromCart).click();
	}
}
