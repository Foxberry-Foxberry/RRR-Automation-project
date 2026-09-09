package com.rrr.page.citizen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // WebElements
    private By mobilenumber = By.xpath("//input[@type='tel']");
    private By password = By.xpath("//input[@type='password']");
    private By viewPasswordIcon = By.xpath("//span[contains(@class,'inset-y-0') and contains(@class,'right-0')]");

    private By Signinbutton= By.xpath("//button[@type='submit']");
    
    // Home Page Element
    private By toiletCleaningSurvey = By.xpath("//h6[text()='Toilet Cleaning Survey']");

    // Methods

    public void addMobileNumber(String mobile) {
        driver.findElement(mobilenumber).sendKeys(mobile);
    }

    public void addPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickViewPasswordIcon() {
        driver.findElement(viewPasswordIcon).click();
    }
    
    
    public void clickonSigninButton() {
        driver.findElement(Signinbutton).click();
    }
    
    // Reusable login method
    public void login(String mobile, String pass) {
        addMobileNumber(mobile);
        addPassword(pass);
        clickonSigninButton();
    }

    public boolean isToiletCleaningSurveyDisplayed() {
        return driver.findElement(toiletCleaningSurvey).isDisplayed();
    }

}