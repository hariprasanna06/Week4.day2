package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa1 {
	public static void main(String[] args) throws InterruptedException {
		//Download the Driver And Setup the Path
		WebDriverManager.chromedriver().setup();
		 //launch the browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-nodifications--");
		ChromeDriver driver = new ChromeDriver(options);
		//get URL
		driver.get("https://www.nykaa.com/");
		//maximize the window
		driver.manage().window().maximize();
		//implicity wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement ele = driver.findElement(By.xpath("//a[text()='brands']"));
		//Mouse over on Brands and Search L'Oreal Paris
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();
		//Click L'Oreal Paris
		driver.findElement(By.xpath("//div[@class='css-ov2o3v'][6]//a")).click();
		//Check the title contains L'Oreal Paris
		driver.findElement(By.xpath("(//h1[@class='css-mrgb7e'])[1]"));
		System.out.println(driver.getTitle());
		//Click sort By
		WebElement sort = driver.findElement(By.xpath("//span[@class='sort-name']"));
		sort.click();
		//select customer top rated
		WebElement userSort = driver.findElement(By.xpath("//span[text()='customer top rated']"));
		userSort.click();
		//Click Category
		WebElement category = driver.findElement(By.xpath("//span[text()='Category']"));
		category.click();
		
		Thread.sleep(2000);
		//click Hair
		driver.findElement(By.xpath("//div[@class=' css-b5p5ep']//span[text()='Hair']")).click();
		
		Thread.sleep(2000);
		//Click haircare
		driver.findElement(By.xpath("//div[@class=' css-b5p5ep']//span[text()='Hair Care']")).click();
		
		Thread.sleep(2000);
		//Click Shampoo
		driver.findElement(By.xpath("//div[@class='control-value']//span[text()='Shampoo']")).click();
		
		Thread.sleep(2000);
		//Click Concern
		driver.findElement(By.xpath("//div[@class='filter-open css-1kwl9pj']//span[text()='Concern']")).click();
		
		Thread.sleep(2000);
		//Color Protection
		driver.findElement(By.xpath("//div[@class='control-value']//span[text()='Color Protection']")).click();
		
		
		//check whether the Filter is applied with Shampoo
		boolean displayed = driver.findElement(By.xpath("(//div[@class='css-1d0jf8e'])//span[1]")).isDisplayed();
		
		System.out.println("Dispalyed in the filter box is: "+displayed);
		//Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("(//div[@class='css-xrzmfa'])[1]")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> openWindow = driver.getWindowHandles();
		List<String> childWindow = new ArrayList<String>(openWindow);
		//Switch to child Window
		driver.switchTo().window(childWindow.get(1));
		//Go to the new window and select size as 175ml
		WebElement sizeofShampoo = driver.findElement(By.xpath("//div[@class='css-11wjdq4']//select"));
		Select drop = new Select(sizeofShampoo);
		drop.selectByVisibleText("175ml");
		//Print the mrp rate
		String mrP = driver.findElement(By.xpath("(//div[@class='css-1d0jf8e']//span)[2]")).getText();
		String mrP1 = mrP.replaceAll("\\W", " ");
		System.out.println("MRP of the product is: " +mrP1);
		
		Thread.sleep(2000);
		//Click on ADD to BAG
		driver.findElement(By.xpath("(//button[@class=' css-12z4fj0']//span)[2]")).click();
		//Go to Shopping Bag 
		driver.findElement(By.xpath("//div[@class='css-0 e1ewpqpu1']//button")).click();
        
		WebElement frame1 = driver.findElement(By.xpath("///iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(frame1);
		//Print the Grand Total amount
		String grandTotal = driver.findElement(By.xpath("//div[@class='first-col']//span[text()='Grand Total']")).getText();
		String grandTotal1 = grandTotal.replaceAll("\\W", "");
		System.out.println("The Grand Total price of the product is: " +grandTotal1);
		//Click  Proceed
		driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']//span[text()='Proceed']")).click();
		//SwichTo ParentWindow
		driver.switchTo().defaultContent();
		//Click on Continue as Guest
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		//Check if this grand total is the same in step 14
		String grandTotal2 = driver.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']//span")).getText();
		System.out.println("The grand total of the product is: " +grandTotal2);
		
		if(grandTotal.equalsIgnoreCase(grandTotal2)) {
        	System.out.println("Both Grand Totals are equal");
        }
        	
        	else {
        		System.out.println("Both Grand Totals are not equal");
        	}
		
		Thread.sleep(2000);
		//Close all the windows
		driver.quit();
		
		
		
		
		
		
		
		
	}

}
