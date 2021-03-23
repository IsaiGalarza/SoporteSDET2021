package com.numeral23;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;


public class DirectoryPageSteps {

	WebDriver driver = null;

	
	@Before
	public void beforeScenary3() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS );
	}
	
	
	@Given("El usuario ha iniciado sesion en la aplicacion Orange")
	public void el_usuario_ha_iniciado_sesion_en_la_aplicacion_orange() throws InterruptedException {
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

	@When("Cuando hago clic en el enlace Directory")
	public void cuando_hago_clic_en_el_enlace_directory() {
		WebElement directoryOption = driver.findElement(By.cssSelector("#menu_directory_viewDirectory"));
		directoryOption.click();		
	}

	@Then("Se despliega la seccion Search Directory")
	public void se_despliega_la_seccion_search_directory() {
		Assert.assertTrue(driver.findElement(By.cssSelector("#content > div.box.searchForm.toggableForm > a")).isDisplayed());		
	}

	@And("Ingreso nombre")
	public void ingreso_nombre() {
		WebElement txtName = driver.findElement(By.cssSelector("#searchDirectory_emp_name_empName"));
		txtName.sendKeys("Linda");
	}

	@And("Hago clic en el boton Search")
	public void hago_clic_en_el_boton_search() throws InterruptedException {
		WebElement btnSearch = driver.findElement(By.cssSelector("#searchBtn"));
		btnSearch.click();
		Thread.sleep(2000);
	}

	@Then("Se despliega los usuarios que cumplan el criterio de busqueda")
	public void se_despliega_los_usuarios_que_cumplan_el_criterio_de_busqueda() {
		WebElement resultado = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]"));
		Assert.assertTrue(!resultado.getText().equalsIgnoreCase("No Records Found"));
	}

	@And("Selecciono un elemento de la lista Job Title")
	public void selecciono_un_elemento_de_la_lista_job_title() throws InterruptedException {
		WebElement jobTitleList = driver.findElement(By.cssSelector("#searchDirectory_job_title"));
				
		Select oSelect = new Select(jobTitleList);
		
		oSelect.selectByVisibleText("IT Manager");
		
		Thread.sleep(2000);
	}	

	@And("Selecciono un elemento de la lista Location")
	public void selecciono_un_elemento_de_la_lista_location() throws InterruptedException {
		WebElement locationList = driver.findElement(By.cssSelector("#searchDirectory_location"));		
		locationList.sendKeys("Texas R&D");
		Thread.sleep(2000);
	}
	
	
	@After
	public void afterScenary3() {
		try {
			driver.close();
			driver.quit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
