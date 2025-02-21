package com.automation.pages.web;

import com.automation.interfaces.StayListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebStayListingPage extends WebBasePage implements StayListingPage {

    @FindBy(xpath = "//a[@data-stid=\"open-hotel-information\"]")
    List<WebElement> stayList;

    @FindBy(xpath = "//button[@data-stid=\"submit-hotel-reserve\"]")
    WebElement reserveButton;

    @FindBy(xpath = "//button[@data-stid=\"submit-hotel-reserve\"]//span[text()=\"Pay at property\"]")
    WebElement payAtPropertyButton;

    @FindBy(className = "hotel-summary-name")
    WebElement hotelName;

    @FindBy(className = "room-summary")
    WebElement roomDetails;

    @FindBy(xpath = "//div[@class='duration']")
    WebElement roomDuration;

    @FindBy(className = "price-container")
    WebElement roomPrice;

    @FindBy(xpath = "//span[@data-price-update=\"totalTaxes\"]")
    WebElement taxPrice;

    @FindBy(xpath = "//span[@data-price-update=\"extraGuestCharge\"]")
    WebElement extraGuestCharge;

    @FindBy(xpath = "//span[@data-price-update=\"total\"]")
    WebElement totalPrice;

    public void clickOnFirstStay() {
        stayList.getFirst().click();
    }

    public void clickOnReserveButton() {
        switchToNewWindow();
        reserveButton.click();
    }

    public void clickOnPayAtPropertyOption() {
        if (isDisplayed(payAtPropertyButton)) {
            payAtPropertyButton.click();
        }
    }

    public void printStayDetails() {
        System.out.println("Hotel Name :- " + hotelName.getText());
        System.out.println("Room Details:- " + roomDetails.getText());
        System.out.println("Timings:- \n" + roomDuration.getText());

    }

    public void printPriceDetails() {
        System.out.println("Room Price :- " + roomPrice.getText());
        System.out.println("Taxes:- " + taxPrice.getText());
        if (isDisplayed(extraGuestCharge)) {
            System.out.println("Extra Guest Charge:- " + extraGuestCharge.getText());
        }
        System.out.println("Total Price:- " + totalPrice.getText());
    }

    public boolean isStayListingPageDisplayed() {
        return stayList.getFirst().isDisplayed();
    }

    public boolean isStayReviewPageDisplayed() {
        return hotelName.isDisplayed();
    }


}
