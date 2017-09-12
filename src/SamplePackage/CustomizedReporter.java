package SamplePackage;

import java.io.PrintWriter;
import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

public class CustomizedReporter extends TestListenerAdapter implements IReporter {

	private static PrintWriter  f_out;
	
	private static final String Out_Folder="custom-test-report";
	
	
	
	@Override
	public void generateReport(List<XmlSuite> arg0, List<ISuite> Suites, String outdir) 
	{
		// TODO Auto-generated method stub
	

		
		
	}

}
