package com.rrr.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.rrr.factory.DriverFactory;
import com.rrr.page.citizen.LoginPage;
import com.rrr.utils.ConfigReader;

public class BaseClass {

    protected WebDriver driver;
    ConfigReader config = ConfigReader.getInstance();

    @Parameters({"role", "browser"})
    @BeforeClass
    public void setUp(@Optional("citizen") String role,
                      @Optional("chrome") String browser) {

        // 1. Initialize driver
        driver = DriverFactory.initDriver(browser);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Integer.parseInt(config.getProperty("implicitWait")))
        );

        // 2. Open application once
        if (role.equalsIgnoreCase("admin")) {
            driver.get(config.getProperty("adminPortalURL"));
        } else {
            driver.get(config.getProperty("citizenPortalURL"));
        }

        // 3. LOGIN ONCE (important change)
        login(role);
    }

    // ================= LOGIN METHOD =================
    private void login(String role) {

        if (role.equalsIgnoreCase("admin")) {

            // Admin login

        } else {

            LoginPage loginPage = new LoginPage(driver);

            loginPage.login(
                    "9767945710",
                    "123"
            );

            System.out.println("Citizen Login Successful");
        }
    }
    // ================= LOGOUT =================
    @AfterClass
    public void tearDown() {

        try {
            logout();
        } catch (Exception e) {
            System.out.println("Logout failed or not needed UI issue");
        }

        if (driver != null) {
            DriverFactory.quitDriver();
        }
    }

    private void logout() {
        System.out.println("Logout executed");
        // implement logout click here
    }

    public WebDriver getDriver() {
        return driver;
    }
}