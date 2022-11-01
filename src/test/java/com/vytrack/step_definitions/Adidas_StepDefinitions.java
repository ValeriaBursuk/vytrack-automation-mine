package com.vytrack.step_definitions;

import com.vytrack.pages.AdidasPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class Adidas_StepDefinitions {

    AdidasPage adidasPage = new AdidasPage();

    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("adidas_url"));
    }


    //this is from product list feature  - 3 different data tables
    @Then("Under {string} category User should be able to see the list of following products")
    public void under_category_user_should_be_able_to_see_the_list_of_following_products(String category, List<String> expectedProduct) {

        adidasPage.clickCategory(category);

        List<WebElement> productsElements = adidasPage.products;

        List<String> actualProducts = BrowserUtils.getElementsText(productsElements);
        Assert.assertEquals(expectedProduct, actualProducts);


    }


    //this is from datatables
    @Then("User should be able to see expected prices in following products")
    public void user_should_be_able_to_see_expected_prices_in_following_products(List<Map<String, String>> productDetails) {


        for (Map<String, String> productDetail : productDetails) {
            System.out.println("====== Product Detail====" + productDetail);//{Category=Monitors, Product=Apple monitor 24, expectedPrice=400}
//            System.out.println(productDetail.get("Category")); //monitors
//            System.out.println(productDetail.get("Product"));//Apple monitor 24
//            System.out.println(productDetail.get("expectedPrice"));//400

            adidasPage.clickCategory(productDetail.get("Category")); //click category
            String actualProductPrice = adidasPage.getProductPrice(productDetail.get("Product"));
            String expectedPrice = productDetail.get("expectedPrice");

            System.out.println("actualProductPrice = " + actualProductPrice);
            System.out.println("expectedPrice = " + expectedPrice);
            Assert.assertEquals(expectedPrice, actualProductPrice);
        }
    }


    @Then("User should be able to see expected prices in following products with listOfList")
    public void user_should_be_able_to_see_expected_prices_in_following_products_with_list_of_list(List<List<String>> productDetails) {

        for (List<String> productDetail : productDetails) {
            System.out.println("===PRODUCT DETAILS====" + productDetail);
            System.out.println(productDetail.get(0)); //clicking category
            System.out.println(productDetail.get(1)); //product name
            System.out.println(productDetail.get(2)); //product price

            adidasPage.clickCategory(productDetail.get(0));
            String actualProductPrice = adidasPage.getProductPrice(productDetail.get(1));
            String expectedPrice = productDetail.get(2);

            Assert.assertEquals(expectedPrice, actualProductPrice);
        }


        //finish with map of list
    }
}


