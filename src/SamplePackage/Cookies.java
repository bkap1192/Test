package SamplePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Set;
import com.gargoylesoftware.htmlunit.util.Cookie;

public class Cookies 
{
	public WebDriver driver;
	
	@Test
	public void addCookie()
	{
		driver=new FirefoxDriver();
		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();
		
		org.openqa.selenium.Cookie ck=new org.openqa.selenium.Cookie("testcookie", "123456");
		driver.manage().addCookie(ck);
		
		java.util.Set<org.openqa.selenium.Cookie> list=driver.manage().getCookies();
		for(org.openqa.selenium.Cookie get:list)
		{
			System.out.println(get);
		}
	}

	
}
