package com.numeral16to19.test;

import org.testng.Assert;
import org.testng.annotations.*;

import com.numeral16to19.pages.ByNowModalMarket;
import com.numeral16to19.pages.HomePage;
import com.numeral16to19.pages.InstallConfModalMarket;
import com.numeral16to19.pages.LoginPage;
import com.numeral16to19.pages.MarketPlacePage;
import com.numeral16to19.pages.MiDriver;

public class TestMarketPlace extends MiDriver {
	
	MarketPlacePage objMarket;
	ByNowModalMarket objByNow;
	InstallConfModalMarket objInstall;
	HomePage objHome;
	LoginPage objLogin;
	
	String url = "https://opensource-demo.orangehrmlive.com/";
	
	//Necesario si no se ejecuta el suite desde testng.xml
	/*
	@BeforeSuite
	public void iniciarDriver() {
		getdriver();
	}
	*/
	
	public void iniciarSesion() {		
		objLogin = new LoginPage(driver);
		objLogin.iniciarSesion("Admin", "admin123");	
		
		objHome = new HomePage(driver);
	}
	
	@Test(priority = 3)
	public void visitarMarketPlace() throws InterruptedException {		
		this.iniciarSesion();
		objHome.goToMarketPlace();
		
		Thread.sleep(2000);
		
		objMarket = new MarketPlacePage(driver);
		
		Assert.assertTrue(objMarket.getEncabezado().equalsIgnoreCase("OrangeHRM Addons"));		
	}
	
	@Test(priority = 4)
	public void verDetalleLdap() throws InterruptedException {
		objMarket.clickLdapPanel();		
		Thread.sleep(2000);
		Assert.assertTrue(objMarket.getDetalleLdap().isDisplayed());		
	}
	
	@Test(priority = 5)
	public void verDetalleIntegration() throws InterruptedException {
		objMarket.clickIntegrationPanel();		
		Thread.sleep(2000);
		Assert.assertTrue(objMarket.getDetalleIntegration().isDisplayed());		
	}
	
	@Test(priority = 6)
	public void verDetalleCorporate() throws InterruptedException {
		objMarket.clickCorporatePanel();
		Thread.sleep(2000);
		Assert.assertTrue(objMarket.getDetalleCorporate().isDisplayed());		
	}
	
	@Test(priority = 7)
	public void verDetalleClaim() throws InterruptedException {
		objMarket.clickClaimPanel();
		Thread.sleep(2000);
		Assert.assertTrue(objMarket.getDetalleClaim().isDisplayed());		
	}
	
	@Test(priority = 8)
	public void confirmarCompraLdap() throws InterruptedException {

		objMarket.clickBtnRequestLdap();
		Thread.sleep(2000);
		
		objByNow = new ByNowModalMarket(driver);
		confirmarCompra();		
		Assert.assertTrue(objMarket.getResultadoCompra().isDisplayed());
	}
	
	@Test(priority = 9)
	public void instalarIntegration() throws InterruptedException {
		objHome.goToMarketPlace();
		Thread.sleep(2000);
		objMarket.clickBtnInstallIntegration();
		Thread.sleep(2000);
		
		objInstall = new InstallConfModalMarket(driver);
		objInstall.clickBtnConfirm();
		
		Assert.assertTrue(objInstall.getResultoInstall().isDisplayed());
	}
	
	@Test(priority = 10)
	public void confirmarCompraCorporate() throws InterruptedException {
		objHome.goToMarketPlace();
		Thread.sleep(3000);
				
		objMarket.clickBtnRequestCorporate();
		Thread.sleep(2000);
		
		confirmarCompra();		
		Assert.assertTrue(objMarket.getResultadoCompra().isDisplayed());
	}
	
	@Test(priority = 11)
	public void confirmarCompraClaim() throws InterruptedException {
		objHome.goToMarketPlace();
		Thread.sleep(2000);
	
		objMarket.clickBtnRequestClaim();
		Thread.sleep(2000);
		
		confirmarCompra();		
		Assert.assertTrue(objMarket.getResultadoCompra().isDisplayed());
	}
	
	public void confirmarCompra()
	{
		objByNow.setEmail("prueba@hotmail.com");
		objByNow.setContactNumber("593999999999");
		objByNow.setOrganization("Prueba");
		objByNow.clickBtnOk();
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
