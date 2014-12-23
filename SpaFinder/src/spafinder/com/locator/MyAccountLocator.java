package spafinder.com.locator;

public class MyAccountLocator {
	
// Frame, window and lightbox
	public String iFrameXpath						= "//*[@id='login-signup-dialog']/iframe"; // Log in
	public String addressiFrame						= "//div[@class='lv_content_wrapper lv_content_dark']/iframe[@class='lv_content_iframe']";
	public String updateProfileIframe				= "//div[@class='lv_content_wrapper lv_content_dark']";
	
// Log In
	public String logInLinkByText					= "My Account";
	public String emailById							= "email";
	public String passwordById						= "password";
	
// Side Rail Links
	public String overviewLinkText					= "Overview";
	public String rewardsLinkText					= "Rewards";
	public String ordersLinkText					= "Orders";
	public String bookingsLinkText					= "Bookings";
	public String creditCardsLinkText				= "Credit Cards";
	public String addressBookLinkText				= "Address Book";
	public String profileSettingsLinkText			= "Profile Settings";
	public String logOutLinkText					= "Log Out";
	
// Side Rail Assert Locator
	public String headerAssert						= "//*[@id='welcome']/p";
	public String headerAssert2						= "//*[@id='content']/div[1]/div";

// Add an Address
	public String fnByName							= "first_name";
	public String lnByName							= "last_name";
	public String countryById						= "country";
	public String addressByName						= "address";
	public String address2ByName					= "address2";
	public String cityByName						= "city";
	public String stateById 						= "stateLabel";
	public String zipcodeByName						= "postal_code";
	public String phoneByName 						= "phone";

// Add Credit Card
	public String ccFirstNameById					= "fname";
	public String ccLastNameById					= "lname";
	public String ccCountryById						= "country";
	public String ccAddressById						= "address1";
	public String ccAddress2ById					= "address2";
	public String ccCityById						= "city";
	public String ccStateById						= "stateLabel";
	public String ccZip								= "zipcode";
	public String ccPhone							= "phone";
	public String ccCardNumber						= "cardnumber";
	public String ccCVV								= "cvv";
	public String ccExpireMonth						= "expireMonth";
	public String ccExpireYY						= "expireYear";
	
	
// Profile Setting tab
	public String selectAllBoxById					= "selectAll";
	public String thankYouMsgByXpath				= "//*[@id='email-preferences']/div[1]";
	public String wellnessCheckboxByName			= "wellness";
	public String partnerCheckboxByName				= "partner";
	public String lmCheckboxByName					= "spaFinderNow";
	public String updateProfileLinkText 			= "Update Profile";
	
// Sign UP New Account
	public String signUpFName						= "//*[@id='first-name']";
	public String signUpLName						= "//*[@id='last-name']";
	public String signUpEmail						= "//*[@id='register-email']";
	public String signUpPass						= "//*[@id='register-password']";
	public String signUpRePass						= "//*[@id='confirm-password']";
	public String alreadyTaken						= "//*[@id='statusMessage']/div";
	public String nameAssert 						= "//*[@id='content']/div[4]/ul/li[1]/a";
	public String eMailAssert						= "//*[@id='content']/div[4]/ul/li[1]/div/ul/li[2]";

// Buttons
	public String ccAddCardButtonByXpath			= "//div[@class='left item-wrapper item-wrapper-cards clear']/ul[@class='clear']/li[@class='add-card left']/a[@class='lightview']//span[@class='medium blue button']";
	public String ccSaveCardButtonById				= "save-card-button";
	public String signUpButtonByName				= "submit";
	public String submitButtonByXpath 				= "//button[@type='submit']";
	public String logInButtonByName					= "submit";
	public String saveEmailButtonByCss				= "button.blue.medium";
	public String addAnAdressButtonByLink			= "Add an Address";

	
	

}
