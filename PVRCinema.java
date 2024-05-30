package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PVRCinema {

	public static void main(String[] args) throws InterruptedException {
	
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//search city
		driver.findElement(By.xpath("//input[@class='p-inputtext p-component p-autocomplete-input p-autocomplete-input']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//h6[text()='Chennai']")).click();
		System.out.println("Chennai city selected");
		Thread.sleep(2000);

	}

}
