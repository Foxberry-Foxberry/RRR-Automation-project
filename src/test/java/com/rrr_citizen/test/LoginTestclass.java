package com.rrr_citizen.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rrr.base.BaseClass;
import com.rrr.page.citizen.LoginPage;

public class LoginTestclass extends BaseClass {

    @Test
    public void verifyCitizenLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.addMobileNumber("9767945710");
        loginPage.addPassword("123");

        // Click Login Button
        loginPage.clickonSigninButton();

        // Verify Home Page
        Assert.assertTrue(
                loginPage.isToiletCleaningSurveyDisplayed(),
                "Citizen login failed. Toilet Cleaning Survey page is not displayed."
        );
    }
}
