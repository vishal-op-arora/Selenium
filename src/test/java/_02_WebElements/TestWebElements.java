package _02_WebElements;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import myPackage.*;

/*
 * <input type="email" class="whsOnd zHQkBf" jsname="YPqjbf" autocomplete="username" spellcheck="false" tabindex="0" aria-label="Email or phone" name="identifier" value="" autocapitalize="none" id="identifierId" dir="ltr" data-initial-dir="ltr" data-initial-value="">

	Locator : 
	-----------
	1. id : identifierId (Could be uniqune or not )
	2. name : identifier
	3. xpath : (every Element would have) //*[@id="identifierId"]
	4. cssSelector : (every Element would have)  #identifierId
	5. ClasName : whsOnd zHQkBf
	6. tagName = input
	7. linkText : 
	8. partialLinkText : 
 * 
 */
public class TestWebElements {

	
	public static String browser = "chrome";
	public static WebDriver driver;
	
	/*
	 * To search elements
	 * 
	 */
	public static boolean isElementPresentCSSSelector(String cssSelector) {
		
		try {
			driver.findElement(By.cssSelector(cssSelector));
			return true;
		}
		catch(Throwable t) {
			return false;
		}	
	}
	
	
	public static boolean isElementPresentCSSSelector_2(String cssSelector) {
		int elementCount = driver.findElements(By.cssSelector(cssSelector)).size();
		return elementCount == 0 ? false : true;
	}
	
	
	public static boolean isElementPresent(By by) {
		int elementCount = driver.findElements(by).size();
		return elementCount == 0 ? false : true;
	}
	
	public static void main(String[] args) throws InterruptedException {

		// Switch between browser	
		driver = new SelectDriver().getDriver(browser);
		
		driver.manage().window().maximize();
		//driver.get("http://gmail.com");
		
		// implicit wait will work for whole code it is the maximum time 
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.navigate().to("http://gmail.com");
		
		/*
		 * driver.navigate().back();
		 * driver.navigate().forward();
		 * driver.navigate().refresh();
		 */
		
		//WebElement userName = driver.findElement(By.id("identifierId"));
		//userName.sendKeys("vishala@pre-scient.com");
		
		// ById
		//driver.findElement(By.id("identifierId")).sendKeys("vishala@pre-scient.com");
		
		// By cssSelector
		driver.findElement(By.cssSelector("#identifierId")).sendKeys("vishala@pre-scient.com");
		
		System.out.println(driver.findElement(By.cssSelector("#identifierId")).isDisplayed()); // To check the Visibility isDiaplayed
		
		// No method to check the presence of element
		System.out.println("*************** First Way ******************");
		System.out.println(isElementPresentCSSSelector("#identifierId"));
		System.out.println(isElementPresentCSSSelector("#identifierId_123"));
		System.out.println("*************** Second Way ******************");
		System.out.println(isElementPresentCSSSelector_2("#identifierId"));
		System.out.println(isElementPresentCSSSelector_2("#identifierId_123"));
		System.out.println("*************** Third Dynamics Way ******************");
		System.out.println(isElementPresent(By.cssSelector("#identifierId")));
		System.out.println(isElementPresent(By.cssSelector("#identifierId_123")));
		
		// 
		
		
		
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
		
		//Thread.sleep(3000);	
		
		// explicit Wait 
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"))).sendKeys("biomedical_09asas");
		
		//driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("biomedical_09");
		driver.findElement(By.cssSelector("#passwordNext > div > button > div.VfPpkd-RLmnJb")).click();
		//Thread.sleep(3000);
		String errorMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span"))).getText();
		System.out.println(errorMsg);
		
		driver.close();
	}

}
