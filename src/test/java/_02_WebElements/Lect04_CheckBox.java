package _02_WebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lect04_CheckBox {

	public static WebDriver  driver;
	
	public static boolean isElementPresent(By by) {
		int size = driver.findElements(by).size();
		return  size == 0 ? false : true;
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		
		
		driver.findElement(By.xpath("//div[4]/input[1]")).click();
		driver.findElement(By.xpath("//div[4]/input[2]")).click();
		driver.findElement(By.xpath("//div[4]/input[3]")).click();
		driver.findElement(By.xpath("//div[4]/input[4]")).click();
		
		Thread.sleep(3000);
		for (int i = 1; i <= 4; i++) {
			driver.findElement(By.xpath("//div[4]/input[" + i +"]")).click();
		}
		
		Thread.sleep(3000);
		int i = 1;
		while(isElementPresent(By.xpath("//div[4]/input[" + i +"]"))) {
			driver.findElement(By.xpath("//div[4]/input[" + i +"]")).click();
			i++;
		}
		
		
		/*
		 * All all name is Sports
		 */
		Thread.sleep(3000);
		List<WebElement> checkboxes = driver.findElements(By.name("sports"));
		System.out.println(checkboxes.size());
		for(WebElement checkbox : checkboxes) {
			checkbox.click();
		}
		
		/*
		 * To section having name Sports
		 */
		Thread.sleep(3000);
		WebElement section = driver.findElement(By.xpath("//td/div[4]"));
		List<WebElement> checkboxes2 = section.findElements(By.name("sports"));
		System.out.println(checkboxes2.size());
		for(WebElement checkbox : checkboxes2) {
			checkbox.click();
		}
	}

}
