package _02_WebElements;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lect05_w2a_assign {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(100, -600));
		driver.manage().window().maximize();
		driver.get("http://www.way2automation.com/");
		
		// Mouse Over Resources
		Thread.sleep(2000);
		WebElement resources = driver.findElement(By.xpath("//a[contains(text(),'Resources')]"));
		Actions resourcesAction = new Actions(driver);
		resourcesAction.moveToElement(resources).perform();
		
		// Click on Practice 1
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Practice site 1')]")).click();
		
		Random random = new Random();
		String randomString = String.valueOf(random.nextInt(99999999));
		
		// Registration Form
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='load_form']/fieldset/input[@name='name']")).sendKeys("Vishal");
		driver.findElement(By.xpath("//*[@id='load_form']/fieldset/input[@name='phone']")).sendKeys("7875017508");
		driver.findElement(By.xpath("//*[@id='load_form']/fieldset/input[@name='email']")).sendKeys("Vishal_" + randomString + "@gmail.com" );
		driver.findElement(By.xpath("//*[@id='load_form']/fieldset/select[@name='country']")).sendKeys("India");
		driver.findElement(By.xpath("//*[@id='load_form']/fieldset/input[@name='city']")).sendKeys("Pune");
		driver.findElement(By.xpath("(//*[@id='load_form']/fieldset/input[@name='username'])[2]")).sendKeys("Admin" + randomString);
		driver.findElement(By.xpath("(//*[@id='load_form']/fieldset/input[@name='password'])[2]")).sendKeys("Admin!@" + randomString);
		
		// Submit Form
		driver.findElement(By.xpath("(//*[@id='load_form']/div/div[2]/input)[2]")).click();
		
		// Select Frame and Windows
		Thread.sleep(2000);
		WebElement framesAndWindows = driver.findElement(By.xpath("//*[@id='toggleNav']/li/a[text()='Frames and Windows']"));
		new Actions(driver).moveToElement(framesAndWindows).perform();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='toggleNav']/li/a[text()='Frames and Windows']")).click();
		
		//Open Multiple Window
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='wrapper']/div/div[1]/div[1]/ul/li/a[text()= 'Open Multiple Windows']")).click();
		
		Thread.sleep(2000);
		WebElement frame = driver.findElement(By.xpath("//*[@id='example-1-tab-4']/div/iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body/div/p/a")).click();
		
		Set <String> windows = driver.getWindowHandles();
		Iterator <String> iterator = windows.iterator();
		String mainWindow = iterator.next();
		String popUpWindow1 = iterator.next();
		String popUpWindow2 = iterator.next();
		String popUpWindow3 = iterator.next();
		
		Thread.sleep(2000);
		driver.switchTo().window(popUpWindow2);
		driver.close();
		
		Thread.sleep(2000);
		driver.switchTo().window(popUpWindow3);
		driver.close();
		
		Thread.sleep(2000);
		driver.switchTo().window(popUpWindow1);
		driver.close();
		
		Thread.sleep(2000);
		driver.switchTo().window(mainWindow);
		driver.close();

	}

}
