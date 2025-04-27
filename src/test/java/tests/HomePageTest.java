package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.box.pages.BasePage;
import com.box.pages.HomePage;
import com.box.pages.LogInPage;
import com.box.utlis.ConstantsUtils;
import com.box.utlis.ExcelUtlis;

public class HomePageTest {
WebDriver driver ;
HomePage hp;
BasePage base;
LogInPage lp;
Properties pp;
@BeforeTest
public void setup() {
	base = new BasePage();
	driver=base.init_driver("chrome");
	pp=base.init_properties();
	lp= new LogInPage(driver);
	hp=lp.login(pp.getProperty("username"), pp.getProperty("password"));
}

@Test(priority=1)
public void verifyTitle()
{
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	hp.getHomeTitle();
	
	Assert.assertEquals(hp.getHomeTitle(), ConstantsUtils.HOME_TITLE);
}

@DataProvider(name="createFolder")
public Object[][] getData()
{
	return ExcelUtlis.getData("Sheet1");
}

@Test(priority=2,dataProvider="createFolder")
public void createFolder(String foldername,String email,String permission)
{
	hp.createFolder(foldername, email, permission);
}

}
