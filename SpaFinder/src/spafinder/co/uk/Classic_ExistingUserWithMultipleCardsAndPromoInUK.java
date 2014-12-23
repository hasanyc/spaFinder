package spafinder.co.uk;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import spafinder.com.locator.Classic_Locator;
import spafinder.com.value.Classic_Values;

public class Classic_ExistingUserWithMultipleCardsAndPromoInUK extends spafinder.com.base.UKBaseClass  {

	Classic_Locator cl = new Classic_Locator ();
	Classic_Values  cv = new Classic_Values  ();
	
@Test
public void ClassicExistingUserWithMultipleCardsAndPromoInUK () throws InterruptedException, IOException{
	
		driver.get(baseURL);
		clickByXpath (cl.MyAccountLink); // From global Header
		typeByXpath (cl.logInEmail, cv.UKemailValue);
		typeByXpath (cl.logInPassword, cv.passwordValue);
		clickByXpath (cl.logInClickButton);
		driver.get(baseURL + "/Catalog/mail-spagiftcertificates.jsp");
		clickByXpath (cl.addToCart_ButtonUK);
		
		
// Personalize (Card 1)
		clickByXpath (cl.writePersonalNote);
		typeByXpath (cl.recipientName, cv.firstNameValue);
		typeByXpath (cl.senderName, cv.lastNameValue);
		typeByXpath (cl.personalMessage, "UK Classic  User - Card 1 and promo");
		
// Card 2
		clickByLink(cl.continueShoppingLinkText);
		clickByXpath (cl.addToCart_ButtonUK);
		clickByXpath (cl.writePersonalNote2);
		typeByXpath (cl.recipientName2, "Sayan");
		typeByXpath (cl.senderName2, "Bhuiyan");
		typeByXpath (cl.personalMessage2, "UK Classic user - Card 2 & Promo");
		dCookieByName (cl.ukCookiesPolicyCancle);
		scroll();
					
// Apply Promo Code
		typeById (cl.promoEditBoxId, cv.promoValue);
		clickById (cl.promoApplyButtonId);
		
		String actPromoText = driver.findElement(By.cssSelector(cl.promoTextCss)).getText();
		String expPromoText = "Promo:";
		boolean asserTion 	 = expPromoText.equals(actPromoText);
		if (asserTion == false)
		 {
			 System.err.println ("Expected: " + expPromoText + " | Actual: " + actPromoText + " = " + asserTion);
		 } else  { 
			 System.out.println ("Expected: " + expPromoText + " | Actual: " + actPromoText + " = " + asserTion);
			 
		String promoAmount = driver.findElement(By.xpath (cl.promoDiscountXpath2)).getText();
		System.err.println ("Discount Amount is: " + promoAmount);
		System.out.println ("");
		clickByXpath (cl.personalize_Button2);
		
				
// Shipping Page
		dCookieByName (cl.ukCookiesPolicyCancle);
		typeByXpath (cl.firstName, cv.firstNameValue);
		typeByXpath (cl.lastName, cv.lastNameValue);
		dropDownById (cl.countryByID, cv.UKcountryValue);
		typeByXpath (cl.Address, cv.UKAddressValue);
		typeByXpath (cl.city, cv.UKCityValue);
		typeByXpath (cl.zipCode, cv.UKZipCodeValue);
		scroll();
		dropDownById (cl.countryByID, cv.UKcountryValue);
		clickByXpath (cl.promoShippingButton_UKUser); // Proccced to Checkout from UK Shipping Page
						
// Billing page
		clickByXpath (cl.ukBillingAsShipping);
		typeByXpath (cl.email, cv.UKemailValue);
		typeByXpath (cl.phoneNumber, cv.ukPhoneNumber);
		typeByXpath (cl.cardNumber, cv.CardNoValue);
		typeByXpath (cl.sercurityCodes, cv.securityCodeValue);
		typeByXpath (cl.expMM, cv.ExpMMvalue);
		typeByXpath (cl.expYY, cv.ExpYYvalue);
		clickByXpath (cl.completeYourOderButton_US);
		

		String totalMoney  = driver.findElement(By.xpath(cl.totalPrice)).getText();
		Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
	    Matcher m = p.matcher(totalMoney);
	      
	    boolean b = m.find();
	    if (b)
	    {
	    	String totalAmount = m.group();
	    	System.err.println ("=====================================================================");		
	 
	  	boolean PF = driver.findElement(By.xpath(cl.UKorderNumber)).isDisplayed();
	    if (PF == false)
	    {
	    	passData ("Order", "passFail", 16, cv.Fail); // writing the text into excel from selenium
	    } else  { 
	    	passData ("UK", "passFail", 16, cv.Pass); // writing the text into excel from selenium
	    	setCellData ("UK", "OrderNumber", 16, cl.orderNumber); // Writing UK number into excel file.
	    	System.out.println(getCellData("UK", "OrderNumber", 16)); // reading from excel\

	    	passData ("UK", "Total", 16, totalAmount);
	    	System.out.println ("Total Price is: " + totalAmount);
	    	System.err.println ("=====================================================================");	
				}
		   	}
		  }
		screenShot ("MultipleCardsAndPromo_ukClassicUSER");
	}	
}