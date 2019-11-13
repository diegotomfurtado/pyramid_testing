package com.diegotomfurtado.unicap.functional.steps;

import org.junit.Assert;
import org.junit.Before;

import com.diegotomfurtado.unicap.functional.pages.BoardPage;
import com.diegotomfurtado.unicap.functional.pages.LoginPage;
import com.diegotomfurtado.unicap.functional.utils.CommonMethods;
import com.liferay.gs.testFramework.FunctionalTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author Diego Furtado
 * 
 */

public class CreateBoardSteps extends FunctionalTest {

	@Before
	public void setUpAll_withBestPractives() {

		_commonMethods.setUpAll();
	}

	@Given("^a user is logged in on Trello Web Application$")
	public void a_user_is_logged_in_on_Trello_Web_Application() {

		_commonMethods.setUpAll();
		_loginPage.performLogin();
	}

	@When("^a user follows the steps to create a new board$")
	public void a_user_follows_the_steps_to_create_a_new_board() {

		_bordPage.clickOnAddButton();
		_bordPage.chooseCreateBoardOption();
		_inputName = _bordPage.typeTheNameOfTheBoard();
		_bordPage.clickOnCreateBoardSubmitButton();
	}

	@Then("^a user will see a new board created$")
	public void a_user_will_see_a_new_board_created() {

		Assert.assertTrue(_bordPage.checkIfBoardWasCreated().contains(_inputName));
	}

	String _inputName = null;

	BoardPage _bordPage = new BoardPage();
	CommonMethods _commonMethods = new CommonMethods(getWebDriver());
	LoginPage _loginPage = new LoginPage();
}
