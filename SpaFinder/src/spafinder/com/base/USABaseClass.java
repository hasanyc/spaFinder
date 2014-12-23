package spafinder.com.base;


import java.net.MalformedURLException;
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


public class USABaseClass extends AbstractClass {
	protected static String baseURL;
	protected static String IgcURL;
	public static String Browser;

@BeforeTest
public static void setBrowser () throws MalformedURLException { 
				
			Browser = "FF";
		
			if (Browser.equalsIgnoreCase("FF")) {
			/*	DesiredCapabilities dc = new DesiredCapabilities();
				dc.setJavascriptEnabled(true);*/
				FirefoxProfile FP = new FirefoxProfile();
				FP.setAcceptUntrustedCertificates(true);
				FP.setAssumeUntrustedCertificateIssuer(false);
				FP.setPreference("print.always_print_silent", true);
				//FP.setPreference ("webdriver.log.file","C:/Users/hassan.abul/Desktop/logs.txt");
				wd = new FirefoxDriver(FP);
				
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
					 
		baseURL = "http://qa.spafinder.com";
				  
		 					
			// baseURL = "http://172.16.100.242"; // Web 14
			
			// baseURL = "http://172.16.100.88"; 
			 
			// baseURL = "http://172.16.100.168"; // Web 16
						
			
			
			iWait (40);
			maxPage();

		}	 
		         
	
@AfterTest
public  void tearDown() throws Exception{
			 
	driver.close(); // close the firefox window
	driver.quit();	// close all ff windows associated with driver
	}
	   
	}

