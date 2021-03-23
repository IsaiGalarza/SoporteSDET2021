package com.numeral21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class AccesoAdminSteps {

	
	WebDriver driver = null;
	
	@Before
	public void beforeScenary1() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	

	@Given("Cuando este en la aplicacion OrangeHRP")
	public void cuando_este_en_la_aplicacion_orange_hrp() throws InterruptedException {

		
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(2000);
		
	}

	@When("Inicie sesion en la aplicacion")
	public void inicie_sesion_en_la_aplicacion() throws InterruptedException {
		
		// username
		WebElement fieldUsername = driver.findElement(By.cssSelector("#txtUsername"));
		fieldUsername.sendKeys("Admin");
		Thread.sleep(2000);

		// password
		WebElement fieldPassword = driver.findElement(By.cssSelector("#txtPassword"));
		fieldPassword.sendKeys("admin123");
		Thread.sleep(2000);

		// botón login
		WebElement btnLogin = driver.findElement(By.cssSelector("#btnLogin"));
		btnLogin.click();
		Thread.sleep(2000);
		
	}

	@And("Haga clic en el menu Admin")
	public void haga_clic_en_el_menu_admin() {
		
		WebElement adminOption = driver.findElement(By.id("menu_admin_viewAdminModule"));
		adminOption.click();
			
	}

	@Then("la pagina del panel esta disponible")
	public void la_pagina_del_panel_esta_disponible() {		
		Assert.assertTrue(driver.findElement(By.id("systemUser-information")).isDisplayed());		
	}
	
	
	@After
	public void afterScenary1() {
		try {
			driver.close();
			driver.quit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
