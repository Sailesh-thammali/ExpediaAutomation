package com.automation.pages.android;

import com.automation.interfaces.ReviewPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidReviewPage extends AndroidBasePage implements ReviewPage {

    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.view.View/android.widget.Button")
    WebElement select;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[1]//android.widget.TextView[@text]")
    WebElement flight;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]//android.view.View[@content-desc]//android.widget.TextView[@text]")
    WebElement price;


    @Override
    public void printFlightInformation() {
        System.out.println(flight.getText());
    }

    @Override
    public void printPriceDetails() {

        System.out.println(price.getText());
    }

    @Override
    public boolean isReviewPageDisplayed() {
        return select.isDisplayed();
    }
}
