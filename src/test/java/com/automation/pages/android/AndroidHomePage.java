package com.automation.pages.android;

import com.automation.interfaces.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePage extends AndroidBasePage implements HomePage {
    @FindBy(xpath = "//android.widget.Button")
    WebElement getStartedBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Cancel']")
    WebElement cancelBtn;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")
    WebElement cancelBtn2;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']")
    WebElement denyBtn;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Sign In Link']")
    WebElement signInBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Flights']")
    WebElement flightIcon;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[1]//android.widget.TextView[@text]")
    WebElement text;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.expedia.bookings:id/tab_icon'])[5]")
    WebElement accountIcon;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]")
    WebElement profileIcon;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[10]/android.widget.Button")
    WebElement signOutBtn;

    @FindBy(xpath = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button")
    WebElement signOut;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button")
    WebElement signIn;

    @FindBy(xpath = "//android.widget.TextView[@text='Stays']")
    WebElement stayBtn;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.Button")
    WebElement settingsOption;

    @FindBy(xpath = "//android.widget.TextView[@text='Region']")
    WebElement regionOption;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.expedia.bookings:id/country_name_text_view' and @text]")
    WebElement selectRegion;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.expedia.bookings:id/country_name_text_view' and @text='United Kingdom']")
    WebElement selectRegionOption;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    WebElement okBtn;


    @Override
    public void openApplication() {
        getStartedBtn.click();
        if (isDisplayed(denyBtn)) {
            denyBtn.click();
        }
        cancelBtn.click();
        cancelBtn2.click();
        denyBtn.click();

    }

    @Override
    public void clickOnSignInButton() {
        signInBtn.click();
    }

    @Override
    public boolean isHomePageDisplayed() {
        return flightIcon.isDisplayed();
    }

    @Override
    public void clickOnAccountElement() {
        accountIcon.click();
    }


    public void clickOnSignOutButton() {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        int startX = width / 2;
        int startY = (height * 3) / 4;
        int endX = width / 2;
        int endY = height / 4;
        while (!isDisplayed(signOutBtn)) {
            scroll(startX, startY, endX, endY);
        }
        signOutBtn.click();
        signOut.click();
    }


    public boolean isAccountElementDisplayed() {
        return accountIcon.isDisplayed();
    }


    public boolean isSignInElementDisplayed() {
        return signIn.isDisplayed();
    }

    @Override
    public void clickOnFlightsOption() {

        flightIcon.click();

    }

    @Override
    public void clickOnStaysOption() {
        stayBtn.click();
    }

    @Override
    public void clickOnRegionButton() {
        accountIcon.click();
        settingsOption.click();


    }

    @Override
    public boolean isRegionOptionDisplayed() {
        return regionOption.isDisplayed();
    }

    @Override
    public void selectRegionOption(String region) {
        regionOption.click();
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        int startX = width / 2;
        int startY = (height * 3) / 4;
        int endX = width / 2;
        int endY = height / 4;
        while (!isDisplayed(selectRegionOption)) {
            scroll(startX, startY, endX, endY);

        }
        selectRegionOption.click();
        okBtn.click();


    }

    @Override
    public boolean isSelectedLanguageDisplayed(String language) {
        return true;
    }
}




