package spafinder.com.locator;


public class Classic_Locator {
	
	public String ukCookiesPolicyCancle			= "//*[@id='e-privacy-directive']/a[2]";
	public String GiftCardNav					= "//*[@id='menu']/ul/li[5]/a";
	public String Classic_subMenu				= "//*[@id='menu']/ul/li[5]/ol/li[2]/a[2]";
	public String GiftCardNavUK					= "//*[@id='menu']/ul/li[4]/a";
	public String Classic_subMenuUK				= "//*[@id='menu']/ul/li[4]/ol/li[2]/a[2]";

	
// LogIn My Account Link
	public String MyAccountLink					= "//*[@id='account']/ul/li[2]/a";
	public String logInEmail					= "//*[@id='email']";
	public String logInPassword					= "//*[@id='password']";
	public String logInClickButton				= "//*[@id='log-in-form']/ul/li[3]/button";
	
	public String addToCart_ButtonUK			= "//*[@id='SF_shop_form']/div/button";
	public String addToCart_ButtonUSA			= "//*[@id='SF_shop_form']/ul/li[3]/button";
	
// Personalize Step 1 (Card 1)
	public String writePersonalNote				= "//*[@id='order-0']/div/ul/li/div[1]/a";
	public String recipientName					= "//*[@id='to-0']";
	public String senderName					= "//*[@id='from-0']";
	public String personalMessage				= "//*[@id='message-0-1']";
	public String personalize_Button			= "//*[@id='overview']/div[3]/button";
	
// Personalize Step 1 (Card 2)
	public String continueShoppingLinkText		= "Continue Shopping";
	public String add2ndCardCss					= "button.green.xlarge";
	public String writePersonalNote2			= "//*[@id='order-0']/div/ul/li[2]/div[1]/a";
	public String recipientName2				= "//*[@id='to-1']";
	public String senderName2					= "//*[@id='from-1']";
	public String personalMessage2				= "//*[@id='message-1-1']";
	public String personalize_Button2			= "//*[@id='overview']/div[4]/button";

		
// Shipping Page
	public String firstName						= "//*[@id='first-name']";
	public String lastName						= "//*[@id='last-name']";
	public String Address						= "//*[@id='address1']";
	public String city							= "//*[@id='city']";
	public String zipCode						= "//*[@id='zip-code']";
	
	public String billingInfo_Button			= "//*[@id='shipping']/fieldset[1]/button";
	public String BillingInfoGuest_UK			= "//*[@id='shipping']/div[3]/button"; // Shipping page using UK Guest
	public String BillingInfoMember_UK			= "//*[@id='shipping']/fieldset[1]/button";

// Billing Page
	public String billingAsShipping				= "//*[@id='billing']/fieldset[1]/div/p/span";
	public String ukBillingAsShipping			= "//*[@id='main-content']/fieldset[1]/div/p/span";
	public String phoneNumber					= "//*[@id='phone']";
	public String email							= "//*[@id='email']";
	public String stateInBllingPage				= "//*[@id='state-province']/div/a[1]";
	public String stateNYinBillingPage			= "//*[@id='state-province']/div/ul/li[34]";
	public String cardNumber					= "//*[@id='card-number']";
	public String sercurityCodes				= "//*[@id='card-security-codes']";
	public String cvv							= "//*[@id='card_cvv']";
	public String expMM							= "//*[@id='card-expiry-month']";
	public String expYY							= "//*[@id='card-expiry-year']";
	public String unCheckBox					= "li.checkbox > span.custom.checkbox";
	
	public String checkOutButton				= "//button[@type='submit']";
	public String completeYourOderButton_US		= "//*[@id='overview']/ul[2]/li[3]/button";
	public String placeOrderButton_UK			= "//*[@id='main-content']/div[3]/div[2]/div/button"; // in Billing page using UK Guest
	
// Billing page
	public String TotalAmountinBillingPage		= "//*[@id='overview']/dl/dd[3]";
	
// Promo code
	//public String promoLinkXpath				= ".//*[@id='promo-roll']/a";
	public String promoEditBoxId				= "promoCode" ;
	public String promoApplyButtonId			= "submit-promotion-code";
	public String promoTextCss					= "span.overview-label.promo-color";
	public String promoDiscountXpath 			= "//*[@id='overview']/div[2]/span[4]";
	public String promoDiscountXpath2			= "//*[@id='overview']/div[3]/span[4]";// for card 2
	public String promoShippingButton_UK		= "//*[@id='overview']/ul/li[2]/dl/dt[5]/button";
	public String promoShippingButton_UKUser	= "//*[@id='overview']/ul/li[3]/dl/dt[5]/button";
	public String airLineRadioButton			= "//ul[2]/li/span";
	public String airlineEditBoxLocator			= "memberProgramCode";
	
	
// Confirmation Page
	public String orderNumber					= "//*[@id='content']/h2";
	public String UKorderNumber					= "//*[@id='content']/h2";
	public String totalPrice					= "//li[@class='details-total clear']//strong/span[@class='val']"; // custom xpath
	public String cardType						= "//*[@id='content']/div[2]/div[1]/div[3]/ul/li[3]";
	
	
// UK 3D Visa Secure
	public String Uk3dVisaTagName				= "iframe";
	public String Uk3dVisaPassword				= "//input[@type='password']";
	public String Uk3dVisaSubmitButton			= "//input[@type='submit']";
	public String UkVisaVerifiedText			= "//tr[3]/td/font";

// CA Classic Express Shipping Method
	public String caExpressRadioButton			= "//*[@id='order-0']/ul[1]/li[2]/span";
	public String caExpressFeeVerify			= "//*[@id='shippingCost']";
	
// DropdownMenu
	public String StateByID						= "state";
	public String countryByID					= "country";
	public String airLineByID					= "member-program";
	
// radioButtons
	
	public String radioButton 					= "//span[@class='custom radio']";
	
// Back Office

	public String adminUserName					= "//input[@id='j_username']";
	public String adminUserPass					= "//input[@id='j_password']"; 
	public String adminSubmitButton				= "//button[@id='SF_submit']";
}
