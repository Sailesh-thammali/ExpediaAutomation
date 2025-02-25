package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class Hooks {
    @Before("@android or @web")
    public void setUp(Scenario scenario) {
        ConfigReader.initReader();
        DriverManager.createDriver();
    }

    @Before("@api")
    public void setUpApi() {
        ConfigReader.initReader();
        RestAssured.baseURI = ConfigReader.getConfigValue("api.url");
        RestAssured.useRelaxedHTTPSValidation();

    }


    // @After
    public void cleanUp(Scenario scenario) {
        DriverManager.getDriver().quit();
    }
}
