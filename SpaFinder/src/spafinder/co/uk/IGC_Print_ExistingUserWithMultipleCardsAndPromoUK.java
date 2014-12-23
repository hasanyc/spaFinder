package spafinder.co.uk;

import java.io.IOException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import spafinder.com.locator.IGC_Locator;
import spafinder.com.value.IGC_Values;

public class IGC_Print_ExistingUserWithMultipleCardsAndPromoUK extends spafinder.com.base.UKBaseClass  {

	IGC_Locator gcl = new IGC_Locator ();
	IGC_Values  gcv = new IGC_Values ();
	
		
@Test
public void IGC_Print_UserWithMultipleCardsAndPromo () throws InterruptedException, IOException{
	
	driver.get(baseURL + "/Catalog/online-spagiftcertificates.htm?type=print");
	clickByXpath (gcl.PersonalizeIt);
	scroll();
	typeByXpath (gcl.from, gcv.UKfirstNameValue);
	typeByXpath (gcl.to, gcv.UKlastNameValue);
	typeByXpath (gcl.messgeBox, "UK IGC Print User with Multiple Cards and Promo - By Automation");
	clickByLink (gcl.addAnotherVoucherLink);

// Adding Card II
	scroll();
	clickByXpath (gcl.theme2);
	clickByXpath (gcl.PersonalizeIt2);
	typeByXpath (gcl.from2, "Ashique");
	typeByXpath (gcl.to2, "Sage");
	typeByXpath (gcl.messgeBox2, "UK IGC Print Automation IGC USER - CARD 2");
	clickByXpath (gcl.ProceedToCheckout2);

	
	clickByXpath (gcl.alreadyMemberLoginLink);
	typeByXpath (gcl.emailMember, gcv.UKemailValue);
	typeByXpath (gcl.PasswordMember, gcv.passwordValue);
	clickByXpath (gcl.signInCheckoutButton);
	
// Entering PromoCode
	scroll ();
	typeById (gcl.promoEditBoxId, gcv.promoValue);
	clickById (gcl.promoApplyButtonId);
	Thread.sleep(1000);
			 
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
	
// Billing Info
	dCookieByName (gcl.ukCookiesPolicyCancle);
	
	typeByXpath (gcl.FirstName, gcv.UKfirstNameValue);
	typeByXpath (gcl.LastName, gcv.UKlastNameValue);
	dropDownById (gcl.countryBoxId, gcv.UKcountryValue);
	
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
    	String totalAmount = m.group();
    	System.err.println ("=====================================================================");		
  
	setCellData ("UK", "OrderNumber", 31, gcl.orderNumber); // Writing order number into excel file.
	System.out.println(getCellData("UK", "OrderNumber", 31)); // reading from excel
	
	passData ("UK", "Total", 31, totalAmount);
	System.out.println ("Total Price is: " + totalAmount);
	passData ("UK", "passFail", 31, gcv.Pass); // writing the text into excel from selenium
	System.err.println ("=====================================================================");

	screenShot ("UK_IGC_UserPrintUsingMultipleCardAndPromo");		 // screenshot from confirmation Page
	System.out.println ();
 	clickByXpath (gcl.print_PrintCardButton);
 	
//Switching to the new tab
 	
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
   }

    System.out.println();
    screenShot ("UK_IGC_UserPrintUsingMultipleCardAndPromoPREVIEW");  // New Tab

// Verifying GC Number from BackOffice
	driver.get(baseURL+"/admin");
	typeByXpath (gcl.adminUserName, gcv.adminUserValue);
	typeByXpath (gcl.adminUserPass, gcv.passwordValue);
	clickByXpath (gcl.adminSubmitButton);
	driver.get(baseURL+"/BackOff/view.do?value(orderId)="+orderNo);
	screenShot ("BackOffice_UK_IGC.Print.USER_WithMultipleNpromo");
	
	String gc1 = driver.findElement(By.xpath(gcl.gcNumber)).getText();
	String gc2 = driver.findElement(By.xpath(gcl.gcNumber2)).getText();
	System.out.println ("Your 1st GC/Voucher Number is: "+ gc1);
	System.out.println ("Your 2nd GC/Voucher Number is: "+ gc2);
	passData ("UK", "GC_Number", 31, gc1); // CARD 1
	passData ("UK", "GC_Number2", 31, gc2); // CARD 1
	
	// Face value 1
	String gcAmount  = driver.findElement(By.xpath(gcl.gcValue)).getText();
	p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
	m = p.matcher(gcAmount);
	b = m.find();
	if (b)
	{
		String gcTotal = m.group();
	System.out.println ("Your 1st GC/Voucher Total amount is: " + gcTotal);
	passData ("UK", "GC_Total", 31, gcTotal); // CARD 1
	}
	
	// Face value 2
	String gcAmount2 = driver.findElement(By.xpath(gcl.gcValue2)).getText();
	p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
	m = p.matcher(gcAmount2);
	b = m.find();
	if (b)
	{
		String gcTotal2 = m.group();
	System.out.println ("Your 2st GC/Voucher Total amount is: " + gcTotal2);
	passData ("UK", "GC_Total2", 31, gcTotal2); // CARD 2
		 	}
		}
	}
}

		
		
		


			



