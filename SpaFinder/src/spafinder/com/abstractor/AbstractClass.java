package spafinder.com.abstractor;

import java.io.BufferedReader;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AbstractClass {
	
	
public static EventFiringWebDriver driver = null;
public static WebDriver wd = null;
public FileInputStream fis = null;
public FileOutputStream fileOut =null;
protected XSSFWorkbook workbook = null;
private XSSFSheet sheet = null;
private XSSFRow row   = null;
private XSSFCell cell = null;
protected Logger APPLICATION_LOGS = Logger.getLogger(AbstractClass.class);

// .............................................Page Title Check...........................................
			public static void getTitle(){
				System.out.println("The Page Title is: " + driver.getTitle());
				}
	
//........................... Maximize the page.......................................................
	 	
			public static void maxPage (){
				driver.manage().window().maximize();
				}

//......................................Drop Down List.....................................................................
		
			public  void dropDownByXpath (String locator, String text){
				WebElement dropDownListBox = driver.findElement(By.xpath(locator));
				Select clickThis = new Select(dropDownListBox);
				clickThis.selectByVisibleText(text);
					}

			public void dropDownById (String locator, String text){
				WebElement dropDownListBox = driver.findElement(By.id(locator));
				Select clickThis = new Select(dropDownListBox);
				clickThis.selectByVisibleText(text);
			}
			
			public void dropDownByCss (String locator, String text){
				WebElement dropDownListBox = driver.findElement(By.cssSelector(locator));
				Select clickThis = new Select(dropDownListBox);
				clickThis.selectByVisibleText(text);
			}
		
			public void drop (String locator, String value){
				WebElement select = driver.findElement(By.id(locator));
				Select dropDown = new Select(select);           
				String selected = dropDown.getFirstSelectedOption().getText();
				if(selected.equals(value)) {//do stuff already selected}
				List<WebElement> Options = dropDown.getOptions();
				for(WebElement option:Options){
				  if(option.getText().equals(value)){
				       option.click();  
				  }
				}
				}
			}
//................... Image CheckPoint.............................................................................................
			
			public void imageCheckByXpath (String locator){
				driver.findElement(By.xpath(locator)).getAttribute("src");
				}
	
//............................................................................... AssertTrue.......................................................

			public void assertion (String expected, String locator){
				WebElement xpath = driver.findElement(By.xpath(locator));
				try {
				Assert.assertEquals(expected, xpath.getText());
				System.out.println ("Text has been asserted with Act vs Exp:==>"+ driver.findElement(By.xpath(locator)).getText());
				} catch (Error t) {
				System.err.println("---->" +t.getMessage());
				}
				
			}
				
			public void AssertionByCss (String expText, String locator){
				WebElement actText = driver.findElement(By.cssSelector(locator));
				Assert.assertEquals(expText, actText.getText());
				System.out.println ("Assertion value was: "+ driver.findElement(By.cssSelector(locator)).getText());
				}
			
			public void Verify(String Exp, String Act){                  //Will confirm that expected text matches actual P/F  
				WebElement xpa = driver.findElement(By.xpath(Act));
				String act = xpa.getText();
				String exp = Exp;

				if (act.equalsIgnoreCase(exp)) {
					System.out.println(act + " Assert With " + exp);
				} else {
				try {
					Assert.assertEquals(act, exp);
					} catch (Exception t) {
					System.err.println("---->" +t.getMessage());
					System.out.println("");
					}
				}
				}
			
		public void assertTrue (String Exp, String Act){
			String actType		 = driver.findElement(By.xpath(Act)).getText();
			String expType		 = Exp;
			boolean assertTrue 	 = expType.equals(actType);
				if (!assertTrue) {
				 APPLICATION_LOGS.error("Expected: " + expType + " | Actual: " + actType + " = " + assertTrue);		
				 System.err.println ("Expected: " + expType + " | Actual: " + actType + " = " + assertTrue);
			} else  { 
					System.out.println ("Expected: " + expType + " | Actual: " + actType + " = " +assertTrue);
					System.out.println("");
				}
			}
	
		
		public void assertTrueByCss (String Exp, String Act){
			String actType		 = driver.findElement(By.cssSelector(Act)).getText();
			String expType		 = Exp;
			boolean assertTrue 	 = expType.equals(actType);
				if (!assertTrue) {
				 APPLICATION_LOGS.error("Expected: " + expType + " | Actual: " + actType + " = " + assertTrue);		
				 System.err.println ("Expected: " + expType + " | Actual: " + actType + " = " + assertTrue);
			} else  { 
					System.out.println ("Expected: " + expType + " | Actual: " + actType + " = " +assertTrue);
					System.out.println("");
				}
			}
		
		public void assertTitle (String locator){
			String act = driver.getTitle();
			String exp = locator;

			boolean assertTrue 	 = exp.equals(act);
			if (!assertTrue) {
			 APPLICATION_LOGS.error("Expected: " + exp + " | Actual: " + act + " = " + assertTrue);		
			 System.err.println ("Expected: " + exp + " | Actual: " + act + " = " + assertTrue);
			} else  { 
				System.out.println ("Expected: " + exp + " | Actual: " + act + " = " +assertTrue);
				System.out.println("");
					}
			}
			
		
			public boolean isDisplayed (String locator){
				boolean visible = driver.findElement(By.xpath(locator)).isDisplayed();
				boolean result = visible;
				System.out.println(result);
				return result;
				}
			
// .............................................................. Verify CheckBox ................................................
			
			public void verifyCheckBox (String xpath){
				boolean isChecked = driver.findElements(By.xpath(xpath)).size() != 0;
				if(!isChecked){
					System.err.println("checkBox is not Selected!!");
					System.out.println ("");
				} else {
					System.out.println ("Checkbox is Selected");
				}
			}
			
			public void verifyCheckBoxByName (String locator){
				boolean isChecked = driver.findElements(By.name(locator)).size() != 0;
				if(!isChecked){
					System.err.println("checkBox is not Selected!!");
					System.out.println ("");
				} else {
					System.out.println ("Checkbox is Selected");
				}
			}
			
//......................................................................... NAVIGATE...........................................

			public void navigateBack () {
				driver.navigate().back();
				}
				
			public void navigateForward (){
				driver.navigate().forward();
				}
				
// ..............................................................  CLEAR EVERYTHING  ............................
			
			public void clearByName (String locator) {
				driver.findElement (By.name(locator)).clear();
				}
			
			public void clearByXpath(String locator){
				driver.findElement(By.xpath(locator)).clear();
				}
			
			public void clearByCss (String locator){
				driver.findElement(By.cssSelector(locator)).clear();
				}
			
				
			public void clearById (String locator){
				driver.findElement(By.id(locator)).clear();
				}
			
//....................................................................   CLICK EVERYTHING  ..................................
				
			public void clickById (String locator){
				try{
				driver.findElement (By.id(locator)).click();
				} catch (Throwable t){
					System.err.println (t.getMessage());
					return;
					}
				}
			
			public void clickByCss (String locator){
				driver.findElement(By.cssSelector(locator)).click();
				}
			
			public void clickByLink (String locator){
				driver.findElement(By.linkText(locator)).click();
				
				}
			public void clickByXpath (String locator){
				driver.findElement(By.xpath(locator)).click();
				
				}
			
			public void doubleClick (String locator){
				Actions action = new Actions(driver);
				action.doubleClick(driver.findElement(By.xpath(locator)));
				action.perform();
				
				}
			
			public void clickByName (String locator){
				driver.findElement(By.name(locator)).click();
				}
					
		
			public void clickByTagName (String locator){
				driver.findElement(By.tagName(locator)).click();
				}
			// .............................................................  TYPE BY  ..................................
			
			public void typeById (String locator, String value){
				driver.findElement(By.id(locator)).clear();
				driver.findElement(By.id(locator)). sendKeys(value);
				}
			
			public void typeByXpath (String locator, String value){
				driver.findElement(By.xpath(locator)).clear();
				driver.findElement(By.xpath(locator)).sendKeys(value);
				}
			
			public void typeByCss (String locator, String value){
				driver.findElement(By.cssSelector(locator)).clear();
				driver.findElement (By.cssSelector(locator)).sendKeys(value);
				}
			
			public void typeByClass (String locator, String value){
				driver.findElement(By.className(locator)).clear();
				driver.findElement(By.className(locator)).sendKeys(value);
				}
			
			public void typeByName (String locator, String value){
				driver.findElement(By.name(locator)).clear();
				driver.findElement(By.name(locator)).sendKeys(value);
				}
			
// ................................ Wait Statement.............................................	
			
			public void wait(int x) throws InterruptedException{
				Thread.sleep(x); // In test class just use: waitTillLoad(3000);
			}
			
			public static void iWait(int X) {
				driver.manage().timeouts().implicitlyWait(X, TimeUnit.SECONDS);
			}
			
			public static void waitTillLoad (String locator) {  
			   	WebDriverWait wait = new WebDriverWait(driver, 10);
			   	//Wait for element to be present
			  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			  	//wait for it to disappear
			  	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
			 }  
			
			
			public void fluentWait (int timeOut, int pollingEvery){ // pollingEvery should be 5 seconds
							new FluentWait<WebDriver>(driver)
					       .withTimeout(timeOut, TimeUnit.SECONDS)
					       .pollingEvery(pollingEvery, TimeUnit.SECONDS)
					       .ignoring(NoSuchElementException.class);

				 		}
			
			public void wait (String locator){
				WebDriverWait wait = new WebDriverWait(driver, 5000);
				wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
				driver.findElement(By.xpath(locator));
				}
			
			public boolean existElement(String locator) {
			    try {
			        driver.findElement(By.xpath (locator));
			        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			        
			    } catch (NoSuchElementException e) {
			        return false;
			    }
			    return true;
				}
// ....................................... getText ..........................................
			
			public void getTextByXpath (String locator){
				WebDriverWait wait = new WebDriverWait(driver, 5000);
				wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
				driver.findElement(By.xpath(locator));
				System.out.println( driver.findElement(By.xpath(locator)).getText());
				System.out.println("");
				}
			
			public void getTextById (String locator){
				WebDriverWait wait = new WebDriverWait(driver, 5000);
				wait.until( ExpectedConditions.presenceOfElementLocated(By.id(locator)));
				driver.findElement(By.id(locator));
				System.out.println("" + driver.findElement(By.id(locator)).getText());
				System.out.println("");
				}
				
			public void getTextByClassName (String locator){
				System.out.println ("" + driver.findElement (By.className (locator)).getText());
				System.out.println("");
				}
			
//........................................................... Alert Message ......................................................
			public void alertMsg () throws InterruptedException {
				Alert alert = driver.switchTo().alert();
				System.out.println (alert.getText());
			}
			
			public void popUpModal (){
				driver.switchTo().activeElement();
			}
// ................................................................. Accept Pop Up Msg.................................................
			public void popUp(){
				try{
				Alert alert = driver.switchTo().alert();
				String msg = alert.getText();
				Thread.sleep(1000);
				System. out.println("The Pop Up Window Message is: "+ msg);
				alert.accept();
				} catch (Throwable t){
					System.err.println (t.getMessage());
					}
				
				System.out.println("");
				}

			public void checkAlert() {
			    try {
			        WebDriverWait wait = new WebDriverWait(driver, 2);
			        wait.until(ExpectedConditions.alertIsPresent());
			        Alert alert = driver.switchTo().alert();
			        alert.accept();
			    } catch (Exception t) {
			    	System.err.println (t.getMessage());
			        //exception handling
			    }
				}
			
			public void closePopUPifPresent (){
				Set<String> winIds = driver.getWindowHandles();
				System.out.println ("Total windows -> " + winIds.size());
				if (winIds.size () == 2){
					Iterator<String> iter = winIds.iterator();
					String mainWinID = iter.next();
					String popupWindID = iter.next();
					driver.switchTo().window(popupWindID);
					driver.close();
					driver.switchTo().window(mainWinID);
				}
			}
// .....................................................................Select/DeSelect.............................................			
			public void deselectAll(String locator) {
				Select selectBox = new Select(driver.findElement(By.cssSelector(locator)));
				selectBox.deselectAll();
				}
						
			public void deselectByIndex(String locator) {
				Select selectBox = new Select(driver.findElement(By.cssSelector(locator)));
				selectBox.deselectByIndex(2);
				}
					
			public void deselectByValue(String locator) {
				Select selectBox = new Select(driver.findElement(By.cssSelector(locator)));
				selectBox.deselectByValue("2");
				}

			public void deselectByVisibleText(String locator) {
				Select selectBox = new Select(driver.findElement(By.cssSelector(locator)));
				selectBox.deselectByVisibleText("Customer service");
				}
						
			public void getAllSelectedOptions(String locator) {
				Select selectBox = new Select(driver.findElement(By.cssSelector(locator)));
				List<WebElement> selectOptions = selectBox.getAllSelectedOptions();
				for (WebElement temp : selectOptions) {
					System.out.println("getText" + temp.getText());}
				} 
					
//.....................................................Drag / Slide ......................................................
						
			public void draggable(String locator) {
				WebElement draggable = driver.findElement(By.id(locator));
				new Actions(driver).dragAndDropBy(draggable, 120, 120).build().perform();
				}
						
			public void droppable() {
				WebElement draggable = driver.findElement(By.id("draggable"));
				WebElement droppable = driver.findElement(By.id("droppable"));
				new Actions(driver).dragAndDrop(draggable, droppable).build().perform();
				}
						
					
			public void selectMultiple(String locator) throws InterruptedException {
				List<WebElement> listItems = driver.findElements(By.cssSelector(locator));
				Actions builder = new Actions(driver);
				builder.clickAndHold(listItems.get(1)).clickAndHold(listItems.get(2)).click();
				Action selectMultiple = builder.build();
				selectMultiple.perform();
				}
						
			public void sliding(String locator) {
				WebElement draggable = driver.findElement(By.className(locator));
				new Actions(driver).dragAndDropBy(draggable, 120, 0).build().perform();
				} 

// ...................................... Delete Cookies ...........................
			
			public void dCookie (){
				driver.manage().deleteCookie(null);
				}
			
			public void dCookieByName (String locator){
				driver.manage().deleteCookieNamed("locator");
				}
			public void dAllCookies (){
				driver.manage().deleteAllCookies();
				}
			
//........................................................... Frame and window Handles ................................		
	
			public void iFrameByTagName (String locator){
				driver.switchTo().frame(driver.findElement(By.tagName(locator)));
				}
		
			public void iFrameByCSS (String locator){
				driver.switchTo().frame(driver.findElement(By.cssSelector(locator)));
				}
		
			public void iFrameByXpath (String locator){
				driver.switchTo().frame(driver.findElement(By.xpath(locator)));
				}
			public void iFrameByClassName (String locator){
				driver.switchTo().frame(driver.findElement(By.className(locator)));
				}
		
			public void switchBack(){
				driver.switchTo().defaultContent();
				}
		
			public void lightBox (){
				Set<String> handles= driver.getWindowHandles();
				driver.switchTo().window(handles.iterator().next());
				}
			
			public void window() throws InterruptedException{
				Set<String> handles = driver.getWindowHandles();
				String current = driver.getWindowHandle();
				handles.remove(current);
				String newTab = handles.iterator().next();
				driver.switchTo().window(newTab);
				Thread.sleep(4000);
				//driver.close(); 
				}
			
			public void closeNewTab (){
				String originalHandle = driver.getWindowHandle();
			    for(String handle : driver.getWindowHandles()) {
			        if (!handle.equals(originalHandle)) {
			            driver.switchTo().window(handle);
			            driver.close();
			        }
			    }

			    driver.switchTo().window(originalHandle);
			}
			
			public void parentWindow (){
				String hasan = driver.getWindowHandles().iterator().next();
			    driver.switchTo().window(hasan);
				}
	
			public void newWindow (){
				//driver.findElement(By.xpath(locator)).click(); // xpath of the entire new window
				for (String winHandle : driver.getWindowHandles()) {
				    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
				}
			}
// ......................................................................... GET CURRENT URL...............................	
			public void getURL (){
				System.out.println (driver.getCurrentUrl());
				}
				
// .................................................... Mouse Hover.........................................................
			public void subMenu (String locator){
				WebElement box = driver.findElement(By.xpath(locator));
				List<WebElement> links = box.findElements(By.tagName("a"));
				System.out.println("Total links ->"+ links.size());
				System.out.println("------------------------");
			  
				for(int i= 0; i<links.size();i++){
					System.out.println(links.get(i).getText());
					links.get(i).click();
					System.out.println (driver.getCurrentUrl());
					// System.out.println (driver.getPageSource());
					System.out.println(driver.getTitle());
					driver.navigate().back();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // wait till load.
			   
				Locatable hoverItem = (Locatable) driver.findElement(By.xpath(locator));
				Mouse mouse = ((HasInputDevices) driver).getMouse();
				mouse.mouseMove(hoverItem.getCoordinates());
				System.out.println("------------------------");
			   //Build cache you have to repeat the steps
				box = driver.findElement(By.xpath(locator));
				links = box.findElements(By.tagName("a")); // object reference
					}
				}
		
		
			public void mouseHover (String parent, String child) {
				Locatable mainNav = (Locatable) driver.findElement(By.xpath(parent));
				Mouse mouse = ((HasInputDevices) driver).getMouse();
				driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
				mouse.mouseMove(mainNav.getCoordinates());
				WebElement subNav = driver.findElement(By.xpath(child));
				subNav.click();
				}
		
				
			public void mouseMove2 (String MainNav, String subNav) throws InterruptedException {
				WebElement Menu=driver.findElement(By.xpath(MainNav));//Menu
				WebElement MenuB=driver.findElement(By.xpath(subNav));//Menu item
				Actions builder = new Actions(driver); 
				Actions hoverOverRegistrar = builder.moveToElement(Menu);
				hoverOverRegistrar.perform();
				MenuB.click();//at last Menu Item Click
				}
		
			public void mouseMove (String locator) {
				Locatable hoverItem = (Locatable) driver.findElement(By.xpath(locator));
				Mouse mouse = ((HasInputDevices) driver).getMouse();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
				mouse.mouseMove(hoverItem.getCoordinates());
				}
		
			public void mouseOver (String locator){
				Actions actions = new Actions (driver);
				WebElement xyz = driver.findElement(By.xpath (locator));
				actions.moveToElement(xyz).perform();
				}
					
//........................................................... Get Local Machine's IP, Day, Date and Times  ................................		
			
			public void getIP () {
				try {
					InetAddress thisIp =InetAddress.getLocalHost();
					System.out.println("The Local Machine IP is :"+thisIp.getHostAddress());
					System.out.println ("");
					}
				catch(Exception e) {
					e.printStackTrace();
					}
				}
	
			public void getTime (){
				DateFormat dateFormat = new SimpleDateFormat("EEEE - MM/dd/YYYY & hh:mm:ss a");
				Calendar cal = Calendar.getInstance();
				System.out.println("The current date and Time is: " + dateFormat.format(cal.getTime()));
				System.out.println ("");
				}
		
// ..................................... Refresh the page ......................
			public void refresh (){
				driver.navigate().refresh();
				}
		
// .............................................. Keyboard ...................
		
			public void enter (String locator){
				driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
				}
			
			public void backSpace (String locator) {
				driver.findElement(By.xpath(locator)).sendKeys(Keys.BACK_SPACE);
				}
			
			public void delete (String locator){
			     driver.findElement(By.xpath(locator)).sendKeys(Keys.DELETE);
				}
			
			public void scroll (){
				JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("javascript:window.scrollBy(0,3000)");
				}
//..................................SCREENSHOT API METHOD..................................
			
			public void takeScreenshot (String ScreenshotName){
				if (driver instanceof TakesScreenshot){
					File tempFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(tempFile, new File("Screenshots/" + ScreenshotName + ".png"));
					} 
				
				catch(IOException e){
						}
					}  			
				}
						
			public static void screenShot (String screenshotName) throws IOException {
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenShots\\"+screenshotName+".png"));
	            System.out.println("Screenshot has been taken. Please go to: workspace-SpaFinder-screenShots Folder to view it. Thanks");
					
						
					}
