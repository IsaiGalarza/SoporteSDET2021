package com.numeral06to9;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

public class TestPaginas {

	WebDriver driver;

	@BeforeSuite
	public void iniciarDriver() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Test(priority = 1)
	public void iniciarSesion() {
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
		WebElement password = driver.findElement(By.cssSelector("#txtPassword"));
		WebElement bntLogin = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));

		userName.sendKeys("Admin");
		password.sendKeys("admin123");
		bntLogin.click();
	}

	@Test(priority = 2)
	public void goToAdmin() throws InterruptedException {
		WebElement adminOption = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]"));
		adminOption.click();
		
		Thread.sleep(2000);

		System.out.println("Título página Admin:" + driver.getTitle());
	}

	@Test(priority = 3)
	public void goToPim() throws InterruptedException {
		WebElement pimOption = driver.findElement(By.cssSelector("#menu_pim_viewPimModule"));
		pimOption.click();
		
		Thread.sleep(2000);

		System.out.println("Título página PIM:" + driver.getTitle());
	}

	@Test(priority = 4)
	public void goToLeave() throws InterruptedException {
		WebElement leaveOption = driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]"));
		leaveOption.click();

		Thread.sleep(2000);
		
		System.out.println("Título página Leave:" + driver.getTitle());
	}

	@Test(priority = 5)
	public void goToDashboard() throws InterruptedException {
		WebElement dashboardOption = driver.findElement(By.cssSelector("#menu_dashboard_index"));
		dashboardOption.click();

		Thread.sleep(2000);
		
		System.out.println("Título página Dashboard:" + driver.getTitle());
	}

	@Test(priority = 6)
	public void goToDirectry() throws InterruptedException {
		WebElement directryOption = driver.findElement(By.xpath("//*[@id=\"menu_dashboard_index\"]"));
		directryOption.click();

		Thread.sleep(2000);
		
		System.out.println("Título página Directry:" + driver.getTitle());
	}

	@Test(priority = 7)
	public void goToMaintenance() throws InterruptedException {
		WebElement maintenanceOption = driver.findElement(By.cssSelector("#menu_maintenance_purgeEmployee"));
		maintenanceOption.click();

		Thread.sleep(2000);
		
		System.out.println("Título página Maintenance:" + driver.getTitle());

	}
	
	public void minimizarPantalla()
	{
		driver.manage().window().setPosition(new Point(0, -1000));	
	}
	
	@AfterSuite
	public void finalizarDriver() throws InterruptedException
	{
		minimizarPantalla();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
