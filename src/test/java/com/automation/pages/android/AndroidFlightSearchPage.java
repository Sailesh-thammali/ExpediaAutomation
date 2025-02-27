package com.automation.pages.android;

import com.automation.interfaces.FlightSearchPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidFlightSearchPage extends AndroidBasePage implements FlightSearchPage {

    @FindBy(xpath = "//android.widget.TextView[@text=\"One-way\"]")
    WebElement oneWayOption;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Leaving from Button\"]")
    WebElement fromPlace;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"TeamTypeaheadInput\"]")
    WebElement fromPlaceInput;

    @FindBy(xpath = "//android.view.View[@resource-id=\"EGDSActionListItem\"]/android.view.View/android.view.View")
    WebElement leavingFrom;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Going to Button\"]")
    WebElement toPlace;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"TeamTypeaheadInput\"]")
    WebElement toPlaceInput;

    @FindBy(xpath = "//android.view.View[@resource-id=\"EGDSActionListItem\"]/android.widget.Button")
    WebElement goingTo;

    @FindBy(xpath = "(//android.view.View[@resource-id=\"EGDSTextInputContainer\"])[3]")
    WebElement dateBtn;

    @FindBy(xpath = "(//android.view.View[@resource-id=\"Month\"])[1]//android.widget.TextView")
    WebElement monthAndYear;

    String XPATH_DATE_VALUE = "(//android.view.View[@resource-id=\"Day\"])[%s]/android.widget.Button";

    @FindBy(xpath = "(//android.view.View[@resource-id=\"Month\"])")
    WebElement calendar;

    @FindBy(xpath = "//android.view.View[@resource-id=\"DateSelector_FullCentralSheet_Button\"]/android.widget.Button")
    WebElement doneBtn;

    @FindBy(xpath = "//android.view.View[@resource-id=\"TravelerSelectorField\"]")
    WebElement travellerBtn;

    @FindBy(xpath = "//android.view.View[@resource-id=\"stepInputIncreaseButton\"]")
    WebElement adutlsButton;

    @FindBy(xpath = "//android.view.View[@resource-id=\"BasicTravelerSelectorDoneButton\"]/android.widget.Button")
    WebElement doneBtn2;

    @FindBy(xpath = "//android.view.View[@resource-id=\"SearchButton\"]/android.widget.Button")
    WebElement searchBtn;


    @Override
    public void clickOnOnewayOption() {
        oneWayOption.click();
    }

    @Override
    public void enterFromCity(String fromCity) {
        fromPlace.click();
        fromPlaceInput.click();
        fromPlaceInput.sendKeys(fromCity);
        leavingFrom.click();
    }

    @Override
    public void enterToCity(String toCity) {
        toPlace.click();
        toPlaceInput.click();
        toPlaceInput.sendKeys(toCity);
        goingTo.click();

    }

    @Override
    public void enterDate(String date) {
        dateBtn.click();
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
        doneBtn.click();
    }

    @Override
    public void enterNoOfTravellers(String noOfAdults) {
        travellerBtn.click();
        for (int i = 0; i < Integer.parseInt(noOfAdults) - 1; i++) {
            adutlsButton.click();
        }
        doneBtn2.click();
    }

    @Override
    public void clickOnSearchButton() {
        searchBtn.click();
    }

    @Override
    public boolean isFlightSearchPageDisplayed() {
        return searchBtn.isDisplayed();
    }

    @Override
    public boolean isErrorDisplayed() {
        return false;
    }
}
