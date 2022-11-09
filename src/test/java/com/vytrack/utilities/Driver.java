package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    static String browser;

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
//
            if (System.getProperty("BROWSER") == null) {
                browser = ConfigReader.getProperty("browser");
            } else {
                browser = System.getProperty("BROWSER");
            }

            System.out.println("Browser: " + browser);
//                String browserName = System.getProperty("browser") != null ? browserName = System.getProperty("browser") : ConfigReader.getProperty("browser");
            //  String browser = ConfigReader.getProperty("browser");

            switch (browser) {
                case "remote-chrome":
                    try {
                        String gridAddress = "44.202.33.81";
                        URL url = new URL("http://" + gridAddress + ":4444/wb/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
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

