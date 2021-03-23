package com.numeral16to19.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MiDriver {

	public static WebDriver driver;

	public void inicializarDriver() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	public  WebDriver getdriver() {
		if (driver == null) {
			inicializarDriver();
			return driver;
		} else {
			return driver;
		}
	}
	
	public void finalizarDriver()
	{
		driver.close();
		driver.quit();
	}

}
