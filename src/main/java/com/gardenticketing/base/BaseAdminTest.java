package com.gardenticketing.base;

import org.testng.annotations.BeforeClass;

import com.gardenticketing.pages.admin.LoginPage;

public class BaseAdminTest extends BaseTestclass {

    @BeforeClass
    public void loginToAdmin() {

        openPortal("admin");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterMobileNumber("9562341785");
        loginPage.clickSendOtp();
        loginPage.enterOTP("9999");
        loginPage.verifyotp();

        System.out.println("Admin Portal Login Successful");
    }
}