package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.MainPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class MainStepDefinitions {
    //new step definitions for every feature

    MainPage mainPage = new MainPage();

    /** WITH A LIST OF MAP AS A PARAMETER:
     *       | module     | - need to have module as a key for a map
     *       | Fleet      |
     *       | Customers  |
     *       | Activities |
     *       | System     |
     *  @Then("user should be able to see the following modules")
     * //    public void user_should_be_able_to_see_the_following_modules(List<Map<String, String>> modules){
     * //         // modules : [{module=Fleet}, {module=Customers}, {module=Activities}, {module=System}]
     * //        //module: {module=Fleet}, module.get("module") => Fleet
     * //        //module: {module=Customers}, module.get("module") => Customers
     * //        //module : {module=Activities}, module.get("module") => Activities
     * //        //module: {module=System} , module.get("module") => System
     * //        for (Map<String, String> module : modules) {
     * //            System.out.println(module);
     * //            System.out.println(module.get("module"));
     * //        }
     * //    }
     */


    /**
     * with LIST as parameter only values without module header
     * | Fleet      |
     * | Customers  |
     * | Activities |
     * | System     |
     *
     * @param
     */
    @Then("user should be able to see the following modules")
    public void user_should_be_able_to_see_the_following_modules(List<String> expectedModules) {
       BrowserUtils.waitForInvisibilityOf(mainPage.loaderMask);
        List<String> actualModulesText = BrowserUtils.getElementsText(mainPage.allModules);
        Assert.assertEquals(expectedModules, actualModulesText);
    }

    @When("user enters below credentials")
    public void user_enters_below_credentials(Map<String, String> loginCredentials) {

        String username = loginCredentials.get("username");
        String password = loginCredentials.get("password");
        new LoginPage().login(username, password);
        BrowserUtils.sleep(3);

    }

    @Then("user should be able to see following information")
    public void user_should_be_able_to_see_following_information(Map<String, String> userInfo) {
        String actualUserInfo = mainPage.username.getText();
        String expectedUserInfo = userInfo.get("firstname")+" "+userInfo.get("lastname");
        Assert.assertEquals("Username verification failed", expectedUserInfo, actualUserInfo);
    }





}



