package spafinder.com.locator;



public class HomePageLocator {
	
	public String spaFinderLogoImage					= "//*[@id='trademark']/a/img";
	public String spafinderLogoFromBlog					= "img[alt=\"Spafinder Wellness 365\"]";
	public String AssertLocations						= "//*[@id='content']/div[1]/dl/dd/div/span";
	
	
	public String customerServiceLink_GlobalHeader		= "//*[@id='account']/ul/li[3]/a";
	//public String customerServiceLinkUK					= "//*[@id='account']/ul/li[4]/a";
	public String customerSeviceAssertLocator			= "//*[@id='breadcrumb-new']";
	public String csNumberAssert						= "//*[@id='content']/table/tbody/tr/td[1]/p[9]";
	
		
//  Menu Tab Links
	public String searchResults							= "//*[@id='results-found']/h1";
	public String AssertSpa								= "//*[@id='destinations4']/div/div/div[2]/h2";

// Header (Global Navigation)
	public String FindServicesLinks						= "//*[@id='menu']/ul/li[1]";
	public String subMenuFindService					= "//*[@id='menu']/ul/li[1]/ol";
	
	public String ExploreTravelLinks					= "//*[@id='menu']/ul/li[2]";
	public String subMenuExploreTravelLinks				= "//*[@id='menu']/ul/li[2]/ol";
		
	public String GetInspiredLinks						= "//*[@id='menu']/ul/li[3]";
	public String subMenuGetInspiredLinks				= "//*[@id='menu']/ul/li[3]/ol";
	
	public String ExploreTravelLinksUS					= "//*[@id='menu']/ul/li[3]";	
	public String subMenuExploreTravelLinksUS			= "//*[@id='menu']/ul/li[3]/ol";
	
