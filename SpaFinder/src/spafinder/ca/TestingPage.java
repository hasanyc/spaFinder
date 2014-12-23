package spafinder.ca;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestingPage extends spafinder.com.base.CABaseClass{


	
@Test ()
public void ValidInfo (){
	driver.get("https://www.spafinder.com/account/clubspa/index.jsp");
	driver.findElement(By.xpath(".//*[@id='email']")).sendKeys ("jayRahim@gmail.com");
	driver.findElement(By.xpath(".//*[@id='password']")).sendKeys ("badon123");
	driver.findElement (By.xpath(".//*[@id='log-in-form']/ul/li[3]/button")).click();
	
	Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='content']/div[4]/ul/li[1]/div/ul/li[1]")).getText(), "Joyar Rahim");
	driver.findElement(By.linkText ("Log Out")).click();
}


@Test ()
public void invalidInfo (){
	driver.get("https://www.spafinder.com/account/clubspa/index.jsp");
	driver.findElement(By.xpath(".//*[@id='email']")).sendKeys ("jayRahim@gmail.com");
	driver.findElement(By.xpath(".//*[@id='password']")).sendKeys ("badon12356"); // wrong password
	driver.findElement (By.xpath(".//*[@id='log-in-form']/ul/li[3]/button")).click();
	
	Assert.assertTrue(driver.findElement (By.tagName("body")).getText().contains("The username and password entered were not found. Please try again."));
	

}

@Test ()
public void forgetPass (){
	driver.get("https://www.spafinder.com/account/clubspa/index.jsp");
	driver.findElement(By.xpath(".//*[@id='email']")).sendKeys ("jayRahim@gmail.com");
	driver.findElement(By.xpath(".//*[@id='password']")).sendKeys ("badon12356"); // wrong password
	driver.findElement (By.xpath(".//*[@id='log-in-form']/ul/li[3]/button")).click();
	
	Assert.assertTrue(driver.findElement (By.tagName("body")).getText().contains("The username and password entered were not found. Please try again."));
	Assert.assertTrue(driver.findElement (By.linkText ("Forgot Password?")).isDisplayed());
	driver.findElement (By.linkText("Forgot Password?")).click();
	
	driver.findElement (By.xpath(".//*[@id='forgottenPasswordCommand']/ul/li/input")).sendKeys("jayRahim@gmail.com");
	

}



}



//*[@id='statusMessage']/div
// The username and password entered were not found. Please try again. 

//*[@id='content']/div[4]/ul/li[1]/div/ul/li[1]
//*[@id='password']