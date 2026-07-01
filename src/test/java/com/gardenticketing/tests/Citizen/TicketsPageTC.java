package com.gardenticketing.tests.Citizen;
import com.gardenticketing.utils.FileUtilityDownlode;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gardenticketing.base.BaseTestClassCitizen;
import com.gardenticketing.pages.Citizen.TicketspageElement;



public class TicketsPageTC extends BaseTestClassCitizen {

	
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void navigateToHomePage() throws InterruptedException {

	    Thread.sleep(2000);   // Optional

	    driver.navigate().to("https://stg.garden.chdc.foxberry.live/");

	    System.out.println("Navigated to Home Page");
	}
    @Test
    public void verifyTicketDownloadedSuccessfully() {

        TicketspageElement ticketPage =
                new TicketspageElement(driver);

        ticketPage.openTicketsPage();

        FileUtilityDownlode.deleteOldTickets();

        ticketPage.clickDownloadTicket();

        Assert.assertTrue(
        		FileUtilityDownlode.isTicketDownloaded(),
                "Ticket Download Failed");

        System.out.println("Ticket Downloaded Successfully");
    }
}