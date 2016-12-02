/*
 * Test that will choose the departments and make sure you are
 * on the correct page.
 */

package mavenMod.amazonProject;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class departmentsChooseTest {
	
	WebDriver driver;
	String chromeAddress = "C:\\Users\\daniel.smith\\Documents\\selenium-2.53.0\\chromedriver.exe";
	amazonHomePage homePage;
	
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
	public void departmentSelectTest() throws InterruptedException
	{
		homePage = new amazonHomePage(driver);
		
		homePage.hoverDepartments();
		
		homePage.departmentFireTV();
		
		homePage.getPageTitle();
		System.out.println("Page title: " + homePage.getPageTitle());
		
		homePage.hoverDepartments();
		
		homePage.sportsLink();
		System.out.println("Page title: " + homePage.getPageTitle());
		
		homePage.campingPage();
		System.out.println("Page title: " + homePage.getPageTitle());
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
