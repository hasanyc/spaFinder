package spafinder.com;


import java.awt.AWTException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import spafinder.com.locator.Classic_Locator;
import spafinder.com.value.Classic_Values;


public class Classic_GuestInUSA extends spafinder.com.base.USABaseClass  {
	
	Classic_Locator cl = new Classic_Locator ();
	Classic_Values  cv = new Classic_Values  ();
	
	
	
	
@Test (enabled = true)
public void classicGuestUSA () throws InterruptedException, IOException, AWTException, WriteException{
		
		driver.get(baseURL+"/Catalog/mail-spagiftcertificates.jsp");
		clickByXpath (cl.addToCart_ButtonUSA);
	  
// Personalize
		clickByXpath (cl.writePersonalNote);
		typeByXpath (cl.recipientName, cv.firstNameValue);
		typeByXpath (cl.senderName, cv.lastNameValue);
		typeByXpath (cl.personalMessage, cv.personalMsgValue);
		clickByXpath (cl.personalize_Button);
			
// Shipping Page
		typeByXpath (cl.firstName, cv.firstNameValue);
		typeByXpath (cl.lastName, cv.lastNameValue);
		dropDownById (cl.countryByID, cv.CountryValue);
		typeByXpath (cl.Address, cv.AddressValue);
		typeByXpath (cl.city, cv.CityValue);
		typeByXpath (cl.zipCode, cv.ZipcodeValue);
		dropDownById (cl.StateByID, cv.StateValue);
	//	radioButtonByXpath (cl.radioButton);
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
				
// Confirmation Page
		String totalMoney  = driver.findElement(By.xpath(cl.totalPrice)).getText();
		Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
	   	Matcher m = p.matcher(totalMoney);
	     
	    boolean b = m.find();
	    if (b)
	    {
	    	String total = m.group();
	    	System.err.println ("=====================================================================");
	       
	   boolean PF = driver.findElements (By.xpath(cl.orderNumber)).size() != 0;
		if (!PF)
		 {
			passData ("USA", "passFail", 17, cv.Fail); // writing the text into excel from selenium
		 } else  { 
			 passData ("USA", "passFail", 17,cv.Pass); // writing the text into excel from selenium
			 setCellData ("USA", "OrderNumber", 17, cl.orderNumber); // Writing order number into excel file.
			 System.out.println(getCellData("USA", "OrderNumber", 17)); // reading from excel\

			 passData ("USA", "Total", 17, total);
			 System.out.println ("Total Price is: " + total);
			 
//			 String cardType = driver.findElement(By.xpath(cl.cardType)).getText();
//			 passData ("Order", "cardType", 17, cardType); // writing today's date into excel.
			 screenShot ("USA_ClassicGuest");
			 System.err.println ("=====================================================================");	
		
		 		}
		
			}
	    	
	}	
}
		
	