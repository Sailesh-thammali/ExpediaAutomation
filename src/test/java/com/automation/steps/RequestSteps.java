package com.automation.steps;

import com.automation.pojo.CreateTokenPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.lang.reflect.Field;

public class RequestSteps {

    @Given("user wants to call {string} end point")
    public void userWantsToCallEndPoint(String endPoint) {
        RestAssuredUtils.clear();
        if (endPoint.contains("@id")) {
            endPoint = endPoint.replace("@id", ConfigReader.getConfigValue("booking.id"));
        } else if (endPoint.contains("?firstname")) {
            endPoint = endPoint.replace("=", ConfigReader.getConfigValue("firstname"));
        } else if (endPoint.contains("?lastname")) {
            endPoint = endPoint.replace("=", ConfigReader.getConfigValue("lastname"));
        } else if (endPoint.contains("?checkout")) {
            endPoint = endPoint.replace("=", ConfigReader.getConfigValue("checkout.date"));
        } else if (endPoint.contains("?checkin")) {
            endPoint = endPoint.replace("=", ConfigReader.getConfigValue("checkin.date"));
        }
        RestAssuredUtils.setEndPoint(endPoint);
    }

    @And("set header {string} to {string}")
    public void setHeaderTo(String key, String value) {
        if (value.contains("@token")) {
            value = value.replace("@token", ConfigReader.getConfigValue("auth.token"));
        }
        RestAssuredUtils.setHeader(key, value);
    }

    @And("set request body from file {string}")
    public void setRequestBodyFromFile(String filename) {
        RestAssuredUtils.setBody(filename);
    }

    @When("user performs post call")
    public void userPerformsPostCall() {
        RestAssuredUtils.post();
    }

    @When("user performs put call")
    public void userPerformsPutCall() {
        RestAssuredUtils.put();
    }

    @When("user performs delete call")
    public void userPerformsDeleteCall() {
        RestAssuredUtils.delete();
    }

    @When("user performs get call")
    public void userPerformsGetCall() {
        RestAssuredUtils.get();
    }

    @And("set parameters {string} and {string}")
    public void setParametersAnd(String fieldname, String value) {
        RestAssuredUtils.setPath(fieldname, value);

    }

    @And("set the request body from file {string} with {string} and {string}")
    public void setTheRequestBodyFromFileWithAnd(String fileName, String username, String password) throws JsonProcessingException, NoSuchFieldException, IllegalAccessException {

        String content = RestAssuredUtils.getDataFromJsonFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        CreateTokenPojo pojo = objectMapper.readValue(content, CreateTokenPojo.class);

        Field field;

        field = CreateTokenPojo.class.getDeclaredField("username");
        field.setAccessible(true);
        field.set(pojo, username);
        field = CreateTokenPojo.class.getDeclaredField("password");
        field.setAccessible(true);
        field.set(pojo, password);

        System.out.println(">>>>>>>>>>>Pojo: " + pojo);


        RestAssuredUtils.setBody(pojo);

    }


}
