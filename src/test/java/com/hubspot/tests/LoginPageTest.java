package com.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.listeners.TestAllureListener;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.AppConstants;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({TestAllureListener.class})
public class LoginPageTest extends BasePage {
	LoginPage loginpage= new LoginPage();
	
@BeforeMethod

public void setUp() 
{
	launchBrowser();
}
@Story("123456- Hubspot loginpage functionalities")
@Severity(SeverityLevel.BLOCKER)
@Test(priority=4)
public void loginTest()
{
	loginpage.doLogin(prop.getProperty("Emailaddress"), prop.getProperty("Password"));
}
@Story("123456- Hubspot loginpage functionalities")
@Severity(SeverityLevel.MINOR)
@Test(priority=1)
public void TestSignupLink()
{
	Assert.assertTrue(loginpage.checkSignupLink());
}
@Story("123458- Hubspot page validation")
@Severity(SeverityLevel.NORMAL)
@Test(priority=2)
public void TestPageTitle()
{
	String title=loginpage.getPageTitle();
	Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
}
@Story("123458- Hubspot page validation")
@Severity(SeverityLevel.NORMAL)
@Test(priority=3)
public void TestInnerText()
{
	Assert.assertTrue(loginpage.InnerText());
}

@AfterMethod
public void tearDown()
{
	closeBrowser();
}

}
