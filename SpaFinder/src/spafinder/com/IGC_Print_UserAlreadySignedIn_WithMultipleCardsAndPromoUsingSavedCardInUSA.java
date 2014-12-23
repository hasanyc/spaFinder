package spafinder.com;

import java.io.IOException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import spafinder.com.locator.IGC_Locator;
import spafinder.com.value.IGC_Values;

public class IGC_Print_UserAlreadySignedIn_WithMultipleCardsAndPromoUsingSavedCardInUSA extends spafinder.com.base.USABaseClass {

	IGC_Locator gcl = new IGC_Locator ();
	IGC_Values  gcv = new IGC_Values ();
	
@Test
public void IGC_Print_UserAlreadySignedInWithMultipleCardsAndPromoUsingSavedCardInUSA () throws InterruptedException, IOException{
	
	
		driver.get(baseURL);
		clickByXpath (gcl.MyAccountLink); // From global Header
		typeByXpath (gcl.logInEmail, gcv.emaiValue);
		typeByXpath (gcl.logInPassword, gcv.passwordValue);
		clickByXpath (gcl.logInClickButton);
	
		driver.get(baseURL+"/Catalog/online-spagiftcertificates.htm?type=print");
		
// Card 1
		driver.findElement(By.cssSelector("a.current")).click();
		driver.findElement(By.xpath("//div[2]/ul/li")).click();
		new Select(driver.findElement(By.id("instantGCInfoList[0].amount"))).selectByVisibleText("$ 25");
		clickByXpath (gcl.theme);
		clickByXpath (gcl.Print_PersonalizeIt);
		typeByXpath (gcl.from, gcv.firstNameValue);
		typeByXpath (gcl.to, gcv.lastNameValue);
		typeByXpath (gcl.messgeBox, "USA IGC Print User Already Signed In using Saved Card 1 - By Automation");
		clickByLink (gcl.addAnotherCardLink);

// Adding Card II
		scroll();
		clickByXpath (gcl.theme2);
		clickByXpath (gcl.Print_PersonalizeIt2);
		typeByXpath (gcl.from2, "Ashique");
		typeByXpath (gcl.to2, "Sage");
		typeByXpath (gcl.messgeBox2, "USA IGC USER Print - CARD 2 & Promo");
		clickByXpath (gcl.ProceedToCheckout2);
			
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
			
// Billing Information page
		typeByXpath (gcl.securityCodeMember, gcv.securityCodeValue);
		clickByXpath (gcl.CompleteYourOderButton);
			
		String orderNumber = driver.findElement (By.xpath(gcl.orderNumber)).getText();
		String orderNo		= orderNumber.replaceAll("[^\\d.]", "");
		
		String totalMoney  = driver.findElement(By.xpath(gcl.totalPrice)).getText();
		Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
	    Matcher m = p.matcher(totalMoney);
	     
	    boolean b = m.find();
	    if (b)
	    {
	    	String total = m.group();
	    	System.err.println ("=====================================================================");
	    
	    
	   boolean PF = driver.findElements(By.xpath(gcl.orderNumber)).size() != 0;
		if (PF == false)
		 {
			passData ("USA", "passFail", 32, gcv.Fail); // writing the text into excel from selenium
		 } else  { 
			passData ("USA", "passFail", 32, gcv.Pass); // writing the text into excel from selenium
			setCellData ("USA", "OrderNumber", 32, gcl.orderNumber); // Writing order number into excel file.
			System.out.println(getCellData("USA", "OrderNumber", 32)); // reading from excel\

			passData ("USA", "Total", 32, total);
			System.out.println ("Total Price is: " + total);
			System.err.println ("=====================================================================");	
			
			screenShot ("USA_IGC_Print.UserAlreadySignedInWithMultipleCardAndPromoUsingSavedCardConfirmation");		 // screenshot from confirmation Page
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
	  
		screenShot ("USA_IGC_Print.UserAlreadySignedInWithMultipleCardAndPromoUsingSavedCardPREVIEW");  // New Tab
	    }
		
// Verifying GC Number from BackOffice
		driver.get(baseURL+"/admin");
		typeByXpath (gcl.adminUserName, gcv.adminUserValue);
		typeByXpath (gcl.adminUserPass, gcv.passwordValue);
		clickByXpath (gcl.adminSubmitButton);
		driver.get(baseURL+"/BackOff/view.do?value(orderId)="+orderNo);
		screenShot ("BackOffice_USA_IGC.Print.USER_WithMultipleNpromo");
		
		String gc1 = driver.findElement(By.xpath(gcl.gcNumber)).getText();
		String gc2 = driver.findElement(By.xpath(gcl.gcNumber2)).getText();
		System.out.println ("Your 1st GC/Voucher Number is: "+ gc1);
		System.out.println ("Your 2nd GC/Voucher Number is: "+ gc2);
		passData ("USA", "GC_Number", 32, gc1); // CARD 1
		passData ("USA", "GC_Number2", 32, gc2); // CARD 1
		
		// Face value 1
		String gcAmount  = driver.findElement(By.xpath(gcl.gcValue)).getText();
		p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
		m = p.matcher(gcAmount);
		b = m.find();
		if (b)
		{
			String gcTotal = m.group();
		System.out.println ("Your 1st GC/Voucher Total amount is: " + gcTotal);
		passData ("USA", "GC_Total", 32, gcTotal); // CARD 1
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
		passData ("USA", "GC_Total2", 32, gcTotal2); // CARD 2
		 				}
					}
				}
			}
}
}
		
		
		


		
		