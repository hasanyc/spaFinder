package spafinder.ca;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import spafinder.com.locator.IGC_Locator;
import spafinder.com.value.IGC_Values;


public class IGC_ExistingUserInCA extends spafinder.com.base.CABaseClass {
	IGC_Locator gcl = new IGC_Locator ();
	IGC_Values  gcv = new IGC_Values ();
		
@Test
public void IGCExistingUserInCA () throws InterruptedException, IOException{
	
	driver.get(baseURL + "/Catalog/online-spagiftcertificates.htm?type=email");
	
	typeByXpath (gcl.deliveryEmailAddress, gcv.emaiValue);	clickByXpath (gcl.PersonalizeIt);
	typeByXpath (gcl.from, gcv.firstNameValue);
	typeByXpath (gcl.to, gcv.lastNameValue);
	clickByXpath (gcl.ProceedToCheckout);
	
	clickByXpath (gcl.alreadyMemberLoginLink);
	typeByXpath (gcl.emailMember, gcv.emaiValue);
	typeByXpath (gcl.PasswordMember, gcv.passwordValue);
	clickByXpath (gcl.signInCheckoutButton);
	
// Billing page
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
	typeByXpath (gcl.securityCode, gcv.securityCodeValue);
	typeByXpath (gcl.expMM, gcv.ExpMMvalue);
	typeByXpath (gcl.expYY, gcv.ExpYYvalue);
	clickByXpath (gcl.CompleteYourOderButton);
			
	String totalMoney  = driver.findElement(By.xpath(gcl.totalPrice)).getText();
	Pattern p = Pattern.compile(".[0-9]{2,11}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
    Matcher m = p.matcher(totalMoney);
      
    boolean b = m.find();
    if (b)
    {
    	String totalAmount = m.group();
    	System.err.println ("=====================================================================");	
 
   	boolean PF = driver.findElement(By.xpath(gcl.orderNumber)).isDisplayed();
	if (PF == false)
	 {
		passData ("CA", "passFail", 3, gcv.Fail); // writing the text into excel from selenium
	 } else  { 
		passData ("CA", "passFail", 3, gcv.Pass); // writing the text into excel from selenium
		setCellData ("CA", "OrderNumber", 3, gcl.orderNumber); // Writing CA number into excel file.
		System.out.println(getCellData("CA", "OrderNumber", 3)); // reading from excel
		
		passData ("CA", "Total", 3, totalAmount);
		System.out.println ("Total Amount is: " + totalAmount);
		System.err.println ("=====================================================================");		
		}
    	screenShot ("CA_IGCMember");
		}
			
	}
}


