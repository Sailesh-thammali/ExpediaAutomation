package com.automation.interfaces;

public interface CarListingPage {
    void clickOnFirstCar();

    void printCarDetails();

    boolean isCarListingPageDisplayed();

    void printLocationDetails();

    boolean isCarReviewPageDisplayed();

    void clickOnPassengersBox();

    boolean isNoOfPassengersDisplayed();

    void clickOnSortLowToHighOption();

    boolean isPriceLowToHigh();
}
