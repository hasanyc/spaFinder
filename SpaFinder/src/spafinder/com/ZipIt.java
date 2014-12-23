package spafinder.com;

import java.io.File;

import spafinder.com.abstractor.*;





public class ZipIt  {
	private static final String PATH = 	"C:\\Users\\hassan.abul\\workspace\\SpaFinder\\";
			
//	@Test (enabled = true)
//	public void makeZipFolder(){
			
		
	public static void main(String[] args) throws Exception  {	
	
		Zip.zipIt();
		
		 
	try {
    
	    File source = new File(PATH +"Reports.zip");
	   
	    
		File[] files = new File[2];
		files[0]= new File(PATH +"Logs.txt");
		files[1]= new File(PATH +"orders.xlsx");

		Zip.addFilesToZip(source, files);

	} catch (Exception e) {
			e.printStackTrace();
	}
    

	}
}