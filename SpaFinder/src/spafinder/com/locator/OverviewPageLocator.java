package spafinder.com.locator;

public class OverviewPageLocator {
	
	public String iFrameTagName					= "iframe"; // emailUs 
	
// Hero Wrapper
	public String heroTitle						= "//div[@class='hero-wrapper']/h1[@class='hero-title']//span";
	public String tout							= "//div[@class='hero-wrapper']/h1[@class='hero-title']//p";
	public String displayURL					= "//div[@class='hero-visit-website']//a[@class='visit clear']//span";
	public String viewMoreLink					= "//*[@id='getaway-hero-wrapper']/div[2]/div[1]/a";
	public String searchLocation				= "//*[@id='results-found']/h1/em[1]";

// Tabs Links
	public String aboutLink						= "About";
	public String addressLink					= "Address & Info";
	public String speicalOfferLink				= "Special Offers";
	public String servicesNclassesLink			= "Services & Classes";
	public String reviewsLink					= "Reviews";
	public String diningLink					= "Dining & Facilities";
	public String eventsLink					= "Events";
	
	
// About Tab
	public String aboutTitle					= "//div[@class='property-description columns']//h3";
	public String aboutDescription				= "//div[@class='ellipsis']//p";
	public String aboutAcceptGC					= "//div[@class='gift-cards-text']";
	public String aboutArrowLinkNext			= "//a[@class='orbit-next']";
	public String aboutArrowLinkPrev			= "//a[@class='orbit-prev']";
	public String aboutSlideNumberText			= "//div[@class='orbit-slide-number']";
	public String aboutReviewLink				= "//a[@href='#reviews']//span";
	public String aboutReviewAssert				= "//div[@class='property-review-item-text description']";

	
// Address and Info tab
	
	
	
	
	
	
	
// Special Offers Tab
	public String dealTitle						= "//div[@class='property-deals-title']/span[@class='property-deals-titleText']";
	public String dealPrintButton				= "//button[@class='large button blue deal-button']";
	public String dealCouponBanner				= "//div[@class='coupon']/div[@class='coupon-content']//h1";
	public String Email							= "//input[@id='email']";
	public String Pass							= "//input[@id='password']";
	public String loginButton					= "//button[@type='submit']";
	public String dealPrintBanner				= "//article[@id='content']/aside";
	public String dealPrintCoupon				= "//button[@id='print-button']";
	
// Services & Classes Tab
	public String Classes 						= "//*[@id='view-services']/div[4]/div/div/div";
	public String Service 						= "//*[@id='view-services']/div[3]/div[1]/div/div/div";
	public String PDF							= "//div[@class='property-menu-link']/a[@class='modal-opener pdf-open']/span[@class='property-menu-linkA']";
	public String meetOurStaff					= "//div[@class='property-overview-modalLinks tmp-staff-link']/a[@class='modal-opener']";
	public String staffLightBox					= "//div[@id='view-staff']";
	public String staffInfo						= "//*[@id='view-staff']/div[2]/div/div[1]/div/p[1]";
	public String staffInfo2					= ".//*[@id='view-staff']/div[2]/div/div[1]/div/p[2]";
	public String staffClose					= "×";
	
	
// Review tabs
	public String reviewsTitle					= "//*[@id='tabs']/section[5]/div[2]/div[1]/div/div[1]/h3";
	public String part1 						= "//*[@id='view-reviews']/div[1]/div[2]/div["; 
	public String part2							= "]";
	
	
	
	
	

	
}
