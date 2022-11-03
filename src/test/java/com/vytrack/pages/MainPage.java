package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//span[@class='title title-level-1']")
   public List<WebElement> allModules;

    @FindBy(css = "#user-menu>a") //id = user-menu ,>  a - child
    public WebElement username;

}
