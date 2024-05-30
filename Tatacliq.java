package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tatacliq {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);

		driver.get("https://www.tatacliq.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// iframe for ads
		WebElement frameAds = driver.findElement(By.xpath("//iframe[@id='wiz-iframe-intent']"));
		driver.switchTo().frame(frameAds);
		driver.findElement(By.xpath("//span[@class='CT_InterstitialClose']")).click();

		driver.switchTo().defaultContent();
		// mouse over
		Actions action = new Actions(driver);
		WebElement brandsWE = driver.findElement(By.xpath("(//div[@class='DesktopHeader__categoryAndBrand'])[2]"));
		action.moveToElement(brandsWE).perform();
		WebElement watches = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		action.moveToElement(watches).perform();
		driver.findElement(By.xpath("//div[text()='Casio']")).click();
		Thread.sleep(4000);

		WebElement selectNArrivals = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		Select newArrivals = new Select(selectNArrivals);
		newArrivals.selectByVisibleText("New Arrivals");
		System.out.println("Listing Casio - brand watches");

		driver.findElement(By.xpath("//div[text()='Men']")).click();

		Thread.sleep(4000);
		List<String> tempList = new ArrayList<String>();
		List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']"));
		int size = priceList.size();
		System.out.println("no of watches available: " + size);

		System.out.println("Price List: ");
		for (int i = 0; i < size; i++) {
			WebElement price = priceList.get(i);
			String priceTxt = price.getText();
			System.out.println("Watch" + i + " Price:" + priceTxt);
			tempList.add(priceTxt);
		}

		// click on the first watch
		WebElement prodClick = driver.findElement(By.xpath("//div[@class='ProductDescription__content']"));
		driver.executeScript("arguments[0].click();", prodClick);

		// Moving to a new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		System.out.println("Moved to a new window...");

		Thread.sleep(3000);
		String priceMain = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3")).getText();
		System.out.println("Price of the selected watch: " + priceMain);

		// Replacing extra characters from price field
		String replaceAllPriceMain = priceMain.replaceAll("[^0-9]", "");

		// WebElement list1WE = priceList.get(0);
		// String priceList1 = list1WE.getText();
		String priceList1 = tempList.get(0);
		System.out.println("priceList1: " + priceList1);
		String replaceAllPriceList1 = priceList1.replaceAll("[^0-9]", "");

		if (replaceAllPriceList1.equals(replaceAllPriceMain)) {
			System.out.println("Prices are equal...");
		} else {
			System.out.println("Prices are not equal...");
		}

		// Add to cart
		WebElement addtocart = driver.findElement(By.xpath("//span[text()='ADD TO BAG']"));
		driver.executeScript("arguments[0].click();", addtocart);

		// screenshot
		System.out.println("Taking a screen shot...");
		File sourceFile = driver.getScreenshotAs(OutputType.FILE);
		File destiFile = new File("./snaps/viewAddtoCart.png");
		FileUtils.copyFile(sourceFile, destiFile);

		//driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']")).click();
		//System.out.println("Added to cart...");

	}

}
