package com.vytrack.utilities;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static void sleep(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static boolean checkVisibilityOfElement(WebElement element) {
        boolean result = false;
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            result = true;
            System.out.println("Element was visible withing the timeframe");
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static boolean checkVisibilityOfElement(WebElement element, int waitTime) {
        boolean result = false;
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), waitTime);

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            result = true;
            System.out.println("Element was visible withing the timeframe");
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void waitForInvisibilityOf(WebElement element, int waitTime) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), waitTime);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForInvisibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void waitForVisibilityOf(WebElement element, int waitTime) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), waitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForVisibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void switchWindowAndVerify(String expectedUrl, String expectedTitle) {
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String eachWindow : allWindowHandles) {
            Driver.getDriver().switchTo().window(eachWindow);
            if (Driver.getDriver().getCurrentUrl().contains(expectedUrl)) {
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title verification failed", actualTitle.contains(expectedTitle));
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void verifyTitle(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Title Verification Failed", actualTitle, expectedTitle);

    }

    public static void verifyTitleContains(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("Title Verification Failed", actualTitle.contains(expectedTitle));
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * this method will accept Dropdown as WebElement and return all the options' text as a List of String
     */
    public static List<String> getDropdownOptionsAsString(WebElement selectElement){
        Select select = new Select(selectElement);
        List<WebElement> optionsElements = select.getOptions();
        List<String> listOfActualOptions = new ArrayList<>();

        for (WebElement option : optionsElements) {
            String actualText = option.getText();
            listOfActualOptions.add(actualText);
        }

        return listOfActualOptions;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

////////////////////////////////////////////////////////////////////////////////////////////////

    public static List<String> getElementsText(List<WebElement> elements){
        List<String> elementsText = new ArrayList<>();
        for (WebElement element : elements) {
            elementsText.add(element.getText());
        }

        return elementsText;
    }














    //    public static void takeScreenshot(String FileName){
//        try{
//            File File = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(File, new File(""
//                    + FileName + ".jpeg"));
//        } catch(IOException ie){
//        }
//    }

}

