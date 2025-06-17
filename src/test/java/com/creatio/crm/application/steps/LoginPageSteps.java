package com.creatio.crm.application.steps;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.applicatiom.elements.LoginPageElements;
import com.creatio.crm.framework.utilities.PropUtil;

public class LoginPageSteps extends LoginPageElements {

	Properties prop = PropUtil.readData("Config.properties");
	
	public LoginPageSteps(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

	public void launchTheApplication() {
		launchApplication();
		Assert.assertEquals(getTitle(), prop.getProperty("APP_TITLE"), "Application title mismatch after launch.");
		log("pass", "Application launched successfully");

	}

	public void loginPageHeader(String expHeader) {
		waitForElement(header);
		Assert.assertEquals(header, expHeader);
		log("pass", "Login page header text verified successfully");
	}

	/*
	 * public void verifyLoginPageLogo() { waitForElement(logo);
	 * Assert.assertTrue(isElementDisplayed(logo),
	 * "Login page logo is not visible."); log("pass",
	 * "Login page logo verified successfully"); }
	 */

	public void enterCredentials(String userName, String password) {
		waitForElement(emailInputField);
		enterElement(emailInputField, userName);
		log("pass", "Email has been entered successfully" + userName);

		waitForElement(passwordInputField);
		enterElement(passwordInputField, password);
		log("pass", "password has been entered successfully" + password);

	}

	public void clickOnLogoinButton() {
		waitForElement(loginButton);
		click(loginButton);
		log("pass", "Clicked on login button");
	}

	public void verifyEmailLoginErrorMessage() {
		waitForElement(EmailLoginErrorMessage);
		Assert.assertTrue(isElementDisplayed(EmailLoginErrorMessage),
				"Login error message not displayed on invalid email.");
		log("pass", "Email Login error message verified successfully");
	}

	public void verifyPasswordLoginErrorMessage() {
		waitForElement(PasswordLoginErrorMessage);
		Assert.assertTrue(isElementDisplayed(PasswordLoginErrorMessage),
				"Login error message not displayed on invalid password.");
		log("pass", "Password error message verified successfully");
	}
	
	

	public void clickOnForgotLoginLink() {
		waitForElement(forgotPassLink);
		click(forgotPassLink);
		log("info", "Clicked on forgot password link");
	}

	public void verifyChatButton() {
		waitForElement(ChatWindowButton);
		click(ChatWindowButton);
		log("info", "chat window button is verified");
	}

	public void verifyGoogleLoginlink() {
		waitForElement(googleLoginLink);
		jsClick(googleLoginLink);
//		click(googleLoginLink);
		log("info", "clicked on google login button");
	}

	public void verifyFacebookLoginLink() {
		waitForElement(facebookLoginLink);
		click(facebookLoginLink);
		log("info", "clicked on facebooklogin link");
	}
	
	public void verifySignInLink() {
		waitForElement(signUpLink);
		click(signUpLink);
		log("info","Clicked on SignUpLink");
	}

	public void verifyLogoutSuccessful() {
		waitForElement(header);
		Assert.assertTrue(isElementDisplayed(header), "Login page header not displayed after logout.");
		log("pass", "Logout is successful, Login page header text is displayed");
	}

	public void verifyInvalidLoginErrorMessage(String expectedErrorMessage) {
		waitForElement(InvalidLoginErrorMessage);
		String actualErrorMessage = getElementText(InvalidLoginErrorMessage);
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match expected.");
		log("pass", "Error message verified successfully: " + actualErrorMessage);
		
	}
}
