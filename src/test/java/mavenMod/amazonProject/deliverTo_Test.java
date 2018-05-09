package mavenMod.amazonProject;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class deliverTo_Test {
	
	WebDriver driver;
	
	String chromeAddress = "C:\\Users\\daniel.smith\\Documents\\Selenium_items\\chromedriver.exe";
	delieverTo_locationSetting deliverTo_page;	
	Point location = new Point(960, 0);
	Dimension size = new Dimension(960, 1160);

	@BeforeTest
	public void setupBrowser()
	{
		System.setProperty("webdriver.chrome.driver", chromeAddress);
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
	
		driver.manage().window().setPosition(location);
		driver.manage().window().setSize(size);
	}
	
	@Test
	public void testLocation()
	{
		String zipCode = "28358";
		
		//instantant the page object
		deliverTo_page = new delieverTo_locationSetting(driver);
		
		//Click the deliver to button located on the in the top nav bar
		deliverTo_page.clickDeliverTo();
		
		//wait for the popover to appear
		deliverTo_page.checkThatPopOver_visible();
		
		//Get the information from the current zip code section of popover
		deliverTo_page.getCurrentZipCode();
		
		//Change the zip code 
		deliverTo_page.changeZip(zipCode);
		
		//Get the current zip code from lable again
		deliverTo_page.getCurrentZipCode();
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}
}
