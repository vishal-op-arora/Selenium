package _02_WebElements;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lect05_Popups {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().setPosition(new Point(-100, -800));
			driver.manage().window().maximize();
			driver.get("http://www.way2automation.com/");
			
			System.out.println("-------------   One Window   -------------------");
			
			Set <String> windows = driver.getWindowHandles();
			/*
			 * String first_window = windows.iterator().next();
			 * 
			 * or use Itreator 
			 */

			Iterator <String> iterator = windows.iterator();
			String first_window = iterator.next();
			System.out.println("First Window : " + first_window);
			
			for(String window : windows) {
				System.out.println("Window ID : " + window);
			}
			
			System.out.println("-------------   Two Windows   -------------------");
			
			driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[2]/div/div[2]/div/a[1]")).click();
			
			windows = driver.getWindowHandles();
			iterator = windows.iterator();
			
			System.out.println("First Window : " + iterator.next());
			String second_window = iterator.next();
			System.out.println("Second Window : " + second_window);
			
			Set <String> windows2 = driver.getWindowHandles();
			for(String window : windows2) {
				System.out.println("Window ID : " + window);
			}
			
			
			
			driver.switchTo().window(second_window);
			driver.findElement(By.id("user_email")).sendKeys("vishal.op.arora@gmail.com");
			/*
			Thread.sleep(3000);
			driver.close(); // Second Window
			
			Thread.sleep(3000);
			driver.switchTo().window(first_window);
			driver.close(); // First Window
			*/
			driver.quit();// Close all windows in one shot
			
			
	}

}
