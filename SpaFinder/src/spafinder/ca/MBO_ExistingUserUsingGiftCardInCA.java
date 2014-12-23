package spafinder.ca;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import spafinder.com.base.CABaseClass;
import spafinder.com.locator.OnlineBookingLocator;
import spafinder.com.value.OnlineBookingValue;

public class MBO_ExistingUserUsingGiftCardInCA extends CABaseClass {

		OnlineBookingLocator mbol = new OnlineBookingLocator();
		OnlineBookingValue   mbov = new OnlineBookingValue ();
	
	
@Test
public void MBOusingGCinCATest () throws InterruptedException, IOException{
	
		driver.get (baseURL + "/Spa/29816-a#view-services");	
		List <WebElement> allPrice = driver.findElements (By.xpath(mbol.MboPriceLocator));
		System.out.println ("Total Prices are: " + allPrice.size());
		  
		List <WebElement> allButtons = driver.findElements (By.xpath(mbol.MboButtonsLocator));
		System.out.println ("Total Buttons are: " + allButtons.size());
		  
		   for (int i = 0; i<allPrice.size(); i++){
			   if(StringUtils.isNotEmpty(allPrice.get(i).getText())){
				   //System.out.println (allPrice.get(i).getText());
				   // String strPrice = allPrice.get(i).getText().substring(1);
				   String  strPrice = allPrice.get(i).getText().replaceAll("[^\\d.]", "");
				    //System.out.println (strPrice);
				    Integer  price = new Integer(strPrice);
				  
				  //  if (price > 60){  // using gc+cc}
				   if (price >=10 && price <=50){ // using Gift cards
				  System.out.println (strPrice);
				  allButtons.get(i).click();
				  break;
				    }
			   }   
		   }
		
					
		clickByXpath (mbol.OnlineBookingclickHereToLogIn);
		typeByXpath (mbol.OnlineBookingemailAddress, mbov.SpaEmail);
		typeByXpath (mbol.OnlineBookingpassword, mbov.SpaPassword);
		clickByXpath (mbol.OnlineBookinglogin);
					
// Using Gift Card
		
		clickByXpath (mbol.OnlinebookingGiftCardTab);
		//Thread.sleep(3000L);
		typeByXpath (mbol.onlineBookingFirstName, mbov.MBOFNameValue);
		typeByXpath (mbol.onlineBookingLastName, mbov.MBOLNameValue);
		typeByXpath (mbol.onlineBookingEmail, mbov.SpaEmail);
		typeByXpath (mbol.onlineBookingPhoneNumber, mbov.MBOPhoneNumberValue);
		typeByXpath (mbol.OnlinebookingGCNumber, mbov.OnlineBookingGCNumber);
		clickByXpath (mbol.OnlinebookingGCDropDown);
		clickByXpath (mbol.onlineBookingGCValue);
		clickByXpath (mbol.onlineBookingCancellationPolicy);
		clickByXpath (mbol.onlineBookingCompleYourBookingLink);
			
		
		String totalMoney  = driver.findElement(By.xpath(mbol.totalPrice)).getText();
		Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
		Matcher m = p.matcher(totalMoney);
			      
		boolean b = m.find();
		if (b)
			{
			 	String totalAmount = m.group();
		
	    boolean PF = driver.findElement(By.xpath(mbol.orderNumber)).isDisplayed();
		if (!PF)
		   {
			passData ("CA", "passFail", 22, mbov.Fail); // writing the text into excel from selenium
		     } else  { 
		    	 passData ("CA", "passFail", 22, mbov.Pass); // writing the text into excel from selenium
		    	 System.err.println ("=====================================================================");	
		    	 setCellData ("CA", "OrderNumber", 22, mbol.orderNumber); // Writing order number into excel file.
		    	 System.out.println(getCellData("CA", "OrderNumber", 22)); // reading from excel
		    		
		    	 passData ("CA", "Total", 22, totalAmount);
		    	 System.out.println ("Total Amount is: " + totalAmount);
		    	 System.err.println ("=====================================================================");			
		       	}
			}
		screenShot ("CA_MBO_AlreadyMember_usingGC");
		}
	}


	
