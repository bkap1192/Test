package SamplePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadFromPropertiesFile 
{
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		//File file=new File("D://Livestable_Smoke//TestProject//src//SamplePackage//objects.properties");
		
		File file=new File("D://Livestable_Smoke//TestProject//src//SamplePackage//xpath.properties");

		FileInputStream ipstream=new FileInputStream(file);
		
//		FileOutputStream op=new FileOutputStream(file);
//		prop.setProperty("Email1", "barkha.kapoor@hotelogix.com");
		Properties prop=new Properties();
		
		prop.load(ipstream);
		
		driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		
		//to get values from property file using getProperty method
		
		/*driver.get(prop.getProperty("URL"));
		driver.findElement(By.id("Email")).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.id("next")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("Passwd")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.id("signIn")).click();*/
		
		
		
		/*Enumeration keyvalues=prop.keys();
		
		while(keyvalues.hasMoreElements())
		{
			String key=(String) keyvalues.nextElement();
			String value=prop.getProperty(key);
			
			System.out.println(key  +":"+  value);
		}
		*/
		
		
		
		Set<Object> keyValues=prop.keySet();
		for(Object obj:keyValues)
		{
			String key=obj.toString();
			String value=prop.getProperty(key);
			System.out.println(key+" "+value);
		}
			
			
			
			
			
			
		driver.get(prop.getProperty("URL"));
		driver.findElement(By.xpath(prop.getProperty("Email"))).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.xpath(prop.getProperty("Next"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("Pwd"))).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath(prop.getProperty("Submit"))).click();
		
		
		
		driver.close();
		
	}

}
