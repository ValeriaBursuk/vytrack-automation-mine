package com.vytrack.step_definitions;

import com.vytrack.pages.AdidasPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;

public class AdidasNew_StepDefinitions {

    AdidasPage adidaspage = new AdidasPage();

    @Given("User is on the main page")
    public void user_is_on_the_main_page() {
        Driver.getDriver().get(ConfigReader.getProperty("adidas_url"));
    }


    @When("user navigates to {string} and chooses {string} and clicks on Add to cart and accepts pop up confirmation.")
    public void user_navigates_to_and_chooses_and_clicks_on_add_to_cart_and_accepts_pop_up_confirmation(String category, String product) {
        adidaspage.addToCart(category, product);
    }
    @When("navigates to {string} and chooses {string} and clicks on Add to cart and accepts pop up confirmation.")
    public void navigates_to_and_chooses_and_clicks_on_add_to_cart_and_accepts_pop_up_confirmation(String category, String product) {
adidaspage.addToCart(category, product);
    }
    @When("navigates to Cart Delete {string} from cart.")
    public void navigates_to_cart_delete_from_cart(String string) {

    }
    @When("clicks on place order {string}.")
    public void clicks_on_place_order(String string) {

    }
    @When("fills in all web form fields.")
    public void fills_in_all_web_form_fields() {

    }
    @When("clicks on {string}")
    public void clicks_on(String string) {

    }
    @When("captures and log purchase Id and Amount.")
    public void captures_and_log_purchase_id_and_amount() {


    }
    @Then("asserts purchase amount equals expected.")
    public void asserts_purchase_amount_equals_expected() {

    }
    @Then("Click on {string}")
    public void click_on(String string) {

    }















}
