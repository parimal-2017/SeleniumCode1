package vtigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.ListenerImplimentation;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;
@Listeners(ListenerImplimentation.class)

public class Organizations {
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	JavaUtil jutils = new JavaUtil();
	
	@Test
	public void organizationTest() throws IOException, InterruptedException {
		
	WebDriver driver = new ChromeDriver();
	
	//maximize the window
	wutil.maximize(driver);
	
	//To apply wait for the element
	wutil.implicitWait(driver);
	
	//To read data from property file
	String URL = putil.getDataFromPropertyFile("Url");
	String USERNAME = putil.getDataFromPropertyFile("Username");
	String PASSWORD = putil.getDataFromPropertyFile("Password");
	
	//To read the data from excel sheet
	String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
	String GROUP = eutil.getDataFromExcel("Organizations", 1, 1);
	
	//To launch the applicatiom
	driver.get(URL);
	
	//log in toapplication
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//click on Organizations
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	
	//click on plus icon
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	//pass the Organization name
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutils.getRandomNumber());
	
	//In assign to click on group
	driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	
	//In the dropdown select support group
	WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
	wutil.handleddropdown(dropdown, GROUP);
	
	
	//click on save button
	driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	
	
	Thread.sleep(2000);
	//mousehover on img
	WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	wutil.mousehover(driver, image);
	
	//Click on sign out 
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
