package com.gardenticketing.pages.Citizen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TermAndConditionPage {

    WebDriver driver;

    public TermAndConditionPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/terms-and-conditions']")
    WebElement termAndConditionPage;

    @FindBy(xpath = "//div[@class='mb-8']")
    WebElement allConditions;

    public void openTermAndConditionPage() {

        termAndConditionPage.click();
    }

    public boolean isTermAndConditionDisplayed() {

        return allConditions.isDisplayed();
    }

    public String getTermAndConditionText() {

        return allConditions.getText();
    }
}