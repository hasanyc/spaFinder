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

public class G1_ExistingUserUsingGiftCardInCA extends CABaseClass {

	OnlineBookingLocator gl = new OnlineBookingLocator();
	OnlineBookingValue   gv = new OnlineBookingValue ();

	@Test
	public void G1AlreadyMemUsingGCinCA () throws InterruptedException, IOException{
		
		driver.get(baseURL + "/Spa/424-Allure-Day-Spa-and-Hair-Design#services");
		
		List <WebElement> allPrice = driver.findElements (By.xpath(gl.gOnePriceLocator));
		System.out.println ("Total Prices are: " + allPrice.size());
		  
		 List <WebElement> allButtons = driver.findElements (By.xpath(gl.gOneButtonsLocator));
		 System.out.println ("Total Buttons are: " + allButtons.size());
		  
		   for (int i = 0; i<allPrice.size(); i++){
			   if(StringUtils.isNotEmpty(allPrice.get(i).getText())){
				   //System.out.println (allPrice.get(i).getText());
				   String  strPrice = allPrice.get(i).getText().replaceAll("[^\\d.]", "");
				//    String strPrice = allPrice.get(i).getText().substring(1);
				    Integer  price = new Integer(strPrice);
				  
				  //  if (price > 60){  // using gc+cc}
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
				System.out.println ("");
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
		typeByXpath (gl.onlineBookingEmail, gv.SpaEmail);
		typeByXpath (gl.onlineBookingPhoneNumber, gv.MBOPhoneNumberValue);
		typeByXpath (gl.OnlinebookingGCNumber, gv.OnlineBookingGCNumber);
		clickByXpath (gl.OnlinebookingGCDropDown);
		clickByXpath (gl.onlineBookingGCValue);
		clickByXpath (gl.onlineBookingCancellationPolicy);
			
		clickByXpath (gl.onlineBookingCompleYourBookingLink);
		System.out.println ("");

		String totalMoney  = driver.findElement(By.xpath(gl.totalPrice)).getText();
		Pattern p = Pattern.compile(".[0-9]{2,3}[.]?[0-9]{0,2}"); // period will print any char. Ex: $, € etc
	    Matcher m = p.matcher(totalMoney);
	      
	    boolean b = m.find();
	    if (b)
	    {
	    	String totalAmount = m.group();
	    		  
	    boolean PF = driver.findElement(By.xpath(gl.orderNumber)).isDisplayed();
	    if (PF == false)
	     {
	    	passData ("CA", "passFail", 25, gv.Fail); // writing the text into excel from selenium
	     } else  { 
	    	 System.err.println ("=====================================================================");
	    	 passData ("CA", "passFail", 25, gv.Pass); // writing the text into excel from selenium
	    	 setCellData ("CA", "OrderNumber", 25, gl.orderNumber); // Writing order number into excel file.
	    	 System.out.println(getCellData("CA", "OrderNumber", 25)); // reading from excel
	    		
	    	 passData ("CA", "Total", 25, totalAmount);
	    	 System.out.println ("Total Amount is: " + totalAmount);
	    	 System.err.println ("=====================================================================");		
	    	 System.out.println ();
	     			}
	    	}
		}
		screenShot ("CA_G1_AlreadyMember_usingGC");
	}
}
