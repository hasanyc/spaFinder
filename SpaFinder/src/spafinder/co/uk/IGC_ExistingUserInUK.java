package spafinder.co.uk;


import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import spafinder.com.locator.IGC_Locator;
import spafinder.com.value.IGC_Values;


public class IGC_ExistingUserInUK extends spafinder.com.base.UKBaseClass  {

	IGC_Locator gcl = new IGC_Locator ();
	IGC_Values  gcv = new IGC_Values ();
	
		
@Test
public void IGC_Email_ExistingUserInUK () throws InterruptedException, IOException{
	
	driver.get(baseURL + "/Catalog/online-spagiftcertificates.htm?type=email");
	typeByXpath (gcl.deliveryEmailAddress, gcv.UKemailValue);
	clickByXpath (gcl.PersonalizeItUK);
	typeByXpath (gcl.from, gcv.UKfirstNameValue);
	typeByXpath (gcl.to, gcv.UKlastNameValue);
	clickByXpath (gcl.continueButtonInStep1UK);
	
	clickByXpath (gcl.alreadyMemberLoginLink);
	typeByXpath (gcl.emailMember, gcv.UKemailValue);
	typeByXpath (gcl.PasswordMember, gcv.passwordValue);
	clickByXpath (gcl.signInCheckoutButton);
	
// Billing Info
	dCookieByName (gcl.ukCookiesPolicyCancle);
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

	String totalMoney  = driver.findElement(By.xpath(gcl.totalPrice)).getText();
	Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
    Matcher m = p.matcher(totalMoney);
      
    boolean b = m.find();
    if (b)
    {
    	String totalAmount = m.group();
    	System.err.println ("=====================================================================");		
  
	setCellData ("UK", "OrderNumber", 3, gcl.orderNumber); // Writing order number into excel file.
	System.out.println(getCellData("UK", "OrderNumber", 3)); // reading from excel
	
	passData ("UK", "Total", 3, totalAmount);
	System.out.println ("Total Price is: " + totalAmount);
	passData ("UK", "passFail", 3, gcv.Pass); // writing the text into excel from selenium
	System.err.println ("=====================================================================");
		}
    screenShot ("UK_IGCMember");
	}
}
