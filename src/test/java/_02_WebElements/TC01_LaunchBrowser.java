package _02_WebElements;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01_LaunchBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("*****************************************");
		System.out.println();
		System.out.println("Enter value to lauch desire Web Browser");
		System.out.println(" 1  --  Chrome");
		System.out.println(" 2  --  Edge");
		System.out.println(" 3  --  FireFox");
		System.out.println(" 4  --  Opera");
		System.out.println();
		System.out.println("*****************************************");
		
		// User input
		Scanner in = new Scanner(System.in);
		int userInput = Integer.parseInt(in.nextLine());
		
		WebDriver driver = null;
		
		switch (userInput){
		
		case 1 :
			WebDriverManager.chromedriver().setup(); // Setup Chrome Driver
			driver = new ChromeDriver();
			break;
			
		case 2:
			WebDriverManager.edgedriver().setup(); // Edge
			driver = new EdgeDriver();
			break;
			
		case 3:
			WebDriverManager.firefoxdriver().setup(); // Fire Fox
			driver = new FirefoxDriver();
			break;
		
		case 4:
			WebDriverManager.operadriver().setup(); //Opera
			driver = new OperaDriver();
			break;
			
		default :
			System.out.println("Incorrect user input");
		}
		
		
		if (driver != null) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.close();
		}	
	}
}
