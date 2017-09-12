package SamplePackage;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class CustReport2 implements IReporter
{

	@Override
	public void generateReport(List<XmlSuite> arg0, List<ISuite> suites, String arg2)
	{
		// TODO Auto-generated method stub
		
		for(ISuite suite:suites)
		{
			String suiteName=suite.getName();
			
			Map<String, ISuiteResult> suiteResults=suite.getResults();
			
			for(ISuiteResult sr:suiteResults.values())
			{
				ITestContext tc=sr.getTestContext();
				
				System.out.println("Passed test for suite: "+ suiteName+ " is"+ tc.getPassedTests().getAllResults().size());
				
				System.out.println("Failed test for suite: "+ suiteName+ " is"+ tc.getFailedTests().getAllResults().size());
				
				System.out.println("Skipped test for suite: "+suiteName+ " is"+ tc.getSkippedTests().getAllResults().size());
			}
		}
		
	}

}
