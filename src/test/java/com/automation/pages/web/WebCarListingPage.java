package com.automation.pages.web;

import com.automation.interfaces.CarListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebCarListingPage extends WebBasePage implements CarListingPage {
    @FindBy(xpath = "//button[@data-auto-id='bookButton']")
    List<WebElement> carSelectButton;

    @FindBy(xpath = "//div[@data-auto-id=\"txtPassengers\"]")
    List<WebElement> noOfPassengers;

    @FindBy(xpath = "//div[@for=\"passengers-99\"]")
    WebElement passengersButton;

    @FindBy(xpath = "(//button[@aria-label=\"Sort by Price\"])[2]")
    WebElement sortByPriceButton;

    @FindBy(xpath = "//div[@class=\"ct-price-container\"]")
    List<WebElement> carPrices;

    @FindBy(xpath = "//div[@data-auto-id='pickUpLocationReadOnly']")
    WebElement pickUpSummary;

    @FindBy(xpath = "//div[@data-auto-id='dropOffUpLocationReadOnly']")
    WebElement dropOffSummary;

    @FindBy(className = "ct-prominent-size")
    List<WebElement> vehicleDetails;

    @FindBy(className = "ct-total-price")
    WebElement vehiclePrice;

    List<Double> beforePrices = new ArrayList<>();
    List<Double> afterPrices;

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

    public void clickOnPassengersBox() {
        passengersButton.click();
        pause(3000);
    }

    public boolean isNoOfPassengersDisplayed() {
        for (WebElement pass : noOfPassengers) {
            if (!pass.getText().contains("7")) {
                return false;
            }

        }
        return true;
    }

    public void clickOnSortLowToHighOption() {
        beforePrices = beforeCarPrices();
        sortByPriceButton.click();
        pause(3000);
    }

    private List<Double> beforeCarPrices() {
        pause(3000);
        for (int i = 0; i < carPrices.size(); i++) {
            beforePrices.add(i, Double.parseDouble(carPrices.get(i).getText().replace("₨ ", "").replace(",", "")));
        }
        return beforePrices;
    }

    public boolean isPriceLowToHigh() {
        afterPrices = new ArrayList<>();
        for (int i = 0; i < carPrices.size(); i++) {
            afterPrices.add(i, Double.parseDouble(carPrices.get(i).getText().replace("₨ ", "").replace(",", "")));
        }
        Collections.sort(beforePrices);
        return beforePrices.equals(afterPrices);
    }

    public boolean isCarListingPageDisplayed() {
        return carSelectButton.getFirst().isDisplayed();
    }

    public boolean isCarReviewPageDisplayed() {
        switchToNewWindow();
        return pickUpSummary.isDisplayed();
    }
}
