package com.automation.pages.web;

import com.automation.interfaces.StaySearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebStaySearchPage extends WebBasePage implements StaySearchPage {

    @FindBy(xpath = "//button[contains(@aria-label,'Where to?')]")
    WebElement cityElement;

    @FindBy(xpath = "//input[contains(@placeholder,'Where to?')]")
    WebElement cityInput;

    @FindBy(xpath = "//button[contains(@data-stid,'destination_form_field-result-item-button')]")
    List<WebElement> cityList;

    @FindBy(xpath = "//button[contains(@data-testid,'uitk-date-selector-input1-default')]")
    WebElement calendarElement;

    @FindBy(xpath = "//span[contains(@class,'uitk-align-center uitk-month-label')]")
    WebElement monthAndYear;

    @FindBy(xpath = "//button[contains(@data-stid,'uitk-calendar-navigation-controls-next-button')]")
    WebElement nextButton;

    String XPATH_DATE_VALUE = "//div[contains(@class,'uitk-date-number uitk-date-number-default uitk-type-300 uitk-type-regular') and text()='%s']";

    @FindBy(xpath = "//button[text()='Done']")
    WebElement calendarDoneButton;

    @FindBy(xpath = "//button[contains(@data-stid,'open-room-picker')]")
    WebElement travellersButton;

    @FindBy(xpath = "(//span[@class='uitk-step-input-button'])[2]")
    WebElement adultsButton;

    @FindBy(id = "traveler_selector_done_button")
    WebElement travellersDoneButton;

    @FindBy(id = "search_button")
    WebElement searchButton;

    public void enterCity(String city) {
        cityElement.click();
        cityInput.sendKeys(city);
        cityList.getFirst().click();
    }

    public void enterFromDate(String date) {
        calendarElement.click();
        String expMonthYear = getFormattedDate("MMMM yyyy", date, "dd/MM/yyyy");
        String actMonthYear = monthAndYear.getText();
        while (!expMonthYear.equalsIgnoreCase(actMonthYear)) {
            nextButton.click();
            actMonthYear = monthAndYear.getText();
        }
        pause(2000);
        String dateValue = getFormattedDate("dd", date, "dd/MM/yyyy");
        WebElement dateElement = driver.findElement(By.xpath(String.format(XPATH_DATE_VALUE, dateValue)));
        dateElement.click();

    }

    public void enterToDate(String date) {
        String expMonthYear = getFormattedDate("MMMM yyyy", date, "dd/MM/yyyy");
        String actMonthYear = monthAndYear.getText();
        while (!expMonthYear.equalsIgnoreCase(actMonthYear)) {
            nextButton.click();
            actMonthYear = monthAndYear.getText();
        }
        String dateValue = getFormattedDate("dd", date, "dd/MM/yyyy");
        WebElement dateElement = driver.findElement(By.xpath(String.format(XPATH_DATE_VALUE, dateValue)));
        dateElement.click();
        calendarDoneButton.click();
    }

    public void enterNoOfTravellers(String noOfAdults) {
        travellersButton.click();
        for (int i = 0; i < Integer.parseInt(noOfAdults) - 2; i++) {
            waitForElementClickable(adultsButton);
            adultsButton.click();
        }
        travellersDoneButton.click();
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public boolean isStaySearchPageDisplayed() {
        return searchButton.isDisplayed();
    }
}
