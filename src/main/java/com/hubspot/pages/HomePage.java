package com.hubspot.pages;

import org.openqa.selenium.By;

import com.hubspot.base.BasePage;
import com.hubspot.util.ElementUtil;

public class HomePage extends BasePage {
	
ElementUtil elementutil=new ElementUtil();
	
	By maincontacts= By.id("nav-primary-contacts-branch");
	By subcontacts= By.id("nav-secondary-contacts");
	
public ContactPage goToContact()
{
	elementutil.waitforElementPresent(maincontacts);
	elementutil.doClick(maincontacts);
	elementutil.waitforElementPresent(subcontacts);
	elementutil.doClick(subcontacts);
	
	return new ContactPage();
}
	
	

}
