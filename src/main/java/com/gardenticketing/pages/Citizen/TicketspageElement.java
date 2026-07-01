package com.gardenticketing.pages.Citizen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketspageElement {

    WebDriver driver;

    public TicketspageElement(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/tickets']")
    WebElement ticketsPage;

    @FindBy(xpath = "(//button[@title='Download'])[1]")
    WebElement firstTicketDownload;

    public void openTicketsPage() {

        ticketsPage.click();
    }

    public void clickDownloadTicket() {

        firstTicketDownload.click();
    }
}