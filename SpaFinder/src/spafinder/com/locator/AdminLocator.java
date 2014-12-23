package spafinder.com.locator;

public class AdminLocator {

// User name and Password
	public String adminUserAssert			= ".//*[@id='SF_row_bottom']/form/label[1]";
	public String adminUserName 			=	".//*[@id='SF_row_bottom']/form/input[1]";
	
	public String adminPassAssert			= ".//*[@id='SF_row_bottom']/form/label[2]";
	public String adminPass					=	".//*[@id='SF_row_bottom']/form/input[2]";
	public String adminSubmitLink			= 	".//*[@id='SF_submit']";

// Creating new Business
	public String NewDashBoard				= ".//*[@id='SF_header']/ul/li[1]/a";
	public String PartnerAuditing			= ".//*[@id='SF_tower_left']/a[2]";
	public String CreateNewBusiness			= ".//*[@id='createNewBusinessButton']";
	
// User Information Page:
	public String BusinessFName				= ".//*[@id='partnerUser.firstName']";
	public String BusinessLname				= ".//*[@id='partnerUser.lastName']";
	public String BusinessPostion			= ".//*[@id='partnerUser.title']";
	public String BusinessEmail				= ".//*[@id='partnerUser.email']";
	public String BusinessPhone				= ".//*[@id='partnerUser.phoneNumber']";
	public String BusinessPassword			= ".//*[@id='partnerUser.strPassword']";
	public String BusinessConfirmPassword	= ".//*[@id='confirmPassword']";
	public String BusinessNextLink			= ".//*[@id='next']";
	
// Business Info:
	public String SpaName					= ".//*[@id='spa.name']";
	public String SpaPhone					= ".//*[@id='businessPhone']";
	public String SpaEmail					= ".//*[@id='businessEmail']";
	public String SpaType					= ".//*[@id='listingTypeSelector']"; 	// drop down
	public String SpaAddress				= ".//*[@id='spaAddress.address1']";
	public String SpaCountry				= ".//*[@id='countrySelector']"; 		// drop down
	public String SpaState					= ".//*[@id='stateSelector']";  		// Drop down
	public String SpaCity					= ".//*[@id='locFor']";
	public String SpaZipCode				= ".//*[@id='spaAddress.postalCode']";   
	public String createSpaLink				= ".//*[@id='actionButton']";          
	

	public String spaWebsite				= ".//*[@id='webSiteForTracking']";
	public String spaDescriptionIFrame		= "html body div#page div#main div.wrapper div#content div.wrapper div.info_form form#businessInfoCommand ul span#businessinfo_part li.cl div.fieldValue span#descriptionBasicId_parent.mceEditor table#descriptionBasicId_tbl.mceLayout tbody tr td.mceIframeContainer iframe#descriptionBasicId_ifr";
	public String Description				= "mceContentBody";
	
// Business Hours
	public String spaMonday					= ".//*[@id='daysMapMONDAY.enabledDay1']";
	public String spaMondayStart			= ".//*[@id='daysMapMONDAY.startDate']";
	public String spaMondayEnd				= ".//*[@id='daysMapMONDAY.endDate']";
	
	public String spaTuesday				= ".//*[@id='daysMapTUESDAY.enabledDay1']";
	public String spaTuesdayStart			= ".//*[@id='daysMapTUESDAY.startDate']";
	public String spaTuesdayEnd				= ".//*[@id='daysMapTUESDAY.endDate']";
	public String spaTuesdayNone			= ".//*[@id='daysMapTUESDAY.spaBreakHours.enabled1']";
	public String spaTuesdayBreakStart		= ".//*[@id='daysMapTUESDAY.spaBreakHours.startDate']";
	public String spaTuesdayBreakEnds		= ".//*[@id='daysMapTUESDAY.spaBreakHours.endDate']";
	
	public String spaWednesday				= ".//*[@id='daysMapWEDNESDAY.enabledDay1']";
	public String saveAllChangesLink		= ".//*[@id='next']";
	

	
// SpaFinder Admin
	public String spaFinderAdiminNaviLink	= ".//*[@id='main']/div[2]/div[1]/ul/li[7]/span/a";
	public String adminNaviLinkAfterPro		= ".//*[@id='main']/div[2]/div[1]/ul/li[12]/span/a";
	public String selectProfessional		= ".//*[@id='enhance']";
	public String active					= ".//*[@id='active1']" ;
	
// Images and Video:
	public String spaImagesNaviLink			= ".//*[@id='main']/div[2]/div[1]/ul/li[2]/span/a";
	public String spaAddImages				= ".//*[@id='SWFUpload_1']";
	
// Services 
	public String servicesNaviLink			=".//*[@id='main']/div[2]/div[1]/ul/li[4]/span/a";
	public String servicePDF				= ".//*[@id='SWFUpload_0']";
	public String bodyScrubs				= ".//*[@id='tsection1']";
	public String saltScrubs				= ".//*[@id='spaServices3']";
	public String boydWraps					= ".//*[@id='tsection2']";
	public String clayWrap					= ".//*[@id='spaServices12']";
	public String massages					= ".//*[@id='tsection3']";
	public String otherMassages				= ".//*[@id='spaServices45']";
	public String fitness					= ".//*[@id='class_section1']";
	public String personalTraining			= ".//*[@id='spaSpaClasses7']";
	public String saveServicesLink			= ".//*[@id='saveButton_classes']";
	
	
//Facilities and Amenities
	public String facilitesNaviLink			= ".//*[@id='main']/div[2]/div[1]/ul/li[5]/span/a";
	public String facilites					= ".//*[@id='class_section0']";
	public String showersFacilites			= ".//*[@id='checkedFacilitiesAndAmenitiesId14']";
	public String amenities					= ".//*[@id='class_section1']";
	public String foodAndDrinkAmenities		= ".//*[@id='checkedFacilitiesAndAmenitiesId40']";
	public String saveFacilites				= ".//*[@id='saveButton']";
	
	
// Deals Link
	public String dealsNaviLink				= ".//*[@id='main']/div[2]/div[1]/ul/li[7]/span/a";
	public String addNewDeal				= ".//*[@id='addDealButton']";
	public String dealTitle					= ".//*[@id='dealTitle']";
	public String dealDescriptionIFrame		= "html body div#page div#main div.wrapper div#content div.wrapper div.info_form form#dealsList div#addDealForm.addDealForm ul.clear li.formLine span#dealDescription_parent.mceEditor table#dealDescription_tbl.mceLayout tbody tr td.mceIframeContainer iframe#dealDescription_ifr";
	public String dealDescription 			= ".//*[@id='content']";
	public String offerAvailable			= ".//*[@id='bookingStartDate']";
	public String offerEnds					= ".//*[@id='bookingEndDate']";
	public String customerStart				= ".//*[@id='startDate']";
	public String customerEnd				= ".//*[@id='endDate']";
	public String saveDeals					= ".//*[@id='_submit']";
	
	
	
	
	
	
	
	
}
