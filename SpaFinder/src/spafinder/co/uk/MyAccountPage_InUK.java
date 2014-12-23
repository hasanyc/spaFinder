package spafinder.co.uk;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Test;

import spafinder.com.locator.MyAccountLocator;
import spafinder.com.value.MyAccountValues;

public class MyAccountPage_InUK  extends spafinder.com.base.UKBaseClass {


	MyAccountLocator mal = new MyAccountLocator();
	MyAccountValues mav = new MyAccountValues();
	
	
	DateFormat dateFormat = new SimpleDateFormat("MM.dd.YYYY.hh.mm.ss"); // ("EEEE - MM/dd/YYYY & hh:mm:ss a");
	Calendar cal = Calendar.getInstance();
	String currentDate = dateFormat.format(cal.getTime());
	String email1 = "UkAutomation";
	String email2 = "@gmail.com";
	String emailAddress = email1+currentDate+email2;


@Test (enabled = true)
public void myAccountTestInUK () throws InterruptedException{
	
	driver.get(baseURL + "/account/clubspa/signup.jsp");
		
	typeByXpath(mal.signUpFName, mav.addressFnameValue);
	typeByXpath(mal.signUpLName, mav.addressLastNameValue);
	typeByXpath(mal.signUpEmail, emailAddress);
	typeByXpath(mal.signUpPass, mav.SpaPassword);
	typeByXpath(mal.signUpRePass, mav.SpaPassword);
	clickByName (mal.signUpButtonByName);
	assertTrue (emailAddress, mal.eMailAssert);
	passData ("UK", "OrderNumber", 33, emailAddress);
	
	clickByLink (mal.rewardsLinkText);
	assertTrue (mav.rewardsValueUK, mal.headerAssert);
	clickByLink (mal.overviewLinkText);
	assertTrue (mav.overviewValue, mal.headerAssert);
	
		
	// Profile Setting
	clickByLink (mal.profileSettingsLinkText);
	assertTrue (mav.profileSettingsValue, mal.headerAssert);
	clickByLink (mal.updateProfileLinkText);
	lightBox();
	typeByName (mal.fnByName, mav.addressFnameValue);
	typeByName (mal.lnByName, mav.addressLastNameValue);
	clickByXpath (mal.submitButtonByXpath);
	clickById (mal.selectAllBoxById);
	clickByCss (mal.saveEmailButtonByCss);
	Thread.sleep (3000);
	assertTrue (mav.thankYouMsgValue, mal.thankYouMsgByXpath);
	Thread.sleep(1000);
	verifyCheckBoxByName (mal.wellnessCheckboxByName);
	verifyCheckBoxByName (mal.partnerCheckboxByName);
	verifyCheckBoxByName (mal.lmCheckboxByName);
	System.out.println ();
		
	clickByLink (mal.ordersLinkText);
	assertTrue (mav.ordersValue, mal.headerAssert2);
	clickByLink (mal.bookingsLinkText);
	assertTrue (mav.bookingsValue, mal.headerAssert2);
	
	// Add Address
	clickByLink (mal.addressBookLinkText);
	assertTrue (mav.addressBookValue, mal.headerAssert2);
	clickByLink (mal.addAnAdressButtonByLink);
	iFrameByXpath (mal.addressiFrame);
	typeByName (mal.fnByName, mav.addressFnameValue);
	typeByName (mal.lnByName, mav.addressLastNameValue);
	dropDownById (mal.countryById, mav.addressCountryValue);
	typeByName (mal.addressByName, mav.address1Value);
	typeByName (mal.address2ByName, mav.address2Value);
	typeByName (mal.cityByName, mav.addressCityValue);
	dropDownById (mal.stateById, mav.addressStateNYvalue);
	typeByName (mal.zipcodeByName, mav.addressZIPvalue);
	typeByName (mal.phoneByName, mav.addressPhoneValue);
	clickByXpath (mal.submitButtonByXpath);
	popUp();
}

	}
	
	

