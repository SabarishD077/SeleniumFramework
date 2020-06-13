package com.hubspot.pages;

import org.openqa.selenium.By;

import com.hubspot.base.BasePage;
import com.hubspot.util.ElementUtil;
import com.hubspot.util.JavascriptUtil;

public class ContactPage extends BasePage {
	ElementUtil elementutil=new ElementUtil();
	
	
	By createcontact= By.xpath("//span[text()='Create contact']");
	By Email = By.name("textInput");
	By Firstname = By.xpath("//input[@data-field='firstname']");
	By Lastname = By.xpath("//input[@data-field='lastname']");
	By Jobtitle = By.xpath("//input[@data-field='jobtitle']");
	By createcontacts = By.xpath("(//button[@type='button']//span[text()='Create contact'])[position()=2]");
	
	public void createContacts(String mail, String FN, String LN, String JT)
	{
	
		elementutil.waitforElementPresent(createcontact);
		elementutil.doClick(createcontact);
		elementutil.waitforElementPresent(Email);
		elementutil.doSendKeys(Email, mail);
		elementutil.doSendKeys(Firstname, FN);
		elementutil.doSendKeys(Lastname, LN);
		elementutil.doSendKeys(Jobtitle, JT);
		elementutil.waitforElementPresent(createcontacts);
		JavascriptUtil.clickElementByJS(elementutil.getElement(createcontacts));
		System.out.println("****Contact Creates Successfully****");
	}
	
	
	

}
