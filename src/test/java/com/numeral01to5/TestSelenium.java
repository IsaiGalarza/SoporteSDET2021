package com.numeral01to5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 * Implementación de numerales: 1, 2, 3, 4, 5
 */
public class TestSelenium {
	
	WebDriver driver;
	
	@BeforeTest
	public void configuraciones() {

		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(priority = 1)
	public void verificarTitulo()
	{
		//Imprimir título página
		System.out.println("Título: " + driver.getTitle());		
	}
	
	@Test(priority = 2)
	public void login()
	{
		// imgLogo
		WebElement imgLogo = driver.findElement(By.cssSelector("#divLogo > img")); // cssSelector
		//WebElement imgLogo = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")); //xpath

		// imgCircle
		WebElement imgCircle = driver.findElement(By.cssSelector("#divLoginImage > svg > switch > g > circle:nth-child(14)")); //cssSelector
		//WebElement imgCircle = driver.findElement(By.xpath("//*[@id=\"divLoginImage\"]/svg/switch/g/circle[3]")); // xpath	
				 
		// caja de texto username
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")); // xpath
		//WebElement userName = driver.findElement(By.cssSelector("#txtUsername"));	//cssSelector
		
		// caja de texto contraseña
		WebElement password = driver.findElement(By.cssSelector("#txtPassword")); // cssSelector
		//WebElement password = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));	//xpath
		
		// botón login
		WebElement bntLogin = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")); // xpath
		//WebElement bntLogin = driver.findElement(By.cssSelector("#btnLogin")); //cssSelector

		// Enlace Olvido su clave
		WebElement lnkForgotPass = driver.findElement(By.cssSelector("#forgotPasswordLink > a")); // cssSelector
		//WebElement lnkForgotPass = driver.findElement(By.xpath("//*[@id=\"forgotPasswordLink\"]/a")); //xpath
		
		//Iniciar sesion
		userName.sendKeys("Admin");
		password.sendKeys("admin123");		
		bntLogin.click();		
	}
	
	@Test(priority = 3)
	public void verificarDashBoard()
	{
		System.out.println(driver.findElement(By.cssSelector("#content > div > div.head > h1")).isEnabled());
		Assert.assertTrue(driver.findElement(By.cssSelector("#content > div > div.head > h1")).isEnabled());	
	}
	
	@Test(priority = 4)
	public void verificarPaginaInicio() throws InterruptedException
	{
		WebElement admin = driver.findElement(By.cssSelector("#menu_admin_viewAdminModule > b"));
		admin.click();
		
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.findElement(By.cssSelector("#menu_admin_UserManagement")).isDisplayed()
				&& driver.findElement(By.cssSelector("#menu_admin_Job")).isDisplayed()
				&& driver.findElement(By.cssSelector("#menu_admin_Organization")).isDisplayed()
				&& driver.findElement(By.cssSelector("#menu_admin_Qualifications")).isDisplayed());			
	}
	
	@AfterTest
	public void finalizar()
	{
		try {
			driver.close();
			driver.quit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
