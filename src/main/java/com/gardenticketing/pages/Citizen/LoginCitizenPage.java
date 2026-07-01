package com.gardenticketing.pages.Citizen;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginCitizenPage {

	WebDriver driver;
	WebDriverWait wait;

	public LoginCitizenPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// Login Page Locators

	@FindBy(xpath = "//button[contains(@class,'bg-green-600')]")
	WebElement clickonloginbutton;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement addmobilenumber;

	@FindBy(xpath = "//div[@class='flex items-center justify-center gap-1']")
	WebElement SendOTP;

	@FindBy(xpath = "//input[@maxlength='1']")
	WebElement AddOTP;
	
	

	@FindBy(xpath = "//div[@class='flex items-center justify-center gap-1']")
	WebElement verifyOTP;
	
	
	@FindBy(xpath = "//button[contains(@class,'max-sm:hidden') and contains(@class,'shadow-md')]")
	WebElement DisplayLogout;
	
	


	// Methods

	public void clickonloginbutton() {

		try {

			wait.until(ExpectedConditions.elementToBeClickable(clickonloginbutton));

			((JavascriptExecutor) driver)
					.executeScript("arguments[0].click();", clickonloginbutton);

		} catch (Exception e) {

			System.out.println("Unable to click Login Button : " + e.getMessage());
		}
	}

	public void addmobilenumber(String mobileno) {

		try {

			wait.until(ExpectedConditions.visibilityOf(addmobilenumber));

			addmobilenumber.clear();
			addmobilenumber.sendKeys(mobileno);

			System.out.println("Mobile Number Entered");

			// Wait for popup/loader after mobile entry
			Thread.sleep(5000);

		} catch (Exception e) {

			System.out.println("Unable to enter Mobile Number : " + e.getMessage());
		}
	}

	public void SendOTP() {

		try {

			Thread.sleep(5000);

			wait.until(ExpectedConditions.elementToBeClickable(SendOTP));

			((JavascriptExecutor) driver)
					.executeScript("arguments[0].click();", SendOTP);

			System.out.println("Send OTP Clicked");

		} catch (Exception e) {

			System.out.println("Unable to click Send OTP : " + e.getMessage());
		}
	}

	public void AddOTP(String otp) {

		try {

			wait.until(ExpectedConditions.visibilityOf(AddOTP));

			((JavascriptExecutor) driver)
					.executeScript("arguments[0].scrollIntoView(true);", AddOTP);

			AddOTP.sendKeys(otp);

			System.out.println("OTP Entered");

		} catch (Exception e) {

			System.out.println("Unable to enter OTP : " + e.getMessage());
		}
	}

	public void verifyOTP() {

		try {

			wait.until(ExpectedConditions.elementToBeClickable(verifyOTP));

			((JavascriptExecutor) driver)
					.executeScript("arguments[0].click();", verifyOTP);

			System.out.println("Verify OTP Clicked");

		} catch (Exception e) {

			System.out.println("Unable to click Verify OTP : " + e.getMessage());
		}
	}

	// Complete Login Flow

	public void LoginFlow(String mobileno, String otp) {

		clickonloginbutton();

		addmobilenumber(mobileno);

		SendOTP();

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		AddOTP.sendKeys(otp);

		verifyOTP();
	}
	
	public boolean displayLogoutButton() {

		return DisplayLogout.isDisplayed();
	}
	
	
	
}