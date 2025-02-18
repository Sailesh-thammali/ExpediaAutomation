package com.automation.pages.web;

import com.automation.interfaces.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends WebBasePage implements HomePage {

    @FindBy(xpath = "//button[contains(text(),\"Sign in\")]")
    WebElement signInElement;

    @FindBy(xpath = "//a[contains(text(),\"Sign in\")]")
    WebElement signInButton;

    @FindBy(xpath = "//span[contains(text(),\"Flights\")]")
    WebElement flightsOption;

    @FindBy(xpath = "//div[contains(@data-testid,\"memberprofile-mediumview\")]")
    WebElement accountElement;

    @FindBy(xpath = "//div[text()=\"Sign out\"]")
    WebElement signOutButton;


    public void openApplication(){
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    public void clickOnSignInButton(){
       // signInElement.click();
        signInButton.click();
    }

    public boolean isHomePageDisplayed(){
        return flightsOption.isDisplayed();
    }

    public void clickOnAccountElement(){
        accountElement.click();
    }
    public void clickOnSignOutButton(){
        signOutButton.click();
    }

    public boolean isAccountElementDisplayed(){
        pause(5000);
        return accountElement.isDisplayed();
    }

    public boolean isSignInElementDisplayed(){
        return signInElement.isDisplayed();
    }

    public void clickOnFlightsOption(){
        flightsOption.click();
    }
}
