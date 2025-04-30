package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.box.utlis.ConstantsUtils;
import com.box.utlis.ExcelUtlis;

public class HomePageTest extends BaseTest
{

	
	public void setupHome()
	{
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
	setupHome();
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
