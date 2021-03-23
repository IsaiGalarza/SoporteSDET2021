package com.numeral16to19.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By userName = By.xpath("//*[@id=\"txtUsername\"]");	
	By password = By.cssSelector("#txtPassword");	
	By bntLogin = By.xpath("//*[@id=\"btnLogin\"]");
	By lnkForgotPass = By.cssSelector("#forgotPasswordLink > a"); 

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUserName(String strUserName) {
		driver.findElement(userName).sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}

	public void clickBtnLogin() {

		driver.findElement(bntLogin).click();
	}
	
	public void clickLnkForgotPass() {

		driver.findElement(lnkForgotPass).click();
	}

	public void iniciarSesion(String strUserName, String strPassword) {

		this.setUserName(strUserName);
		this.setPassword(strPassword);
		this.clickBtnLogin();
	}
}
