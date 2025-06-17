package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.applicatiom.elements.SignupPageElements;

public class SignupPageSteps extends SignupPageElements {
	
	public SignupPageSteps(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

	public void enterBussinessEmailId(String emailID, String password) {
		waitForElement(BussinessEmailField);
		enterElement(BussinessEmailField, emailID);
		log("Pass", "Email has been added successfully");

		waitForElement(PasswordField);
		enterElement(PasswordField, password);
		log("Pass", "Password has been added Successfully");

	}

	public void checkThePrivacybutton() {
		waitForElement(PrivacyPolicyCheckBox);
		selectCheckBox(PrivacyPolicyCheckBox, false);
		log("Pass", "Privacy checkbox has been selected");

	}

	public void clickOnContinueButton() {

		waitForElement(ContinueButton);
		click(ContinueButton);
		log("Pass", "Clicked on Continue button");
	}

	public void enterNameToSignUp(String userName) {
		waitForElement(SignupNameField);
		enterElement(SignupNameField, userName);
		log("Pass", "UserName has been entered" + userName);
	}

	public void enterCompanyNameToSignUp(String company) {
		waitForElement(CompanyField);
		enterElement(CompanyField, company);
		log("Pass", "CompanyName has been entered" + company);

	}

	public void enterCountryNameToSignUp(String country) {
		waitForElement(CountryField);
		enterTextUsingActions(CountryField, country);
		selectDropdownOption(CountryField, country, "visibletext");
		log("Pass", "Country has been entered" + country);
	}

	public void enterPhoneNumber(String phoneNumber) {
		waitForElement(PhoneNumberField);
		enterElement(PhoneNumberField, phoneNumber);
		log("Pass", "PhoneNumber has been entered" + phoneNumber);
	}
	
	public void clickOnSignUpButton() {
		waitForElement(SignUPButton);
		click(SignUPButton);
		log("Pass","Signup button has been clicked");
	}

}
