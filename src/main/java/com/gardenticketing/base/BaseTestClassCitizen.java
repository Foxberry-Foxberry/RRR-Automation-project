package com.gardenticketing.base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.gardenticketing.pages.Citizen.LoginCitizenPage;

public class BaseTestClassCitizen extends BaseTestclass {

	@BeforeSuite
	public void citizenLogin() throws InterruptedException {

	    openPortal("citizen");

	    LoginCitizenPage citizenLoginPage = new LoginCitizenPage(driver);

	    citizenLoginPage.clickonloginbutton();
	    citizenLoginPage.addmobilenumber("9767945710");
	    citizenLoginPage.SendOTP();
	    citizenLoginPage.AddOTP("9999");
	    citizenLoginPage.verifyOTP();

	    System.out.println("Citizen Portal Login Successful");
	}
}