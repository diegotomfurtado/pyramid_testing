package com.diegotomfurtado.unicap.functional.pages;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.gs.testFramework.FunctionalTest;
import com.liferay.gs.testFramework.utils.SeleniumWaitMethods;

public class DashboardPage extends FunctionalTest {

	public void selectFirstSite() {

		SeleniumWaitMethods.findElementWithWaitDriver(getWebDriver(), _bySiteName,
				ExpectedConditions::visibilityOfElementLocated, ExpectedConditions::elementToBeClickable);

		WebElement siteRow = getWebDriver().findElement(_bySiteName);

		siteRow.click();
	}

	public void selectSite(String siteName) {
		SeleniumWaitMethods.findElementWithWaitDriver(getWebDriver(), _bySiteName,
				ExpectedConditions::visibilityOfElementLocated, ExpectedConditions::elementToBeClickable);

		Optional<WebElement> siteRow = getWebDriver().findElements(_bySiteName).stream()
				.filter(e -> e.getText().equals(siteName)).findAny();

		if (!siteRow.isPresent()) {
			throw new RuntimeException("Could not find a site row for site with name '" + siteName + "' on the page");
		}

		WebElement siteElement = siteRow.get();
		siteElement.click();
	}

	private final By _bySiteName = By.cssSelector(".site-name");
}
