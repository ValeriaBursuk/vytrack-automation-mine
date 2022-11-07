package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


    public class AdidasPage {
        public AdidasPage(){
            PageFactory.initElements(Driver.getDriver(),this);
        }

        @FindBy(xpath = "//h3[@class='price-container']")
        public WebElement purchasePrice;

        @FindBy(xpath = "//a[.='Add to cart']")
        public WebElement addCart;

        @FindBy(xpath = "(//a[@class='nav-link'])[1]")
        public WebElement homeLink;

        @FindBy(xpath = "//a[.='Cart']")
        public WebElement cart;

        @FindBy(xpath = "//button[.='Place Order']")
        public WebElement placeButton;

        @FindBy(id = "name")
        public WebElement name;

        @FindBy(id = "country")
        public WebElement country;

        @FindBy(id = "city")
        public WebElement city;

        @FindBy(id = "card")
        public WebElement creditCard;

        @FindBy(id = "month")
        public WebElement month;

        @FindBy(id = "year")
        public WebElement year;

        @FindBy(xpath = "//button[.='Purchase']")
        public WebElement purchaseButton;

        @FindBy(xpath = "//p[@class='lead text-muted ']")
        public WebElement confirmation;

        @FindBy(xpath = "//button[@class=\"confirm btn btn-lg btn-primary\"]")
        public WebElement OK;

        @FindBy(css = ".hrefch")
        public List<WebElement> products;
//xpath = "//a[@class='hrefch']")



        public void clickButton(String button){
            Driver.getDriver().findElement(By.xpath("//button[.='"+button+"']"));
        }



        public String getProductPrice(String product){

            String actualPrice = Driver.getDriver().findElement(By.xpath("//a[normalize-space(.)='" + product + "']/../../h5")).getText();

            return actualPrice.substring(1);
        }


        public void clickCategory(String category){
            Driver.getDriver().findElement(By.xpath("//a[.='" + category + "']")).click();
            BrowserUtils.sleep(1);
        }


        public int addToCart(String category, String product){
            Driver.getDriver().findElement(By.xpath("//a[.='" + category + "']")).click();
            BrowserUtils.sleep(1);
            Driver.getDriver().findElement(By.xpath("//a[.='"+product+"']")).click();
            BrowserUtils.sleep(1);

            String fullPriceText = purchasePrice.getText();
//             "$790 *includes taxes"
//            we wanna get 790 ->
            String [] arr = fullPriceText.split(" ");
            //-> [$790] [*includes] [taxes]
           // arr[0].substring(1); //--> "790"  --> as a string we want integer

            int price = Integer.parseInt(arr[0].substring(1));

            addCart.click();
            BrowserUtils.waitForAlertIsPresent(5);
            BrowserUtils.acceptJSAlert();
            homeLink.click();

            return price;
        }





        public int removeProduct(String productName){
            //tbody//td[.='Apple monitor 24']/../td[3]
            //tbody//td[.='Samsung galaxy s6']/../td[3]

            String priceForProductLocator = "//tbody//td[.='"+ productName +"']/../td[3]";
            String price = Driver.getDriver().findElement(By.xpath(priceForProductLocator)).getText();
            String productDelete = "//tbody//td[.='"+productName+"']/../td/a";
            Driver.getDriver().findElement(By.xpath(productDelete)).click();
            return Integer.parseInt(price);
        }

        public void fillOutForm(){
            Faker faker = new Faker();
            name.sendKeys(faker.name().fullName());
            country.sendKeys(faker.country().name());
            city.sendKeys(faker.country().capital());
            creditCard.sendKeys(faker.finance().creditCard());
            month.sendKeys(String.valueOf(faker.number().numberBetween(1, 12)));
            year.sendKeys(String.valueOf(faker.number().numberBetween(2023, 2032)));
        }

}
//String priceString = purchasePrice.getText() ==   "$790 *includes taxes"
//we wanna get 790 ->
//String [] arr = priceString.split(" ") -> [$790] [*includes] [taxes]
//arr[0].substring(1) --> "790"  --> as a string we want integer

//int price = Integer.parseInt(arr[0].substring(1))

