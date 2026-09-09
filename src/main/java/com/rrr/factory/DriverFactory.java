package com.rrr.factory;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initDriver(String browser) {

        if (driver == null) {

            switch (browser.toLowerCase()) {

                case "chrome":

                    WebDriverManager.chromedriver().setup();

                    ChromeOptions options = new ChromeOptions();

                    Map<String, Object> prefs = new HashMap<>();

                    // Allow Camera permission
                    prefs.put(
                        "profile.default_content_setting_values.media_stream_camera",
                        1
                    );

                    // Allow Microphone permission
                    prefs.put(
                        "profile.default_content_setting_values.media_stream_mic",
                        1
                    );

                    // Allow Location permission
                    prefs.put(
                        "profile.default_content_setting_values.geolocation",
                        1
                    );

                    options.setExperimentalOption("prefs", prefs);

                    // Automatically click Allow on camera/mic popup
                    options.addArguments("--use-fake-ui-for-media-stream");

                    driver = new ChromeDriver(options);

                    break;


                case "firefox":

                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();

                    break;


                case "edge":

                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();

                    break;


                default:

                    throw new RuntimeException("Invalid browser: " + browser);
            }

            driver.manage().window().maximize();
        }

        return driver;
    }


    public static WebDriver getDriver() {

        return driver;
    }


    public static void quitDriver() {

        if (driver != null) {

            driver.quit();
            driver = null;
        }
    }
}