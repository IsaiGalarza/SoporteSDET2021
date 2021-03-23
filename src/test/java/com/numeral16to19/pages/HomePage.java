package com.numeral16to19.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	
	By marketPlace = By.cssSelector("#MP_link");
	By subscribe = By.id("Subscriber_link");
	By btnnotificaciones = By.cssSelector("#notification");
	By notificacionesPanel = By.cssSelector("#notificationModal > div.modal-dialog > div");
	By helpIcon = By.xpath("//*[@id=\"branding\"]/a[3]");
	By welcomeOptions = By.id("welcome");
	By aboutOption = By.cssSelector("#welcome-menu > ul > li:nth-child(1) > a");
	By logoutOption = By.cssSelector("#welcome-menu > ul > li:nth-child(2) > a"); 
	By aboutModal = By.id("displayAbout");
	By dashBoard = By.xpath("//*[@id=\"content\"]/div/div[1]/h1");
	By cerrarAbout = By.xpath("//*[@id=\"displayAbout\"]/div/a");
	By dashboardOption = By.cssSelector("#menu_dashboard_index");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
		
	public void goToMarketPlace()
	{
		driver.findElement(marketPlace).click();
	}
	
	public void goToSusbscribe()
	{
		driver.findElement(subscribe).click();			
	}
	
	public void clickNotificaciones()
	{
		driver.findElement(btnnotificaciones).click();
	}
	
	public WebElement getNotificaciones()
	{
		return driver.findElement(notificacionesPanel);
	}
	
	public void goToHelp()
	{
		driver.findElement(helpIcon).click();
	}
	

	public void clickWelcomeOption() {
		driver.findElement(welcomeOptions).click();
	}
	
	public void clickAboutOption() {
		driver.findElement(aboutOption).click();
	}
	
	public void clickLogOutOption() {
		driver.findElement(logoutOption).click();
	}	
	
	public WebElement getAboutModal() {
		return driver.findElement(aboutModal);
	}
	
	public WebElement getDashboard() {
		return driver.findElement(dashBoard);
	}
	
	public void cerrarAboutModal()
	{
		driver.findElement(cerrarAbout).click();
	}
	
	public void clickDashboardOption() {
		driver.findElement(dashboardOption).click();
	}
}