package com.automation.pages.web;

import com.automation.interfaces.FlightListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebFlightListingPage extends WebBasePage implements FlightListingPage {

    @FindBy(xpath = "//div[contains(@data-test-id,\"offer-card\")]")
    List<WebElement> flightsList;

    @FindBy(xpath = "//button[contains(@stid,\"select-button\")]")
    WebElement selectButton;

    @FindBy(xpath = "//a[text()='No thanks']")
    WebElement noThanksButton;

    @FindBy(id = "sort-filter-dropdown-SORT")
    WebElement filterOption;

    @FindBy(xpath = "//span[@class='uitk-lockup-price']")
    List<WebElement> flightPricesList;

    @FindBy(name = "showMoreButton")
    WebElement showMoreButton;

    @FindBy(xpath = "//div[contains(@class,'uitk-text truncate') and not(contains(text(),'('))]")
    List<WebElement> flightCompanyList;

    @FindBy(xpath = "//input[contains(@value,'AI')]")
    WebElement airIndiaFilter;

    @FindBy(xpath = "//input[@name='NUM_OF_STOPS']")
    WebElement directStopFilter;

    @FindBy(xpath = "//span[@class=\"uitk-text uitk-type-300 uitk-type-medium uitk-text-positive-theme\"]")
    List<WebElement> flightStopList;

    List<Integer> beforePrices = new ArrayList<>();
    List<Integer> afterPrices;


    public void clickOnFirstFlight() {
        flightsList.getFirst().click();
        selectButton.click();
        if (isDisplayed(noThanksButton)) {
            noThanksButton.click();
        }
    }

    public boolean isFlightListingPageDisplayed() {
        return flightsList.getFirst().isDisplayed();
    }

    public void clickOnSortLowToHighOption() {
        showMoreButton.click();
        beforePrices = beforeFlightPrices();
        Select select = new Select(filterOption);
        select.selectByValue("PRICE_INCREASING");
        showMoreButton.click();
        pause(3000);
    }

    public void clickOnSortHighToLowOption() {
        showMoreButton.click();
        beforePrices = beforeFlightPrices();
        Select select = new Select(filterOption);
        select.selectByValue("PRICE_DECREASING");
        showMoreButton.click();
        pause(3000);
    }

    private List<Integer> beforeFlightPrices() {
        pause(3000);
        for (int i = 0; i < flightPricesList.size(); i++) {
            beforePrices.add(i, Integer.parseInt(flightPricesList.get(i).getText().replace("₹", "").replace(",", "")));
        }
        return beforePrices;
    }

    public boolean isPriceLowToHigh() {
        afterPrices = new ArrayList<>();
        for (int i = 0; i < flightPricesList.size(); i++) {
            afterPrices.add(i, Integer.parseInt(flightPricesList.get(i).getText().replace("₹", "").replace(",", "")));
        }
        Collections.sort(beforePrices);
        return beforePrices.equals(afterPrices);
    }

    public boolean isPriceHighToLow() {
        afterPrices = new ArrayList<>();
        for (int i = 0; i < flightPricesList.size(); i++) {
            afterPrices.add(i, Integer.parseInt(flightPricesList.get(i).getText().replace("₹", "").replace(",", "")));
        }
        Collections.sort(beforePrices);
        return beforePrices.reversed().equals(afterPrices);
    }

    public void clickOnAirIndiaFilter() {
        airIndiaFilter.click();
    }

    public boolean isSelectedFlightShown(String company) {
        pause(3000);
        for (WebElement ele : flightCompanyList) {
            if (!ele.getText().contains(company)) {
                return false;
            }
        }
        return true;
    }

    public void clickOnDirectFilter() {
        directStopFilter.click();
    }

    public boolean isSelectedStopsShown(String stops) {
        pause(3000);
        for (WebElement ele : flightStopList) {
            if (!ele.getText().contains(stops)) {
                return false;
            }
        }
        return true;

    }


}