//........................................ Read/Write into Excel (POI) ...................................		
				
// Taking existing files and writing into it from web
							
			public boolean setCellData(String sheetName,String colName,int rowNum, String locator){
				try{
				fis = new FileInputStream(System.getProperty("user.dir") + "\\orders.xlsx"); 
				workbook = new XSSFWorkbook(fis);
	
				if(rowNum<=0)
					return false;
				
				int index = workbook.getSheetIndex(sheetName);
				int colNum=-1;
				if(index==-1)
					return false;
						
				sheet = workbook.getSheetAt(index);
				row=sheet.getRow(0);
				for(int i=0;i<row.getLastCellNum();i++){
					//System.out.println(row.getCell(i).getStringCellValue().trim());
					if(row.getCell(i).getStringCellValue().trim().equals(colName))
						colNum=i;
				}
				if(colNum==-1)
					return false;
	
				sheet.autoSizeColumn(colNum); 
				row = sheet.getRow(rowNum-1);
				if (row == null)
					row = sheet.createRow(rowNum-1);
				
				cell = row.getCell(colNum);	
				if (cell == null)
			        cell = row.createCell(colNum);
			    cell.setCellValue(driver.findElement(By.xpath(locator)).getText());
				//cell.setCellValue(locator);
			    fileOut = new FileOutputStream(System.getProperty("user.dir")+"\\orders.xlsx");
			    workbook.write(fileOut);
			    fileOut.close();	
				}
				catch(Exception e){
					e.printStackTrace();
					return false;
				}
				return true;
				}
			
			
			public String getCellData(String sheetName,String colName,int rowNum){
				try{
					if(rowNum <=0)
						return "";
				int index = workbook.getSheetIndex(sheetName);
				int col_Num=-1;
				if(index==-1)
					return "";
				sheet = workbook.getSheetAt(index);
				row=sheet.getRow(0);
				for(int i=0;i<row.getLastCellNum();i++){
					//System.out.println(row.getCell(i).getStringCellValue().trim());
					if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
						col_Num=i;
				}
				if(col_Num==-1)
					return "";
				sheet = workbook.getSheetAt(index);
				row = sheet.getRow(rowNum-1);
				if(row==null)
					return "";
				cell = row.getCell(col_Num);
				
				if(cell==null)
					return "";
				//System.out.println(cell.getCellType());
				if(cell.getCellType()==Cell.CELL_TYPE_STRING)
					  return cell.getStringCellValue();
				else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
					  
				String cellText  = String.valueOf(cell.getNumericCellValue());
				 if (HSSFDateUtil.isCellDateFormatted(cell)) {
				    // format in form of M/D/YY
					double d = cell.getNumericCellValue();
					Calendar cal =Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
				    cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
				    cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
				    cal.get(Calendar.MONTH)+1 + "/" + 
				    cellText;
				    //System.out.println(cellText);
				 	}
				  return cellText;
				  } else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
				      return ""; 
				  else 
					  return String.valueOf(cell.getBooleanCellValue());
				
					}
					catch(Exception e){
					e.printStackTrace();
					return "row "+rowNum+" or column "+colName +" does not exist in xls";
					}
					}
			
			
			public boolean passData(String sheetName,String colName,int rowNum, String value){
				try{
				fis = new FileInputStream(System.getProperty("user.dir")+"\\orders.xlsx"); 
				workbook = new XSSFWorkbook(fis);
	
				if(rowNum<=0)
					return false;
				
				int index = workbook.getSheetIndex(sheetName);
				int colNum=-1;
				if(index==-1)
					return false;
				sheet = workbook.getSheetAt(index);
				row=sheet.getRow(0);
				for(int i=0;i<row.getLastCellNum();i++){
					//System.out.println(row.getCell(i).getStringCellValue().trim());
					if(row.getCell(i).getStringCellValue().trim().equals(colName))
						colNum=i;
				}
				if(colNum==-1)
					return false;
	
				sheet.autoSizeColumn(colNum); 
				row = sheet.getRow(rowNum-1);
				if (row == null)
					row = sheet.createRow(rowNum-1);
				
				cell = row.getCell(colNum);	
				if (cell == null)
			        cell = row.createCell(colNum);
			    cell.setCellValue(value);
			    fileOut = new FileOutputStream(System.getProperty("user.dir")+"\\orders.xlsx");
			    workbook.write(fileOut);
			    fileOut.close();	
				}
				catch(Exception e){
					e.printStackTrace();
					return false;
				}
				return true;
				}
		
