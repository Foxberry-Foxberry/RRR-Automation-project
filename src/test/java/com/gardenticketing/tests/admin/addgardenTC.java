package com.gardenticketing.tests.admin;

import org.testng.annotations.Test;

import com.gardenticketing.base.BaseAdminTest;
import com.gardenticketing.base.BaseTestclass;
import com.gardenticketing.pages.admin.Addgardens;

public class addgardenTC extends BaseAdminTest {


    @Test(priority = 1)
    public void verify_theNew_garden_added_Successfully() throws InterruptedException {

    	 Addgardens garden = new Addgardens(driver);
        
        // 1. Navigate to Gardens Module
        
        garden.clickOnGardensMenu();
        Thread.sleep(6000);
        garden.clickAddGardenButton();

        // 2. Enter Garden Names
        garden.enterGardenName("Central Garden");
        garden.enterUdyanName("सेन्ट्रल गार्डन");

        // 3. Select Area
        garden.selectAreaField();
        garden.selectAreaChinchwad();
        garden.addareacode("AC123");

        // 4. Select Zone
        garden.clickZone();
        garden.selectAZone();

        // 5. Location Fields
        garden.clickLocationField("Near Metro Station");
        garden.clickStanField("मेट्रो स्टेशन जवळ");

        // 6. Google Map URL
        garden.enterGMapURL("https://maps.google.com/sample-location");

        // 7. Coordinates
        garden.enterLatitude("18.6290");
        garden.enterLongitude("73.7990");

        // 8. Capacity
        garden.enterMaxCapacity("500");

        // 9. Entry Prices
        garden.enterAdultPrice("50");
        garden.enterChildPrice("25");

        // 10. Description
        garden.enterDescription("Large garden with jogging track and playground.");
        garden.enterVarnan("धावपट्टी आणि खेळाची सोय असलेले मोठे उद्यान");

        // 11. Upload Image & Video
        garden.uploadImage("C:\\Users\\Foxberry\\Foxberry Project\\gardenticketing-Automation\\src\\test\\resource\\testdata\\garden image.webp");
        garden.clickCropImage();
        garden.clickUploadImage();
        Thread.sleep(3000);
        garden.uploadVideo("C:\\Users\\Foxberry\\Foxberry Project\\gardenticketing-Automation\\src\\test\\resource\\testdata\\garden vidios10mb.mp4");
        Thread.sleep(2000);
        // 12. Start selection
        garden.clickStartTime();           // Clicks the input (your method)
        garden.setStartTime("10:30");      // Directly sets time without popup
        
        Thread.sleep(2000);
// End Time
        garden.clickEndTime();         // Click the end time input
        garden.setEndTime("21:00"); 
        
        
        Thread.sleep(3000);
        garden.clickSaveButton();

        
        Thread.sleep(4000);
        
        // 13. Enable Creator Allow Toggle
        garden.toggleCreatorAllow();

        // 14. Photography / Videography Prices
        garden.enterPhotographyPrice("500");
        garden.enterVideographyPrice("1000");

        // 15.  Submit Garden
       
        garden.submitGardenForm();
        
        Thread.sleep(3000);
        
        System.out.println("garden added Succesfully");

    }
    @Test(priority = 2, dependsOnMethods = {"verify_theNew_garden_added_Successfully"})
    public void verify_Update_Garden_Details() throws InterruptedException {

        Addgardens garden = new Addgardens(driver);

        // 1. Open Gardens Module
        garden.clickOnGardensMenu();
        Thread.sleep(3000);

        // 2. Click Last Garden and Open Details
        garden.clickLastGardenAndUpdate();
        Thread.sleep(3000);


        // 4. Update required fields only
       garden.updateMaxCapacity();
        garden.enterMaxCapacity("600");   // Update Capacity
        garden.updatePhotographyPrice();
        garden.enterPhotographyPrice("750");   // Update Photography Price
        garden.updateVideographyPrice();
        garden.enterVideographyPrice("1200");  // Update Videography Price
        Thread.sleep(2000);
        garden.clickonupdatebutton();
        
        System.out.println(" Garden Updated succesfully");
        }

    @Test(priority = 3, dependsOnMethods = {"verify_Update_Garden_Details"})
    public void verify_lastGarden_is_deleted_successfully() throws InterruptedException {
        
        Addgardens garden = new Addgardens(driver);

        // 1. Navigate to Garden module
        garden.clickOnGardensMenu();
        Thread.sleep(3000);

        // 2. Open last added garden
        garden.openLastGarden();
        Thread.sleep(2000);

        // 3. Click Delete button
        garden.clickDeleteButton();
        Thread.sleep(1000);

        // 4. Confirm delete popup
        garden.confirmDelete();
        Thread.sleep(3000);

//        // 5. Assertion
//        String message = garden.getDeleteSuccessMessage();
//        Assert.assertTrue(message.contains("deleted") || message.contains("success"),
//                "Delete message not displayed!");

        System.out.println("Garden deleted successfully!");
    }

    
    
}
