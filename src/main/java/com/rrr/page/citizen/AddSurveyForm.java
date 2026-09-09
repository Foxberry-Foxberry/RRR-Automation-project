package com.rrr.page.citizen;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddSurveyForm {
	 WebDriver driver;

	    // Constructor
	    public AddSurveyForm(WebDriver driver) {
	        this.driver = driver;
	    }

	//WebElements

	//Survey Form Field

	private By clickaddsurvey=By.xpath("//button[contains(@class,'px-4') and contains(@class,'bg-blue-700')]");
	private By selectLocationCheckbopx=By.xpath("//input[@class='w-5 h-5 accent-blue-600']");
	private By Donationcheckbox=By.xpath("//label[normalize-space()='Unknown / Forceful Donation']/input[@type='checkbox']");
	private By clickselectZone=By.xpath("//div[contains(@class,'cursor-pointer') and .//span[text()='▼']]");
	private By SelectAZone =By.xpath("//button[normalize-space()='A']");
	private By clickSelectWard=By.xpath("(//div[contains(@class,'cursor-pointer') and .//span[text()='▼']])[2]");
	private By selectWard10=By.xpath("//button[normalize-space()='10']");
	private By Donaraddress= By.xpath("(//input[@type='text'])[2]");

	//Reusable Items
	//shoes
	private By selectShoes=By.xpath("//span[normalize-space()='Shoes']/preceding-sibling::input[@type='checkbox']");
	private By selectShoesQty=By.xpath("//label[normalize-space()='Qty']/preceding-sibling::input[@type='tel']");
	private By selectShoesWeight=By.xpath("//label[normalize-space()='Weight (kg)']/preceding-sibling::input[@type='tel']");

	//Cloth
	private By selectCloth=By.xpath("//span[normalize-space()='Clothes']/preceding-sibling::input[@type='checkbox']");
	private By selectClothQty=By.xpath("//label[.//span[normalize-space()='Clothes']]/following-sibling::div//label[normalize-space()='Qty']/preceding-sibling::input");
	private By selectClothweight=By.xpath("//label[.//span[normalize-space()='Clothes']]/following-sibling::div//label[normalize-space()='Weight (kg)']/preceding-sibling::input");
	//Toys
	private By selectToys=By.xpath("//span[normalize-space()='Toys']/preceding-sibling::input[@type='checkbox']");
	private By selectToysQty =By.xpath("//label[.//span[normalize-space()='Toys']]/following-sibling::div//label[normalize-space()='Qty']/preceding-sibling::input");
	private By selectToysweight =By.xpath("//label[.//span[normalize-space()='Toys']]/following-sibling::div//label[normalize-space()='Weight (kg)']/preceding-sibling::input");
	//Bags
	private By selectBags=By.xpath("//span[normalize-space()='Bags']/preceding-sibling::input[@type='checkbox']");
	private By selectBagsQty=By.xpath("//label[.//span[normalize-space()='Bags']]/following-sibling::div//label[normalize-space()='Qty']/preceding-sibling::input");
	private By selectBagsweight=By.xpath("//label[.//span[normalize-space()='Bags']]/following-sibling::div//label[normalize-space()='Weight (kg)']/preceding-sibling::input");
	//Furniture
	private By selectFurniture=By.xpath("//span[normalize-space()='Furniture']/preceding-sibling::input[@type='checkbox']");
	private By selectFurnitureQty=By.xpath("//label[.//span[normalize-space()='Furniture']]/following-sibling::div//label[normalize-space()='Qty']/preceding-sibling::input");
	private By selectFurnitureweight=By.xpath("//label[.//span[normalize-space()='Furniture']]/following-sibling::div//label[normalize-space()='Weight (kg)']/preceding-sibling::input");
	//Books & Statinary
	private By selectBooksStatinary=By.xpath("//span[normalize-space()='Books & Statinary']/preceding-sibling::input[@type='checkbox']");
	private By selectBooksStatinaryQty=By.xpath("//label[.//span[normalize-space()='Books & Statinary']]/following-sibling::div//label[normalize-space()='Qty']/preceding-sibling::input"); 
	private By selectBooksStatinaryweight=By.xpath("//label[.//span[normalize-space()='Books & Statinary']]/following-sibling::div//label[normalize-space()='Weight (kg)']/preceding-sibling::input");

	
	
	
	//Recyclable Materials
//1)Patsic (Bottles, Containers, Wrappers)
private By selectPlaticmaterial=By.xpath("//span[normalize-space()='Plastic (Bottles,Containers,Wrappers)']/preceding-sibling::input[@type='checkbox']");
private By selectPlasticQty=By.xpath("//label[.//span[normalize-space()='Plastic (Bottles,Containers,Wrappers)']]/following-sibling::div//label[normalize-space()='Qty']/preceding-sibling::input");
private By selectPlasticweight=By.xpath("//label[.//span[normalize-space()='Plastic (Bottles,Containers,Wrappers)']]/following-sibling::div//label[normalize-space()='Weight (kg)']/preceding-sibling::input");

//2) Paper & cardboard
private By selectPaperCardboard = By.xpath("//span[normalize-space()='Paper & cardboard']/preceding-sibling::input[@type='checkbox']");
private By selectPaperCardboardQty = By.xpath("//label[.//span[normalize-space()='Paper & cardboard']]/following-sibling::div//label[normalize-space()='Qty']/preceding-sibling::input");
private By selectPaperCardboardweight = By.xpath("//label[.//span[normalize-space()='Paper & cardboard']]/following-sibling::div//label[normalize-space()='Weight (kg)']/preceding-sibling::input");

//3) Metal Items
private By selectMetalItems = By.xpath("//span[normalize-space()='Metal items']/preceding-sibling::input[@type='checkbox']");
private By selectMetalItemsQty = By.xpath("//label[.//span[normalize-space()='Metal items']]/following-sibling::div//label[normalize-space()='Qty']/preceding-sibling::input");
private By selectMetalItemsweight = By.xpath("//label[.//span[normalize-space()='Metal items']]/following-sibling::div//label[normalize-space()='Weight (kg)']/preceding-sibling::input");

//4) Glass Bottles
private By selectGlassBottles = By.xpath("//span[normalize-space()='Glass bottles']/preceding-sibling::input[@type='checkbox']");
private By selectGlassBottlesQty = By.xpath("//label[.//span[normalize-space()='Glass bottles']]/following-sibling::div//label[normalize-space()='Qty']/preceding-sibling::input");
private By selectGlassBottlesweight = By.xpath("//span[normalize-space()='Glass bottles']/ancestor::label/following-sibling::div//label[normalize-space()='Weight (kg)']/preceding-sibling::input");

//5) E-waste
private By selectEwaste = By.xpath("//span[normalize-space()='E-waste (old electronics, wires, charges)']/preceding-sibling::input[@type='checkbox']");
private By selectEwasteQty = By.xpath("//label[.//span[normalize-space()='E-waste (old electronics, wires, charges)']]/following-sibling::div//label[normalize-space()='Qty']/preceding-sibling::input");
private By selectEwasteweight = By.xpath("//label[.//span[normalize-space()='E-waste (old electronics, wires, charges)']]/following-sibling::div//label[normalize-space()='Weight (kg)']/preceding-sibling::input");

//Household Items

//1) Small Appliances
private By selectSmallAppliances = By.xpath("//span[normalize-space()='Small appliances']/preceding-sibling::input[@type='checkbox']");
private By selectSmallAppliancesQty = By.xpath("//label[.//span[normalize-space()='Small appliances']]/following-sibling::div//label[normalize-space()='Qty']/preceding-sibling::input");
private By selectSmallAppliancesweight = By.xpath("//label[.//span[normalize-space()='Small appliances']]/following-sibling::div//label[normalize-space()='Weight (kg)']/preceding-sibling::input");

//2) Tools
private By selectTools = By.xpath("//span[normalize-space()='Tools']/preceding-sibling::input[@type='checkbox']");
private By selectToolsQty = By.xpath("//label[.//span[normalize-space()='Tools']]/following-sibling::div//label[normalize-space()='Qty']/preceding-sibling::input");
private By selectToolsweight = By.xpath("//label[.//span[normalize-space()='Tools']]/following-sibling::div//label[normalize-space()='Weight (kg)']/preceding-sibling::input");

//3) Utensils
private By selectUtensils = By.xpath("//span[normalize-space()='Utensils']/preceding-sibling::input[@type='checkbox']");
private By selectUtensilsQty = By.xpath("//label[.//span[normalize-space()='Utensils']]/following-sibling::div//label[normalize-space()='Qty']/preceding-sibling::input");
private By selectUtensilsweight = By.xpath("//label[.//span[normalize-space()='Utensils']]/following-sibling::div//label[normalize-space()='Weight (kg)']/preceding-sibling::input");

//Summary & Extra Details

//Enter other Materials

private By enterOtherMaterials=By.xpath("//label[text()='Enter Other / Waste Material']/preceding-sibling::input");

//Uplode Donation Proof through Camera

private By clickCameraIcon=By.xpath("//button[contains(@class,'bg-blue-800') and contains(@class,'text-white')]");

//capture photo
private By clickCapturePhoto=By.xpath("//button[contains(@class,'bg-green-600') and contains(@class,'rounded')]");


//Submit Survey

private By clickSubmitSurvey=By.xpath("//div[contains(text(),'Submit Survey')]");



//Survey Form Methods
	

	public void clickAddSurvey() {
		driver.findElement(clickaddsurvey).click();
	}

	public void selectLocationCheckbox() {
		driver.findElement(selectLocationCheckbopx).click();
	}

	public void clickDonationCheckbox() {
		driver.findElement(Donationcheckbox).click();
	}

	public void clickSelectZone() {
		driver.findElement(clickselectZone).click();
	}

	public void selectZoneA() {
		driver.findElement(SelectAZone).click();
	}

	public void clickSelectWard() {
		driver.findElement(clickSelectWard).click();
	}

	public void selectWard10() {
		driver.findElement(selectWard10).click();
	}

	public void enterDonorAddress(String address) {
		driver.findElement(Donaraddress).sendKeys(address);
	}

	
	//Shoes


	public void selectShoes() {
		driver.findElement(selectShoes).click();
	}

	public void enterShoesQty(String qty) {
		driver.findElement(selectShoesQty).sendKeys(qty);
	}

	public void enterShoesWeight(String weight) {
		driver.findElement(selectShoesWeight).sendKeys(weight);
	}


	//Clothes
	
	public void selectCloth() {
		driver.findElement(selectCloth).click();
	}

	public void enterClothQty(String qty) {
		driver.findElement(selectClothQty).sendKeys(qty);
	}

	public void enterClothWeight(String weight) {
		driver.findElement(selectClothweight).sendKeys(weight);
	}


	//Toys


	public void selectToys() {
		driver.findElement(selectToys).click();
	}

	public void enterToysQty(String qty) {
		driver.findElement(selectToysQty).sendKeys(qty);
	}

	public void enterToysWeight(String weight) {
		driver.findElement(selectToysweight).sendKeys(weight);
	}

	//Bags

	public void selectBags() {
		driver.findElement(selectBags).click();
	}

	public void enterBagsQty(String qty) {
		driver.findElement(selectBagsQty).sendKeys(qty);
	}

	public void enterBagsWeight(String weight) {
		driver.findElement(selectBagsweight).sendKeys(weight);
	}

	//========================
	//Furniture
	//========================

	public void selectFurniture() {
		driver.findElement(selectFurniture).click();
	}

	public void enterFurnitureQty(String qty) {
		driver.findElement(selectFurnitureQty).sendKeys(qty);
	}

	public void enterFurnitureWeight(String weight) {
		driver.findElement(selectFurnitureweight).sendKeys(weight);
	}

	
	//Books & Statinary
	

	public void selectBooksStatinary() {
		driver.findElement(selectBooksStatinary).click();
	}

	public void enterBooksStatinaryQty(String qty) {
		driver.findElement(selectBooksStatinaryQty).sendKeys(qty);
	}

	public void enterBooksStatinaryWeight(String weight) {
		driver.findElement(selectBooksStatinaryweight).sendKeys(weight);
	}

//Recyclable Materials
	//Plastic (Bottles, Containers, Wrappers)
	public void selectPlaticmaterial() {
		driver.findElement(selectPlaticmaterial).click();
	}

	public void enterPlasticQty(String qty) {
		driver.findElement(selectPlasticQty).sendKeys(qty);
	}

	public void enterPlasticWeight(String weight) {
		driver.findElement(selectPlasticweight).sendKeys(weight);
	}
	
	//Paper & Cardboard

	public void selectPaperCardboard() {
		driver.findElement(selectPaperCardboard).click();
	}

	public void enterPaperCardboardQty(String qty) {
		driver.findElement(selectPaperCardboardQty).sendKeys(qty);
	}

	public void enterPaperCardboardWeight(String weight) {
		driver.findElement(selectPaperCardboardweight).sendKeys(weight);
	}


	//Metal Items

	public void selectMetalItems() {
		driver.findElement(selectMetalItems).click();
	}

	public void enterMetalItemsQty(String qty) {
		driver.findElement(selectMetalItemsQty).sendKeys(qty);
	}

	public void enterMetalItemsWeight(String weight) {
		driver.findElement(selectMetalItemsweight).sendKeys(weight);
	}


	//Glass Bottles

	public void selectGlassBottles() {
		driver.findElement(selectGlassBottles).click();
	}

	public void enterGlassBottlesQty(String qty) {
		driver.findElement(selectGlassBottlesQty).sendKeys(qty);
	}

	public void enterGlassBottlesWeight(String weight) {
		driver.findElement(selectGlassBottlesweight).sendKeys(weight);
	}


	//E-waste

	public void selectEwaste() {
		driver.findElement(selectEwaste).click();
	}

	public void enterEwasteQty(String qty) {
		driver.findElement(selectEwasteQty).sendKeys(qty);
	}

	public void enterEwasteWeight(String weight) {
		driver.findElement(selectEwasteweight).sendKeys(weight);
	}


	//Small Appliances

	public void selectSmallAppliances() {
		driver.findElement(selectSmallAppliances).click();
	}

	public void enterSmallAppliancesQty(String qty) {
		driver.findElement(selectSmallAppliancesQty).sendKeys(qty);
	}

	public void enterSmallAppliancesWeight(String weight) {
		driver.findElement(selectSmallAppliancesweight).sendKeys(weight);
	}


	//Tools

	public void selectTools() {
		driver.findElement(selectTools).click();
	}

	public void enterToolsQty(String qty) {
		driver.findElement(selectToolsQty).sendKeys(qty);
	}

	public void enterToolsWeight(String weight) {
		driver.findElement(selectToolsweight).sendKeys(weight);
	}


	//Utensils

	public void selectUtensils() {
		driver.findElement(selectUtensils).click();
	}

	public void enterUtensilsQty(String qty) {
		driver.findElement(selectUtensilsQty).sendKeys(qty);
	}

	public void enterUtensilsWeight(String weight) {
		driver.findElement(selectUtensilsweight).sendKeys(weight);
	}


	//Other Materials

	public void enterOtherMaterials(String material) {
		driver.findElement(enterOtherMaterials).sendKeys(material);
	}


	//Camera
	public void clickCameraIcon() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(clickCameraIcon)).click();
	}

	//Capture Photo

	public void clickCapturePhoto() {
		driver.findElement(clickCapturePhoto).click();
	}


	//Submit Survey

	public void clickSubmitSurvey() {
		driver.findElement(clickSubmitSurvey).click();
	}
	
	
	
	
	
	
}
