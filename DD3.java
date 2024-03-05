package basicDDT;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import commonUtils.ExcelUtil;
import commonUtils.PropertyFileUtil;

public class DD3 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		ExcelUtil eutil = new ExcelUtil();
		PropertyFileUtil putil = new PropertyFileUtil();
		System.out.println(eutil.getDataFromExcel("Sheet1", 1, 1));
		System.out.println(putil.getDataFromPropertyFile("url"));
		System.out.println(putil.getDataFromPropertyFile("email"));
		System.out.println(putil.getDataFromPropertyFile("password"));
		

	}

}
