package mavenMod.amazonProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class searchBarEntry {

	WebDriver driver;
	By searchBar = By.id("twotabsearchtextbox");
	By item = By.xpath("//*[@id='result_2']/div/div/div/div[2]/div[2]/a/h2");
	By itemTitle = By.id("productTitle");
	By addtoCart = By.id("add-to-cart-button");
	By addtoCart1 = By.id("buy-now-button");
	By viewCart = By.linkText("Cart");
	By deleteFromCart = By.xpath("//*[@id='activeCartViewForm']/div[2]/div/div[4]/div[2]/div[1]/div/div/div[2]/div/span[1]/span/input");
	
	public searchBarEntry(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickSearchBar()
	{
		driver.findElement(searchBar).click();
	}
	
	public void enterSearch(String strSearch)
	{
		driver.findElement(searchBar).sendKeys(strSearch);
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
	}
	
	public void selectItem()
	{
		driver.findElement(item).click();
	}
	
	public String itemTitle()
	{
		return driver.findElement(itemTitle).getText();
	}
	
	public void addToCartbtn()
	{
		try
		{
			driver.findElement(addtoCart).click();
		}
		catch(NoSuchElementException e)
		{
			driver.findElement(addtoCart1).click();
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
