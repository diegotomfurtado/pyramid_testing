package com.diegotomfurtado.unicap.functional.pages;

import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;

import com.diegotomfurtado.unicap.functional.utils.CommonMethods;
import com.liferay.gs.testFramework.FunctionalTest;

public class BoardPage extends FunctionalTest {

	public void clickOnAddButton() {

		_commonMethods.clickOnTheElement(_addButtonLocator);
	}

	public void chooseCreateBoardOption() {
		
		_commonMethods.clickOnTheElement(_createBoardLinkLocator);
	}

	public String typeTheNameOfTheBoard() {

		String inputField = _commonMethods.randomContentToUseOnTestCase();
		_commonMethods.input(_addBoardTitleinputFieldLocator, inputField);
		
		return inputField;
	}

	public void clickOnCreateBoardSubmitButton() {
		
		_commonMethods.clickOnTheElement(_createBoardSubmitButtonLocator);
	}

	public String checkIfBoardWasCreated() {

		return _commonMethods.getTextFromPage(_getNameFromTheBoardLocator);
	}

	public static final By _addButtonLocator = xpath("//*[@id='header']//*[@name='add']");
	public static final By _createBoardLinkLocator = xpath("//*[@data-test-id='header-create-board-button']");
	public static final By _addBoardTitleinputFieldLocator = xpath("//*[@data-test-id='create-board-title-input']");
	public static final By _createBoardSubmitButtonLocator = xpath("//*[@data-test-id='create-board-submit-button']");
	public static final By _getNameFromTheBoardLocator = xpath(
			"//*[@id='content']//*[@class='js-board-editing-target board-header-btn-text' and text()]");

	CommonMethods _commonMethods = new CommonMethods(getWebDriver());


}