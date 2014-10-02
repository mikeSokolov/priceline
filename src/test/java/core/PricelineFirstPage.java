package core;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricelineFirstPage {
	
	@FindBy(how=How.ID,using="tab-flights")
	@CacheLookup
	static WebElement flights;

	
	
	public PricelineFirstPage(WebDriver dr){
		driver = dr;
	}
	
	WebDriver driver;
	
	
	
	public void waiter(){
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public void chooseTab(){
		//flights.click();
		WebDriverWait wait =new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(flights)).click();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
}
