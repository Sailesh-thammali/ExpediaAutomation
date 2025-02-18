package com.automation.steps;

import com.automation.interfaces.FlightListingPage;
import com.automation.interfaces.FlightSearchPage;
import com.automation.interfaces.HomePage;
import com.automation.interfaces.SignInPage;

import com.automation.pages.web.WebFlightListingPage;
import com.automation.pages.web.WebFlightSearchPage;
import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.android.AndroidSignInPage;
import com.automation.pages.web.WebHomePage;
import com.automation.pages.web.WebSignInPage;


public class BaseSteps {
    HomePage homePage;
    SignInPage signInPage;
    FlightSearchPage flightSearchPage;
    FlightListingPage flightListingPage;
    public BaseSteps() {
        if (System.getProperty("platform").equals("web")) {

        homePage= new WebHomePage();
        signInPage=new WebSignInPage();
        flightSearchPage=new WebFlightSearchPage();
        flightListingPage=new WebFlightListingPage();

        }
        else {
            homePage= new AndroidHomePage();
            signInPage =new AndroidSignInPage();
        }

    }
}
