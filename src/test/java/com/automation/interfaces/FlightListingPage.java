package com.automation.interfaces;

public interface FlightListingPage {
    void clickOnFirstFlight();

    boolean isFlightListingPageDisplayed();

    default void clickOnSortLowToHighOption() {

    }

    default void clickOnSortHighToLowOption() {

    }

    default boolean isPriceLowToHigh() {
        return false;
    }

    default boolean isPriceHighToLow() {
        return false;
    }

    default void clickOnAirIndiaFilter() {

    }

    default boolean isSelectedFlightShown(String company) {
        return false;
    }

    default void clickOnDirectFilter() {

    }

    default boolean isSelectedStopsShown(String stops) {
        return false;
    }
}
