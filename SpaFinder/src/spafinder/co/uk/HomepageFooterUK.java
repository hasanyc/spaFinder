package spafinder.co.uk;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import spafinder.com.locator.HomePageLocator;
import spafinder.com.value.HomePageValue;


public class HomepageFooterUK extends spafinder.com.base.UKBaseClass {

	HomePageValue 		hpv = new  HomePageValue();
	HomePageLocator		hpl = new  HomePageLocator();
	 	
	@Test (priority = 1)
	public void resourcesFooterLinkInUK () throws InterruptedException{
		
			driver.get(baseURL);
			System.out.println ("........ Resource Foooter Link In UK.........");
			scroll();
			
			clickByXpath (hpl.trendsLinkUK);
			assertTrue (hpv.trendsValue, hpl.trendsLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.wtaLinkUK);
			assertTrue (hpv.wtaValue, hpl.wtaLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.rcaLinkUK);
			assertTrue (hpv.rcaValue, hpl.rcaLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.spaEtiquetteLinkUK);
			assertTrue (hpv.spaEtiquetteValueUK, hpl.spaEtiquetteLocatorUK);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.spaGlossaryLinkUK);
			assertTrue (hpv.spaGlossaryValue, hpl.spaGlossary);
			navigateBack();
			scroll ();
				
			clickByXpath (hpl.londonSpaGuideLinkUK);
			assertTrue (hpv.londonSpaGuideValueUK, hpl.londonSpaGuideLocatorUK);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.spaBreaksLinkUK);
			assertTrue (hpv.spaBreaksValueUK, hpl.spaBreaksLocatorUK);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.spaVouchersLinkUK);
			assertTrue (hpv.spaVouchersValueUK, hpl.spaVouchersLocatorUK);
			navigateBack();
			scroll ();
		}
			 
	@Test (priority = 2)
	public void helpFooterLinkInUK () throws InterruptedException{
				
			driver.get(baseURL);
			System.out.println ("........ Help Foooter Link in UK.........");
			scroll();
			
			clickByXpath (hpl.GC_FAQsLinkUK);
			assertTrue (hpv.FaqValue, hpl.FaqLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.customerServiceLinkUK);
			assertTrue (hpv.customerServiceValue, hpl.customerServiceLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.contactUsLinkUK);
			assertTrue (hpv.contactUsValue, hpl.contactUsLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.legalNoticesLinkUK);
			assertTrue (hpv.LNValue, hpl.LNLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.giveUs_FeedbackLinkUK);
			assertTrue (hpv.feedbackValue, hpl.feedbackLocator);
			navigateBack();
			scroll ();
	}


	@Test (priority = 3)
	public void businessPartnersFooterLinkInUK () throws InterruptedException{
				
			driver.get(baseURL);
			System.out.println ("........ Business Partner Foooter Link In UK .........");
			scroll();
			
			clickByXpath (hpl.becomePartnerLinkUK);
			assertTrue (hpv.becomePartnerValue, hpl.becomePartnerLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.affiliateProgramLinkUK);
			assertTrue (hpv.affiliateProgramValueUK, hpl.affiliateProgramLocatorUK);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.travelAgentsLinkUK);
			assertTrue (hpv.travelAgentsValueCA, hpl.travelAgentsLocatorCA);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.corporateWellnessLinkUK);
			assertTrue (hpv.corporateWellnessValueUK, hpl.corporateWellnessLocatorUK);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.topSpaBrandsLinkUK);
			assertTrue (hpv.topSpaBrandsValueUK, hpl.topSpaBrandsLocatorUK);
			navigateBack();
			scroll ();
	}	
		
	@Test (priority = 5)
	public void aboutPartnersFooterLinkInUK () throws InterruptedException{
				
			driver.get(baseURL);
			System.out.println ("........ About Foooter Link In UK .........");
			scroll();
			
			clickByXpath (hpl.aboutUsLinkUK);
			assertTrue (hpv.aboutUsValue, hpl.aboutUsLocators);
			navigateBack();
			scroll ();
			
//			clickByXpath (hpl.careersLinkUK);
//			assertTrue (hpv.careersValue, hpl.careersLocators);
//			navigateBack();
//			scroll ();
			
			clickByXpath (hpl.newsroomLinkCA);
			assertTrue (hpv.newsroomValue, hpl.newsroomLocators);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.siteMapLinkUK);
			assertTrue (hpv.siteMapValue, hpl.siteMapLocators);
			navigateBack();
			scroll ();
		}
		 	
@Test (priority = 6)
public void copyRightAndSocialNetworksInUK() throws InterruptedException{
		 
		driver.get(baseURL);
		System.out.println ("........ UK SpaFinder CopyRight Test.........");
		System.out.println ();
		
		scroll();	 		
		assertTrue (hpv.copyRightValueUK, hpl.copyRightLocator);
		
		System.out.println ("........ UK SpaFinder Social Networks.........");
		System.out.println ();
		
		clickByCss (hpl.faceBook);
		window();
		getURL();
		assertTrue (hpv.ukFacebookValue, hpl.FacebookLocator);
		driver.close();
		parentWindow();	 
		
		clickByCss (hpl.twitter);
		window();
		getURL();
		driver.close();
		parentWindow();	
		
		clickByCss (hpl.pinterest);
		window();
		getURL();
		assertTrue (hpv.ukPinterestValue, hpl.PinterestLocator);
		driver.close();
		parentWindow();	
		
		clickByCss (hpl.google);
		window();
		assertTrue (hpv.ukGoogleValue, hpl.GoogleLocator);
		driver.close();
		parentWindow();	
}
	
@Test (priority = 7)
public void subscriptionInUK() throws InterruptedException{
		driver.get(baseURL);
		System.out.println ("........ UK SpaFinder Subscription Test.........");
		scroll();	 		
			
		typeById (hpl.subscriptionEditBox, hpv.subEmail);
		clickById (hpl.subscriptionSubmit);
		scroll();	
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hpl.subscriptionVerify)));
		assertTrue (hpv.verifySubscribe, hpl.subscriptionVerify);
}





}
	 		
		

	
		
	
		
