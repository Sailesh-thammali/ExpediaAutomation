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

    default void clickOnCarsOption() {
    }

    void clickOnStaysOption();

    void clickOnRegionButton();

    boolean isRegionOptionDisplayed();

    void selectRegionOption(String region);

    default void selectLanguageOption(String language) {

    }

    default void clickOnSaveButton() {

    }

    boolean isSelectedLanguageDisplayed(String language);

}
