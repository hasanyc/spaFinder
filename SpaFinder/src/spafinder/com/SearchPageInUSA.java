package spafinder.com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import spafinder.com.locator.SearchBoxLocator;
import spafinder.com.value.SearchBoxValue;

public class SearchPageInUSA extends spafinder.com.base.USABaseClass {

	SearchBoxLocator sbl = new SearchBoxLocator ();
	SearchBoxValue sbv = new SearchBoxValue();
	

@Test (priority  = 0)
public void filterCheckBoxTest (){
	
	driver.get(baseURL);
	System.out.println ("Testing Filter CheckBox :........................");
	typeByXpath (sbl.searchKeywordBoxLocatorXpath, sbv.searchKeywordSpa);    // SPA
	typeByXpath (sbl.searchLocationBoxLocatorXpath, sbv.searchLocation10010); // NY ZIP Code 10010
	clickByXpath (sbl.findButton);
	
	clickByXpath (sbl.acceptGCcheckBox);
	verifyCheckBox (sbl.verifyAcceptGC);
	clickByXpath (sbl.onlineBookingCheckBox);
	verifyCheckBox (sbl.verifyOnlineBooking);
	clickByXpath (sbl.dealsAndPromoCheckBox);
	verifyCheckBox (sbl.verifyDealsAndPromo);
	clickByXpath (sbl.upcomingEventsCheckBox);
	verifyCheckBox (sbl.verifyUpcomingEvent);

}


@Test (priority  = 1)
public void sortByTest () throws Exception{
	
	driver.get(baseURL);
	System.out.println ("Testing Sort By Links :.................");
	typeByXpath (sbl.searchKeywordBoxLocatorXpath, sbv.searchKeywordSpa);    // SPA
	typeByXpath (sbl.searchLocationBoxLocatorXpath, sbv.searchLocation10010); // NY ZIP Code 10010
	clickByXpath (sbl.searchButtonClickXpath);
	clickByLink (sbl.ratingByLink);
	}

@Test (priority  = 2)
public void PaginationTest () throws InterruptedException{
	
	driver.get(baseURL);
	System.out.println ("Testing PaginationLink :........................");

	typeByXpath (sbl.searchKeywordBoxLocatorXpath, "spa");    // SPA
	typeByXpath (sbl.searchLocationBoxLocatorXpath, "11417"); // NY ZIP Code 10010
	clickByXpath (sbl.searchButtonClickXpath); // Find button
	
	boolean 	nextButton		= driver.findElements(By.xpath(".//*[@id='content-top-navigation']/div[2]/div/a")).size() != 0;
	String 		pageCount 		= driver.findElement(By.xpath(".//*[@id='content-top-navigation']/div[2]/span")).getText();
	
	if (!nextButton){
		System.out.println ("There is only one page in this page:" + pageCount);
		
	} else {
		System.out.println ( pageCount + " Now Automation script going to verify the next Arrow Link." );
		driver.findElement(By.cssSelector("a.pagination-next")).click();
		Thread.sleep(3000);
		
		String page2 = driver.findElement(By.cssSelector("div.pagination.top-pagination > span")).getText();
		Pattern p = Pattern.compile("Page 2"); // period will print any char. Ex: $, € etc
		Matcher m = p.matcher(page2);
	    
	    boolean b = m.find();
	    if (b)
	    {
	    	String pageTwo = m.group();
	    	System.out.println ("Actual is = Page 2 and expected is = " + pageTwo);
	    }
	    System.err.println ("__________________________________________________");
	}
}

}




