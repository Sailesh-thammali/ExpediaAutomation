package com.automation.pages.web;

import com.automation.interfaces.CarListingPage;
import com.automation.interfaces.FlightListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebCarListingPage extends WebBasePage implements CarListingPage {
    @FindBy(xpath = "//button[@data-auto-id='bookButton']")
    List<WebElement> carSelectButton;

    @FindBy(xpath = "//div[@data-auto-id='pickUpLocationReadOnly']")
    WebElement pickUpSummary;

    @FindBy(xpath = "//div[@data-auto-id='dropOffUpLocationReadOnly']")
    WebElement dropOffSummary;

    @FindBy(className = "ct-prominent-size")
    List<WebElement> vehicleDetails;

    @FindBy(className = "ct-total-price")
    WebElement vehiclePrice;

    public void clickOnFirstCar() {
        carSelectButton.getFirst().click();
    }

    @Override
    public void printCarDetails() {
        System.out.println("---------------");
        System.out.println("Car Type:- " + vehicleDetails.getFirst().getText());
        System.out.println("Car Name:- " + vehicleDetails.getLast().getText());
        System.out.println("Car Fee:- " + vehiclePrice.getText());

    }

    public void printLocationDetails() {
        switchToNewWindow();
        String text = pickUpSummary.getText();
        String[] lines = text.split("\n");
        String pickUpLocation = lines[0];
        String dateTime = lines[1];
        System.out.println("Pick-up:- " + pickUpLocation);
        System.out.println("Date & Time:- " + dateTime);
        System.out.println("---------------");
        String text1 = dropOffSummary.getText();
        String[] lines1 = text1.split("\n");
        String dropOffLocation = lines1[0];
        String dateAndTime = lines1[1];
        System.out.println("Drop Off :- " + dropOffLocation);
        System.out.println("Date & Time:- " + dateAndTime);

    }

    public boolean isCarListingPageDisplayed() {
        return carSelectButton.getFirst().isDisplayed();
    }
}
