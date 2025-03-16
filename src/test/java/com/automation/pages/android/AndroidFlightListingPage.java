package com.automation.pages.android;

import com.automation.interfaces.FlightListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidFlightListingPage extends AndroidBasePage implements FlightListingPage {
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.expedia.bookings:id/uds_button_label']")
    WebElement filterBtn;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id='com.expedia.bookings:id/standard_fare'])[1]")
    WebElement flight;

    @FindBy(xpath = "//android.view.View[@content-desc='Sort by Button Recommended']")
    WebElement sortOptions;

    @FindBy(xpath = "//android.widget.TextView[@text='Price (highest to lowest)']")
    WebElement highToLowOption;

    @FindBy(xpath = "//android.widget.TextView[@text='Price (lowest to highest)']")
    WebElement lowToHighOption;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='buttonLabel']")
    WebElement doneBtn;


    @Override
    public void clickOnFirstFlight() {
        flight.click();
    }

    @Override
    public boolean isFlightListingPageDisplayed() {
        return filterBtn.isDisplayed();
    }

    @Override
    public void clickOnSortLowToHighOption() {
        filterBtn.click();
        sortOptions.click();
        lowToHighOption.click();
        doneBtn.click();

    }

    @Override
    public void clickOnSortHighToLowOption() {

        filterBtn.click();
        sortOptions.click();
        highToLowOption.click();
        doneBtn.click();
    }

}
