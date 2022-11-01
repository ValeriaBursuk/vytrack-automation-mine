package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
