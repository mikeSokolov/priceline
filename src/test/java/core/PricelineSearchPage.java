package core;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricelineSearchPage {
	
	public PricelineSearchPage(WebDriver dr){
		driver = dr;
	}
	
	
	WebDriver driver;
	
	public void operator(String a){
		
		driver.findElement(By.linkText(a)).click();
		
	}
	
	public void waitUntil(int i,By select){
		WebDriverWait wait =new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(select)).click();
	}
	
	//work around
			/*driver.findElement(selectStopsBy).click();
			stopsList = driver.findElement(By.cssSelector(".selection_box").id("Stops_list"));
			stopsList.findElement(By.id("0stop")).click();
			stopsList.findElement(By.id("1stop")).click();
			update = driver.findElement(By.cssSelector("#Stops_list > div.blue_border > span.b-update > a > img[alt=\"update filter selections\"]"));
			update.click();*/
	
	public void filterChoose(){
		//By.cssSelector(".selection_box");
		WebElement stopsList = driver.findElement(By.id("Stops_list"));
		stopsList.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
		stopsList.findElement(By.id("1stop")).click();
		WebElement update = driver.findElement(By.cssSelector("#Stops_list > div.blue_border > span.b-update > a > img[alt=\"update filter selections\"]"));
		update.click();
	}
	
	public ArrayList<Float> minPrice(ArrayList<Float> a){
		for(WebElement li : driver.findElements(By.cssSelector("div.list ol.list_items li.list_item"))){
			if(li.getText().contains("Virgin America")&& li.getText().contains("1 Stop")) {
				WebElement el = li.findElement(By.cssSelector(".choose_price .dollar"));
				a.add(Float.valueOf(el.getText().replace("$", "")));
				//if(li.getText().contains(Collections.min(a).toString())){}
			}
		}return  a;
	}
	public void printPriseAndFlight(WebElement a,ArrayList<Float> b){
		a.findElement(By.cssSelector(".flt_deatil_opt span a")).click();
		System.out.println("Price - $"+ Collections.min(b).toString()+ " /  Flight #: "+ a.findElement(By.cssSelector(".flt_info .airline .flightnum")).getText());
	}
	
	

}
