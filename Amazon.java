package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys");
		driver.findElement(By.id("nav-search-bar-form")).submit();

		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(5000);
		
		WebElement totalBags = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
		System.out.println("total no of bags available: " + totalBags.getText());
		
		// selecting 2 brands - American Tourister
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[4]")).click();
		System.out.println("2 brands selected...");
		
		// sort by: New arrivals
		driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();
			
		// first item in the list
		WebElement bagName = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base']"));
		System.out.println("Brand Name: "+bagName.getText());
		WebElement prodName = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		System.out.println("Product details: "+prodName.getText());
		WebElement price =driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		System.out.println("Price: "+price.getText());
	}

}
