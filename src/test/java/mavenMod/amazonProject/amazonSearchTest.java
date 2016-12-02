/*
	10/18/2016
	doing a search for a item then go into the cart and remove the item.
*/
package mavenMod.amazonProject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class amazonSearchTest {
	
	WebDriver driver;
	searchBarEntry searchBar = new searchBarEntry(driver);
	String chromeAddress = "C:\\Users\\daniel.smith\\Documents\\selenium-2.53.0\\selenium-2.53.0\\chromedriver.exe";
	String[] items = {"Battlefield 4", "gta V", "nba2k16", "nba 2k17"};
	Random itemNumber = new Random();
	
	Point location = new Point(960, 0);
	Dimension size = new Dimension(960, 1160);
	
	@BeforeTest
	public void setupTest()
	{
		System.setProperty("webdriver.chrome.driver", chromeAddress);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");
		
		driver.manage().window().setPosition(location);
		driver.manage().window().setSize(size);
	}
	
	@Test(priority = 0)
	public void searchBarTest()
	{
		searchBar = new searchBarEntry(driver);
		
		searchBar.clickSearchBar();
		searchBar.enterSearch(items[itemNumber.nextInt(4)]); //Random number to go through options
		searchBar.selectItem();
		System.out.println("Title of the item: " + searchBar.itemTitle().toString());
		searchBar.addToCartbtn();
		searchBar.viewCart();
		searchBar.delete_From_Cart();
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}

}
