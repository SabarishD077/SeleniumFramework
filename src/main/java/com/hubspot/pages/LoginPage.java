package com.hubspot.pages;

import org.openqa.selenium.By;
import com.hubspot.base.BasePage;
import com.hubspot.util.AppConstants;
import com.hubspot.util.ElementUtil;
import com.hubspot.util.JavascriptUtil;

public class LoginPage extends BasePage {
	
	ElementUtil elementutil=new ElementUtil();
	
By username= By.id("username");
By password= By.id("password");
By login= By.id("loginBtn");
By Signup= By.linkText("Sign up");

public String getPageTitle()
{
	elementutil.waitforElementPresent(Signup);
	return elementutil.doGetTitle();
}

public boolean checkSignupLink()
{
	elementutil.waitforElementPresent(Signup);
	return elementutil.doIsDisplayed(Signup);
}

public HomePage doLogin(String Emailaddress, String Password)
{
	elementutil.waitforElementPresent(username);
	elementutil.doSendKeys(username, Emailaddress);
	elementutil.doSendKeys(password, Password);
	elementutil.doClick(login);
	
	return new HomePage();
}

public boolean InnerText()
{
	elementutil.waitforElementPresent(username);
	String pagetext=JavascriptUtil.getPageInnerText();
	System.out.println("Inner Text of login Page are: " + pagetext);
	return pagetext.contains(AppConstants.INNER_TEXT);
	
}

}
