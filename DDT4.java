package basicDDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDT4 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\PARIMAL\\Downloads\\harsh\\Selenium\\DDT.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row rw = sh.createRow(5);
		Cell cl = rw.createCell(5);
		cl.setCellValue("Jivan");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\PARIMAL\\Downloads\\harsh\\Selenium\\DDT.xlsx");
		wb.write(fos);
		
	}
	
	

}
