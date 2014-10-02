package core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PricelineMenuPage {
	
	
	WebDriver driver;
	
	@FindBy(how=How.ID,using="vp-options-air-radio-air")
	@CacheLookup
	static WebElement flightonly;
	
	@FindBy(how=How.XPATH,using="//div[2]/div[2]/form/div[3]/div/label[1]/span")
	@CacheLookup
	static WebElement tripbutton;
	
	@FindBy(how=How.ID,using="air-orig-0")
	@CacheLookup
	static WebElement from;
	
	@FindBy(how=How.ID,using="air-dest-0")
	@CacheLookup
	static WebElement to;
	
	@FindBy(how=How.ID,using="air-date-0")
	@CacheLookup
	static WebElement datego;
	
	@FindBy(how=How.ID,using="air-date-1")
	@CacheLookup
	static WebElement dateback;
	
	@FindBy(how=How.ID,using="air-carrier")
	@CacheLookup
	static WebElement airl;
	
	@FindBy(how=How.XPATH,using="//form/div[6]/label[1]/select")
	@CacheLookup
	static WebElement cabincl;
	
	@FindBy(how=How.ID,using="air-btn-submit-retl")
	@CacheLookup
	static WebElement search;
	
	@FindBy(how=How.ID,using="adult-passengers")
	@CacheLookup
	static WebElement adults;
	
	@FindBy(how=How.ID,using="child-passengers")
	@CacheLookup
	static WebElement childs;
	
	public PricelineMenuPage(WebDriver dr){
		driver = dr;
	}
	
	
	
	public void flightOptions(){
		flightonly.click();
	}
	
	public void chooseTrip(){
		tripbutton.click();
	}
	
	public void fromTo(String a,String b){
		from.sendKeys(a);
		to.sendKeys(b);
	}
	
	public void tripLenght(String a,String b){
		datego.sendKeys(a);
		dateback.sendKeys(b);
	}
	
	public void adultDrop(String i){
		adults.sendKeys(i);
	} 
	
	public void childDrop(String i){
		childs.sendKeys(i);
	} 
	
	public void cabinClass(String cabinType){
		cabincl.sendKeys(cabinType);
	}
	
	public void airline(String a){
		airl.sendKeys(a);
	}
	
	public void searchAll(){
		search.click();
		
	}

}
