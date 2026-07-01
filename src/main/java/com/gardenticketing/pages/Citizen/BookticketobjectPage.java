package com.gardenticketing.pages.Citizen;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookticketobjectPage {

	WebDriver driver;
	WebDriverWait wait;

	public BookticketobjectPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// Garden Booking Elements

	@FindBy(xpath="//a[@href='#explore-gardens']")
	WebElement exploreGarden;

	@FindBy(xpath="(//section[contains(@class,'grid')]//div[contains(@class,'shadow-xl')])[1]")
	WebElement selectGarden;

	@FindBy(xpath="(//span[@class='relative text-xs md:text-sm'])[4]")
	WebElement creatorPass;
	
	@FindBy(xpath="	(//span[contains(@class,' max-sm:text-x') and contains (@class, 'text-nowrap')])[2]")
	WebElement Videography;

	@FindBy(xpath="(//button[contains(@class,'w-6')])[2]")
	WebElement addChildTicket;
	
	@FindBy(xpath="(//button[contains(@class,'w-6')])[4]")
	WebElement addAdultTicket;

	@FindBy(xpath="//button[contains(@class,'bg-green-600')]")
	WebElement confirmTicket;

	@FindBy(xpath="//button[@class='btn-success']")
	WebElement proceedToPay;

	// Easebuzz Payment Elements

	@FindBy(xpath="//span[text()='UPI']")
	WebElement selectUPI;

	@FindBy(xpath="//span[@class='lang-en' and contains(text(),'Pay with UPI ID')]")
	WebElement selectUPIRadio;

	@FindBy(xpath="//input[@placeholder='Enter your UPI ID']")
	WebElement enterUPIID;

	@FindBy(xpath="//span[contains(@class,'verify-btn')]")
	WebElement verifyButton;

	@FindBy(xpath="//button[contains(@class,'pay-btn')]")
	WebElement payButton;
	
	@FindBy(xpath="//h6[@class='text-xl font-semibold mb-0']")
	WebElement Bookingstatus;
	
	// getticket Booking date  (//p[@class='text-gray-900 font-semibold text-xs'])[1]
	@FindBy(xpath=" (//p[@class='text-gray-900 font-semibold text-xs'])[1]")
	WebElement ticketBookDate;
	
	
	//getticket Booking Slot   (//p[@class='text-gray-900 font-semibold text-xs'])[2]
	@FindBy(xpath="(//p[@class='text-gray-900 font-semibold text-xs'])[2]")
	WebElement ticketBookSlot;
	
	
	//booking amount
	@FindBy(xpath="//span[contains(@class,'text-emerald-600')]")
	WebElement BookingAmount;
	
	//cancel ticket icon
	@FindBy(xpath="//button[contains(@class,'text-gray-600') and contains(@class,'cursor-pointer') and contains(@class,'hover:text-black')]")
	WebElement cancelBookingIcon;
	
	
	

	// ============================
	
	
	
	
	
	
	// Booking Methods
	// ============================

	public void clickExploreGarden() {
		exploreGarden.click();
	}

	public void clickSelectGarden() {
		selectGarden.click();
	}

	public void clickCreatorPass() {
		creatorPass.click();
	}

	public void VediographyPass() {
		Videography.click();
	}
	

	public void addAdultTicket() {
		addAdultTicket.click();
	}

	public void addChildTicket() {
		addChildTicket.click();
	}

	public void clickConfirmTicket() {
		confirmTicket.click();
	}

	public void clickProceedToPay() {
		proceedToPay.click();
	}

	// ============================
	// Window Handle
	// ============================

	public void switchToEasebuzzWindow() {

		String parentWindow = driver.getWindowHandle();

		try {
			Thread.sleep(5000);
		}
		catch(Exception e) {

		}

		for(String window : driver.getWindowHandles()) {

			if(!window.equals(parentWindow)) {

				driver.switchTo().window(window);
				break;
			}
		}
	}

	// ============================
	// Payment Methods
	// ============================

	public void selectUPIOption() {

		try {
			selectUPI.click();
		}
		catch(Exception e) {

			JavascriptExecutor js =
					(JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", selectUPI);
		}
	}

	public void selectUPIRadioButton() {

		wait.until(ExpectedConditions.elementToBeClickable(selectUPIRadio));

		selectUPIRadio.click();
	}

	public void enterUPI(String upiId) {
		enterUPIID.sendKeys(upiId);
	}

	public void clickVerifyButton() {
		verifyButton.click();
	}

	public void clickPayButton() {
		payButton.click();
	}

	// ============================
	// Complete UPI Payment Flow
	// ============================

	public void completeUPIPayment(String upiId) {

		switchToEasebuzzWindow();

		selectUPIOption();

		selectUPIRadioButton();

		enterUPI(upiId);

		clickVerifyButton();

		clickPayButton();
	}
	
	// ============================
	// Ticket Details Methods
	// ============================

	public String getTicketBookDate() {

	    wait.until(ExpectedConditions.visibilityOf(ticketBookDate));

	    return ticketBookDate.getText().trim();
	}

	
	public String getTicketBookSlot() {

	    wait.until(ExpectedConditions.visibilityOf(ticketBookSlot));

	    return ticketBookSlot.getText().trim();
	}

	
	public String getBookingAmount() {

	    wait.until(ExpectedConditions.visibilityOf(BookingAmount));

	    return BookingAmount.getText().trim();
	}
	
	
	
	
	
}