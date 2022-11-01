package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("env1"));
    }

    @When("user enters {string} information")
    public void user_enters_information(String userType) {
        //could do switch , if , but we created a method in LoginPage
        loginPage.dynamicLogin(userType);
    }

    @Then("user should be able to login")
    public void user_should_be_able_to_login() {
        String expectedTitle = "Dashboard";
        BrowserUtils.verifyTitle(expectedTitle);
    }



}
