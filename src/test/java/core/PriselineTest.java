package core;



import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PriselineTest {
	
	String baseUrl= null;
	String fromCity = null;
	String toCity = null;
	String startDate= null;
	String endDate = null;
	String adultC = null;
	String childC = null;
	String cabine = null;
	String airli = null;
	String oper =null;
	
	
	public PriselineTest() throws FileNotFoundException, IOException{
		Properties properties = new Properties();

		properties.load(new FileInputStream("./src/main/resources/TestData1.properties"));

		baseUrl = properties.getProperty("url");
		fromCity=properties.getProperty("fromCityData");
		toCity=properties.getProperty("toCityData");
		startDate=properties.getProperty("toStartDate");
		endDate=properties.getProperty("toEndDate");
		adultC=properties.getProperty("adultNum");
		childC=properties.getProperty("childNum");
		cabine=properties.getProperty("cabina");
		airli=properties.getProperty("airline");
		oper=properties.getProperty("operatorAir");
		
		
	}
	ArrayList<Float> prices = new ArrayList<Float>();
	WebElement minimum = null;
	By selectStopsBy = new By.ByCssSelector("img[alt=\"select stops\"]");
	static WebDriver driver = new FirefoxDriver();
	
	
	PricelineFirstPage firstP =  PageFactory.initElements(driver, PricelineFirstPage.class);
	PricelineMenuPage menuP = PageFactory.initElements(driver, PricelineMenuPage.class);
	PricelineSearchPage searchP = PageFactory.initElements(driver, PricelineSearchPage.class);
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
		driver=null;
	}

	@Before
	public void setUp() throws Exception {
		driver.get(baseUrl);
		firstP.waiter();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void test1search() {
		
		assertEquals("Priceline.com - The Best Deals on Hotels, Flights and Rental Cars.", firstP.getTitle());
		firstP.chooseTab();
		menuP.flightOptions();
		menuP.chooseTrip();
		menuP.fromTo(fromCity, toCity);
		menuP.tripLenght(startDate, endDate);
		menuP.adultDrop(adultC);
		menuP.childDrop(childC);
		menuP.cabinClass(cabine);
		menuP.airline(airli);
		menuP.searchAll();
		searchP.waitUntil(30, selectStopsBy);
		searchP.filterChoose();
		searchP.minPrice(prices);
		for(WebElement lis : driver.findElements(By.cssSelector("div.list ol.list_items li.list_item"))){
			if(lis.getText().contains(Collections.min(prices).toString()) && lis.getText().contains("Virgin America") && lis.getText().contains("1 Stop")){
				minimum = lis;
				}
		}
		
		searchP.printPriseAndFlight(minimum, prices);
		
		
		
	}

}
