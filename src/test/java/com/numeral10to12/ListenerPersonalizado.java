package com.numeral10to12;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerPersonalizado extends MiDriver implements ITestListener{
	
	@Override
	public void onStart(ITestContext context) {
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Prueba fallida");
		capturarPantalla("fallido");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Prueba exitosa");
		capturarPantalla("exitoso");
	}	
}
