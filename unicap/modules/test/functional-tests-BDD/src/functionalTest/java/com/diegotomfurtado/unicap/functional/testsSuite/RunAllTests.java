package com.diegotomfurtado.unicap.functional.testsSuite;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.liferay.gs.testFramework.driver.WebDriverManager;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

/**
 * 
 * @author Diego Furtado
 * 
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		snippets = SnippetType.CAMELCASE, 
		dryRun = false, 
		features = {
			"src/functionalTest/resources/com/diegotomfurtado/unicap/functional/createboard/CreateBoard.feature"
				},
		glue = { "com.diegotomfurtado.unicap.functional.steps"}, 
		tags = {
			"@TestRun",
			"~@ignore" 
		})

public class RunAllTests {

	@AfterClass
	public static void afterClass() {
		_webDriverManager.quitAll();
	}

	private static WebDriverManager _webDriverManager = new WebDriverManager();

}
