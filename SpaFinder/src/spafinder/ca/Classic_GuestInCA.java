package spafinder.ca;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import spafinder.com.locator.Classic_Locator;
import spafinder.com.value.Classic_Values;

public class Classic_GuestInCA extends spafinder.com.base.CABaseClass  {

	Classic_Locator cl = new Classic_Locator ();
	Classic_Values  cv = new Classic_Values  ();
	
	
@Test(enabled = true)
public void ClassicGuestInCA () throws InterruptedException, IOException{
		
		driver.get(baseURL + "/Catalog/mail-spagiftcertificates.jsp");
		clickByXpath (cl.addToCart_ButtonUSA);
		
// Personalize
		clickByXpath (cl.writePersonalNote);
		typeByXpath (cl.recipientName, cv.firstNameValue);
		typeByXpath (cl.senderName, cv.lastNameValue);
		typeByXpath (cl.personalMessage, "CA Classic Guest - By Automation");
		clickByXpath (cl.personalize_Button);
			
// Shipping Page
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
			passData ("CA", "passFail", 15, cv.Fail); // writing the text into excel from selenium
		 } else  { 
			 passData ("CA", "passFail", 15,cv.Pass); // writing the text into excel from selenium
			 setCellData ("CA", "OrderNumber", 15, cl.orderNumber); // Writing order number into excel file.
			 System.out.println(getCellData("CA", "OrderNumber", 15)); // reading from excel\

			 passData ("CA", "Total", 15, total);
			 System.out.println ("Total Price is: " + total);
			 System.err.println ("=====================================================================");	
		
		 		}
			screenShot ("CA_ClassicGuestUsingFREEshipping");
			}
	   }	
}
		
	