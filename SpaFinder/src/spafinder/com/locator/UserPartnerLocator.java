package spafinder.com.locator;

public class UserPartnerLocator {

	public String iFrameXpath				= "//*[@id= 'login-signup-dialog']/iframe"; // Log in
	public String spaFinderLogoImage		= "//*[@id='trademark']/a/img";
	
// Partner Log In
	public String partnerLogInLink			= "//*[@id='account']/ul/li[2]/a";
	public String CApartnerLogInLink		= "//*[@id='account']/ul/li[3]";
	public String CAexistingPartners		= "//*[@id='account']/ul/li[3]/ul/li[1]/a";
	
	public String existingPartners			= "//*[@id='account']/ul/li[2]/ul/li[1]/a";
	public String existingPartnersAssert	= "//*[@id='main']/div[2]";
	
	
	public String newPartners				= "//*[@id='account']/ul/li[2]/ul/li[2]/a";
	public String partnerUserName			= "//*[@id='userName']";
	public String partnerPassword			= "//*[@id='password']";
	public String partnerSubmitLink			=  "submit";
	
	public String partnerLogInAssert		= ".//*[@id='splash']/div/span";
	public String partnerLogOutLink			= "//*[@id='splash']/div/a";
	
// Self Services - Join the Network
	public String newPartnerAssert				= "//*[@id='signup-wrapper']/h2";
	public String headerAssertion				= "//*[@id='signup-wrapper']/header/hgroup";
	public String spaFitnessAndWellness			= "//*[@id='signup-wrapper']/div/ul/li[1]/a";
	public String medicalSpas					= "//*[@id='signup-wrapper']/div/ul/li[2]/a";
	public String Travel						= "//*[@id='signup-wrapper']/div/ul/li[3]/a";
	
	public String flexAssert					= ".//*[@id='signup-wrapper']/div/ul/li[1]/h3";
	public String FlexSignUpLink				= ".//*[@id='signup-wrapper']/div/ul/li[1]/a";
	
	public String BusinessName					= "//*[@id='business-name']";
	public String BusinessEmail					= "//*[@id='email']";
	public String BusinessPassword				= "//*[@id='password']";
	public String BusinessRePassword			= "//*[@id='reenter-password']";
	public String clickStep2					= "//*[@id='get-started']/fieldset[2]/ul/li[4]/button";
	
	public String BusinessType					= "//*[@id='business-type']";
	public String BusinessAddress				= "//*[@id='business-address-1']";
	
	public String BusinessCountry				= ".//*[@id='country_code_chzn']/a";
	public String BusinessState					= "//*[@id='state_code_chzn']/a/div/b";
	public String BusinessStateValue			= "//*[@id='state_code_chzn_o_33']";
	
	public String BusinessCity					= "//*[@id='city_code_chzn']/a/div/b";
	public String BusinessCityValue				= "//*[@id='city_code_chzn_o_802']";
	public String BusinessZipCode				= "//*[@id='business-zip-code']";
	public String BusinessPhoneNumber			= "//*[@id='business-phone']";
	public String clickStep3					= "//*[@id='spa-business']/fieldset[2]/ul/li[8]/button";
	public String clickAgree					= "//*[@id='terms-of-service']";
	public String clickSaveProfile				= "//*[@id='billing-form']/fieldset[2]/ul[1]/li[2]/button";
	public String FlexConfirmationAssert		= "//*[@id='content']";
}
