package com.vytrack.step_definitions;

import com.vytrack.pages.AdidasPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.Arrays;

public class AdidasNew_StepDefinitions {

    AdidasPage adidaspage = new AdidasPage();
    int expectedTotalPrice = 0;

    @Given("User is on the main page")
    public void user_is_on_the_main_page() {
        Driver.getDriver().get(ConfigReader.getProperty("adidas_url"));
    }


    @When("user navigates to {string} and chooses {string} and clicks on Add to cart and accepts pop up confirmation.")
    public void user_navigates_to_and_chooses_and_clicks_on_add_to_cart_and_accepts_pop_up_confirmation(String category, String product) {
        //price before adding to cart
        expectedTotalPrice += adidaspage.addToCart(category, product);
        System.out.println("When added Sony vaio: " + expectedTotalPrice);
    }

    @When("navigates to {string} and chooses {string} and clicks on Add to cart and accepts pop up confirmation.")
    public void navigates_to_and_chooses_and_clicks_on_add_to_cart_and_accepts_pop_up_confirmation(String category, String product) {
        //we need price before adding to cart
        expectedTotalPrice += adidaspage.addToCart(category, product);
        System.out.println("added Dell i6 8gb:" + expectedTotalPrice);
    }

    @When("navigates to Cart Delete {string} from cart.")
    public void navigates_to_cart_delete_from_cart(String product) {
        adidaspage.cart.click();
        expectedTotalPrice -= adidaspage.removeProduct(product);
        System.out.println("Removed Dell i7 8gb:" + expectedTotalPrice);
    }

    @When("clicks on place order.")
    public void clicks_on_place_order() {
        BrowserUtils.sleep(3);
        adidaspage.placeButton.click();
        BrowserUtils.sleep(2);
    }

    @When("fills in all web form fields.")
    public void fills_in_all_web_form_fields() {
        adidaspage.fillOutForm();
    }

    @When("clicks on Purchase button")
    public void clicks_on_purchase_button() {
        BrowserUtils.sleep(3);
        adidaspage.purchaseButton.click();
        BrowserUtils.sleep(2);
    }

    @When("captures and log purchase Id and Amount.")
    public void captures_and_log_purchase_id_and_amount() {
        String confirmationText = adidaspage.confirmation.getText();
        System.out.println("===================================");
        System.out.println(confirmationText);
        System.out.println("===================================");
        String[] arr = confirmationText.split(" ");
        System.out.println(Arrays.toString(arr));
        System.out.println("===================================");
       String id = arr[1];
        System.out.println("ID arr[1]: " + id);


    }

    @Then("asserts purchase amount equals expected.")
    public void asserts_purchase_amount_equals_expected() {
        Assert.assertTrue(adidaspage.confirmation.getText().contains(String.valueOf(expectedTotalPrice)));
    }

    @Then("Click on Ok")
    public void click_on() {
        adidaspage.okBtn.click();
    }


}
