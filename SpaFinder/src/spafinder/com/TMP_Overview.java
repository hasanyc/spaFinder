package spafinder.com;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import spafinder.com.locator.OverviewPageLocator;
import spafinder.com.value.OverviewPageValue;

public class TMP_Overview extends spafinder.com.base.USABaseClass  {
	
	OverviewPageLocator 	opl = new OverviewPageLocator ();
	OverviewPageValue  		opv = new OverviewPageValue  ();
	
	
	
@Test
public void TMP_HeroWrapperInUSA () throws InterruptedException{
	
	driver.get(baseURL+"/Spa/6450-a");
	assertTrue (opv.heroTitleValue, opl.heroTitle);
	assertTrue (opv.toutValue, opl.tout);
	assertTrue (opv.displayURLtextValue, opl.displayURL);
	clickByXpath (opl.displayURL);
	window();
	getURL();
	driver.close();
	parentWindow();
	assertTrue (opv.viewMoreText, opl.viewMoreLink);
    clickByXpath (opl.viewMoreLink);
    fluentWait(20, 5);
    assertTrue (opv.searchValue, opl.searchLocation);
   	}
	

@Test
public void TMP_AboutTab () throws InterruptedException{
	
	driver.get(baseURL+"/Spa/6450-a");

	clickByLink (opl.aboutLink);
	assertTrue (opv.aboutTitleValue, opl.aboutTitle);
	assertTrue (opv.aboutDescriptionValue, opl.aboutDescription);
	assertTrue (opv.aboutAcceptGCvalue, opl.aboutAcceptGC);
	assertTrue (opv.aboutImage1, opl.aboutSlideNumberText);
	clickByXpath (opl.aboutArrowLinkNext);
	Thread.sleep (2000);
	assertTrue (opv.aboutImage2, opl.aboutSlideNumberText);
	clickByXpath (opl.aboutArrowLinkPrev);
	Thread.sleep (2000);
	assertTrue (opv.aboutImage1, opl.aboutSlideNumberText);
	clickByXpath (opl.aboutReviewLink);
	fluentWait(20, 5);
	assertTrue (opv.aboutReviewValue, opl.aboutReviewAssert);
	
	
}


@Test
public void TMP_addressTab (){
	
	driver.get(baseURL+"/Spa/6450-a");
	
	clickByLink (opl.addressLink);
	fluentWait(20, 5);
	// current address
	
	// contact info link
	// contact number
	// display url
	// buy gift card text
	// buy gc button
	// hours of operation
	// video link
	// social networks
	
	
	
	
	
	
}

@Test
public void TMP_OffersTab () throws IOException{
	
	driver.get(baseURL+"/Spa/6450-a");
	clickByLink (opl.speicalOfferLink);
	assertTrue (opv.dealTitleValue, opl.dealTitle);
	clickByXpath (opl.dealPrintButton);
	assertTrue (opv.dealCouponBannerValue, opl.dealCouponBanner);
	typeByXpath (opl.Email, opv.EmailValue);
	typeByXpath (opl.Pass, opv.PassValue);
	clickByXpath (opl.loginButton);
	assertTrue (opv.dealPrintBannerValue, opl.dealPrintBanner);
	screenShot ("TMP_Coupon");
		
}

@Test
public void TMP_ServicesTab () throws InterruptedException{
	
	driver.get(baseURL+"/Spa/6450-a");
	clickByLink (opl.servicesNclassesLink);
	
	assertTrue (opv.classesValue, opl.Classes);
	assertTrue (opv.serviceValue, opl.Service);
	assertTrue (opv.pdfValue, opl.PDF);
	assertTrue (opv.meetOurStaffValue, opl.meetOurStaff);
	clickByXpath (opl.meetOurStaff);
	clickByXpath (opl.staffLightBox);
	newWindow();
	
	assertTrue (opv.staffInfoValue, opl.staffInfo);
	assertTrue (opv.staffInfoValue2, opl.staffInfo2);
	Thread.sleep(5000);
	clickByLink (opl.staffClose);
}


@Test
public void TMP_reviewTab (){
	
	driver.get(baseURL+"/Spa/6450-a");
	clickByLink (opl.reviewsLink);

	List<String> expType = new ArrayList<String>();
		expType.add(opv.value);
		expType.add(opv.value2);
		expType.add(opv.value3);
	
	for (int i=1; i<=3; i++){
		String actType = driver.findElement(By.xpath(opl.part1+i+opl.part2)).getText();
			
		boolean assertTrue 	 = expType.get(i-1).equals(actType);
			if (!assertTrue) {
			 System.err.println ("Expected: " + expType.get(i-1) + " | Actual: " + actType + " = " + assertTrue);
				 				 
		} else  { 
				System.out.println ("Expected: " + expType.get(i-1) + " | Actual: " + actType + " = " +assertTrue);
				System.out.println("");
			}
		}
	
	
	
	}
	
@Test
public void TMP_restTab (){
	
	driver.get(baseURL+"/Spa/6450-a");
	clickByLink (opl.diningLink);
	clickByLink (opl.eventsLink);
	

	
	}






}




