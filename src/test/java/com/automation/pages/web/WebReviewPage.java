package com.automation.pages.web;

import com.automation.interfaces.ReviewPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebReviewPage extends WebBasePage implements ReviewPage {
    @FindBy(xpath = "//span[contains(text(),\"Show details\")]")
    WebElement showDetailsButton;

    @FindBy(xpath = "//div[contains(@data-stid,\"journey-part-0\")]")
    WebElement flightInformation;

    @FindBy(xpath = "//div[contains(@class,'uitk-table-container')]")
    WebElement  priceSummary;

    @FindBy(xpath = "(//div[contains(@class,'uitk-table-container')])[3]//tr[contains(@class,'uitk-table-row')]")
    WebElement  totalPrice;

    public void printFlightInformation(){
        showDetailsButton.click();
        System.out.println(flightInformation.getText());
    }
    public void printPriceDetails(){
        System.out.println(priceSummary.getText());
        System.out.println("Total price :- "+totalPrice.getText());
    }
    public boolean isReviewPageDisplayed(){
        switchToNewWindow();
        return showDetailsButton.isDisplayed();
    }
}
