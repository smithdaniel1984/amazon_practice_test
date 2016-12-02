package mavenMod.amazonProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class amazonHomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	amazonHomePage homePage;
	
	//By departmentsLink = By.linkText("Departments");
	By departmentsLink = By.className("nav-line-2");
	By fireTvLink = By.xpath("//*[@id='nav-flyout-shopAll']/div[2]/span[7]/span");
	By fireStickLink = By.xpath("//*[@id='nav-flyout-shopAll']/div[3]/div[7]/div[1]/div/a[2]/span[1]");
	By sportsLink = By.xpath("//*[@id='nav-flyout-shopAll']/div[2]/span[17]/span");
	By sportsGoodsLink = By.xpath("//*[@id='nav-flyout-shopAll']/div[3]/div[17]/div[2]/div/a[1]/span");
	By campingHikingLink = By.xpath("//*[@id='nav-subnav']/a[2]/span[1]");
	By campingBag = By.xpath("//*[@id='nav-flyout-ab:camping-backpacking-subnav-flyout-content-1,camping-backpacking-subnav-flyout-promo-1:verticalstores-subnav-flyout']/div[2]/div/div[1]/ul/li[1]/a/img");
	
	amazonHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void hoverDepartments()
	{
		wait = new WebDriverWait(driver, 15);
		
		WebElement deparmentsLinkEle = driver.findElement(departmentsLink);
		Actions hover = new Actions(driver);

		hover.moveToElement(deparmentsLinkEle).perform();
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(fireTvLink));
	}
	
	public void departmentFireTV()
	{
		WebElement fireLink = driver.findElement(fireTvLink);
		
		Actions moveToFireLink = new Actions(driver);
		
		Action mouseOver =  moveToFireLink.moveToElement(fireLink).build();
		mouseOver.perform();
		
		driver.findElement(fireStickLink).click();
	}
	
	public void sportsLink()
	{
		WebElement sportslink = driver.findElement(sportsLink);
		WebElement sportsGoodslink = driver.findElement(sportsGoodsLink);
		
		wait.until(ExpectedConditions.visibilityOf(sportslink));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(sportslink).perform();
		
		wait.until(ExpectedConditions.visibilityOf(sportsGoodslink));
		act.moveToElement(sportsGoodslink).perform();
		
		driver.findElement(sportsGoodsLink).click();
		
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void campingPage() throws InterruptedException
	{
		WebElement campingAndHikingLink = driver.findElement(campingHikingLink);
		
		Actions moveToAction = new Actions(driver);
		
		wait.until(ExpectedConditions.visibilityOf(campingAndHikingLink));
		moveToAction.moveToElement(campingAndHikingLink).perform();
		Thread.sleep(500);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(campingBag)));
		WebElement campingBagPic = driver.findElement(campingBag);
		
		moveToAction.moveToElement(campingBagPic).perform();
		
		campingBagPic.click();
	}

}
