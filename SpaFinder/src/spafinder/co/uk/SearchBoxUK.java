package spafinder.co.uk;


import org.testng.annotations.Test;

import spafinder.com.locator.SearchBoxLocator;
import spafinder.com.value.SearchBoxValue;

public class SearchBoxUK extends spafinder.com.base.UKBaseClass {

	SearchBoxLocator sbl = new SearchBoxLocator ();
	SearchBoxValue sbv = new SearchBoxValue();
	
@Test ()
public void searchBySpaInUK (){
	driver.get(baseURL);
	System.out.println ("....Searching By SPA.......................");
	System.out.println ();
	
	typeByXpath (sbl.searchKeywordBoxLocatorXpath, sbv.searchKeywordSpa);		// SPA
	typeByXpath (sbl.searchLocationBoxLocatorXpath, sbv.searchLocation10010); 	// NY ZIP Code 10010
	clickByXpath (sbl.searchButtonClickXpath);
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
public void searchByYogaInUK (){
	driver.get(baseURL);
	System.out.println ("....Searching By Yoga.......................");
	System.out.println ();
	
	typeByXpath (sbl.searchKeywordBoxLocatorXpath, sbv.searchKeywordYoga);		// Yoga
	typeByXpath (sbl.searchLocationBoxLocatorXpath, sbv.searchLocationN2); 		// ZIP Code N2
	clickByXpath (sbl.searchButtonClickXpath);
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
public void searchByPilatesInUK (){
	driver.get(baseURL);
	System.out.println ("....Searching By Pilates.......................");
	System.out.println ();
	
	typeByXpath (sbl.searchKeywordBoxLocatorXpath, sbv.searchKeywordPilates);		// Pilates
	typeByXpath (sbl.searchLocationBoxLocatorXpath, sbv.searchLocationW112BQ); 		// Zip 
	clickByXpath (sbl.searchButtonClickXpath);
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
public void searchByFitnessInUK (){
	driver.get(baseURL);
	System.out.println ("....Searching By Fitness .......................");
	System.out.println ();
	
	typeByXpath (sbl.searchKeywordBoxLocatorXpath, sbv.searchKeywordFitness);		// Fitness
	typeByXpath (sbl.searchLocationBoxLocatorXpath, sbv.searchLocationK8N5W6); 		// Zip  K8N5W6
	clickByXpath (sbl.searchButtonClickXpath);
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
public void searchByMassageInUK (){
	driver.get(baseURL);
	System.out.println ("....Searching By Massage.......................");
	System.out.println ();
	
	typeByXpath (sbl.searchKeywordBoxLocatorXpath, sbv.searchKeywordMassage);		// Massage
	typeByXpath (sbl.searchLocationBoxLocatorXpath, sbv.searchLocation11417); 		// Zip 11417
	clickByXpath (sbl.searchButtonClickXpath);
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
