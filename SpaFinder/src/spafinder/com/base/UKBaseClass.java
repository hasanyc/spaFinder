package spafinder.com.base;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import spafinder.com.abstractor.AbstractClass;


public class UKBaseClass extends AbstractClass {
	protected static String baseURL;
	protected static String Browser;
	private static StringBuffer verificationErrors = new StringBuffer();
	

@BeforeTest
public static void setBrowser () throws IOException {
	
			Browser = "FF";
			
			if (Browser.equalsIgnoreCase("FF")) {
				FirefoxProfile FP = new FirefoxProfile();
				FP.setAcceptUntrustedCertificates(true);
				FP.setAssumeUntrustedCertificateIssuer(false);
				//FP.setPreference ("webdriver.log.file","C:/Users/hassan.abul/Desktop/logs.txt");
				wd = new FirefoxDriver();
					   		
			} else if (Browser.equalsIgnoreCase("IE")) {
			  	System.setProperty("webdriver.ie.driver",(System.getProperty("user.dir")+"\\CrossBrowserDriver\\IEDriverServer.exe"));
		      	DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		      	dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);  
		      	wd = new InternetExplorerDriver(dc);
		      	wd.manage().deleteAllCookies();
		      	
			} else if (Browser.equalsIgnoreCase("CH")){
				System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"\\CrossBrowserDriver\\chromedriver.exe"));
				wd = new ChromeDriver();
				System.err.println("Google Chrome is selected");
				System.out.println ("==========================================================");
				
			} else if (Browser.equalsIgnoreCase("Safari")){
				wd = new SafariDriver();
				System.err.println("Safari has been selected");
				
			} else if (Browser.equalsIgnoreCase("iOS")){
			  	new RemoteWebDriver(new URL("http://localhost:3001/wd/hub"), DesiredCapabilities.ipad());
			  	System.err.println("iOS is selected To do the Cross Browser Test");
			
			} else {      
				throw new IllegalArgumentException("The Browser Type is Undefined");  
			}
			
			//EventFiringWebDriver
			driver = new EventFiringWebDriver (wd);		
					
	
			 baseURL = "http://qa.spafinder.co.uk";
				
			//	baseURL = "http://172.16.100.244";   	// Web 14
			 
		//	 baseURL = "http://172.16.100.150"; 		// Web 15
			 
			// baseURL = "http://172.16.100.169"; 		// Web 16
			 
			 
			iWait (40);
			maxPage();

}
	
	
@AfterTest
public static void closeURL (){
 	   
	driver.close();
	driver.quit ();
	driver=null;
	
	
	String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
	
	}


