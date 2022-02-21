package _02_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import myPackage.*;

public class TestSliders {

	public static void main(String[] args) {
		
		// Step 1. Web-Browser Setup
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// 2. Launch Webpage
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		
		// 3. Slider
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]"));
		
		int width = slider.getSize().width;
		int height = slider.getSize().height;
		
		System.out.println("Width : " + width);
		System.out.println("Height : " + height);
		
		// 4. Slider
		// 4a
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(slider, width/2, 0).perform();
		// 4b
		//new Actions(driver).dragAndDropBy(slider, 400, 0).perform();
		
		
	}

}
