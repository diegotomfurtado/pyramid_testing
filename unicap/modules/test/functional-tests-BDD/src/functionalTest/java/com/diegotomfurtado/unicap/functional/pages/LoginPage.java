package com.diegotomfurtado.unicap.functional.pages;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;

import com.diegotomfurtado.unicap.functional.utils.CommonMethods;
import com.liferay.gs.testFramework.FunctionalTest;
import com.liferay.gs.testFramework.core.SeleniumReadPropertyKeys;

public class LoginPage extends FunctionalTest {

	public void clickOnSignInButton() {
		_commonMethods.clickOnTheElement(_clickOnSignInButtonLocator);
	}

	public void typeUserOnLoginForm(String userLogin) {

		_commonMethods.input(_typeOnUserLocator, userLogin);
	}

	public void typePasswordOnLoginForm(String passwordLogin) {

		_commonMethods.input(_typeOnPasswordLocator, passwordLogin);
	}

	public void performLogin() {
		typeUserOnLoginForm(SeleniumReadPropertyKeys.getDefaultUsername());
		typePasswordOnLoginForm(SeleniumReadPropertyKeys.getDefaultPassword());
		clickOnSignInButton();
	}

	public void returnPageButton() {

		_commonMethods.getCurrentURL();
	}

	CommonMethods _commonMethods = new CommonMethods(getWebDriver());

	// Fields
	private static final By _typeOnUserLocator = xpath("//*[@id='user']");
	private static final By _typeOnPasswordLocator = xpath("//*[@id='password']");

	// Buttons
	private static final By _clickOnSignInButtonLocator = xpath("//*[@id='login']");

}
