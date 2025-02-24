package com.automation.interfaces;


public interface HomePage {
    void openApplication();

    void clickOnSignInButton();

    boolean isHomePageDisplayed();

    void clickOnAccountElement();

    void clickOnSignOutButton();

    boolean isAccountElementDisplayed();

    boolean isSignInElementDisplayed();

    void clickOnFlightsOption();

    void clickOnCarsOption();

    void clickOnStaysOption();

    void clickOnRegionButton();

    boolean isRegionOptionDisplayed();

    void selectRegionOption(String region);

    void selectLanguageOption(String language);

    void clickOnSaveButton();

    boolean isSelectedLanguageDisplayed(String language);

}
