package spafinder.com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Admin extends spafinder.com.base.USABaseClass {

	
	@Test
	public void testingAdmin () throws InterruptedException{
		driver.get("http://www.spafinder.com/admin");
	
		driver.findElement(By.id("j_username")).clear();
		driver.findElement(By.id("j_username")).sendKeys("qa.test");
		driver.findElement(By.id("j_password")).clear();
		driver.findElement(By.id("j_password")).sendKeys("Finderspa1");
		driver.findElement(By.id("SF_submit")).click();
		driver.get ("http://www.spafinder.com/admin/business/managespas/businessinfo.htm?id=76773");
		
		// checkbox tuesday
		driver.findElement(By.xpath("//form[@id='businessInfoCommand']/section[4]/div[2]/div[7]/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'Select Time')])[5]")).click();
		
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[8]/div/ul/li[3]")).click();
		
	
		new Select(driver.findElement(By.id("daysMapTUESDAY.startDate"))).selectByVisibleText("12:30 AM");
		
//		driver.findElement(By.xpath("(//a[contains(text(),'Select Time')])[5]")).click();
//		driver.findElement(By.xpath("//div[9]/div/ul/li[12]")).click();
//		Thread.sleep(1000);
//		
//		new Select(driver.findElement(By.id("daysMapTUESDAY.endDate"))).selectByVisibleText("06:00 PM");
//		Thread.sleep(1000);


		
		
		
	}
}
