package com.diegotomfurtado.unicap.functional.utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.gs.testFramework.FunctionalTest;
import com.liferay.gs.testFramework.core.SeleniumReadPropertyKeys;
import com.liferay.gs.testFramework.utils.SeleniumWaitMethods;

/**
 * 
 * @author Diego Furtado
 * 
 */

public class CommonMethods extends FunctionalTest {

	public CommonMethods(WebDriver webDriver) {

		_webDriver = webDriver;
	}

	public void clickOnTheElement(By locator) {

		SeleniumWaitMethods.findElementWithWaitDriver(getWebDriver(), locator,
				ExpectedConditions::visibilityOfElementLocated, ExpectedConditions::elementToBeClickable);
		_webDriver.findElement(locator).click();
	}

	public void input(By locator, String text) {

		SeleniumWaitMethods.findElementWithWaitDriver(getWebDriver(), locator,
				ExpectedConditions::visibilityOfElementLocated, ExpectedConditions::elementToBeClickable);
		getWebDriver().findElement(locator).clear();
		getWebDriver().findElement(locator).sendKeys(text);
	}

	public String getTextFromPage(By locator) {

		SeleniumWaitMethods.findElementWithWaitDriver(getWebDriver(), locator,
				ExpectedConditions::visibilityOfElementLocated);

		String getText = getWebDriver().findElement(locator).getText();
		return getText;
	}

	public void switchToNewWindowPage() throws InterruptedException {

		for (String winHandle : getWebDriver().getWindowHandles()) {

			SeleniumWaitMethods.waitMediumTime();
			getWebDriver().switchTo().window(winHandle);
		}
	}

	public void returnToPreviousPage() {

		getWebDriver().navigate().back();
	}

	public String getCurrentURL() {

		return getWebDriver().getCurrentUrl();
	}

	public void returnToPreviousWindowns() throws InterruptedException {

		switchToNewWindowPage();
	}

	public void getTimeOutImplicitWait() {

		getWebDriver().manage().timeouts().implicitlyWait(SeleniumReadPropertyKeys.getTimeOut(), TimeUnit.SECONDS);
	}

	public void goToURLPage() {

		getWebDriver().get(SeleniumReadPropertyKeys.getUrlToHome());
	}

	public void setDimensionOfTheBrowser() {

		Dimension dimension = new Dimension(1284, 900);
		getWebDriver().manage().window().setSize(dimension);
	}

	public void setUpAll() {
		getTimeOutImplicitWait();
		goToURLPage();
		setDimensionOfTheBrowser();
	}
	
	public String randomContentToUseOnTestCase() {

		Random random = new Random();
		return "Testing_" + random.nextInt(500) + "_Board";
	}

	private WebDriver _webDriver;
}