package com.automation.pages.android;

import com.automation.interfaces.StaySearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidStaySearchPage extends AndroidBasePage implements StaySearchPage {

    @FindBy(xpath = "//android.widget.EditText[@resource-id='SearchLocationInput']")
    WebElement enterCityInput;

    @FindBy(xpath = "(//android.view.View[@resource-id='EGDSActionListItem'])[1]/android.widget.Button")
    WebElement selectCity;

    @FindBy(xpath = "//android.view.View[@resource-id='SearchFormDataPickerField']")
    WebElement dateButton;

    @FindBy(xpath = "(//android.view.View[@resource-id='Month'])[1]//android.widget.TextView")
    WebElement monthAndYear;

    String XPATH_DATE_VALUE = "(//android.view.View[@resource-id='Day'])[%s]/android.widget.Button";

    @FindBy(xpath = "(//android.view.View[@resource-id='Month'])")
    WebElement calendar;

    @FindBy(xpath = "//android.view.View[@resource-id='DateSelector_FullCentralSheet_Button']/android.widget.Button")
    WebElement calenderDone;

    @FindBy(xpath = "//android.view.View[@resource-id='TravelerSelectorField']")
    WebElement travellersButton;

    @FindBy(xpath = "//android.view.View[@resource-id='stepInputIncreaseButton']")
    WebElement adutlsButton;

    @FindBy(xpath = "//android.view.View[@resource-id='TravelerSelectorRoomDoneButton']/android.widget.Button")
    WebElement travellerDone;

    @FindBy(xpath = "//android.view.View[@resource-id='SearchButton']/android.widget.Button")
    WebElement searchBtn;

    @Override
    public void enterCity(String city) {
        enterCityInput.click();
        enterCityInput.sendKeys(city);
        selectCity.click();

    }

    @Override
    public void enterFromDate(String date) {
        dateButton.click();
        String expMonthYear = getFormattedDate("MMMM yyyy", date, "dd/MM/yyyy");
        String actMonthYear = monthAndYear.getText();
        System.out.println(actMonthYear);
        while (!expMonthYear.equalsIgnoreCase(actMonthYear)) {
            location(calendar, "scroll");
            actMonthYear = monthAndYear.getText();
        }

        String dateValue = getFormattedDate("dd", date, "dd/MM/yyyy");
        WebElement dateElement = driver.findElement(By.xpath(String.format(XPATH_DATE_VALUE, dateValue)));
        dateElement.click();
    }

    @Override
    public void enterToDate(String date) {
        String expMonthYear = getFormattedDate("MMMM yyyy", date, "dd/MM/yyyy");
        String actMonthYear = monthAndYear.getText();
        System.out.println(actMonthYear);
        while (!expMonthYear.equalsIgnoreCase(actMonthYear)) {
            location(calendar, "scroll");
            actMonthYear = monthAndYear.getText();
        }

        String dateValue = getFormattedDate("dd", date, "dd/MM/yyyy");
        WebElement dateElement = driver.findElement(By.xpath(String.format(XPATH_DATE_VALUE, dateValue)));
        dateElement.click();
        calenderDone.click();
    }

    @Override
    public void enterNoOfTravellers(String noOfAdults) {
        travellersButton.click();
        for (int i = 0; i < Integer.parseInt(noOfAdults) - 2; i++) {
            adutlsButton.click();
        }
        travellerDone.click();

    }

    @Override
    public void clickOnSearchButton() {
        searchBtn.click();
    }

    @Override
    public boolean isStaySearchPageDisplayed() {
        return searchBtn.isDisplayed();
    }

}
