package SamplePackage;

import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class JSClick 
{

	public static WebDriver driver;
	

	public static void main(String[] args)
	{
		driver=new FirefoxDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Hello");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("argument[0].click();", driver.findElement(By.name("btnK")));
		
		
		//..for alert
		js.executeScript("alert('Hi World');");
		
		
	}
}
