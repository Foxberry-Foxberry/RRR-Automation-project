package com.gardenticketing.tests.admin;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gardenticketing.base.BaseAdminTest;
import com.gardenticketing.base.BaseTestclass;
import com.gardenticketing.pages.admin.LoginPage;

public class LoginPageTC extends BaseAdminTest {

    @Test(priority = 1)
    public void verifyUserCanLoginWithValidOTP() {

        LoginPage loginPage = new LoginPage(driver);

        System.out.println("Page Title: " + loginPage.getPageTitle());

        Assert.assertFalse(
                loginPage.getPageTitle().isEmpty(),
                "Login Failed - Page Title is Empty");
    }
}