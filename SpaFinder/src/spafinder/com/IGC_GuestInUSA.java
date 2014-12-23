package spafinder.com;



import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import spafinder.com.locator.IGC_Locator;
import spafinder.com.value.IGC_Values;


public class IGC_GuestInUSA extends spafinder.com.base.USABaseClass {

	IGC_Locator gcl = new IGC_Locator ();
	IGC_Values  gcv = new IGC_Values ();
	
	@Test
	public void IGC_Email_GuestInUSA () throws InterruptedException, IOException{
	
		driver.get(baseURL+"/Catalog/online-spagiftcertificates.htm?type=email");
		typeByXpath (gcl.deliveryEmailAddress, gcv.emaiValue);
		clickByXpath (gcl.PersonalizeIt);
		typeByXpath (gcl.from, gcv.firstNameValue);
		typeByXpath (gcl.to, gcv.lastNameValue);
		clickByXpath (gcl.ProceedToCheckout);
		clickByXpath (gcl.guestButton);					// Guest Signing In
	
	// Billing page
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
	       
	   boolean PF = driver.findElement(By.xpath(gcl.orderNumber)).isDisplayed();
		if (PF == false)
		 {
			passData ("USA", "passFail", 8, gcv.Fail); // writing the text into excel from selenium
		 } else  { 
			 passData ("USA", "passFail", 8, gcv.Pass); // writing the text into excel from selenium
			 setCellData ("USA", "OrderNumber", 8, gcl.orderNumber); // Writing order number into excel file.
			 System.out.println(getCellData("USA", "OrderNumber", 8)); // reading from excel\

			 passData ("USA", "Total", 8, total);
			 System.out.println ("Total Price is: " + total);
			 System.err.println ("=====================================================================");	
		       						
		 	}
		   }
	    screenShot ("USA_IGC.Email_Guest");
	    
// Verifying GC Number from BackOffice
	    
	    driver.get(baseURL+"/admin");
	    typeByXpath (gcl.adminUserName, gcv.adminUserValue);
	    typeByXpath (gcl.adminUserPass, gcv.passwordValue);
	    clickByXpath (gcl.adminSubmitButton);
	    driver.get(baseURL+"/BackOff/view.do?value(orderId)="+orderNo);
	    screenShot ("BackOffice_USA_IGC.Email_Guest");
	    
	    String gcNumber = driver.findElement (By.xpath(gcl.gcNumber)).getText();
	    System.out.println ("Your GC/Voucher Number is: "+gcNumber);
	    passData ("USA", "GC_Number", 8, gcNumber); // Writing order number into excel file.
	   	     
	    String gcAmount  = driver.findElement(By.xpath(gcl.gcValue)).getText();
	    p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
	    m = p.matcher(gcAmount);
	    b = m.find();
	    if (b)
	    {
	    	String gcTotal = m.group();
	    
	    System.out.println ("Your GC/Voucher Total amount is: " + gcTotal);
	    passData ("USA", "GC_Total", 8, gcTotal);
	  }
}
}