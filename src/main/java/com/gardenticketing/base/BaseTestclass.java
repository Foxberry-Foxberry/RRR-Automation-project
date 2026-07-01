package com.gardenticketing.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.gardenticketing.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestclass {

    protected static WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {

        String browserName = ConfigReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicitWait"));

        System.out.println("🚀 Starting browser: " + browserName);

        if (browserName.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            if (headless) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
            }

            options.addArguments("--disable-notifications");
            options.addArguments("--use-fake-ui-for-media-stream");

            driver = new ChromeDriver(options);

        } else {

            throw new RuntimeException("Browser not supported: " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

        System.out.println("Browser launched successfully");
    }

    // Common method to open portals
    public static void openPortal(String userType) {

        String url;

        switch (userType.toLowerCase()) {

        case "admin":
            url = ConfigReader.getProperty("adminPortalURL");
            break;

        case "citizen":
            url = ConfigReader.getProperty("citizenPortalURL");
            break;

        default:
            throw new RuntimeException("Invalid user type: " + userType);
        }

        System.out.println("Navigating to : " + url);

        driver.get(url);
    }

    @AfterSuite
    public void tearDownSuite() {

        if (driver != null) {

            driver.quit();

            System.out.println("Browser closed successfully");
        }
    }
}