package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@id='_submit']")
    public WebElement loginBtn;


    public void login(String username, String password){
        usernameBox.sendKeys(username);
        BrowserUtils.sleep(1);
        passwordBox.sendKeys(password);
        BrowserUtils.sleep(1);
        loginBtn.click();
    }

    public void dynamicLogin(String userType) {
        userType = userType.replace(" ", "_");
       String username = ConfigReader.getProperty(userType + "_username");
       String password = ConfigReader.getProperty(userType + "_password");
       login(username, password); //called other login method
    }




}
