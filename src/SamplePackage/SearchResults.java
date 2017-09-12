package SamplePackage;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.server.SeleniumServer;
import org.testng.annotations.Test;



public class SearchResults 
{
	private static SeleniumServer seleniumServer;
	private static SeleniumServer selenium;
	
	HashMap<String, String> params = new HashMap<String, String>();

	/*//path to the below constructor should be the path of the "csv" file
	CSVTestData td = new CSVTestData("C:\\Users\\qa\\Documents\\TestCSV1.csv");
	
	@Before
	public void setUp() throws Exception {
		params.putAll(td.readcsvData());
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.google.co.in/");
        seleniumServer = new SeleniumServer();
        seleniumServer.start();
		selenium.start();
	}

	@Test
	public void testAdvancedSearch() throws Exception {
		selenium.open(params.get("AppURL"));
		selenium.click("link=Advanced search");
		selenium.waitForPageToLoad("30000");
		selenium.type("as_q", params.get("SearchVals"));
		selenium.select("num", "label=20 results");
		selenium.click("//input[@value='Advanced Search']");
		selenium.waitForPageToLoad("30000");
	}
*/
	@After
	public void tearDown() throws Exception {
		selenium.stop();
		seleniumServer.stop();
	}
}
