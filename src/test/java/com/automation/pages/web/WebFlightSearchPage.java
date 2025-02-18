package com.automation.pages.web;

import com.automation.interfaces.FlightSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebFlightSearchPage extends WebBasePage implements FlightSearchPage {

    @FindBy(xpath = "//span[contains(text(),\"One-way\")]")
    WebElement oneWayOption;

    @FindBy(xpath = "//button[contains(@aria-label,\"Leaving from\")]")
    WebElement fromElement;

    @FindBy(xpath = "//input[contains(@placeholder,\"Leaving from\")]")
    WebElement fromCityInput;

    @FindBy(xpath = "//button[contains(@data-stid,\"origin_select-result-item-button\")]")
    List<WebElement> fromCityList;

    @FindBy(xpath = "//button[contains(@aria-label,\"Going to\")]")
    WebElement toElement;

    @FindBy(xpath = "//input[contains(@placeholder,\"Going to\")]")
    WebElement toCityInput;

    @FindBy(xpath = "//button[contains(@data-stid,\"destination_select-result-item-button\")]")
    List<WebElement> toCityList;

    @FindBy(xpath = "//button[contains(@data-testid,\"uitk-date-selector-input1-default\")]")
    WebElement calendarElement;

    @FindBy(xpath = "//span[contains(@class,'uitk-align-center uitk-month-label')]")
    WebElement monthAndYear;

    @FindBy(xpath = "//button[contains(@data-stid,\"uitk-calendar-navigation-controls-next-button\")]")
    WebElement nextButton;

    String XPATH_DATE_VALUE = "//div[contains(@class,\"uitk-date-number uitk-date-number-default uitk-type-300 uitk-type-regular\") and text()=\"%s\"]";

    @FindBy(xpath = "//button[text()='Done']")
    WebElement calendarDoneButton;

    @FindBy(xpath = "//button[contains(@data-stid,\"open-room-picker\")]")
    WebElement travellersButton;

    @FindBy(xpath = "(//span[@class='uitk-step-input-button'])[2]")
    WebElement adultsButton;

    @FindBy(id = "travelers_selector_done_button")
    WebElement travellersDoneButton;

    @FindBy(id = "search_button")
    WebElement searchButton;

    public void clickOnOnewayOption() {
        oneWayOption.click();
    }

    public void enterFromCity(String fromCity) {
        fromElement.click();
        fromCityInput.sendKeys(fromCity);
        fromCityList.getFirst().click();
    }

    public void enterToCity(String toCity) {
        toElement.click();
        toCityInput.sendKeys(toCity);
        toCityList.getFirst().click();
    }

    public void enterDate(String date) throws InterruptedException {
        calendarElement.click();
        String expMonthYear = getFormattedDate("MMMM yyyy", date, "dd/MM/yyyy");
        String actMonthYear = monthAndYear.getText();
        while (!expMonthYear.equalsIgnoreCase(actMonthYear)) {
            System.out.println(expMonthYear);
            System.out.println(actMonthYear);
            nextButton.click();
            actMonthYear = monthAndYear.getText();
        }

        String dateValue = getFormattedDate("dd", date, "dd/MM/yyyy");
        Thread.sleep(4000);
        WebElement dateElement = driver.findElement(By.xpath(String.format(XPATH_DATE_VALUE, dateValue)));
        dateElement.click();
        calendarDoneButton.click();
    }

    public void enterNoOfTravellers(String noOfAdults) {
        travellersButton.click();
        adultsButton.click();
        travellersDoneButton.click();
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public boolean isFlightSearchPageDisplayed(){
        return searchButton.isDisplayed();
    }
}