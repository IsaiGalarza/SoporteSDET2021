package com.numeral22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class AccesoJobSteps {

	WebDriver driver = null;

	
	@Before
	public void beforeScenary2() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Given("He iniciado sesion en la aplicacion Orange")
	public void he_iniciado_sesion_en_la_aplicacion_orange() throws InterruptedException {
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(2000);

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

	@When("Cuando hago clic en el enlace Administrador")
	public void cuando_hago_clic_en_el_enlace_administrador() {
		WebElement adminOption = driver.findElement(By.id("menu_admin_viewAdminModule"));
		adminOption.click();
	}

	@And("Haga clic en Job")
	public void haga_clic_en_job() {
		WebElement jobOption = driver.findElement(By.cssSelector("#menu_admin_Job"));
		jobOption.click();
	}

	@And("Validar texto")
	public void validar_texto() {
		WebElement jobList = driver.findElement(By.xpath("//*[@id=\"mainMenuFirstLevelUnorderedList\"]/li[1]/ul/li[2]/ul"));
		System.out.println(jobList.getText());
	}

	@Then("Titulo del Job")
	public void titulo_del_job() {		
		Assert.assertTrue(driver.findElement(By.cssSelector("#menu_admin_viewJobTitleList")).isDisplayed());
	}
	
	
	@After
	public void afterScenary2() {
		try {
			driver.close();
			driver.quit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
