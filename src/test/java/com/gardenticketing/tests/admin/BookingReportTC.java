package com.gardenticketing.tests.admin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gardenticketing.base.BaseAdminTest;
import com.gardenticketing.base.BaseTestclass;
import com.gardenticketing.pages.admin.BookingReport;

public class BookingReportTC extends BaseAdminTest {

	private BookingReport Bookinghistory;
	
	
	@BeforeClass
	
	public void setuppage() {
		
		Bookinghistory=new BookingReport(driver);
	}
	
	
	@Test(priority=1)
	public void  verifyByclickingOnBookingReport() throws InterruptedException {
		Thread.sleep(5000);
		Bookinghistory.clickBookingReportTab();
//		Bookinghistory.clickGeneralPass();
		
		
}

	@Test(priority=2)
	public void Verifythe_all_Genralpass_tickets_showing() throws InterruptedException{
		
		Bookinghistory.clickGeneralPass();
		
		 String actualText =Bookinghistory.getGeneralPassText();
	
		    // Assertion
		    Assert.assertFalse(actualText.isEmpty(), "General Pass Text is NOT displayed!");
		    System.out.println("Displayed Text: " + actualText);
	
	}
	
	@Test(priority=3)
	public void Verifythe_all_Creatorpass_tickets_showing_Dashboard() {
		
		Bookinghistory.clickCreatorPass();
		
		 String actualText =Bookinghistory.getCreatorPassText();
	
		    // Assertion
		    Assert.assertFalse(actualText.isEmpty(), "CreatorPass Text is NOT displayed!");
		    System.out.println("Displayed Text: " + actualText);
	
	}
	@Test(priority=4)
	public void Verify_the_all_Event_pass_tickets_showing_Dashboard() {
		
		Bookinghistory.clickEventPass();
		
		 String actualText =Bookinghistory.getEventPassText();
	
		    // Assertion
		    Assert.assertFalse(actualText.isEmpty(), "EventPass Text is NOT displayed!");
		    System.out.println("Displayed Text: " + actualText);
	}
	
	@Test(priority=5)
public void Check_by_Selecting_FromDate() {
		Bookinghistory.clickFromDate();
}
	
	@Test(priority=6)
public void Check_by_Selecting_ToDate() {
		Bookinghistory.clickToDate();
}
	@Test(priority=7)
	public void verify_datewise_datashowingOn_table() {
		Bookinghistory.clickSearchDateWiseButton();
		
	}
	
	@Test(priority=7)
	public void verify_filterdata_reseted_afterClickedOn_Reset() {
		Bookinghistory.clickResetDateButton();
	}
	
	
	@Test(priority=8)
	public void verify_the_Usercan_View_Ticket_succesfully_And_Cancel_ticket_icon() {
		Bookinghistory.clickViewActionButton();
		Bookinghistory.clickCancelTicketIcon();
		
	}
	
	
	
	@Test(priority=9)
	public void verify_the_garden_ticketExported_succesfully_ByclickonExportfunctionaity() {
		Bookinghistory.clickExportButton();
	}
	
	@AfterMethod
	public void slowDown() throws InterruptedException {
	    Thread.sleep(2000);   // 2 seconds delay after each test
	}
	
}
