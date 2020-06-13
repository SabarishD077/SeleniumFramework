package com.hubspot.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.listeners.TestAllureListener;
import com.hubspot.pages.ContactPage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.AppConstants;
import com.hubspot.util.ExcelUtil;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Listeners({TestAllureListener.class})
public class ContactPageTest extends BasePage {
	LoginPage loginpage= new LoginPage();
	HomePage homepage= new HomePage();
	ContactPage contactpage=new ContactPage();
	
@BeforeMethod
public void setUp() 
{
	launchBrowser();
	loginpage.doLogin(prop.getProperty("Emailaddress"), prop.getProperty("Password"));
	contactpage=homepage.goToContact();
}

@DataProvider
public Object[][] getContactsTestData()
{
	Object[][] data= ExcelUtil.getTestData(AppConstants.SHEET_NAME);
	return data;
}
@Story("123459- Hubspot Create user contact validation")
@Severity(SeverityLevel.CRITICAL)
@Test(priority=1, dataProvider= "getContactsTestData")
public void testcreateContacts(String mail, String firstname, String lastname, String jobtitle )
{
	contactpage.createContacts(mail, firstname, lastname, jobtitle);
}
	
@AfterMethod
public void tearDown()
{
	closeBrowser();
}

}
