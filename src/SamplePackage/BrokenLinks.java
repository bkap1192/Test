package SamplePackage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.http.HttpClient;
import org.testng.annotations.Test;

public class BrokenLinks 
{
	

	public static int validlinks;
	
	public static int brokenlinks;
	
	public static void main(String[] args) throws IOException
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		List<WebElement> list1=driver.findElements(By.tagName("a"));
		System.out.println(list1.size());
		
		
		validlinks=0;
		brokenlinks=0;
		
		/*for(int i=0;i<list1.size();i++)
		{
			System.out.println(list1.get(i).getAttribute("href"));
			//int status=0;
			String status = verifyStatus(list1.get(i).getAttribute("href"));
			if(status.contains("200"))
			{
				System.out.println(i +status);
				++validlinks;
			}
			else
			{
				System.out.println(i +status);
				++brokenlinks;
			}
		}*/
		
		
		for(WebElement ele: list1)
		{
			if(list1!=null)
			{
				String url=ele.getAttribute("href");
				if(url!=null && !url.contains("javascript"))
				{
					verifyStatus(url);
				}
				else
				{
					brokenlinks++;
				}
			}
		}
		
		System.out.println("broken links:  "+brokenlinks);
		System.out.println("valid links:  "+validlinks);
				
	}
	
	
	
	public static void verifyStatus(String url1) throws IOException
	{
	CloseableHttpClient client=HttpClientBuilder.create().build();
	HttpGet get=new HttpGet(url1);
	HttpResponse resp=client.execute(get);
		System.out.println(resp);
	if(resp.getStatusLine().getStatusCode()==200)
	{
		validlinks++;
	}
		
		System.out.println(validlinks);
	}
}
