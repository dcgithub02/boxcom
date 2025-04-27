package com.box.utlis;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.box.pages.BasePage;

public class ElementUtils extends BasePage{

	
	WebDriver driver;
	//WebElement element;
	
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getElement(By locator)
	{
		WebElement element;
			try
			{
		element=this.driver.findElement(locator);
		return element;
			}
			catch(Exception e){
			e.printStackTrace();
			return null;
			}
		}

	public List<WebElement> getElements(By locator)
	{
		
		return driver.findElements(locator);
	}
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	public String doGetTitle() {
		return driver.getTitle();
	}
	public void doSendKeys(By locator,String text)
	{
		getElement(locator).sendKeys(text);
	}
	public boolean doIsDisplayed(By locator)
	{
		return getElement(locator).isDisplayed();
	}
	/* Dropdowns ******************************************************************************************************************/
	public void doSelectDropdownUsingSelectByVisibleText(By locator,String value)
	{
		Select select= new Select(getElement(locator));
		select.selectByContainsVisibleText(value);
	}
	public void doSelectDropdownUsingSelectByIndex(By locator,int index)
	{
		Select select= new Select(getElement(locator));
		select.selectByIndex(index);
	}
	public void doSelectDropdownUsingSelectByValue(By locator,String value)
	{
		Select select= new Select(getElement(locator));
		select.selectByValue(value);
	}
	public void doSelectBySelectOptions(By locator,String value) {
		List<WebElement> list;
		String text;
		Select select = new Select(getElement(locator));
		list=select.getOptions();
		for(int index=0;index<list.size();index++)
		{
			text=list.get(index).getText();
			if(text.equalsIgnoreCase(value))
			{
				list.get(index).click();
				break;
			}
		}
	}
	public List<WebElement> getDropdownOptions(By locator)
	{
		List<WebElement> list;
		list=getElements(locator);
		return list;
	}
	public int getSizeOfList(By locator)
	{
		return getDropdownOptions(locator).size();
	}
	
	// Actions Class********************************************************************************
	
	public void doClickUsingActions(By Locator)
	{
		Actions act = new Actions(this.driver);
		act.click(getElement(Locator)).build().perform();
	}
	public void doSendKeysUsingActions(By Locator,String value)
	{
		Actions act = new Actions(this.driver);
		act.sendKeys(getElement(Locator), value).build().perform();
	}
	public void doDoubleClickUsingActions(By Locator)
	{
		Actions act = new Actions(this.driver);
		act.doubleClick(getElement(Locator)).build().perform();
	}
	public void doDragAndDropUsingActions(By source,By target)
	{
		Actions act = new Actions(this.driver);
		act.dragAndDrop(getElement(source), getElement(target)).build().perform();
	}
	public void doContextClickUsingActions(By locator)
	{
		Actions act = new Actions(this.driver);
		act.contextClick(getElement(locator)).build().perform();
	}
	public void doMoveToElementUsingActions(By locator)
	{
		Actions act = new Actions(this.driver);
		act.moveToElement(getElement(locator)).build().perform();
	}
	
}
