package spafinder.co.uk;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import spafinder.com.locator.OnlineBookingLocator;
import spafinder.com.value.OnlineBookingValue;

public class MBOusingGCandCCinUK extends spafinder.com.base.UKBaseClass {

	OnlineBookingLocator mbol = new OnlineBookingLocator();
	OnlineBookingValue   mbov = new OnlineBookingValue ();
	
	
@Test
public void MBOMemberUsingGCAandCCinUK () throws InterruptedException, IOException{
	
		driver.get (baseURL + "/Spa/29816-a#view-services");
		List <WebElement> allPrice = driver.findElements (By.xpath(mbol.MboPriceLocator));
		System.out.println ("Total Prices are: " + allPrice.size());
	  
		List <WebElement> allButtons = driver.findElements (By.xpath(mbol.MboButtonsLocator));
		System.out.println ("Total Buttons are: " + allButtons.size());
	  
		for (int i = 0; i<allPrice.size(); i++){
		if(StringUtils.isNotEmpty(allPrice.get(i).getText())){
				String  strPrice = allPrice.get(i).getText().replaceAll("[^\\d.]", "");
				Integer  price = new Integer(strPrice);
			  
		if (price >=100){ // using Gift cards
			 System.out.println (strPrice);
			 allButtons.get(i).click();
			 break; 
			 }
		   }   
	   }
		
	   clickByXpath (mbol.OnlineBookingclickHereToLogIn);
	   typeByXpath (mbol.OnlineBookingemailAddress, mbov.UKemailValue);
	   typeByXpath (mbol.OnlineBookingpassword, mbov.SpaPassword);
	   clickByXpath (mbol.OnlineBookinglogin);
	   iWait (5);
		
// Using Gift Card
	   	
		clickByXpath (mbol.OnlinebookingGiftCardTab);
		typeByXpath (mbol.onlineBookingFirstName, mbov.MBOFNameValue);
		typeByXpath (mbol.onlineBookingLastName, mbov.MBOLNameValue);
		typeByXpath (mbol.onlineBookingEmail, mbov.UKemailValue);
		typeByXpath (mbol.onlineBookingPhoneNumber, mbov.MBOPhoneNumberValue);
		typeByXpath (mbol.OnlinebookingGCNumber, mbov.OnlineBookingGCNumber);
		clickByXpath (mbol.OnlinebookingGCDropDown);
		clickByXpath (mbol.onlineBookingGCValueUK);
		clickByXpath (mbol.onlineBookingCancellationPolicy);			
		clickByXpath (mbol.onlineBookingCompleYourBookingLink);
		
		String verifyBalanceDue = driver.findElement(By.xpath (".//*[@id='appointment-overview']/ul[1]/li[4]/span")).getText();
		String act = "Balance Due:";
		boolean balanceDue = act.equalsIgnoreCase(verifyBalanceDue);
		if (!balanceDue){
			passData ("UK", "passFail", 24, mbov.Fail); // writing the text into excel from selenium
			screenShot ("GCFailed_UK_MBO_AlreadyMember_using_GC+CC");
		  } else  { 
		    	 		
					
// USING CC Info
		dCookieByName (mbol.ukCookiesPolicyCancle);
		typeByXpath (mbol.onlineBookingFirstName, mbov.MBOFNameValue);
		typeByXpath (mbol.onlineBookingLastName, mbov.MBOLNameValue);
		typeByXpath (mbol.onlineBookingEmail, mbov.UKemailValue);
		
		driver.findElement(By.linkText("United Kingdom")).click();
		driver.findElement(By.xpath("//li[4]/div/ul/li")).click();
		new Select(driver.findElement(By.id("card-country"))).selectByVisibleText("United States");
		
		typeByXpath (mbol.onlineBookingStreetAddress, mbov.MBOStreetAddressValue);
		typeByXpath (mbol.onlineBookingCity, mbov.MBOCityValue);
		typeByXpath (mbol.onlineBookingZipCode, mbov.MBOZipCodeValue);
		scroll();

		driver.findElement(By.xpath("//li[@id='card-state-container']/div/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[8]/div/ul/li[34]")).click();
		new Select(driver.findElement(By.id("card-state"))).selectByVisibleText("New York");
	
		typeByXpath (mbol.onlineBookingPhoneNumber, mbov.MBOPhoneNumberValue);
		typeByXpath (mbol.onlineBookingCardNumber, mbov.MBOCardNumberValue);
		typeByXpath (mbol.onlineBookingSecurityCode, mbov.MBOSecurityCodeValue);
		typeByXpath (mbol.OnlineBookingExpMM, mbov.MBOExpirationMonthValue);
		typeByXpath (mbol.OnlineBookingExpYY, mbov.MBOExpirationYearValue);
		clickByXpath (mbol.onlineBookingCompleYourBookingLink);
		
		String totalMoney  = driver.findElement(By.xpath(mbol.totalPrice)).getText();
		Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
		Matcher m = p.matcher(totalMoney);
		      
		boolean b = m.find();
		if (b)
		  	{
		  		String totalAmount = m.group();
		    		  
		boolean PF = driver.findElement(By.xpath(mbol.orderNumber)).isDisplayed();
		if (PF == false)
		   {  
			passData ("UK", "passFail", 24, mbov.Fail); // writing the text into excel from selenium
		     } else  { 
		    	 passData ("UK", "passFail", 24, mbov.Pass); // writing the text into excel from selenium
		    	 System.err.println ("=====================================================================");	
		    	 setCellData ("UK", "OrderNumber", 24, mbol.orderNumber); // Writing order number into excel file.
		    	 System.out.println(getCellData("UK", "OrderNumber", 24)); // reading from excel
		    		
		    	 passData ("UK", "Total", 24, totalAmount);
		    	 System.out.println ("Total Amount is: " + totalAmount);
		    	 System.err.println ("=====================================================================");			
		     	}
		screenShot ("UK_MBO_AlreadyMember_using_GC+CC");
		    }
		}
	}
}