// .......................................................... replace .......................................
			
			public void replace (String locator, String inputValue){
				String oldValue = driver.findElement(By.xpath(locator)).getText();
				String newValue = oldValue.replace(inputValue, "");
				System.out.println (newValue);
				}
			
//............................................ ByPass URL.............................
			public void byPass (){
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("convctrs.overture.com:443", 255);
		        profile.setAssumeUntrustedCertificateIssuer(false);
		        //  driver = new FirefoxDriver(profile);
		        //   driver.get("convctrs.overture.com:443");      
				}

//................................................ All Dates .........................................
		
			public void RandomDate (String locator){
				int year = AbstractClass.randBetween(2014, 2015);
				int month = AbstractClass.randBetween(01, 12);
				GregorianCalendar gc = new GregorianCalendar(year, month, 01);
				int day = AbstractClass.randBetween(01, gc.getActualMaximum(Calendar.DAY_OF_MONTH));
				gc.set(year, month, day);
				String s =(gc.get(Calendar.MONTH) + "/" + gc.get(Calendar.DAY_OF_MONTH) + "/" + gc.get(Calendar.YEAR));
				driver.findElement(By.xpath(locator)).sendKeys(s);
				}

			public void radomEmail (String locator){
				
				DateFormat dateFormat = new SimpleDateFormat("M.d.YY.hh.mm.ss"); // ("EEEE - MM/dd/YYYY & hh:mm:ss a");
				Calendar cal = Calendar.getInstance();
				String currentDate = dateFormat.format(cal.getTime());
				String email1 = "Automation";
				String email2 = "@hasan.com";
				String randomEmail = email1+currentDate+email2;
				System.out.println ("The random email address is: " + randomEmail);
				driver.findElement(By.xpath(locator)).sendKeys(randomEmail);
			}

			public static int randBetween(int start, int end) {
				return start + (int)Math.round(Math.random() * (end - start));
				}
	    	   
			public void todayDate (String locator){
	    	  String s;
	    	  Date date;
	    	  SimpleDateFormat formatter;
	    	  Calendar calendar = Calendar.getInstance();
	    	
	    	  date = calendar.getTime();
	    	  formatter = new SimpleDateFormat("MM/dd/YYYY");
	    	  s = formatter.format(date);
	    	
	    	  //DateFormat dateFormat = new SimpleDateFormat("EEEE - MM/dd/YYYY");
	    	  //Calendar cal = Calendar.getInstance();
	    	  //String h =dateFormat.format(cal.getTime());
	    	  driver.findElement(By.xpath(locator)).sendKeys(s);
				}
	       
			public void Tdate (String locator){
				String T;
				Date date;
				SimpleDateFormat formatter;
				Calendar calendar = Calendar.getInstance();
	  	 
				calendar.add(Calendar.DATE, 2);
				date = calendar.getTime();
				formatter = new SimpleDateFormat("MM/dd/YYYY");
				T = formatter.format(date);
				driver.findElement(By.xpath(locator)).sendKeys(T); 
	  	 
				/** 
			  	for (int count = 7; count>0; count++)
			  	  {
			  	  	cal = Calendar.getInstance();
			  		cal.add (Calendar.DATE, +count);
			  		formatter = new SimpleDateFormat("MM/dd/YYYY");
			  		String T = formatter.format((cal.getTime()));
			  		driver.findElement(By.xpath(locator)).sendKeys(T); 
			  	*/
				}
	  
