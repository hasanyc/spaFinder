package spafinder.co.uk;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import spafinder.com.locator.OnlineBookingLocator;
import spafinder.com.value.OnlineBookingValue;

public class G1usingGCinUK  extends spafinder.com.base.UKBaseClass {

	OnlineBookingLocator gl = new OnlineBookingLocator();
	OnlineBookingValue   gv = new OnlineBookingValue ();
	
@Test
public void G1AlreadyMemberUsingGC_UK () throws InterruptedException, IOException{
	
	driver.get (baseURL+"/Spa/424-Allure-Day-Spa-and-Hair-Design#services");
	
		List <WebElement> allPrice = driver.findElements (By.xpath(gl.gOnePriceLocator));
		System.out.println ("Total Prices are: " + allPrice.size());
	  
		List <WebElement> allButtons = driver.findElements (By.xpath(gl.gOneButtonsLocator));
		System.out.println ("Total Buttons are: " + allButtons.size());
	  
		for (int i = 0; i<allPrice.size(); i++){
		   if(StringUtils.isNotEmpty(allPrice.get(i).getText())){
			   //System.out.println (allPrice.get(i).getText());
			   String  strPrice = allPrice.get(i).getText().replaceAll("[^\\d.]", "");
			   Integer  price = new Integer(strPrice);
			if (price >=1 && price <=50){ // using Gift cards
			System.out.println (strPrice);
			allButtons.get(i).click();
			break;
					}
		   		}   
			}
	
		boolean hoursExists = driver.findElements( By.xpath(gl.hoursLink)).size() != 0;
		int count = 0;
	
		while(!hoursExists  && count < 3 ){
		boolean buttonExist = driver.findElements( By.xpath(gl.TwoWksButton)).size() != 0;
		if (buttonExist){
				count++;
				driver.findElement(By.xpath(gl.TwoWksButton)).click(); // Button
		  		System.out.println ( driver.findElement(By.xpath(gl.verifyAppt)).getText());
			}
				hoursExists = driver.findElements( By.xpath(gl.hoursLink)).size() != 0;
			} 
		if (count == 3){
				System.err.println ("No Service Time Found, Tried "+ count +"  Times");
		} else{
				driver.findElement(By.xpath(gl.hoursLink)).click();
				System.out.println ( driver.findElement(By.xpath(gl.verifyAppt)).getText());

		clickByXpath (gl.G1BillingLink);
		clickByXpath (gl.OnlineBookingclickHereToLogIn);
		typeByXpath (gl.OnlineBookingemailAddress, gv.emailWithNoSavedCard);
		typeByXpath (gl.OnlineBookingpassword, gv.SpaPassword);
		clickByXpath (gl.OnlineBookinglogin);
	
// Using Gift Card
		clickByXpath (gl.OnlinebookingGiftCardTab);
		typeByXpath (gl.onlineBookingFirstName, gv.MBOFNameValue);
		typeByXpath (gl.onlineBookingLastName, gv.MBOLNameValue);
		typeByXpath (gl.onlineBookingEmail, gv.emailWithNoSavedCard);
		typeByXpath (gl.onlineBookingPhoneNumber, gv.MBOPhoneNumberValue);
		typeByXpath (gl.OnlinebookingGCNumber, gv.OnlineBookingGCNumber);
		clickByXpath (gl.OnlinebookingGCDropDown);
		clickByXpath (gl.onlineBookingGCValueUK);
		clickByXpath (gl.onlineBookingCancellationPolicy);
		clickByXpath (gl.onlineBookingCompleYourBookingLink);

		String totalMoney  = driver.findElement(By.xpath(gl.totalPrice)).getText();
		Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
		Matcher m = p.matcher(totalMoney);
      
		boolean b = m.find();
		if (b)
		{
				String totalAmount = m.group();
    		
		boolean PF = driver.findElement(By.xpath(gl.orderNumber)).isDisplayed();
		if (!PF)
    		{
			passData ("UK", "passFail", 28, gv.Fail); // writing the text into excel from selenium
        	} else  { 
        			System.err.println ("=====================================================================");
        			passData ("UK", "passFail", 28, gv.Pass); // writing the text into excel from selenium
        			setCellData ("UK", "OrderNumber", 28, gl.orderNumber); // Writing order number into excel file.
        			System.out.println(getCellData("UK", "OrderNumber", 28)); // reading from excel
        		 	passData ("UK", "Total", 28, totalAmount);
        		 	System.out.println ("Total Amount is: " + getCellData("UK", "Total", 28));
        		 	System.err.println ("=====================================================================");		
       
         			}
			}
		  	}
		screenShot ("UK_G1AlreadyMember_usingGC");
	}
}
			



