package com.rrr_citizen.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rrr.base.BaseClass;
import com.rrr.page.citizen.AddSurveyForm;
import com.rrr.page.citizen.CollectionHistoryPage;

public class AddSurveyFormTC extends BaseClass {

    AddSurveyForm addSurveyForm;
    CollectionHistoryPage collectionHistoryPage;

    @BeforeMethod
    public void waitBeforeTest() throws InterruptedException {
        Thread.sleep(2000);
    }
    
    @Test(priority = 1)
    public void verifyRRRSurveySubmittedSuccesfully() {

        addSurveyForm = new AddSurveyForm(driver);
        collectionHistoryPage = new CollectionHistoryPage(driver);

        // Click Add Survey
        addSurveyForm.clickAddSurvey();

        // Location
        addSurveyForm.selectLocationCheckbox();

        // Donation
        addSurveyForm.clickDonationCheckbox();

        // Zone
        addSurveyForm.clickSelectZone();
        addSurveyForm.selectZoneA();

        // Ward
        addSurveyForm.clickSelectWard();
        addSurveyForm.selectWard10();

        // Donor Address
        addSurveyForm.enterDonorAddress("Mumbai Citizen Address");

        // =====================================================
        // Reusable Items - Shoes
        // =====================================================

        addSurveyForm.selectShoes();
        addSurveyForm.enterShoesQty("5");
        addSurveyForm.enterShoesWeight("2");

        // =====================================================
        // Clothes
        // =====================================================

        addSurveyForm.selectCloth();
        addSurveyForm.enterClothQty("10");
        addSurveyForm.enterClothWeight("5");

        // =====================================================
        // Toys
        // =====================================================

        addSurveyForm.selectToys();
        addSurveyForm.enterToysQty("3");
        addSurveyForm.enterToysWeight("1");

        // =====================================================
        // Bags
        // =====================================================

        addSurveyForm.selectBags();
        addSurveyForm.enterBagsQty("4");
        addSurveyForm.enterBagsWeight("2");

        // =====================================================
        // Furniture
        // =====================================================

        addSurveyForm.selectFurniture();
        addSurveyForm.enterFurnitureQty("2");
        addSurveyForm.enterFurnitureWeight("20");

        // =====================================================
        // Books & Stationary
        // =====================================================

        addSurveyForm.selectBooksStatinary();
        addSurveyForm.enterBooksStatinaryQty("15");
        addSurveyForm.enterBooksStatinaryWeight("8");

        // =====================================================
        // Recyclable Materials - Plastic
        // =====================================================

        addSurveyForm.selectPlaticmaterial();
        addSurveyForm.enterPlasticQty("10");
        addSurveyForm.enterPlasticWeight("3");

        // =====================================================
        // Paper & Cardboard
        // =====================================================

        addSurveyForm.selectPaperCardboard();
        addSurveyForm.enterPaperCardboardQty("20");
        addSurveyForm.enterPaperCardboardWeight("5");

        // =====================================================
        // Metal Items
        // =====================================================

        addSurveyForm.selectMetalItems();
        addSurveyForm.enterMetalItemsQty("5");
        addSurveyForm.enterMetalItemsWeight("4");

        // =====================================================
        // Glass Bottles
        // =====================================================

        addSurveyForm.selectGlassBottles();
        addSurveyForm.enterGlassBottlesQty("8");
        addSurveyForm.enterGlassBottlesWeight("6");

        // =====================================================
        // E-Waste
        // =====================================================

        addSurveyForm.selectEwaste();
        addSurveyForm.enterEwasteQty("2");
        addSurveyForm.enterEwasteWeight("3");

        // =====================================================
        // Household Items - Small Appliances
        // =====================================================

        addSurveyForm.selectSmallAppliances();
        addSurveyForm.enterSmallAppliancesQty("3");
        addSurveyForm.enterSmallAppliancesWeight("5");

        // =====================================================
        // Tools
        // =====================================================

        addSurveyForm.selectTools();
        addSurveyForm.enterToolsQty("4");
        addSurveyForm.enterToolsWeight("2");

        // =====================================================
        // Utensils
        // =====================================================

        addSurveyForm.selectUtensils();
        addSurveyForm.enterUtensilsQty("6");
        addSurveyForm.enterUtensilsWeight("4");

        // =====================================================
        // Other Material
        // =====================================================

        addSurveyForm.enterOtherMaterials("Wooden Waste");

        // =====================================================
        // Upload Donation Proof
        // =====================================================

        addSurveyForm.clickCameraIcon();
        addSurveyForm.clickCapturePhoto();

        // =====================================================
        // Submit Survey
        // =====================================================

        addSurveyForm.clickSubmitSurvey();

    }
       
    
    // =====================================================
        // Verify Submitted Record in Collection History Table
        // =====================================================

    @Test(priority = 2)
    public void verify_Submitted_SurveyForm_DisplayedSuccesfully() {

        collectionHistoryPage = new CollectionHistoryPage(driver);

        Assert.assertTrue(
                collectionHistoryPage.isSubmittedSurveyDisplayedInTable(
                        "waste collection organization",
                        97,
                        70
                ),
                "Submitted RRR survey record is not displayed in Collection History"
        );

        System.out.println(
                "RRR Survey Record Displayed Successfully in Collection History"
        );
       
    }
        
        
        @Test(priority = 3)
        public void verify_Collection_FilterApplied_Succesfully() throws InterruptedException {

        	collectionHistoryPage = new CollectionHistoryPage(driver);

        	collectionHistoryPage.clickCancelButton();
        	
        	
        	collectionHistoryPage.clickRefreshTableButton();
            // Click Collection Filter button
        	collectionHistoryPage.clickCollectionFilterButton();

            // Enter today's date in From Date
        	collectionHistoryPage.enterCollectionFromDateToday();

            // Enter today's date in To Date
        	collectionHistoryPage.enterCollectionToDateToday();

            // Click Search button
        	collectionHistoryPage.clickCollectionFilterSearch();
        	
        	

            System.out.println("Collection filter search executed successfully");
            
            
            // Validate today's data in table
            boolean isTodayDataAvailable =
            		collectionHistoryPage.isCollectionDataAvailableForToday();

            Assert.assertTrue(
                    isTodayDataAvailable,
                    "Filter not applied. Today's data is not available in the table."
            );
        }
        
        
    
    
        @Test(
        	    priority = 4,
        	    dependsOnMethods = {"verify_Submitted_SurveyForm_DisplayedSuccesfully"}
        	)
        	public void verify_Collection_details_shwoingonthetable() {

        	    collectionHistoryPage = new CollectionHistoryPage(driver);

        	    collectionHistoryPage.clickViewIcon();

        	    Assert.assertTrue(
        	            collectionHistoryPage.isCollectionDetailsDisplayed(),
        	            "Collection Details page is not displayed."
        	    );
        	}
}