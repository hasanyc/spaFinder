package spafinder.ca;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import spafinder.com.base.CABaseClass;
import spafinder.com.locator.IGC_Locator;
import spafinder.com.value.IGC_Values;



public class IGC_GuestInCA extends CABaseClass {

	IGC_Locator gcl = new IGC_Locator ();
	IGC_Values  gcv = new IGC_Values ();
	
	@Test
	public void IGC_Email_GuestInCa () throws InterruptedException, IOException{
		
		driver.get(baseURL+"/Catalog/online-spagiftcertificates.htm?type=email");
		typeByXpath (gcl.deliveryEmailAddress, gcv.emaiValue);
		clickByXpath (gcl.PersonalizeIt);
		typeByXpath (gcl.from, gcv.firstNameValue);
		typeByXpath (gcl.to, gcv.lastNameValue);
		clickByXpath (gcl.ProceedToCheckout);
		clickByXpath (gcl.guestButton);
			
	// Billing Info
		typeByXpath (gcl.email, gcv.emaiValue);
		typeByXpath (gcl.FirstName, gcv.firstNameValue);
		typeByXpath (gcl.LastName, gcv.lastNameValue);
		dropDownById (gcl.countryBoxId, gcv.CountryValueCA);
		
		typeByXpath (gcl.address, gcv.AddressValueCA);
		typeByXpath (gcl.city, gcv.CityValueCA);
		typeByXpath (gcl.zipCode, gcv.ZipcodeValueCA);
		dropDownById (gcl.stateBoxById, gcv.StateValueCA);
		
		typeByXpath (gcl.phoneNumber, gcv.PhoneNumberValueCA);
		typeByXpath (gcl.cardNumber, gcv.CardNoValue);
		//typeByXpath (gcl.cardNumber, gcv.AmexCard);
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
	    	String totalAmount = m.group();
	    	System.err.println ("=====================================================================");		
	  
	    boolean PF = driver.findElements(By.xpath(gcl.orderNumber)).size() != 0;
	    if (PF == false)
	     {
	    	passData ("CA", "passFail", 7, gcv.Fail); // writing the text into excel from selenium
		 } else  { 
			passData ("CA", "passFail", 7, gcv.Pass); // writing the text into excel from selenium
			setCellData ("CA", "OrderNumber", 7, gcl.orderNumber); // Writing CA number into excel file.
			System.out.println(getCellData("CA", "OrderNumber", 7)); // reading from excel
			
			passData ("CA", "Total", 7, totalAmount);
			System.out.println ("Total Amount is: " + totalAmount);
			System.err.println ("=====================================================================");		
			System.out.println ();
			
			}
			}
	    	screenShot ("CA_IgcEmailGuest");

// Verifying GC Number from BackOffice
		    
		    driver.get(baseURL+"/admin");
		    typeByXpath (gcl.adminUserName, gcv.adminUserValue);
		    typeByXpath (gcl.adminUserPass, gcv.passwordValue);
		    clickByXpath (gcl.adminSubmitButton);
		    driver.get(baseURL+"/BackOff/view.do?value(orderId)="+orderNo);
		    screenShot ("BackOffice_CA_IGC.Email_Guest");
		    
		    String gcNumber = driver.findElement (By.xpath(gcl.gcNumber)).getText();
		    System.out.println ("Your GC/Voucher Number is: "+gcNumber);
		    passData ("CA", "GC_Number", 7, gcNumber); // Writing order number into excel file.
		   	     
		    String gcAmount  = driver.findElement(By.xpath(gcl.gcValue)).getText();
		    p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
		    m = p.matcher(gcAmount);
		    b = m.find();
		    if (b)
		    {
		    	String gcTotal = m.group();
		    
		    System.out.println ("Your GC/Voucher Total amount is: " + gcTotal);
		    passData ("CA", "GC_Total", 7, gcTotal);
		  }
	}
	}

		