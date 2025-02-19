package com.automation.steps;

import com.automation.interfaces.*;


import com.automation.pages.android.*;
import com.automation.pages.web.WebFlightListingPage;
import com.automation.pages.web.WebFlightSearchPage;
import com.automation.pages.web.WebHomePage;
import com.automation.pages.web.WebSignInPage;
import com.automation.pages.web.WebFlightReviewPage;



import com.automation.pages.web.*;


public class BaseSteps {
    HomePage homePage;
    SignInPage signInPage;
    FlightSearchPage flightSearchPage;
    FlightListingPage flightListingPage;
    ReviewPage reviewPage;


    CarSearchPage carSearchPage;
    public BaseSteps() {
        if (System.getProperty("platform").equals("web"))  {
            homePage = new WebHomePage();
            signInPage = new WebSignInPage();
            flightSearchPage = new WebFlightSearchPage();
            flightListingPage = new WebFlightListingPage();
            reviewPage = new WebFlightReviewPage();
        } else {
          homePage = new AndroidHomePage();
            signInPage = new AndroidSignInPage();
            flightSearchPage = new AndroidFlightSearchPage();
            flightListingPage = new AndroidFlightListingPage();
            reviewPage = new AndroidReviewPage();

        }


        }
    }
}
