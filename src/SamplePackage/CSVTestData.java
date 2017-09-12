package SamplePackage;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import au.com.bytecode.opencsv.CSVReader;

public class CSVTestData 
{
	
private static String FILE_PATH;
	
	HashMap<String, String> parametervals = new HashMap<String, String>();
	
	public void CsvTestData(String filepath){
		FILE_PATH=filepath;
	}
	
	public String getFilePath(){
		return FILE_PATH;
	}
	
	public HashMap<String, String> readcsvData()throws IOException {
		CSVReader reader = new CSVReader(new FileReader(FILE_PATH));
		String [] nextLine;
		int i=0;
		while ((nextLine = reader.readNext()) != null) {
			parametervals.put(nextLine[i], nextLine[i+1]);
			i++;
		}
		return parametervals;
	}

}
