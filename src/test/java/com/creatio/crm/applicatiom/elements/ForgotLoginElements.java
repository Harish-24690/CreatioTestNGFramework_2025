package com.creatio.crm.applicatiom.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.web.commons.WebCommons;

public class ForgotLoginElements extends WebCommons{
	
	@FindBy(xpath="//a[@data-qa='resend-link']")
	protected WebElement ForgotLoginClickHere;
	
	@FindBy(xpath="//label[@class='title-label']")
	protected WebElement ForgotLoginHeader;

}
