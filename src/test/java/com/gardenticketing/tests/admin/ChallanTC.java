package com.gardenticketing.tests.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gardenticketing.base.BaseAdminTest;
import com.gardenticketing.base.BaseTestclass;
import com.gardenticketing.pages.admin.ChallanPage;

public class ChallanTC extends BaseAdminTest {
//WebDriver driver;
private ChallanPage challanpagetc;

@BeforeClass
public void beforesetup() {
	challanpagetc=new ChallanPage(driver);
}

@Test
public void verify_User_GetChallanSheet() throws InterruptedException {
	
	Thread.sleep(6000);
	challanpagetc.clickonchallanbutton();
	
	challanpagetc.clickonselectmonthDD();
	challanpagetc.Month();
	Thread.sleep(3000);
//	challanpagetc.selectbyTextmonth("November");
	challanpagetc.selectYearDD();
	challanpagetc.Year();
	Thread.sleep(3000);
//	challanpagetc.selectbyTextYear("2025");
	challanpagetc.clickongetchallanbutton();
	
    Assert.assertTrue(challanpagetc.getcalender(), 
            " Calendar is not visible after clicking Get Challan Sheet");
    }
}





