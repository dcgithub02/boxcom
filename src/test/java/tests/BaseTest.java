package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.box.pages.BasePage;
import com.box.pages.HomePage;
import com.box.pages.LogInPage;
import com.box.utlis.ConstantsUtils;
import com.box.utlis.ExcelUtlis;

public class BaseTest
{
	WebDriver driver ;
	HomePage hp;
	BasePage base;
	LogInPage lp;
	Properties pp;
	
	@BeforeClass
	public void setup() {
		base = new BasePage();
		driver=base.init_driver("firefox");
		pp=base.init_properties();
		lp= new LogInPage(driver);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}



}