package _02_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lect04_Resize {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/resizable/default.html");
		
		WebElement resizable = driver.findElement(By.xpath("//body/div[@id='resizable']/div[3]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(resizable,  200 /* x : width */, 300 /* y : height */).perform();
		
	}

}
