package com.rrr.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rrr.base.BaseClass;
import com.rrr.page.citizen.CollectionHistoryPage;

/**
 * Tests for Collection History filter (From / To / Search)
 *
 * These tests assume BaseClass handles driver init and login to the citizen portal.
 */
public class CollectionHistoryTest extends BaseClass {

    @Test(description = "Filter collections by From=Today and To=Today and verify results")
    public void testFilterFromToToday() throws InterruptedException {
        CollectionHistoryPage page = new CollectionHistoryPage(driver);

        // Open filter UI
        page.clickCollectionFilterButton();

        // Set both from & to to today and apply search
        page.filterCollectionsForToday();

        // Verify at least one record is shown
        Assert.assertTrue(page.isAnyRecordPresent(), "Expected records for today's filter but none were found");
    }

    @Test(description = "Filter collections by From=Today only and verify results")
    public void testFilterFromTodayOnly() throws InterruptedException {
        CollectionHistoryPage page = new CollectionHistoryPage(driver);

        page.clickCollectionFilterButton();

        // Set only From date to today and click search
        page.enterCollectionFromDateToday();
        page.clickCollectionFilterSearch();

        Assert.assertTrue(page.isAnyRecordPresent(), "Expected records when filtering From=today but none were found");
    }
}
