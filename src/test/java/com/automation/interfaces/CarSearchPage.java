package com.automation.interfaces;

public interface CarSearchPage {

    void enterFromCity(String fromCity);

    void enterToCity(String toCity);

    void enterFromDate(String date);

    void enterToDate(String date);

    void enterPickupAndDropOffTime(String pickUpTime, String dropOffTime);

    boolean isCarSearchPageDisplayed();

    void clickOnSearchButton();
}
