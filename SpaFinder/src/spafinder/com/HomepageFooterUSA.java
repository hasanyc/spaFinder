package spafinder.com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import spafinder.com.locator.HomePageLocator;
import spafinder.com.value.HomePageValue;


public class HomepageFooterUSA extends spafinder.com.base.USABaseClass {

	 HomePageValue 		hpv = new  HomePageValue();
	 HomePageLocator	hpl = new  HomePageLocator();
	 
 
	 
@Test (priority = 1)
public void resourcesFooterLinkInUSA () throws InterruptedException{
	
		driver.get(baseURL);
		System.out.println ("........ Resource Foooter Link In USA.........");
		scroll();
		
		clickByXpath (hpl.trendsLink);
		assertTrue (hpv.trendsValue, hpl.trendsLocator);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.wtaLink);
		assertTrue (hpv.wtaValue, hpl.wtaLocator);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.rcaLink);
		assertTrue (hpv.rcaValue, hpl.rcaLocator);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.spaEtiquetteLink);
		assertTrue (hpv.spaEtiquetteValue, hpl.spaEtiquette);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.spaGlossaryLink);
		assertTrue (hpv.spaGlossaryValue, hpl.spaGlossary);
	}
		 
@Test (priority = 2)
public void helpFooterLinkInUSA () throws InterruptedException{
			
		driver.get(baseURL);
		System.out.println ("........ Help Foooter Link in USA.........");
		scroll();
		
		clickByXpath (hpl.GC_FAQsLink);
		assertTrue (hpv.FaqValue, hpl.FaqLocator);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.customerServiceLink);
		assertTrue (hpv.customerServiceValue, hpl.customerServiceLocator);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.contactUsLink);
		assertTrue (hpv.contactUsValue, hpl.contactUsLocator);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.legalNoticesLink);
		assertTrue (hpv.LNValue, hpl.LNLocator);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.giveUs_FeedbackLink);
		assertTrue (hpv.feedbackValue, hpl.feedbackLocator);
		navigateBack();
		scroll ();
}


@Test (priority = 3)
public void businessPartnersFooterLinkInUSA () throws InterruptedException{
			
		driver.get(baseURL);
		System.out.println ("........ Business Partner Foooter Link In USA .........");
		scroll();
		
		clickByXpath (hpl.becomePartnerLink	);
		assertTrue (hpv.becomePartnerValue, hpl.becomePartnerLocator);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.adWithUsLink);
		assertTrue (hpv.adWithUsValue, hpl.adWithUsLocator);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.affiliateProgramLink);
		assertTrue (hpv.affiliateProgramValue, hpl.affiliateProgramLocator);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.travelAgentsLink);
		assertTrue (hpv.travelAgentsValue, hpl.travelAgentsLocator);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.corporateWellnessLink);
		assertTrue (hpv.corporateWellnessValue, hpl.corporateWellnessLocator);
		navigateBack();
		scroll ();
}	
	
@Test (priority = 5)
public void aboutPartnersFooterLinkInUSA () throws InterruptedException{
			
		driver.get(baseURL);
		System.out.println ("........ About Foooter Link In USA .........");
		scroll();
		
		clickByXpath (hpl.aboutUsLink);
		assertTrue (hpv.aboutUsValue, hpl.aboutUsLocators);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.careersLink);
		assertTrue (hpv.careersValue, hpl.careersLocators);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.newsroomLink);
		assertTrue (hpv.newsroomValue, hpl.newsroomLocators);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.siteMapLink);
		assertTrue (hpv.siteMapValue, hpl.siteMapLocators);
		navigateBack();
		scroll ();
		
		clickByXpath (hpl.corporateIncentivesLink);
		assertTrue (hpv.corporateIncentivesValue, hpl.corporateIncentivesLocators);
		navigateBack();
		scroll ();
		
		
}

@Test (priority = 6)
public void copyRightAndSocialNetworksInUSA() throws InterruptedException{
		 
		driver.get(baseURL);
		System.out.println ("........ USA SpaFinder CopyRight Test.........");
		System.out.println ();
		
		scroll();	 		
		assertTrue (hpv.copyRightValueUSA, hpl.copyRightLocator);
		
		System.out.println ("........ USA SpaFinder Social Networks.........");
		System.out.println ();
		
		clickByCss (hpl.faceBook);
		window();
		getURL();
		assertTrue (hpv.usaFacebookValue, hpl.FacebookLocator);
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
		assertTrue (hpv.usaPinterestValue, hpl.PinterestLocator);
		driver.close();
		parentWindow();	
		
		clickByCss (hpl.google);
		window();
		getURL();
		assertTrue (hpv.usaGoogleValue, hpl.GoogleLocator);
		driver.close();
		parentWindow();	
}
	

@Test (priority = 7)
public void subscriptionInUSA() throws InterruptedException{
	
		driver.get(baseURL);
		System.out.println ("........ USA SpaFinder Subscription Test.........");
		System.out.println ();
		scroll();	 		
			
		typeById (hpl.subscriptionEditBox, hpv.subEmail);
		clickById (hpl.subscriptionSubmit);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hpl.subscriptionVerify)));
		assertTrue (hpv.verifySubscribe, hpl.subscriptionVerify);
	
}



}

	