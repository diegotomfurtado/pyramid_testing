package com.diegotomfurtado.unicap.functional.testsSuite;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.diegotomfurtado.unicap.functional.tests.CreateBoardTest;
import com.liferay.gs.testFramework.core.ConcurrentSuite;
import com.liferay.gs.testFramework.driver.WebDriverManager;

/**
 * 
 * @author Diego Furtado
 * 
 */

@RunWith(ConcurrentSuite.class)
@SuiteClasses(
{ 
	CreateBoardTest.class 
})

public class RunAllTests {

	@AfterClass
	public static void afterClass() {
		_webDriverManager.quitAll();
	}

	private static WebDriverManager _webDriverManager = new WebDriverManager();

}
