package com.creatio.crm.application.tests;

import java.util.Properties;

import org.testng.annotations.Test;

import com.creatio.crm.framework.utilities.PropUtil;



public class ApplicationTest extends BaseTest {
	
	public Properties prop = PropUtil.readData("Config.properties");
	
	@Test(dataProvider="data")
	public void verifyLoginWithValidCredentials(String username,String password,String header) {
		loginPage.launchApplication();
		loginPage.enterCredentials(username,password);
		loginPage.clickOnLogoinButton();
		homePage.verifyHomePageIsDisplayed(header);
		
	}

}
