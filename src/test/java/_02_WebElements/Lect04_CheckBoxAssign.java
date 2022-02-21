package _02_WebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lect04_CheckBoxAssign {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		
		Thread.sleep(1000);
		WebElement section = driver.findElement(By.xpath("//td/div[4]"));
		List <WebElement> inputElements = section.findElements(By.tagName("input"));
		System.out.println(inputElements.size());
		for(WebElement inputElement : inputElements ) {
			System.out.println("Value : " + inputElement.getAttribute("value"));
			if(inputElement.getAttribute("value").equals("baseball")) {
				inputElement.click();
			}
		}
		
		System.out.println(section.getText());
		
		Thread.sleep(1000);
		List <WebElement> lineElements = section.findElements(By.xpath("br"));
		System.out.println(lineElements.size());
		for(WebElement lineElement : lineElements) {
			
			System.out.println("Text : " + lineElement.getText());
		}
		
		/*
		 * List <WebElement> lineElements = section.findElements(By.xpath("//td/div[4]/text()/following-sibling::input"));
		System.out.println(lineElements.size());
		for(WebElement lineElement : lineElements) {
			
			System.out.println("Text : " + lineElement.getAttribute("value"));
		}
		 */
		
		driver.close();
	}
}
