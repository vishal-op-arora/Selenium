package _02_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lect04_RightClick_Assign {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		
		WebElement contextMenu1 = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/p[2]/img[1]"));
		
		Actions action = new Actions(driver);
		action.contextClick(contextMenu1).perform();
		
		/*
		 * Move Mouse Pointer on the Element
		 */
		Thread.sleep(1500);
		WebElement contextMenu2 = driver.findElement(By.xpath("//td[@id='dm2m1i1tdT']"));
		action.moveToElement(contextMenu2).perform();
		
		Thread.sleep(1500);
		WebElement contextMenu3 = driver.findElement(By.xpath("//td[@id='dm2m2i1tdT']"));
		action.moveToElement(contextMenu3).perform();
		
		Thread.sleep(1500);
		WebElement contextMenu3Item = driver.findElement(By.xpath("//td[@id='dm2m3i0tdT']"));
		action.click(contextMenu3Item).perform();
	}
}
