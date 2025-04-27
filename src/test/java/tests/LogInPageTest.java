package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.box.pages.BasePage;
import com.box.pages.LogInPage;
import com.box.utlis.ConstantsUtils;
import com.box.utlis.ExcelUtlis;

public class LogInPageTest {
	 BasePage base;
	 WebDriver driver;
	 LogInPage lp;
	 Properties pp;
	@BeforeTest
	public void setup() {
		base = new BasePage();
		driver=base.init_driver("chrome");
		lp= new LogInPage(driver);
		pp=base.init_properties();
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitle()
	{
		
	String title=lp.getLoginPageTitle();
	
	Assert.assertEquals(title, ConstantsUtils.LOGIN_TITLE, "LoginPage title didnt match");
	}
	
	@Test(priority=2)
	public void verifyResetPasswordTest()
	{
		boolean linkPresent=lp.verifyResetPasswordLink();
		Assert.assertEquals(linkPresent, true,"reset password link missing");
		
	}
	

	@Test(priority=3)
	public void loginTest() {
	
		lp.login(pp.getProperty("username"), pp.getProperty("password"));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
