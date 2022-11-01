package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    //1 - private constructor - no one can create an instance of the WebDriver
    /*
    A constructor has to exist because if there's no constructor at all, a public default constructor is included.
     */
    private Driver() {
    }

    //2 - private isn't accessible from outside any other class
    //static - can't create an instance of it
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                default:
                    System.out.println("UNKNOWN BROWSER TYPE " + browser);
                    driver = null;
            }

        }
        driver.manage().window().maximize();

        return driver;
    }

    public static void closeDriver() { //This method will make sure our driver value is always null after using quit() method
        if (driver != null) {
            driver.quit(); ////
            driver = null;
        }
    }

    // This method will make sure our driver value is always null after using quit() method
//    public static void closeDriver(){
//        if(driverPool.get() != null){
//            driverPool.get().quit(); // this line will terminate the existing driver session. with using this driver will not be even null
//            driverPool.remove();  //driver = null


}
