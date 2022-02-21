package _02_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestResizable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. Setup
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=114
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// 2. Web-Page
		driver.get("https://jqueryui.com/resources/demos/resizable/default.html");
		
		// 3. get Element 
		WebElement resizeableWindow = driver.findElement(By.xpath("//*[@id=\"resizable\"]"));
		WebElement resizeableElement = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		
		int height = resizeableWindow.getSize().height;
		int width = resizeableWindow.getSize().width;
		
		System.out.println("Height : " + height); // Y-Axis
		System.out.println("Width : " + width); // X-Axis
		
		// 4. Change the height and Width
		
		int windowHeight = 400;
		int windowWidth = 400;
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(resizeableElement, windowWidth - width, windowHeight - height).perform();
	
		System.out.println("Height : " + resizeableWindow.getSize().height);
		System.out.println("Width : " + resizeableWindow.getSize().width);
		
		System.out.println("Test Resize");
		try {
			int i = 1;
			do {
				action.dragAndDropBy(resizeableElement, 10, 10).perform();
				System.out.println();
				System.out.println(i + ". Height : " + resizeableWindow.getSize().height);
				System.out.println(i + ". Width : " + resizeableWindow.getSize().width);
				i++;
			} while (true);
		}
		catch(Throwable t) {
			System.out.println("Resize Ends");
		}
	}

}
