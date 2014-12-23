package spafinder.ca;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import spafinder.com.base.CABaseClass;
import spafinder.com.locator.HomePageLocator;
import spafinder.com.value.HomePageValue;


public class HomepageFooterCA extends CABaseClass {

	HomePageValue 	hpv = new  HomePageValue();
	HomePageLocator	hpl = new  HomePageLocator();
	
	 
	@Test (priority = 1)
	public void resourcesFooterLinkInCA () throws InterruptedException{
		
			driver.get(baseURL);
			System.out.println ("........ Resource Foooter Link In CA.........");
			scroll();
			
			clickByXpath (hpl.wellnessBlogLinkCA);
			popUpModal ();
			assertTrue (hpv. wellnessBlogValueCA, hpl.wellnessBlogLocatorCA);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.trendsLinkCA);
			assertTrue (hpv.trendsValue, hpl.trendsLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.wtaLinkCA);
			assertTrue (hpv.wtaValue, hpl.wtaLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.rcaLinkCA);
			assertTrue (hpv.rcaValue, hpl.rcaLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.spaEtiquetteLinkCA);
			assertTrue (hpv.spaEtiquetteValue, hpl.spaEtiquette);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.spaGlossaryLinkCA);
			assertTrue (hpv.spaGlossaryValue, hpl.spaGlossary);
			navigateBack();
			scroll ();
						
			clickByXpath (hpl.topTenListLinkCA);
			assertTrue (hpv.topTenListValueCA, hpl.topTenListLocatorCA);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.wellnessWeekLinkCA);
			assertTrue (hpv.wellnessWeekValueCA, hpl.wellnessWeekLocatorCA);
		}
			 
	@Test (priority = 2)
	public void helpFooterLinkInCA () throws InterruptedException{
				
			driver.get(baseURL);
			System.out.println ("........ Help Foooter Link in CA.........");
			scroll();
			
			clickByXpath (hpl.GC_FAQsLinkCA);
			assertTrue (hpv.FaqValue, hpl.FaqLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.customerServiceLinkCA);
			assertTrue (hpv.customerServiceValue, hpl.customerServiceLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.contactUsLinkCA);
			assertTrue (hpv.contactUsValue, hpl.contactUsLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.legalNoticesLinkCA);
			assertTrue (hpv.LNValue, hpl.LNLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.giveUs_FeedbackLinkCA);
			assertTrue (hpv.feedbackValue, hpl.feedbackLocator);
			navigateBack();
			scroll ();
	}


	@Test (priority = 3)
	public void businessPartnersFooterLinkInCA () throws InterruptedException{
				
			driver.get(baseURL);
			System.out.println ("........ Business Partner Foooter Link In CA .........");
			scroll();
			
			clickByXpath (hpl.becomePartnerLinkCA);
			assertTrue (hpv.becomePartnerValue, hpl.becomePartnerLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.partnerFaqsLinkCA); 
			assertTrue (hpv.FaqValue, hpl.FaqLocator); // Same locator and value as GC FAQs
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.adWithUsLinkCA);
			assertTrue (hpv.adWithUsValueCA, hpl.adWithUsLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.affiliateProgramLinkCA);
			assertTrue (hpv.affiliateProgramValue, hpl.affiliateProgramLocator);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.travelAgentsLinkCA);
			assertTrue (hpv.travelAgentsValueCA, hpl.travelAgentsLocatorCA);
			navigateBack();
			scroll ();
			
//			clickByXpath (hpl.corporateWellnessLinkCA);
//			assertTrue (hpv.corporateWellnessValue, hpl.corporateWellnessLocator);
//			navigateBack();
//			scroll ();
			
			clickByXpath (hpl.corporateIncentivesLinkCA);
			assertTrue (hpv.corporateIncentivesValue, hpl.corporateIncentivesLocators);
			navigateBack();
			scroll ();
	}	
		
	@Test (priority = 5)
	public void aboutPartnersFooterLinkInCA () throws InterruptedException{
				
			driver.get(baseURL);
			System.out.println ("........ About Foooter Link In CA .........");
			scroll();
			
			clickByXpath (hpl.aboutUsLinkCA);
			assertTrue (hpv.aboutUsValue, hpl.aboutUsLocators);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.careersLinkCA);
			assertTrue (hpv.careersValue, hpl.careersLocators);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.newsroomLinkCA);
			assertTrue (hpv.newsroomValue, hpl.newsroomLocators);
			navigateBack();
			scroll ();
			
			clickByXpath (hpl.siteMapLinkCA);
			assertTrue (hpv.siteMapValue, hpl.siteMapLocators);
			navigateBack();
			scroll ();
		}

	@Test (priority = 6)
	public void copyRightAndSocialNetworksInCA() throws InterruptedException{
			 
			driver.get(baseURL);
			System.out.println ("........ CA SpaFinder CopyRight Test.........");
			System.out.println ();
			
			scroll();	 		
			assertTrue (hpv.copyRightValueCA, hpl.copyRightLocator);
			
			System.out.println ("........ CA SpaFinder Social Networks.........");
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
			System.out.println ("........ CA SpaFinder Subscription Test.........");
			System.out.println ();
			scroll();	 		
				
			typeById (hpl.subscriptionEditBox, hpv.subEmail);
			clickById (hpl.subscriptionSubmit);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hpl.subscriptionVerify)));
			assertTrue (hpv.verifySubscribe, hpl.subscriptionVerify);
		
	}



	}

		