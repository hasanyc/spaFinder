package spafinder.com.locator;

public class SearchBoxLocator {
	
	public String homepageLogo							= "//*[@id='trademark']/a/img";
	
	public String searchKeywordBoxLocatorXpath 			= "(//input[@name='keywords'])[4]";
	public String searchLocationBoxLocatorXpath 		= "(//input[@name='location'])[4]";
	public String searchButtonClickXpath 				= "(//button[@type='submit'])[4]";
	
	public String searchResultsFoundLocatorXpath		 = "//*[@id='results-found']/h1";
	public String searchingDistance						= "//*[@id='spa']/ul";
	
	public String assertKeyWord							= "//*[@id='results-found']/h1/em[1]";
	public String assertLocation						= "//*[@id='results-found']/h1/em[2]";
	
	public String acceptGCBoxFromHomePage				= "//div/div/div/form/ul/li[3]/label/span";
	
	
// Re search from Search results page
	public String reSearchKey							= "(//input[@name='keywords'])[4]";
	public String reSearchLoc							= "(//input[@name='location'])[4]";
	public String findButton							= "(//button[@type='submit'])[4]";
	
	
		
	
// Filters
	public String acceptGCcheckBox						= "//li[@id='accepts-gift-certificates']/label/span";
	public String onlineBookingCheckBox					= "//li[@id='online-booking']/label/span";
	public String dealsAndPromoCheckBox					= "//li[@id='deals-promotions']/label/span";
	public String upcomingEventsCheckBox				= "//li[@id='upcoming-events']/label/span";

	public String verifyAcceptGC						= "//ul[@class='popular-refinements']/li[@id='accepts-gift-certificates']/label[@for='50001']/span[@class='custom checkbox checked']";
	public String verifyOnlineBooking					= "//ul[@class='popular-refinements']/li[@id='online-booking']/label[@for='50010']/span[@class='custom checkbox checked']";
	public String verifyDealsAndPromo					= "//ul[@class='popular-refinements']/li[@id='deals-promotions']/label[@for='30']/span[@class='custom checkbox checked']";
	public String verifyUpcomingEvent					= "//ul[@class='popular-refinements']/li[@id='upcoming-events']/label[@for='51043']/span[@class='custom checkbox checked']"; 
	
	
// SortBy
	public String ratingByLink							= "Rating";
	public String distanceByLink						= "Distance";
	public String relevanceByLink						= "Relevance";

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
