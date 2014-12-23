package spafinder.co.uk;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import spafinder.com.locator.Classic_Locator;
import spafinder.com.value.Classic_Values;

public class Classic_GuestUsing3DVisaInUK extends spafinder.com.base.UKBaseClass  {

	
	Classic_Locator cl = new Classic_Locator ();
	Classic_Values  cv = new Classic_Values  ();
	
	
	
	@Test (enabled = true)
	public void ClassicGuestUsing3dVisa_InUK () throws InterruptedException, IOException{
		

		driver.get(baseURL + "/Catalog/mail-spagiftcertificates.jsp");
		clickByXpath (cl.addToCart_ButtonUK);
		
		
// Personalize
		clickByXpath (cl.writePersonalNote);
		typeByXpath (cl.recipientName, cv.firstNameValue);
		typeByXpath (cl.senderName, cv.lastNameValue);
		typeByXpath (cl.personalMessage, cv.personalMsgValue);
		clickByXpath (cl.personalize_Button);
			
// Shipping Page
		
		typeByXpath (cl.firstName, cv.firstNameValue);
		typeByXpath (cl.lastName, cv.lastNameValue);
		dropDownById (cl.countryByID, cv.UKcountryValue);
		typeByXpath (cl.Address, cv.UKAddressValue);
		typeByXpath (cl.city, cv.UKCityValue);
		typeByXpath (cl.zipCode, cv.UKZipCodeValue);
		typeById (cl.StateByID, cv.UKCounty);
		clickByXpath (cl.BillingInfoMember_UK); // step 3: Billing Info Button
	
		
// Billing page
		
		clickByXpath (cl.ukBillingAsShipping);
		typeByXpath (cl.email, cv.UKemailValue);
		typeByXpath (cl.phoneNumber, cv.ukPhoneNumber);
		typeByXpath (cl.cardNumber, cv.Uk3dVisa);
		typeByXpath (cl.sercurityCodes, cv.Uk3dVisaPasswordValue);
		typeByXpath (cl.expMM	, cv.ExpMMvalue);
		typeByXpath (cl.expYY, cv.ExpYYvalue);
		clickByXpath (cl.completeYourOderButton_US);
		
		iFrameByTagName (cl.Uk3dVisaTagName);
		
		String actText = driver.findElement(By.xpath (cl.UkVisaVerifiedText)).getText();
		String expText = "Please submit your Verified by Visa password.";
		boolean asserTion 	 = expText.equals(actText);
		if (asserTion == false) 
		{
			 System.err.println ("Expected: " + expText + " | Actual: " + actText + " = " + asserTion);
		} else  { 
			System.out.println ("Expected: " + expText + " | Actual: " + actText + " = " + asserTion);
			System.err.println (actText);
				
		typeByXpath (cl.Uk3dVisaPassword, cv.Uk3dVisaPasswordValue);
		System.out.println ("3D Visa password has been Submitted!!");
		clickByXpath (cl.Uk3dVisaSubmitButton);
		
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
	    	passData ("Order", "passFail", 19, cv.Fail); // writing the text into excel from selenium
	    } else  { 
	    	passData ("UK", "passFail", 19, cv.Pass); // writing the text into excel from selenium
	    	setCellData ("UK", "OrderNumber", 19, cl.orderNumber); // Writing UK number into excel file.
	    	System.out.println(getCellData("UK", "OrderNumber", 19)); // reading from excel\

	    	passData ("UK", "Total", 19, totalAmount);
	    	System.out.println ("Total Price is: " + totalAmount);
	    	
	    	System.err.println ("=====================================================================");	
					
			}
	    }
	    screenShot ("3D_UkClassicGUEST");
    }
}
}
