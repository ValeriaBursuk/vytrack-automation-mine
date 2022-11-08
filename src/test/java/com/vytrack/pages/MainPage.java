package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='title title-level-1']")
   public List<WebElement> allModules;

    @FindBy(css = "#user-menu>a") //id = user-menu ,>  a - child
    public WebElement username;

    @FindBy(xpath = "//div[@class='loader-frame']")
    public WebElement loaderMask; //it disappears too fast
////
}
