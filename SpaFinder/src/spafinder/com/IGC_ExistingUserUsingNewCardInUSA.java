package spafinder.com;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import spafinder.com.locator.IGC_Locator;
import spafinder.com.value.IGC_Values;

public class IGC_ExistingUserUsingNewCardInUSA extends spafinder.com.base.USABaseClass{
	IGC_Locator gcl = new IGC_Locator ();
	IGC_Values  gcv = new IGC_Values ();
	
@Test
public void IGC_EmailAlradyMemberUsingNewCardinUSA () throws InterruptedException, IOException{
	
	driver.get(baseURL+"/Catalog/online-spagiftcertificates.htm?type=email");
	
	typeByXpath (gcl.deliveryEmailAddress, gcv.emailWithNoSavedCard); // qa.test@hotmail.com
	clickByXpath (gcl.PersonalizeIt);
	typeByXpath (gcl.from, gcv.firstNameValue);
	typeByXpath (gcl.to, gcv.lastNameValue);
	clickByXpath (gcl.ProceedToCheckout);
	
	clickByXpath (gcl.alreadyMemberLoginLink);
	typeByXpath (gcl.emailMember, gcv.emailWithNoSavedCard);
	typeByXpath (gcl.PasswordMember, gcv.passwordValue);
	clickByXpath (gcl.signInCheckoutButton);
	
	
// Billing and Shipping
	
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
	
	String totalMoney  = driver.findElement(By.xpath(gcl.totalPrice)).getText();
	Pattern p = Pattern.compile(".[0-9]{2,4}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
    Matcher m = p.matcher(totalMoney);
     
    boolean b = m.find();
    if (b)
    {
    	String total = m.group();
    	System.err.println ("=====================================================================");
       
   boolean PF = driver.findElements(By.xpath(gcl.orderNumber)).size() != 0;
	if (!PF)
	 {
		passData ("USA", "passFail", 4, gcv.Fail); // writing the text into excel from selenium
	 } else  { 
		 passData ("USA", "passFail", 4,gcv.Pass); // writing the text into excel from selenium
		 setCellData ("USA", "OrderNumber", 4, gcl.orderNumber); // Writing order number into excel file.
		 System.out.println(getCellData("USA", "OrderNumber", 4)); // reading from excel\

		 passData ("USA", "Total", 4, total);
		 System.out.println ("Total Price is: " + total);
		 System.err.println ("=====================================================================");	
	 		}
       	}
	screenShot ("USA_IGCMemberUsingNewCC");
	}


}
