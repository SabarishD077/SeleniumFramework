package com.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hubspot.base.BasePage;

public class ElementUtil extends BasePage {
	
WebDriverWait wait;
	
public WebElement getElement(By locator)
{
	WebElement element= null;
	try {
		element = driver.findElement(locator);
		if(highlightelement)
		{
			JavascriptUtil.flash(element);
		}
	} catch (Exception e) {
		System.out.println("An Exception occured with " + element + " element");
	}
	return element;
}

public void doClick(By locator)
{
	try {
		getElement(locator).click();
	} catch (Exception e) {
		System.out.println("An Exception occured while clicking web element");
	}
}

public void doSendKeys(By locator, String Value)
{
	try {
		WebElement ele = getElement(locator);
		ele.clear();
		ele.sendKeys(Value);
	} catch (Exception e) {
		System.out.println("An Exception occured while entering the text value");
	}
}

public boolean doIsDisplayed(By locator)
{
	try {
		return getElement(locator).isDisplayed();
	} catch (Exception e) {
		System.out.println("An Exception occured with element display");
	}
	return false;
}

public String doGetText(By locator)
{
	return getElement(locator).getText();
}
public String doGetTitle()
{
	return driver.getTitle();
}

public boolean waitforElementPresent(By locator)
{
	wait= new WebDriverWait(driver, AppConstants.TIMEOUT_WAIT);
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	return true;
}

public boolean waitforElementVisible(By locator)
{
	wait= new WebDriverWait(driver, AppConstants.TIMEOUT_WAIT);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	return true;
}


}
