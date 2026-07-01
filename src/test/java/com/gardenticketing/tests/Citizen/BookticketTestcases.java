package com.gardenticketing.tests.Citizen;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gardenticketing.base.BaseTestClassCitizen;
import com.gardenticketing.pages.Citizen.BookticketobjectPage;
import com.gardenticketing.utils.ConfigReader;

public class BookticketTestcases extends BaseTestClassCitizen {

	@BeforeMethod(alwaysRun = true)
	public void navigateToHomePage() throws InterruptedException {

	    Thread.sleep(2000);   // Optional

	    driver.navigate().to("https://stg.garden.chdc.foxberry.live/");

	    System.out.println("Navigated to Home Page");
	}

    @Test(priority = 1)
    public void verifyGenralTicketBookingAndUPIPayment() throws InterruptedException {

        BookticketobjectPage book = new BookticketobjectPage(driver);

        System.out.println("Step 1 : Click Explore Garden");
        book.clickExploreGarden();

        System.out.println("Step 2 : Select Garden");
        book.clickSelectGarden();

        System.out.println("Step 3 : Add Child Ticket");
        book.addChildTicket();

        System.out.println("Step 4 : Add Adult Ticket");
        book.addAdultTicket();

        System.out.println("Step 5 : Confirm Ticket");
        book.clickConfirmTicket();

        System.out.println("Step 6 : Proceed To Pay");
        book.clickProceedToPay();

        System.out.println("Step 7 : Complete UPI Payment");
        book.completeUPIPayment("success@easebuzz");

        Thread.sleep(5000);

        String bookedDate = book.getTicketBookDate();
        String bookedSlot = book.getTicketBookSlot();
        String bookedAmount = book.getBookingAmount();

        System.out.println("=====================================");
        System.out.println("Booking Successful");
        System.out.println("Booked Date   : " + bookedDate);
        System.out.println("Booked Slot   : " + bookedSlot);
        System.out.println("Booked Amount : " + bookedAmount);
        System.out.println("=====================================");
    }

    @Test(priority = 2)
    public void verifyCreatorPassPhotographyBookingAndUPIPayment() throws InterruptedException {

        BookticketobjectPage book = new BookticketobjectPage(driver);

        System.out.println("Step 1 : Click Explore Garden");
        book.clickExploreGarden();

        System.out.println("Step 2 : Select Garden");
        book.clickSelectGarden();

        System.out.println("Step 3 : Select Creator Pass");
        book.clickCreatorPass();

        System.out.println("Step 4 : Add Adult Ticket");
        book.addAdultTicket();

        System.out.println("Step 5 : Confirm Ticket");
        book.clickConfirmTicket();

        System.out.println("Step 6 : Proceed To Pay");
        book.clickProceedToPay();

        System.out.println("Step 7 : Complete UPI Payment");
        book.completeUPIPayment("success@easebuzz");

        Thread.sleep(5000);

        String bookedDate = book.getTicketBookDate();
        String bookedSlot = book.getTicketBookSlot();
        String bookedAmount = book.getBookingAmount();

        System.out.println("=====================================");
        System.out.println("Photography Creator Pass Booking Successful");
        System.out.println("Booked Date   : " + bookedDate);
        System.out.println("Booked Slot   : " + bookedSlot);
        System.out.println("Booked Amount : " + bookedAmount);
        System.out.println("=====================================");
    }

    @Test(priority = 3)
    public void verifyCreatorPassVideographyBookingAndUPIPayment() throws InterruptedException {

        BookticketobjectPage book = new BookticketobjectPage(driver);

        System.out.println("Step 1 : Click Explore Garden");
        book.clickExploreGarden();

        System.out.println("Step 2 : Select Garden");
        book.clickSelectGarden();

        System.out.println("Step 3 : Select Creator Pass");
        book.clickCreatorPass();

        System.out.println("Step 4 : Select Videography Pass");
        book.VediographyPass();

        System.out.println("Step 5 : Add Child Ticket");
        book.addChildTicket();

        System.out.println("Step 6 : Add Adult Ticket");
        book.addAdultTicket();

        System.out.println("Step 7 : Confirm Ticket");
        book.clickConfirmTicket();

        System.out.println("Step 8 : Proceed To Pay");
        book.clickProceedToPay();

        System.out.println("Step 9 : Complete UPI Payment");
        book.completeUPIPayment("success@easebuzz");

        Thread.sleep(5000);

        String bookedDate = book.getTicketBookDate();
        String bookedSlot = book.getTicketBookSlot();
        String bookedAmount = book.getBookingAmount();

        System.out.println("=====================================");
        System.out.println("Videography Creator Pass Booking Successful");
        System.out.println("Booked Date   : " + bookedDate);
        System.out.println("Booked Slot   : " + bookedSlot);
        System.out.println("Booked Amount : " + bookedAmount);
        System.out.println("=====================================");
    }
   
}