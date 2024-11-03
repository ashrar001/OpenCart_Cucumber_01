package utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class DataReader {
public static HashMap<String ,String>storeValue=new HashMap();
List<HashMap<String,String>>mydata=new ArrayList<>();
try {
	FileInputStream fs=new FileInputStream(filepath);
	XSSFWorkbook workbook=new XSSFWorkbook(fs);
	Row HeaderRow=sheet.getRow(0);
	for(int i=1;i<sheet.getPhysicalNumberOfRows();i++) {
		Row currentRow=sheet.getRow(i);
		HashMap<String,String>currentHash=new HashMap<String,String>();
		for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++) {
			Cell currentCell=currentRow.getCell(j);
			switch(currentCell.getCellType()) {
			case STRING:
				currentHash.put(HeaderRow.getCell(j).getStringCellValue(),currentCell.getStringCellValue());
				break;
			}
		}
		mydata.add(currentHash);
		
	}
	fs.close();
	
}
catch(Exception e) {
	e.printStackTrace();
}
return mydata;
}
