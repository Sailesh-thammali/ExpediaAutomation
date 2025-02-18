package com.automation.steps;

import com.automation.interfaces.FlightListingPage;
import com.automation.interfaces.FlightSearchPage;
import com.automation.interfaces.HomePage;
import com.automation.interfaces.SignInPage;
import com.automation.pages.WebFlightListingPage;
import com.automation.pages.WebFlightSearchPage;
import com.automation.pages.WebHomePage;
import com.automation.pages.WebSignInPage;

public class BaseSteps {
    HomePage homePage;
    SignInPage signInPage;
    FlightSearchPage flightSearchPage;
    FlightListingPage flightListingPage;
    public BaseSteps() {

        homePage= new WebHomePage();
        signInPage=new WebSignInPage();
        flightSearchPage=new WebFlightSearchPage();
        flightListingPage=new WebFlightListingPage();

    }
}
