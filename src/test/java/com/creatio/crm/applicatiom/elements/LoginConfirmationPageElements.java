package com.creatio.crm.applicatiom.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.web.commons.WebCommons;

public class LoginConfirmationPageElements extends WebCommons{
	
	@FindBy(xpath="//label[text()=' Almost done! ']")
	protected WebElement ConfirmationPageHeader;
	
	@FindBy(xpath="//a[text()=' Click here ']")
    protected WebElement ClickhereLink;
}
