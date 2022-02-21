package _02_WebElements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Lect06_ObjectRepositoryProperties {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*
		 * What is an Object Repository in Selenium?
		 * 
		 * Element will be loaded from properties file
		 * Test Data will be loaded from excel file 
		 * 
		 * 
		 */
		Properties OR = new Properties(); // Object of Properties Class
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\properties\\OR.properties"); // Objject of File
		OR.load(fis); // Load the Object 
		
		Properties Config = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\properties\\Config.properties");
		Config.load(fis);
		
		System.out.println(OR.getProperty("username_ID"));
		System.out.println(Config.getProperty("browser"));
		
		/*
		 * even use fro developer as well 
		 * 1 - add log4j dependencies 
		 * 2 - Logger - getLogger()
		 * 3 - Log4j Appenders - Format, information, Error, Debug
		 * 		Append true : log appended to same file
		 * 		Append false - create new file, overwrite older one 
		 * 		where the log file should be genrator..... ........................   log4j.properties 
		 * 4 - PropertyConfigurator 
		 * 
		 * 
		 */
	}

}
