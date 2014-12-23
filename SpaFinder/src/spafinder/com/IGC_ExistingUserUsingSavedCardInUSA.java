package spafinder.com;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import spafinder.com.locator.IGC_Locator;
import spafinder.com.value.IGC_Values;


public class IGC_ExistingUserUsingSavedCardInUSA extends spafinder.com.base.USABaseClass{
	IGC_Locator gcl = new IGC_Locator ();
	IGC_Values  gcv = new IGC_Values ();
	
@Test
public void IGCAlradyMemberUsingSaveCardInUSATest () throws InterruptedException, IOException{
	
	driver.get(baseURL+"/Catalog/online-spagiftcertificates.htm?type=email");
		
	typeByXpath (gcl.deliveryEmailAddress, gcv.emaiValue);
	clickByXpath (gcl.PersonalizeIt);
	typeByXpath (gcl.from, gcv.firstNameValue);
	typeByXpath (gcl.to, gcv.lastNameValue);
	clickByXpath (gcl.ProceedToCheckout);
	
	clickByXpath (gcl.alreadyMemberLoginLink);
	typeByXpath (gcl.emailMember, gcv.emaiValue);
	typeByXpath (gcl.PasswordMember, gcv.passwordValue);
	clickByXpath (gcl.signInCheckoutButton);
	
// Billing Page
	typeByXpath (gcl.securityCodeMember, gcv.securityCodeValue);
	clickByXpath (gcl.CompleteYourOderButton);
	
	String totalMoney  = driver.findElement(By.xpath(gcl.totalPrice)).getText();
	Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
    Matcher m = p.matcher(totalMoney);
     
    boolean b = m.find();
    if (b)
    {
    	String total = m.group();
    	System.err.println ("=====================================================================");
       
   boolean PF = driver.findElement(By.xpath(gcl.orderNumber)).isDisplayed();
	if (!PF)
	 {
		passData ("USA", "passFail", 3, gcv.Fail); // writing the text into excel from selenium
	 } else  { 
		 passData ("USA", "passFail", 3,gcv.Pass); // writing the text into excel from selenium
		 setCellData ("USA", "OrderNumber", 3, gcl.orderNumber); // Writing order number into excel file.
		 System.out.println(getCellData("USA", "OrderNumber", 3)); // reading from excel\

		 passData ("USA", "Total", 3, total);
		 System.out.println ("Total Price is: " + total);
		 System.err.println ("=====================================================================");	
	 		}
    	screenShot ("USA_IGCMember");

    	}
	}

}
