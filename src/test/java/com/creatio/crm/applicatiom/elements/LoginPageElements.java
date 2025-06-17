package com.creatio.crm.applicatiom.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.web.commons.WebCommons;

public class LoginPageElements extends WebCommons{
	
	
	@FindBy(xpath="//span[@class='form-title']")
	protected WebElement header;
	
	@FindBy(xpath = "//input[@id='email']")
	protected WebElement emailInputField;
	
	@FindBy(xpath = "//input[@id='pass']")
	protected WebElement passwordInputField;
	
	@FindBy(xpath="//span[text()=' LOG IN ']")
	protected WebElement loginButton;
	
   @FindBy(xpath="//a[contains(text(),'Forgot')]")
   protected WebElement forgotPassLink;
   
   @FindBy(xpath="//img[@class='icon-google']")
   protected WebElement googleLoginLink;
   
   @FindBy(xpath="//img[@class='icon-facebook']")
   protected WebElement facebookLoginLink;
   
   @FindBy(xpath="//a[text()='Sign up']")
   protected WebElement signUpLink;
   
   @FindBy(xpath="//div[contains(@aria-label,'Open Intercom')]")
   protected WebElement ChatWindowButton;
   
   @FindBy(xpath="//div[contains(@data-testid,'minimize')]")
   protected WebElement minimizeChatWindow;
   
   @FindBy(xpath="//mat-error[text()='Email is required']")
   protected WebElement EmailLoginErrorMessage;
   
   @FindBy(xpath="//mat-error[text()='Password is required']")
   protected WebElement PasswordLoginErrorMessage;
   
   @FindBy(xpath="//mat-error[text()='Invalid email or password']")
   protected WebElement InvalidLoginErrorMessage;
   
   
   
	
	

}
