package com.yatra.automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YatraAutomationScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions chromeoptions=new ChromeOptions();
		
		chromeoptions.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(chromeoptions);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();
		
		//Handling the pop-up in home page
		closePopUp(wait);
		
		By departureDate=By.xpath("//div[@class='position-relative css-qf1gji' and @role='button']");
		
		WebElement departureDateButton= wait.until(ExpectedConditions.elementToBeClickable(departureDate));
		departureDateButton.click();
		
		By CalMonthLocator=By.xpath("//div[@class='react-datepicker__month-container']");
		List<WebElement> calendarMonthList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CalMonthLocator));
		System.out.println(calendarMonthList.size());
		
		WebElement augustcalWebElement=calendarMonthList.get(1);  //current month
		Thread.sleep(2000);
		By pricelocate=By.xpath(".//span[contains(@class,\"custom-day-content\")]");
		
		List<WebElement> augustPriceList=augustcalWebElement.findElements(pricelocate);  //chaning xpath
		int lowestPrice=Integer.MAX_VALUE;
		WebElement priceElement=null;
		for(WebElement price:augustPriceList)
		{
			String priceString=price.getText();
			if(priceString.length()>0)
			{
			priceString=priceString.replace("₹", "").replace(",","");
		//	System.out.println(priceString);
			//Tell which is the lowest price
			int priceInt=Integer.parseInt(priceString);
			if(priceInt<lowestPrice)
			{
				lowestPrice=priceInt;
				priceElement=price;
			}
		}
		}
		System.out.println(lowestPrice);
		WebElement dateElement=priceElement.findElement(By.xpath(".//../.."));
		System.out.println(dateElement.getAttribute("aria-label"));
		
	}

	private static void closePopUp(WebDriverWait wait) {
		By popuplocator=By.xpath("//span[@class='style_cross__q1ZoV']");
		try {
		WebElement popupElement=wait.until(ExpectedConditions.visibilityOfElementLocated(popuplocator));
		WebElement crossbutton=popupElement.findElement(By.xpath(".//img[@alt='cross']"));
		crossbutton.click();
		}
		catch(TimeoutException e) {
			System.out.println("pop-up is not shown in the screen.....");
		}
	}
	
	

}
