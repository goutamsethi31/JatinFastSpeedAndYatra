package fastSpeed;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FastAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://fast.com/");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	//	By speedValueLocator=By.id("speed-value");
	//	By speedUnitLocator=By.id("speed-units");
		String className;
		while(true) {
		WebElement speedValueElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("speed-value")));
		WebElement speedUnitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("speed-units")));
		
		System.out.println(speedValueElement.getText()+" "+speedUnitElement.getText());
		className=speedValueElement.getAttribute("class");
		if(className!=null && className.contains("succeeded")) {
			break;
		}
		
	}
		System.out.println("...........Final Speed........");
		WebElement speedValueElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("speed-value")));
		WebElement speedUnitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("speed-units")));
		System.out.println(speedValueElement.getText()+" "+speedUnitElement.getText());
	}

}
