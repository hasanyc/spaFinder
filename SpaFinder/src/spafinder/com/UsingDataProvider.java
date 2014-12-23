package spafinder.com;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import spafinder.com.locator.MyAccountLocator;
import spafinder.com.value.MyAccountValues;

public class UsingDataProvider extends spafinder.com.base.USABaseClass {
	
	MyAccountLocator mal = new MyAccountLocator();
	MyAccountValues mav = new MyAccountValues();
	

	DateFormat dateFormat = new SimpleDateFormat("MM.dd.YYYY.hh.mm.ss"); // ("EEEE - MM/dd/YYYY & hh:mm:ss a");
	Calendar cal = Calendar.getInstance();
	String currentDate = dateFormat.format(cal.getTime());
	String email = "automation";
	String email2 = "@gmail.com";

	
@Test (dataProvider = "dp", enabled = false)
public void signUpUserAccountTest (String firstName, String lastName, String Password, String rePassword){
		
		driver.get(baseURL + "/account/clubspa/signup.jsp");
		maxPage();
		iWait (30);
		typeByXpath(mal.signUpFName, firstName);
		typeByXpath(mal.signUpLName, lastName);
		typeByXpath(mal.signUpEmail, email+currentDate+email2);
		typeByXpath(mal.signUpPass, Password);
		typeByXpath(mal.signUpRePass, rePassword);
		clickByName (mal.signUpButtonByName);
		try{
		assertion ("email+currentDate+email2", mal.eMailAssert);
		}catch(Exception t){
			
			boolean exists = driver.findElements( By.xpath(mal.alreadyTaken)).size() != 0;
			String alreadyTaken = 	driver.findElement( By.xpath(mal.alreadyTaken)).getText();
			if (exists) {
				System.out.println ("");
				System.out.println (alreadyTaken);
				}
		}
	}
	
	
	@DataProvider(name="dp")
	public Object[][] dp1(){
		Object[][] data = new Object[3][5]; // [2] as many times u want to run  and [5] is your string parameters in test class
		
		
		 data[0][0] = "Hasan";
		 data[0][1] = "Bhuiyan";
		 data[0][2] = "qa.test021@gmail.com";
		 data[0][3] = "Finderspa1";
		 data[0][4] = "Finderspa1";
		 
		 data[1][0] = "Hasan";
		 data[1][1] = "Bhuiyan";
		 data[1][2] = "qa.test023@gmail.com";
		 data[1][3] = "Finderspa1";
		 data[1][4] = "Finderspa1";
		 
		 
		 data[1][0] = "Hasan";
		 data[1][1] = "Bhuiyan";
		 data[1][2] = "qa.test024@gmail.com";
		 data[1][3] = "Finderspa1";
		 data[1][4] = "Finderspa1";
		 
		 
		 System.out.println (data);
		 
			 
		 return data;
	}
	

}
