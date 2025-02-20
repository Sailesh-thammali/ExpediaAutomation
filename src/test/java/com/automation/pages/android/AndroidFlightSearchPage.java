package com.automation.pages.android;

import com.automation.interfaces.FlightSearchPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidFlightSearchPage extends AndroidBasePage implements FlightSearchPage {

    @FindBy(xpath = "//android.view.View[@resource-id=\"CenteredTabs\"]/android.view.View/android.view.View[2]/android.view.View")
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

    String enterDate = "(//android.view.View[@resource-id=\"Day\"])[%s]/android.widget.Button";

    @FindBy(xpath = "//android.view.View[@resource-id=\"DateSelector_FullCentralSheet_Button\"]/android.widget.Button")
    WebElement doneBtn;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Travellers Button 1 traveller\"]")
    WebElement travellerBtn;

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
        WebElement dateElement = driver.findElement(By.xpath(String.format(enterDate, date)));
        dateElement.click();
        doneBtn.click();
    }

    @Override
    public void enterNoOfTravellers(String noOfAdults) {
        travellerBtn.click();
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
}
