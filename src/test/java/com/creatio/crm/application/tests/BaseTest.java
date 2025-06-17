package com.creatio.crm.application.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.creatio.crm.application.steps.ForgotLoginSteps;
import com.creatio.crm.application.steps.HomePageSteps;
import com.creatio.crm.application.steps.LoginConfirmationpageSteps;
import com.creatio.crm.application.steps.LoginPageSteps;
import com.creatio.crm.application.steps.SignupPageSteps;
import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.utilities.ExcelUtil;



public class BaseTest extends BasePage{
	
	public LoginPageSteps loginPage;
	public SignupPageSteps signUPpage;
	public LoginConfirmationpageSteps confirmationPage;
	public HomePageSteps homePage;
	public ForgotLoginSteps forgotLoginPage;
	

	@BeforeMethod(alwaysRun = true,dependsOnMethods = "setupBrowser")
	public void initializePages() {
		WebDriver driver = BasePage.getDriver();
		loginPage = new LoginPageSteps(driver);
		signUPpage = new SignupPageSteps(driver);
		confirmationPage = new LoginConfirmationpageSteps(driver);
		homePage = new HomePageSteps(driver);
		forgotLoginPage = new ForgotLoginSteps(driver);
	}

	@DataProvider(name = "data")
	public String[][] testData(Method method) {
		String[][] data = ExcelUtil.readExcelData("TestData.xlsx", method.getName());
		return data;
	}
}
