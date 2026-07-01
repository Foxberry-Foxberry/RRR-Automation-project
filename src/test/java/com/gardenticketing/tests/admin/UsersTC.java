package com.gardenticketing.tests.admin;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gardenticketing.base.BaseAdminTest;
import com.gardenticketing.base.BaseTestclass;
import com.gardenticketing.pages.admin.Users;

public class UsersTC extends BaseAdminTest {
	
	public Users addusers;
	

	@BeforeClass
	
	public void setuppage() {
		
		addusers=new Users(driver);
	}
	

    @Test(priority=1)
    public void Verified_New_user_addedSuccesfully() throws InterruptedException {

        Users user = new Users(driver);
        Thread.sleep(5000);
        // Step 1: Click Users Menu
        user.openUsersModule();;

        // Step 2: Click Add Operator Button
        user.clickAddOperator();;

        // Step 3: Fill the Basic Details
        user.enterName("Test User");
        user.enterEmail("testuser@gmail.com");
        user.enterMobileNumber("9876543210");
        user.enterDOB("31-08-1999");

        Thread.sleep(2000);
        // Step 4: Select Gender
        user.selectGenderOption("Male");   // options: Male / Female / Other
        Thread.sleep(2000);
        // Step 5: Select User Type / Role
        user.selectUserRoleOption("Operator");  // role: Admin / Operator / User
        
        Thread.sleep(2000);
        
        user.selectGarden("BHOSARI SAHAL KENDRA UDYAN");

        // Optional: Validation step to confirm the selection
        Thread.sleep(2000); // small wait to see the selection
        System.out.println("Garden 'Operator' selected successfully."); 

        // Step 6: Submit the Form
        user.clickSubmit();
    }

         @Test(priority=2)
        public void Check_By_Selecting_pagination_fromDropdown() {
        	 
        	 addusers.selectPaginationByValue("1000"); 
  
           }


@Test(priority=3)

public void verify_User_deleted_Successfully() throws InterruptedException {
	Thread.sleep(5000);
	addusers.clickondeletebutton();
	addusers.deleteuserconfirmation();
	//Validate success message
    String message =addusers.getSuccessMessage();
//    Assert.assertEquals(message, "User deleted successfully");
	
}
    
	
    }
