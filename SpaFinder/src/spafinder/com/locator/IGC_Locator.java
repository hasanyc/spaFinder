package spafinder.com.locator;

public class IGC_Locator {

	public String ukCookiesPolicyCancle				= "//*[@id='e-privacy-directive']/a[2]";
	
// LogIn My Account Link
	public String MyAccountLink						= "//*[@id='account']/ul/li[2]/a";
	public String logInLinkByText					= "My Account";
	public String logInEmail						= "//*[@id='email']";
	public String logInPassword						= "//*[@id='password']";
	public String logInClickButton					= "//*[@id='log-in-form']/ul/li[3]/button";

// Main Navigation Button from Home page
	public String GiftCardNav						= "//*[@id='menu']/ul/li[5]/a";
	public String GiftCardNavUK						= "//*[@id='menu']/ul/li[4]/a"; // for UK and CA
	
// Sub menu button from Mouse Hover
	public String IGC_SubMenuButton					= "//*[@id='menu']/ul/li[5]/ol/li[2]/a[1]"; // for USA
	public String IGC_SubMenuButtonUK				= "//*[@id='menu']/ul/li[4]/ol/li[2]/a[1]"; // For UK AND CA
	
// Step 1 (Theme picker page for EMAIL)
	public String theme								= ".//*[@id='igcTheme0']/section/ul/li[1]/a/img";
	public String deliveryEmailAddress				= "//*[@id='instantGCInfoList[0].recipientEmail']";
	public String PersonalizeIt						= "//*[@id='instantGCWizardCommand']/div/div/div/div[4]"; // for USA & CA
	public String PersonalizeItUK					= "//*[@id='instantGCWizardCommand']/div/div/div/div[5]"; // For UK Only
	public String from								= "//*[@id='instantGCInfoList[0].senderName']";
	public String to								= "//*[@id='instantGCInfoList[0].recipientName']";
	public String messgeBox							= "//*[@id='instantGCInfoList[0].message']";
	public String continueButtonInStep1UK			= "//*[@id='instantGCWizardCommand']/div/div/div/div[7]/div/button"; //UK only		
	public String ProceedToCheckout					= "//button[@name='_target1']";
	
	
// Step 1 (PRINT)
	public String Print_PersonalizeIt				= "//*[@id='instantGCWizardCommand']/div/div/div/div[3]";
	public String print_VerifyText					= "//*[@id='certificates']/h2";
	public String print_PrintCardButton				= "//*[@id='certificates']/div/ul/li[1]/a";
	public String print_VerifyNewTabText			= "//*[@id='information']/dt/p[1]";
	public String printNowButton					= "//*[@id='content']/a";
	

// For Additional Card 2
	public String addAnotherCardLink				= "Add Another Card";
	public String addAnotherVoucherLink				= "Add Another Voucher";
	public String theme2							= "//*[@id='igcTheme1']/section/ul/li[4]/a/img";
	public String deliveryEmailAddress2				= "//*[@id='instantGCInfoList[1].recipientEmail']";
	public String PersonalizeIt2					= "//*[@id='instantGCWizardCommand']/div[2]/div/div/div[5]";
	public String Print_PersonalizeIt2				= "//*[@id='instantGCWizardCommand']/div[2]/div/div/div[4]";
	public String PersonalizeItUK2					= "//*[@id='instantGCWizardCommand']/div[2]/div/div/div[6]";
	public String from2								= "//*[@id='instantGCInfoList[1].senderName']";
	public String to2								= "//*[@id='instantGCInfoList[1].recipientName']";
	public String messgeBox2						= "//*[@id='instantGCInfoList[1].message']";
	public String image2							= "//*[@id='igcTheme1']/section/ul/li[2]/a/img";
	public String assertCard2						= "//*[@id='overview']/h4[2]";
	public String ProceedToCheckout2				= "(//button[@name='_target1'])[2]";
	
	
// Step 2 (Guest option)
	public String guestButton						= "//*[@id='submitGuestLogin']";
	
// Step 2 (Already Member Option)
	public String alreadyMemberLoginLink			= "//*[@id='login-toggle']";
	public String emailMember						= "//*[@id='email-login']"	;
	public String PasswordMember					= "//*[@id='password-login']";
	public String signInCheckoutButton				= "//*[@id='submitLogin']";
	public String securityCodeMember				= "//*[@id='card-cvv']";
	
	
// Step 2 (Billing Info for Guest)
	public String FirstName							= "//*[@id='first-name']";
	public String LastName							= "//*[@id='last-name']";
	public String email								= "//*[@id='email']";
	public String address							= "//*[@id='address-1']";
	public String city								= "//*[@id='city']";
	public String zipCode							= "//*[@id='zip-code']";
	public String phoneNumber						= "//*[@id='phone']";
	
	
//....................................................................................................................
	
	public String cardNumber						= "//*[@id='card-number']";
	public String securityCode						= "//*[@id='card-security-code']";
	public String expMM								= "//*[@id='userMonth']";
	public String expYY								= "//*[@id='userYear']";
	public String CompleteYourOderButton			= "//*[@id='overview']/button";
	
// Confirmation Page
	public String orderNumber						= "//*[@id='order-main']/h1";
	public String Amount							= "//*[@id='certificates']/div/ul/li[4]";
	public String totalPrice						= "//*[@id='order-details']";
	
	
	
// Promo Code and Flyer Miles
	
	//public String promoLinkXpath					= "//*[@id='promo-roll']/a";
	public String promoEditBoxId					= "promo-code" ;
	public String promoApplyButtonId				= "submit-promo-code";
	public String promoTextCss						= "dt.overview-promo";
	public String promoDiscountXpath 				= "//div[@id='overview']/dl[@class='clear']/dd[@class='overview-promo']";
	
	public String airLineRadioButton				= "//div[@id='promo-code-area']/div[2]/ul/li/label";
	public String airLineLinkText					= "Select Carrier or Program";
	public String airLineDropDownList				= "//li[2]/div/ul/li[2]";
	public String airlineEditBoxLocator				= "memberProgramCode";
	public String airlineSubmitButton				= "//*[@id='billing-form']/fieldset[4]/button";
	
	
// UK 3D Visa Secure
	
	public String Uk3dVisaTagName					= "iframe";
	public String Uk3dVisaPassword					= "//input[@type='password']";
	public String Uk3dVisaSubmitButton				= "//input[@type='submit']";
	public String UkVisaVerifiedText				= "//tr[3]/td/font";

// DropDowns
	public String amountId							= "instantGCInfoList[0].amount";
	public String countryBoxId						= "countryBoxId";
	public String stateBoxById						= "stateBoxId";
	public String airLineDropDownMenu				= "memberProgramId";
	
// Back Office
	
	public String adminUserName						= "//input[@id='j_username']";
	public String adminUserPass						= "//input[@id='j_password']"; 
	public String adminSubmitButton					= "//button[@id='SF_submit']";
	
	public String gcNumber							= "//*[@id='formId']/table/tbody/tr[4]/td[2]";
	public String gcNumber2							= "(//form[@id='formId']/table/tbody/tr[4]/td[2])[2]";
	public String gcValue							= "//*[@id='formId']/table/tbody/tr[8]/td[2]";
	public String gcValue2							= "(//form[@id='formId']/table/tbody/tr[8]/td[2])[2]";
	
	
}
