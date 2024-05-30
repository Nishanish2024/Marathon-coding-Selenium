package marathon;

import java.awt.event.ActionEvent;

import java.beans.PropertyChangeListener;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev210045.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("tdY0ES=5luW-");
		driver.findElement(By.id("sysverb_login")).click();

		// Moving to a new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(0));
		System.out.println("Moved to a new window...");
	
		//driver.switchTo().defaultContent();
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[text()='All']").click();

		
		//driver.findElement(By.xpath("//a[text()='Service Catalog']")).click();

		// Mobiles
		//driver.findElement(By.xpath("//td[@class='homepage_category_only_description_cell']"));

	}

}
