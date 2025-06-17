package com.creatio.crm.applicatiom.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.web.commons.WebCommons;

public class GoogleLoginPageElements extends WebCommons{
	
	@FindBy(xpath="//button[contains(@data-destination-info,'creatio.com')]")
	protected WebElement VerifyGoogleLogin;
	

}
