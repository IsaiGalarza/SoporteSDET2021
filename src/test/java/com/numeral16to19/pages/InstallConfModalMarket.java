package com.numeral16to19.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InstallConfModalMarket {
	
	WebDriver driver;

	By btnConfirm = By.cssSelector("#modal_confirm_install");	
	By btnCancel = By.cssSelector("#installConfModal > div.modal-footer > input.btn.cancel");	
	By btnCerrar = By.xpath("//*[@id=\"installConfModal\"]/div[1]/a");
	By resultadoInstall = By.cssSelector("#addon_div");
	
	public InstallConfModalMarket(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickBtnConfirm() {
		driver.findElement(btnConfirm).click();
	}
	
	public void clickBtnCancel() {
		driver.findElement(btnCancel).click();
	}
	
	public void clickBtnCerrar() {
		driver.findElement(btnCerrar).click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}	
	
	public WebElement getResultoInstall() {
		return driver.findElement(resultadoInstall);
	}
}