	public String GetInspiredLinksUS					= "//*[@id='menu']/ul/li[4]";
	public String subMenuGetInspiredLinksUS				= "//*[@id='menu']/ul/li[4]/ol";
	
// Body (Hero Image)
	public String rightArrowLink						= "//*[@id='hero-unit']/div/a[2]";
	public String leftArrowLink							= "//*[@id='hero-unit']/div/a[1]";
	public String iWantEditBox							= "//*[@id='content-top']/div[2]/div/form/ul/li[1]/input";
	public String nearEditBox							= "//*[@id='content-top']/div[2]/div/form/ul/li[2]/input";
	public String findButton							= "//*[@id='content-top']/div[2]/div/form/ul/li[4]/button";
	public String assertKeyWord							= "//*[@id='results-found']/h1/em[1]";
	public String assertLocation						= "//*[@id='results-found']/h1/em[2]";
	public String searchResultsFoundLocatorXpath		= "//*[@id='results-found']/h1";
	
// Body (Newsletters)
	public String NewsletterAssert						= "h3.m-700";
	public String newsletterEmail						= "//*[@id='newsletter-email']";
	public String newsletterSignUpButton				= "//*[@id='newsletter-submit']";
	public String topBrandLink							= "see all featured brands";
	public String topBrandActText						= "h1";

// Body (blogs)
	public String blogReadMoreLink1						= "Read more";									// By Link Text
	public String blogReadMoreLink2						= "//*[@id='content']/section[4]/article[2]/a[2]";
	public String blogReadMoreLink3						= "//*[@id='content']/section[4]/article[2]/a[2]";
	public String blogReadMoreLink4						= "//*[@id='content']/section[4]/article[2]/a[2]";
	public String blogReadMoreLink5						= "//*[@id='content']/section[4]/article[2]/a[2]";
	public String blogReadMoreLink6						= "//*[@id='content']/section[4]/article[2]/a[2]";
	public String blogReadMoreLink7						= "//*[@id='content']/section[4]/article[2]/a[2]";
	public String blogReadMoreLink8						= "//*[@id='content']/section[4]/article[2]/a[2]";
	public String blogLoadMoreArticles 					= "Load More Articles";
	public String blogExploreMore1						= "//*[@id='content']/section[4]/article[1]/a[3]";
	public String blogExploreMore2						= "//*[@id='content']/section[4]/article[2]/a[3]";
	public String blogExploreMore3						= "//*[@id='content']/section[4]/article[3]/a[3]";
	public String blogExploreMore4						= "//*[@id='content']/section[4]/article[4]/a[3]";
	public String blogExploreMore5						= "//*[@id='content']/section[4]/div[2]/article[1]/a[3]";
	public String blogExploreMore6						= "//*[@id='content']/section[4]/div[2]/article[2]/a[3]";
	public String blogExploreMore7						= "//*[@id='content']/section[4]/div[2]/article[3]/a[3]";
	public String blogExploreMore8						= "//*[@id='content']/section[4]/div[2]/article[4]/a[3]";
	public String blogReadMoreInTheBlogLink				= "//*[@id='content']/section[4]/div[2]/span/a/span[1]";

// 	USA Footer Spafinder Links .........................................................
	// Resources
	public String footerLink							= "//*[@id='resource']/ul";
	public String trendsLink							= "//*[@id='resource']/ul/li[1]/div/a[1]";
	public String wtaLink								= "//*[@id='resource']/ul/li[1]/div/a[2]";
	public String rcaLink								= "//*[@id='resource']/ul/li[1]/div/a[3]";
	public String spaEtiquetteLink						= "//*[@id='resource']/ul/li[1]/div/a[4]";
	public String spaGlossaryLink						= "//*[@id='resource']/ul/li[1]/div/a[5]";
	// Help
	public String GC_FAQsLink							= "//*[@id='resource']/ul/li[2]/div/a[1]";
	public String customerServiceLink					= "//*[@id='resource']/ul/li[2]/div/a[2]";
	public String contactUsLink							= "//*[@id='resource']/ul/li[2]/div/a[3]";
	public String legalNoticesLink						= "//*[@id='resource']/ul/li[2]/div/a[4]";
	public String giveUs_FeedbackLink					= "//*[@id='resource']/ul/li[2]/div/a[5]";
	// Business Partners
	public String becomePartnerLink						= "//*[@id='resource']/ul/li[3]/div/a[1]";
	public String adWithUsLink							= "//*[@id='resource']/ul/li[3]/div/a[2]";
	public String affiliateProgramLink					= "//*[@id='resource']/ul/li[3]/div/a[3]";
	public String travelAgentsLink						= "//*[@id='resource']/ul/li[3]/div/a[4]";
	public String corporateWellnessLink					= "//*[@id='resource']/ul/li[3]/div/a[5]";
	// About 
	public String aboutUsLink							= "//*[@id='resource']/ul/li[4]/div/a[1]";
	public String careersLink							= "//*[@id='resource']/ul/li[4]/div/a[2]";
	public String newsroomLink							= "//*[@id='resource']/ul/li[4]/div/a[3]";
	public String siteMapLink							= "//*[@id='resource']/ul/li[4]/div/a[4]";
	public String corporateIncentivesLink				= "//*[@id='resource']/ul/li[4]/div/a[5]";
// USA Footer Assert Locator............................................................................................
	// Resources Locator
	public String trendsLocator							= "//div[@id='top-ten-header']/p";
	public String rcaLocator							= "//*[@id='destinations4']/div/div[2]/div[3]/h2";
	public String wtaLocator							= "//*[@id='destinations4']/div/div[2]/section[1]/div[2]/p/i";
	public String spaEtiquette							= "//*[@id='content']/div[2]/div[2]/h1";
	public String spaGlossary							= ".//*[@id='content']/div[2]/div[2]/h1/a";
	// Help Locators
	public String FaqLocator							= "//*[@id='page-title']";
	public String customerServiceLocator				= "//*[@id='page-title']";
	public String contactUsLocator						= "//*[@id='page-title']";
	public String LNLocator								= "//*[@id='content']/div/p";
	public String feedbackLocator						= "//*[@id='feedback']/div/div[1]/h2";
	// Business Partners Locators
	public String becomePartnerLocator					= "//*[@id='main']/div/div[1]/div/h1";
	public String adWithUsLocator						= "//*[@id='content']/div[1]/div[2]/div[1]/h2";
	public String affiliateProgramLocator				= "//*[@id='content']/div[2]/div[2]/ul/li[8]/a";
	public String travelAgentsLocator					= "//*[@id='destinations4']/div/div/section[2]/div[1]/h3";
	public String corporateWellnessLocator				= "html/body/section/h2[1]/span[1]";
	// About Locators
	public String aboutUsLocators						= "//*[@id='page-title']";
	public String careersLocators						= "//*[@id='page-title']";
	public String newsroomLocators						= "//*[@id='page-title']";
	public String siteMapLocators						= "//*[@id='sitemap']/h2";
	public String corporateIncentivesLocators			= "//*[@id='destinations4']/div/div[1]/div/h1/span[1]";

// CA Footer Links
	// Resources
	public String wellnessBlogLinkCA					= "//*[@id='resource']/ul/li[1]/div/a[1]";
	public String trendsLinkCA							= "//*[@id='resource']/ul/li[1]/div/a[2]";
	public String wtaLinkCA								= "//*[@id='resource']/ul/li[1]/div/a[3]";
	public String rcaLinkCA								= "//*[@id='resource']/ul/li[1]/div/a[4]";
	public String spaEtiquetteLinkCA					= "//*[@id='resource']/ul/li[1]/div/a[5]";
	public String spaGlossaryLinkCA						= "//*[@id='resource']/ul/li[1]/div/a[6]";
	public String topTenListLinkCA						= "//*[@id='resource']/ul/li[1]/div/a[7]";
	public String wellnessWeekLinkCA					= "//*[@id='resource']/ul/li[1]/div/a[8]";
	// Help
	public String GC_FAQsLinkCA							= "//*[@id='resource']/ul/li[2]/div/a[1]";
	public String customerServiceLinkCA					= "//*[@id='resource']/ul/li[2]/div/a[2]";
	public String contactUsLinkCA						= "//*[@id='resource']/ul/li[2]/div/a[3]";
	public String legalNoticesLinkCA					= "//*[@id='resource']/ul/li[2]/div/a[4]";
	public String giveUs_FeedbackLinkCA					= "//*[@id='resource']/ul/li[2]/div/a[5]";
	// Business Partners
	public String becomePartnerLinkCA					= "//*[@id='resource']/ul/li[3]/div/a[1]";
	public String partnerFaqsLinkCA						= "//*[@id='resource']/ul/li[3]/div/a[2]";
	public String adWithUsLinkCA						= "//*[@id='resource']/ul/li[3]/div/a[3]";
	public String affiliateProgramLinkCA				= "//*[@id='resource']/ul/li[3]/div/a[4]";
	public String travelAgentsLinkCA					= "//*[@id='resource']/ul/li[3]/div/a[5]";
	public String corporateWellnessLinkCA				= "//*[@id='resource']/ul/li[3]/div/a[6]";
	public String corporateIncentivesLinkCA				= "//*[@id='resource']/ul/li[3]/div/a[7]";
	// About 
	public String aboutUsLinkCA							= "//*[@id='resource']/ul/li[4]/div/a[1]";
	public String careersLinkCA							= "//*[@id='resource']/ul/li[4]/div/a[2]";
	public String newsroomLinkCA						= "//*[@id='resource']/ul/li[4]/div/a[3]";
	public String siteMapLinkCA							= "//*[@id='resource']/ul/li[4]/div/a[4]";
// CA Footer Assert Locator
	public String wellnessBlogLocatorCA 				= "html/body/div[2]/header[2]/div[1]/div[2]/p";
	public String topTenListLocatorCA					= "//*[@id='top-ten-slides']/h1";
	public String wellnessWeekLocatorCA					= "//*[@id='wellness-week-wrapper']/article/dl/dt/h2";
	public String travelAgentsLocatorCA					= "//*[@id='destinations4']/div/div/h1/span/span[2]";
	
// UK Footer Links ..................................................................................................................	
	// Resources
	public String trendsLinkUK							= "//*[@id='resource']/ul/li[1]/div/a[1]";
	public String wtaLinkUK								= "//*[@id='resource']/ul/li[1]/div/a[2]";
	public String rcaLinkUK								= "//*[@id='resource']/ul/li[1]/div/a[3]";
	public String spaEtiquetteLinkUK					= "//*[@id='resource']/ul/li[1]/div/a[4]";
	public String spaGlossaryLinkUK						= "//*[@id='resource']/ul/li[1]/div/a[5]";
	public String londonSpaGuideLinkUK					= "//*[@id='resource']/ul/li[1]/div/a[6]";
	public String spaBreaksLinkUK						= "//*[@id='resource']/ul/li[1]/div/a[7]";
	public String spaVouchersLinkUK						= "//*[@id='resource']/ul/li[1]/div/a[8]";
	// Help
	public String GC_FAQsLinkUK							= "//*[@id='resource']/ul/li[2]/div/a[1]";
	public String customerServiceLinkUK					= "//*[@id='resource']/ul/li[2]/div/a[2]";
	public String contactUsLinkUK						= "//*[@id='resource']/ul/li[2]/div/a[3]";
	public String legalNoticesLinkUK					= "//*[@id='resource']/ul/li[2]/div/a[4]";
	public String giveUs_FeedbackLinkUK					= "//*[@id='resource']/ul/li[2]/div/a[5]";
	// Business Partners
	public String becomePartnerLinkUK					= "//*[@id='resource']/ul/li[3]/div/a[1]";
	public String affiliateProgramLinkUK				= "//*[@id='resource']/ul/li[3]/div/a[2]";
	public String travelAgentsLinkUK					= "//*[@id='resource']/ul/li[3]/div/a[3]";
	public String corporateWellnessLinkUK				= "//*[@id='resource']/ul/li[3]/div/a[4]";
	public String topSpaBrandsLinkUK					= "//*[@id='resource']/ul/li[3]/div/a[5]";
	// About 
	public String aboutUsLinkUK							= "//*[@id='resource']/ul/li[4]/div/a[1]";
	public String careersLinkUK							= "//*[@id='resource']/ul/li[4]/div/a[2]";
	public String newsroomLinkUK						= "//*[@id='resource']/ul/li[4]/div/a[3]";
	public String siteMapLinkUK							= "//*[@id='resource']/ul/li[4]/div/a[4]";
	// UK Footer assertion Locators
	public String londonSpaGuideLocatorUK				= "//*[@id='featured-properties']/div[3]/h4";
	public String spaBreaksLocatorUK					= "//h1";
	public String spaVouchersLocatorUK					= "//*[@id='content-bottom']/div/section[1]/div/div[2]/h3";
	public String spaEtiquetteLocatorUK					= "//h1";
	public String affiliateProgramLocatorUK				= "//*[@id='content']/div[2]/div[2]/ol/li[3]/a";
	public String corporateWellnessLocatorUK			= "//*[@id='destinations4']/div/div[1]/div/h1/span[2]";
	public String topSpaBrandsLocatorUK					= "//h1";
	
	
// Subscription
	public String subscriptionEditBox					= "subscribe-email";
	public String subscriptionSubmit					= "subscribe-submit";
	public String subscriptionVerify					= "//*[@id='subscription']/div/strong";
	public String subscriptionVerifyxpath 				= "//div[2]/div/strong";
	
// CopyRight
	public String copyRightLocator						= "//*[@id='copyright']/ul/li[1]/p[1]";
		
// Social Networks	
	public String faceBook								= "a.facebook";
	public String twitter								= "a.twitter";
	public String pinterest								= "a.pinterest";
	public String google								= "a.google-plus";
	
	public String FacebookLocator						= "//*[@id='fbProfileCover']/div[2]/div[1]/h2/span[1]";
	public String TwitterLocator						= "//div[@class='profile-card-inner']/h1[@class='fullname editable-group']//span";
	public String PinterestLocator						= "html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]/h1";
	public String GoogleLocator							= "//*[@id='contentPane']/div/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div/div/span/a";
		
	
}