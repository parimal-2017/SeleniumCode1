package commonUtils;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public class ExcelUtil1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		ExcelUtil eutil = new ExcelUtil();
		System.out.println(eutil.getDataFromExcel("Sheet1", 1, 1));
		
		

	}

}
