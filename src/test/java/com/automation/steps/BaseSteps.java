package com.automation.steps;

import com.automation.interfaces.*;

import com.automation.pages.web.WebFlightListingPage;
import com.automation.pages.web.WebFlightSearchPage;
import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.android.AndroidSignInPage;
import com.automation.pages.web.WebHomePage;
import com.automation.pages.web.WebSignInPage;
import com.automation.pages.web.*;


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
