package spafinder.com;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import spafinder.com.locator.UserPartnerLocator;
import spafinder.com.value.UserPartnerValue;

public class FlexPartnerSignUp extends spafinder.com.base.USABaseClass {
	
	UserPartnerLocator iol = new UserPartnerLocator();
	UserPartnerValue  iov = new UserPartnerValue ();
	
@Test
public void FlexSignUpPartnerUSA () throws InterruptedException{
		
		//driver.get(baseURL + "/self-service/index.htm?plan=Flex");
				
//		typeByXpath (iol.BusinessName, "qa.test002@gmail.com");
//		typeByXpath (iol.BusinessEmail, "qa.test002@gmail.com");
//		typeByXpath (iol.BusinessPassword, iov.BusinessPasswordValue);
//		typeByXpath (iol.BusinessRePassword, iov.BusinessPasswordValue);
//		clickByXpath (iol.clickStep2);
//		iWait (25);
//		
//		dropDownByXpath (iol.BusinessType, iov.BusinessTypeValue);
//		typeByXpath (iol.BusinessAddress, iov.BusinessAddressValue);
//		dropDownByXpath (iol.BusinessCountry, iov.BusinessCountryValue);
//		clickByXpath (iol.BusinessState);
//		iWait (20);
//		clickByXpath (iol.BusinessStateValue);
//		iWait (20);
//		clickByXpath (iol.BusinessCity);
//		iWait (40);
//		clickByXpath (iol.BusinessCityValue);
//		iWait (20);
//		typeByXpath (iol.BusinessZipCode, iov.BusinessZipCodeValue);
//		typeByXpath (iol.BusinessPhoneNumber, iov.BusinessPhoneNumberValue);
//		clickByXpath (iol.clickStep3);
//		iWait (30);
//		
//		clickByXpath (iol.clickAgree);
//		clickByXpath (iol.clickSaveProfile);
//		iWait (30);
//		getTextByXpath (iol.FlexConfirmationAssert);
		
		driver.get(baseURL + "/");
		driver.findElement(By.linkText("Business Partners")).click();
		driver.findElement(By.linkText("Become one today!")).click();
		driver.findElement(By.linkText("Select")).click();
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.id("business-name")).clear();
		driver.findElement(By.id("business-name")).sendKeys("qatest24");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("qatest24@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Finderspa1");
		driver.findElement(By.id("reenter-password")).clear();
		driver.findElement(By.id("reenter-password")).sendKeys("Finderspa1");
		driver.findElement(By.cssSelector("button.blue.large")).click();
		new Select(driver.findElement(By.id("business-type"))).selectByVisibleText("Day Spa");
		driver.findElement(By.id("business-address-1")).clear();
		driver.findElement(By.id("business-address-1")).sendKeys("257 park ave south");
		dropDownByXpath (iol.BusinessCountry, iov.BusinessCountryValue);
		clickByXpath (iol.BusinessState);
		clickByXpath (iol.BusinessStateValue);
		clickByXpath (iol.BusinessCity);
		clickByXpath (iol.BusinessCityValue);
		driver.findElement(By.xpath("//li[6]/input")).sendKeys("10010");
		driver.findElement(By.id("business-phone")).clear();
		driver.findElement(By.id("business-phone")).sendKeys("7185597821");
		driver.findElement(By.cssSelector("button.blue")).click();
		driver.findElement(By.id("terms-of-service")).click();
		driver.findElement(By.cssSelector("button.green")).click();
		//String ThankYouForSignUp = driver.findElement(By.cssSelector("h1")).getText();


		
	}

}
