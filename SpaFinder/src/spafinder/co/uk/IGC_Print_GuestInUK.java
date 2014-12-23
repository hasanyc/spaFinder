package spafinder.co.uk;

import java.io.IOException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import spafinder.com.locator.IGC_Locator;
import spafinder.com.value.IGC_Values;

public class IGC_Print_GuestInUK extends spafinder.com.base.UKBaseClass {
	IGC_Locator gcl = new IGC_Locator ();
	IGC_Values  gcv = new IGC_Values ();
	
@Test
public void IGC_PrintGuestInUK () throws InterruptedException, IOException{
	
		driver.get(baseURL+"/Catalog/online-spagiftcertificates.htm?type=print");
		clickByXpath (gcl.PersonalizeIt);
		typeByXpath (gcl.from, gcv.firstNameValue);
		typeByXpath (gcl.to, gcv.lastNameValue);
		typeByXpath (gcl.messgeBox, "IGC Guest Print in UK - By Automation");
		scroll();
		dCookieByName (gcl.ukCookiesPolicyCancle);
		clickByXpath (gcl.ProceedToCheckout);
		clickByXpath (gcl.guestButton);					                  // Guest Signing In
	
				
// Billing Info
		typeByXpath (gcl.email, gcv.UKemailValue);
		typeByXpath (gcl.FirstName, gcv.UKfirstNameValue);
		typeByXpath (gcl.LastName, gcv.UKlastNameValue);
		dropDownById (gcl.countryBoxId, gcv.UKcountryValue);
		scroll();
		dCookieByName (gcl.ukCookiesPolicyCancle);
		
		typeByXpath (gcl.address, gcv.UKAddressValueValue);
		typeByXpath (gcl.city, gcv.UKCityValue);
		typeByXpath (gcl.zipCode, gcv.UKZipCodeValue);
		dropDownById (gcl.stateBoxById, gcv.UKStateValue);
		
		typeByXpath (gcl.phoneNumber, gcv.ukPhoneNumber);
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
	    
	    
	   boolean PF = driver.findElements(By.xpath(gcl.orderNumber)).size() != 0;
		if (PF == false)
		 {
			passData ("UK", "passFail", 30, gcv.Fail); // writing the text into excel from selenium
		 } else  { 
			passData ("UK", "passFail", 30, gcv.Pass); // writing the text into excel from selenium
			setCellData ("UK", "OrderNumber", 30, gcl.orderNumber); // Writing order number into excel file.
			System.out.println(getCellData("UK", "OrderNumber", 30)); // reading from excel\

			passData ("UK", "Total", 30, total);
			System.out.println ("Total Price is: " + total);
			System.err.println ("=====================================================================");	
			
			screenShot ("UK_IGC_GuestUsingPrint");		 // screenshot from confirmation Page
			System.out.println ();
		 	clickByXpath (gcl.print_PrintCardButton);
		 	
// Switching to the new tab
		 	
		 	Set<String> handles = driver.getWindowHandles();
			String current = driver.getWindowHandle();
			handles.remove(current);
			String newTab = handles.iterator().next();
			driver.switchTo().window(newTab);
			Thread.sleep(1000);
			
			String actNewTabText = driver.findElement(By.xpath(gcl.print_VerifyNewTabText)).getText();
			String expNewTabText = "eVoucher Information";
			boolean assertNewTab = expNewTabText.equals(actNewTabText);
			if (!assertNewTab)
			 {
				 System.err.println ("Expected: " + expNewTabText + " | Actual: " + actNewTabText + " = " + assertNewTab);
			 } else  { 
				 System.out.println ("Expected: " + expNewTabText + " | Actual: " + actNewTabText + " = " + assertNewTab);
			 	}
		   
	    
		System.out.println();
		screenShot ("UK_IGC_GuestUsingPrintFromNewTab");  // New Tab

// Verifying GC Number from BackOffice
	    
	    driver.get(baseURL+"/admin");
	    typeByXpath (gcl.adminUserName, gcv.adminUserValue);
	    typeByXpath (gcl.adminUserPass, gcv.passwordValue);
	    clickByXpath (gcl.adminSubmitButton);
	    driver.get(baseURL+"/BackOff/view.do?value(orderId)="+orderNo);
	    screenShot ("BackOffice_UK_IGC.Print_Guest");
	    
	    String gcNumber = driver.findElement (By.xpath(gcl.gcNumber)).getText();
	    System.out.println ("Your GC/Voucher Number is: "+gcNumber);
	    passData ("UK", "GC_Number", 30, gcNumber); // Writing order number into excel file.
	   	     
	    String gcAmount  = driver.findElement(By.xpath(gcl.gcValue)).getText();
	    p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
	    m = p.matcher(gcAmount);
	    b = m.find();
	    if (b)
	    {
	    	String gcTotal = m.group();
	    
	    System.out.println ("Your GC/Voucher Total amount is: " + gcTotal);
	    passData ("UK", "GC_Total", 30, gcTotal);
	    		}
		 	}
	    }
	}
}

		

