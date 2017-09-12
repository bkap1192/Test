package SamplePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataHandling 
{

	//Workbook XSSFWorkBook;
	
	public  void fn_read(String filePath,String fileName,String sheetName) throws IOException
	{
		File file= new File(filePath+"\\"+fileName);
		
		FileInputStream ipstream=new FileInputStream(file);
		
		Workbook wb=null;
		
		String[] txt=fileName.split("\\.");
		
		if(txt[1].equals("xlsx"))
		{
		  
			wb=new XSSFWorkbook(ipstream);
		}
		else 
			if(txt[1].equals("xls"))
		{
			wb=new HSSFWorkbook(ipstream);
		}
		
		Sheet sheet=wb.getSheet(sheetName);
		
		
		int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();

	    for(int i=0;i<rowcount+1;i++)
	    {
	    	Row row=sheet.getRow(i);
	    	
	    	
	    	for(int j=0;j<row.getLastCellNum();j++)
	    	{
	    		System.out.println(row.getCell(j).getStringCellValue()+"|| ");
	    	}
	    	
	    	System.out.println();
	    }
	
	
	}
	
	
	
	public static void main(String[] args) throws IOException
	{
		TestDataHandling obj=new TestDataHandling();
		
		String filePath=System.getProperty("user.dir")+"\\src\\testdata";
		
		obj.fn_read(filePath, "TestData.xlsx", "Sheet1");
	}
	

	
}
