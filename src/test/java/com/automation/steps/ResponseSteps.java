package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ResponseSteps {
    @Then("verify status code is {int}")
    public void verifyStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());
    }

    @And("store {string} into {string}")
    public void storeInto(String jsonPath, String configKey) {
        String value = RestAssuredUtils.getResponseFieldValue(jsonPath);
        ConfigReader.setConfigValue(configKey, value);
    }

    @And("verify response body has a field {string} is {string}")
    public void verifyResponseBodyHasAFieldIs(String jsonPath, String value) {
        Assert.assertEquals(value, RestAssuredUtils.getResponseFieldValue(jsonPath));
    }


}
