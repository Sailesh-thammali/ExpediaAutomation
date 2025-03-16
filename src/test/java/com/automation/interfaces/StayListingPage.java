package com.automation.interfaces;

public interface StayListingPage {
    void clickOnFirstStay();

    void clickOnReserveButton();

    void clickOnPayAtPropertyOption();

    void printStayDetails();

    void printPriceDetails();

    boolean isStayListingPageDisplayed();

    boolean isStayReviewPageDisplayed();

    void fillDetails(String firstname, String lastname, String email);

    void clickOnCompleteBookingButton();

    boolean isErrorMessageDisplayed();

    void clickOnFilterOption(String filterName);

    boolean isFilterOptionDisplayed(String filterName);
}
