package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.applicatiom.elements.ForgotLoginElements;

public class ForgotLoginSteps extends ForgotLoginElements{
	
	public ForgotLoginSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyForgotLoginHeader(String ForgotLoginPageHeader) {
		waitForElement(ForgotLoginHeader);
		Assert.assertEquals(getElementText(ForgotLoginHeader),ForgotLoginPageHeader);
		log("Pass","Forgot login Page header has beeb verified");
	}

}
