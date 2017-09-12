package SamplePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(CustReport1.class)
public class Test1 

{
	
	
	WebDriver driver=new FirefoxDriver();

	
	@Test()
	public void login()
	{
		driver.get("http://demo.guru99.com/V4/");
		driver.findElement(By.name("uid")).sendKeys("mngr71616");
		driver.findElement(By.name("password")).sendKeys("tunarys");
		driver.findElement(By.name("btnLogin")).click();
	}
	
	
	
	@Test()
	public void failTest()
	{
		System.out.println("method for test to fail");
		Assert.assertTrue(false);
	}
}
