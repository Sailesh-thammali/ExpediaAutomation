package com.automation.pages.web;

import com.automation.interfaces.CarSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebCarSearchPage extends WebBasePage implements CarSearchPage {

    @FindBy(xpath = "//button[contains(@aria-label,'Pick-up')]")
    WebElement fromElement;

    @FindBy(xpath = "//input[contains(@placeholder,'Pick-up')]")
    WebElement fromCityInput;

    @FindBy(xpath = "//button[contains(@data-stid,'pick_up_location-result-item')]")
    List<WebElement> fromCityList;

    @FindBy(xpath = "//button[contains(@aria-label,'Same as pick-up, Drop-off')]")
    WebElement toElement;

    @FindBy(xpath = "//input[contains(@data-stid,'drop_off_location-menu-input')]")
    WebElement toCityInput;

    @FindBy(xpath = "//button[contains(@data-stid,'drop_off_location-result-item-button')]")
    List<WebElement> toCityList;

    @FindBy(xpath = "//button[contains(@data-testid,'uitk-date-selector-input1-default')]")
    WebElement calendarElement;

    @FindBy(xpath = "//span[contains(@class,'uitk-align-center uitk-month-label')]")
    WebElement monthAndYear;

    @FindBy(xpath = "//button[contains(@data-stid,'uitk-calendar-navigation-controls-next-button')]")
    WebElement nextButton;

    String XPATH_DATE_VALUE = "//div[contains(@class,'uitk-date-number uitk-date-number-default uitk-type-300 uitk-type-regular') and text()='%s']";

    @FindBy(xpath = "//button[text()='Done']")
    WebElement calendarDoneButton;

    @FindBy(id = "pick_up_time")
    WebElement pickUpTimeElement;

    @FindBy(id = "drop_off_time")
    WebElement dropOffTimeElement;

    @FindBy(id = "search_button")
    WebElement searchButton;

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

    public void enterFromDate(String date) {
        calendarElement.click();
        String expMonthYear = getFormattedDate("MMMM yyyy", date, "dd/MM/yyyy");
        String actMonthYear = monthAndYear.getText();
        while (!expMonthYear.equalsIgnoreCase(actMonthYear)) {
            nextButton.click();
            actMonthYear = monthAndYear.getText();
        }

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

    public void enterPickupAndDropOffTime(String pickUpTime, String dropOffTime) {
        Select pickUpSelect = new Select(pickUpTimeElement);
        pickUpSelect.selectByVisibleText(pickUpTime);

        Select dropOffSelect = new Select(dropOffTimeElement);
        dropOffSelect.selectByVisibleText(dropOffTime);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public boolean isCarSearchPageDisplayed() {
        return searchButton.isDisplayed();
    }
}
