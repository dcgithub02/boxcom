package com.box.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.box.utlis.ElementUtils;

public class LogInPage extends BasePage {

	private WebDriver driver;
	public ElementUtils eu;
	
	public LogInPage(WebDriver driver)
	{
		this.driver=driver;
		 eu = new ElementUtils(this.driver);
		
	}
	
	private By email= By.id("login-email");
	private By next=By.id("login-submit");
	private By password=By.id("password-login");
	private By logInBtn=By.id("login-submit-password");
	private By resetPassword= By.id("reset-password-login");
	
	public String getLoginPageTitle()
	{
		return eu.doGetTitle();
	}
	public boolean verifyResetPasswordLink() {
		return eu.doIsDisplayed(resetPassword);
	}
	
	public HomePage login(String userName,String password)
	{
		eu.doSendKeys(this.email, userName);
		eu.doClick(next);
		eu.doSendKeys(this.password, password);
		eu.doClick(logInBtn);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage(this.driver);
		
	}
}