//............................................... upload file from computer.........................
	    
			public void uploadFile (String locator) throws IOException {
				driver.findElement(By.xpath(locator)).click();
			    BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\hassan.abul\\Pictures\\TestingAutomation.pdf")); 
			    in.readLine(); 
			    in.close();
			    }
	    
	   
// ....................................... click / verify all links..........................................
			public void clickAllLinks (String locator) throws InterruptedException{
		   		WebElement link = driver.findElement(By.xpath(locator));
		   		//driver.findElement(By.xpath("//*[@id='news']")); you can do this line instead of above line
				List<WebElement> links = link.findElements(By.tagName("a"));
				System.out.println("Total links ->"+ links.size());
				System.out.println("------------------------");
				  
				for(int i= 0; i<links.size();i++){
					System.out.println(links.get(i).getText());
					links.get(i).click();
					System.out.println (driver.getCurrentUrl());
					System.out.println(driver.getTitle());
					driver.navigate().back();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					System.out.println("------------------------");
					//Build cache you have to repeat the steps
					link = driver.findElement(By.xpath(locator));
					links = link.findElements(By.tagName("a"));
				  		}
				}
	     
			public void verifyAllLinks () {
				List<WebElement> links = driver.findElements(By.tagName("a"));
				System.out.println("Total links -> " + links.size());
				System.out.println("------------------------");
			  
				for(int i= 0; i<links.size();i++){
					System.out.println(links.get(i).getText());
					System.out.println(links.get(i).getText()+ "=="+ links.get(i).isDisplayed());
					System.out.println("");
					System.out.println("Total links -> " + links.size());
					System.out.println("");
					}
				}
	   
