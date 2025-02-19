package com.automation.pages.web;

import com.automation.interfaces.ReviewPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebFlightReviewPage extends WebBasePage implements ReviewPage {
    @FindBy(xpath = "//span[contains(text(),'Show details')]")
    WebElement showDetailsButton;

    @FindBy(xpath = "//div[contains(@data-stid,'journey-part-0')]")
    WebElement flightInformation;

    @FindBy(xpath = "//div[contains(@class,'uitk-table-container')]")
    WebElement priceSummary;

    @FindBy(xpath = "//h3[contains(text(),'₹')]")
    WebElement totalPrice;

    public void printFlightInformation() {
        showDetailsButton.click();
        String flightInfoText = flightInformation.getText().trim();

        String[] lines = flightInfoText.split("\n");

        String departureTime = "";
        String departureLocation = "";
        String departureAirport = "";
        String duration = "";
        String flightName = "";
        String flightType = "";
        String flightClass = "";
        String arrivalTime = "";
        String arrivalLocation = "";
        String arrivalAirport = "";

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.contains("Departure")) {
                departureTime = lines[i + 1].trim();
                departureLocation = lines[i + 2].trim();
                departureAirport = lines[i + 3].trim();
            } else if (line.matches("\\d+h \\d+m flight")) {
                duration = line.trim();
            } else if (line.matches("[A-Za-z]+ \\d+")) {
                flightName = line.trim();
            } else if (line.matches("[A-Za-z]+ [A-Za-z0-9]+")) {
                flightType = line.trim();
            } else if (line.contains("Economy") || line.contains("Business") || line.contains("Premium")) {
                flightClass = line.trim();
            } else if (line.contains("Arrival")) {
                arrivalTime = lines[i + 1].trim();
                arrivalLocation = lines[i + 2].trim();
                arrivalAirport = lines[i + 3].trim();
            }
        }
        System.out.println("--- Flight Information ---");
        System.out.println("Departure:- " + departureLocation);
        System.out.println(departureAirport);
        System.out.println();
        System.out.println("Duration :- " + duration);
        System.out.println("Flight Name :- " + flightName);
        System.out.println("Flight Type :- " + flightType);
        System.out.println("Class :- " + flightClass);
        System.out.println();
        System.out.println("Arrival:- " + arrivalLocation);
        System.out.println(arrivalAirport);
        System.out.println();

    }

    public void printPriceDetails() {
        System.out.println("--- Price Details ---");
        String priceSummaryText = priceSummary.getText().trim();
        String[] lines = priceSummaryText.split("\n");

        int travellerCount = 0;
        String travellerInfo = "";
        String flightInfo = "";
        String taxesInfo = "";

        for (String line : lines) {
            line = line.trim();
            if (line.contains("More information")) {
                continue;
            }
            if (line.contains("Traveller")) {
                travellerCount++;
                travellerInfo = line.split(":")[1].trim();
                System.out.println("Traveller " + travellerCount + ": " + travellerInfo + " :- " + getNextPrice(lines, travellerCount));
            } else if (line.contains("Flight")) {
                flightInfo = getNextPrice(lines, travellerCount);
                System.out.println("Flight :- " + flightInfo);
            } else if (line.contains("Taxes, fees and charges")) {
                taxesInfo = getNextPrice(lines, travellerCount);
                System.out.println("Taxes, fees and charges :- " + taxesInfo);
            }
        }
        System.out.println("Total price :- " + totalPrice.getText());
        takeScreenshot("WebFlightBooking");
    }

    public boolean isReviewPageDisplayed() {
        switchToNewWindow();
        return showDetailsButton.isDisplayed();
    }

    private static String getNextPrice(String[] lines, int travellerCount) {
        String price = "";
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].trim().contains("Traveller " + travellerCount)) {
                if (i + 1 < lines.length) {
                    price = lines[i + 1].trim();
                    break;
                }
            }
        }
        return price;
    }
}
