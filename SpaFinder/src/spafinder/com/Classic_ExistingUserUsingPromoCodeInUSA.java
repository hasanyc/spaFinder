package spafinder.com;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import spafinder.com.locator.Classic_Locator;
import spafinder.com.value.Classic_Values;


public class Classic_ExistingUserUsingPromoCodeInUSA extends spafinder.com.base.USABaseClass{

	Classic_Locator cl = new Classic_Locator ();
	Classic_Values  cv = new Classic_Values  ();
	
@Test (enabled = true)
public void ClassicExsitingUserApplyingPromoUsingNewCardinUSA () throws InterruptedException, IOException{
	
	driver.get(baseURL);
	
	clickByXpath (cl.MyAccountLink); // From global Header
	typeByXpath (cl.logInEmail, cv.emailWithNoSavedCard);
	typeByXpath (cl.logInPassword, cv.passwordValue);
	clickByXpath (cl.logInClickButton);
	
	driver.get(baseURL +"/Catalog/mail-spagiftcertificates.jsp");
	System.out.println("The Home Page Title is: " + driver.getTitle());
	clickByXpath (cl.addToCart_ButtonUSA);
	
	clickByXpath (cl.writePersonalNote);
	typeByXpath (cl.recipientName, cv.firstNameValue);
	typeByXpath (cl.senderName, cv.lastNameValue);
	typeByXpath (cl.personalMessage, "Classic - ExistingUserApplying Promo Code using New CC");
	
//Apply Promo Code

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
		 
	String promoAmount = driver.findElement(By.xpath (cl.promoDiscountXpath)).getText();
	System.err.println ("Discount Amount is: " + promoAmount);
	System.out.println ("");
	
	clickByXpath (cl.personalize_Button);
	
//Shipping Page
	
	typeByXpath (cl.firstName, cv.firstNameValue);
	typeByXpath (cl.lastName, cv.lastNameValue);
	dropDownById (cl.countryByID, cv.CountryValue);
	typeByXpath (cl.Address, cv.AddressValue);
	typeByXpath (cl.city, cv.CityValue);
	typeByXpath (cl.zipCode, cv.ZipcodeValue);
	dropDownById (cl.StateByID, cv.StateValue);
	clickByXpath (cl.billingInfo_Button); // step 3: Billing Info Button
			
//Billing Page
	clickByXpath (cl.billingAsShipping);
	typeByXpath (cl.email, cv.emaiValue);
	clickByXpath (cl.stateInBllingPage);
	clickByXpath (cl.stateNYinBillingPage);
	typeByXpath (cl.phoneNumber, cv.PhoneNumberValue);
	typeByXpath (cl.cardNumber, cv.CardNoValue);
	//typeByXpath (cl.cardNumber, cv.AmexCard);
	typeByXpath (cl.sercurityCodes, cv.securityCodeValue);
	typeByXpath (cl.expMM, cv.ExpMMvalue);
	typeByXpath (cl.expYY, cv.ExpYYvalue);
	clickByCss (cl.unCheckBox);
	clickByXpath (cl.checkOutButton);
		
	boolean PF = driver.findElements(By.xpath(cl.orderNumber)).size() != 0;
	if (!PF)
	 {
		passData ("USA", "passFail", 15, cv.Fail); // writing the text into excel from selenium
	
	} else {
		String totalMoney  = driver.findElement(By.xpath(cl.totalPrice)).getText();
		Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
		Matcher m = p.matcher(totalMoney);
	 
	boolean b = m.find();
	if (b)
	{
		String total = m.group();
		System.err.println ("=====================================================================");
	   
		passData ("USA", "passFail", 15,cv.Pass); // writing the text into excel from selenium
		setCellData ("USA", "OrderNumber", 15, cl.orderNumber); // Writing USA number into excel file.
		System.out.println(getCellData("USA", "OrderNumber", 15)); // reading from excel\
	
		passData ("USA", "Total", 15, total);
		System.out.println ("Total Price is: " + total);
		 
		System.err.println ("=====================================================================");	
		
	    	}
	    }
					
		}
	screenShot ("Promo_ClassicMemberUsingNewCard");
		
	}
}