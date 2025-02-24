package com.automation.interfaces;

public interface FlightSearchPage {
     void clickOnOnewayOption();
    void enterFromCity(String fromCity);
    void enterToCity(String toCity);
    void enterDate(String date);
    void enterNoOfTravellers(String noOfAdults);
    void clickOnSearchButton();
    boolean isFlightSearchPageDisplayed();
    boolean isErrorDisplayed();
}
