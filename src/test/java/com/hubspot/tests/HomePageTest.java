package com.hubspot.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.listeners.TestAllureListener;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({TestAllureListener.class})
public class HomePageTest extends BasePage{
	LoginPage loginpage= new LoginPage();
	HomePage homepage= new HomePage();
	
	@BeforeMethod
	public void setUp() 
	{
		launchBrowser();
		loginpage.doLogin(prop.getProperty("Emailaddress"), prop.getProperty("Password"));
	}
	@Story("123456- Hubspot loginpage functionalities")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void goToContactTest()
	{
		homepage.goToContact();
	}
	
	@AfterMethod
	public void tearDown()
	{
		closeBrowser();
	}

}
