package _02_WebElements;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lect05_ScreenShot {

	static WebDriver driver;
	
	public static void captureScreenshot() {
		
		Date date = new Date();
		String fileName = date.toString().replace(":", "_").replace(" ", "_")+".jpg";
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"\\screenshot\\"+fileName));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(100, -600));
		driver.manage().window().maximize();
		driver.get("https://time.is/");
		
		//File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"\\screenshot\\error.jpg"));
		captureScreenshot();
		
		System.out.println("End of Program");
		driver.close();
	}

}
