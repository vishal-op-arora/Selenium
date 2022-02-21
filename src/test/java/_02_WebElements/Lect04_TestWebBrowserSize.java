package _02_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import myPackage.*;

public class Lect04_TestWebBrowserSize {
	
	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Launch Chrome Web-Browser
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
		driver = new SelectDriver().getDriver(browser);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.manage().window().getSize().width + "  " + driver.manage().window().getSize().height);
		// Set Dimensions
		int width = 520;
		int height = 520; 
		System.out.println("Default ---- Width is " + driver.manage().window().getSize().getWidth());
		System.out.println("Default ---- Height is " + driver.manage().window().getSize().getHeight());
		Dimension dimension = new Dimension(width, height);
		driver.manage().window().setSize(dimension);
		
		System.out.println("Fisrt Change --- Width is " + driver.manage().window().getSize().getWidth() + ". set value is " + width);
		System.out.println("Fisrt Change --- Height is " + driver.manage().window().getSize().getHeight() + ". set value is " + height);
		
		System.out.println("Web-Browser resize START.");
		int i = 0;
		do {
			i= i +10;
			int newWidth = width + i;
			int newHeight = height + i;
			driver.manage().window().setSize(new Dimension(newWidth, newHeight));
			System.out.println(i + ". Width is " + driver.manage().window().getSize().getWidth() + ". set value is " + newWidth);
			System.out.println(i + ". Height is " + driver.manage().window().getSize().getHeight() + ". set value is " + newHeight);
			System.out.println();
		}while(i<500);
		System.out.println("Web-Browser resize END.");
		
		
		System.out.println(driver.manage().window().getSize().width + "  " + driver.manage().window().getSize().height);
		/*
		// 1. Get Point 
		Point point = driver.manage().window().getPosition();
		System.out.println("X Position : " + point.getX());
		System.out.println("Y Position : " + point.getY());
		
		// 2. Move Window
		point.move(500, 500);
		System.out.println("X Position : " + point.getX());
		System.out.println("Y Position : " + point.getY());
		*/
		
	}

}
