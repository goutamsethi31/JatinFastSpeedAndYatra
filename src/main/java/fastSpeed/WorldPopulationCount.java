package fastSpeed;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorldPopulationCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open Worldometer Population page
        driver.get("https://www.worldometers.info/world-population/");

        // Locate current world population using XPath
        WebElement populationElement = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='current_population']"));

        // Get the text (current population number)
        String currentPopulation = populationElement.getText();

        // Print it
        System.out.println("Current World Population: " + currentPopulation);
        
        driver.close();

	}

}
