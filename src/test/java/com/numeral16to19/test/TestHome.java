package com.numeral16to19.test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.numeral16to19.pages.HomePage;
import com.numeral16to19.pages.LoginPage;
import com.numeral16to19.pages.MiDriver;

public class TestHome extends MiDriver{

	LoginPage objLogin;
	HomePage objHome;
		
	String url = "https://opensource-demo.orangehrmlive.com/";

	//Necesario si no se ejecuta suite desde testng.xml
	/*
	@BeforeSuite
	public void iniciarDriver() {
		getdriver();
	}
	*/	
	
	@Test(priority = 1)
	public void validarDashBoard() throws InterruptedException {
		objLogin = new LoginPage(driver);
		objLogin.iniciarSesion("Admin","admin123");
		
		Thread.sleep(2000);
		
		objHome = new HomePage(driver);
		objHome.clickDashboardOption();
		
		System.out.println(driver.getCurrentUrl());
		
		Assert.assertTrue(objHome.getDashboard().isDisplayed());
	}
	
	@Test(priority = 2)
	public void accederMarketPlace() throws InterruptedException {
	
		objHome.goToMarketPlace();
		
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/marketPlace/ohrmAddons"));
	}
	
	
	@Test(priority = 3)
	public void irASuscribe() throws InterruptedException
	{
		objHome.goToSusbscribe();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/index.php/pim/subscriber"));
	}
	
	@Test(priority = 4)
	public void irAHelp()
	{
		objHome.goToHelp();		
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/index.php/help"));
	}
	
	@Test(priority = 5)
	public void verNotificaciones() throws InterruptedException
	{
		objHome.clickNotificaciones();		
		Thread.sleep(2000);
		Assert.assertTrue(objHome.getNotificaciones().isDisplayed());
	}
	
	@Test(priority = 6)
	public void verInformacionApp() throws InterruptedException
	{
		objHome.clickNotificaciones();
		objHome.clickWelcomeOption();
		Thread.sleep(2000);
		objHome.clickAboutOption();
		Thread.sleep(2000);
		
		Assert.assertTrue(objHome.getAboutModal().isDisplayed());
	}
	
	@Test(priority = 7)
	public void salirApp() throws InterruptedException
	{
		objHome.cerrarAboutModal();
		objHome.clickLogOutOption();
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/auth/login"));
	}
		
	//Necesario si no se ejecuta suite desde testng.xml
	/*
	@AfterSuite
	public void finalizar()
	{
		finalizarDriver();
	}
	*/
}
