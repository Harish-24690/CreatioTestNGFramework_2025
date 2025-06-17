package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.applicatiom.elements.GoogleLoginPageElements;

public class GoogleLoginPageSteps extends GoogleLoginPageElements {
	
	public GoogleLoginPageSteps(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
	public void verifyGoogleLoginPageIsDisplayed() {
		waitForElement(VerifyGoogleLogin);
		log("pass","Googleloginlink is verified");
	}
}
