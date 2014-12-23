package spafinder.com.locator;

public class OnlineBookingLocator {

	public String ukCookiesPolicyCancle						= "//*[@id='e-privacy-directive']/a[2]";
	
	public String MboPriceLocator							= "//div[@class='large-1 columns']";
	public String MboButtonsLocator							= "//div[@class='large-3 columns']/a[@class='button blue small right']";
	
// Already Customer:
	public String OnlineBookingclickHereToLogIn 			= ".//*[@id='click-to-login']";
	public String OnlineBookingemailAddress					= "//*[@id='email-login']";
	public String OnlineBookingpassword						= "//*[@id='password-login']";
	public String OnlineBookinglogin						= "//*[@id='submit-login']";
	
	
// New Customers
	public String OnlineBookingNewCustomerFName				= "//*[@id='first-name']";
	public String OnlineBookingNewCustomerLName				= "//*[@id='last-name']";
	public String OnlineBookingNewCustomerEmail				= "//*[@id='email']";
	public String OnlineBookingNewCustomerPassword			= "//*[@id='password']";
	public String OnlineBookingNewCustomerRetypePassword	= "//*[@id='confirm-password']";
	public String OnlineBookingNewCustomerZipCode			= "//*[@id='zip-code']";
	public String OnlineBookingNewCustomerRegisterLink		= "//*[@id='submit-register']";
	
	
// OnlineBooking Personal info 
	public String onlineBookingFirstName					= "//*[@id='FirstName']";
	public String onlineBookingLastName						= "//*[@id='LastName']";
	public String onlineBookingEmail						= ".//*[@id='email']";
	public String onlineBookingCountry						= ".//*[@id='billing-address']/ul/li[4]/div/a[1]";
	public String onlineBookingCountryUSA					= ".//*[@id='billing-address']/ul/li[4]/div/ul/li[1]";
	public String onlineBookingStreetAddress				= "//*[@id='card-address']";
	public String onlineBookingCity							= "//*[@id='card-city']";
	public String onlineBookingState						= ".//*[@id='card-state-container']/div/a[1]";
	public String onlineBookingStateNY						= ".//*[@id='card-state-container']/div/ul/li[34]";
	public String onlineBookingZipCode						= "//*[@id='ZipCode']";
	public String onlineBookingPhoneNumber					= "//*[@id='PhoneNumber']";
	public String onlineBookingCardNumber					= "//*[@id='CreditCardNumber']";
	public String onlineBookingSecurityCode					= "//*[@id='SecurityCode']";
	public String OnlineBookingExpMM						= "//*[@id='ExpirationMonth']";
	public String OnlineBookingExpYY						= "//*[@id='ExpirationYear']";
	public String onlineBookingCancellationPolicy			= ".//*[@id='checkBoxParent']/span[1]";
	public String onlineBookingCompleYourBookingLink		= ".//*[@id='form-footer']/p[2]/button";

	// UK Online Booking
	
	public String countryLinkText							= "United Kingdom";

	
// Confirmation Page
	
	
	public String orderNumber								= "//*[@id='content']/h2";
	public String totalPrice								= "//*[@id='content']/ul/li[1]/div/ul/li[3]";
// ...................................... G1 .............................................................................................
	
	public String gOnePriceLocator							= "//div[@class='large-1 small-3 columns']";
	public String gOneButtonsLocator						= "//div[@class='large-3 small-5 columns']/a[@class='button blue small right property-services-link']";
	public String TwoWksButton								= "//*[@id='no-times-in2wks']/button";
	public String hoursLink									= "//*[@id='content']/div/ul/li[1]/a/span";
	public String verifyAppt								= ".//*[@id='selected-time-day-wrap']";
	public String G1BillingLink								= "//*[@id='billing-button']";

	
// GIFT CARD......................................
	
	public String OnlinebookingGiftCardTab					= "//*[@id='use-gift-card']";
	public String OnlinebookingGCNumber						= "//*[@id='GiftCardNumber']";
	public String OnlinebookingGCDropDown					= ".//*[@id='choose-card']/li[2]/div/a[1]";
	public String onlineBookingGCValue						= ".//*[@id='choose-card']/li[2]/div/ul/li[2]";
	public String onlineBookingGCValueUK					= ".//*[@id='choose-card']/li[2]/div/ul/li[3]";
	
	
	
	
}
