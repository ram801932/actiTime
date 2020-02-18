package com.actiTime.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;



public class Base {
	public static Logger log;
	 public static WebDriver driver;
	@BeforeTest
	public static void testOpenBrowser() throws EncryptedDocumentException, InvalidFormatException, IOException {
		log =Logger.getLogger(Base.class);
		PropertyConfigurator.configure("log4j.properties");
		
		String browser=Excel.readdata("Sheet1", 1, 2);
		
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		}
		
		else if(browser.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		}
		log.info("===============Browser launched=============");
		
	}

	@AfterTest
	public static void testcloseBrowser() {
		driver.close();
		log.info("===============Browser closed=============");

	}
	
	@BeforeClass
	public void testLoging() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/test.properties");
		Properties p=new Properties();
		p.load(fis);
		driver.get(p.getProperty("url"));
		log.info("===============actitime login page=============");
		driver.findElement(By.name("username")).sendKeys(p.getProperty("username"));
		driver.findElement(By.name("pwd")).sendKeys(p.getProperty("password"));
		driver.findElement(By.xpath("//input[@valign='absmiddle']")).click();
		log.info("===============ACTITIME OpenTask Page=============");
	}
	@AfterClass
	public void testLogout()
	{
		driver.findElement(By.className("logoutImg")).click();
		log.info("============= logout successfull ============");
	}
}
