package spafinder.com;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import spafinder.com.locator.IGC_Locator;
import spafinder.com.value.IGC_Values;

public class IGC_GuestUsingMultipleCardsAndPromoInUSA extends spafinder.com.base.USABaseClass {

	IGC_Locator gcl = new IGC_Locator ();
	IGC_Values  gcv = new IGC_Values ();
	
@Test
public void IGC_Email_GuestWithMultipleCardsAndPromo_InUSA () throws InterruptedException, IOException{
	
	
	driver.get(baseURL+"/Catalog/online-spagiftcertificates.htm?type=email");

// Card 1
	typeByXpath (gcl.deliveryEmailAddress, gcv.emaiValue); 
	clickByXpath (gcl.PersonalizeIt);
	typeByXpath (gcl.from, gcv.firstNameValue);
	typeByXpath (gcl.to, gcv.lastNameValue);
	typeByXpath (gcl.messgeBox, "Automation - CARD 1");
	
// Adding Card II
	clickByLink (gcl.addAnotherCardLink);
	clickByXpath (gcl.image2);
	typeByXpath (gcl.deliveryEmailAddress2, gcv.emaiValue); 
	clickByXpath (gcl.PersonalizeIt2);
	typeByXpath (gcl.from2, "Ashique");
	typeByXpath (gcl.to2, "Sage");
	typeByXpath (gcl.messgeBox2, "Automation - CARD 2");
		
	clickByXpath (gcl.ProceedToCheckout2);
	clickByXpath (gcl.guestButton);
	
// Verify If card2 is present
	
	String actCard2 = driver.findElement(By.xpath(gcl.assertCard2)).getText();
	String expCard2 = "CARD 2";
	
	boolean verifyCard2 	 = expCard2.equals(actCard2);
	if (!verifyCard2) 
	{
		 System.err.println ("Expected: " + expCard2 + " | Actual: " + actCard2 + " = " + verifyCard2);
	} else  { 
		System.out.println ("Expected: " + expCard2 + "  | Actual: " + actCard2 + " = " + verifyCard2);
	
	
// Entering PromoCode
	scroll ();
	typeById (gcl.promoEditBoxId, gcv.promoValue);
	clickById (gcl.promoApplyButtonId);
	 
	String actPromoText = driver.findElement(By.cssSelector(gcl.promoTextCss)).getText();
	String expPromoText = "Promo";
	boolean asserTion 	 = expPromoText.equals(actPromoText);
	if (asserTion == false) 
	{
		 System.err.println ("Expected: " + expPromoText + " | Actual: " + actPromoText + " = " + asserTion);
	} else  { 
		System.out.println ("Expected: " + expPromoText + "  | Actual: " + actPromoText + " = " + asserTion);
		 
	String promoAmount = driver.findElement(By.xpath (gcl.promoDiscountXpath)).getText();
	System.err.println ("Discount Amount is: " + promoAmount);
	System.out.println ("");	
			
// Billing Information page
	typeByXpath (gcl.email, gcv.emaiValue);
	typeByXpath (gcl.FirstName, gcv.firstNameValue);
	typeByXpath (gcl.LastName, gcv.lastNameValue);
	dropDownById (gcl.countryBoxId, gcv.CountryValue);
	    
	typeByXpath (gcl.address, gcv.AddressValue);
	typeByXpath (gcl.city, gcv.CityValue);
	typeByXpath (gcl.zipCode, gcv.ZipcodeValue);
	dropDownById (gcl.stateBoxById, gcv.StateValue);
	
	typeByXpath (gcl.phoneNumber, gcv.PhoneNumberValue);
	typeByXpath (gcl.cardNumber, gcv.CardNoValue);
	typeByXpath (gcl.securityCode, gcv.securityCodeValue);
	typeByXpath (gcl.expMM, gcv.ExpMMvalue);
	typeByXpath (gcl.expYY, gcv.ExpYYvalue);
	clickByXpath (gcl.CompleteYourOderButton);
	Thread.sleep(1500);
	
	String orderNumber = driver.findElement (By.xpath(gcl.orderNumber)).getText();
	String orderNo		= orderNumber.replaceAll("[^\\d.]", "");
			
	String totalMoney  = driver.findElement(By.xpath(gcl.totalPrice)).getText();
	Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
    Matcher m = p.matcher(totalMoney);
     
    boolean b = m.find();
    if (b)
    {
    	String total = m.group();
    	System.err.println ("=====================================================================");
       
   boolean PF = driver.findElements(By.xpath(gcl.orderNumber)).size() != 0;
	if (PF == false)
	 {
		passData ("USA", "passFail", 11, gcv.Fail); // writing the text into excel from selenium
	 } else  { 
		 passData ("USA", "passFail", 11, gcv.Pass); // writing the text into excel from selenium
		 setCellData ("USA", "OrderNumber", 11, gcl.orderNumber); // Writing order number into excel file.
		 System.out.println(getCellData("USA", "OrderNumber", 11)); // reading from excel\

		 passData ("USA", "Total", 11, total);
		 System.out.println ("Total Price is: " + total);
		 System.err.println ("=====================================================================");	
		   						
	
	}
	screenShot ("USA_IGC.Email.Guest_WithMultipleNpromo");
    }
	
// Verifying GC Number from BackOffice
    
    driver.get(baseURL+"/admin");
    typeByXpath (gcl.adminUserName, gcv.adminUserValue);
    typeByXpath (gcl.adminUserPass, gcv.passwordValue);
    clickByXpath (gcl.adminSubmitButton);
    driver.get(baseURL+"/BackOff/view.do?value(orderId)="+orderNo);
    screenShot ("BackOffice_USA_IGC.Email.Guest_WithMultipleNpromo");
    
    String gc1 = driver.findElement(By.xpath(gcl.gcNumber)).getText();
    String gc2 = driver.findElement(By.xpath(gcl.gcNumber2)).getText();
    System.out.println ("Your 1st GC/Voucher Number is: "+ gc1);
    System.out.println ("Your 2nd GC/Voucher Number is: "+ gc2);
    passData ("USA", "GC_Number", 11, gc1); // CARD 1
    passData ("USA", "GC_Number2", 11, gc2); // CARD 1
    
	// Face value 1
    String gcAmount  = driver.findElement(By.xpath(gcl.gcValue)).getText();
    p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
    m = p.matcher(gcAmount);
    b = m.find();
    if (b)
    {
    	String gcTotal = m.group();
    System.out.println ("Your 1st GC/Voucher Total amount is: " + gcTotal);
    passData ("USA", "GC_Total", 11, gcTotal); // CARD 1
    }
    
    // Face value 2
    String gcAmount2 = driver.findElement(By.xpath(gcl.gcValue2)).getText();
    p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
    m = p.matcher(gcAmount2);
    b = m.find();
    if (b)
    {
    	String gcTotal2 = m.group();
    System.out.println ("Your 2st GC/Voucher Total amount is: " + gcTotal2);
    passData ("USA", "GC_Total2", 11, gcTotal2); // CARD 2
     }

    
	}
	}
}
}


