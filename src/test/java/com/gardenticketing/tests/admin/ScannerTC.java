package com.gardenticketing.tests.admin;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gardenticketing.base.BaseAdminTest;
import com.gardenticketing.base.BaseTestclass;
import com.gardenticketing.pages.admin.ScannerModule;

public class ScannerTC extends BaseAdminTest {

    private ScannerModule scannerModule;

    @BeforeClass
    public void setUpPages() {
        scannerModule = new ScannerModule(driver);
    }

    @Test(priority = 1)
    public void verifyScannerButtonClickable() throws InterruptedException {
        scannerModule.clickScanner();
        Thread.sleep(2000);  
    }

    @Test(priority = 2)
    public void verifyCameraOFFButton() throws InterruptedException {
        scannerModule.turnOffCamera();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void verifyCameraONButton() throws InterruptedException {
        scannerModule.turnOnCamera();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void verifyOpenProfile() throws InterruptedException {
        scannerModule.openProfile();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void verifyProfileBackNavigation() throws InterruptedException {
        scannerModule.clickProfileBackArrow();
        Thread.sleep(2000);
    }
}
