package spafinder.ca;

import java.io.IOException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import spafinder.com.locator.IGC_Locator;
import spafinder.com.value.IGC_Values;

public class IGC_Print_UserWithMultipleCardsAndPromoInCA extends spafinder.com.base.CABaseClass {
	IGC_Locator gcl = new IGC_Locator ();
	IGC_Values  gcv = new IGC_Values ();
		
@Test
public void IGC_Print_UserWithMultipleCardsAndPromo_inCA () throws InterruptedException, IOException{
	
			driver.get(baseURL + "/Catalog/online-spagiftcertificates.htm?type=print");
// Card 1
			clickByXpath (gcl.theme);
			clickByXpath (gcl.Print_PersonalizeIt);
			typeByXpath (gcl.from, gcv.firstNameValue);
			typeByXpath (gcl.to, gcv.lastNameValue);
			typeByXpath (gcl.messgeBox, "CA IGC Print User Already Signed In using Saved Card 1 - By Automation");
			clickByLink (gcl.addAnotherCardLink);

// Adding Card II
			scroll();
			clickByXpath (gcl.theme2);
			clickByXpath (gcl.Print_PersonalizeIt2);
			typeByXpath (gcl.from2, "Hasan");
			typeByXpath (gcl.to2, "Sayan");
			typeByXpath (gcl.messgeBox2, "CA IGC USER Print - CARD 2 & Promo");
			clickByXpath (gcl.ProceedToCheckout2);
			
			clickByXpath (gcl.alreadyMemberLoginLink);
			typeByXpath (gcl.emailMember, gcv.emaiValue);
			typeByXpath (gcl.PasswordMember, gcv.passwordValue);
			clickByXpath (gcl.signInCheckoutButton);
				
// Verify If card2 is present
			
			String actCard2 = driver.findElement(By.xpath(gcl.assertCard2)).getText();
			String expCard2 = "CARD 2";
			
			boolean verifyCard2 	 = expCard2.equals(actCard2);
			if (!verifyCard2) 
			{
				 System.err.println ("Expected: " + expCard2 + " | Actual: " + actCard2 + " = " + verifyCard2);
			} else  { 
				System.out.println ("Expected: " + expCard2 + "  | Actual: " + actCard2 + " = " + verifyCard2);
			
			
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
				System.out.println ("Expected: " + expPromoText + "  | Actual: " + actPromoText + " = " + asserTion);
				 
			String promoAmount = driver.findElement(By.xpath (gcl.promoDiscountXpath)).getText();
			System.err.println ("Discount Amount is: " + promoAmount);
			System.out.println ("");	
			scroll();
	

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
			
			String orderNumber = driver.findElement (By.xpath(gcl.orderNumber)).getText();
			String orderNo		= orderNumber.replaceAll("[^\\d.]", "");
					
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
				passData ("CA", "passFail", 6, gcv.Fail); // writing the text into excel from selenium
			 } else  { 
				passData ("CA", "passFail", 6, gcv.Pass); // writing the text into excel from selenium
				setCellData ("CA", "OrderNumber", 6, gcl.orderNumber); // Writing CA number into excel file.
				System.out.println(getCellData("CA", "OrderNumber", 6)); // reading from excel
				
				passData ("CA", "Total", 6, totalAmount);
				System.out.println ("Total Amount is: " + totalAmount);
				System.err.println ("=====================================================================");	
				screenShot ("CA_IGC.Print.UserWithMultipleCardsAndPromo");
				System.out.println ();
			 	clickByXpath (gcl.print_PrintCardButton);
			 	
// Switching to the new tab
			 	
			 	Set<String> handles = driver.getWindowHandles();
				String current = driver.getWindowHandle();
				handles.remove(current);
				String newTab = handles.iterator().next();
				driver.switchTo().window(newTab);
				Thread.sleep(1000);
				
				String actNewTabText = driver.findElement(By.xpath(gcl.print_VerifyNewTabText)).getText();
				String expNewTabText = "eGift Card Information";
				boolean assertNewTab = expNewTabText.equals(actNewTabText);
				if (!assertNewTab)
				 {
					 System.err.println ("Expected: " + expNewTabText + " | Actual: " + actNewTabText + " = " + assertNewTab);
				 } else  { 
					 System.out.println ("Expected: " + expNewTabText + " | Actual: " + actNewTabText + " = " + assertNewTab);
				 	}
			   }
		    System.out.println();
			screenShot ("USA_IGC_Print.UserAlreadySignedInWithMultipleCardAndPromoUsingSavedCardPREVIEW");  // New Tab
		    }

// Verifying GC Number from BackOffice

			driver.get(baseURL+"/admin");
			typeByXpath (gcl.adminUserName, gcv.adminUserValue);
			typeByXpath (gcl.adminUserPass, gcv.passwordValue);
			clickByXpath (gcl.adminSubmitButton);
			driver.get(baseURL+"/BackOff/view.do?value(orderId)="+orderNo);
			screenShot ("BackOffice_CA_IGC.Print.USER_WithMultipleNpromo");
			
			String gc1 = driver.findElement(By.xpath(gcl.gcNumber)).getText();
			String gc2 = driver.findElement(By.xpath(gcl.gcNumber2)).getText();
			System.out.println ("Your 1st GC/Voucher Number is: "+ gc1);
			System.out.println ("Your 2nd GC/Voucher Number is: "+ gc2);
			passData ("CA", "GC_Number", 6, gc1); // CARD 1
			passData ("CA", "GC_Number2", 6, gc2); // CARD 1
			
			// Face value 1
			String gcAmount  = driver.findElement(By.xpath(gcl.gcValue)).getText();
			p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
			m = p.matcher(gcAmount);
			b = m.find();
			if (b)
			{
				String gcTotal = m.group();
			System.out.println ("Your 1st GC/Voucher Total amount is: " + gcTotal);
			passData ("CA", "GC_Total", 6, gcTotal); // CARD 1
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
			passData ("CA", "GC_Total2", 6, gcTotal2); // CARD 2
			 		
					}
				}
			}
		}
	}	
	