package SamplePackage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

import java.io.File;
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.apache.pdfbox.PDFDebugger;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class PDFTextVerify 
{

	WebDriver driver;
	
	//@BeforeTest
	public void fn_setup()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void fn_verifyPDFContent() throws IOException
	{
		try
		{
		
	
		URL url1=new URL("http://www.axmag.com/download/pdfurl-guide.pdf");
		BufferedInputStream file=new BufferedInputStream(url1.openStream());
		PDFParser parser=new PDFParser(file);
		parser.parse();
		String a=parser.getPDDocument().toString();
		 	
		String text=new PDFTextStripper().getText(parser.getPDDocument());
		System.out.println(text);
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	
	/*public static void main(String[] args) throws IOException, COSVisitorException 
	{
		File file=new File("C:\\Users\\qa\\Downloads\\test1.pdf");
		PDDocument doc=new PDDocument();
		PDDocument.load(file);
		
		PDFTextStripper stripper=new PDFTextStripper();
		String text=stripper.getText(doc);
		
		System.out.println(text);
		//Assert.assertEquals(text.contains("Cashier"), true);
	}
	*/
	
	
	/*@AfterTest
	public void fn_close()
	{
		driver.close();
	}*/
	
}
