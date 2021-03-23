package com.numeral10to12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class MiDriver {
	
	public static WebDriver driver;
	
	public static void inicializarDriver()
	{
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	public static void iniciarSesion(String usuario, String clave)
	{
		WebElement userName = driver.findElement(By.cssSelector("#txtUsername"));			
		WebElement password = driver.findElement(By.cssSelector("#txtPassword")); 		
		WebElement bntLogin = driver.findElement(By.cssSelector("#btnLogin")); 
		
		userName.sendKeys(usuario);
		password.sendKeys(clave);		
		bntLogin.click();		
	}
	
	public static WebElement getDashboard() {
		return driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1"));
	}
	
	public static  void capturarPantalla(String resultado)
	{
		Shutterbug.shootPage(driver)
        .withName("resultado_listener_" + resultado )                
        .save(); 
	}
	
	public static void finalizar()
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
