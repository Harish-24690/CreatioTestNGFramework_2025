package com.creatio.crm.application.steps;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.applicatiom.elements.HomePageElements;


public class HomePageSteps extends HomePageElements {

	public HomePageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnNewFolder() {
		waitForElement(NewFolderButton);
		click(NewFolderButton);
		log("Pass", "Clicked on New Folder Link");
	}

	public void clickONNewProcess() {
		waitForElement(NewProcessButton);
		click(NewProcessButton);
		log("Pass", "Clicked on New process Link");
	}

	public void verifyLeftPanelLinks() {
		waitForElement(HomePageHeader);
		waitForElement(HRProcessLink);
		waitForElement(SalesProcessLink);
		waitForElement(ServiceProcessLink);
		waitForElement(NewFolderButton);
		waitForElement(NewProcessButton);
		log("Pass", "All links in the homepage are Displayed and Verified");
	}

	public void LogoutFromApplication() {
		waitForElement(ProfileButton);
		click(ProfileButton);
		click(LogoutButton);
		log("Pass", "Logout from Application Successfully -clicking on logoutbutton");
	}

	public void verifyHomePageIsDisplayed(String expHeader) {
		waitForElement(HomePageHeader);
		Assert.assertEquals(getElementText(HomePageHeader), expHeader);
		log("pass", "Login page header text verified successfully");
		
	}

}
