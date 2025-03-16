package com.automation.pages.web;

import com.automation.interfaces.StayListingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebStayListingPage extends WebBasePage implements StayListingPage {

    @FindBy(xpath = "//a[@data-stid='open-hotel-information']")
    List<WebElement> stayList;

    String AMENITIES_XPATH = "//span[@class='uitk-button-toggle-label-text' and text()='%s']";
    String AMENITIES_HOTEL_XPATH = "//div[contains(@class,'uitk-text truncate') and contains(text(),'%s')]";

    @FindBy(xpath = "//button[@data-stid='submit-hotel-reserve']")
    WebElement reserveButton;

    @FindBy(xpath = "//button[@data-stid='submit-hotel-reserve']//span[text()='Pay at property']")
    WebElement payAtPropertyButton;

    @FindBy(className = "hotel-summary-name")
    WebElement hotelName;

    @FindBy(className = "room-summary")
    WebElement roomDetails;

    @FindBy(xpath = "//div[@class='duration']")
    WebElement roomDuration;

    @FindBy(className = "price-container")
    WebElement roomPrice;

    @FindBy(xpath = "//span[@data-price-update='totalTaxes']")
    WebElement taxPrice;

    @FindBy(xpath = "//span[@data-price-update='extraGuestCharge']")
    WebElement extraGuestCharge;

    @FindBy(xpath = "//span[@data-price-update='total']")
    WebElement totalPrice;

    @FindBy(xpath = "//input[@data-tealeaf-name='firstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@data-tealeaf-name='lastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@data-tealeaf-name='email']")
    WebElement emailInput;

    @FindBy(xpath = "//button[@id='complete-booking']")
    WebElement completeButton;

    @FindBy(xpath = "//p[contains(@class,'uitk-validation-error') and contains(text(),'Please')]")
    WebElement errorMessage;

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
        takeScreenshot("WebStayBookingDetails");
    }

    public boolean isStayListingPageDisplayed() {
        return stayList.getFirst().isDisplayed();
    }

    public void clickOnFilterOption(String filterName) {
        WebElement filter = driver.findElement(By.xpath(String.format(AMENITIES_XPATH, filterName)));
        pause(2000);
        filter.click();
    }

    public boolean isFilterOptionDisplayed(String filterName) {
        WebElement amenities = driver.findElement(By.xpath(String.format(AMENITIES_HOTEL_XPATH, filterName)));
        waitForElementVisible(amenities);
        return amenities.isDisplayed();
    }

    public boolean isStayReviewPageDisplayed() {
        return hotelName.isDisplayed();
    }

    public void fillDetails(String firstname, String lastname, String email) {
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        emailInput.sendKeys(email);
    }

    public void clickOnCompleteBookingButton() {
        completeButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        System.out.println(errorMessage.getText());
        takeScreenshot("WebStayDetailsError");
        return errorMessage.isDisplayed();
    }
}
