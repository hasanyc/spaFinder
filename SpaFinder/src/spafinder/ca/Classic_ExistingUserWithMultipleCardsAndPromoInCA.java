package spafinder.ca;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import spafinder.com.locator.Classic_Locator;
import spafinder.com.value.Classic_Values;

public class Classic_ExistingUserWithMultipleCardsAndPromoInCA extends spafinder.com.base.CABaseClass  {

	Classic_Locator cl = new Classic_Locator ();
	Classic_Values  cv = new Classic_Values  ();
	
	
	@Test(enabled = true)
	public void ClassicMemberWithPromoAndMultipleCards_Express () throws InterruptedException, IOException{
		

		driver.get(baseURL);
		clickByXpath (cl.MyAccountLink); // From global Header
 		typeByXpath (cl.logInEmail, cv.emaiValue);
		typeByXpath (cl.logInPassword, cv.passwordValue);
		clickByXpath (cl.logInClickButton);
		driver.get(baseURL + "/Catalog/mail-spagiftcertificates.jsp");
		clickByXpath (cl.addToCart_ButtonUSA);

		clickByLink(cl.continueShoppingLinkText);  // To another card.
		clickByCss (cl.add2ndCardCss);
		
// Personalize (Card 1)
		clickByXpath (cl.writePersonalNote);
		typeByXpath (cl.recipientName, cv.firstNameValue);
		typeByXpath (cl.senderName, cv.lastNameValue);
		typeByXpath (cl.personalMessage, "CA USER Classic - Card 1");
		
// Card 2
		clickByXpath (cl.writePersonalNote2);
		typeByXpath (cl.recipientName2, "Ash");
		typeByXpath (cl.senderName2, "Jay");
		typeByXpath (cl.personalMessage2, "CA USER Classic - Card 2 and Promo");

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
		
// Express Shipping Options
		clickByXpath (cl.caExpressRadioButton);
		String actFee = driver.findElement(By.xpath(cl.caExpressFeeVerify)).getText();
		String expFee = "$8.00";
		boolean expressShipping	 = expFee.equals(actFee);
		if (expressShipping == false)
		 {
			 System.err.println ("Expected: " + expFee + " | Actual: " + actFee + " = " + expressShipping);
		 } else  { 
			 System.out.println ("Expected : " + expFee + " | Actual: " + actFee + " = " + expressShipping);
	
		typeByXpath (cl.firstName, cv.firstNameValue);
		typeByXpath (cl.lastName, cv.lastNameValue);
		dropDownById (cl.countryByID, cv.CountryValueCA);
		typeByXpath (cl.Address, cv.AddressValueCA);
		typeByXpath (cl.city, cv.CityValueCA);
		typeByXpath (cl.zipCode, cv.ZipcodeValueCA);
		dropDownById (cl.StateByID, cv.StateValueCA);
		clickByXpath (cl.billingInfo_Button); // step 3: Billing Info Button	
		
// Billing Page

		clickByXpath (cl.billingAsShipping);
		typeByXpath (cl.email, cv.emaiValue);
		typeByXpath (cl.phoneNumber, cv.PhoneNumberValue);
		typeByXpath (cl.cardNumber, cv.CardNoValue);
		typeByXpath (cl.sercurityCodes, cv.securityCodeValue);
		typeByXpath (cl.expMM, cv.ExpMMvalue);
		typeByXpath (cl.expYY, cv.ExpYYvalue);
		clickByXpath (cl.completeYourOderButton_US);
				
// Confirmation Page
	
		String totalMoney  = driver.findElement(By.xpath(cl.totalPrice)).getText();
		Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
	   	Matcher m = p.matcher(totalMoney);
	     
	    boolean b = m.find();
	    if (b)
	    {
	    	String total = m.group();
	    	System.err.println ("=====================================================================");
	       
	   boolean PF = driver.findElements(By.xpath(cl.orderNumber)).size() != 0;
		if (!PF)
		 {
			passData ("CA", "passFail", 13, cv.Fail); // writing the text into excel from selenium
		 } else  { 
			 passData ("CA", "passFail", 13,cv.Pass); // writing the text into excel from selenium
			 setCellData ("CA", "OrderNumber", 13, cl.orderNumber); // Writing order number into excel file.
			 System.out.println(getCellData("CA", "OrderNumber", 13)); // reading from excel\

			 passData ("CA", "Total", 13, total);
			 System.out.println ("Total Price is: " + total);
			 System.err.println ("=====================================================================");	
		
		 			}
	    		 }
	    	screenShot ("PromoCA_MultipleCardsAndPromoInCA");	
		 }
	  	}	
	}
}
		
