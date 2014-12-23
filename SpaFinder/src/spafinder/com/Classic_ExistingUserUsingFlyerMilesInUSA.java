package spafinder.com;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import spafinder.com.locator.Classic_Locator;
import spafinder.com.value.Classic_Values;

public class Classic_ExistingUserUsingFlyerMilesInUSA extends spafinder.com.base.USABaseClass  {

	
	Classic_Locator cl = new Classic_Locator ();
	Classic_Values  cv = new Classic_Values  ();
	
	
@Test (enabled = false)
public void ClassicGuestUsingFlyerMilesUsingSAVEDCardInUSA () throws InterruptedException, IOException{
		
		driver.get(baseURL);
	
		clickByXpath (cl.MyAccountLink); // From global Header
		typeByXpath (cl.logInEmail, cv.emaiValue);
		typeByXpath (cl.logInPassword, cv.passwordValue);
		clickByXpath (cl.logInClickButton);
	
		driver.get(baseURL +"/Catalog/mail-spagiftcertificates.jsp");
		System.out.println("The Home Page Title is: " + driver.getTitle());
		clickByXpath (cl.addToCart_ButtonUSA);

// Personalize
		clickByXpath (cl.writePersonalNote);
		typeByXpath (cl.recipientName, cv.firstNameValue);
		typeByXpath (cl.senderName, cv.lastNameValue);
		typeByXpath (cl.personalMessage, cv.personalMsgValue);
	
// Apply FlyerMiles
		clickByXpath (cl.airLineRadioButton);
		dropDownById (cl.airLineByID, cv.AirLineTypes);
		typeById  (cl.airlineEditBoxLocator, cv.AirlineValue);
		clickByXpath (cl.personalize_Button);

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
		typeByXpath (cl.cvv, cv.securityCodeValue);
		clickByXpath (cl.completeYourOderButton_US);
						
// Confirmation Page
		String totalMoney  = driver.findElement(By.xpath(cl.totalPrice)).getText();
		Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
	    Matcher m = p.matcher(totalMoney);
	     
	    boolean b = m.find();
	    if (b)
	    {
	    	String Total = m.group();
	    	System.err.println ("=====================================================================");
	       
	  		 passData ("USA", "passFail", 14,cv.Pass); // writing the text into excel from selenium
			 setCellData ("USA", "OrderNumber", 14, cl.orderNumber); // Writing USA number into excel file.
			 System.out.println(getCellData("USA", "OrderNumber", 14)); // reading from excel\

			 passData ("USA", "Total", 14, Total);
			 System.out.println ("Total Price is: " + Total);
			 System.err.println ("=====================================================================");
			
	    	}
	    screenShot ("FlyerMiles_ClassicUser_USA");
	    	}
	    	
	     }
		
		

		
	