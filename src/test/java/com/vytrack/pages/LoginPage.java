package com.vytrack.pages;

import com.vytrack.utilities.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@id='_submit']")
    public WebElement loginBtn;


    public void login(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }

    public void dynamicLogin(String userType) {
        userType = userType.replace(" ", "_");
       String username = ConfigReader.getProperty(userType + "_username");
       String password = ConfigReader.getProperty(userType + "_password");
       login(username, password); //called other login method
    }




}
