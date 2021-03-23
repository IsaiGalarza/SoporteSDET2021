package com.numeral16to19.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassPage {

	WebDriver driver;

	By userName = By.id("securityAuthentication_userName");
	By btnResetPass = By.id("btnSearchValues");
	By btnCancelar = By.id("btnCancel");	
	By message = By.cssSelector("div[class='message warning fadable']");

	public ForgotPassPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUserName(String strUserName) {
		driver.findElement(userName).sendKeys(strUserName);
	}	

	public void clickBtnResetPass() {
		driver.findElement(btnResetPass).click();
	}

	public void clickBtnCancel() {
		driver.findElement(btnCancelar).click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getMessage() {
		return driver.findElement(message).getText();
	}

	public void resetPassword(String strUserName) {
		this.setUserName(strUserName);
		this.clickBtnResetPass();		
	}
}
