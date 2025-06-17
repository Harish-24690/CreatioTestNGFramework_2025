package com.creatio.crm.applicatiom.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.web.commons.WebCommons;

public class SignupPageElements extends WebCommons{
	
	@FindBy(xpath="//input[@data-placeholder='Business email']")
	protected WebElement BussinessEmailField;
	
	@FindBy(xpath="//input[@data-placeholder='Password']")
	protected WebElement PasswordField;
	
	@FindBy(xpath="//mat-checkbox[@formcontrolname='acceptedPrivacyPolicyControl']")
	protected WebElement PrivacyPolicyCheckBox;
	
	@FindBy(xpath="//span[text()=' CONTINUE ']")
	protected WebElement ContinueButton;
	
	@FindBy(xpath="//input[contains(@data-qa,'input-full')]")
	protected WebElement SignupNameField;
	
	@FindBy(xpath="//input[contains(@data-qa,'company')]")
	protected WebElement CompanyField;
	
	@FindBy(xpath="//input[contains(@name,'country')]")
	protected WebElement CountryField;
	
	@FindBy(xpath="//input[contains(@name,'phone')]")
	protected WebElement PhoneNumberField;
	
	@FindBy(xpath="//span[contains(text(),' SIGN')]")
	protected WebElement SignUPButton;
	
	@FindBy(xpath="//span[contains(text(),'BACK')]")
	protected WebElement BackButton;

}
