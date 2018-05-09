package mavenMod.amazonProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class delieverTo_locationSetting {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	By deliverTo_lbl = By.xpath("//div[@id = 'nav-main']/div[@class = 'nav-left']");
	By zipCode_lbl = By.xpath("//div[@id = 'GLUXZipConfirmationSection']");
	By chooseLocation_popover = By.xpath("//div[@class = 'a-popover-wrapper']");
	By lnk_changeZip = By.xpath("//a[@id = 'GLUXChangePostalCodeLink']");
	By txtbox_zipChange = By.xpath("//input[@id = 'GLUXZipUpdateInput']");
	By btn_apply = By.id("GLUXZipUpdate");
	//By btn_Done = By.id ("a-autoid-1");
	
	delieverTo_locationSetting(WebDriver driver){
		this.driver = driver;
	}

	public void clickDeliverTo()
	{
		driver.findElement(deliverTo_lbl).click();
	}
	public void checkThatPopOver_visible()
	{
		wait = new WebDriverWait(driver, 15);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(chooseLocation_popover)));
	}
	public void getCurrentZipCode()
	{
		wait = new WebDriverWait(driver, 15);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode_lbl));
		WebElement zipCode_info = driver.findElement(zipCode_lbl);
		System.out.println("Current zip code: " + zipCode_info.getText());
	}
	public void changeZip(String zipCode)
	{
		wait = new WebDriverWait(driver, 15);
		action = new Actions(driver);
		
		driver.findElement(lnk_changeZip).click();
		WebElement textbox_zipCode = driver.findElement(txtbox_zipChange);
		
		action.doubleClick(textbox_zipCode).perform();
		textbox_zipCode.sendKeys(zipCode);
		
		wait.until(ExpectedConditions.elementToBeClickable(btn_apply));
		driver.findElement(btn_apply).click();
	}
	
}
