package generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Lib {
	
	//------------------------------------------------------------------------------------------------------
	public static String getProperty(String path, String key){
		
		String val = "";
		
		Properties p = new Properties();
		
		try {
			p.load(new FileInputStream(path));
			val = p.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}
	
	//------------------------------------------------------------------------------------------------------
	public static String getCellValue(String path, String sheet, int r, int c){
		
		String val = null;
		
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			val = wb.getSheet(sheet).getRow(r).getCell(c).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}

	//------------------------------------------------------------------------------------------------------
}
