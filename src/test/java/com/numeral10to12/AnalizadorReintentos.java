package com.numeral10to12;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class AnalizadorReintentos implements IRetryAnalyzer{

	int counter = 0;
	int retryLimit = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(counter < retryLimit)
		{
			counter++;
			System.out.println("Intento: " + counter );
			return true;
		}
		
		return false;
	}

	
}
