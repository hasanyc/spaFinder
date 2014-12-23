package spafinder.com;

import java.awt.AWTException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.write.WriteException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import spafinder.com.locator.Classic_Locator;
import spafinder.com.value.Classic_Values;

public class Classic_GuestUsingMultipleCardsAndPromoInUSA extends spafinder.com.base.USABaseClass  {
	
	Classic_Locator cl = new Classic_Locator ();
	Classic_Values  cv = new Classic_Values  ();
	
	
	
@Test
public void ClassicGuest_UsingMultipleCardsAndPromoInUSA () throws InterruptedException, IOException, AWTException, WriteException{
		
		driver.get(baseURL+"/Catalog/mail-spagiftcertificates.jsp");
		clickByXpath (cl.addToCart_ButtonUSA);
	  
// Personalize (Card 1)
		clickByXpath (cl.writePersonalNote);
		typeByXpath (cl.recipientName, cv.firstNameValue);
		typeByXpath (cl.senderName, cv.lastNameValue);
		typeByXpath (cl.personalMessage, "Classic - Card 1");
		
// Card 2
		clickByLink(cl.continueShoppingLinkText);
		driver.findElement(By.cssSelector("a.selector")).click();
		driver.findElement(By.xpath("//div/ul/li")).click();
		new Select(driver.findElement(By.id("SF_amount"))).selectByVisibleText("$25");

		clickByCss (cl.add2ndCardCss);
		clickByXpath (cl.writePersonalNote2);
		typeByXpath (cl.recipientName2, "Ash");
		typeByXpath (cl.senderName2, "Jay");
		typeByXpath (cl.personalMessage2, "Classic - Card 2");

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

		typeByXpath (cl.firstName, cv.firstNameValue);
		typeByXpath (cl.lastName, cv.lastNameValue);
		dropDownById (cl.countryByID, cv.CountryValue);
		typeByXpath (cl.Address, cv.AddressValue);
		typeByXpath (cl.city, cv.CityValue);
		typeByXpath (cl.zipCode, cv.ZipcodeValue);
		dropDownById (cl.StateByID, cv.StateValue);
		clickByXpath (cl.billingInfo_Button); // step 3: Billing Info Button
	
// Billing Page
		
		clickByXpath (cl.billingAsShipping);
		typeByXpath (cl.email, cv.emaiValue);
		clickByXpath (cl.stateInBllingPage);
		clickByXpath (cl.stateNYinBillingPage);
		
		typeByXpath (cl.phoneNumber, cv.PhoneNumberValue);
		typeByXpath (cl.cardNumber, cv.CardNoValue);
		typeByXpath (cl.sercurityCodes, cv.securityCodeValue);
		typeByXpath (cl.expMM, cv.ExpMMvalue);
		typeByXpath (cl.expYY, cv.ExpYYvalue);
		clickByXpath (cl.completeYourOderButton_US);
		Thread.sleep(1000);
				
// Confirmation Page
	
		String totalMoney  = driver.findElement(By.xpath(cl.totalPrice)).getText();
		Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
	    Matcher m = p.matcher(totalMoney);
	     
	    boolean b = m.find();
	    if (b)
	    {
	    	String promoTotal = m.group();
	    	System.err.println ("=====================================================================");
	       
	   boolean PF = driver.findElements(By.xpath(cl.orderNumber)).size() != 0;
		if (!PF)
		 {
			passData ("USA", "passFail", 20, cv.Fail); // writing the text into excel from selenium
		 } else  { 
			 passData ("USA", "passFail", 20,cv.Pass); // writing the text into excel from selenium
			 setCellData ("USA", "OrderNumber", 20, cl.orderNumber); // Writing USA number into excel file.
			 System.out.println(getCellData("USA", "OrderNumber", 20)); // reading from excel\

			 passData ("USA", "Total", 20, promoTotal);
			 System.out.println ("Total Price is: " + promoTotal);
			 System.err.println ("=====================================================================");
         
		 		}
		 	}
	    	screenShot ("MultipleCardsAndPromo_USAClassicGuest");
	     }
		
	}	
}
		