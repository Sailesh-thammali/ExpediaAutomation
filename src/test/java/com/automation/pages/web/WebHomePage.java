package com.automation.pages.web;

import com.automation.interfaces.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WebHomePage extends WebBasePage implements HomePage {

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement signInElement;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInButton;

    @FindBy(xpath = "//span[contains(text(),'Flights')]")
    WebElement flightsOption;

    @FindBy(xpath = "//span[contains(text(),'Cars')]")
    WebElement carsOption;

    @FindBy(xpath = "//span[contains(text(),'Stays')]")
    WebElement staysOption;

    @FindBy(xpath = "//div[contains(@data-testid,'memberprofile-mediumview')]")
    WebElement accountElement;

    @FindBy(xpath = "//div[text()='Sign out']")
    WebElement signOutButton;

    @FindBy(xpath = "//button[@data-stid=\"button-type-picker-trigger\"]")
    WebElement regionButton;

    @FindBy(id = "site-selector")
    WebElement regionSelector;

    @FindBy(id = "language-selector")
    WebElement languageSelector;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveButton;


    public void openApplication() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    public void clickOnSignInButton() {
        // signInElement.click();
        signInButton.click();
    }

    public boolean isHomePageDisplayed() {
        return flightsOption.isDisplayed();
    }

    public void clickOnAccountElement() {
        accountElement.click();
    }

    public void clickOnSignOutButton() {
        pause(1000);
        signOutButton.click();
    }

    public boolean isAccountElementDisplayed() {
        pause(5000);
        return accountElement.isDisplayed();
    }

    public boolean isSignInElementDisplayed() {
        pause(2000);
        return signInElement.isDisplayed();
    }

    public void clickOnFlightsOption() {
        flightsOption.click();
    }

    public void clickOnCarsOption() {
        carsOption.click();
    }

    public void clickOnStaysOption() {
        staysOption.click();
    }

    public void clickOnRegionButton() {
        regionButton.click();
    }

    public boolean isRegionOptionDisplayed() {
        return saveButton.isDisplayed();
    }

    public void selectRegionOption(String region) {
        Select select = new Select(regionSelector);
        select.selectByVisibleText(region);
    }

    public void selectLanguageOption(String language) {
        Select select = new Select(languageSelector);
        select.selectByVisibleText(language);
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public boolean isSelectedLanguageDisplayed(String language) {
        return regionButton.getText().equals(language);
    }
}
