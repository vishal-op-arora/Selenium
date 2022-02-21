package _02_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lect04_SliderElement {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//driver.get("https://jqueryui.com/slider/");
		//WebElement slider = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/span[1]"));
		
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");			
		WebElement sliderNobe = driver.findElement(By.xpath("//*[@id='slider']/span[1]"));
		
		Actions slideAction = new Actions(driver);
		slideAction.dragAndDropBy(sliderNobe, 50, 0).perform();
		
		Thread.sleep(3000);
		WebElement slider = driver.findElement(By.xpath("//*[@id='slider']"));
		int width = slider.getSize().width;
		System.out.println("Slider widt : " + width);
		slideAction.dragAndDropBy(sliderNobe, -50, 0).perform();
		slideAction.dragAndDropBy(sliderNobe, width/2, 0).perform();
	}
}
