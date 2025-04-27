package com.box.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.box.utlis.ElementUtils;

public class HomePage extends BasePage {
	
	WebDriver driver;
	HomePage hp;
	ElementUtils element;
	HomePage(WebDriver driver)
	{
		this.driver=driver;
		 element= new ElementUtils(driver);
		// hp= new HomePage(driver);
	}
	
	By newBtn= By.xpath("//div/span[text()='New']");
	By folder=By.cssSelector("[data-target-id='MenuItem-newfolder']");
	By folderName= By.name("folder-name");
	By emailIDD=By.cssSelector(".pill-selector-input");
	By name=By.name("invite-permission");
	By createBtn= By.cssSelector(".btn-primary");
	By cancelBtn=By.cssSelector("[data-resin-target='cancel']");
	public String getHomeTitle()
	{
		return  element.doGetTitle();
	}
	public void createFolder(String foldername1,String emailID1,String permission1)
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element.doClick(newBtn);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		element.doClick(folder);
			try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		element.doSendKeys(folderName,foldername1);
		element.doSendKeys(emailIDD, emailID1);
		element.doSelectDropdownUsingSelectByValue(name,permission1);
		element.doClick(createBtn);
	}
	

}
