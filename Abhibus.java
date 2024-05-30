package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Abhibus {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://www.abhibus.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='From Station']")).sendKeys("Chennai");
		WebElement fromStationWE = driver.findElement(By.xpath("//div[text()='Chennai']"));
		fromStationWE.click();
		System.out.println("Entered From Station successfully.... ");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='To Station']")).sendKeys("Bangalore");
		WebElement toStationWE = driver.findElement(By.xpath("//div[text()='Bangalore']"));
		toStationWE.click();
		System.out.println("Entered To Station successfully.... ");
		
		
		//calender
		driver.findElement(By.xpath("//input[@placeholder='Onward Journey Date']")).click();
		WebElement calenderWE=driver.findElement(By.xpath("//span[text()='16']"));
		calenderWE.click();
		System.out.println("Calender selected for tommorrows date.... ");
		
		//Search button
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
		//First bus
		WebElement firstBus = driver.findElement(By.xpath("//h5[@class='title']"));
		String txtFirstBus = firstBus.getText();
		System.out.println("First bus is: "+txtFirstBus);
		
		//choose sleeper class
		driver.findElement(By.xpath("//span[text()='Sleeper']")).click();
		//show seats button
		driver.findElement(By.xpath("//button[text()='Show Seats']")).click();
		WebElement seatWE = driver.findElement(By.xpath("//div[@class='text-grey']"));
		String seats=seatWE.getText();
		System.out.println("no of seats= "+seats);
		
		//driver.findElement(By.xpath("//button[@class='seat sleeper']")).click();
		//choose the seatno
		driver.findElement(By.xpath("//table[@id='seat-layout-details']")).click();
		//choose boarding point
		driver.findElement(By.xpath("(//input[@class='primary  '])[2]")).click();
		//choose dropping point 
		driver.findElement(By.xpath("(//input[@class='primary  '])[2]")).click();
		//span[text()='Dropping Point']")).click();
		
		WebElement seatSelected = driver.findElement(By.xpath("//span[text()='Seat Selected :']"));
		System.out.println("Selected seat is: "+seatSelected.getText());
		
		WebElement fare = driver.findElement(By.xpath("(//span[@class='text-primary'])[2]"));
		//span[contains(text(),'Base Fare :'
	
		System.out.println("Fare is: "+fare.getText());
		//driver.close();
	}
}
