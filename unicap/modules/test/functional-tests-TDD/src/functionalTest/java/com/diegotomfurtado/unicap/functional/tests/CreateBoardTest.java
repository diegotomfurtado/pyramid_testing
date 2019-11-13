package com.diegotomfurtado.unicap.functional.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.diegotomfurtado.unicap.functional.pages.BoardPage;
import com.diegotomfurtado.unicap.functional.pages.LoginPage;
import com.diegotomfurtado.unicap.functional.utils.CommonMethods;
import com.liferay.gs.testFramework.FunctionalTest;

/**
 * 
 * @author Diego Furtado
 * 
 */

public class CreateBoardTest extends FunctionalTest {

	@Before
	public void setUpAll_withBestPractives() {

		_commonMethods.setUpAll();
		_loginPage.performLogin();
	}

	@Test
	public void validateIfAUserCouldCreateANewBoard() {

		_bordPage.selectTheOptionToCreateANewBoard();
		String inputName = _bordPage.typeTheNameOfTheBoard();
		_bordPage.clickOnSubmitButtonToCreateTheBoard();

		Assert.assertTrue(_bordPage.theBoardWasSucessfulyCreated().contains(inputName));
	}

	BoardPage _bordPage = new BoardPage();
	CommonMethods _commonMethods = new CommonMethods(getWebDriver());
	LoginPage _loginPage = new LoginPage();

}
