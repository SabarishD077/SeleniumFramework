package com.hubspot.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.hubspot.base.BasePage;

public class JavascriptUtil extends BasePage {
	
public static String getPageInnerText()
{
	JavascriptExecutor js=((JavascriptExecutor)driver);
	String pageinnertext=js.executeScript("return document.documentElement.innerText;").toString();
	return pageinnertext;
}

public static void flash(WebElement element)
{
	JavascriptExecutor js=((JavascriptExecutor)driver);
	String bgcolor=element.getCssValue("backgroungColor");
	for(int i=0;i<3;i++)
	{
		changeColor("rgb(0,200,0)", element);// 1
		changeColor(bgcolor, element);// 2
	
	}
}
private static void changeColor(String color, WebElement element) {
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

	try {
		Thread.sleep(20);
	} catch (InterruptedException e) {
	}
}
public static void clickElementByJS(WebElement element) {
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("arguments[0].click();", element);

}

public static void refreshBrowserByJS() {
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("history.go(0)");
}



}
