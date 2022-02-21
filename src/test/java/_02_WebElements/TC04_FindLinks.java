package _02_WebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import myPackage.*;

public class TC04_FindLinks {

	public static void main(String[] args) {

		// Driver Setup
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Launch website 
		driver.get("https://www.wikipedia.org/");
		
		// get all links
		List<WebElement> linkElements = driver.findElements(By.xpath("//a[@href]"));
		
		int linkElementCount = 0;
		System.out.println("Links Count : " + linkElements.size());
		for(WebElement linkElemnt : linkElements) {
			linkElementCount ++;
			//System.out.println(linkElementCount + ".  " + linkElemnt.getAttribute("href"));
		}
		
		System.out.println(" ***************   Section Start   ****************");
		
		// Section Elements 
		//WebElement languageSection = driver.findElement(By.xpath("//div[@id='js-lang-lists']"));
		WebElement languageSection = driver.findElement(By.xpath("//div[@class='lang-list-container']"));
		List<WebElement> languageSectionElements = languageSection.findElements(By.xpath("//a[@href]"));
		//List <WebElement> languageSectionElements = driver.findElement(By.xpath("//div[@class='lang-list-container']")).findElements(By.xpath("//a[@href]"));
		//List <WebElement> languageSectionElements = driver.findElements(By.xpath("//div[@class='lang-list-container']//a[@href]"));
		int laguageSectionElementsCount = 0;
		System.out.println("Section Elements Size : " + languageSectionElements.size());
		for(WebElement languageSectionElement : languageSectionElements) {
			laguageSectionElementsCount ++;
			System.out.println(laguageSectionElementsCount + ".  " + languageSectionElement.findElement(By.xpath("//a")).getAttribute("href"));
		}
		
		System.out.println("End of Program.");
		driver.close();
		
	}

}
