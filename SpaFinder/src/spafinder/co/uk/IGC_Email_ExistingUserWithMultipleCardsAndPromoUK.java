package spafinder.co.uk;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import spafinder.com.locator.IGC_Locator;
import spafinder.com.value.IGC_Values;

public class IGC_Email_ExistingUserWithMultipleCardsAndPromoUK extends spafinder.com.base.UKBaseClass  {

	IGC_Locator gcl = new IGC_Locator ();
	IGC_Values  gcv = new IGC_Values ();
	
		
@Test
public void IGC_Email_UserWithMultipleCardsAndPromoUK() throws InterruptedException, IOException{
	
	driver.get(baseURL + "/Catalog/online-spagiftcertificates.htm?type=email");
	
	driver.findElement(By.cssSelector("a.current")).click();
	driver.findElement(By.xpath("//div[2]/ul/li")).click();
	new Select(driver.findElement(By.id("instantGCInfoList[0].amount"))).selectByVisibleText("25");
	typeByXpath (gcl.deliveryEmailAddress, gcv.UKemailValue);
	clickByXpath (gcl.PersonalizeItUK);
	typeByXpath (gcl.from, gcv.UKfirstNameValue);
	typeByXpath (gcl.to, gcv.UKlastNameValue);
	typeByXpath (gcl.messgeBox, "UK IGC Email User Already Signed In using Saved Card 1 - By Automation");
	clickByLink (gcl.addAnotherVoucherLink);
	
// Adding Card II
	scroll();
	clickByXpath (gcl.theme2);
	typeByXpath (gcl.deliveryEmailAddress2, gcv.UKemailValue);
	clickByXpath (gcl.PersonalizeItUK2);
	typeByXpath (gcl.from2, "Sayan");
	typeByXpath (gcl.to2, "Bhuiyan");
	typeByXpath (gcl.messgeBox2, "UK IGC Email Automation IGC USER - CARD 2 & Promo");
	clickByXpath (gcl.ProceedToCheckout2);
	
	clickByXpath (gcl.alreadyMemberLoginLink);
	typeByXpath (gcl.emailMember, gcv.UKemailValue);
	typeByXpath (gcl.PasswordMember, gcv.passwordValue);
	clickByXpath (gcl.signInCheckoutButton);
	
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
  
	setCellData ("UK", "OrderNumber", 6, gcl.orderNumber); // Writing order number into excel file.
	System.out.println(getCellData("UK", "OrderNumber", 6)); // reading from excel
	
	passData ("UK", "Total", 6, totalAmount);
	System.out.println ("Total Price is: " + totalAmount);
	passData ("UK", "passFail", 6, gcv.Pass); // writing the text into excel from selenium
	System.err.println ("=====================================================================");
		}
    screenShot ("UK_IGC_eMailExistingUser_WithMultipleCardsAndPromo");
	
// Verifying GC Number from BackOffice

	driver.get(baseURL+"/admin");
	typeByXpath (gcl.adminUserName, gcv.adminUserValue);
	typeByXpath (gcl.adminUserPass, gcv.passwordValue);
	clickByXpath (gcl.adminSubmitButton);
	driver.get(baseURL+"/BackOff/view.do?value(orderId)="+orderNo);
    screenShot ("BackOffice_UK_IGC_eMailExistingUser_WithMultipleCardsAndPromo");
	
	String gc1 = driver.findElement(By.xpath(gcl.gcNumber)).getText();
	String gc2 = driver.findElement(By.xpath(gcl.gcNumber2)).getText();
	System.out.println ("Your 1st GC/Voucher Number is: "+ gc1);
	System.out.println ("Your 2nd GC/Voucher Number is: "+ gc2);
	passData ("UK", "GC_Number", 6, gc1); // CARD 1
	passData ("UK", "GC_Number2", 6, gc2); // CARD 1
	
	// Face value 1
	String gcAmount  = driver.findElement(By.xpath(gcl.gcValue)).getText();
	p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
	m = p.matcher(gcAmount);
	b = m.find();
	if (b)
	{
		String gcTotal = m.group();
	System.out.println ("Your 1st GC/Voucher Total amount is: " + gcTotal);
	passData ("UK", "GC_Total", 6, gcTotal); // CARD 1
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
	passData ("UK", "GC_Total2", 6, gcTotal2); // CARD 2
	 			}
			}
		}
	}
	
		
		
		
