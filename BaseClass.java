package commonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	
	
	WebDriver driver = new ChromeDriver();
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	@BeforeSuite
	public void BS() {
		System.out.println("Connect to database");
		
	}
	
	@BeforeClass
	public void BC() throws IOException {
		String URL = putil.getDataFromPropertyFile("Url");
		//maximize the window
		wutil.maximize(driver);
		
		//To apply wait for the element
		wutil.implicitWait(driver);
		
		//To launch the applicatiom
		driver.get(URL);
		
		
	}
	@BeforeMethod
	public void BM() throws IOException {
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		//log in to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		

		
	}
	@AfterMethod
	public void AM() throws InterruptedException {
		Thread.sleep(2000);
		//mousehover on img
		WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mousehover(driver, image);
		
		//Click on sign out 
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	
	
	@AfterClass
	public void AC() {
		driver.quit();
		
		
	}
	@AfterSuite
	public void AS() {
		System.out.println("Disconnect from database");
		
	}

}
