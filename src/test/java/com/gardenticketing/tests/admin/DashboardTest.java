package com.gardenticketing.tests.admin;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gardenticketing.base.BaseAdminTest;
import com.gardenticketing.base.BaseTestclass;
import com.gardenticketing.pages.admin.DashboardPage;

public class DashboardTest extends BaseAdminTest {

    private DashboardPage dashboard;
//    public LoginPage login;

    @BeforeClass
    public void setUpPage() {
        // Initialize page object after driver setup from BaseTestclass
        dashboard = new DashboardPage(driver);
    }

    @Test(priority = 1, description = "Verify Total Gardens card count and navigation")
    public void verifyTotalGardensCard() {
        String count = dashboard.getCardCount("Total Gardens");
        System.out.println("Total Gardens count: " + count);

        // Validate that count is not empty or invalid
        Assert.assertFalse(count.isEmpty(), "Total Gardens count should not be empty");

        // Click and navigate
        dashboard.clickCard("Total Gardens");
        driver.navigate().back();
    }

    @Test(priority = 2, description = "Verify Total Tickets card count and navigation")
    public void verifyTotalTicketsCard() {
        String count = dashboard.getCardCount("Total Tickets");
        System.out.println("Total Tickets count: " + count);

        Assert.assertFalse(count.isEmpty(), "Total Tickets count should not be empty");

        dashboard.clickCard("Total Tickets");
        driver.navigate().back();
    }

    @Test(priority = 3, description = "Verify Total Collection card count and navigation")
    public void verifyTotalCollectionCard() {
        String count = dashboard.getCardCount("Total Collection");
        System.out.println("Total Collection value: " + count);

        Assert.assertFalse(count.isEmpty(), "Total Collection should not be empty");

        dashboard.clickCard("Total Collection");
        driver.navigate().back();
    }

    @Test(priority = 4, description = "Verify Total Users card count and navigation")
    public void verifyTotalUsersCard() {
        String count = dashboard.getCardCount("Total Users");
        System.out.println("Total Users count: " + count);

        Assert.assertFalse(count.isEmpty(), "Total Users count should not be empty");

        dashboard.clickCard("Total Users");
        driver.navigate().back();
    }

    @Test(priority = 5, description = "Verify Pie Graph visibility and click")
    public void verifyPieGraph() {
        dashboard.clickPieGraph();
        System.out.println("Clicked on Pie Graph successfully");
        driver.navigate().back();
    }
}
