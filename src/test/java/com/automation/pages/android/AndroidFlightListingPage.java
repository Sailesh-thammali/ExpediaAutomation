package com.automation.pages.android;

import com.automation.interfaces.FlightListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidFlightListingPage extends AndroidBasePage implements FlightListingPage {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.expedia.bookings:id/uds_button_label\"]")
    WebElement filterBtn;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.expedia.bookings:id/standard_fare\"])[1]")
    WebElement flight;

    @Override
    public void clickOnFirstFlight() {
        flight.click();
    }

    @Override
    public boolean isFlightListingPageDisplayed() {
        return filterBtn.isDisplayed();
    }
}
