package com.automation.steps;

import com.automation.interfaces.*;

<<<<<<< HEAD
import com.automation.pages.web.WebFlightListingPage;
import com.automation.pages.web.WebFlightSearchPage;
import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.android.AndroidSignInPage;
import com.automation.pages.web.WebHomePage;
import com.automation.pages.web.WebSignInPage;
=======
import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.android.AndroidSigninPage;
>>>>>>> 4fc9552971f676f57562ec2c735f4a4a30a67e03
import com.automation.pages.web.*;


public class BaseSteps {
    HomePage homePage;
    SignInPage signInPage;
    FlightSearchPage flightSearchPage;
    FlightListingPage flightListingPage;
    public BaseSteps() {
<<<<<<< HEAD

        homePage= new WebHomePage();
        signInPage=new WebSignInPage();
        flightSearchPage=new WebFlightSearchPage();
        flightListingPage=new WebFlightListingPage();
=======
        if(System.getProperty("platfrom","web").equals("web")) {
            homePage = new WebHomePage();
            signInPage = new WebSignInPage();
            flightSearchPage = new WebFlightSearchPage();
            flightListingPage = new WebFlightListingPage();
            reviewPage = new WebReviewPage();
        }
        else {
            homePage=new AndroidHomePage();
            signInPage = new AndroidSigninPage();
        }
>>>>>>> 4fc9552971f676f57562ec2c735f4a4a30a67e03

    }
}
