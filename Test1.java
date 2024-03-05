package basicDDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://demoapp.skillrary.com/");
		
		//Step1: Create the object of FileInputStream class in FileInputStream() enter the path/location of the external file
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Data.properties");
		
		//Step2: create object of properties class
		Properties p = new Properties();
		
		//Step3:call load(inputstream) to fetch the location of the external file 
		p.load(fis);
		
		
		//Step4:Call getProperty(String key) to fetch the keys
		String emai = p.getProperty("email");
		String pass = p.getProperty("password");
		String Url = p.getProperty("url");
		
		driver.get(Url);
		driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
		driver.findElement(By.id("email")).sendKeys(emai);
		driver.findElement(By.id("password")).sendKeys(pass);
		
	}
	

}
