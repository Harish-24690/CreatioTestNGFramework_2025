package com.creatio.crm.application.tests;

import java.util.Properties;

import org.testng.annotations.Test;

import com.creatio.crm.framework.utilities.PropUtil;



public class ApplicationTest extends BaseTest {
	
	public Properties prop = PropUtil.readData("Config.properties");
	
	@Test(priority=4, dataProvider="data")
	public void verifyLoginWithValidCredentials(String username,String password,String header) {
		loginPage.launchApplication();
		loginPage.enterCredentials(username,password);
		loginPage.clickOnLogoinButton();
		homePage.verifyHomePageIsDisplayed(header);
		
	}
	@Test(priority= 2, dataProvider = "data")
	public void verifyLoginInvalidCredentials(String username,String password,String errorMessage) {
		loginPage.launchApplication();
		loginPage.enterCredentials(username,password);
		loginPage.clickOnLogoinButton();
		loginPage.verifyInvalidLoginErrorMessage(errorMessage);
	}
	
	@Test(priority=3)
	public void verifyGoogleLogin() {
		loginPage.launchApplication();
		loginPage.verifyGoogleLoginlink();
		googleLoginPage.verifyGoogleLoginPageIsDisplayed();
	}
	@Test(priority=1,dataProvider="data")
	public void verifyForgotLoginFeature(String username ,String password,String header) {
		loginPage.launchApplication();
		loginPage.enterCredentials(username, password);
		loginPage.clickOnForgotLoginLink();
		forgotLoginPage.verifyForgotLoginHeader(header);
		
	}

}
