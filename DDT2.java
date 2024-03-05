package basicDDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDT2 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step1: Create the object of FileInputStream class in FileInputStream() enter the path/location of the external file
		FileInputStream fis = new FileInputStream("src\\test\\resources\\DDT.xlsx");
		
		//Step2: WorkBookFactory class from apache poi & call create(InputStream)
		Workbook wb = WorkbookFactory.create(fis);
		
		//step3:Call getSheet(string name) & enter sheet name
		Sheet sh = wb.getSheet("Sheet1");
		
		//Step4:Call getRow(int num)& enter the row num
		Row rw = sh.getRow(2);
		
		//Step5: Call getCell(int cell)
		Cell cl = rw.getCell(1);
		
		//Step6:Call getStringCellValue
		String data = cl.getStringCellValue();
		
		System.out.println(data);
	}

}
