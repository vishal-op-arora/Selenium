package _02_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC02_BrowserParameter {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		int sleepTime = 3000; // Time in mill-sec
		
		
		// Driver SetUp
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Full screen
		Thread.sleep(sleepTime);
		driver.manage().window().fullscreen();
		
		// Maximize
		Thread.sleep(sleepTime);
		driver.manage().window().maximize();
		
		// Get Position 
		Thread.sleep(sleepTime);
		Point browserPostion = driver.manage().window().getPosition();
		System.out.println("X-Postion : " + browserPostion.getX());
		System.out.println("Y-Postion : " + browserPostion.getY());
		
		// Get Size
		Thread.sleep(sleepTime);
		Dimension browserSize = driver.manage().window().getSize();
		System.out.println("Height : " + browserSize.getHeight());
		System.out.println("Width : " + browserSize.getWidth());
		
		//
		Point p = new Point(0,3000);
		driver.manage().window().setPosition(p);
		
		
		// Close the browser
		Thread.sleep(sleepTime);
		driver.close();		
	}
}
