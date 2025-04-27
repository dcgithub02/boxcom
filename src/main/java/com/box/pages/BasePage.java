package com.box.pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Synchronized;

public class BasePage {
	
	 WebDriver driver;
	Properties prop;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	public  static synchronized WebDriver getDriver()
	{
		return tldriver.get();
	}
	
	
	public WebDriver init_driver(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver= new ChromeDriver();
			tldriver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver= new FirefoxDriver();
			tldriver.set(new FirefoxDriver());
		}
		else if(browserName.equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			//driver= new SafariDriver();
			tldriver.set(new SafariDriver());
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getDriver().get("https://app.box.com");
		return getDriver();
		
	}
	
	public Properties init_properties()
	{
		prop= new Properties();
		try {
			FileInputStream ip= new FileInputStream(".//src//main//java//com//box//config//Configuration.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
	public String getScreenshot()
	{
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path= System.getProperty("user.dir")+"//screenshot"+System.currentTimeMillis()+".png";
		File destination= new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}