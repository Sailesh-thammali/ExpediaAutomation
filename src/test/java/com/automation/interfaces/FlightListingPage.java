package com.automation.interfaces;

public interface FlightListingPage {
    void clickOnFirstFlight();

    boolean isFlightListingPageDisplayed();

    void clickOnSortLowToHighOption();

    void clickOnSortHighToLowOption();

    boolean isPriceLowToHigh();

    boolean isPriceHighToLow();

    void clickOnAirIndiaFilter();

    boolean isSelectedFlightShown(String company);

    void clickOnDirectFilter();

    boolean isSelectedStopsShown(String stops);
}
