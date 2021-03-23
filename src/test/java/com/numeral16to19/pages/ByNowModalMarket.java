package com.numeral16to19.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ByNowModalMarket {
	
	WebDriver driver;

	By email = By.cssSelector("#email");
	By contactNumber = By.cssSelector("#contactNumber");	
	By organization = By.cssSelector("#organization");		
	By btnOk = By.cssSelector("#modal_confirm_buy");	
	By btnCancel = By.cssSelector("#buyNowModal > div.modal-footer > input.btn.cancel");	
	By btnCerrar = By.xpath("//*[@id=\"buyNowModal\"]/div[1]/a");
	
	public ByNowModalMarket(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickBtnOk() {
		driver.findElement(btnOk).click();
	}
	
	public void clickBtnCancel() {
		driver.findElement(btnCancel).click();
	}
	
	public void clickBtnCerrar() {
		driver.findElement(btnCerrar).click();
	}
	
	public void setEmail(String strEmail) {
		driver.findElement(email).sendKeys(strEmail);
	}
	
	public void setContactNumber(String strContactNumber) {
		driver.findElement(contactNumber).sendKeys(strContactNumber);
	}
	
	public void setOrganization(String strOrganization) {
		driver.findElement(organization).sendKeys(strOrganization);
	}
	
	public void confirmBuy(String email, String contactNumber, String organization) {
		this.setEmail(email);
		this.setContactNumber(contactNumber);
		this.setOrganization(organization);		
		this.clickBtnOk();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
