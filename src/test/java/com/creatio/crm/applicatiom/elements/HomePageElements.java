package com.creatio.crm.applicatiom.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.web.commons.WebCommons;

public class HomePageElements extends WebCommons{
	
	@FindBy(xpath="//mat-label[text()='All processes']")
	protected WebElement HomePageHeader;
	
	@FindBy(xpath="//span[@class='account-name']")
	protected WebElement UserProfileName;
	
	@FindBy(xpath="//mat-label[@title='HR processes']")
	protected WebElement HRProcessLink;
	
	@FindBy(xpath="//mat-label[@title='Sales processes']")
	protected WebElement SalesProcessLink;
	
	@FindBy(xpath="//mat-label[@title='Service processes']")
	protected WebElement ServiceProcessLink;
	
	@FindBy(xpath="(//mat-icon[@role='img'][normalize-space()='icon_tree_arrow_close_16'])[1]")
	protected WebElement HRProcessExpandButton;
	
	@FindBy(xpath="(//mat-icon[@role='img'][normalize-space()='icon_tree_arrow_close_16'])[2]")
	protected WebElement SalesProcessExpandButton;
	
	@FindBy(xpath="(//mat-icon[@role='img'][normalize-space()='icon_tree_arrow_close_16'])[3]")
	protected WebElement ServiceProcessExpandButton;
	
	@FindBy(xpath="//mat-label[text()='New folder']")
	protected WebElement NewFolderButton;
	
	@FindBy(xpath="//mat-label[text()='New process']")
	protected WebElement NewProcessButton;
	
	@FindBy(css="button[data-qa='userProfileMenu'] mat-icon[role='img']")
	protected WebElement ProfileButton;	
	
	@FindBy(xpath="//span[text()=' Log out ']")
	protected WebElement LogoutButton;
	
	
	

}
