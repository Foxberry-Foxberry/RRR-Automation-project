package com.gardenticketing.tests.Citizen;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gardenticketing.base.BaseTestClassCitizen;
import com.gardenticketing.pages.Citizen.LoginCitizenPage;

public class LoginCitizentestcase extends BaseTestClassCitizen {

    LoginCitizenPage loginpage;

    @BeforeMethod
    public void setupPage() {
        loginpage = new LoginCitizenPage(driver);
    }

    @Test
    public void verifyCitizenLogin() throws InterruptedException {

        loginpage.clickonloginbutton();

        loginpage.addmobilenumber("9767945710");

        loginpage.SendOTP();

        Thread.sleep(2000); 

        loginpage.AddOTP("9999");
        
        
        Thread.sleep(2000);

        loginpage.verifyOTP();

        Thread.sleep(3000);
        
        
        Assert.assertTrue(loginpage.displayLogoutButton());
        
        
    }
}