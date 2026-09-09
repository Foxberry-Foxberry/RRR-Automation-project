package com.rrr.page.citizen;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CollectionHistoryPage {

    WebDriver driver;
    WebDriverWait wait;

    public CollectionHistoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // ==============================
    // Collection History Page Elements
    // ==============================

    private By collectionFilterButton = By.xpath("//button[.//span[normalize-space()='Filters']]");
    private By collectionFromdate = By.xpath("//input[@name='startDate']");
    private By collectionTodate = By.xpath("//input[@name='endDate']");
    private By collectionFilterSearch = By.xpath("//button[contains(@class,'bg-[#004686]') and contains(@class,'hover:bg-blue-700')]");
    private By collectionTableDates = By.xpath("//table//tbody//tr/td[7]//div");
    private By successToastMessage = By.xpath("//p[normalize-space()='Survey submitted successfully!']");
    private By cancelButton = By.xpath("//button[contains(@class,'Toastify__close-button')]");
    private By refreshTableButton = By.xpath("//*[local-name()='svg' and @width='26' and @height='26']");
    private By clickviewicon = By.xpath("(//td[contains(@class,'text-right')]//button)[1]");
    private By getcollectiondetais = By.xpath("//h1[normalize-space()='Collection Details']");
    
    // =========================================================
    // Validate Submitted Survey Record
    // =========================================================

    public boolean isSubmittedSurveyDisplayedInTable(
            String organization,
            int expectedTotalCount,
            double expectedTotalWeight) {

        String todayDate = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String expectedWeight = String.format(
                "%.2f Kg",
                expectedTotalWeight
        );

        By submittedRecord = By.xpath(
                "//table//tbody//tr[" +
                        ".//td[normalize-space()='" + organization + "']" +
                        " and .//td[normalize-space()='" + todayDate + "']" +
                        " and .//td[normalize-space()='" + expectedWeight + "']" +
                        " and .//td[normalize-space()='" + expectedTotalCount + "']" +
                        "]"
        );

        boolean isRecordDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        submittedRecord
                )
        ).isDisplayed();

        System.out.println(
                "Submitted survey record displayed in Collection Records table: "
                        + isRecordDisplayed
        );

        return isRecordDisplayed;
    }


    // =========================================================
    // Wait for Actual Success Message to Disappear
    // =========================================================

    public void waitForSuccessToastToDisappear() {

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        successToastMessage
                )
        );

        System.out.println(
                "Survey submitted successfully message disappeared."
        );
    }


    // =========================================================
    // Collection Filter Methods
    // =========================================================

    public void clickCollectionFilterButton() {

        waitForSuccessToastToDisappear();

        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        collectionFilterButton
                )
        ).click();

        System.out.println(
                "Collection Filter button clicked successfully."
        );
    }

    public void enterCollectionFromDate(String fromDate) {

        WebElement fromDateElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        collectionFromdate
                )
        );

        fromDateElement.clear();
        fromDateElement.sendKeys(fromDate);
    }


    public void enterCollectionFromDateToday() {

        String todayDate = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        WebElement fromDateElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        collectionFromdate
                )
        );

        fromDateElement.clear();
        fromDateElement.sendKeys(todayDate);

        System.out.println(
                "Entered today's date in from date field: "
                        + todayDate
        );
    }


    public void enterCollectionToDateToday() {

        WebElement toDateElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        collectionTodate
                )
        );

        String todayDate = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "const element = arguments[0];" +
                "const value = arguments[1];" +
                "const setter = Object.getOwnPropertyDescriptor(" +
                "window.HTMLInputElement.prototype, 'value').set;" +
                "setter.call(element, value);" +
                "element.dispatchEvent(new Event('input', { bubbles: true }));" +
                "element.dispatchEvent(new Event('change', { bubbles: true }));",
                toDateElement,
                todayDate
        );
    }
//    public void enterCollectionToDate(String toDate) {
//
//        WebElement toDateElement = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        collectionTodate
//                )
//        );
//
//        toDateElement.clear();
//        toDateElement.sendKeys(toDate);
//    }


    public void clickCollectionFilterSearch() throws InterruptedException {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        collectionFilterSearch
                )
        ).click();

        System.out.println(
                "Collection Filter Search button clicked successfully."
        );
        Thread.sleep(3000); // Wait for 2 seconds to allow the table to refresh
    }


    // =========================================================
    // Collection Table Methods
    // =========================================================

    public boolean isAnyRecordPresent() {

        return !driver.findElements(
                By.xpath("//table//tbody//tr")
        ).isEmpty();
    }


    public void filterCollectionsForToday() throws InterruptedException {

        enterCollectionFromDateToday();

        enterCollectionToDateToday();

        clickCollectionFilterSearch();
    }


    // =========================================================
    // Validate Today's Collection Data
    // =========================================================

    public boolean isCollectionDataAvailableForToday() {

        String todayDate = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        for (WebElement dateElement :
                driver.findElements(collectionTableDates)) {

            if (dateElement.getText().equals(todayDate)) {

                System.out.println(
                        "Today's collection data is available in the table."
                );

                return true;
            }
        }

        System.out.println(
                "No collection data for today is available in the table."
        );

        return false;
    }
    public void clickCancelButton() {
		wait.until(
				ExpectedConditions.elementToBeClickable(
						cancelButton
				)
		).click();

		System.out.println(
				"Cancel button clicked successfully."
		);
	}
    
    public void clickRefreshTableButton() {
        driver.findElement(refreshTableButton).click();
    }
    
    public void clickViewIcon() {
		wait.until(
				ExpectedConditions.elementToBeClickable(
						clickviewicon
				)
		).click();

		System.out.println(
				"View icon clicked successfully."
		);
	}
    
    public boolean isCollectionDetailsDisplayed() {
		return wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						getcollectiondetais
				)
		).isDisplayed();
	}
    
}