package com.numeral13;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

//Implementación numeral 13
public class TestShutterbug {

	WebDriver driver;

	@BeforeTest
	public void configuraciones() {

		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	public void iniciarSesion()
	{
		WebElement userName = driver.findElement(By.cssSelector("#txtUsername"));			
		WebElement password = driver.findElement(By.cssSelector("#txtPassword")); 		
		WebElement bntLogin = driver.findElement(By.cssSelector("#btnLogin")); 
		
		userName.sendKeys("Admin");
		password.sendKeys("admin123");		
		bntLogin.click();		
	}
	
	@Test
	public void pruebaPIM() throws InterruptedException {
				
		iniciarSesion();
		
		String nombre = "Linda Anderson";
		
		WebElement opcionPim = driver.findElement(By.cssSelector("#menu_pim_viewPimModule"));
		opcionPim.click();
		
		Thread.sleep(2000);
		
		WebElement employeeName = driver.findElement(By.cssSelector("#empsearch_employee_name_empName"));
		employeeName.sendKeys(nombre);
		
		Thread.sleep(2000);
		
		WebElement btnBuscar = driver.findElement(By.id("searchBtn"));
		btnBuscar.click();
		
		Thread.sleep(2000);
	
        Shutterbug.shootPage(driver)                
                .withName("Employee_List")                
                .save(); 
        
        WebElement resultadoBusqueda = driver.findElement(By.cssSelector("#resultTable > tbody > tr > td"));		
		Assert.assertTrue(!resultadoBusqueda.getText().contentEquals("No Records Found"));
	}
	
	@AfterTest
	public void finalizar()
	{
		
	}
}
