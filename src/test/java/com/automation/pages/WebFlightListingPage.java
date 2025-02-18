package com.automation.pages;

import com.automation.interfaces.FlightListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebFlightListingPage extends WebBasePage implements FlightListingPage {

    @FindBy(xpath = "//div[contains(@data-test-id,\"offer-card\")]")
    List<WebElement> flightsList;

    @FindBy(xpath = "//button[contains(@stid,\"select-button\")]")
    WebElement selectButton;

    @FindBy(xpath = "//a[text()='No thanks']")
    WebElement  noThanksButton;

    public void clickOnFirstFlight(){
        flightsList.getFirst().click();
        selectButton.click();
        if(isDisplayed(noThanksButton)){
            noThanksButton.click();
        }
    }

    public boolean isFlightListingPageDisplayed(){
        flightsList.getFirst().isDisplayed();
    }




}
