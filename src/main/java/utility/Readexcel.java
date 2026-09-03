package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Readexcel {
public static void main(String[]args) throws EncryptedDocumentException, IOException {
       Readexcel r=new Readexcel();
       r.getData("Sheet1");
       r.getData("Sheet2");

	
}
	public String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException {
		File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\Data.xlsx");
	    System.out.println(file+" "+excelSheetName);
	    FileInputStream fis=new FileInputStream(file);
	    Workbook wb=WorkbookFactory.create(fis);
	    Sheet sheet=wb.getSheet(excelSheetName);
	    int rows=sheet.getLastRowNum();
	    System.out.println(rows);
	    Row rowCells=sheet.getRow(0);
	    int rc=rowCells.getLastCellNum();
	    System.out.println(rc);
	
	    DataFormatter format=new DataFormatter();
		String testdata[][]  = new String[rows][rc];
	    for(int i=1;i<=rows;i++) {
	    	for(int j=0;j<rc;j++) {
	    	
			testdata[i-1][j]=format.formatCellValue(sheet.getRow(i).getCell(j));
	    	System.out.println(testdata[i-1][j]);
	    	}
	    	
	    	
	    }
	    
	    return testdata;
	    
	    
	    
	    
	}
}
