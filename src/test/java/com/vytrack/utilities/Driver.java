package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    // We make WebDriver private, because we want to close access from outside of class
    // We make it static, because we will use it inside static method , can't create an instance of it
    //private static WebDriver driver; // value is null by default
    // private constructor - no one can create an instance of the WebDriver
    //  constructor has to exist because if there's no constructor at all, a public default constructor is included
    private Driver() {
    }



    private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {


        // it will check if driver is null and if it is we will set up browser inside if statement
        // if you already setup driver and using it again for following line of codes, it will return to same driver
        if (driverPool.get() == null) {
            String browser = ConfigReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                default:
                    System.out.println("UNKNOWN BROWSER TYPE " + browser);
                    driver = null;
            }

        }
        
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit(); //// this line will kill the session. value will noy be null
            driverPool.remove();      //driver = null
        }
    }

}
