package spafinder.ca;

import org.testng.annotations.Test;
import spafinder.com.base.CABaseClass;
import spafinder.com.locator.SearchBoxLocator;
import spafinder.com.value.SearchBoxValue;

public class SearchBoxTestingCA  extends CABaseClass{

	SearchBoxLocator sbl = new SearchBoxLocator ();
	SearchBoxValue sbv = new SearchBoxValue();
	
@Test ()
public void searchBySpaInCA (){
	driver.get(baseURL);
	System.out.println ("...... Search By Spa in CA .................");
	System.out.println ("");
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordSpa);		// SPA
	typeByXpath (sbl.reSearchLoc, sbv.searchLocation10010); 	// NY ZIP Code 10010
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordSpa, sbl.assertKeyWord);
	assertTrue (sbv.searchLocation10010, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath); 
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordSpa); 						// Spa
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationAlberta);  					// Alberta
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordSpa, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationAlberta, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath);
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordSpa); 						// Spa
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationSpain);  					// Spain
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordSpa, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationSpain, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath);
	
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordSpa); 						// Spa
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationBrooklyn);					// Brooklyn, NY
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordSpa, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationBrooklyn, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath);
}

@Test ()
public void searchByYogaInCA (){
	driver.get(baseURL);
	System.out.println ("...... Search By Yoga in CA .................");
	System.out.println ("");
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordYoga);		// Yoga
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationN2); 		// ZIP Code N2
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordYoga, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationN2, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath); 
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordYoga); 						
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationNYC);  						// NYC
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordYoga, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationNYC, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath);
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordYoga); 						
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationFlordia);  					// Florida
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordYoga, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationFlordia, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath);
	
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordYoga); 					
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationMexico);					// Mexico
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordYoga, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationMexico, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath);
}


@Test ()
public void searchByPilatesInCA (){
	driver.get(baseURL);
	System.out.println ("...... Search By Pilates in CA .................");
	System.out.println ("");
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordPilates);		// Pilates
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationW112BQ); 		// Zip 
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordPilates, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationW112BQ, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath); 
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordPilates); 						
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationOntario);  						// Ontario
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordPilates, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationOntario, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath);
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordPilates); 						
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationSunnyside);  					// Sunnyside, NY
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordPilates, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationSunnyside, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath);
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordPilates); 					
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationUK);							// United Kingdom
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordPilates, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationUK, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath);
	
}


@Test ()
public void searchByFitnessInCA (){
	driver.get(baseURL);
	System.out.println ("...... Search By Fitness in CA .................");
	System.out.println ("");
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordFitness);		// Fitness
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationK8N5W6); 		// Zip  K8N5W6
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordFitness, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationK8N5W6, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath); 
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordFitness); 						
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationLondon);  						// London
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordFitness, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationLondon, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath);
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordFitness); 						
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationCA);  							// Canada
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordFitness, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationCA, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath);
}


@Test ()
public void searchByMassageInCA (){
	driver.get(baseURL);
	System.out.println ("...... Search By Massage in CA .................");
	System.out.println ("");
	
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordMassage);		// Massage
	typeByXpath (sbl.reSearchLoc, sbv.searchLocation11417); 		// Zip 11417
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordMassage, sbl.assertKeyWord);
	assertTrue (sbv.searchLocation11417, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath); 
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordMassage); 						
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationEngland);  						// England
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordMassage, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationEngland, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath);
	
	typeByXpath (sbl.reSearchKey, sbv.searchKeywordMassage); 						
	typeByXpath (sbl.reSearchLoc, sbv.searchLocationManchester);  					// Manchester
	clickByXpath (sbl.findButton);
	assertTrue (sbv.searchKeywordMassage, sbl.assertKeyWord);
	assertTrue (sbv.searchLocationManchester, sbl.assertLocation);
	getTextByXpath (sbl.searchResultsFoundLocatorXpath);
}

}
