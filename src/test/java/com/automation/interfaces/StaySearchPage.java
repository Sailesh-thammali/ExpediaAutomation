package com.automation.interfaces;

public interface StaySearchPage {
     void enterCity(String city);
     void enterFromDate(String date);
     void enterToDate(String date);
     void enterNoOfTravellers(String noOfAdults);
     void clickOnSearchButton();
    boolean isStaySearchPageDisplayed();
    boolean isCarReviewPageDisplayed();

}
