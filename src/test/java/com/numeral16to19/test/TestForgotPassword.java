package com.numeral16to19.test;

import org.testng.Assert;
import org.testng.annotations.*;

import com.numeral16to19.pages.ForgotPassPage;
import com.numeral16to19.pages.LoginPage;
import com.numeral16to19.pages.MiDriver;

public class TestForgotPassword extends MiDriver {
	
	LoginPage objLogin;
	ForgotPassPage objForgot;
		
	String url = "https://opensource-demo.orangehrmlive.com/";

	@BeforeSuite
	public void iniciarDriver() {
		getdriver();
	}
	
	@Test(priority = 1)
	public void cambiarClave() throws InterruptedException {
		objLogin = new LoginPage(driver);
		objLogin.clickLnkForgotPass();
		
		objForgot = new ForgotPassPage(driver);
		objForgot.setUserName("Jadine.Jackie");
		objForgot.clickBtnResetPass();
		
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/index.php/auth/sendPasswordReset"));
	}
	
	@Test(priority = 2)
	public void desistirCambioClave()
	{
		driver.get(url);
		objLogin.clickLnkForgotPass();
		objForgot.clickBtnCancel();
		
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/index.php/auth/login"));
	}
		
	@AfterSuite
	public void finalizar()
	{
		finalizarDriver();
	}

}
