package _02_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lect04_MouseOver_Action {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.way2automation.com/");
		
		WebElement menu = driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[3]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[3]/ul/li[2]/a")).click();
		
	}

}
