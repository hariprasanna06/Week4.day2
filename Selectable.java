package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement ele1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement ele2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement ele3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement ele4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		
		Actions builder = new Actions(driver);
		builder.clickAndHold(ele1).clickAndHold(ele2).clickAndHold(ele3).clickAndHold(ele4).perform();
		
	}

}