// ....................................... get All InputBox ..........................................

			public void inputBox (String locator)  {
				List<WebElement> inputBox = driver.findElements(By.xpath(locator));
				System.out.println("Total edit boxes are: -> "+ inputBox.size());
				System.out.println("------------------------");
				}
	   
// ....................................... getAttribute ...............................................................
			public void getAttributeByXpath (String locator, String value){
				System.out.println("Input Value is: " + driver.findElement(By.xpath(locator)).getAttribute(value));
					}
				
// .......................................... RadioButton ........................................................
			public void radioButtonByXpath (String locator){
			
			List <WebElement> radioButtons = driver.findElements (By.xpath(locator));
							  radioButtons.get(1).click();
		}
			
			
	public void spawishCard (){
		 PreparedStatement stmt =null;
		 Connection conn =null;
		try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.71.16/SW", "SFUser", "xyzzzz");
             stmt = conn.prepareStatement("update t_certificate "
							  + "set redeemdate = null ,sfw_spa_id = null ,[status] = 30 ,userid= null ,officeId = null "
							  + ",AmountPaid = null where certcode in  ( select t.certcode from t_certificate t left join spafinder.dbo.spas s on t.sfw_spa_id = s.spaid "
							  + "where certcode in ('SWB4004496712109390707USD')and redeemdate is not null )");
          int status = stmt.executeUpdate();
           
          if (status == 1){
        	  System.out.println ("Record successfully updated");
          }
    	  else {
    		  System.err.println ("Didn't updated!!");
         }
          
        } catch (Exception e) {
                System.out.println(e.toString());
        }  finally {
      	
    	  } try {
    		  if(stmt != null)
    		  stmt.close();
    	  } catch (SQLException e){
    	  } try {
    		  if(conn != null)
    			  conn.close();
    	  } catch (SQLException e){
    		  
    	  }
      }

	
	


}
