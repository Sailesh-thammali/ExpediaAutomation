package com.automation.pages.android;

import com.automation.interfaces.SignInPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidSignInPage extends AndroidBasePage implements SignInPage {
    @FindBy(xpath = "//android.widget.EditText/android.view.View")
    WebElement emailText;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement emailInput;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[6]/android.view.View/android.widget.Button")
    WebElement continueButton;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[6]/android.view.View/android.widget.Button")
    WebElement passwordButton;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[3]/android.view.View/android.view.View/android.widget.EditText")
    WebElement passwordInput;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.View[5]/android.view.View/android.widget.Button")
    WebElement signInButton;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Cancel']")
    WebElement cancelBtn;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='System error']")
    WebElement errorMsg;


    @Override
    public void enterCredentials(String email, String password) {
        cancelBtn.click();
        emailText.click();
        emailInput.sendKeys(ConfigReader.getConfigValue("signIn.email"));
        continueButton.click();
        passwordButton.click();
        passwordInput.sendKeys(ConfigReader.getConfigValue("signIn.password"));
    }

    @Override
    public void clickOnSignInButton() {
        signInButton.click();
    }

    @Override
    public void clickOnContinueButton() {
        continueButton.click();

    }

    @Override
    public boolean isSignInPageDisplayed() {
        return cancelBtn.isDisplayed();
    }

    @Override
    public void enterEmail(String email) {
        cancelBtn.click();
        emailText.click();
        emailInput.sendKeys(email);
    }

    @Override
    public boolean isErrorMessageDisplayed() {
        return errorMsg.isDisplayed();
    }
}
