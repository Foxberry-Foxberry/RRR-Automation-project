package com.rrr.utils;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilclass {
	  // Returns full file path from testdata folder
    public static String getTestDataFilePath(String fileName) {
        return System.getProperty("user.dir") 
                + "/src/test/resources/testdata/" 
                + fileName;
    }

    // Returns File object
    public static File getTestDataFile(String fileName) {
        return new File(getTestDataFilePath(fileName));
    }
    


    // Wait for visibility
    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for element clickable
    public static WebElement waitForClickable(WebDriver driver, WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for presence (DOM only)
    public static WebElement waitForPresence(WebDriver driver, WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
     
    // Select by visible text
    public static void selectByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    // Select by value
    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    // Select by index
    public static void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    
    
    
    
    
    
}
