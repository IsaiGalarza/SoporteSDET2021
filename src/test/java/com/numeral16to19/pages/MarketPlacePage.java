package com.numeral16to19.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MarketPlacePage {

	WebDriver driver;

	By ldapPanel = By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/div[2]/div/div[1]");
	By btnRequestLdap = By.id("buyBtn1");
	
	By integrationPanel = By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/div[3]/div/div[1]");	
	By btnInstallIntegration = By.id("installButton2");
	
	By corporatePanel = By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/div[4]/div/div[1]");	
	By btnRequestCorporate = By.id("buyBtn3");
	
	By claimPanel = By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/div[5]/div/div[1]");	
	By btnRequestClaim = By.id("buyBtn4");
	
	By encabezado = By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]");
	By detalleLdap = By.id("des1");
	By detalleIntegration = By.id("des2");
	By detalleCorporate = By.id("des3");
	By detalleClaim = By.id("des4");
	By resultadoCompra = By.cssSelector("#addon_div");
	
	public MarketPlacePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLdapPanel() {
		driver.findElement(ldapPanel).click();
	}
	
	public void clickBtnRequestLdap() {
		driver.findElement(btnRequestLdap).click();
	}
	
	public void clickIntegrationPanel() {
		driver.findElement(integrationPanel).click();
	}
	
	public void clickBtnInstallIntegration() {
		driver.findElement(btnInstallIntegration).click();
	}
	
	public void clickCorporatePanel() {
		driver.findElement(corporatePanel).click();
	}
	
	public void clickBtnRequestCorporate() {
		driver.findElement(btnRequestCorporate).click();
	}
	
	public void clickClaimPanel() {
		driver.findElement(claimPanel).click();
	}
	
	public void clickBtnRequestClaim() {
		driver.findElement(btnRequestClaim).click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getEncabezado() {
		return driver.findElement(encabezado).getText();
	}
	
	public WebElement getDetalleLdap() {
		return driver.findElement(detalleLdap);
	}
	
	public WebElement getDetalleIntegration() {
		return driver.findElement(detalleIntegration);
	}
	
	public WebElement getDetalleCorporate() {
		return driver.findElement(detalleCorporate);
	}
	
	public WebElement getDetalleClaim() {
		return driver.findElement(detalleClaim);
	}
	
	public WebElement getResultadoCompra() {
		return driver.findElement(resultadoCompra);
	}
}
