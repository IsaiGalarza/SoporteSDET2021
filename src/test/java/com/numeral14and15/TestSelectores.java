package com.numeral14and15;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

//implementación numerales: 14 y 15
public class TestSelectores {
	
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
	
	@Test (priority = 1)
	public void cssSelectorPrueba() throws InterruptedException
	{
		iniciarSesion();
		
		WebElement pim = driver.findElement(By.cssSelector("#menu_pim_viewPimModule"));
		WebElement time = driver.findElement(By.cssSelector("#menu_time_viewTimeModule"));
		WebElement maintenance = driver.findElement(By.cssSelector("#menu_maintenance_purgeEmployee"));
		
		WebElement assignLeave = driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(1)"));
		WebElement timeSheets = driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(3)"));
		
		WebElement pastel = driver.findElement(By.cssSelector("#div_graph_display_emp_distribution"));
		
		Thread.sleep(2000);
		
		Shutterbug.shootPage(driver)
        .highlight(pim)
        .highlight(time)
        .highlight(maintenance)
        .highlight(assignLeave)
        .highlight(timeSheets)
        .highlight(pastel)       
        .withName("literal14_cssSelector")
        .save();
	}
	
	@Test(priority = 2)
	public void xpathPrueba() throws InterruptedException {
		
		WebElement admin = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]"));
		WebElement marketPlace = driver.findElement(By.xpath("//*[@id=\"MP_link\"]"));
		WebElement welcome = driver.findElement(By.xpath("//*[@id=\"welcome\"]"));
		
		WebElement leaveList = driver.findElement(By.xpath("//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[2]/div"));
				
		Thread.sleep(2000);
		
		Shutterbug.shootPage(driver)
        .highlight(admin)
        .highlight(marketPlace)
        .highlight(welcome)
        .highlight(leaveList)       
        .withName("literal15_xpath")
        .save();
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
