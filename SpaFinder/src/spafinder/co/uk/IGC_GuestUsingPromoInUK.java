package spafinder.co.uk;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import spafinder.com.locator.IGC_Locator;
import spafinder.com.value.IGC_Values;


public class IGC_GuestUsingPromoInUK extends spafinder.com.base.UKBaseClass {
	IGC_Locator gcl = new IGC_Locator ();
	IGC_Values  gcv = new IGC_Values ();
	
	
@Test
public void IGC_GuestWithPromoInUK () throws InterruptedException, IOException{
	
	driver.get(baseURL + "/Catalog/online-spagiftcertificates.htm?type=email");
	
	typeByXpath (gcl.deliveryEmailAddress, gcv.UKemailValue);
	clickByXpath (gcl.PersonalizeItUK);
	typeByXpath (gcl.from, gcv.UKfirstNameValue);
	typeByXpath (gcl.to, gcv.UKlastNameValue);
	clickByXpath (gcl.continueButtonInStep1UK);
	
	clickByXpath (gcl.guestButton);
		
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
		 System.out.println ("Expected: " + expPromoText + " | Actual: " + actPromoText + " = " + asserTion);
				 
	String promoAmount = driver.findElement(By.xpath (gcl.promoDiscountXpath)).getText();
	System.err.println ("Discount Amount is: " + promoAmount);
	System.out.println ("");
			 
// Billing page
	
	dCookieByName (gcl.ukCookiesPolicyCancle);
	typeByXpath (gcl.email, gcv.emaiValue);
	typeByXpath (gcl.FirstName, gcv.UKfirstNameValue);
	typeByXpath (gcl.LastName, gcv.UKlastNameValue);
	dropDownById (gcl.countryBoxId, gcv.UKcountryValue);
	scroll();
	
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
		
// Regular Expression 
	String totalMoney  = driver.findElement(By.xpath(gcl.totalPrice)).getText();
	Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
    Matcher m = p.matcher(totalMoney);
      
    boolean b = m.find();
    if (b)
     {
    	String promoTotal = m.group();
    	System.err.println ("=====================================================================");
       
    boolean PF = driver.findElement(By.xpath(gcl.orderNumber)).isDisplayed();
 	if (PF == false)
 	 {
 		passData ("UK", "passFail", 10, gcv.Fail); // writing the text into excel from selenium
 	} else  { 
 		passData ("UK", "passFail", 10, gcv.Pass); // writing the text into excel from selenium
 		setCellData ("UK", "OrderNumber", 10, gcl.orderNumber); // Writing order number into excel file.
 		System.out.println(getCellData("UK", "OrderNumber", 10)); // reading from excel\

 		passData ("UK", "Total", 10, promoTotal);
 		System.out.println ("Total Price is: " + promoTotal);
 		System.err.println ("=====================================================================");	
 	
 				}			
   		}
    	screenShot ("Promo_UK_IGCGuest");
	 	}
	}
}