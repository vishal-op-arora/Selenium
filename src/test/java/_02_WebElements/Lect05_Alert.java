package _02_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lect05_Alert {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(100, -600));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		
		/*
		 * driver.get("https://username:password@mail.rediff.com/cgi-bin/login.cgi");
		 * in case intra-net login alert will ask for username and password 
		 * by this we will bypass 
		 */
		driver.findElement(By.name("proceed")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		Thread.sleep(2000);
		alert.accept();
		
		Thread.sleep(2000);
		driver.close();
	}

}
