package spafinder.co.uk;


import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import spafinder.com.locator.OnlineBookingLocator;
import spafinder.com.value.OnlineBookingValue;

public class G1AlreadyMemberUK extends spafinder.com.base.UKBaseClass {

	OnlineBookingLocator gl = new OnlineBookingLocator();
	OnlineBookingValue   gv = new OnlineBookingValue ();

@Test(enabled = true)  // (enabled = false) means skpping test

public void G1_UsingCCinUK () throws InterruptedException, IOException{
	
		driver.get (baseURL+"/Spa/424-Allure-Day-Spa-and-Hair-Design#services");
		clickByXpath (gl.gOneButtonsLocator);
				
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
		} else {
				driver.findElement(By.xpath(gl.hoursLink)).click();
				System.out.println ( driver.findElement(By.xpath(gl.verifyAppt)).getText());

		clickByXpath (gl.G1BillingLink);
		clickByXpath (gl.OnlineBookingclickHereToLogIn);
		typeByXpath (gl.OnlineBookingemailAddress, gv.UKemailValue);
		typeByXpath (gl.OnlineBookingpassword, gv.SpaPassword);
		clickByXpath (gl.OnlineBookinglogin);
		
// USING CC Info
		
		typeByXpath (gl.onlineBookingFirstName, gv.MBOFNameValue);
		typeByXpath (gl.onlineBookingLastName, gv.MBOLNameValue);
		typeByXpath (gl.onlineBookingEmail, gv.UKemailValue);
		clickByXpath (gl.onlineBookingCountry);
		clickByXpath (gl.onlineBookingCountryUSA);
		typeByXpath (gl.onlineBookingStreetAddress, gv.MBOStreetAddressValue);
		typeByXpath (gl.onlineBookingCity, gv.MBOCityValue);
		typeByXpath (gl.onlineBookingZipCode, gv.MBOZipCodeValue);
		clickByXpath (gl.onlineBookingState);
		clickByXpath (gl.onlineBookingStateNY);
		typeByXpath (gl.onlineBookingPhoneNumber, gv.MBOPhoneNumberValue);
		typeByXpath (gl.onlineBookingCardNumber, gv.MBOCardNumberValue);
		typeByXpath (gl.onlineBookingSecurityCode, gv.MBOSecurityCodeValue);
		typeByXpath (gl.OnlineBookingExpMM, gv.MBOExpirationMonthValue);
		typeByXpath (gl.OnlineBookingExpYY, gv.MBOExpirationYearValue);
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
    			passData ("UK", "passFail", 27, gv.Fail); // writing the text into excel from selenium
    	} else  { 
    			System.err.println ("=====================================================================");
    			passData ("UK", "passFail", 27, gv.Pass); // writing the text into excel from selenium
    			setCellData ("UK", "OrderNumber", 27, gl.orderNumber); // Writing order number into excel file.
    			System.out.println(getCellData("UK", "OrderNumber", 27)); // reading from excel
    		 	passData ("UK", "Total", 27, totalAmount);
    		 	System.out.println ("Total Amount is: " + getCellData("UK", "Total", 27));
    		 	System.err.println ("=====================================================================");		
   
     			}
			}
			}
		screenShot ("UK_G1AlreadyMember_usingCC");
	}
}
