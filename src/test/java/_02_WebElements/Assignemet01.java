package _02_WebElements;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import myPackage.*;
public class Assignemet01 {

	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new SelectDriver().getDriver(browser);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://qa.way2automation.com/");
		driver.manage().window().maximize();
		
		// Name
		WebElement name = driver.findElement(By.xpath("//input[@type=\"text\"] [@name=\"name\"]"));
		name.sendKeys("Vishal");
		System.out.println("Name : " + name.getText());
		
		// Phone
		WebElement phone = driver.findElement(By.xpath("//input[@type=\"tel\"][@name=\"phone\"]")); 
		phone.sendKeys("7875017508");
		System.out.println("Phone : " + phone.getText());
		
		// eMail
		WebElement email = driver.findElement(By.xpath("//input[@type=\"email\"][@name=\"email\"]")); 
		email.sendKeys("reweri.vishal@gmail.com");
		System.out.println("eMail : " + email.getText());
		
		// eMail
		// WebElement country = driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[4]/select/option[101]")); 
		// country.sendKeys("reweri.vishal@gmail.com");
		// System.out.println("Country : " + country.getText());
				
		// City
		WebElement city = driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[5]/input")); 
		city.sendKeys("Pune");

		System.out.println("City : " + city.getText());
		
	}

}
