package com.numeral10to12;

import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(ListenerPersonalizado.class)
public class TestListenerReintentos extends MiDriver{
	
	@BeforeTest
	public void establecerConfiguracion()
	{
		inicializarDriver();
	}
	
	@Test(retryAnalyzer = AnalizadorReintentos.class)
	public void verificarDashboard() throws InterruptedException {
		iniciarSesion("Admin","admin123");
		System.out.println("Texto elemento: " + getDashboard().getText());
		Assert.assertTrue(getDashboard().isDisplayed());
		//Assert.assertTrue(false);
	}
	
	@AfterTest
	public void cerrarDriver()
	{
		finalizar();
	}

}
