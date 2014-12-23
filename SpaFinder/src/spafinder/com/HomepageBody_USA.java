package spafinder.com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import spafinder.com.locator.HomePageLocator;
import spafinder.com.value.HomePageValue;

public class HomepageBody_USA extends spafinder.com.base.USABaseClass {

	 HomePageValue 		hpv = new  HomePageValue();
	 HomePageLocator	hpl = new  HomePageLocator();
	 

@Test
public void pageTitleTest (){
	driver.get(baseURL);
	System.out.println ("........ Homepage Title.........");
	assertTitle ("Massage, Yoga, Facial, Spa, Gift Cards and More - Spafinder Wellness 365");
	System.out.println ("");
	
}
	 
@Test
public void heroImageTest () throws Throwable{
	
	driver.get(baseURL);
	System.out.println ("........Hero Image.........");
	clickByXpath (hpl.leftArrowLink);
	Thread.sleep (1000);
	clickByXpath (hpl.rightArrowLink);
	Thread.sleep (1000);
	typeByXpath (hpl.iWantEditBox, hpv.FnBKWValue);
	typeByXpath (hpl.nearEditBox, hpv.FnBNearValue);
	clickByXpath (hpl.findButton);
	assertTrue(hpv.FnBKWValue, hpl.assertKeyWord); 
	assertTrue (hpv.FnBNearValue, hpl.assertLocation);
	getTextByXpath (hpl.searchResultsFoundLocatorXpath); 
	System.out.println ("");
}


@Test
public void newslettersTest() throws Throwable{
	
	driver.get(baseURL);
	System.out.println ("........Newsletters Test.........");
	AssertionByCss (hpv.NewsletterTitleValue, hpl.NewsletterAssert);
	typeByXpath (hpl.newsletterEmail, hpv.newsletterEmailValue);
	clickByXpath (hpl.newsletterSignUpButton);
	//waitTillLoad (hpl.NewsletterAssert);
	WebDriverWait wait = new WebDriverWait(driver, 5000);
	wait.until( ExpectedConditions.presenceOfElementLocated(By.cssSelector(hpl.NewsletterAssert)));
	driver.findElement(By.cssSelector(hpl.NewsletterAssert));
	
	AssertionByCss (hpv.newsletterThanksValue, hpl.NewsletterAssert);   // after successfully signed up
	clickByLink (hpl.topBrandLink);										// top brand link
	AssertionByCss (hpv.topBrandExpText, hpl.topBrandActText);
	System.out.println ("");

}

@Test 
public void wellnessLifestyleTest () throws InterruptedException{
	
	driver.get(baseURL);
//	driver.get("http://www.spafinder.com");
	System.out.println ("........Wellness Lifestyle Test.........");
	clickByLink (hpl.blogReadMoreLink1);		// Read More Links
	popUpModal ();
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByXpath (hpl.blogReadMoreLink2);
	popUpModal ();
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByXpath (hpl.blogReadMoreLink3);
	popUpModal ();
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByXpath (hpl.blogReadMoreLink4);
	popUpModal ();
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByLink (hpl.blogLoadMoreArticles); 		// read more articles after 4th one
	clickByXpath (hpl.blogReadMoreLink5);
	popUpModal ();
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByLink (hpl.blogLoadMoreArticles); 
	clickByXpath (hpl.blogReadMoreLink6);
	popUpModal ();
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByLink (hpl.blogLoadMoreArticles); 
	popUpModal ();
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByLink (hpl.blogLoadMoreArticles); 
	clickByXpath (hpl.blogReadMoreLink8);
	popUpModal ();
	clickByCss (hpl.spafinderLogoFromBlog);

	clickByXpath (hpl.blogExploreMore1);				// Explore More Links
	popUpModal ();
	assertTitle (hpv.blogExploreMoreAssert1);
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByXpath (hpl.blogExploreMore2);
	popUpModal ();
	assertTitle (hpv.blogExploreMoreAssert2);
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByXpath (hpl.blogExploreMore3);
	popUpModal ();
	assertTitle (hpv.blogExploreMoreAssert3);
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByXpath (hpl.blogExploreMore4);
	popUpModal ();
	assertTitle (hpv.blogExploreMoreAssert4);
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByLink (hpl.blogLoadMoreArticles);
	clickByXpath (hpl.blogExploreMore5);
	popUpModal ();
	assertTitle (hpv.blogExploreMoreAssert5);
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByLink (hpl.blogLoadMoreArticles);
	clickByXpath (hpl.blogExploreMore6);
	popUpModal ();
	assertTitle (hpv.blogExploreMoreAssert6);
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByLink (hpl.blogLoadMoreArticles);
	clickByXpath (hpl.blogExploreMore7);
	popUpModal ();
	assertTitle (hpv.blogExploreMoreAssert7);
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByLink (hpl.blogLoadMoreArticles);
	clickByXpath (hpl.blogExploreMore8);
	popUpModal ();
	assertTitle (hpv.blogExploreMoreAssert8);
	clickByCss (hpl.spafinderLogoFromBlog);
	clickByXpath (hpl.blogReadMoreInTheBlogLink);
	popUpModal ();
	
	assertTitle (hpv.blogHomepageTitle); // Homepage Title
	clickByCss (hpl.spafinderLogoFromBlog);
	


	
}






}